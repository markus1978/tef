/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef.liveparser;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.TestCase;

public class Tests extends TestCase {
	
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
	
	private Parser theStack;
	
	public void setUp() {
		theStack = new Parser(Arrays.asList(fRules), EXPR);
	}
	
	public void testEmptyPossibilities() {
		assertEquals(theStack.possibilities(), Arrays.asList(fRules));
	}
	
	public void testTokenPossibilities() throws Exception {
		theStack.shift(new FixToken("("));		

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new TokenRule(OBRACE, new FixToken("("))
		}));		
	}
	
	public void testTokenShiftReduce() throws Exception {
		theStack.shift(new ValueToken(new FixToken("("), "("));
		theStack.reduce(new TokenRule(OBRACE, new FixToken("(")));
		assertEquals(theStack.getHead(), OBRACE);
	}
	
	public void testSymbolPossibilities() throws Exception {				
		theStack.shift(new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"));
		theStack.reduce(new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")));				

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new SymbolRule(EXPR, new Object[] {ID})
		}));		
	}
	
	public void testIsPrefix() throws Exception {		
		theStack.shift(new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"));
		theStack.reduce(new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")));		
		theStack.reduce(new SymbolRule(EXPR, new Object[] {ID}));
		
		assertTrue(theStack.isPrefix(Arrays.asList(new Object[] { EXPR })));
	}
	
	public void testSymbolShiftReducePossibilities() throws Exception {				
		theStack.shift(new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"));
		theStack.reduce(new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")));		
		theStack.reduce(new SymbolRule(EXPR, new Object[] {ID}));

		assertEquals(theStack.possibilities(), Arrays.asList(new SyntaxRule[] {
				new SymbolRule(EXPR, new Object[] {EXPR, PLUS, EXPR}),
				new SymbolRule(EXPR, new Object[] {EXPR, TIMES, EXPR})
		}));		
	}
	
	public void testSymbolShiftReducePossibilities2() throws Exception {				
		for (IToken token: new IToken[] {
				new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"),
				new ValueToken(new FixToken("+"), "+"),			
		}) {
			theStack.parse(token);
		}		

		assertTrue(theStack.allPossibleTokens().contains(new FixToken("(")));	
	}
	
	public void testParse() throws Exception {
		for (IToken token: new IToken[] {
				new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"),
				new ValueToken(new FixToken("+"), "+"),
				new ValueToken(new FixToken("("), "("),
				new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"),
				new ValueToken(new FixToken("*"), "*"),
				new ValueToken(new RegexpToken("[a-zA-Z0-9_]+"), "test"),
				new ValueToken(new FixToken(")"), ")")
		}) {
			theStack.parse(token);
		}
		assertTrue(theStack.finished());
	}
	
	public void testScanner() throws Exception {
		Scanner scanner = new Scanner(Arrays.asList(new IToken[] {
				new FixToken("("),
				new RegexpToken("[a-zA-Z0-9_]+"),	
				new FixToken(")")
		}));
		scanner.setStringToScann("(hans)");
		assertTrue(scanner.next().equals(new FixToken("(")));
		assertTrue(scanner.next().equals(new RegexpToken("[a-zA-Z0-9_]+")));
		assertTrue(scanner.next().equals(new FixToken(")")));
	}
	
	public void testScannerParser() {
		Scanner scanner = new Scanner(Arrays.asList(new IToken[] {
				new FixToken("("),
				new RegexpToken("[a-zA-Z0-9_]+"),	
				new FixToken(")")
		}));
		scanner.setStringToScann("(hans)");
		assertTrue(theStack.parser(scanner));
		scanner.setStringToScann("(hans+)");
		assertFalse(theStack.parser(scanner));
		scanner.setStringToScann("(hans%");
		assertFalse(theStack.parser(scanner));
	}
}
