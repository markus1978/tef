package fri.patterns.interpreter.parsergenerator.parsertables;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.*;

/**
	Nullability of a nonterminal means that it can be "nothing", i.e.
	there is a rule that contains the nonterminal on the left side and
	no symbol on the right side (empty right side), expressing an optional
	rule.
	<p>
	<b>Algorithm:</b><br>
	Sort rules by size.
	Search every rule that contain the nonterminal on left side.
	Scan the left side of every rule until a terminal or a non-nullable
	nonterminal appears. If found, rule is not nullable, else it is nullable.
	If one of the rules that derive nonterminal is nullable, this nonterminal
	is nullable.

	@author (c) 2000, Fritz Ritzberger
*/

class Nullable extends Hashtable
{
	/** The special empty symbol. */
	public static final String NULL = "";
	
	/**
		Explores the nullability of all nonterminals in syntax. Provides nullability
		as Boolean within this Map, key is nonterminal.
		@param syntax the grammar to scan for nonterminals and their nullability.
		@param nonterminals pre-built list of nonterminals.
	*/
	public Nullable(Syntax syntax, List nonterminals)
		throws ParserBuildException
	{
		// loop nonterminals
		Map done = new Hashtable(nonterminals.size());	// avoid endless loops
		for (int i = 0; i < nonterminals.size(); i++)	{
			String nt = (String) nonterminals.get(i);
			checkNullability(syntax, nt, done);
		}
	}


	/** Returns true if passed nonterminal is nullable, else false. */
	public boolean isNullable(String nonterminal)	{
		Boolean nullable = (Boolean) get(nonterminal);
		return nullable.booleanValue();
	}


	private boolean checkNullability(Syntax syntax, String nonterm, Map done)
		throws ParserBuildException
	{
		Boolean n = (Boolean) get(nonterm);
		if (n != null)
			return n.booleanValue();

		if (done.get(nonterm) != null)
			return false;	// endless recursion

		done.put(nonterm, nonterm);	// avoid endless loops

		// loop rules for an empty rule deriving this nonterminal
		for (int j = 0; j < syntax.size(); j++)	{
			Rule rule = syntax.getRule(j);
			String nt = rule.getNonterminal();	// left side of derivation

			if (nt.equals(nonterm) && rule.rightSize() <= 0)	// this rule derives the nonterminal and is empty
				return putSymbol(nonterm, true);
		}

		// loop rules for nullable nonterminal sequences
		for (int j = 0; j < syntax.size(); j++)	{
			Rule rule = syntax.getRule(j);
			String nt = rule.getNonterminal();	// left side of derivation

			if (nt.equals(nonterm))	{	// this rule derives the nonterminal
				boolean nullable = true;	// assume it is nullable

				// then all symbols on right side must be nullable
				for (int i = 0; nullable && i < rule.rightSize(); i++)	{
					String symbol = rule.getRightSymbol(i);

					if (Token.isTerminal(symbol))	{	// a terminal ends symbol-loop
						nullable = false;
					}
					else
					if (symbol.equals(nonterm) == false)	{	// do not search self
						try	{
							nullable = checkNullability(syntax, symbol, done);	// is nullable when this symbol is nullable
						}
						catch (Exception ex)	{
							throw new ParserBuildException("Nullable ERROR: "+ex.getMessage()+" <- "+nonterm);
						}
					}
				}

				if (nullable)	// one nullable rule is enough for nonterminal to be nullable
					return putSymbol(nonterm, true);
			}
		}
		return putSymbol(nonterm, false);
	}

	private boolean putSymbol(String symbol, boolean value)	{
		put(symbol, new Boolean(value));
		return value;
	}


	/**
		Detect an empty terminal in input grammar: length == 0,  '', "", ``.
		@return true when symbol is empty.
	*/
	public static boolean isNull(String symbol)	{
		return symbol.length() <= 0 ||
				symbol.equals(""+Token.STRING_QUOTE+Token.STRING_QUOTE) ||
				symbol.equals(""+Token.COMMAND_QUOTE+Token.COMMAND_QUOTE) ||
				symbol.equals(""+Token.CHAR_QUOTE+Token.CHAR_QUOTE);
	}




	// test main

	public static void main(String [] args)	{
		List nt = new ArrayList();
		nt.add("S"); nt.add("T"); nt.add("F"); nt.add("L");

		List sx = new ArrayList();

		List r = new ArrayList();
		r.add("S"); r.add("T"); r.add("L"); r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("S"); r.add("T"); r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("T");
		sx.add(r);

		r = new ArrayList();
		r.add("F");
		//r.add("S");
		sx.add(r);

		try	{
			Nullable n = new Nullable(new Syntax(sx), nt);
			String s = "S";
			System.err.println("nullable "+s+": "+n.isNullable(s));
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}