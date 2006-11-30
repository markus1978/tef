package hub.sam.tef.liveparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpToken implements IToken {

	private final String fRegexp;
	private final Pattern fPattern;

	public RegexpToken(final String regexp) {
		super();
		fRegexp = regexp;
		fPattern = Pattern.compile(regexp);
	}

	public boolean isPrefix(String string) {
		return match(string) != null;
	}

	public String match(String string) {
		Matcher matcher = fPattern.matcher(string);
		if (matcher.lookingAt()) {
			if  (matcher.start() == 0) {
				return string.substring(matcher.start(), matcher.end());
			} else {
				return null;
			}
		} else {
			return null;
		}
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
