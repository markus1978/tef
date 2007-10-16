package hub.sam.tef.rcc.syntax;

import hub.sam.tef.rcc.Token;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
	A rule is a list of String symbols on the right side
	and a nonterminal on the left side: "a ::= b c d;"
	A nonterminal is represented as a String with no quotes,
	every terminal must appear quoted by " or ' or ` (backquote).
	
	@author (c) 2004 Fritz Ritzberger
*/

public class Rule implements Serializable
{
	
	public static boolean isScanTerminal(String symbol) {
		return symbol.charAt(0) == Token.COMMAND_QUOTE;
	}
	public static boolean isTerminal(String symbol) {
		return symbol.charAt(0) == Token.COMMAND_QUOTE || symbol.charAt(0) == Token.CHAR_QUOTE ||
				symbol.charAt(0) == Token.STRING_QUOTE;
	}
	
	private List<String> symbols;

	/** Source generator constructor. */
	public Rule(String nonterminal, int rightSize)	{
		this(new ArrayList<String>(rightSize + 1));
		symbols.add(nonterminal);
	}

	/** Constructing a rule from a String array, first element is interpreted as nonterminal. */
	public Rule(String [] symbols)	{
		this(SyntaxUtil.ruleToList(symbols));
	}

	/** Constructing a rule from a String List, first element is interpreted as nonterminal. */
	public Rule(List<String> symbols)	{
		if (symbols == null)
			throw new IllegalArgumentException("Can not construct rule without nonterminal: "+symbols);
		this.symbols = symbols;
	}

	/** Serializable constructor, do not use. */
	protected Rule()	{
	}


	public String getNonterminal()	{
		return (String) symbols.get(0);
	}
	
	public int rightSize()	{
		return symbols.size() - 1;
	}
	
	public String getRightSymbol(int i)	{
		return (String) symbols.get(i + 1);
	}
	
	public void setRightSymbol(String symbol, int i)	{
		symbols.set(i + 1, symbol);
	}
	
	public void addRightSymbol(String symbol)	{
		symbols.add(symbol);
	}
	
	public int indexOnRightSide(String symbol)	{
		for (int i = 0; i < rightSize(); i++)
			if (getRightSymbol(i).equals(symbol))
				return i;
		return -1;
	}


	/** Returns true if symbol lists are equal. */
	public boolean equals(Object o)	{
		return ((Rule)o).symbols.equals(symbols);
	}
	
	/** Returns symbol lists hashcode. */
	public int hashCode()	{
		return symbols.hashCode();
	}
	
	/** Returns the syntax as a multiline string. */
	public String toString()	{
		StringBuffer sb = new StringBuffer(getNonterminal()+" ::= ");
		for (int i = 0; i < rightSize(); i++)	{
			sb.append(getRightSymbol(i));
			sb.append(" ");
		}
		sb.append(";");
		return sb.toString();
	}

}
