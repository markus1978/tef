package fri.patterns.interpreter.parsergenerator;

/**
	Lexer-Parser communication struct. Utility methods defining EPSILON and terminals.
	Definition of all global constants for parsergenerator packages.
	<p>
	This class defines special token identifiers: "token" (<i>Token.TOKEN</i>) and
	"ignored" (<i>Token.IGNORED</i>), which are needed when specifiying a syntax with
	mixed parser and lexer rules.
	<p>
	This class defines special symbols needed to define character sets with <i>Token.UPTO</i>
	(e.g. A..Z) and intersections with <i>Token.BUTNOT</i> (e.g. `char` - `newline`).
	
	@author (c) 2000, Fritz Ritzberger
*/

public class Token
{
	/** This special token symbol means "end of input" to the Parser, which stops calling <i>getNextToken()</i> then. */
	public static final String EPSILON = "\"EoI\"";

	/** Delimiter for literal terminals. */
	public static final char STRING_QUOTE = '"';

	/** Delimiter for literal terminal. */
	public static final char CHAR_QUOTE = '\'';

	/** Delimiter for lexer rules (terminal). */
	public static final char COMMAND_QUOTE = '`';

	/** Symbol used to define lexer character sets, e.g. <i>a..z</i>. */
	public static final String UPTO = "..";

	/** Symbol used to define lexer character set intersections, e.g. <i>char - "/*" - "//"</i>. */
	public static final String BUTNOT = "-";

	/** Reserved identifier that marks nonterminals the lexer should deliver to parser. */
	public static final String TOKEN = "token";
	
	/** Reserved identifier that marks tokens not to deliver to parser, e.g. <i>ignored ::= spaces ;</i>. */
	public static final String IGNORED = "ignored";
	
	/** The character used to mark artificial nonterminal (e.g. made from "prolog?"). Every artificial rule starts with it. */
	public static final String ARTIFICIAL_NONTERMINAL_START_CHARACTER = "_";
	
	/** The syntax symbol this Token represents. */
	public final String symbol;
	/** The text that was scanned for this Token. */
	public final Object text;
	/** The start and end Address of this Token. */
	public final Range range;


	/** Address stores input line number (1-n), column (0-n) and character/byte offset (0-n). */
	public static class Address implements Comparable
	{
		/** The line number (1-n). */
		public final int line;
		/** The column number (0-n). */
		public final int column;
		/** The character/byte offset (0-n). */
		public final int offset;
		
		public Address()	{
			this(1, 0, 0);
		}
		public Address(int line, int column, int offset)	{
			this.line = line;
			this.column = column;
			this.offset = offset;
		}
		public String toString()	{
			return line+"/"+column;
		}
		public boolean equals(Object o)	{
			return offset == ((Address) o).offset;
		}
		public int hashCode()	{
			return offset;
		}
		public int compareTo(Object o) {
			return offset - ((Address) o).offset;
		}
	}

	/** Range stores start and end Address of a token. */
	public static class Range implements Comparable
	{
		/** The start Address of this Token, pointing to the first character/byte. */
		public final Address start;
		/** The end Address of this Token, one after the last character/byte. */
		public final Address end;
		
		public Range(Address start, Address end)	{
			this.start = start != null ? start : new Address();
			this.end = end != null ? end : new Address();
		}
		public boolean equals(Object o)	{
			return start.equals(((Range) o).start) && end.equals(((Range) o).end);
		}
		public int hashCode()	{
			return start.hashCode() + end.hashCode();
		}
		public String toString()	{
			return start+"-"+end;
		}
		public int compareTo(Object o) {
			return start.compareTo(((Range) o).start) + end.compareTo(((Range) o).end);
		}
	}


	public Token(String symbol, Object text, Range range)	{
		this.symbol = symbol;
		this.text = text;
		this.range = range;
	}

	/**
		Epsilon means end of input, EOF, no more bytes available.
		@return true if passed token is the EPSILON-symbol.
	*/
	public static boolean isEpsilon(Token token)	{
		return isEpsilon(token.symbol);
	}

	/**
		Epsilon means end of input, no more bytes available.
		@return true if Token symbol not null and is the EPSILON-symbol.
	*/
	public static boolean isEpsilon(String symbol)	{
		return symbol != null && symbol == EPSILON;
	}

	/**
		Distinction of 'terminals' and nonterminals:
		terminals are either starting with digit or are enclosed in quotes '"` or equal to EPSILON.
	*/
	public static boolean isTerminal(String symbol)	{
		char c = symbol.charAt(0);
		return
				c == STRING_QUOTE ||
				c == CHAR_QUOTE ||
				c == COMMAND_QUOTE ||
				Character.isDigit(c) ||
				Token.isEpsilon(symbol);
	}

}