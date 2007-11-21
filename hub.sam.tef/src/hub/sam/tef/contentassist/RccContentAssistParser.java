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
import hub.sam.tef.tsl.impl.SyntaxImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;

public class RccContentAssistParser extends Parser {
	
	private static final long serialVersionUID = 1L;	
	private int completionOffset = -1;
	private boolean stop = false;
	private Token last = null;
	
	public RccContentAssistParser(ParserTables tables) {
		super(tables);
	}	
	
	public void setCompletionOffset(int offset) {
		this.completionOffset = offset;
	}
	
	
	@Override
	protected Token getNextToken() throws IOException {
		Token token = super.getNextToken();
		if (token.range.end.offset >= completionOffset) {
			last = new Token(token.symbol, 
					token.text, new Token.Range(
					((token.range.start.offset >= completionOffset)? 
							new Token.Address(0,0,completionOffset):
					token.range.start), new Token.Address(0,0,completionOffset)));
			stop = true;
			return new Token(null, token.text, token.range);
		} else {			
			return token;
		}		
	}

	public boolean completionParseOk() {
		return stop;
	}
	
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
			for (RuleStateItem grammarElement: stateNode.getRuleStateItems()) {
				Rule rccRule = grammarElement.getRule();
				int index = grammarElement.getPointerPosition();		
				if (rccRule.rightSize() >= index && 
						!rccRule.getNonterminal().equals("<START>") &&
						!rccRule.getNonterminal().equals(SyntaxImpl.START_SYMBOL)) {
					hub.sam.tef.tsl.Rule tslRule = syntax.getRuleForRccRule(rccRule);
					Assert.isTrue(tslRule instanceof SimpleRule, 
							"At this point all rules must be simple rules.");
					result.add(((SimpleRule)tslRule).getRhs().get(index - 1));
				}			
			}
		}
		return result;
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
