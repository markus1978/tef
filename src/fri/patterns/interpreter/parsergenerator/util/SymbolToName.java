package fri.patterns.interpreter.parsergenerator.util;

import fri.patterns.interpreter.parsergenerator.Token;

/**
	The contained methods are needed to generate nonterminal names for spawned rules,
	e.g. for a repeatable nullable rule "(a | b | c)" from the rule "e ::= (a | b | c)* d;".

	@author (c) 2000, Fritz Ritzberger
*/

public abstract class SymbolToName
{
	/**
		Converts the passed character sequence (symbol) to a name that can be used as identifier (but not as Java identifier).
		If enclosing quotes are found, they will be substituted by "_".
		@param symbol character sequence to be converted to identifier
	*/
	public static String makeIdentifier(String symbol)	{
		return makeIdentifier(symbol, false);
	}
	
	/**
		Converts the passed character sequence (symbol) to a name that can be used as identifier, optionally as Java identifier.
		If enclosing quotes are found, they will be substituted by "_".
		@param symbol character sequence to be converted to identifier
		@param startIsSignificant when true a Java identifier is produced
	*/
	public static String makeIdentifier(String symbol, boolean startIsSignificant)	{
		return makeIdentifier(symbol, "_", startIsSignificant);
	}
	
	/**
		Converts the passed character sequence (symbol) to a name that can be used as identifier (but not as Java identifier).
		If enclosing quotes are found, they will be substituted by passed substitute string.
		@param symbol character sequence to be converted to identifier
		@param enclosingQuoteSubstitute the string to be used for enclosing quotes
	*/
	public static String makeIdentifier(String symbol, String enclosingQuoteSubstitute)	{
		return makeIdentifier(symbol, enclosingQuoteSubstitute, false);
	}
	
	/**
		Converts the passed character sequence (symbol) to a name that can be used as identifier, optionally as Java identifier.
		If enclosing quotes are found, they will be substituted by passed substitute string.
		@param symbol character sequence to be converted to identifier
		@param enclosingQuoteSubstitute the string to be used for enclosing quotes
		@param startIsSignificant when true a Java identifier is produced
	*/
	public static String makeIdentifier(String symbol, String enclosingQuoteSubstitute, boolean startIsSignificant)	{
		if (symbol.equals(Token.UPTO))
			return "upto";
			
		StringBuffer sb = new StringBuffer();
		int len = symbol.length();
		
		for (int i = 0; i < len; i++)	{
			char c = symbol.charAt(i);

			if (c == '_' && (len == 1 || len == 3 && i == 1 && sb.length() > 0 && sb.charAt(0) == '_') ||
					startIsSignificant && i == 0 && (c == '$' || !Character.isJavaIdentifierStart(c)) ||
					(c == '$' || !Character.isJavaIdentifierPart(c)))
			{
				if ((i == 0 || i == len - 1) && (c == '\'' || c == '"' || c == '`'))
					sb.append(enclosingQuoteSubstitute);
				else
					sb.append(convert(c));
			}
			else	{
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	

	/** Returns a symbolic name for passed symbol, e.g. "lparen" for "(". */
	public static String convert(char c)	{
		if (c == ':')
			return "colon";
		if (c == ';')
			return "semicol";
		if (c == '.')
			return "dot";
		if (c == ',')
			return "comma";
		if (c == '?')
			return "quest";
		if (c == '!')
			return "call";
		if (c == '@')
			return "at";
		if (c == '_')
			return "uscore";
		if (c == '<')
			return "less";
		if (c == '=')
			return "equal";
		if (c == '>')
			return "greater";
		if (c == '-')
			return "minus";
		if (c == '+')
			return "plus";
		if (c == '/')
			return "slash";
		if (c == '*')
			return "star";
		if (c == '#')
			return "nr";
		if (c == '~')
			return "tilde";
		if (c == '$')
			return "dollar";
		if (c == '%')
			return "perct";
		if (c == '&')
			return "ampers";
		if (c == '(')
			return "lparen";
		if (c == '{')
			return "lbrace";
		if (c == '[')
			return "lbrack";
		if (c == ')')
			return "rparen";
		if (c == '}')
			return "rbrace";
		if (c == ']')
			return "rbrack";
		if (c == '\\')
			return "bslash";
		if (c == '|')
			return "or";
		if (c == '&')
			return "and";
		if (c == '^')
			return "caret";
		if (c == '"')
			return "dquote";
		if (c == '\'')
			return "quote";
		if (c == '`')
			return "bquote";
		if (c >= '0' && c <= '9')
			return ""+c;
		return "_";	// default
	}
	
	
	private SymbolToName()	{}	// do not instantiate
}
	
	