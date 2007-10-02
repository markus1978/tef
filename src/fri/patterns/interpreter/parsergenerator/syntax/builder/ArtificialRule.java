package fri.patterns.interpreter.parsergenerator.syntax.builder;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.util.SymbolToName;

/**
	ArtificialRule is needed to
	<ul>
		<li>create nonterminals and rules for symbols within parenthesis: "(a b c)" -> "_a_b_c_"</li>
		<li>create nonterminals and rules for symbols that were quantified with "*", "+", "?"</li>
	</ul>
	The nonterminal names get created from symbols that are converted to names.
	Every created nonterminal starts with "_" (Token.ARTIFICIAL_RULE_START_CHARACTER).
	<p>
	Example:
	<pre>
		sentence1 ::= word* ;
		sentence2 ::= word+ ;
		sentence3 ::= word? ;
	</pre>
	will be converted to following rules
	<pre>
		_sentence1_OPTLIST ::= _sentence1_LIST;
		_sentence1_OPTLIST ::= ;
		_sentence1_LIST ::= _sentence1_LIST word;
		_sentence1_LIST ::= word;
		
		_sentence2_LIST ::= _sentence2_LIST word;
		_sentence2_LIST ::= word;

		_sentence3_OPT ::= word;
		_sentence3_OPT ::= ;
	</pre>
	 
	@author (c) 2002 Fritz Ritzberger
*/

class ArtificialRule
{
	private List rules;
	private String nonterminal;
	
	/**
		Creates an artificial rule from an expression within parenthesis.
		Argument sentencesInParenthesis holds a List of arbitrary deep Lists
		that contain String or ArtificialRule at end.
		The method getRules() will return as much rules as are contained on any
		level in sentencesInParenthesis.
	*/
	public ArtificialRule(List sentencesInParenthesis, String catSym)	{	// make "(b c)" to rule "_b_c_ ::= b c"
		StringBuffer sb = new StringBuffer();
		parenthesisContentsToString(sentencesInParenthesis, sb, catSym);
		nonterminal = ensureUnderscore(sb.toString());
		rules = createRule(nonterminal, sentencesInParenthesis);
	}
	
	private void parenthesisContentsToString(List sentences, StringBuffer sb, String catSym)	{
		for (int i = 0; i < sentences.size(); i++)	{
			Object o = sentences.get(i);
			
			if (o instanceof List)	{
				parenthesisContentsToString((List)o, sb, "");	// catenize symbol only on first level
			}
			else	{
				if (o instanceof String)
					o = SymbolToName.makeIdentifier((String)o, "");	// no "_" for quotes
				sb.append(o.toString());	// ArtificialRule goes here
			}

			if (i < sentences.size() - 1)
				sb.append((catSym.length() > 0 ? "_" + catSym : "") + "_");
		}
	}

	
	/**
		Creates an artificial rule from with a quantifier like "*", "+", "?".
		From this some rules are resulting that getRules() will return.
		"token" is either String or ArtificialRule.
	*/
	public ArtificialRule(Object token, String quantifier)	{	// make "a*", "a+", "a?" to rules
		nonterminal = token.toString();
		
		String listNonterm = null;	// needed for * and +
		
		if (quantifier.equals("+") || quantifier.equals("*"))	{
			List sentences = new ArrayList();

			listNonterm = ensureUnderscore(nonterminal)+"_LIST";
			
			// for now leave out the left side nonterminal of list
			List sentence = new ArrayList();	// mandatory tokenlist expands to
			sentence.add(listNonterm);	// the list and 
			sentence.add(token.toString());	// the token
			sentences.add(sentence);

			sentence = new ArrayList();
			sentence.add(token.toString());	// or the token alone
			sentences.add(sentence);
			
			rules = createRule(listNonterm, sentences);	// adds the left side nonterminal of list
			
			if (quantifier.equals("+"))
				nonterminal = listNonterm;	// "_a_LIST" is the substitute for "a+"
		}

		if (quantifier.equals("*") || quantifier.equals("?"))	{
			List sentences = new ArrayList();

			nonterminal = ensureUnderscore(nonterminal)+(quantifier.equals("*") ? "_OPTLIST" : "_OPT");

			String nonterm = quantifier.equals("*") ? listNonterm : token.toString();
			
			List sentence = new ArrayList();	// optional tokenlist expands to
			sentence.add(nonterm);	// the mandatory list when *, the token when ?
			sentences.add(sentence);

			sentences.add(new ArrayList());	// or nothing
				
			List mandatoryList = quantifier.equals("*") ? rules : null;

			rules = createRule(nonterminal, sentences);

			if (mandatoryList != null)
				rules.addAll(mandatoryList);
		}
	
		if (token instanceof ArtificialRule)	// could be '(' token ')'
			rules.addAll(((ArtificialRule)token).getRules());
	}
	

