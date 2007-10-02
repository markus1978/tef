package fri.patterns.interpreter.parsergenerator.lexer;

import fri.patterns.interpreter.parsergenerator.Token;

/**
	Standard lexer rules are building blocks for lexers dealing with text input.
	This class resolves nonterminals enclosed in `backquotes` within an EBNF,
	e.g. `cstylecomment`.
	<p>
	Furthermore it provides methods to retrieve sets of rules describing certain standard
	scan items like `number` or `identifier`. The resulting arrays can be built together
	by <i>SyntaxUtil.catenizeRules(...)</i>.
	<p>
	This class provides rules for comments with an arbitrary start character or start/end sequence:
	<ul>
		<li>getCustomOneLineCommentRules(String startChar)</li> and
		<li>getCustomMultiLineCommentRules(String startSeq, String endSeq)</li>.
	</ul>
	<p>
	Example (CStyleCommentStrip):
	<pre>
	String [][] rules = {
		{ Token.TOKEN, "others" },	// define what we want to receive
		{ Token.TOKEN, "`stringdef`" },	// need this rule as string definitions could contain comments
		{ Token.IGNORED, "`cstylecomment`" },
		{ "others", "others", "other" },
		{ "others", "other" },
		{ "other", "`char`", Token.BUTNOT, "`cstylecomment`", Token.BUTNOT, "`stringdef`" },
	};
	Syntax syntax = new Syntax(rules);
	SyntaxSeparation separation = new SyntaxSeparation(syntax);
	LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
	Lexer lexer = builder.getLexer();
	</pre>

	TODO: Refactor this class and make smaller units with better names.

	@see fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder
	@author (c) 2002, Fritz Ritzberger
*/

public abstract class StandardLexerRules
{
	/**
		Returns e.g. the Letter-Rules <i>getUnicodeLetterRules()</i> for id "letter".
		Using this, one can write things like `identifier` in a Lexer specification text,
		as LexerBuilder tries to resolve these words calling this method.
		Possible values for id are:
		<ul>
			<li>char (all UNICODE characters)</li>
			<li>newline</li>
			<li>newlines</li>
			<li>space</li>
			<li>spaces</li>
			<li>whitespace</li>
			<li>whitespaces</li>
			<li>letter</li>
			<li>digit</li>
			<li>digits</li>
			<li>hexdigit</li>
			<li>hexdigits (does NOT include preceeding "0x")</li>
			<li>identifier</li>
			<li>stringdef</li>
			<li>chardef</li>
			<li>bnf_chardef (differs as in BNF characters can be written as "020" instead of '\020')</li>
			<li>ruleref	(`lexerrule`)</li>
			<li>quantifier	(*+?)</li>
			<li>cstylecomment</li>
			<li>comment</li>
			<li>shellstylecomment</li>
			<li>octdigits</li>
			<li>bindigits</li>
			<li>number</li>
			<li>float</li>
			<li>integer</li>
			<li>xmlchar</li>
			<li>combiningchar</li>
			<li>extenderchar</li>
		</ul>
	*/
	public static String [][] rulesForIdentifier(String id)	{
		//System.err.println("searching for syntax rules for nonterminal "+id);
		if (id.equals("char"))
			return getUnicodeCharRules();
		if (id.equals("newline"))
			return getNewlineRules();
		if (id.equals("newlines"))
			return getNewlinesRules();
		if (id.equals("space"))
			return getSpaceRules();
		if (id.equals("spaces"))
			return getSpacesRules();
		if (id.equals("whitespace"))
			return getWhitespaceRules();
		if (id.equals("whitespaces"))
			return getWhitespacesRules();
		if (id.equals("letter"))
			return getUnicodeLetterRules();
		if (id.equals("digit"))
			return getUnicodeDigitRules();
		if (id.equals("digits"))
			return getUnicodeDigitsRules();
		if (id.equals("hexdigit"))
			return getHexDigitRules();
		if (id.equals("hexdigits"))
			return getHexDigitsRules();
		if (id.equals("octdigits"))
			return getOctDigitsRules();
		if (id.equals("bindigits"))
			return getBinDigitsRules();
		if (id.equals("number"))
			return getNumberRules();
		if (id.equals("integer"))
			return getIntegerRules();
		if (id.equals("float"))
			return getFloatRules();
		if (id.equals("identifier"))
			return getUnicodeIdentifierRules();
		if (id.equals("stringdef"))
			return getUnicodeStringdefRules();
		if (id.equals("chardef"))
			return getUnicodeChardefRules();
		if (id.equals("bnf_chardef"))
			return getUnicodeBNFChardefRules();
		if (id.equals("ruleref"))
			return getRulerefRules();
		if (id.equals("quantifier"))
			return getQuantifierRules();
		if (id.equals("comment"))
			return getCommentRules();
		if (id.equals("cstylecomment"))
			return getCStyleCommentRules();
		if (id.equals("shellstylecomment"))
			return getShellStyleCommentRules();
		if (id.equals("xmlchar"))
			return getUnicodeXmlCharRules();
		if (id.equals("combiningchar"))
			return getUnicodeCombiningCharRules();
		if (id.equals("extenderchar"))
			return getUnicodeExtenderCharRules();
		return null;
	}


