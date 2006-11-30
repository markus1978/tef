package hub.sam.tef.liveparser;

import java.util.Collection;

public class Scanner {

	private String stringToScan = null;
	private final Collection<IToken> fToken;		
	
	public Scanner(final Collection<IToken> token) {
		super();		
		fToken = token;
	}
	
	public void setStringToScann(String stringToScan) {
		this.stringToScan = stringToScan;
	}

	public IToken next() {
		for (IToken token: fToken) {			
			if (token.isPrefix(stringToScan)) {
				stringToScan = stringToScan.substring(token.match(stringToScan).length());
				return token;
			}
		}
		return null;
	}
}
