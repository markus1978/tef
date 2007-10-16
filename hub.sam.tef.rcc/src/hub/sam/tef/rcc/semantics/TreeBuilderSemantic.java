package hub.sam.tef.rcc.semantics;

import hub.sam.tef.rcc.Semantic;
import hub.sam.tef.rcc.syntax.Rule;

import java.util.List;

/**
	A semantic that builds a syntax tree model from a parser run.
	Every node of the result tree contains the rule and the parsed token list.
	The result of the parser run can be retrieved by
	<i>(TreeBuilderSemantic.Node) parser.getResult()</i>.

	@author (c) 2002, Fritz Ritzberger
*/

public class TreeBuilderSemantic implements Semantic
{
	/**
		Implements Semantic to store every node of the syntax tree with rule and values.
	*/
	public Object doSemantic(Rule rule, List inputTokens, List ranges)	{
		return new Node(rule, inputTokens, ranges);
	}


	/**
		Node class that representy a syntax tree node. All sub-nodes are contained as children.
	*/
	public static class Node
	{
		private Rule rule;
		private List inputTokens, ranges;
		
		public Node(Rule rule, List inputTokens, List ranges)	{
			this.rule = rule;
			this.inputTokens = inputTokens;
			this.ranges = ranges;
		}
		
		/** Returns the rule of this syntax tree node. */
		public Rule getRule()	{
			return rule;
		}
		
		/** Returns the instance token list. */
		public List getInputTokens()	{
			return inputTokens;
		}
		
		/** Returns the instance token line range list. */
		public List getRanges()	{
			return ranges;
		}
		
		/** Returns "nonterminal@hashcode" as String representation of this node. */
		public String toString()	{
			return getRule().getNonterminal()+"@"+hashCode();
		}
		
		/**
			Returns the human readable representation of this node and all sub-nodes.
			@param indent spaces to indent on sub-nodes.
		*/
		public String toString(int indent)	{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < indent; i++)
				sb.append("  ");
				
			sb.append(toString());
			sb.append(" ::= ");
			
			if (getRule().rightSize() <= 0)
				sb.append("/*nothing*/");
			else
				for (int i = 0; i < getRule().rightSize(); i++)
					sb.append(getRule().getRightSymbol(i)+" ");
				
			sb.append("\t=>\t");
			sb.append(getInputTokens());
			sb.append("\n");
			
			for (int i = 0; i < getInputTokens().size(); i++)	{
				Object o = getInputTokens().get(i);
				
				if (o instanceof Node)	{
					sb.append(((Node)o).toString(indent + 1));
				}
			}
			
			return sb.toString();
		}
	}


	public Object doSemanticForErrorRecovery(String recoverSymbol) {
		return "ERROR";
	}
	
}
