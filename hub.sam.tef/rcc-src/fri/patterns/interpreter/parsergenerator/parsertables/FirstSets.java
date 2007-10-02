package fri.patterns.interpreter.parsergenerator.parsertables;

import java.util.*;
import fri.util.collections.UniqueAggregatingHashtable;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.*;

/**
	Map of all FOLLOW-sets of a SLR syntax. Key is nonterminal.
	<p>
	The FIRST-set for a nonterminal is the collection of terminals that
	appear on first position of the right side of all rules where that
	nonterminal appears on the left side.
	<p>
	<b>Algorithm:</b><br>
	Search all rules that contain the nonterminal on left side.
	Scan the right side of all these rules until a terminal or a non-nullable
	nonterminal appears. The terminal goes to FIRST, the FIRST sets of
	all scanned nonterminals go to FIRST. This implies that one must
	collect FIRST sets recursively, for every scanned nonterminal.

	@author (c) 2000, Fritz Ritzberger
*/

class FirstSets extends UniqueAggregatingHashtable
{
	/**
		Calculate Map of FIRST sets of all nonterminals contained in syntax.
		The FIRST sets will then be lists within this Map that provides the
		nonterminal as key.
		@param syntax the grammar to scan.
		@param nullAble Map containing Boolean true or false for nullability of every nonterminal.
		@param nonterminals pre-built list of nonterminals
	*/
	public FirstSets(Syntax syntax, Nullable nullAble, List nonterminals)
		throws ParserBuildException
	{
		// collect FIRST sets into this Hashtable where each
		// nonterminal has a List of FIRST-symbols
		Map done = new Hashtable(nonterminals.size());	// avoid recursion
		for (int i = 0; i < nonterminals.size(); i++)	{
			String nonterm = (String) nonterminals.get(i);
			generateFirstSet(syntax, nullAble, nonterm, done);
		}
	}

	private void generateFirstSet(Syntax syntax, Nullable nullAble, String nonterminal, Map done)
		throws ParserBuildException
	{
		if (get(nonterminal) != null)
			return;	// alreay done
		
		if (done.get(nonterminal) != null)
			return;
		done.put(nonterminal, nonterminal);	// avoid endless loops
		//System.err.println("generateFirstSet("+nonterminal+")");

		// The FIRST set of a nonterminal are all symbols
		// that are on first position of the right side of all rules
		// where the nonterminal is on the left side.
		for (int k = 0; k < syntax.size(); k++)	{
			Rule rule = syntax.getRule(k);
			String nonterm = rule.getNonterminal();	// left side of derivation

			if (nonterminal.equals(nonterm))	{	// this rule derives the nonterminal
				// if left side is empty, add NULL to FIRST of nonterminal
				if (rule.rightSize() <= 0)	{
					put(nonterm, Nullable.NULL);
				}
				else	{	// there are symbols on left side
					boolean nullable = true;	// enable loop until nullable
	
					// While nullable, add the symbol, shift to the next and
					// check if it is nullable again.
					for (int i = 0; nullable && i < rule.rightSize(); i++)	{
						String symbol = rule.getRightSymbol(i);
						
						nullable = false;	// assume it is a terminal

						if (Token.isTerminal(symbol))	{
							put(nonterm, symbol);
						}
						else	{
							// If there is a nonterminal on first position, add its FIRST set
							// FIRST set of this nonterminal, but without null-word.
							try	{
								generateFirstSet(syntax, nullAble, symbol, done);	// enter recursion

								List list = (List) get(symbol);	// get the results
								for (int j = 0; list != null && j < list.size(); j++)	{
									String s = (String) list.get(j);
									put(nonterm, s);
								}

								nullable = nullAble.isNullable(symbol);
							}
							catch (Exception ex)	{
								throw new ParserBuildException(ex.getMessage()+" <- "+nonterm);
							}
						}	// end if terminal
					}	// end for all symbols of rule
							
					// If the last added symbol is the last of the rule and
					// is a nonterminal and is nullable, add null to FIRST set.
					//if (nullable)	{
					//	Sets.addToSets(this, nonterm, Nullable.NULL);
					//}
	
				}	// end if rule size > 1
			}	// end for al rules of syntax
		}
	}

	/** Overridden to check for equality of key and value: Exception is thrown when so. */
	public Object put(Object key, Object value)	{
		if (key.equals(value))
			throw new IllegalArgumentException("Can not be FIRST of its own: key="+key+", value="+value);
			
		return super.put(key, value);
	}



	/** Test main */
	public static void main(String [] args)	{
		// nonterminals
		List nonterm = new ArrayList();
		nonterm.add("S"); nonterm.add("T"); nonterm.add("F"); nonterm.add("L");

		// rules
		List sx = new ArrayList();

		List r = new ArrayList();
		r.add("S"); r.add("T"); r.add("'*'"); r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("S"); r.add("T");
		sx.add(r);

		r = new ArrayList();
		r.add("T"); r.add("F");
		sx.add(r);

		/* test empty derivation */
		r = new ArrayList();
		r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("F");
		r.add("'1'");
		sx.add(r);

		Syntax syntax = new Syntax(sx);
		try	{
			FirstSets f = new FirstSets(syntax, new Nullable(syntax, nonterm), nonterm);
			String s = "S";
			System.err.println("FIRST("+s+") = "+f.get(s));
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}