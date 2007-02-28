package hub.sam.util.strings;

public class Change {
	
	public final int pos;
	public final int length;
	public final String text;

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

	public Change aggregateChange(Change otherChange) {		
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
		return new Change(pos, newLength, newText);
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
	
	@Override
	public String toString() {
		return "[" + pos + ", " + (pos + length) + "]:" + text;
	}
}
