package hub.sam.util.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Changes {
	final LinkedList<Change> changes = new LinkedList<Change>();
	final List<Change> changes2 = new Vector<Change>();
	
	public void addChange(Change change) {
		changes2.add(change);
		int i= 0;
		for (Change existingChange: changes) {
			if (existingChange.colidesWith(change)) {
				existingChange.aggregateChange(change);
				return;
			} else if (existingChange.isBefore(change)) {
				changes.add(i, change);
				return;
			} else {
				i++;
			}
		}
		changes.add(change);
	}
	
	public int getIndexBeforeChanges(int index) {
		int difference = 0;
		for (Change change: changes) {
			if (index <= change.pos) {
				return index + difference;
			} else {
				int newIndex = change.getIndexBeforeChange(index);
				if (newIndex != -1) {
					difference += newIndex - index;
				} else {
					return -1;
				}
			}
		}		
		return index + difference;
	}
	
	public int getIndexAfterChanges(int index) {
		int difference = 0;
		for (Change change: changes) {
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
		for (Change change: changes2) {
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
		System.out.println(document.charAt(changes.getIndexBeforeChanges(9)));		
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
	
	public static void main(String args[]) {
		test1();
		test2();
	}
	
}