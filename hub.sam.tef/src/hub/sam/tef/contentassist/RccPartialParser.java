package hub.sam.tef.contentassist;

import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.parsertables.LALRSyntaxNode;
import hub.sam.tef.rcc.parsertables.SLRSyntaxNode.RuleStateItem;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.util.DoubleLinkedTreeNode;
import hub.sam.tef.util.MultiMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.Assert;

/**
 * TODO
 * 
 * A partial parser allows the parsing of some text to a certain position. In
 * contrast to a {@link RccContentAssistParser}, the parsing is not stopped
 * once this position is reached, but the parsing is continued. This
 * continuation, however, is not based on the parsed text, but a token stream
 * provided in a way that parsing is finished successfully with the least tokens
 * necessary. This allows to create a real parse-tree that reflects the parsed
 * text up to the completion offset. This parse-tree can than be used for
 * further partial model creation.
 */
public class RccPartialParser extends Parser {

	private static final long serialVersionUID = 1L;

	private int fCompletionOffset;
	private boolean normalMode = true;
	private Iterator<String> tokenStream = null;

	private final MultiMap<String, Rule> fRules;

	public RccPartialParser(ParserTables tables) {
		super(tables);

		fRules = new MultiMap<String, Rule>();
		Syntax syntax = getParserTables().getSyntax();
		for (int i = 0; i < syntax.size(); i++) {
			Rule rule = syntax.getRule(i);
			fRules.put(rule.getNonterminal(), rule);
		}
	}

	/**
	 * Allows to the the offset, the position up to that the parser shall parse
	 * the input text to.
	 */
	public void setCompletionOffset(int offset) {
		fCompletionOffset = offset;
		normalMode = true;
		tokenStream = null;
	}

	/**
	 * This method provides a modified behaviour of the super method. It works
	 * just like the super method until the completion offset is reached. After
	 * that, it returns the tokens that will force a complete reduction of the
	 * parse stack as soon as possible.
	 */
	@Override
	protected Token getNextToken() throws IOException {
		if (normalMode) {
			Token token = super.getNextToken();
			if (Token.isEpsilon(token)
					|| (token.range.end.offset > fCompletionOffset)) {
				normalMode = false;
			} else {
				return token;
			}
		}
		if (!normalMode) {
			if (tokenStream == null) {
				// check for accept
				Map<String, Integer> currentParserActions = getParserTables()
						.getParserActions(stateStack.peek());
				if (currentParserActions.keySet().contains(Token.EPSILON)) {
					// we definitely take the EoF, no matter what.
					return new Token(Token.EPSILON, null, new Token.Range(
							fCompletionOffset, fCompletionOffset));
				}

				List<String> shortestParsingEdingTerminalSequence = shortestTerminalSequenceForReduce(stateStack);
				tokenStream = shortestParsingEdingTerminalSequence.iterator();
			}

			if (tokenStream.hasNext()) {
				String terminal = tokenStream.next();

				if (Token.isFixedTerminal(terminal)) {
					return new Token(terminal, terminal.substring(1, terminal
							.length() - 1), new Token.Range(fCompletionOffset,
							fCompletionOffset));
				} else {
					// TODO use some better text than null
					return new Token(terminal, null, new Token.Range(
							fCompletionOffset, fCompletionOffset));
				}
			} else {
				return new Token(Token.EPSILON, null, new Token.Range(
						fCompletionOffset, fCompletionOffset));
			}
		} else {
			Assert.isTrue(false, "unreachable");
			return null;
		}
	}

	/**
	 * Returns all grammar items for the current parser state.
	 * 
	 * @param stateStack
	 *            that represents the parser state.
	 * @return a collection of grammar items.
	 */
	private Collection<RuleStateItem> getAllRuleStateItems(
			Stack<Integer> stateStack) {
		Collection<RuleStateItem> result = new ArrayList<RuleStateItem>();
		List<LALRSyntaxNode> syntaxNodes = ((LALRParserTables) getParserTables())
				.getSyntaxNodes();
		Collection<Integer> stateAndReducedStates = getMostReducedStatesForState(
				stateStack, new HashSet<Integer>());
		for (int state : stateAndReducedStates) {
			LALRSyntaxNode stateNode = syntaxNodes.get(state);
			result.addAll(stateNode.getRuleStateItems());
		}
		return result;
	}

	/**
	 * Calculates a short sequence of terminals that leads to accept. Note that
	 * this algorithm is faulty and might throw an assertion in some cases.
	 * 
	 * @param stateStack
	 *            a valid parser stack.
	 * @return the shortest sequence of terminal symbols that leads to
	 *         acceptance.
	 */
	private List<String> shortestTerminalSequenceForReduce(
			Stack<Integer> stateStack) {
		List<String> shortestResult = null;
		ReductionTreeNode reductionTree = new ReductionTreeNode(null, null);
		Assert.isTrue(buildReductionTree(reductionTree, stateStack));
		for (ReductionTreeNode reduction : reductionTree.getLeaves()) {
			List<String> resultCandidate = reduction.getWordForReduction();
			if (shortestResult == null
					|| shortestResult.size() > resultCandidate.size()) {
				shortestResult = resultCandidate;
			}
		}
		reductionTree.dispose();
		return shortestResult;
	}

