package hub.sam.tef.rcc.syntax.builder;

import hub.sam.tef.rcc.Semantic;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.syntax.Rule;

import java.util.ArrayList;
import java.util.List;

/**
	A syntax specification similar to EBNF.
	This semantic is used to build a Parser with Lexer from a textual EBNF syntax specification.
	<p>
	The semantics of ".." is the description of the set between leading and trailing character.
	The leading must be the one with the lower UNICODE value.
	<p>
	The semantics of "-" is intersection. When specifiying <i>chars - comment - stringdef</i> this means
	all <i>chars</i> but not <i>comments</i> or <i>stringdef</i>, i.e. <i>stringdef</i> is not subtracted
	from <i>comment</i> but from <i>chars</i>!
	<p>
	TODO: think over repeat number symbol: parser AND lexer would need this.
			Better define this by written symbols like "a ::= b b b b;"? But what to do on hundred "b"?
	
	@author (c) 2002 Fritz Ritzberger
*/

public class SyntaxBuilderSemantic implements Semantic
{
	public static String [][] syntax = {
		// START rule
		{ "syntax",    "syntax", "rule" },	// the grammar consists of rules
		{ "syntax",    "rule" },

		{ "set",     "`bnf_chardef`", "\""+Token.UPTO+"\"", "`bnf_chardef`" },	// set of characters

		{ "intersectionstartunit",  "set" },	// intersection of character sets
		{ "intersectionstartunit",  "`identifier`" },
		{ "intersectionstartunit",  "`ruleref`" },

		{ "intersectionunit",  "`bnf_chardef`" },
		{ "intersectionunit",  "`stringdef`" },
		{ "intersectionunit",  "intersectionstartunit" },

		{ "intersectionsubtracts", "intersectionsubtracts", "intersectionsubtract" },
		{ "intersectionsubtracts", "intersectionsubtract" },
		{ "intersectionsubtract", "'"+Token.BUTNOT+"'", "intersectionunit" },

		{ "intersection", "intersectionstartunit", "intersectionsubtracts" },

		{ "sequnit",  "intersection" },	// unit of a sequence
		{ "sequnit",  "intersectionunit" },
		{ "sequnit",  "'('", "unionseq", "')'" },

		{ "quantifiedsequnit", "sequnit", "`quantifier`" },	// unit can be quantified
		{ "quantifiedsequnit", "sequnit" },

		{ "sequence", "sequence", "quantifiedsequnit" },	// sequence of units with significant order
		{ "sequence", "quantifiedsequnit" },

		{ "sequence_opt", "sequence" },	// sequence is nullable
		{ "sequence_opt", /*nothing*/ },

		{ "unionseq", "unionseq", "'|'", "sequence_opt" },	// rule alternatives
		{ "unionseq", "sequence_opt" },

		{ "rule",    "`identifier`", "\"::=\"", "unionseq", "';'" },	// one rule of a grammar

		// specify what will be ignored. Using StandardLexerRules.lexerSyntax will include this automatically
		//{ "ignored", "`comment`" },
		//{ "ignored", "`spaces`" },
		//{ "ignored", "`newlines`" },
	};
	
	private List initialNonterminals;
	

	/**
		Creates a syntax builder semantic that resolves parenthesis and quantifiers.
	*/
	public SyntaxBuilderSemantic()	{
		this(null);
	}
	
	/**
		Creates a syntax builder semantic that resolves parenthesis and quantifiers.
		All nonterminals read from the processed syntax will be collected into the passed List.
	*/
	public SyntaxBuilderSemantic(List initialNonterminals)	{
		this.initialNonterminals = initialNonterminals;
	}
	

	public Object doSemantic(Rule rule, List inputTokens, List ranges)	{
		String nt = rule.getNonterminal();

		if (nt.equals("set"))
			return inputTokens;

		if (nt.equals("intersectionstartunit") || nt.equals("intersectionunit"))
			return inputTokens.get(0);

		if (nt.equals("intersectionsubtract"))
			return inputTokens;

		if (nt.equals("intersectionsubtracts"))
			if (inputTokens.size() == 2)
				return appendAll((List) inputTokens.get(0), (List)inputTokens.get(1));
			else
				return inputTokens.get(0);

		if (nt.equals("intersection"))
			return insertAtStart(inputTokens.get(0), (List) inputTokens.get(1));

		if (nt.equals("sequnit"))
			if (inputTokens.size() == 3)
				return sequnitInParenthesis(inputTokens.get(1));
			else
				return inputTokens.get(0);

		if (nt.equals("quantifiedsequnit"))
			if (inputTokens.size() == 2)
				return quantifiedsequnit(inputTokens.get(0), inputTokens.get(1));
			else
				return inputTokens.get(0);

		if (nt.equals("sequence"))
			if (inputTokens.size() == 2)
				return append((List) inputTokens.get(0), inputTokens.get(1));
			else
				return inputTokens;

		if (nt.equals("sequence_opt"))
				return inputTokens;

		if (nt.equals("unionseq"))
			if (inputTokens.size() == 3)
				return append((List) inputTokens.get(0), (List) inputTokens.get(2));
			else
				return inputTokens;

		if (nt.equals("rule"))
			return rule((String) inputTokens.get(0), (List) inputTokens.get(2));

		if (nt.equals("syntax"))
			if (inputTokens.size() == 2)
				return syntax((List) inputTokens.get(0), (List) inputTokens.get(1));
			else
				return inputTokens.get(0);
				
		throw new IllegalArgumentException("Unknown rule: "+rule);
	}
	

	private ArtificialRule sequnitInParenthesis(Object unionseq)	{
		return new ArtificialRule((List)unionseq, "OR");
	}

	private ArtificialRule quantifiedsequnit(Object sequnit, Object quantifier)	{
		return new ArtificialRule(sequnit, (String)quantifier);
	}

	private List append(List list, Object element)	{
		list.add(element);
		return list;
	}

	private List appendAll(List list, List elements)	{
		for (int i = 0; i < elements.size(); i++)
			list.add(elements.get(i));
		return list;
	}

	private List insertAtStart(Object intersectionStart, List intersectionList)	{
		intersectionList.add(0, intersectionStart);
		return intersectionList;
	}
	
	private List rule(String identifier, List unionseq)	{
		if (initialNonterminals != null && initialNonterminals.indexOf(identifier) < 0)
			initialNonterminals.add(identifier);

		for (int i = 0; i < unionseq.size(); i++)	{
			List deep = (List) unionseq.get(i);
			List flat = ArtificialRule.flattenLists(deep, new ArrayList());
			flat.add(0, identifier);
			unionseq.set(i, flat);
		}
		return unionseq;
	}

	private List syntax(List syntax, List rule)	{
		for (int i = 0; i < rule.size(); i++)
			syntax.add((List) rule.get(i));
		return syntax;
	}
	
	public Object doSemanticForErrorRecovery(String recoverSymbol) {
		return "ERROR";
	}
}
