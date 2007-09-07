package hub.sam.util.strings;

import junit.framework.TestCase;

public class ChangeTest extends TestCase {

	
	private StringBuffer test;
	private String document = "0123456789";
	private Changes changes;
	
	@Override
	protected void setUp() throws Exception {
		document = "0123456789";
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
		assertEquals(document.charAt(changes.getIndexBeforeChanges(9, true)), test.toString().charAt(9));			
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
		assertEquals(changes.getIndexBeforeChanges(3, true), -1);		
	}
	
	public void testBug1() {
		document = "a.testProperty.foo";
		test = new StringBuffer(document);
		
		changes.addChange(new Change(14, 1, ""));
		changes.addChange(new Change(13, 1, ""));		
		changes.addChange(new Change(12, 1, ""));
		changes.addChange(new Change(11, 1, ""));
		changes.addChange(new Change(10, 1, ""));
		changes.addChange(new Change(9, 1, ""));
		changes.addChange(new Change(8, 1, ""));
		changes.addChange(new Change(7, 1, ""));
		changes.addChange(new Change(6, 1, ""));
		changes.addChange(new Change(5, 1, ""));
		changes.addChange(new Change(4, 1, ""));
		changes.addChange(new Change(3, 1, ""));
		changes.addChange(new Change(2, 1, ""));
		
		changes.apply(test);
		assertEquals(test.toString(), "a.foo");
		assertEquals(document.substring(changes.getIndexBeforeChanges(2, true), changes.getIndexBeforeChanges(5, false)), "foo");
		assertEquals(document.substring(changes.getIndexBeforeChanges(1, true), changes.getIndexBeforeChanges(2, false)), ".");
		assertEquals(document.substring(changes.getIndexBeforeChanges(1, true), changes.getIndexBeforeChanges(2, true)), ".testProperty.");
	}
	
}
