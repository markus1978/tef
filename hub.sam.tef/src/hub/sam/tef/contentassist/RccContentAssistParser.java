package hub.sam.tef.contentassist;

import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.parsertables.LALRSyntaxNode;
import hub.sam.tef.rcc.parsertables.SLRSyntaxNode.RuleStateItem;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.WhiteSpace;
import hub.sam.tef.tsl.impl.SyntaxImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;

public class RccContentAssistParser extends Parser implements Cloneable {
	
	private static final long serialVersionUID = 1L;	
	private int completionOffset = -1;
	private boolean stop = false;
	private Token last = null;
	private boolean resume = false;
	private boolean lastOvershoot = false;
	
	public RccContentAssistParser(ParserTables tables) {
		super(tables);
	}		
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		RccContentAssistParser clone = (RccContentAssistParser)super.clone();
		clone.last = null;
		return clone;
	}



	/**
	 * Sets up this parser for a new completion parse.
	 */
	public void setCompletionOffset(int offset) {
		this.completionOffset = offset;
		resume = false;
		last = null;
		stop = false;
		lastOvershoot = false;
	}
		
	/**
	 * Different from the original method, this one does not pass the next token
	 * to the parser when this token touches the completion offset. It rather
	 * stops the parser by returning an lexer error and prepares a token that
	 * can be used to determine the prefix of what the user wanted to type last.
	 * 
	 * It behaves differently depending on whether this is a resumed completion
	 * parse or not.
	 */
	@Override
	protected Token getNextToken() throws IOException {
		Token token = super.getNextToken();
		
		if (!resume) {
			if (   token.symbol == null
				|| (Token.isEpsilon(token) && token.range.start.offset >= completionOffset))
			{
				last = null;
				stop = true;
				return new Token(null, token.text, token.range);
			} else if (token.range.end.offset == completionOffset && 
					Token.isFixedTerminal(token.symbol)) {
				return token;
			} else  if (token.range.end.offset >= completionOffset) {
				if (token.range.end.offset > completionOffset) {
					lastOvershoot = true;
				}
				if (token.range.start.offset != completionOffset) {
					last = new Token(token.symbol, 
							token.text, new Token.Range(
							((token.range.start.offset >= completionOffset)? 
									new Token.Address(0,0,completionOffset):
							token.range.start), new Token.Address(0,0,completionOffset)));
				} else {
					last = null;
				}
				stop = true;
				return new Token(null, token.text, token.range);			
			} else {			
				return token;
			}
		} else {
			if (!stop) {
				stop = true;
				return last;				
			} else {
				last = null;
				return new Token(null, token.text, token.range);
			}
		}
	}
	
	/**
	 * Allows to resume content assist parsing when the last token of the last
	 * content assist parse was a pattern. The idea behind content assist parse
	 * resume is that after a pattern the user might wanted to continue the
	 * pattern (e.g. a name) or wanted to start with the next token. So on the
	 * first completion run the last pattern is not acutally parsed, so that
	 * content assist can be collected as if the user was just about to enter a
	 * name. On the resume parse this last pattern is parsed and it is tried to
	 * consume the next token, which will stop the parse because it has to reach
	 * the completion offset, which was actually also reached on the first
	 * parse, but now we can collect completion proposals as if the user was
	 * finish entering a name.
	 */
	public void resumeContentAssistParse() throws IOException {
		Assert.isTrue(lastTokenWasAPattern());
		resume = true;
		stop = false;
		resumeParse();
	}
	
	/**
	 * {@link #resumeContentAssistParse()}
	 */
	public boolean lastTokenWasAPattern() {
		if (last != null && last.symbol != null) {
			return !Token.isFixedTerminal(last.symbol) && !lastOvershoot;
		} else {
			return false;
		}
	}

	/**
	 * @return true if the content could be parsed up to the completion offset.
	 *         The actual result of the parsing is usually false, because we
	 *         pretended a lexer error at the completion offset.
	 */
	public boolean completionParseOk() {
		return stop;
	}
	
	/**
	 * @return the last token that was not parsed, but touches the completion
	 *         offset. This is the token that the user just wanted to type.
	 */
	public Token getLastToken() {
		return last;
	}

	@Override
	public boolean parse() throws IOException {		
		return super.parse();
	}
	
	/**
	 * Returns all symbols (this includes their position in a specific rule)
	 * valid follow up according to the actual parse state.
	 * 
	 * @return a collection of symbols, where the containment of the symbol in a
	 *         specific rule makes a difference.
	 */
	public Collection<Symbol> getFollowSymbols(Syntax syntax) throws TslException {
		Collection<Symbol> result = new ArrayList<Symbol>();
		List<LALRSyntaxNode> syntaxNodes = 
			((LALRParserTables)getParserTables()).getSyntaxNodes();		
		Collection<Integer> stateAndReducedStates = new ArrayList<Integer>();
		getStateAndReducedStatesForState(stateStack, stateAndReducedStates);		
		for (int state: stateAndReducedStates) {
			LALRSyntaxNode stateNode = syntaxNodes.get(state);
			loop: for (RuleStateItem grammarElement: stateNode.getRuleStateItems()) {
				Rule rccRule = grammarElement.getRule();
				int index = grammarElement.getPointerPosition();		
				if (rccRule.rightSize() >= index && 
						!rccRule.getNonterminal().equals("<START>") &&
						!rccRule.getNonterminal().equals(SyntaxImpl.START_SYMBOL)) {
					hub.sam.tef.tsl.Rule tslRule = syntax.getRuleForRccRule(rccRule);
					if (tslRule == null) {
						continue loop;
					}
					Assert.isTrue(tslRule instanceof SimpleRule, 
							"At this point all rules must be simple rules.");					
					result.add(((SimpleRule)tslRule).getRhs().get(
							recalculateIndex(index - 1, (SimpleRule)tslRule)));
				}			
			}
		}
		return result;
	}
	
	/**
	 * @param index
	 *            based on a RCC rule.
	 * @param tslRule
	 *            the TSL rule for the RCC rule that the index is from.
	 * @return the equivalent index for the TSL rule.
	 */
	private int recalculateIndex(int index, SimpleRule tslRule) {
		int result = index;
		int i = 0;
		for (Symbol rhsPart: tslRule.getRhs()) {
			if (rhsPart instanceof WhiteSpace) {
				result++;
			} else {
				i++;
			}
			if (i > index) {
				return result;
			}
		}
		Assert.isTrue(false, "supposed unreachable");
		return -1;
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
	private void getStateAndReducedStatesForState(List<Integer> stack, Collection<Integer> states) {
		int state = stack.get(stack.size() - 1);
		if (states.contains(state)) {
			return;
		}
		states.add(state);
		Collection<Rule> possibleReductions = getParserTables().
				getPossibleReductionsForState(state);
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
			
			getStateAndReducedStatesForState(stackCopy, states);
		}		
	}
}
