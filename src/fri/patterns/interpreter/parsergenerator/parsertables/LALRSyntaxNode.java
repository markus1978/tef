package fri.patterns.interpreter.parsergenerator.parsertables;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;

/**
	LR bottom-up parser syntax node. This node type contains an
	algorithm to propagate lookahead-sets of items to dependent items
	after syntax nodes were constructed.
	
	@see fri.patterns.interpreter.parsergenerator.parsertables.LRSyntaxNode
	@author (c) 2000, Fritz Ritzberger
*/

class LALRSyntaxNode extends LRSyntaxNode
{
	/** Construction of node with FIRST-sets and nullability of all nonterminals in syntax. */
	public LALRSyntaxNode(Nullable nullable, FirstSets firstSets)	{
		super(nullable, firstSets);
	}
	
	
	/** Factory-method that constructs a LALRSyntaxNode. */
	protected SLRSyntaxNode createSyntaxNode()	{
		return new LALRSyntaxNode(nullable, firstSets);
	}
	
	/**
		Factory-method that constructs a LALRRuleStateItem.
		A start-lookahead gets appended to the item when it is the start node.
	*/
	protected RuleStateItem createRuleStateItem(int ruleIndex, Rule rule)	{
		LALRRuleStateItem item = new LALRRuleStateItem(ruleIndex, rule);
		addStartLookahead(item, ruleIndex);
		return item;
	}

	/** Calls super. After build lookaheads get propagated. */
	public List build(Syntax syntax, List syntaxNodes, Hashtable kernels)	{
		syntaxNodes = super.build(syntax, syntaxNodes, kernels);
		
		// propagate lookaheads
		for (int i = 0; i < syntaxNodes.size(); i++)	{
			LALRSyntaxNode node = (LALRSyntaxNode) syntaxNodes.get(i);
			for (Enumeration e = node.entries.elements(); e.hasMoreElements(); )	{
				LALRRuleStateItem item = (LALRRuleStateItem) e.nextElement();
				item.propagateLookaheads(null);
			}
		}
		return syntaxNodes;
	}
		
	/**
		Method called from closure, adopt all rules that derive the pending nonterminal.
		Default lookaheads are calculated here. Items that need lookahead propagation
		are located here.
	*/
	protected void addRulesDerivingPendingNonTerminal(RuleStateItem itm, String nonterm, Syntax syntax, List newItems)	{
		// make the closure for one item:
		// if pointer before a nonterminal, add all rules that derive it
		
		LALRRuleStateItem item = (LALRRuleStateItem) itm;
		boolean needsPropagation = false;
		List lookahead = null;

		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);
			
			if (rule.getNonterminal().equals(nonterm))	{
				LALRRuleStateItem rsi = (LALRRuleStateItem) createRuleStateItem(i, rule);
				
				// look if new item is already contained
				LALRRuleStateItem existing = (LALRRuleStateItem)entries.get(rsi);
				if (existing != null)	{
					rsi = existing;
				}
				else	{	// if not contained, add it
					entries.put(rsi, rsi);	// real list
					newItems.add(rsi);	// work list
				}
				
				if (lookahead == null)
					// calculate lookahead of originator and if it needs to propagate changes in
					// its lookahead to the new items (has nullable nonterms until end)
					needsPropagation = item.calculateLookahead(
							lookahead = new ArrayList(),
							nullable,
							firstSets);
				
				rsi.addLookahead(lookahead.iterator());	// merge lookaheads
				
				if (needsPropagation)	// if lookahead is visible from this item,
					item.addPropagate(rsi);	// add to propagate list
			}
		}
	}


	/**
		Called from closure, connect a rule state item to its follower.
		Lookahead-Propagation gets prepared by linking parent to child.
	*/
	protected void linkParentItemToChild(RuleStateItem parent, int newIndex, List syntaxNodes, RuleStateItem child)	{
		LALRRuleStateItem pnt = (LALRRuleStateItem) parent;
		pnt.followNodeIndex = newIndex;

		LALRSyntaxNode node = (LALRSyntaxNode) syntaxNodes.get(newIndex);
		
		// find corresponding item
		LALRRuleStateItem rsi = (LALRRuleStateItem) node.entries.get(child);

		// probably will have to propagate lookaheads to shifted item
		pnt.addPropagate(rsi);
	}





	/**
		Rule state entry item class, contained within LALR syntax node.
		Lookahead propagation is implemented here.
	*/
	protected class LALRRuleStateItem extends LRRuleStateItem
	{
		boolean needsPropagation = false;
		Stack propagateItems = new Stack();
		
		public LALRRuleStateItem(int ruleIndex, Rule rule)	{
			super(ruleIndex, rule);
		}
		
		protected LALRRuleStateItem(RuleStateItem orig)	{
			super(orig);
		}

		/** Factory-method creating LALRRuleStateItem. */
		protected RuleStateItem createRuleStateItem(RuleStateItem orig)	{
			return new LALRRuleStateItem(orig);
		}
		
		/** Add an item that need lookahead propagation by this one. */
		void addPropagate(RuleStateItem item)	{
			propagateItems.push(item);
			needsPropagation = true;
		}
		
		/** Accept incoming lookahead and propagate the own lookahead. */
		void propagateLookaheads(Iterator originatorLookahead)	{
			boolean change = false;
			
			/// return when if nothing to propagate
			if (needsPropagation == false && (originatorLookahead == null || originatorLookahead.hasNext() == false))
				return;
			
			if (originatorLookahead != null)
				change = addLookahead(originatorLookahead);	// accept lookahead
			
			// if changed or need it, propagate across all linked items
			if (change || needsPropagation)	{
				needsPropagation = false;
			
				for (int i = 0; i < propagateItems.size(); i++)	{
					LALRRuleStateItem item = (LALRRuleStateItem) propagateItems.get(i);
					item.propagateLookaheads(lookahead.keySet().iterator());
				}
			}
		}
		
		/** Rule index and position of dot must be equal. */
		public boolean equals(Object o)	{
			RuleStateItem item = (RuleStateItem)o;
			return ruleIndex == item.ruleIndex && pointerPosition == item.pointerPosition;
		}

		/** The ruleIndex * 13 + dot poisition. */
		public int hashCode()	{
			if (hashCache == null)
				hashCache = new Integer(ruleIndex * 13 + pointerPosition);
			return hashCache.intValue();
		}

	}	// end class LALRRuleStateItem
	
}