	/**
	 * Executes a reduce on the given parse stack.
	 * 
	 * @param stateStack
	 *            the parse stack.
	 * @param action
	 *            the rule index.
	 */
	private void executeReduce(Stack<Integer> stateStack, int action) {
		Rule reductionRule = getParserTables().getSyntax().getRule(action);
		for (int i = 0; i < reductionRule.rightSize(); i++) {
			stateStack.pop();
		}
		stateStack.push(getParserTables().getGotoState(stateStack.peek(),
				reductionRule.getNonterminal()));
	}
	
	/**
	 * Constructs a tree of reduction. This tree represents all possible ways to
	 * reduce the parse stack up to the starting state. Each path from root to a
	 * leave in this tree will represent a series of reductions that lead to an
	 * state stack that only contains the start state, i.e. accepts.
	 * 
	 * @param parent
	 *            a parent tree node to append the possible reductions for the
	 *            given state stack.
	 * @param stateStack
	 *            the actual parser state.
	 * @return true if a reduction tree could be created. false in the case of
	 *         endless recursion, parser errors, etc.
	 */
	private boolean buildReductionTree(ReductionTreeNode parent,
			Stack<Integer> stateStack) {		
		// reduce based on the element in the parent node )
		RuleStateItem itemToReduce = parent.fElement;
		if (itemToReduce != null) {
			Rule rule = itemToReduce.getRule();
			int pointerPosition = itemToReduce.getPointerPosition() - 1;
			if (pointerPosition < rule.rightSize()) {
				String terminal = rule.getRightSymbol(pointerPosition);
				loop: while (true) {
					int action = getParserTables().getParseAction(
							stateStack.peek(), terminal);
					if (action == ParserTables.SHIFT) {
						break loop;
					} else if (action == ParserTables.ERROR) {
						Assert.isTrue(false);
					} else if (action == ParserTables.ACCEPT) {
						Assert.isTrue(false);
					} else {
						executeReduce(stateStack, action);
					}
				}
			}

			for (int i = 0; i < pointerPosition; i++) {
				stateStack.pop();
			}
			Integer gotoState = getParserTables().getGotoState(
					stateStack.peek(), rule.getNonterminal());
			if (gotoState == -1 && rule.getNonterminal().equals("<START>")) {
				return true; // TODO dirty
			} else if (gotoState == -1) {
				return false;
			}
			stateStack.push(gotoState);
		}		

		// check for termination of the recursion (this is when the current
		// stack accepts
		// an EoF.
		if (getParserTables().getParserActions(stateStack.peek()).get(
				Token.EPSILON) == ParserTables.ACCEPT) {
			return true;
		}

		// create the children based on the reduced stack
		boolean continuedReduction = false;
		for (RuleStateItem childItem : getAllRuleStateItems(stateStack)) {
			int pointerPosition = childItem.getPointerPosition() - 1;
			Rule rule = childItem.getRule();
			if (pointerPosition == rule.rightSize()
					|| Rule.isTerminal(rule.getRightSymbol(pointerPosition))) {
				Stack<Integer> stackCopy = copy(stateStack);
				ReductionTreeNode childNode = new ReductionTreeNode(childItem,
						copy(stateStack));
				if (!parent.contains(childNode)) {					
					parent.addChild(childNode);
					if (buildReductionTree(childNode, stackCopy)) {
						continuedReduction = true;
					} else {
						parent.removeLastChild();
					}
				}
			}
		}
		return continuedReduction;
	}

