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
package hub.sam.tef.templates;

public class LayoutManager {
	
	public static final int SPACE = 1;
	public static final int BREAK = 2;
	public static final int INDENT = 3;
	public static final int BEGIN_BLOCK = 4;
	public static final int END_BLOCK = 5;

	class LayoutInformation {
		private final int fFunction;

		public LayoutInformation(final int function) {
			super();
			fFunction = function;
		}	
	}
		
	private String getIndent(int depth) {
		StringBuffer result = new StringBuffer("");
		for (int i = 0; i < depth; i++) {
			result.append("    ");
		}
		return result.toString();
	}
	
	private boolean inChange = false;
	

	public LayoutManager() {
		super();		
	}
}
