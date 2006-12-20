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