	/**
	 * Represents a node in a tree of reduction, see
	 * {@link RccPartialParser#buildReductionTree(hub.sam.tef.contentassist.RccPartialParser.ReductionTreeNode, Stack)}.
	 */
	private class ReductionTreeNode extends
			DoubleLinkedTreeNode<ReductionTreeNode> {
		private final RuleStateItem fElement;
		private final Stack<Integer> fStack;

		public ReductionTreeNode(RuleStateItem element, Stack<Integer> stack) {
			super();
			fElement = element;
			fStack = stack;
		}

		/**
		 * This should be called for a leave. It goes up to the root and
		 * collects all symbols down the path to itself. The resulting list of
		 * symbols represents the symbols that have to be placed on the parse
		 * stack in order to achieve the reduction series represented by this
		 * node.
		 * 
		 * @param symbols
		 *            a list of already collected symbols. Simply give an empty
		 *            list if you execute this on a leave.
		 * @return the list of symbols.
		 */
		private List<String> collectReductionSymbols(List<String> symbols) {
			if (fElement == null) {
				return symbols;
			} else {
				getParent().collectReductionSymbols(symbols);
				Rule rule = fElement.getRule();
				int pointerPosition = fElement.getPointerPosition() - 1;
				int rightSize = rule.rightSize();
				for (int i = pointerPosition; i < rightSize; i++) {
					symbols.add(rule.getRightSymbol(i));
				}
				return symbols;
			}
		}

		/**
		 * @return a list of terminals that would result in the reduction
		 *         serious represented by this node.
		 */
		public List<String> getWordForReduction() {
			List<String> result = new ArrayList<String>();
			for (String symbol : collectReductionSymbols(new ArrayList<String>())) {
				if (Rule.isTerminal(symbol)) {
					result.add(symbol);
				} else {
					result
							.addAll(getShortesWord(symbol,
									new HashSet<String>()));
				}
			}
			return result;
		}

		/**
		 * @param node
		 *            a reduction tree node.
		 * @return true if the path from this node to the root contains a node
		 *         with the same stack than the given node.
		 */
		public boolean contains(ReductionTreeNode node) {
			return this.equals(node) || (this.fElement == node.fElement && this.fStack.size() < node.fStack.size())
					|| (getParent() == null ? false : getParent().contains(node));
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((fStack == null) ? 0 : fStack.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final ReductionTreeNode other = (ReductionTreeNode) obj;
			if (fStack == null) {
				if (other.fStack != null)
					return false;
			} else if (!fStack.equals(other.fStack))
				return false;
			return true;
		}
	}

	private <E> Stack<E> copy(Stack<E> original) {

		Stack<E> result = new Stack<E>();
		for (E i : original) {
			result.add(i);
		}
		return result;

		// return new StackCopy<Integer>(original);
	}

	/**
	 * Collects all the states that lay "on top" of the stack. This is not only
	 * the state on top, but also all states that would lay on top if possible
	 * reduction would be executed.
	 * 
	 * @param stack
	 *            the stack to analyse.
	 * @param states
	 *            a collection that will contain all the collected states.
	 */
	private Collection<Integer> getMostReducedStatesForState(
			List<Integer> stack, Collection<Integer> states) {
		int state = stack.get(stack.size() - 1);
		if (states.contains(state)) {
			Collection<Integer> result = new ArrayList<Integer>();
			result.add(state);
			return result;
		}
		states.add(state);
		Collection<Integer> result = new ArrayList<Integer>();
		Collection<Rule> possibleReductions = getParserTables()
				.getPossibleReductionsForState(state);
		if (possibleReductions.size() == 0) {
			result.add(state);
		} else {
			loop: for (Rule reduction : possibleReductions) {
				List<Integer> stackCopy = new ArrayList<Integer>(stack);
				int reductionSize = reduction.rightSize();
				for (int i = 0; i < reductionSize; i++) {
					stackCopy.remove(stack.size() - i - 1);
				}
				Integer gotoState = getParserTables().getGotoState(
						stackCopy.get(stackCopy.size() - 1),
						reduction.getNonterminal());
				if (gotoState == -1) {
					// we reached to start state with all the reductions
					continue loop;
				}
				stackCopy.add(gotoState);

				result.addAll(getMostReducedStatesForState(stackCopy, states));
			}
		}
		return result;
	}

	/**
	 * Creates a shortest sequence of terminal symbols that can be derived from
	 * a given non-terminal.
	 * 
	 * @param symbol
	 *            must be a non terminal.
	 * @param usedSymbols
	 *            a collection of symbols already used in a derivation, these
	 *            symbols will not be used again to avoid endless recusion.
	 * @return the shortest sequence of terminal symbols.
	 */
	private List<String> getShortesWord(String symbol,
			Collection<String> usedSymbols) {
		if (Rule.isTerminal(symbol)) {
			Assert.isTrue(false);
			return null;
		} else {
			List<String> shortestResult = null;
			loop: for (Rule rule : fRules.get(symbol)) {
				Collection<String> usedSymbolsCopy = new HashSet<String>(
						usedSymbols);
				List<String> result = new ArrayList<String>();
				for (int i = 0; i < rule.rightSize(); i++) {
					String rhs = rule.getRightSymbol(i);
					if (Rule.isTerminal(rhs)) {
						result.add(rhs);
					} else {
						if (usedSymbolsCopy.contains(rhs)) {
							continue loop;
						} else {
							usedSymbolsCopy.add(rhs);
							List<String> subResult = getShortesWord(rhs,
									usedSymbolsCopy);
							if (subResult == null) {
								continue loop;
							} else {
								result.addAll(subResult);
							}
						}
					}
				}
				if (shortestResult == null
						|| result.size() < shortestResult.size()) {
					shortestResult = result;
				}
			}
			return shortestResult;
		}
	}

}
