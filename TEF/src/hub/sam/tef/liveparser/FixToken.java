package hub.sam.tef.liveparser;

public class FixToken implements IToken {

	private final String fString;
	
	public FixToken(String string) {
		super();
		fString = string;
	}

	public boolean isPrefix(String string) {
		return string.startsWith(fString);
	}

	public String match(String string) {
		if (isPrefix(string)) {
			return fString;
		} else {
			return null;
		}
	}

	@Override
	public boolean equals(Object otherToken) {
		if (otherToken instanceof FixToken) {
			return fString.equals(((FixToken)otherToken).fString);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fString.hashCode();
	}

	@Override
	public String toString() {
		return fString;
	}
}
