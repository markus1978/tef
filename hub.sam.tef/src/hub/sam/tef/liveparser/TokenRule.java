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

public class TokenRule extends SyntaxRule {
	private final IToken fToken;

	public TokenRule(Object symbol, final IToken token) {
		super(symbol);
    	this.fToken = token;
	}

	public IToken getToken() {
		return fToken;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof TokenRule) {
			return ((TokenRule)obj).fToken.equals(fToken);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return fToken.hashCode() + super.hashCode();
	}
	
	@Override
	public String toString() {
		return getSymbol() + "->" + fToken;
	}
}
