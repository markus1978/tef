package hub.sam.tef.tokens;

public class StandardLexerRules {

	/**
	Returns rules for a custom comment (like C-style "/*", but with passed start and end sequence).
	the resulting rules will be classified as 'ignored' rules, meaning these won't reach the parser
	@param nonterminalName name of comment to be used within syntax, e.g. "pascalComment".
	@param startSeq string defining the start sequence of the comment, e.g. "(*"
	@param endSeq string defining the end sequence of the comment, e.g. "*)"
	*/
	public static final String [][] getCustomMultiLineCommentRules(String nonterminalName, String startSeq, String endSeq)	{
		String [][] sarr0 = hub.sam.tef.rcc.lexer.StandardLexerRules.getUnicodeCharRules();
		String [][] customRules = new String [7][];
		customRules[0] = new String [] { nonterminalName,  "\""+startSeq+"\"", "char_minus_"+nonterminalName+"_list_opt", "\""+endSeq+"\"" };
		customRules[1] = new String [] { "char_minus_"+nonterminalName, "char", hub.sam.tef.rcc.Token.BUTNOT, "\""+endSeq+"\"" };
		customRules[2] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[3] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[4] = new String [] { "char_minus_"+nonterminalName+"_list_opt", "char_minus_"+nonterminalName+"_list" };
		customRules[5] = new String [] { "char_minus_"+nonterminalName+"_list_opt" /*nothing*/ };
		customRules[6] = new String[] {"ignored", "`"+nonterminalName+"`"};
		return hub.sam.tef.rcc.lexer.StandardLexerRules.catenizeRules(new String [][][] { sarr0, customRules });
	}
	
	/**
	Returns rules for a custom comment (like C-style "/*", but with passed start and end sequence).
	@param nonterminalName name of comment to be used within syntax, e.g. "pascalComment".
	@param startSeq string defining the start sequence of the comment, e.g. "(*"
	@param endSeq string defining the end sequence of the comment, e.g. "*)"
	*/
	public static final String [][] getCustomMultiLineBracketRules(String nonterminalName, String startSeq, String endSeq)	{
		String [][] sarr0 = hub.sam.tef.rcc.lexer.StandardLexerRules.getUnicodeCharRules();
		String [][] customRules = new String [6][];
		customRules[0] = new String [] { nonterminalName,  "\""+startSeq+"\"", "char_minus_"+nonterminalName+"_list_opt", "\""+endSeq+"\"" };
		customRules[1] = new String [] { "char_minus_"+nonterminalName, "char", hub.sam.tef.rcc.Token.BUTNOT, "\""+endSeq+"\"" };
		customRules[2] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[3] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[4] = new String [] { "char_minus_"+nonterminalName+"_list_opt", "char_minus_"+nonterminalName+"_list" };
		customRules[5] = new String [] { "char_minus_"+nonterminalName+"_list_opt" /*nothing*/ };
		return hub.sam.tef.rcc.lexer.StandardLexerRules.catenizeRules(new String [][][] { sarr0, customRules });
	}
}
