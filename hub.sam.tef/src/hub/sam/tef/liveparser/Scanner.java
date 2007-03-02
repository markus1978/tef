/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
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
