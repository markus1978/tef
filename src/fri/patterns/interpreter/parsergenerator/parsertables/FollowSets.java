package fri.patterns.interpreter.parsergenerator.parsertables;

import java.util.*;
import fri.util.collections.UniqueAggregatingHashtable;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.*;

/**
	Map of all FOLLOW-sets of a SLR syntax. Key is nonterminal.
	<p>
	The FOLLOW-set for a nonterminal is the collection of terminals that
	can appear behind that nonterminal on the right side of all rules.
	<p>
	<b>Algorithm:</b><br>
	Search all rules that contain the nonterminal on right side.
	Scan for a terminal after the nonterminal on right side until found
	or one scanned nonterminal is not nullable. The FIRST set of every
	scanned nonterminal goes to the FOLLOW set. When reaching the end
	without having found a terminal or a non-nullable nonterminal, even
	the FOLLOW set of the nonterminal on the left side of that rule goes
	to FOLLOW.

	@author (c) 2000, Fritz Ritzberger
*/

class FollowSets extends UniqueAggregatingHashtable
{
	/**
		Calculate FOLLOW-sets for all nonterminals contained in passed syntax.
		The FOLLOW sets will then be Lists within a Map that provides the nonterminal
		as key.
		@param syntax the grammar
		@param nullAble Map containing Boolean true when nonterminal (key) is nullable, else false.
		@param firstSets ready-made FIRST sets for all nonterminals.
	*/
	public FollowSets(Syntax syntax, Nullable nullAble, FirstSets firstSets)
		throws ParserBuildException
	{
		// collect FOLLOW sets into a Hashtable where each nonterminal has a list of FOLLOW symbols
		generateFollow(syntax, nullAble, firstSets);

		// make a plain list from references to other FOLLOW sets
		resolveSets();
	}

	private void generateFollow(Syntax syntax, Nullable nullAble, FirstSets firstSets)	{
		// The FOLLOW set of a nonterminal are all symbols that appear after the
		// nonterminal on the right side of all rules. If the nonterminal stands
		// at last position, add the FOLLOW set of the left side of this rule.
		
		// loop across all syntax rules
		for (int rulePos = 0; rulePos < syntax.size(); rulePos++)	{
			Rule rule = syntax.getRule(rulePos);
			String nonterm = rule.getNonterminal();	// left side of derivation

			if (rulePos == 0)	{	// START node, FOLLOW of start node is always epsilon
				put(nonterm, Token.EPSILON);
				// first rule is made programmatically, add Epsilon to FOLLOW
				put(rule.getRightSymbol(0), Token.EPSILON);
			}
			else	{
				List nonterms = new ArrayList();	// collect receiving nonterminals
				
				for (int i = 0; i < rule.rightSize(); i++)	{
					String symbol = rule.getRightSymbol(i);
					boolean isTerminal = Token.isTerminal(symbol);
					
					if (nonterms.size() > 0)	{	// if there are receivers (not at first element)
						// add symbol to FOLLOW sets of all nonterminals in local list
						List l;
						if (isTerminal)	{
							l = new ArrayList();
							l.add(symbol);	// terminal goes to FOLLOW set
						}
						else	{
							l = (List) firstSets.get(symbol);	// FIRST(symbol) goes to FOLLOW set
						}
						//System.err.println("rule "+rule+", adding to "+nonterms+" symbols "+v);
						addToAllFollowSets(nonterms, l);
					}
					
					if (isTerminal || nullAble.isNullable(symbol) == false)	{	// if it is a terminal or can not be null
						nonterms.clear();	// empty list of receiving nonterminals
					}

					if (isTerminal == false)	{	// if it is a nonterminal
						nonterms.add(symbol);
						
						if (i == rule.rightSize() - 1)	{	// at end
							// add left side of rule to FOLLOW sets of all collected nonterminals
							List l = new ArrayList();
							l.add(nonterm);
							addToAllFollowSets(nonterms, l);
						}
					}
				}	// end for all symbols
			}	// end if rule position 0
		}	// end for, loop across rules
	}

	private void addToAllFollowSets(List nonterms, List symbols)	{
		for (int i = 0; i < nonterms.size(); i++)	{
			String nt = (String) nonterms.get(i);

			for (int j = 0; j < symbols.size(); j++)	{
				String s = (String) symbols.get(j);

				if (Nullable.isNull(s) == false)	// do not add empty word
					put(nt, s);
			}
		}
	}


	private void resolveSets()
		throws ParserBuildException
	{
		// Make plain lists of mixed reference lists: all nonterminals are resolved to their terminal lists
		for (Enumeration e = keys(); e.hasMoreElements(); )	{
			String key = (String) e.nextElement();
			//System.err.println("nonterminal "+key+" = "+get(key));
			List newList = resolveSetSymbol(key, new Hashtable());
			replace(key, newList);
		}
	}
	
	private List resolveSetSymbol(String nonterm, Map done)
		throws ParserBuildException
	{
		if (done.get(nonterm) != null)
			return null;
		done.put(nonterm, nonterm);	// avoid endless loops

		List values = (List) get(nonterm);
		List newList = new ArrayList(values.size() * 2);
		
		for (int j = 0; j < values.size(); j++)	{
			String symbol = (String) values.get(j);
			
			if (Token.isTerminal(symbol) == false)	{	// resolve nonterminal
				try	{
					List l = resolveSetSymbol(symbol, done);
					for (int i = 0; l != null && i < l.size(); i++)	{
						String s = (String) l.get(i);
						if (newList.indexOf(s) < 0)
							newList.add(s);
					}
				}
				catch (Exception ex)	{
					throw new ParserBuildException("FOLLOW set error: "+ex.getMessage()+" <- "+symbol);
				}
			}
			else	{	// add terminal
				if (newList.indexOf(symbol) < 0)
					newList.add(symbol);
			}
		}
		return newList;
	}


	/** Overridden to check for equality of key and value: Exception is thrown when so. */
	public Object put(Object key, Object value)	{
		if (key.equals(value))
			throw new IllegalArgumentException("Can not be FOLLOW of its own: key="+key+", value="+value);
			
		return super.put(key, value);
	}



	/** Test main */
	public static void main(String [] args)	{
		List nt = new ArrayList();
		nt.add("S"); nt.add("T"); nt.add("F"); nt.add("L");

		List sx = new ArrayList();

		List r = new ArrayList();
		r.add("S"); r.add("E");
		sx.add(r);

		r = new ArrayList();
		r.add("E"); r.add("T"); r.add("'*'"); r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("E"); r.add("T");
		sx.add(r);

		r = new ArrayList();
		r.add("T"); r.add("F");
		sx.add(r);

		r = new ArrayList();
		r.add("F"); r.add("'1'");
		sx.add(r);

		Syntax syntax = new Syntax(sx);
		try	{
			Nullable nullAble = new Nullable(syntax, nt);
			FollowSets f = new FollowSets(syntax, nullAble, new FirstSets(syntax, nullAble, nt));
			String s = "T";
			System.err.println("FOLLOW("+s+") = "+f.get(s));
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}