	private String ensureUnderscore(String nonterminal)	{
		if (nonterminal.startsWith(Token.ARTIFICIAL_NONTERMINAL_START_CHARACTER) == false)
			nonterminal = Token.ARTIFICIAL_NONTERMINAL_START_CHARACTER + nonterminal;
		return nonterminal;
	}
	
	private List createRule(String nonterminal, List sentences)	{
		for (int i = 0; i < sentences.size(); i++)	{
			List deep = (List) sentences.get(i);
			List flat = flattenLists(deep, new ArrayList());
			flat.add(0, nonterminal);
			sentences.set(i, flat);
		}
		return sentences;
	}


	/**
		The passed "deep" container contains Lists of arbitrary depth, that means every List
		element can be a List. This method resolves them to a sequential List of Lists.
		@param container List that contains Lists that contain Lists ...
		@param result List containing only Lists, retrieved from the "tree" container.
		@return the result flattened List (identical with passed "flat" List).
	*/
	public static List flattenLists(List deep, List flat)	{
		for (int i = 0; i < deep.size(); i++)	{
			Object o = deep.get(i);
			
			if (o instanceof List)
				flattenLists((List)o, flat);
			else
				flat.add(o);
		}
		return flat;
	}

	
			
	/**
		Returns the artificial name of this rule.
		This is used to represent this rule within other rules.
	*/
	public String toString()	{
		return nonterminal;
	}

	/**
		Returns all real rules of this artificial rule.
	*/
	public List getRules()	{
		return rules;
	}


	/**
		Resolves a List of rules that contain ArtificialRules to a
		to a list of real rules and stores those in resultSyntax.
		@param rules List of rules to resolve, containing ArtificialRules on the right side.
		@param resultSyntax List of rules that will not contain ArtificialRules. Will not be cleared when passed!
	*/
	public static void resolveArtificialRules(List rules, List resultSyntax)	{
		for (int j = 0; j < rules.size(); j++)	{
			List rule = (List) rules.get(j);

			resultSyntax.add(rule);	// add it
			
			for (int k = 1; k < rule.size(); k++)	{	// optionally modify it
				Object symbol = rule.get(k);
				
				if (symbol instanceof ArtificialRule)	{	// when containing rules
					rule.set(k, symbol.toString());	// set the rule's nonterminal
					
					ArtificialRule ar = (ArtificialRule)symbol;
					resolveArtificialRules(ar.getRules(), resultSyntax);	// add the rule
				}
			}
		}
	}


	public static void main(String [] args)	{
		List ruleA = new ArrayList();
		List ruleB = new ArrayList();
		List parenthesisRule = new ArrayList();
		ruleA.add("a1"); ruleA.add("a2");
		ruleB.add("b1");
		parenthesisRule.add(ruleA); parenthesisRule.add(ruleB);
		ArtificialRule afr = new ArtificialRule(parenthesisRule, "OR");
		System.err.println(afr.toString()+" ::= "+afr.getRules());
		
		ArtificialRule afr2 = new ArtificialRule(afr, "*");
		System.err.println(afr2.toString()+" ::= "+afr2.getRules());
	}

}