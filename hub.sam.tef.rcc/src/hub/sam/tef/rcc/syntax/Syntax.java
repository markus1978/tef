package hub.sam.tef.rcc.syntax;

import hub.sam.tef.rcc.Token;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
	A Syntax is a Rule list that can be converted to a parser table.
	It provides several methods to check and simplify the grammar.
	Syntax accepts no duplicate rules (ignores any addition except
	the first by using a backing hashtable).
	
	@author (c) 2004 Fritz Ritzberger
*/

public class Syntax implements Serializable
{

	private List<Rule> rules;
	private Hashtable<Rule, Rule> ruleHash;
	
	public static Syntax copy(Syntax original) {
		return new Syntax(original);
	}
	
	private Syntax(Syntax original) {
		rules = new ArrayList<Rule>();
		rules.addAll(original.rules);
		ruleHash = new Hashtable<Rule, Rule>();
	}
	
	public Syntax()	{
		this(new ArrayList<List<String>>());
	}
	
	public Syntax(int size)	{
		this(new ArrayList<List<String>>(size));
	}
	
	public Syntax(String [][] rules)	{
		this(SyntaxUtil.ruleArrayToList(rules));
	}
	
	public Syntax(String [][][] ruleSets)	{
		this(SyntaxUtil.catenizeRulesUnique(ruleSets));
	}

	public Syntax(List<List<String>> rules)	{
		appendRules(rules);
	}


	/** Append rules to this syntax. List elements can be Rule or List, second will be converted to Rule. */
	public void appendRules(List rules)	{
		if (rules != null)	{
			if (rules.size() > 0)	{
				if (this.rules == null)	{
					allocateRules(rules);
				}
					
				for (int i = 0; i < rules.size(); i++)	{
					Object o = rules.get(i);
					if (o instanceof Rule)
						addRule((Rule) o);
					else	// must convert from List to Rule
						addRule(new Rule((List<String>) o));
				}
			}
			else	{
				if (this.rules == null)	{
					allocateRules(rules);
				}
			}
		}
	}
	
	/** Returns the number of rules of this Syntax. */
	public int size()	{
		return rules != null ? rules.size() : 0;
	}
	
	/** Returns the rule at the given position. */
	public Rule getRule(int i)	{
		return (Rule) rules.get(i);
	}
	
	/** Appends a new rule to this Syntax. */
	public void addRule(Rule rule)	{
		insertRule(size(), rule);
	}
	
	/** Inserts a new rule into this Syntax (needed to set artificial START rule at position 0). */
	public void insertRule(int i, Rule rule)	{
		if (rules == null)	{
			allocateRules(null);
		}
		
		if (ruleHash.get(rule) != null)
			return;	// already contained
		
		ruleHash.put(rule, rule);
		rules.add(i, rule);
	}
	
	/** Removes the rule at passed index from this Syntax. */
	public void removeRule(int index)	{
		rules.remove(index);
	}
	

	private void allocateRules(List rules)	{
		int size = rules == null || rules.size() <= 0 ? 64 : rules.size();
		this.rules = new ArrayList<Rule>(size);
		this.ruleHash = new Hashtable<Rule, Rule>(size);
	}


	/** Returns a List of top level Rules (that do not appear on right side of any contained rule). */
	public List<Rule> findStartRules()	{
		List<Rule> roots = new ArrayList<Rule>(1);
		
		for (int i = 0; i < size(); i++)	{
			Rule rule = getRule(i);
			String nonterm = rule.getNonterminal();

			// search this left side nonterminal on right sides of all rules
			boolean found = nonterm.equals(Token.TOKEN) || nonterm.equals(Token.IGNORED);
			for (int j = 0; found == false && j < size(); j++)	{
				Rule r = getRule(j);
				if (j != i && r.getNonterminal().equals(nonterm) == false)	// start rule is allowed to be recursive
					for (int k = 0; found == false && k < r.rightSize(); k++)
						if (r.getRightSymbol(k).equals(nonterm) && false == r.getNonterminal().equals(Token.TOKEN) && false == r.getNonterminal().equals(Token.IGNORED))
							found = true;
			}
			
			if (found == false)	// must be a top level rule
				roots.add(rule);
		}
		
		return roots;
	}


	/**
		Simplify the syntax. Search rules that have a nonterminal that is defined only once
		and contains exactly one symbol on right side. Such a rule gets deleted and its references
		get substituted by the symbol on right side of that rule.
		<p>
		This method is called by default from SerializedObject (base class for all builders).
		<p>
		CAUTION: Such symbols will not be called within Semantic!
	*/
	public void resolveSingulars()	{
		Rule singular;
		while ((singular = removeSingular()) != null)	{
			String substitute = singular.getNonterminal();

			for (int i = 0; i < size(); i++)	{	// substitute rules containing the singular
				Rule rule = getRule(i);

				for (int j = 0; j < rule.rightSize(); j++)
					if (rule.getRightSymbol(j).equals(substitute))
						rule.setRightSymbol(singular.getRightSymbol(0), j);
			}
		}
	}

