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

public class ValueToken implements IToken {

	private final String fValue;
	private final IToken fDefinition;
		
	public ValueToken(final IToken definition, final String value) {
		super();
		fValue = value;
		fDefinition = definition;
	}

	public boolean isPrefix(String string) {
		return fDefinition.isPrefix(string);
	}

	public String match(String string) {
		return fDefinition.match(string);
	}	
	
	public String getValue() {
		return fValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ValueToken) {
			return ((ValueToken)obj).fDefinition.equals(fDefinition); 
		} else {
			return fDefinition.equals(obj);
		}
	}

	@Override
	public int hashCode() {
		return fDefinition.hashCode();
	}

	@Override
	public String toString() {
		return fDefinition.toString();
	}	
}
