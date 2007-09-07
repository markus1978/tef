package hub.sam.tef.completion;

import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.io.IOException;
import java.util.List;

import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

public class CompletionParser extends Parser {

	private final ParserTables fTables;	
	private int completionOffset = -1;
	
	private Token lastShiftedToken = null;	
	private Token actualToken = null;
	
	public CompletionParser(ParserTables tables) {
		super(tables);
		this.fTables = tables;
	}	

	@Override
	protected void setActualToken(Token token) {
		actualToken = token;
	}

	public Object getParseResult(int i) {
		return valueStack.get(valueStack.size() - i - 1);
	}

	public void reduce(Rule rule, int length) {
		List parseResults = valueStack.subList(valueStack.size() - length, valueStack.size());
		List<Token.Range> resultRanges = rangeStack.subList(rangeStack.size() - length, rangeStack.size());
		
		for (int i = 0; i < length; i++) {
			stateStack.pop();
		}
		
		Object parseResult = getSemantic().doSemantic(rule, parseResults, resultRanges);
		
		stateStack.push(-1);
		valueStack.push(parseResult);
		rangeStack.push(new Token.Range(new Token.Address(), new Token.Address()));
	}
	
	public void setCompletionOffset(int offset) {
		this.completionOffset = offset;
	}

	@Override
	protected Token shift(Token token) throws IOException {
		if (lastShiftedToken != null && token.range.end.offset >= completionOffset && token.symbol.equals("`identifier`")) {
			Token result = new Token(Token.EPSILON, "", new Token.Range(
					lastShiftedToken.range.end, lastShiftedToken.range.end)); 			
			lastShiftedToken = token;
			return result;
		} else {
			lastShiftedToken = token;
			return super.shift(token);
		}
	}
	
	public String getIdentifierPrefix() {
		if (lastShiftedToken != null && lastShiftedToken.symbol.equals("`identifier`")) {
			return (String)lastShiftedToken.text;
		} else if (actualToken.symbol.equals("`identifier`")) {
			return (String)actualToken.text;
		}
		return "";
	}

	/**
	 * Excermines the parse stacks and checks whether the last symbol on top of the stack is allowed to be
	 * there based on the forelast state. Since the last symbol created by the completion and not by the 
	 * parse table, it might be wrong. 
	 */
	public boolean hasValidStack() {
		int state = stateStack.get(stateStack.size() - 2);
		Object topParseResult = valueStack.get(valueStack.size() - 1);
		int gotoState = fTables.getGotoState(state, ((ASTElementNode)topParseResult).getElement().getSymbol());
		return gotoState != -1;
	}
	
	public void reset() {
		//lastShiftedToken = null; ... continue here 25.5.07 There is still a bug regarding completions of emty strings
	}

	@Override
	public boolean parse() throws IOException {		
		return super.parse();
	}		
}
