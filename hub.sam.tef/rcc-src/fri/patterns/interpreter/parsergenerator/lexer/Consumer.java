package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.*;
import java.io.IOException;
import java.io.Serializable;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
	Consuming characters (or bytes) means reading from an input stream as long
	as the read characters match the pattern the consumer was built for.
	A consumer can be built with a fixed string, a character set, other
	character consumers, or a mixed sequence of those. It can be a list of
	alternating (parallel) consumers. It can be set repeatable and nullable.
	A character consumer succeeds when he could apply all consumers or
	patterns/sets stored in its sequence when reading input. It fails and
	unreads all characters when one non-nullable consumer in its sequence fails.
	
	@author (c) 2002, Fritz Ritzberger
*/

class Consumer implements
	Comparable,
	Serializable
{
	private List sequence = new ArrayList();
	private List constraints;
	private boolean nullable = false;
	private boolean repeatable = false;
	protected Rule rule;
	protected int fixedLength = -1, startLength = -1, variance = -1;
	
	
	/** Empty consumer knowing its rule. This could become a Lexer toplevel consumer. */
	Consumer(Rule rule)	{
		this.rule = rule;
	}

	/** Consumer with some start character or fixed string, without rule. */
	Consumer(String charOrString)	{
		append(charOrString);
	}

	/** Internal constructor needed in LexerBuilder. */
	protected Consumer()	{
	}


	/** Append a String or character to sequence. */
	public void append(String charOrString)	{
		Object o = sequence.size() > 0 ? sequence.get(sequence.size() - 1) : null;	// check preceding
		if (o instanceof String)	{	// has a string preceding
			String s = (String)o;
			s = s + charOrString;	// append to it
			sequence.set(sequence.size() - 1, s);
		}
		else	{
			sequence.add(charOrString);
		}
	}

	/** Add a character consumer reference. */
	public void append(Reference subConsumer)	{
		sequence.add(subConsumer);
	}

	/** Add a character consumer. */
	public void append(Consumer subConsumer)	{
		sequence.add(subConsumer);
	}

	/** Add a character set by its high character. Low character is previously appended one. */
	public void appendSet(String high)
		throws LexerException
	{
		String low = (String) sequence.get(sequence.size() - 1);	// throws ClassCastException if not String
		if (low.length() > 1)	{	// low character was appended to previous string
			int i = low.length() - 1;
			sequence.set(sequence.size() - 1, low.substring(0, i));	// cut last character
			sequence.add(new CharacterSet(""+low.charAt(i), high));	// append set
		}
		else	{
			sequence.set(sequence.size() - 1, new CharacterSet(low, high));
		}
	}

	/** Passed Consumer will constrain every character of this consumer. */
	public void subtract(Consumer constraint)	{
		if (constraints == null)
			constraints = new ArrayList();
		constraints.add(constraint);
	}
	
	/** Passed reference will constrain every character of this consumer. */
	public void subtract(Reference constraint)	{
		if (constraints == null)
			constraints = new ArrayList();
		constraints.add(constraint);
	}
	

	/** Resolve all references to real consumers after build. */
	public void resolveConsumerReferences(Map charConsumers, Map doneList)
		throws LexerException
	{
		if (doneList.get(this) != null)
			return;
		doneList.put(this, this);
		
		List [] varr = new List[] { sequence, getAlternatives(), constraints };
		for (int j = 0; j < varr.length; j++)	{
			List v = varr[j];
			
			if (v != null)	{
				for (int i = 0; v != null && i < v.size(); i++)	{
					Object o = v.get(i);
					
					if (o instanceof Reference)	{
						//System.err.println("Found consumer reference "+o+" within "+rule);
						Reference cr = (Reference)o;
						Object cc = charConsumers.get(cr.nonterminal);
						
						if (cc == null)
							throw new LexerException("Consumer-Reference not found: "+cr.nonterminal);
						
						v.set(i, cc);
					}
					else
					if (o instanceof Consumer)	{
						Consumer cc = (Consumer)o;
						cc.resolveConsumerReferences(charConsumers, doneList);
					}
				}
			}
		}
	}
	
	
	public void setNullable()	{
		nullable = true;
	}
	
	public boolean isNullable()	{
		return nullable;
	}
	
	public void setRepeatable()	{
		repeatable = true;
	}
	
	public boolean isRepeatable()	{
		return repeatable;
	}

	/** Always returns null as this consumer holds no alternatives. */
	public List getAlternatives()	{
		return null;
	}
	
	
	/** Implements Comparable: Sort alternatives by precedence: - getStartVariance(), + getStartLength(), + getFixedLength(). */
	public int compareTo(Object o)	{
		Consumer cc = (Consumer)o;
		int i;
		i = getStartVariance() - cc.getStartVariance();	// be as exact as possible
		if (i != 0)
			return i;
		i = cc.getStartLength() - getStartLength();	// be as significant as possible
		if (i != 0)
			return i;
		i = cc.getFixedLength() - getFixedLength();	// be long as possible
		if (i != 0)
			return i;
		return 0;
	}

	/** Returns the first character of this consumer, or null if starting with a set. */
	public Character getStartCharacter()	{
		Object o = sequence.get(0);
		//System.err.println("getStartCharacter from sequence "+o);
		if (o instanceof Consumer)
			return ((Consumer)o).getStartCharacter();
		else
		if (o instanceof CharacterSet)
			return null;
		else
			return new Character(((String)o).charAt(0));
	}
	

	/** Returns the count of possible start characters. For fixed start character this is 1. */
	public int getStartVariance()	{
		if (this.variance > 0)
			return this.variance;
			
		if (getStartCharacter() != null)
			return this.variance = 1;

		int variance;
		Object o = sequence.get(0);
		if (o instanceof Consumer)
			variance = ((Consumer)o).getStartVariance();
		else
		if (o instanceof CharacterSet)
			variance = ((CharacterSet)o).getVariance();
		else
			throw new IllegalStateException("No fixed start character, no character set, where am i?");
			
		for (int i = 0; constraints != null && i < constraints.size(); i++)
			variance -= ((Consumer) constraints.get(i)).getStartVariance();
			
		return this.variance = variance;
	}
	
	/** The fixed length ends before the first found character set (like "0..9") or repeatable or nullable consumer. */
	public int getFixedLength()	{
		if (fixedLength >= 0)	// never call toString() before all sequences have arrived
			return fixedLength;
		fixedLength = getSomeLength(false, new ArrayList());
		return fixedLength;
	}
	
	/** The start length ends before the first found repeatable or nullable consumer (like "chars*"), but not before a character set. */
	public int getStartLength()	{
		if (startLength >= 0)	// never call toString() before all sequences have arrived
			return startLength;
		List reason = new ArrayList();
		startLength = getSomeLength(true, reason);
		//System.err.println("found start length "+startLength+" for rule "+rule+", sequence "+sequence+", reason "+reason);
		return startLength;
	}


	protected int getSomeLength(boolean exploreStartLength, List breakIndicator)	{
		int len = 0;
		
		for (int i = 0; breakIndicator.size() <= 0 && i < sequence.size(); i++)	{
			Object o = sequence.get(i);
			
			if (o instanceof Consumer)	{
				Consumer cc = (Consumer)o;

				if (cc.isNullable())	{	// fixed start length ends here
					breakIndicator.add("nullable");	// make parent terminate
					return len;
				}
				else
				if (cc.isRepeatable())	{	// fixed start length ends here
					len += cc.getSomeLength(exploreStartLength, breakIndicator);
					breakIndicator.add("repeatable");	// make parent terminate
					return len;
				}
				
				len += cc.getSomeLength(exploreStartLength, breakIndicator);
			}
			else
			if (o instanceof CharacterSet)	{
				if (exploreStartLength)	{
					breakIndicator.add("set");	// make parent terminate
					return len;
				}
				len += 1;	// would match exactly one character
			}
			else	{	// must be String
				len += ((String)o).length();	// matches a string of same length
			}
		}
		
		return len;
	}



	/** Return contained consumer when having only one and no constraints. This is called immediately after construction. */
	Consumer optimize()	{
		if (constraints == null && sequence.size() == 1 && sequence.get(0) instanceof Consumer)	{
			// give up this formal-only consumer, take rule to sub-consumer
			Consumer cc = (Consumer) sequence.get(0);
			cc.rule = rule;
			return cc;
		}
		return this;
	}

	/**
		Returns true if the rule of this consumer matches the passed left recursive rule.
		E.g. passing "nonterm ::= nonterm something" would match "nonterm ::= something".
	*/
	boolean matchesRepeatableRule(Rule rule)	{
		if (rule.rightSize() != this.rule.rightSize() + 1)
			return false;
		for (int i = 0; i < this.rule.rightSize(); i++)
			if (this.rule.getRightSymbol(i).equals(rule.getRightSymbol(i + 1)) == false)
				return false;
		return true;
	}



	// consume methods

	/** Passes the factory for Strategy objects to all contained ConsumerAlternatives. */
	public void setStrategyFactoryMethod(StrategyFactoryMethod strategyFactoryMethod)	{
		for (int i = 0; i < sequence.size(); i++)	{
			Object c = sequence.get(i);
			if (c instanceof Consumer)	{
				((Consumer) c).setStrategyFactoryMethod(strategyFactoryMethod);
			}
		}
	}

	/**
		Reads from input. Returns null if input did not match, else a result tree containing the text.
		Ensures that a nullable consumer never returns null and a repeatable consumer repeats.
		@param input Input object where to read from.
		@return null if no match, else scanned input as a result tree.
	*/
	public ResultTree consume(InputText input)
		throws IOException
	{
		// prepare scanning for results
		ResultTree result = isRepeatable() ? ensureResultTree(null) : null;	// prepare a list container when repeatable
		ResultTree r;
		Token.Address start = new Token.Address(input.getScanLine(), input.getScanColumn(), input.getScanOffset());

		// consume input and optionally loop when having a repeatable rule
		do	{
			r = consumeInternal(input);
			if (r != null && r.hasText())
				result = (result == null) ? r : result.addChild(r);
		}
		while (r != null && isRepeatable());

		// check the result tree element
		if (result != null && isRepeatable() && result.getChildCount() <= 0)
			result = null;
			
		if (result == null && isNullable())	// having read no input should not break loop of caller
			result = ensureResultTree(null);	// return empty result element
		
		// add range when there was a result
		if (result != null)	{
			Token.Address end = new Token.Address(input.getScanLine(), input.getScanColumn(), input.getScanOffset());
			result.setRange(new Token.Range(start, end));
		}
		
		return result;
	}


	/**
		Consumes characters from Input and stores it into returned result tree.
		Returns null if nothing has been consumed.
	*/
	protected ResultTree consumeInternal(InputText input)
		throws IOException
	{
		ResultTree result = null;
		boolean ok = true;
		int mark = input.getMark();
		Token.Address start = new Token.Address(input.getScanLine(), input.getScanColumn(), input.getScanOffset());
		
		// all members of this sequence must match
		for (int i = 0; ok && i < sequence.size(); i++)	{
		
			// first check constraint consumers negatively
			for (int j = 0; ok && constraints != null && j < constraints.size(); j++)	{
				Consumer cc = (Consumer) constraints.get(j);

				int mark1 = input.getMark();	// set mark as constraint-consumer is no permitted consumer 
				ok = (cc.consumeInternal(input) == null);	// ok when constraint failed to read
				input.setMark(mark1);	// reset to mark
			}
			
			if (ok)	{	// no constraint succeeded, now check positively
				Object o = sequence.get(i);
				
				if (o instanceof Consumer)	{	// match next consumer
					Consumer cc = (Consumer)o;
					ResultTree r = cc.consume(input);
					
					if (r == null)
						ok = false;
					else
						result = ensureResultTree(result).addChild(r);
				}
				else
				if (o instanceof CharacterSet)	{	// match character set
					CharacterSet charSet = (CharacterSet)o;
					int ic = input.read();
					char c = (char)ic;
					if (ic == Input.EOF || charSet.includes(c) == false)
						ok = false;
					else
						result = ensureResultTree(result).append(c);
				}
				else	{	// match a literal terminal String
					String s = (String)o;
					int j = 0;
					
					do	{
						int ic = input.read();
						ok = (ic != Input.EOF && ((char)ic) == s.charAt(j));
						j++;
					}
					while (ok && j < s.length());
					
					if (ok)
						result = ensureResultTree(result).append(s);
						
				}	// end possible sequence objects
				
			}	// end if ok (not constrained)
		}	// end for all sequences
		

		if (ok && result != null && result.hasText())	{	// sequence did match and read non-null text
			Token.Address end = new Token.Address(input.getScanLine(), input.getScanColumn(), input.getScanOffset());
			result.setRange(new Token.Range(start, end));
			//System.err.println("Consumer success, free memory: "+Runtime.getRuntime().freeMemory()+", "+rule);
			return result;	// null-text will be considered by consume() that knows about nullable rules
		}

		input.setMark(mark);	// start again from initial mark

		//System.err.println("Consumer failed: "+rule);
		return null;	// there was no match
	}


	private ResultTree ensureResultTree(ResultTree result)	{
		if (result == null)
			result = new ResultTree(rule);
		return result;
	}
	
	

	/** String representation of consumer: hashcode, sequence and constraints. */
	public String toString()	{
		return hashCode()+
			"("+getStartVariance()+","+getStartLength()+","+getFixedLength()+")> "+
			toStringBase()+
			(isNullable() && isRepeatable() ? " *" : isNullable() ? " ?" : isRepeatable() ? " +" : "");
	}
	
	/** Returns the base string for toString() method. */
	protected String toStringBase()	{
		StringBuffer sb = new StringBuffer();
		listToString(sequence, sb, " ", false);
		listToString(constraints, sb, " - ", true);
		return sb.toString();
	}

	/** Converts a list into String, for toString() method. */
	protected void listToString(List list, StringBuffer sb, String separator, boolean separatorAtFirst)	{
		for (int i = 0; list != null && i < list.size(); i++)	{
			Object o = list.get(i);
			
			if (separatorAtFirst || i > 0)
				sb.append(separator);
			
			if (o instanceof Consumer)
				sb.append("["+o.hashCode()+"]");
			else	// String or CharacterSet
				sb.append(o.toString());
		}
	}	
		


	/**
		Returns true if the passed consumer could be concurrent with this.
		This method does not consider constraints, as these could be complex.
	*/
	public boolean overlaps(Consumer cc)	{
		Object o1 = sequence.get(0);
		
		if (o1 instanceof Consumer)	{	// drill down
			return ((Consumer)o1).overlaps(cc);
		}
		else	{	// primitive found
			if (cc.sequence.size() <= 0)	// must be ConsumerAlternatives
				return cc.overlaps(this);

			Object o2 = cc.sequence.get(0);
			
			if (o2 instanceof Consumer)	{	// drill down
				return ((Consumer)o2).overlaps(this);
			}
			else
			if (o1 instanceof CharacterSet)	{
				if (o2 instanceof CharacterSet)
					return ((CharacterSet)o1).overlaps((CharacterSet)o2);
				else
				if (o2 instanceof String)
					return ((CharacterSet)o1).includes(((String)o2).charAt(0));
			}
			else
			if (o2 instanceof CharacterSet)	{
				if (o1 instanceof String)
					return ((CharacterSet)o2).includes(((String)o1).charAt(0));
			}

			String seq1 = (String) o1;
			String seq2 = (String) o2;
			return seq1.charAt(0) == seq2.charAt(0);
		}
	}
	
	
	
	
	// helper classes

	
	/** Marker class for references that must be resolved after building consumers. */
	public static class Reference
	{
		String nonterminal;
		
		Reference(String nonterminal)	{
			this.nonterminal = nonterminal;
		}
		public String toString()	{
			return nonterminal;
		}
	}
	
	
	
	private static class CharacterSet implements Serializable
	{
		private String stringRepres;
		private char firstChar, lastChar;
		
		CharacterSet(String first, String last)
			throws LexerException
		{
			this.firstChar = first.charAt(0);
			this.lastChar = last.charAt(0);

			if (firstChar >= lastChar)
				throw new LexerException("First character is bigger equal last: "+toString());
		}
		
		public char getFirstChar()	{
			return firstChar;
		}
		
		public char getLastChar()	{
			return lastChar;
		}
		
		/** Returns the number of contained characters. */
		public int getVariance()	{
			return lastChar - firstChar;
		}

		/** Returns true if passed character is contained in this set. */
		public boolean includes(char c)	{
			return c >= firstChar && c <= lastChar;
		}

		/** Returns true if passed character set contains characters contained in this set. */
		public boolean overlaps(CharacterSet other)	{
			return other.includes(firstChar) || other.includes(lastChar) || includes(other.firstChar) || includes(other.lastChar);
		}
		
		public String toString()	{
			if (stringRepres == null)	{
				if (Character.isISOControl(firstChar) || Character.isISOControl(lastChar))
					this.stringRepres = Integer.toHexString(firstChar)+".."+Integer.toHexString(lastChar);
				else
					this.stringRepres = firstChar+".."+lastChar;
			}
			return stringRepres;
		}
	}

}