package fri.patterns.interpreter.parsergenerator.semantics;

import java.lang.reflect.*;
import java.util.*;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import fri.patterns.interpreter.parsergenerator.Semantic;

/**
	Semantic base class that tries to call methods with the same name as nonterminal
	on left side of rule. The number of parameters of the method must be the same as
	the number of symbols on the right side of the rule, all parameters must be of type
	Object, and the return type must be Object. The method might process the parse
	results and return an arbitrary Object to be processed by another callback method.
	The ranges of the currently dispatched rule is available by protected getRanges() method.
	<p/>
	Example: Both rules
	<pre>
		expression ::= expression "+" term ;
		expression ::= expression "-" term ;
	</pre>
	would be dispatched by
	<pre>
		public Object expression(Object expression, Object operator, Object term)	{
			int e = ((Integer) expression).intValue();
			int t = ((Integer) term).intValue();
			if (operator.equals("+"))
				return new Integer(e + t);
			else
			if (operator.equals("-"))
				return new Integer(e - t);
			else
				throw new IllegalArgumentException("Unknown operator: "+operator);
		}
	</pre>
	
	@see fri.patterns.interpreter.parsergenerator.examples.Calculator
	@author (c) 2000, Fritz Ritzberger
*/

public abstract class ReflectSemantic implements Semantic
{
	private List ranges;
	
	/**
		Tries to find a method with same name as left side of rule and number of arguments
		as much as elements in inputTokens list. All argument types are Object.
		@param rule the rule that was recognized by the parser.
		@param inputTokens all semantic call returns from underlying rules, collected according to current rule.
		@return object to push on parser value-stack.
	*/
	public Object doSemantic(Rule rule, List inputTokens, List ranges)	{
		this.ranges = ranges;
		
		String nonterminal = rule.getNonterminal();
		
		Class [] types = new Class [inputTokens.size()];
		for (int i = 0; i < types.length; i++)
			types[i] = Object.class;
		
		Method m = null;
		try	{
			m = getClass().getMethod(nonterminal, types);
		}
		catch (Exception e)	{
			//System.err.println("WARNING: method not implemented: "+nonterminal+", input is "+inputTokens);
			return fallback(rule, inputTokens, ranges);
		}
		
		Object [] args = new Object[inputTokens.size()];
		inputTokens.toArray(args);

		if (m != null)	{		
			try	{
				m.setAccessible(true);	// problem with anonymous inner classes
				Object o = m.invoke(this, args);
				return o;
			}
			catch (IllegalAccessException e)	{
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)	{
				e.printStackTrace();
			}
			catch (InvocationTargetException e)	{
				e.printStackTrace();
				throw new RuntimeException("ERROR in ReflectSemantic : "+e.getTargetException().toString());
			}
		}
		return null;
	}

	/**
		Fallback semantic handler that is called when no method was found by reflection.
		This method provides a default List aggregation for left recursive rules.
		@return first list element if input list has only one element,
				a List if the passed rule is left recursive,
				else the unmodified inputTokens list.
	*/
	protected Object fallback(Rule rule, List inputTokens, List ranges)	{
		if (inputTokens.size() == 1)	// push the one object on parser value stack
			return inputTokens.get(0);
			
		// check for loop rule and add 1..n right symbols to first right symbol (List)
		if (inputTokens.size() >= 2 && inputTokens.get(0) instanceof List && rule.getNonterminal().equals(rule.getRightSymbol(0)))	{
			List list = (List) inputTokens.get(0);
			for (int i = 1; i < inputTokens.size(); i++)
				list.add(inputTokens.get(i));
				
			return list;
		}
		
		return inputTokens;
	}
	
	
	/** Returns the current Token.Range list of all input tokens. */
	protected List getRanges()	{
		return ranges;
	}

}