	/**
		Returns rules for a custom comment (like C-style "//", but with passed start sequence).
		@param nonterminalName name of comment to be used within syntax, e.g. "basicComment".
		@param startChar string (1-n characters) defining the start sequence of the comment, e.g. ";"
	*/
	public static final String [][] getCustomOneLineCommentRules(String nonterminalName, String startChar)	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getNewlineRules();
		String [][] sarr2 = getSomeRules(290, 296);
		String [] customRule = new String[sarr2[0].length];
		System.arraycopy(sarr2[0], 0, customRule, 0, customRule.length);
		customRule[0] = nonterminalName;
		customRule[1] = "\""+startChar+"\"";	// put custom sequence where where "//" sits
		sarr2[0] = customRule;
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/**
		Returns rules for a custom comment (like C-style "/*", but with passed start and end sequence).
		@param nonterminalName name of comment to be used within syntax, e.g. "pascalComment".
		@param startSeq string defining the start sequence of the comment, e.g. "(*"
		@param endSeq string defining the end sequence of the comment, e.g. "*)"
	*/
	public static final String [][] getCustomMultiLineCommentRules(String nonterminalName, String startSeq, String endSeq)	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getNewlineRules();
		String [][] customRules = new String [6][];
		customRules[0] = new String [] { nonterminalName,  "\""+startSeq+"\"", "char_minus_star_slash_list_opt", "\""+endSeq+"\"" };
		customRules[1] = new String [] { "char_minus_"+nonterminalName, "char", Token.BUTNOT, "\""+endSeq+"\"" };
		customRules[2] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[3] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[4] = new String [] { "char_minus_"+nonterminalName+"_list_opt", "char_minus_"+nonterminalName+"_list" };
		customRules[5] = new String [] { "char_minus_"+nonterminalName+"_list_opt" /*nothing*/ };
		return catenizeRules(new String [][][] { sarr0, sarr1, customRules });
	}
	
	
	/** Rules to scan one UNICODE character: 0x0 .. 0xFFFF. */
	public static final String [][] getUnicodeCharRules()	{
		return getSomeRules(21, 22);
	}

	/** Rules to scan one platform independent newline. */
	public static final String [][] getNewlineRules()	{
		return getSomeRules(16, 21);
	}

	/** Rules to scan one platform independent newline. */
	public static final String [][] getNewlinesRules()	{
		String [][] sarr0 = getNewlineRules();
		String [][] sarr1 = getSomeRules(0, 2, newlinesRules);
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}

	/** Rules to scan one space. */
	public static final String [][] getSpaceRules()	{
		return getSomeRules(13, 16);
	}

	/** Rules to scan spaces. */
	public static final String [][] getSpacesRules()	{
		String [][] sarr0 = getSpaceRules();
		String [][] sarr1 = getSomeRules(242, 244);
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}

	/** Rules to scan one space or newline. */
	public static final String [][] getWhitespaceRules()	{
		String [][] sarr0 = getSpaceRules();
		String [][] sarr1 = getNewlineRules();
		String [][] sarr2 = getSomeRules(0, 2, whitespaceRules);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}

	/** Rules to scan spaces or newlines. */
	public static final String [][] getWhitespacesRules()	{
		String [][] sarr0 = getSpacesRules();
		String [][] sarr1 = getNewlinesRules();
		String [][] sarr2 = getSomeRules(0, 4, whitespaceRules);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}

	/** Rules to scan one hexdigit. */
	public static final String [][] getHexDigitRules()	{
		return getSomeRules(10, 13);
	}

	/** Rules to scan hexdigits that form a number, starting "0x" not included. */
	public static final String [][] getHexDigitsRules()	{
		String [][] sarr0 = getHexDigitRules();
		String [][] sarr1 = getSomeRules(246, 248);	// more hexdigits
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}

	/** Rules to scan one letter. */
	public static final String [][] getUnicodeLetterRules()	{
		return getSomeRules(37, 242);
	}

	/** Rules to scan one digit. */
	public static final String [][] getUnicodeDigitRules()	{
		return getSomeRules(22, 37);
	}

	/** Rules to scan digits. */
	public static final String [][] getUnicodeDigitsRules()	{
		String [][] sarr0 = getUnicodeDigitRules();
		String [][] sarr1 = getSomeRules(244, 246);	// more digits
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}
	
	/** Rules to scan identifiers that start with letter and continue with letter or digit or '_'. */
	public static final String [][] getUnicodeIdentifierRules()	{
		String [][] sarr0 = getUnicodeDigitRules();
		String [][] sarr1 = getUnicodeLetterRules();
		String [][] sarr2 = getSomeRules(259, 268);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules to scan C/Java-like 'c'haracterdefinitions: '\377', 'A', '\n'. */
	public static final String [][] getUnicodeChardefRules()	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getSomeRules(0, 1, digitRules);	// octdigit
		String [][] sarr2 = getSomeRules(0, 2, chardefRules);
		String [][] sarr3 = getSomeRules(248, 249);	// part of bnf_chardef
		String [][] sarr4 = getSomeRules(251, 258);	// part of bnf_chardef
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2, sarr3, sarr4 });
	}
	
	/** Rules to scan BNF-like 'c'haracterdefinitions. They differ from C/Java-chardefs in that they can be written as digits: 0x20. */
	public static final String [][] getUnicodeBNFChardefRules()	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getHexDigitsRules();
		String [][] sarr2 = getUnicodeDigitsRules();
		String [][] sarr3 = getSomeRules(248, 259);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2, sarr3 });
	}
	
	/** Rules to scan "stringdefinitions" that can contain backslash as masking character. */
	public static final String [][] getUnicodeStringdefRules()	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getSomeRules(268, 284);
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}

	/** Rules to read a `lexerrule` within EBNF syntax specifications. */
	public static final String [][] getRulerefRules()	{
		String [][] sarr0 = getUnicodeIdentifierRules();
		String [][] sarr1 = getSomeRules(297, 298);
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}
	
	/** Rules to read quantifiers "*+?" within EBNF syntax specifications. */
	public static final String [][] getQuantifierRules()	{
		return getSomeRules(7, 10);
	}
	
	/** Rules to scan C-style slash-star and slash-slash AND shell-style # comments. */
	public static final String [][] getCommentRules()	{
		String [][] sarr0 = getCStyleCommentRules();
		String [][] sarr1 = getSomeRules(296, 297);
		String [][] sarr2 = getSomeRules(299, 301);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules to scan C-style slash-star and slash-slash comments. */
	public static final String [][] getCStyleCommentRules()	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getNewlineRules();
		String [][] sarr2 = getSomeRules(284, 296);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules to scan # shell-style comments. */
	public static final String [][] getShellStyleCommentRules()	{
		String [][] sarr0 = getUnicodeCharRules();
		String [][] sarr1 = getNewlineRules();
		String [][] sarr2 = getSomeRules(291, 297);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules for XML combining chars. */
	public static final String [][] getUnicodeXmlCharRules()	{
		return xmlCharRules;
	}
	
	/** Rules for XML combining chars. */
	public static final String [][] getUnicodeCombiningCharRules()	{
		String [][] sarr = getSomeRules(0, 95, xmlCombinigAndExtenderRules);
		return sarr;
	}
	
	/** Rules for XML extender chars. */
	public static final String [][] getUnicodeExtenderCharRules()	{
		String [][] sarr = getSomeRules(95, 106, xmlCombinigAndExtenderRules);
		return sarr;
	}
	
	/** Rules for octal number chars. */
	public static final String [][] getOctDigitsRules()	{
		String [][] sarr = getSomeRules(0, 3, digitRules);
		return sarr;
	}
	
	/** Rules for binary number chars. */
	public static final String [][] getBinDigitsRules()	{
		String [][] sarr = getSomeRules(3, 6, digitRules);
		return sarr;
	}
	
	/** Rules for general number chars (integer, float). */
	public static final String [][] getNumberRules()	{
		String [][] sarr2 = getIntegerRules();
		String [][] sarr1 = getFloatRules();
		String [][] sarr0 = getSomeRules(0, 2, numberRules);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules for integer number chars. */
	public static final String [][] getIntegerRules()	{
		String [][] sarr2 = getHexDigitsRules();
		String [][] sarr1 = getUnicodeDigitsRules();
		String [][] sarr0 = getSomeRules(19, 25, numberRules);
		return catenizeRules(new String [][][] { sarr0, sarr1, sarr2 });
	}
	
	/** Rules for float number chars. */
	public static final String [][] getFloatRules()	{
		String [][] sarr1 = getUnicodeDigitsRules();
		String [][] sarr0 = getSomeRules(2, 19, numberRules);
		return catenizeRules(new String [][][] { sarr0, sarr1 });
	}
	

	private static final String [][] getSomeRules(int startIncl, int endExcl)	{
		return getSomeRules(startIncl, endExcl, lexerSyntax);
	}

	private static final String [][] getSomeRules(int startIncl, int endExcl, String [][] rules)	{
		String [][] sarr = new String [endExcl - startIncl] [];
		int j = 0;
		for (int i = startIncl; i < endExcl; i++, j++)
			sarr[j] = rules[i];
		return sarr;
	}


	/** Print a grammar to System.out. */
	public static void printRules(String [][] syntax)	{
		for (int i = 0; i < syntax.length; i++)	{
			for (int j = 0; j < syntax[i].length; j++)
				System.out.print(j == 1 ? " ::= "+syntax[i][j]+" " : syntax[i][j]+" ");
			System.out.println();
		}
	}


	/** Catenizes some rule sets to one rule set. Does not check for uniqueness. */
	public static final String [][] catenizeRules(String [][][] arrays)	{
		int len = 0;
		for (int i = 0; i < arrays.length; i++)
			len += arrays[i].length;
			
		String [][] sarr = new String [len][];
		
		int k = 0;
		for (int i = 0; i < arrays.length; i++)	{
			for (int j = 0; j < arrays[i].length; j++)	{
				sarr[k] = arrays[i][j];
				k++;
			}
		}

		return sarr;
	}




	/** Premade lexer syntax used to scan textual EBNF-like syntax specifications. */
	public static final String [][] lexerSyntax = {
	
		// CAUTION: Do NOT edit without changing indexes in source above!!!
		
		/*0*/	{ Token.TOKEN, "identifier" },
		/*1*/	{ Token.TOKEN, "bnf_chardef" },
		/*2*/	{ Token.TOKEN, "stringdef" },
		/*3*/	{ Token.TOKEN, "quantifier" },	// see 297: ruleref

		/*4*/	{ Token.IGNORED,  "spaces" },
		/*5*/	{ Token.IGNORED,  "newline" },
		/*6*/	{ Token.IGNORED,  "comment" },

		/*7*/	{ "quantifier", "'*'" },
		/*8*/	{ "quantifier", "'+'" },
		/*9*/	{ "quantifier", "'?'" },

		// programmer digits
		
		/*10*/	{ "hexdigit", "'0'", Token.UPTO, "'9'" },
		/*11*/	{ "hexdigit", "'A'", Token.UPTO, "'F'" },
		/*12*/	{ "hexdigit", "'a'", Token.UPTO, "'f'" },
		
		// formatting characters
		
		/*13*/	{ "space",   "0x20" },
		/*14*/	{ "space",   "0x9" },
		/*15*/	{ "space",   "0xC" },	// formfeed
		
		/*16*/	{ "cr", "'\\r'" },	// 0xD
		/*17*/	{ "nl", "'\\n'" },	// 0xA
		/*18*/	{ "newline",   "cr", "nl" },
		/*19*/	{ "newline",   "cr" },
		/*20*/	{ "newline",   "nl" },

		// UNICODE character set
		
		/*21*/	{ "char",    "0x0", Token.UPTO, "0xFFFF" },

		/*22*/	{ "digit",   "0x0030", Token.UPTO, "0x0039" },
		/*23*/	{ "digit",   "0x0660", Token.UPTO, "0x0669" },
		/*24*/	{ "digit",   "0x06F0", Token.UPTO, "0x06F9" },
		/*25*/	{ "digit",   "0x0966", Token.UPTO, "0x096F" },
		/*26*/	{ "digit",   "0x09E6", Token.UPTO, "0x09EF" },
		/*27*/	{ "digit",   "0x0A66", Token.UPTO, "0x0A6F" },
		/*28*/	{ "digit",   "0x0AE6", Token.UPTO, "0x0AEF" },
		/*29*/	{ "digit",   "0x0B66", Token.UPTO, "0x0B6F" },
		/*30*/	{ "digit",   "0x0BE7", Token.UPTO, "0x0BEF" },
		/*31*/	{ "digit",   "0x0C66", Token.UPTO, "0x0C6F" },
		/*32*/	{ "digit",   "0x0CE6", Token.UPTO, "0x0CEF" },
		/*33*/	{ "digit",   "0x0D66", Token.UPTO, "0x0D6F" },
		/*34*/	{ "digit",   "0x0E50", Token.UPTO, "0x0E59" },
		/*35*/	{ "digit",   "0x0ED0", Token.UPTO, "0x0ED9" },
		/*36*/	{ "digit",   "0x0F20", Token.UPTO, "0x0F29" },

		/*37*/	{ "letter",  "0x0041", Token.UPTO, "0x005A" },	// BaseChar
		/*38*/	{ "letter",  "0x0061", Token.UPTO, "0x007A" },
		/*39*/	{ "letter",  "0x00C0", Token.UPTO, "0x00D6" },
		/*40*/	{ "letter",  "0x00D8", Token.UPTO, "0x00F6" },
		/*41*/	{ "letter",  "0x00F8", Token.UPTO, "0x00FF" },
		/*42*/	{ "letter",  "0x0100", Token.UPTO, "0x0131" },
		/*43*/	{ "letter",  "0x0134", Token.UPTO, "0x013E" },
		/*44*/	{ "letter",  "0x0141", Token.UPTO, "0x0148" },
		/*45*/	{ "letter",  "0x014A", Token.UPTO, "0x017E" },
		/*46*/	{ "letter",  "0x0180", Token.UPTO, "0x01C3" },
		/*47*/	{ "letter",  "0x01CD", Token.UPTO, "0x01F0" },
		/*48*/	{ "letter",  "0x01F4", Token.UPTO, "0x01F5" },
		/*49*/	{ "letter",  "0x01FA", Token.UPTO, "0x0217" },
		/*50*/	{ "letter",  "0x0250", Token.UPTO, "0x02A8" },
		/*51*/	{ "letter",  "0x02BB", Token.UPTO, "0x02C1" },
		/*52*/	{ "letter",  "0x0386" },
		/*53*/	{ "letter",  "0x0388", Token.UPTO, "0x038A" },
		/*54*/	{ "letter",  "0x038C" },
		/*55*/	{ "letter",  "0x038E", Token.UPTO, "0x03A1" },
		/*56*/	{ "letter",  "0x03A3", Token.UPTO, "0x03CE" },
		/*57*/	{ "letter",  "0x03D0", Token.UPTO, "0x03D6" },
		/*58*/	{ "letter",  "0x03DA" },
		/*59*/	{ "letter",  "0x03DC" },
		/*60*/	{ "letter",  "0x03DE" },
		/*61*/	{ "letter",  "0x03E0" },
		/*62*/	{ "letter",  "0x03E2", Token.UPTO, "0x03F3" },
		/*63*/	{ "letter",  "0x0401", Token.UPTO, "0x040C" },
		/*64*/	{ "letter",  "0x040E", Token.UPTO, "0x044F" },
		/*65*/	{ "letter",  "0x0451", Token.UPTO, "0x045C" },
		/*66*/	{ "letter",  "0x045E", Token.UPTO, "0x0481" },
		/*67*/	{ "letter",  "0x0490", Token.UPTO, "0x04C4" },
		/*68*/	{ "letter",  "0x04C7", Token.UPTO, "0x04C8" },
		/*69*/	{ "letter",  "0x04CB", Token.UPTO, "0x04CC" },
		/*70*/	{ "letter",  "0x04D0", Token.UPTO, "0x04EB" },
		/*71*/	{ "letter",  "0x04EE", Token.UPTO, "0x04F5" },
		/*72*/	{ "letter",  "0x04F8", Token.UPTO, "0x04F9" },
		/*73*/	{ "letter",  "0x0531", Token.UPTO, "0x0556" },
		/*74*/	{ "letter",  "0x0559" },
		/*75*/	{ "letter",  "0x0561", Token.UPTO, "0x0586" },
		/*76*/	{ "letter",  "0x05D0", Token.UPTO, "0x05EA" },
		/*77*/	{ "letter",  "0x05F0", Token.UPTO, "0x05F2" },
		/*78*/	{ "letter",  "0x0621", Token.UPTO, "0x063A" },
		/*79*/	{ "letter",  "0x0641", Token.UPTO, "0x064A" },
		/*80*/	{ "letter",  "0x0671", Token.UPTO, "0x06B7" },
		/*81*/	{ "letter",  "0x06BA", Token.UPTO, "0x06BE" },
		/*82*/	{ "letter",  "0x06C0", Token.UPTO, "0x06CE" },
		/*83*/	{ "letter",  "0x06D0", Token.UPTO, "0x06D3" },
		/*84*/	{ "letter",  "0x06D5" },
		/*85*/	{ "letter",  "0x06E5", Token.UPTO, "0x06E6" },
		/*86*/	{ "letter",  "0x0905", Token.UPTO, "0x0939" },
		/*87*/	{ "letter",  "0x093D" },
		/*88*/	{ "letter",  "0x0958", Token.UPTO, "0x0961" },
		/*89*/	{ "letter",  "0x0985", Token.UPTO, "0x098C" },
		/*90*/	{ "letter",  "0x098F", Token.UPTO, "0x0990" },
		/*91*/	{ "letter",  "0x0993", Token.UPTO, "0x09A8" },
		/*92*/	{ "letter",  "0x09AA", Token.UPTO, "0x09B0" },
		/*93*/	{ "letter",  "0x09B2" },
		/*94*/	{ "letter",  "0x09B6", Token.UPTO, "0x09B9" },
		/*95*/	{ "letter",  "0x09DC", Token.UPTO, "0x09DD" },
		/*96*/	{ "letter",  "0x09DF", Token.UPTO, "0x09E1" },
		/*97*/	{ "letter",  "0x09F0", Token.UPTO, "0x09F1" },
		/*98*/	{ "letter",  "0x0A05", Token.UPTO, "0x0A0A" },
		/*99*/	{ "letter",  "0x0A0F", Token.UPTO, "0x0A10" },
		/*100*/	{ "letter",  "0x0A13", Token.UPTO, "0x0A28" },
		/*101*/	{ "letter",  "0x0A2A", Token.UPTO, "0x0A30" },
		/*102*/	{ "letter",  "0x0A32", Token.UPTO, "0x0A33" },
		/*103*/	{ "letter",  "0x0A35", Token.UPTO, "0x0A36" },
		/*104*/	{ "letter",  "0x0A38", Token.UPTO, "0x0A39" },
		/*105*/	{ "letter",  "0x0A59", Token.UPTO, "0x0A5C" },
		/*106*/	{ "letter",  "0x0A5E" },
		/*107*/	{ "letter",  "0x0A72", Token.UPTO, "0x0A74" },
		/*108*/	{ "letter",  "0x0A85", Token.UPTO, "0x0A8B" },
		/*109*/	{ "letter",  "0x0A8D" },
		/*110*/	{ "letter",  "0x0A8F", Token.UPTO, "0x0A91" },
		/*111*/	{ "letter",  "0x0A93", Token.UPTO, "0x0AA8" },
		/*112*/	{ "letter",  "0x0AAA", Token.UPTO, "0x0AB0" },
		/*113*/	{ "letter",  "0x0AB2", Token.UPTO, "0x0AB3" },
		/*114*/	{ "letter",  "0x0AB5", Token.UPTO, "0x0AB9" },
		/*115*/	{ "letter",  "0x0ABD" },
		/*116*/	{ "letter",  "0x0AE0" },
		/*117*/	{ "letter",  "0x0B05", Token.UPTO, "0x0B0C" },
		/*118*/	{ "letter",  "0x0B0F", Token.UPTO, "0x0B10" },
		/*119*/	{ "letter",  "0x0B13", Token.UPTO, "0x0B28" },
		/*120*/	{ "letter",  "0x0B2A", Token.UPTO, "0x0B30" },
		/*121*/	{ "letter",  "0x0B32", Token.UPTO, "0x0B33" },
		/*122*/	{ "letter",  "0x0B36", Token.UPTO, "0x0B39" },
		/*123*/	{ "letter",  "0x0B3D" },
		/*124*/	{ "letter",  "0x0B5C", Token.UPTO, "0x0B5D" },
		/*125*/	{ "letter",  "0x0B5F", Token.UPTO, "0x0B61" },
		/*126*/	{ "letter",  "0x0B85", Token.UPTO, "0x0B8A" },
		/*127*/	{ "letter",  "0x0B8E", Token.UPTO, "0x0B90" },
		/*128*/	{ "letter",  "0x0B92", Token.UPTO, "0x0B95" },
		/*129*/	{ "letter",  "0x0B99", Token.UPTO, "0x0B9A" },
		/*130*/	{ "letter",  "0x0B9C" },
		/*131*/	{ "letter",  "0x0B9E", Token.UPTO, "0x0B9F" },
		/*132*/	{ "letter",  "0x0BA3", Token.UPTO, "0x0BA4" },
		/*133*/	{ "letter",  "0x0BA8", Token.UPTO, "0x0BAA" },
		/*134*/	{ "letter",  "0x0BAE", Token.UPTO, "0x0BB5" },
		/*135*/	{ "letter",  "0x0BB7", Token.UPTO, "0x0BB9" },
		/*136*/	{ "letter",  "0x0C05", Token.UPTO, "0x0C0C" },
		/*137*/	{ "letter",  "0x0C0E", Token.UPTO, "0x0C10" },
		/*138*/	{ "letter",  "0x0C12", Token.UPTO, "0x0C28" },
		/*139*/	{ "letter",  "0x0C2A", Token.UPTO, "0x0C33" },
		/*140*/	{ "letter",  "0x0C35", Token.UPTO, "0x0C39" },
		/*141*/	{ "letter",  "0x0C60", Token.UPTO, "0x0C61" },
		/*142*/	{ "letter",  "0x0C85", Token.UPTO, "0x0C8C" },
		/*143*/	{ "letter",  "0x0C8E", Token.UPTO, "0x0C90" },
		/*144*/	{ "letter",  "0x0C92", Token.UPTO, "0x0CA8" },
		/*145*/	{ "letter",  "0x0CAA", Token.UPTO, "0x0CB3" },
		/*146*/	{ "letter",  "0x0CB5", Token.UPTO, "0x0CB9" },
		/*147*/	{ "letter",  "0x0CDE" },
		/*148*/	{ "letter",  "0x0CE0", Token.UPTO, "0x0CE1" },
		/*149*/	{ "letter",  "0x0D05", Token.UPTO, "0x0D0C" },
		/*150*/	{ "letter",  "0x0D0E", Token.UPTO, "0x0D10" },
		/*151*/	{ "letter",  "0x0D12", Token.UPTO, "0x0D28" },
		/*152*/	{ "letter",  "0x0D2A", Token.UPTO, "0x0D39" },
		/*153*/	{ "letter",  "0x0D60", Token.UPTO, "0x0D61" },
		/*154*/	{ "letter",  "0x0E01", Token.UPTO, "0x0E2E" },
		/*155*/	{ "letter",  "0x0E30" },
		/*156*/	{ "letter",  "0x0E32", Token.UPTO, "0x0E33" },
		/*157*/	{ "letter",  "0x0E40", Token.UPTO, "0x0E45" },
		/*158*/	{ "letter",  "0x0E81", Token.UPTO, "0x0E82" },
		/*159*/	{ "letter",  "0x0E84" },
		/*160*/	{ "letter",  "0x0E87", Token.UPTO, "0x0E88" },
		/*161*/	{ "letter",  "0x0E8A" },
		/*162*/	{ "letter",  "0x0E8D" },
		/*163*/	{ "letter",  "0x0E94", Token.UPTO, "0x0E97" },
		/*164*/	{ "letter",  "0x0E99", Token.UPTO, "0x0E9F" },
		/*165*/	{ "letter",  "0x0EA1", Token.UPTO, "0x0EA3" },
		/*166*/	{ "letter",  "0x0EA5" },
		/*167*/	{ "letter",  "0x0EA7" },
		/*168*/	{ "letter",  "0x0EAA", Token.UPTO, "0x0EAB" },
		/*169*/	{ "letter",  "0x0EAD", Token.UPTO, "0x0EAE" },
		/*170*/	{ "letter",  "0x0EB0" },
		/*171*/	{ "letter",  "0x0EB2", Token.UPTO, "0x0EB3" },
		/*172*/	{ "letter",  "0x0EBD" },
		/*173*/	{ "letter",  "0x0EC0", Token.UPTO, "0x0EC4" },
		/*174*/	{ "letter",  "0x0F40", Token.UPTO, "0x0F47" },
		/*175*/	{ "letter",  "0x0F49", Token.UPTO, "0x0F69" },
		/*176*/	{ "letter",  "0x10A0", Token.UPTO, "0x10C5" },
		/*177*/	{ "letter",  "0x10D0", Token.UPTO, "0x10F6" },
		/*178*/	{ "letter",  "0x1100" },
		/*179*/	{ "letter",  "0x1102", Token.UPTO, "0x1103" },
		/*180*/	{ "letter",  "0x1105", Token.UPTO, "0x1107" },
		/*181*/	{ "letter",  "0x1109" },
		/*182*/	{ "letter",  "0x110B", Token.UPTO, "0x110C" },
		/*183*/	{ "letter",  "0x110E", Token.UPTO, "0x1112" },
		/*184*/	{ "letter",  "0x113C" },
		/*185*/	{ "letter",  "0x113E" },
		/*186*/	{ "letter",  "0x1140" },
		/*187*/	{ "letter",  "0x114C" },
		/*188*/	{ "letter",  "0x114E" },
		/*189*/	{ "letter",  "0x1150" },
		/*190*/	{ "letter",  "0x1154", Token.UPTO, "0x1155" },
		/*191*/	{ "letter",  "0x1159" },
		/*192*/	{ "letter",  "0x115F", Token.UPTO, "0x1161" },
		/*193*/	{ "letter",  "0x1163" },
		/*194*/	{ "letter",  "0x1165" },
		/*195*/	{ "letter",  "0x1167" },
		/*196*/	{ "letter",  "0x1169" },
		/*197*/	{ "letter",  "0x116D", Token.UPTO, "0x116E" },
		/*198*/	{ "letter",  "0x1172", Token.UPTO, "0x1173" },
		/*199*/	{ "letter",  "0x1175" },
		/*200*/	{ "letter",  "0x119E" },
		/*201*/	{ "letter",  "0x11A8" },
		/*202*/	{ "letter",  "0x11AB" },
		/*203*/	{ "letter",  "0x11AE", Token.UPTO, "0x11AF" },
		/*204*/	{ "letter",  "0x11B7", Token.UPTO, "0x11B8" },
		/*205*/	{ "letter",  "0x11BA" },
		/*206*/	{ "letter",  "0x11BC", Token.UPTO, "0x11C2" },
		/*207*/	{ "letter",  "0x11EB" },
		/*208*/	{ "letter",  "0x11F0" },
		/*209*/	{ "letter",  "0x11F9" },
		/*210*/	{ "letter",  "0x1E00", Token.UPTO, "0x1E9B" },
		/*211*/	{ "letter",  "0x1EA0", Token.UPTO, "0x1EF9" },
		/*212*/	{ "letter",  "0x1F00", Token.UPTO, "0x1F15" },
		/*213*/	{ "letter",  "0x1F18", Token.UPTO, "0x1F1D" },
		/*214*/	{ "letter",  "0x1F20", Token.UPTO, "0x1F45" },
		/*215*/	{ "letter",  "0x1F48", Token.UPTO, "0x1F4D" },
		/*216*/	{ "letter",  "0x1F50", Token.UPTO, "0x1F57" },
		/*217*/	{ "letter",  "0x1F59" },
		/*218*/	{ "letter",  "0x1F5B" },
		/*219*/	{ "letter",  "0x1F5D" },
		/*220*/	{ "letter",  "0x1F5F", Token.UPTO, "0x1F7D" },
		/*221*/	{ "letter",  "0x1F80", Token.UPTO, "0x1FB4" },
		/*222*/	{ "letter",  "0x1FB6", Token.UPTO, "0x1FBC" },
		/*223*/	{ "letter",  "0x1FBE" },
		/*224*/	{ "letter",  "0x1FC2", Token.UPTO, "0x1FC4" },
		/*225*/	{ "letter",  "0x1FC6", Token.UPTO, "0x1FCC" },
		/*226*/	{ "letter",  "0x1FD0", Token.UPTO, "0x1FD3" },
		/*227*/	{ "letter",  "0x1FD6", Token.UPTO, "0x1FDB" },
		/*228*/	{ "letter",  "0x1FE0", Token.UPTO, "0x1FEC" },
		/*229*/	{ "letter",  "0x1FF2", Token.UPTO, "0x1FF4" },
		/*230*/	{ "letter",  "0x1FF6", Token.UPTO, "0x1FFC" },
		/*231*/	{ "letter",  "0x2126" },
		/*232*/	{ "letter",  "0x212A", Token.UPTO, "0x212B" },
		/*233*/	{ "letter",  "0x212E" },
		/*234*/	{ "letter",  "0x2180", Token.UPTO, "0x2182" },
		/*235*/	{ "letter",  "0x3041", Token.UPTO, "0x3094" },
		/*236*/	{ "letter",  "0x30A1", Token.UPTO, "0x30FA" },
		/*237*/	{ "letter",  "0x3105", Token.UPTO, "0x312C" },
		/*238*/	{ "letter",  "0xAC00", Token.UPTO, "0xD7A3" },
		// Ideographic
		/*239*/	{ "letter",  "0x4E00", Token.UPTO, "0x9FA5" },
		/*240*/	{ "letter",  "0x3007" },
		/*241*/	{ "letter",  "0x3021", Token.UPTO, "0x3029" },

		// helper rules

		/*242*/	{ "spaces", "spaces", "space" },
		/*243*/	{ "spaces", "space" },
			
		/*244*/	{ "digits",  "digits", "digit" },
		/*245*/	{ "digits",  "digit" },

		/*246*/	{ "hexdigits", "hexdigits", "hexdigit" },
		/*247*/	{ "hexdigits", "hexdigit" },

		/*248*/	{ "bnf_chardef", "\"'\"", "char", "\"'\"" },
		/*249*/	{ "bnf_chardef", "\"0x\"", "hexdigits" },
		/*250*/	{ "bnf_chardef", "\"0X\"", "hexdigits" },
		/*251*/	{ "bnf_chardef", "\"'\\''\"" },	// single quote
		/*252*/	{ "bnf_chardef", "\"'\\n'\"" },	// newline
		/*253*/	{ "bnf_chardef", "\"'\\r'\"" },	// carriage return
		/*254*/	{ "bnf_chardef", "\"'\\t'\"" },	// tabulator
		/*255*/	{ "bnf_chardef", "\"'\\f'\"" },	// formfeed
		/*256*/	{ "bnf_chardef", "\"'\\b'\"" },	// backspace
		/*257*/	{ "bnf_chardef", "\"'\\\\'\"" },	// backslash
		// bell \a was removed in favor of backslash and too much work re-numbering ...
		/*258*/	{ "bnf_chardef", "digits" },

		/*259*/	{ "identifier", "letter_or_uscore", "letter_or_digit_list_opt" },
		/*260*/	{ "letter_or_uscore", "letter" },
		/*261*/	{ "letter_or_uscore", "'_'" },
		/*262*/	{ "letter_or_digit", "letter_or_uscore" },
		/*263*/	{ "letter_or_digit", "digit" },
		/*264*/	{ "letter_or_digit_list", "letter_or_digit_list", "letter_or_digit" },
		/*265*/	{ "letter_or_digit_list", "letter_or_digit" },
		/*266*/	{ "letter_or_digit_list_opt", "letter_or_digit_list" },
		/*267*/	{ "letter_or_digit_list_opt" /*nothing*/ },

		/*268*/	{ "stringdef", "'\"'", "stringpart_list_opt", "'\"'" },
		/*269*/	{ "char_minus_doublequote_list", "char_minus_doublequote_list", "char_minus_doublequote" },
		/*270*/	{ "char_minus_doublequote_list", "char_minus_doublequote" },
		/*271*/	{ "char_minus_doublequote", "char", Token.BUTNOT, "'\"'", Token.BUTNOT, "'\\'" },	// does not contain " or \
		/*272*/	{ "char_minus_doublequote_list_opt", "char_minus_doublequote_list" },
		/*273*/	{ "char_minus_doublequote_list_opt" /*nothing*/ },
		/*274*/	{ "backslash_char_list", "backslash_char_list", "backslash_char" },
		/*275*/	{ "backslash_char_list", "backslash_char" },
		/*276*/	{ "backslash_char", "'\\'", "char" },	// escaped character like "\""
		/*277*/	{ "backslash_char_list_opt", "backslash_char_list" },
		/*278*/	{ "backslash_char_list_opt" /*nothing*/ },
		/*279*/	{ "stringpart", "char_minus_doublequote_list_opt", "backslash_char_list_opt" },  
		/*280*/	{ "stringpart_list", "stringpart_list", "stringpart" },
		/*281*/	{ "stringpart_list", "stringpart" },
		/*282*/	{ "stringpart_list_opt", "stringpart_list" },
		/*283*/	{ "stringpart_list_opt" /*nothing*/ },

		/*284*/	{ "cstylecomment",  "\"/*\"", "char_minus_star_slash_list_opt", "\"*/\"" },
		/*285*/	{ "char_minus_star_slash", "char", Token.BUTNOT, "\"*/\"" },
		/*286*/	{ "char_minus_star_slash_list", "char_minus_star_slash_list", "char_minus_star_slash" },
		/*287*/	{ "char_minus_star_slash_list", "char_minus_star_slash" },
		/*288*/	{ "char_minus_star_slash_list_opt", "char_minus_star_slash_list" },
		/*289*/	{ "char_minus_star_slash_list_opt" /*nothing*/ },

		/*290*/	{ "cstylecomment",  "\"//\"", "char_minus_newline_list_opt" },
		/*291*/	{ "char_minus_newline", "char", Token.BUTNOT, "newline" },
		/*292*/	{ "char_minus_newline_list", "char_minus_newline_list", "char_minus_newline" },
		/*293*/	{ "char_minus_newline_list", "char_minus_newline" },
		/*294*/	{ "char_minus_newline_list_opt", "char_minus_newline_list" },
		/*295*/	{ "char_minus_newline_list_opt" /*nothing*/ },
		/*296*/	{ "shellstylecomment",  "'#'", "char_minus_newline_list_opt" },

		/*297*/	{ "ruleref", "'"+Token.COMMAND_QUOTE+"'", "identifier", "'"+Token.COMMAND_QUOTE+"'" },
		/*298*/	{ Token.TOKEN, "ruleref" },

		/*299*/	{ "comment", "cstylecomment" },
		/*300*/	{ "comment", "shellstylecomment" },
	};

	/** XML Char definitions of W3C. */
	public static final String [][] xmlCharRules = {
		/*0*/	{	"xmlchar", "0x9" },
		/*1*/	{	"xmlchar", "0xA" },
		/*2*/	{	"xmlchar", "0xD" },
		/*3*/	{	"xmlchar", "0x20", Token.UPTO, "0xD7FF" },
		/*4*/	{	"xmlchar", "0xE000", Token.UPTO, "0xFFFD" },
		/*5*/	{	"xmlchar", "0x10000", Token.UPTO, "0x10FFFF" },
	};
	
	/** XML CombiningChar and XML Extender definitions of W3C. */
	public static final String [][] xmlCombinigAndExtenderRules = {
		/*0*/	{	"combiningchar", "0x0300", Token.UPTO, "0x0345" },
		/*1*/	{	"combiningchar", "0x0360", Token.UPTO, "0x0361" },
		/*2*/	{	"combiningchar", "0x0483", Token.UPTO, "0x0486" },
		/*3*/	{	"combiningchar", "0x0591", Token.UPTO, "0x05A1" },
		/*4*/	{	"combiningchar", "0x05A3", Token.UPTO, "0x05B9" },
		/*5*/	{	"combiningchar", "0x05BB", Token.UPTO, "0x05BD" },
		/*6*/	{	"combiningchar", "0x05BF" },
		/*7*/	{	"combiningchar", "0x05C1", Token.UPTO, "0x05C2" },
		/*8*/	{	"combiningchar", "0x05C4" },
		/*9*/	{	"combiningchar", "0x064B", Token.UPTO, "0x0652" },
		/*10*/	{	"combiningchar", "0x0670" },
		/*11*/	{	"combiningchar", "0x06D6", Token.UPTO, "0x06DC" },
		/*12*/	{	"combiningchar", "0x06DD", Token.UPTO, "0x06DF" },
		/*13*/	{	"combiningchar", "0x06E0", Token.UPTO, "0x06E4" },
		/*14*/	{	"combiningchar", "0x06E7", Token.UPTO, "0x06E8" },
		/*15*/	{	"combiningchar", "0x06EA", Token.UPTO, "0x06ED" },
		/*16*/	{	"combiningchar", "0x0901", Token.UPTO, "0x0903" },
		/*17*/	{	"combiningchar", "0x093C" },
		/*18*/	{	"combiningchar", "0x093E", Token.UPTO, "0x094C" },
		/*19*/	{	"combiningchar", "0x094D" },
		/*20*/	{	"combiningchar", "0x0951", Token.UPTO, "0x0954" },
		/*21*/	{	"combiningchar", "0x0962", Token.UPTO, "0x0963" },
		/*22*/	{	"combiningchar", "0x0981", Token.UPTO, "0x0983" },
		/*23*/	{	"combiningchar", "0x09BC" },
		/*24*/	{	"combiningchar", "0x09BE" },
		/*25*/	{	"combiningchar", "0x09BF" },
		/*26*/	{	"combiningchar", "0x09C0", Token.UPTO, "0x09C4" },
		/*27*/	{	"combiningchar", "0x09C7", Token.UPTO, "0x09C8" },
		/*28*/	{	"combiningchar", "0x09CB", Token.UPTO, "0x09CD" },
		/*29*/	{	"combiningchar", "0x09D7" },
		/*30*/	{	"combiningchar", "0x09E2", Token.UPTO, "0x09E3" },
		/*31*/	{	"combiningchar", "0x0A02" },
		/*32*/	{	"combiningchar", "0x0A3C" },
		/*33*/	{	"combiningchar", "0x0A3E" },
		/*34*/	{	"combiningchar", "0x0A3F" },
		/*35*/	{	"combiningchar", "0x0A40", Token.UPTO, "0x0A42" },
		/*36*/	{	"combiningchar", "0x0A47", Token.UPTO, "0x0A48" },
		/*37*/	{	"combiningchar", "0x0A4B", Token.UPTO, "0x0A4D" },
		/*38*/	{	"combiningchar", "0x0A70", Token.UPTO, "0x0A71" },
		/*39*/	{	"combiningchar", "0x0A81", Token.UPTO, "0x0A83" },
		/*40*/	{	"combiningchar", "0x0ABC" },
		/*41*/	{	"combiningchar", "0x0ABE", Token.UPTO, "0x0AC5" },
		/*42*/	{	"combiningchar", "0x0AC7", Token.UPTO, "0x0AC9" },
		/*43*/	{	"combiningchar", "0x0ACB", Token.UPTO, "0x0ACD" },
		/*44*/	{	"combiningchar", "0x0B01", Token.UPTO, "0x0B03" },
		/*45*/	{	"combiningchar", "0x0B3C" },
		/*46*/	{	"combiningchar", "0x0B3E", Token.UPTO, "0x0B43" },
		/*47*/	{	"combiningchar", "0x0B47", Token.UPTO, "0x0B48" },
		/*48*/	{	"combiningchar", "0x0B4B", Token.UPTO, "0x0B4D" },
		/*49*/	{	"combiningchar", "0x0B56", Token.UPTO, "0x0B57" },
		/*50*/	{	"combiningchar", "0x0B82", Token.UPTO, "0x0B83" },
		/*51*/	{	"combiningchar", "0x0BBE", Token.UPTO, "0x0BC2" },
		/*52*/	{	"combiningchar", "0x0BC6", Token.UPTO, "0x0BC8" },
		/*53*/	{	"combiningchar", "0x0BCA", Token.UPTO, "0x0BCD" },
		/*54*/	{	"combiningchar", "0x0BD7" },
		/*55*/	{	"combiningchar", "0x0C01", Token.UPTO, "0x0C03" },
		/*56*/	{	"combiningchar", "0x0C3E", Token.UPTO, "0x0C44" },
		/*57*/	{	"combiningchar", "0x0C46", Token.UPTO, "0x0C48" },
		/*58*/	{	"combiningchar", "0x0C4A", Token.UPTO, "0x0C4D" },
		/*59*/	{	"combiningchar", "0x0C55", Token.UPTO, "0x0C56" },
		/*60*/	{	"combiningchar", "0x0C82", Token.UPTO, "0x0C83" },
		/*61*/	{	"combiningchar", "0x0CBE", Token.UPTO, "0x0CC4" },
		/*62*/	{	"combiningchar", "0x0CC6", Token.UPTO, "0x0CC8" },
		/*63*/	{	"combiningchar", "0x0CCA", Token.UPTO, "0x0CCD" },
		/*64*/	{	"combiningchar", "0x0CD5", Token.UPTO, "0x0CD6" },
		/*65*/	{	"combiningchar", "0x0D02", Token.UPTO, "0x0D03" },
		/*66*/	{	"combiningchar", "0x0D3E", Token.UPTO, "0x0D43" },
		/*67*/	{	"combiningchar", "0x0D46", Token.UPTO, "0x0D48" },
		/*68*/	{	"combiningchar", "0x0D4A", Token.UPTO, "0x0D4D" },
		/*69*/	{	"combiningchar", "0x0D57" },
		/*70*/	{	"combiningchar", "0x0E31" },
		/*71*/	{	"combiningchar", "0x0E34", Token.UPTO, "0x0E3A" },
		/*72*/	{	"combiningchar", "0x0E47", Token.UPTO, "0x0E4E" },
		/*73*/	{	"combiningchar", "0x0EB1" },
		/*74*/	{	"combiningchar", "0x0EB4", Token.UPTO, "0x0EB9" },
		/*75*/	{	"combiningchar", "0x0EBB", Token.UPTO, "0x0EBC" },
		/*76*/	{	"combiningchar", "0x0EC8", Token.UPTO, "0x0ECD" },
		/*77*/	{	"combiningchar", "0x0F18", Token.UPTO, "0x0F19" },
		/*78*/	{	"combiningchar", "0x0F35" },
		/*79*/	{	"combiningchar", "0x0F37" },
		/*80*/	{	"combiningchar", "0x0F39" },
		/*81*/	{	"combiningchar", "0x0F3E" },
		/*82*/	{	"combiningchar", "0x0F3F" },
		/*83*/	{	"combiningchar", "0x0F71", Token.UPTO, "0x0F84" },
		/*84*/	{	"combiningchar", "0x0F86", Token.UPTO, "0x0F8B" },
		/*85*/	{	"combiningchar", "0x0F90", Token.UPTO, "0x0F95" },
		/*86*/	{	"combiningchar", "0x0F97" },
		/*87*/	{	"combiningchar", "0x0F99", Token.UPTO, "0x0FAD" },
		/*88*/	{	"combiningchar", "0x0FB1", Token.UPTO, "0x0FB7" },
		/*89*/	{	"combiningchar", "0x0FB9" },
		/*90*/	{	"combiningchar", "0x20D0", Token.UPTO, "0x20DC" },
		/*91*/	{	"combiningchar", "0x20E1" },
		/*92*/	{	"combiningchar", "0x302A", Token.UPTO, "0x302F" },
		/*93*/	{	"combiningchar", "0x3099" },
		/*94*/	{	"combiningchar", "0x309A" },

		/*95*/	{	"extenderchar", "0x00B7" },
		/*96*/	{	"extenderchar", "0x02D0" },
		/*97*/	{	"extenderchar", "0x02D1" },
		/*98*/	{	"extenderchar", "0x0387" },
		/*99*/	{	"extenderchar", "0x0640" },
		/*100*/	{	"extenderchar", "0x0E46" },
		/*101*/	{	"extenderchar", "0x0EC6" },
		/*102*/	{	"extenderchar", "0x3005" },
		/*103*/	{	"extenderchar", "0x3031", Token.UPTO, "0x3035" },
		/*104*/	{	"extenderchar", "0x309D", Token.UPTO, "0x309E" },
		/*105*/	{	"extenderchar", "0x30FC", Token.UPTO, "0x30FE" },
	};


	/** Numerical rules for binary and octal <b>digits</b>. */
	public static final String [][] digitRules = {
		/*0*/	{ "octdigit", "'0'", Token.UPTO, "'7'" },
		/*1*/	{ "octdigits", "octdigits", "octdigit" },
		/*2*/	{ "octdigits", "octdigit" },

		/*3*/	{ "bindigit", "'0'", Token.UPTO, "'1'" },
		/*4*/	{ "bindigits", "bindigits", "bindigit" },
		/*5*/	{ "bindigits", "bindigit" },
	};

	/** Numerical rules for <b>numbers</b> within sourcecode: number ::= integer | float. */
	public static final String [][] numberRules = {
		// number = float | integer (incl. hexnumber)
		/*0*/	{ "number", "float" },
		/*1*/	{ "number", "integer" },
		/*2*/	{ "float", "wholenumber", "'.'", "mantissa", "float_opt" },
		/*3*/	{ "wholenumber", "digits" },
		/*4*/	{ "wholenumber" /*nothing*/ },
		/*5*/	{ "mantissa", "digits", "mantissa_opt" },
		/*6*/	{ "mantissa_opt", "exponent", "digits" },
		/*7*/	{ "mantissa_opt" /*nothing*/ },
		/*8*/	{ "exponent", "exponentletter", "exponentsign" },
		/*9*/	{ "exponentletter", "'e'" },
		/*10*/	{ "exponentletter", "'E'" },
		/*11*/	{ "exponentsign", "'-'" },
		/*12*/	{ "exponentsign", "'+'" },
		/*13*/	{ "exponentsign" /*nothing*/ },
		/*14*/	{ "float_opt", "'f'" },
		/*15*/	{ "float_opt", "'F'" },
		/*16*/	{ "float_opt", "'d'" },
		/*17*/	{ "float_opt", "'D'" },
		/*18*/	{ "float_opt" /*nothing*/ },
		/*19*/	{ "integer", "\"0X\"", "hexdigits" },
		/*20*/	{ "integer", "\"0x\"", "hexdigits" },
		/*21*/	{ "integer", "digits", "integer_opt" },
		/*22*/	{ "integer_opt", "'l'" },	// "long" marker
		/*23*/	{ "integer_opt", "'L'" },	// "long" marker
		/*24*/	{ "integer_opt" /*nothing*/ },
	};
	
	/** Rules describing one or more newlines. */
	public static final String [][] newlinesRules = {
		{ "newlines", "newlines", "newline" },
		{ "newlines", "newline" },
	};
	
	/** Rules describing C/Java-like character definitions: 'c', '\r', '\007'. */
	public static final String [][] chardefRules = {
		/*0*/	{ "chardef", "\"'\\\"", "'0'", Token.UPTO, "'3'", "octdigit", "octdigit", "\"'\"" },
		/*1*/	{ "chardef", "bnf_chardef" },	// but only 248 and 251 - 258 !!!
	};
	
	/** Rules describing whitespace: newlines and spaces, minimum one. */
	public static final String [][] whitespaceRules = {
		/*0*/	{ "whitespace", "newline" },
		/*1*/	{ "whitespace", "space" },
		/*2*/	{ "whitespaces", "whitespaces", "whitespace" },
		/*3*/	{ "whitespaces", "whitespace" },
	};
	

	private StandardLexerRules()	{}

}
