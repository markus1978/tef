package hub.sam.util.strings;

public class Change {
	
	public int pos;
	public  int length;
	public String text;

	public Change(int pos, int length, String text) {
		this.pos = pos;
		this.length = length;
		this.text = text;
	}

	int getStart() {
		return pos;
	}

	/**
	 * Checks whether otherChange is a change before this change in the
	 * document.
	 */
	boolean isBefore(Change otherChange) {
		return otherChange.pos + otherChange.length <= pos;
	}

	boolean colidesWith(Change otherChange) {
		return (!isBefore(otherChange) && otherChange.pos < pos + text.length());
	}

	void aggregateChange(Change otherChange) {
		int afterlap = (otherChange.length + otherChange.pos) - (pos + text.length());
		int newLength = 0;
		if (afterlap > 0) {
			newLength = length + afterlap;
		} else {
			newLength = length;
		}
		String newText = text.substring(0, otherChange.pos - pos)
				+ otherChange.text;
		if (afterlap < 0) {
			newText += text.substring(otherChange.pos - pos
					+ otherChange.length, text.length());
		}
		length = newLength;
		text = newText;
	}

	int getIndexBeforeChange(int index) {
		if (index <= pos) {
			return index;
		} else if (index > pos && index <= pos + text.length()) {
			return -1; // TODO?
		} else {
			return index + length - text.length();
		}
	}
	
	int getIndexAfterChange(int index) {
		if (index <= pos) {
			return index;
		} else if (index > pos && index <= pos + length) {
			return -1; // TODO?
		} else {
			return index - length + text.length();
		}
	}
	
	public static void test1() {
		StringBuffer test = new StringBuffer("0123456789");
		Change a = new Change(1, 2,"abcdef");
		
		Change b = new Change(3, 3, "ABCD");
		a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		System.out.println(test + ": 0abABCDf3456789");
	}
	
	public static void test2() {
		StringBuffer test = new StringBuffer("0123456789");
		Change a = new Change(1, 2,"abc");
		
		Change b = new Change(2, 4, "ABCDE");
		a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		System.out.println(test + ": 0aABCDE56789");
	}
	
	public static void test3() {
		StringBuffer test = new StringBuffer("0123456789");
		Change a = new Change(1, 2,"abc");
		
		Change b = new Change(2, 4, "A");
		a.aggregateChange(b);
		
		test.replace(a.pos, a.pos + a.length, a.text);
		System.out.println(test + ": 0aA56789");
	}
	
	public static void main(String args[]) {
		test1();
		test2();
		test3();
	}
}
