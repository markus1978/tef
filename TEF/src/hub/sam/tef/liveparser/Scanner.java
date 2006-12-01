package hub.sam.tef.liveparser;

import java.util.Collection;
import java.util.HashSet;

public class Scanner {
	
	public static Collection<IToken> getTokensFromRules(Iterable<SyntaxRule> rules) {
		Collection<IToken> result = new HashSet<IToken>();
		for (SyntaxRule rule: rules) {
			if (rule instanceof TokenRule) {
				result.add(((TokenRule)rule).getToken());
			}
		}
		return result;
	}
	

	private String stringToScan = null;
	private final Collection<IToken> fToken;		
	
	public Scanner(final Collection<IToken> token) {
		super();		
		fToken = token;
	}
	
	public void setStringToScann(String stringToScan) {
		this.stringToScan = stringToScan;
	}

	public IToken next() throws ParseException {
		for (IToken token: fToken) {			
			if (token.isPrefix(stringToScan)) {
				String string = token.match(stringToScan);
				stringToScan = stringToScan.substring(string.length());
				return new ValueToken(token, string);
			}
		}
		if (stringToScan.equals("")) {
			return null;
		} else {
			throw new ParseException("scanner error");
		}
	}
}
