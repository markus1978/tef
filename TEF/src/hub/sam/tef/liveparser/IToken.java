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

public interface IToken {
		
	/**
	 * @param string A string to match against this token.
	 * @return True if the given string starts with this token.
	 */
	public boolean isPrefix(String string);
	
	/**
	 * Returns the largest substring of string that matches this token and
	 * starts from the beginning of string.
	 * 
	 * @param string
	 *            The string to match against the token.
	 * @return The result.
	 */
	public String match(String string);
}
