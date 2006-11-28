package hub.sam.tef.liveparser;

public class RegexpToken implements IToken {

	private final String fRegexp;

	public RegexpToken(final String regexp) {
		super();
		fRegexp = regexp;
	}

	public boolean isPrefix(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public String match(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RegexpToken) {
			return ((RegexpToken)obj).fRegexp.equals(fRegexp);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fRegexp.hashCode();
	}
	
	@Override
	public String toString() {
		return fRegexp;
	}
	
}
