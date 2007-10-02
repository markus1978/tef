package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.*;
import java.io.*;
import fri.util.Equals;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
	Container for alternative rules/Consumers.
	If one of the contained consumers succeeds, the
	alternative succeeds, else it fails.
	
	@author (c) 2002, Fritz Ritzberger
*/

class ConsumerAlternatives extends Consumer
{
	private List alternates = new ArrayList(3);
	private StrategyFactoryMethod strategyFactoryMethod;
	private Strategy strategy;
	
	
	/** Create a list of alternative consumers, inserting passed consumer. */
	ConsumerAlternatives(Consumer alternateConsumer)	{
		addAlternate(alternateConsumer);
	}


	/** Add another alternative consumer for same nonterminal. */
	public void addAlternate(Consumer alternateConsumer)	{
		alternates.add(alternateConsumer);
	}

	/**
		Returns the stored alternative consumers that have the same nonterminal.
		This is for the Lexer to retrieve alternative consumers and call them
		explicitely to read input. This must be done to match the longest input.
	*/
	public List getAlternatives()	{
		return alternates;
	}
	
	/** Tries to match to all alternates. Returns true when at least one succeeds. */
	boolean matchesRepeatableRule(Rule rule)	{
		for (int i = 0; i < alternates.size(); i++)	{
			Consumer ac = (Consumer)alternates.get(i);
			if (ac.matchesRepeatableRule(rule))
				return true;
		}
		return false;
	}

	/** Returns the common start character if all alternatives have the same, else null. */
	public Character getStartCharacter()	{
		Character c = null;
		
		for (int i = 0; i < alternates.size(); i++)	{
			Consumer cc = (Consumer)alternates.get(i);
			Character c1 = cc.getStartCharacter();
			
			if (i == 0)
				c = c1;
			else
			if (Equals.equals(c, c1) == false)
				return null;
		}

		return c;
	}

	/**
		Returns 1 if start character exists, else the sum of possible start variances of all consumers
		(silently assuming that they have different character sets).
	*/
	public int getStartVariance()	{
		if (getStartCharacter() != null)
			return 1;
			
		int v = 0;
		for (int i = 0; i < alternates.size(); i++)
			v += ((Consumer) alternates.get(i)).getStartVariance();

		return v;
	}
	
	/**
		Returns the maximum fixed length of all alternating consumers.
		A fixed start sequence ends at the first found character set (like "0..9").
		<p>
		Returns the maximum start length of all alternating consumers.
		A consumer start length ends at the first found repeatable or nullable consumer (like "chars*").
	*/
	protected int getSomeLength(boolean exploreStartLength, List breakIndicator)	{
		int max = 0;
		for (int i = 0; i < alternates.size(); i++)	{
			Consumer cc = (Consumer)alternates.get(i);
			int len = cc.getSomeLength(exploreStartLength, breakIndicator);
			if (len > max)
				max = len;
		}
		return max;
	}
	

	/**
		Reads from input by delegating to a Strategy object.
		@param input Input object where to read from.
		@return null if no match, else scanned input as a StringBuffer.
	*/
	protected ResultTree consumeInternal(InputText input)
		throws IOException
	{
		if (strategy == null)	{	// sort alternatives by their start/fixed length
			strategy = strategyFactoryMethod != null ? strategyFactoryMethod.newStrategy() : new Strategy();

			for (int i = 0; i < alternates.size(); i++)	{
				Consumer cc = (Consumer) alternates.get(i);
				strategy.addTokenConsumer(cc.rule.getNonterminal(), cc);
			}
		}

		Strategy.Item item = strategy.consume(input, input.peek(), null);
		if (item != null)
			return item.getResultTree();
			
		return null;
	}


	/** Returns true if the passed consumer could be concurrent with one of the contained alternatives. */
	public boolean overlaps(Consumer cc)	{
		for (int i = 0; i < alternates.size(); i++)	{
			Consumer ac = (Consumer) alternates.get(i);
			if (ac.overlaps(cc))
				return true;
		}
		return false;
	}


	/** Returns the base string for toString() method. */
	protected String toStringBase()	{
		StringBuffer sb = new StringBuffer();
		listToString(alternates, sb, " | ", false);
		return sb.toString();
	}


	/** Sets the factory for Strategy objects. */
	public void setStrategyFactoryMethod(StrategyFactoryMethod strategyFactoryMethod)	{
		this.strategyFactoryMethod = strategyFactoryMethod;
		
		for (int i = 0; i < alternates.size(); i++)	{
			Consumer c = (Consumer) alternates.get(i);
			c.setStrategyFactoryMethod(strategyFactoryMethod);
		}
	}

}