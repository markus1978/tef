package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
	Lexer result tree element, holding texts, its line/column range, and result children.
	
	@author Fritz Ritzberger, 2003
*/

public class ResultTree
{
	private Rule rule;
	private List sequenceList;
	private Token.Range range;
	private StringBuffer buffer;
	private String stringResult;
	
	ResultTree(Rule rule)	{
		this.rule = rule;
	}
	
	/** Returns the character- or byte-range within input where the token was found. */
	public Token.Range getRange()	{
		return range;
	}
	
	void setRange(Token.Range range)	{
		this.range = range;
	}
	
	/** Returns true if this ResultTree or any of its children has text. */
	public boolean hasText()	{
		for (int i = 0; sequenceList != null && i < sequenceList.size(); i++)	{
			Object o = sequenceList.get(i);
			if (o instanceof ResultTree == false)
				return true;	// StringBuffer was allocated with minimum one char
			else
			if (((ResultTree)o).hasText())
				return true;
		}
		return false;
	}
	
	/** Returns the String text of this ResultTree, including any text of its children. */
	public String toString()	{
		if (stringResult == null)	{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; sequenceList != null && i < sequenceList.size(); i++)	{
				Object o = sequenceList.get(i);
				if (o instanceof ResultTree)
					sb.append(((ResultTree)o).toString());
				else
					sb.append(o.toString());
					// since JDK 1.4: sb.append((StringBuffer) o);	// is faster than o.toString()
			}
			stringResult = sb.toString();
		}
		return stringResult;
	}
	
	/** Returns the rule this ResultTree was built from. */ 
	public Rule getRule()	{
		return rule;
	}

	/** Returns the child at index i of this element, which could be StringBuffer or ResultTree. */
	public Object getChild(int i)	{
		Object o = sequenceList.get(i);
		return o instanceof StringBuffer ? o.toString() : o;	// avoid StringBuffer.append calls
	}

	/** Returns the count of children of this element. */
	public int getChildCount()	{
		return sequenceList != null ? sequenceList.size() : 0;
	}

	ResultTree append(char c)	{
		ensureStringBuffer(null).append(c);
		return this;
	}

	ResultTree append(String s)	{
		ensureStringBuffer(s);
		return this;
	}

	ResultTree addChild(ResultTree r)	{
		if (r.hasText())	{
			ensureSequenceList().add(r);
			buffer = null;	// force new list element
		}
		return this;
	}

	private List ensureSequenceList()	{
		if (sequenceList == null)
			sequenceList = new ArrayList(rule != null ? rule.rightSize() : 1);
		return sequenceList;
	}

	private StringBuffer ensureStringBuffer(String toStore)	{
		if (buffer == null)	{
			if (toStore == null)
				buffer = new StringBuffer(8);
			else
				buffer = new StringBuffer(toStore);
			ensureSequenceList().add(buffer);
		}
		else
		if (toStore != null)	{
			buffer.append(toStore);
		}
		return buffer;
	}

}
