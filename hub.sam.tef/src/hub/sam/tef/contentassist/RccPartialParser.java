package hub.sam.tef.contentassist;

import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.parsertables.LALRSyntaxNode;
import hub.sam.tef.rcc.parsertables.SLRSyntaxNode.RuleStateItem;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.impl.SyntaxImpl;
import hub.sam.tef.util.MultiMap;
import hub.sam.tef.util.Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.Assert;

import sun.awt.SubRegionShowable;

/**
 * TODO
 * 
 * A partial parser allows the parsing of some text to a certain position. In
 * contrast to a {@link RccContentAssistParser}, the parsing is not stopped
 * once this position is reached, but the parsing is continued. This
 * continiuation, however, is not based on the parsed text, but a token stream
 * provided in a way that parsing is finished successfully with the least tokens
 * necessary. This allows to create a real parse-tree that reflects the parsed
 * text up to the completion offset. This parse-tree can than be used for
 * further partial model creation.
 */
public class RccPartialParser extends Parser {
	
	private static final long serialVersionUID = 1L;
	
	private int fCompletionOffset;
	private boolean normalMode = true;
	
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
	
	private List<String> getShortesWord(String symbol, Collection<String> usedSymbols) {
		if (Rule.isTerminal(symbol)) {
			Assert.isTrue(false);
			return null;
		} else {	
			List<String> shortestResult = null;
			loop: for (Rule rule: fRules.get(symbol)) {
				Collection<String> usedSymbolsCopy = new HashSet<String>(usedSymbols);
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
							List<String> subResult = getShortesWord(rhs, usedSymbolsCopy);
							if (subResult == null) {
								continue loop;
							} else {
								result.addAll(subResult);
							}
						}
					}
				}
				if (shortestResult == null || result.size() < shortestResult.size()) {
					shortestResult = result;
				}
			}
			return shortestResult;
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
	
	private Iterator<String> tokenStream = null;
	
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
			if (Token.isEpsilon(token) || (token.range.end.offset > fCompletionOffset)) {
				normalMode = false;					
			} else {			
				return token;
			}
		}
		if (!normalMode) {	
			// check for accept
			Map<String, Integer> currentParserActions = getParserTables().getParserActions(stateStack.peek());
			if (currentParserActions.keySet().contains(Token.EPSILON)) {
				// we definitely take the EoF, no matter what.
				return new Token(Token.EPSILON, null, new Token.Range(
						fCompletionOffset, fCompletionOffset));			
			}
									
			List<String> shortestParsingEdingTerminalSequence = 
					shortestTerminalSequenceForReduce(stateStack);
			if (shortestParsingEdingTerminalSequence == null) {
				Assert.isTrue(false, "there must be a follow up terminal");
				return null;
			} else if (shortestParsingEdingTerminalSequence.size() == 0) {
				return new Token(Token.EPSILON, null, new Token.Range(
						fCompletionOffset, fCompletionOffset));
			} else {
				String terminal = shortestParsingEdingTerminalSequence.get(0);
							
				if (Token.isFixedTerminal(terminal)) {
					return new Token(terminal, terminal.substring(1, terminal.length()-1), 
							new Token.Range(fCompletionOffset, fCompletionOffset));
				} else {
					// TODO use some better text than null
					return new Token(terminal, null, 
							new Token.Range(fCompletionOffset, fCompletionOffset));
				}
			}
		} else {
			Assert.isTrue(false, "unreachable");
			return null;
		}
	}
	
	private List<String> getShortestParsingEndingTerminalSequence(
			Stack<Integer> stateStack, Collection<Consume> visistedConsumes) {
		// check for accept
		Map<String, Integer> currentParserActions = getParserTables().getParserActions(stateStack.peek());
		if (currentParserActions.keySet().contains(Token.EPSILON)) {
			// we definitely take the EoF, no matter what.
			return new ArrayList<String>();			
		}
		
		List<String> shortestResult = null;
		loop: for (String followTerminal: getFollowTerminalsForParserState(stateStack)) {
			Stack<Integer> stackCopy = copy(stateStack);
			Collection<Consume> visitedConsumesCopy = new HashSet<Consume>(visistedConsumes);
			if (!visitedConsumesCopy.add(new Consume("", stackCopy.peek()))) {
				continue loop;
			}
			
			boolean parseResult = parse(stackCopy, followTerminal);
			
			List<String> result = null;
			if (parseResult) {
				result = new ArrayList<String>();
				result.add(followTerminal);			
			} else {
				result = getShortestParsingEndingTerminalSequence(stackCopy, visitedConsumesCopy);
				if (result == null) {
					continue loop;
				}
				result.add(followTerminal);
			}
			if (shortestResult == null || shortestResult.size() > result.size()) {
				shortestResult = result;
			}
		}			
		return shortestResult;
	}
	
	private Collection<String> getFollowTerminalsForParserState(Stack<Integer> stateStack) {
		Collection<String> result = new ArrayList<String>();
		List<LALRSyntaxNode> syntaxNodes = 
			((LALRParserTables)getParserTables()).getSyntaxNodes();		
		Collection<Integer> stateAndReducedStates = new ArrayList<Integer>();
		//getStateAndReducedStatesForState(stateStack, stateAndReducedStates);		
		for (int state: stateAndReducedStates) {
			LALRSyntaxNode stateNode = syntaxNodes.get(state);
			loop: for (RuleStateItem grammarPosition: stateNode.getRuleStateItems()) {
				Rule rule = grammarPosition.getRule();
				int pointerPosition = grammarPosition.getPointerPosition();
				if (pointerPosition -1 >= rule.rightSize()) {
					// this is a position at the end of a rule
					continue loop;
				}
				String rightSymbol = rule.getRightSymbol(pointerPosition - 1);
				if (Rule.isTerminal(rightSymbol)) {
					result.add(rightSymbol);
				}
			}			
		}
		return result;
	}
	
	private Collection<RuleStateItem> getAllRuleStateItems(Stack<Integer> stateStack) {
		Collection<RuleStateItem> result = new ArrayList<RuleStateItem>();
		List<LALRSyntaxNode> syntaxNodes = 
			((LALRParserTables)getParserTables()).getSyntaxNodes();		
		Collection<Integer> stateAndReducedStates = 
				getMostReducedStatesForState(stateStack, new HashSet<Integer>());		
		for (int state: stateAndReducedStates) {
			LALRSyntaxNode stateNode = syntaxNodes.get(state);
			result.addAll(stateNode.getRuleStateItems());						
		}
		return result;
	}
	
	private List<String> shortestTerminalSequenceForReduce(Stack<Integer> stateStack) {			
		List<String> shortestResult = null;
		loop: for (RuleStateItem ruleStateItem: getAllRuleStateItems(stateStack)) {
			if (ruleStateItem.getRule().rightSize() < ruleStateItem.getPointerPosition()) {
				continue loop;
			}
			List<String> result = new ArrayList<String>();
			for (int i = ruleStateItem.getPointerPosition() - 1; 
					i < ruleStateItem.getRule().rightSize(); i++) {
				String symbol = ruleStateItem.getRule().getRightSymbol(i);
				if (Rule.isTerminal(symbol)) {
					result.add(symbol);
				} else {
					result.addAll(getShortesWord(symbol, new HashSet<String>()));
				}
			}
			if (shortestResult == null || shortestResult.size() > result.size()) {
				shortestResult = result;
			}
		}
		return shortestResult;		
	}
	
	private int reduceSize(RuleStateItem item) {
		return item.getPointerPosition();
	}
	
	private int followSize(RuleStateItem item) {
		return item.getRule().rightSize() - item.getPointerPosition();
	}
	
	private boolean parse(Stack<Integer> stack, String terminal) {
		while(true) {
			int currentState = stack.peek();		
			int action = getParserTables().getParseAction(currentState, terminal);		
			if (action == ParserTables.ACCEPT) {
				return true;
			} else if (action == ParserTables.ERROR) {
				Assert.isTrue(false);			
			} else if (action == ParserTables.SHIFT) {
				stack.push(getParserTables().getGotoState(currentState, terminal));
				return false;
			} else { // REDUCE
				Rule reduceRule = getParserTables().getSyntax().getRule(action);
				String symbol = reduceRule.getNonterminal();
				for (int i = 0; i < reduceRule.rightSize(); i++) {
					stack.pop();
				}
				currentState = stack.peek();
				stack.push(getParserTables().getGotoState(currentState, symbol));
			}
		}
	}
	
	private <E> Stack<E> copy(Stack<E> original) {

		Stack<E> result = new Stack<E>();
		for (E i: original) {
			result.add(i);
		}
		return result;

		//return new StackCopy<Integer>(original);
	}
	
	String depth(int depth) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < depth; i++) {
			result.append(" ");
		}
		return result.toString();
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
	private Collection<Integer> getMostReducedStatesForState(List<Integer> stack, Collection<Integer> states) {
		int state = stack.get(stack.size() - 1);
		if (states.contains(state)) {
			Collection<Integer> result = new ArrayList<Integer>();
			result.add(state);
			return result;
		}
		states.add(state);
		Collection<Integer> result = new ArrayList<Integer>();
		Collection<Rule> possibleReductions = getParserTables().
				getPossibleReductionsForState(state);
		if (possibleReductions.size() == 0) {
			result.add(state);
		} else {
			loop: for (Rule reduction: possibleReductions) {
				List<Integer> stackCopy = new ArrayList<Integer>(stack);
				int reductionSize = reduction.rightSize();
				for(int i = 0; i < reductionSize; i++) {
					stackCopy.remove(stack.size() - i - 1);
				}
				Integer gotoState = getParserTables().getGotoState(
						stackCopy.get(stackCopy.size() - 1), reduction.getNonterminal());
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
	
	private class Consume {
		final String terminal;
		final int state;
		public Consume(String terminal, int state) {
			super();
			this.terminal = terminal;
			this.state = state;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + state;
			result = prime * result
					+ ((terminal == null) ? 0 : terminal.hashCode());
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
			final Consume other = (Consume) obj;
			if (state != other.state)
				return false;
			if (terminal == null) {
				if (other.terminal != null)
					return false;
			} else if (!terminal.equals(other.terminal))
				return false;
			return true;
		}		
	}
}
