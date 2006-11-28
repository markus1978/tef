package hub.sam.tef.liveparser.tests;

import java.util.Arrays;

import hub.sam.tef.liveparser.FixToken;
import hub.sam.tef.liveparser.IToken;
import hub.sam.tef.liveparser.SyntaxRule;
import hub.sam.tef.liveparser.RegexpToken;
import hub.sam.tef.liveparser.Stack;
import hub.sam.tef.liveparser.SymbolRule;
import hub.sam.tef.liveparser.TokenRule;
import junit.framework.TestCase;

public class StackTests extends TestCase {
	
	private static final String OBRACE = "obrace";
	private static final String CBRACE = "cbrace";
	private static final String EXPR = "expr";
	private static final String PLUS = "plus";
	private static final String TIMES = "times";
	private static final String ID = "id";

	private final SyntaxRule[] fRules = {
			new SymbolRule(EXPR, new Object[] {OBRACE, EXPR, CBRACE}),
			new SymbolRule(EXPR, new Object[] {EXPR, PLUS, EXPR}),
			new SymbolRule(EXPR, new Object[] {EXPR, TIMES, EXPR}),
			new SymbolRule(EXPR, new Object[] {ID}),
			
			new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")),
			new TokenRule(OBRACE, new FixToken("(")),
			new TokenRule(CBRACE, new FixToken(")")),
			new TokenRule(PLUS, new FixToken("+")),
			new TokenRule(TIMES, new FixToken("*")),
	};
	
	private Stack theStack;
	
	public void setUp() {
		theStack = new Stack(Arrays.asList(fRules), EXPR);
	}
	
	public void testEmptyPossibilities() {
		assertEquals(theStack.possibilities(), Arrays.asList(fRules));
	}
	
	public void testTokenPossibilities() {
		theStack.shift(new FixToken("("));		

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new TokenRule(OBRACE, new FixToken("("))
		}));		
	}
	
	public void testTokenShiftReduce() {
		theStack.shift(new FixToken("("));
		theStack.reduce(new TokenRule(OBRACE, new FixToken("(")));
		assertEquals(theStack.getHead(), OBRACE);
	}
	
	public void testSymbolPossibilities() {				
		theStack.shift(new FixToken("[a-zA-Z0-9_]+"));
		theStack.reduce(new TokenRule(ID, new FixToken("[a-zA-Z0-9_]+")));				

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new SymbolRule(EXPR, new Object[] {ID})
		}));		
	}
	
	public void testIsPrefix() {		
		theStack.shift(new FixToken("[a-zA-Z0-9_]+"));
		theStack.reduce(new TokenRule(ID, new FixToken("[a-zA-Z0-9_]+")));		
		theStack.reduce(new SymbolRule(EXPR, new Object[] {ID}));
		
		assertTrue(theStack.isPrefix(Arrays.asList(new Object[] { EXPR })));
	}
	
	public void testSymbolShiftReducePossibilities() {				
		theStack.shift(new FixToken("[a-zA-Z0-9_]+"));
		theStack.reduce(new TokenRule(ID, new FixToken("[a-zA-Z0-9_]+")));		
		theStack.reduce(new SymbolRule(EXPR, new Object[] {ID}));

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new SymbolRule(EXPR, new Object[] {EXPR, PLUS, EXPR}),
				new SymbolRule(EXPR, new Object[] {EXPR, TIMES, EXPR})
		}));		
	}
	
	public void testSymbolShiftReducePossibilities2() {				
		for (IToken token: new IToken[] {
				new FixToken("[a-zA-Z0-9_]+"),
				new FixToken("+"),			
		}) {
			theStack.parse(token);
		}		

		assertTrue(theStack.allPossibleTokens().contains(new FixToken("(")));	
	}
	
	public void testParse() {
		for (IToken token: new IToken[] {
				new FixToken("[a-zA-Z0-9_]+"),
				new FixToken("+"),
				new FixToken("("),
				new FixToken("[a-zA-Z0-9_]+"),
				new FixToken("*"),
				new FixToken("[a-zA-Z0-9_]+"),
				new FixToken(")")				
		}) {
			theStack.parse(token);
		}
		assertTrue(theStack.finished());
	}
}