	private Rule removeSingular()	{
		for (int i = size() - 1; i >= 0; i--)	{
			Rule rule = getRule(i);
			String nonterminal = rule.getNonterminal();
			
			// check if rule has only one symbol on right side and nonterminal is artificial symbol
			boolean singular = 
				rule.rightSize() == 1 &&
				nonterminal.startsWith(Token.ARTIFICIAL_NONTERMINAL_START_CHARACTER) &&
				nonterminal.equals(Token.TOKEN) == false && nonterminal.equals(Token.IGNORED) == false;

			// check if defined only once on any left side
			for (int j = 0; singular && j < size(); j++)
				if (j != i && getRule(j).getNonterminal().equals(nonterminal))
					singular = false;	// nonterm has been found once more on left side: rule has alternative rules
			
			// check if this is not a semantic splitting of a nonterminal in different contexts:
			// is right symbol defined only once on any right side with rightSize() == 1 ?
			String rightSymbol = singular ? rule.getRightSymbol(0) : null;
			for (int j = 0; singular && j < size(); j++)
				if (j != i && getRule(j).rightSize() == 1 && getRule(j).getRightSymbol(0).equals(rightSymbol))
					singular = false;	// nonterm has been found once more on a right side with exactly one symbol
			
			if (singular)	{
				if (rule.indexOnRightSide(nonterminal) >= 0)	// check if recursive rule
					System.err.println("WARNING: removing recursive singular rule: "+rule);

				this.rules.remove(i);
				return rule;
			}
		}
		return null;
	}



	/**
		Resolves undefined rules in this syntax from another syntax.
		@param resolvingSyntax the syntax to copy rules from
	*/
	public void resolveFrom(Syntax resolvingSyntax)	{
		Set unresolved = getUnresolvedNonterminals();
		Map<String, String> done = new Hashtable<String, String>();
		for (Iterator it = unresolved.iterator(); it.hasNext(); )	{
			getRulesUnderSymbol((String) it.next(), resolvingSyntax, done);
		}
	}

	/**
		Returns a set of nonterminals that have no rule within this syntax.
	*/
	public Set<String> getUnresolvedNonterminals()	{
		Set<String> unresolved = new HashSet<String>();
		for (int j = 0; j < size(); j++)	{
			Rule rule = getRule(j);
			for (int i = 0; i < rule.rightSize(); i++)	{
				String sym = rule.getRightSymbol(i);
				if (Token.isTerminal(sym) == false && sym.equals(Token.BUTNOT) == false && sym.equals(Token.UPTO) == false && hasRule(sym) == false)
					unresolved.add(sym);
			}
		}
		return unresolved;
	}

	private void getRulesUnderSymbol(String nonterminal, Syntax sourceSyntax, Map<String, String> done)	{
		if (done.get(nonterminal) != null)
			return;
		done.put(nonterminal, nonterminal);

		for (int i = 0; i < sourceSyntax.size(); i++)	{
			Rule rule = sourceSyntax.getRule(i);
			if (rule.getNonterminal().equals(nonterminal))	{
				addRule(rule);
				for (int j = 0; j < rule.rightSize(); j++)	{	// cascade to other rules
					String sym = rule.getRightSymbol(j);
					if (Token.isTerminal(sym) == false && sym.equals(Token.BUTNOT) == false && sym.equals(Token.UPTO) == false)
						getRulesUnderSymbol(sym, sourceSyntax, done);
				}
			}
		}
	}

	/**
		Returns true if the passed nonterminal is on the left side of at least one contained rule.
	*/
	public boolean hasRule(String nonterminal)	{
		for (int i = 0; i < size(); i++)
			if (getRule(i).getNonterminal().equals(nonterminal))
				return true;
		return false;
	}		




	/** Returns the syntax as a human readable multiline text. */
	public String toString()	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size(); i++)	{
			sb.append(getRule(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	/* HUB */
	/**
	 * @return all rules that start with the given prefix. A prefix starts with
	 *         the LHS of the rule, followed by the symbols describing the start
	 *         of a RHS.
	 */
	public Collection<Rule> rulesWithPrefix(String[] rulePrefix) {
		Collection<Rule> result = new ArrayList<Rule>();
		for (Rule rule: rules) {
			if (rule.getNonterminal().equals(rulePrefix[0])) {
				for (int i = 1; i < rulePrefix.length; i++) {
					if (rule.rightSize() >= i && 
							rule.getRightSymbol(i - 1).equals(rulePrefix[i])) {
						result.add(rule);
					}
				}
			}
		}
		return result;
	}
}
