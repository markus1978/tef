package hub.sam.tef.liveparser;

import java.util.Collection;

public class Scanner {

	private String stringToScan;
	private final Collection<IToken> fToken;		
	
	public Scanner(String stringToScan, final Collection<IToken> token) {
		super();
		this.stringToScan = stringToScan;
		fToken = token;
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
