package hub.sam.util.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Changes {
	final LinkedList<Change> combinedChanges = new LinkedList<Change>();
	final List<Change> allChanges = new Vector<Change>();
	
	public void addChange(Change change) {
		allChanges.add(change);
		int i= 0;
		for (Change existingChange: combinedChanges) {
			if (existingChange.colidesWith(change)) {
				combinedChanges.remove(existingChange);
				change = existingChange.aggregateChange(change);
				combinedChanges.add(i, change);
				return;
			} else if (existingChange.isBefore(change)) {
				combinedChanges.add(i, change);
				return;
			} else {
				i++;
			}
		}
		combinedChanges.add(change);
	}
	
	public int getIndexBeforeChanges(int index, boolean inclusive) {		
		for (Change change: combinedChanges) {
			boolean indexIsBefore = inclusive ? index < change.pos : index <= change.pos;			
			if (indexIsBefore) {
				return index;
			} else {
				int newIndex = change.getIndexBeforeChange(index, inclusive);
				if (newIndex != -1) {
					index = newIndex;
				} else {
					return -1;
				}
			}
		}		
		return index;
	}
	
	public int getIndexAfterChanges(int index) {
		int difference = 0;
		for (Change change: combinedChanges) {
			if (index <= change.pos) {
				return index + difference;
			} else {
				int newIndex = change.getIndexAfterChange(index);
				if (newIndex != -1) {
					difference += newIndex - index;
				} else {
					return -1;
				}
			}
		}		
		return index + difference;
	}
	
	public void apply(StringBuffer buffer) {
		for (Change change: allChanges) {
			buffer.replace(change.pos, change.pos + change.length, change.text);
		}
	}
	
	public static void test1() {
		String document = "0123456789";
		StringBuffer buffer = new StringBuffer(document);
		Changes changes = new Changes();
		
		Change a = new Change(1, 2,"abcdef");		
		buffer.replace(a.pos, a.pos + a.length, a.text);
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		buffer.replace(b.pos, b.pos + b.length, b.text);
		changes.addChange(b);
		
		System.out.println(buffer);
		System.out.println(document.charAt(changes.getIndexBeforeChanges(9, true)));		
	}
	
	public static void test2() {
		String document = "0123456789";
		StringBuffer buffer = new StringBuffer(document);
		Changes changes = new Changes();
		
		Change a = new Change(1, 2,"abcdef");		
		buffer.replace(a.pos, a.pos + a.length, a.text);
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		buffer.replace(b.pos, b.pos + b.length, b.text);
		changes.addChange(b);
		
		System.out.println(buffer);
		System.out.println(buffer.toString().charAt(changes.getIndexAfterChanges(4)));		
	}
	
	public static void test3() {
		String document = "0123456789";
		StringBuffer buffer = new StringBuffer(document);
		Changes changes = new Changes();
		
		Change a = new Change(1, 2,"abcdef");				
		changes.addChange(a);
		
		Change b = new Change(3, 3, "ABCD");
		changes.addChange(b);
		
	    changes.apply(buffer);
		System.out.println(buffer);
		System.out.println(buffer.toString().charAt(changes.getIndexAfterChanges(4)));		
	}
	
	public static void main(String args[]) {
		test1();
		test2();
		test3();
	}
	
}