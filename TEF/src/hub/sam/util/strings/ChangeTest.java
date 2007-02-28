package hub.sam.util.strings;

import junit.framework.TestCase;

public class ChangeTest extends TestCase {

	
	private StringBuffer test;
	private final String document = "0123456789";
	private Changes changes;
	
	@Override
	protected void setUp() throws Exception {
		test = new StringBuffer(document);
		changes = new Changes();
	}

	public void testAggregationWithIn() {		
		Change a = new Change(1, 2,"abcdef");
		
		Change b = new Change(3, 3, "ABCD");
		a = a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		assertEquals(test.toString(), "0abABCDf3456789");
	}
	
	public void testAggregationEndLonger() {
		Change a = new Change(1, 2,"abc");
		
		Change b = new Change(2, 4, "ABCDE");
		a = a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		assertEquals(test.toString(), "0aABCDE56789");
	}
	
	public void testAggregationEndShorter() {
		Change a = new Change(1, 2,"abc");
		
		Change b = new Change(2, 4, "A");
		a = a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		assertEquals(test.toString(), "0aA56789");
	}
	
	public void testChangesIndexBefore() {
		Change a = new Change(1, 2,"abcdef");		
		test.replace(a.pos, a.pos + a.length, a.text);
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		test.replace(b.pos, b.pos + b.length, b.text);
		changes.addChange(b);

		assertEquals(test.toString(), "0abABCDf3456789");
		assertEquals(document.charAt(changes.getIndexBeforeChanges(9)), test.toString().charAt(9));			
	}
	
	public void testChangesIndexAfter() {
		Change a = new Change(1, 2,"abcdef");		
		test.replace(a.pos, a.pos + a.length, a.text);
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		test.replace(b.pos, b.pos + b.length, b.text);
		changes.addChange(b);
		
		assertEquals(test.toString(), "0abABCDf3456789");
		assertEquals(test.toString().charAt(changes.getIndexAfterChanges(4)), document.charAt(4));		
	}
	
	public  void testChangesApply() {
		Change a = new Change(1, 2,"abcdef");				
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		changes.addChange(b);
		
	    changes.apply(test);
	    assertEquals(test.toString(), "0abABCDf3456789");
		assertEquals(test.toString().charAt(changes.getIndexAfterChanges(4)), document.charAt(4));		
	}
	
	public  void testChangesHitIndex() {
		Change a = new Change(1, 2,"abcdef");				
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		changes.addChange(b);
		
	    changes.apply(test);
	    assertEquals(test.toString(), "0abABCDf3456789");
		assertEquals(test.toString().charAt(changes.getIndexBeforeChanges(3)), document.charAt(4));		
	}
	
}
