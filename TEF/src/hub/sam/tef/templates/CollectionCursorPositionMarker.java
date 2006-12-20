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

import hub.sam.tef.views.Text;


public class CollectionCursorPositionMarker {

	private final int fPosition;
	private final Object fObject; 
	private Text markedText = null;

	public CollectionCursorPositionMarker(final int position) {
		super();
		fPosition = position;
		fObject = null;
	}
	
	public CollectionCursorPositionMarker(final Object object) {
		fPosition = -1;
		fObject = object;
	}
	
	private boolean isMarked(int index, Object object) {
		if (fPosition == -1) {
			return object.equals(fObject);
		} else {
			return fPosition == index;
		}
	}
	
	public void mark(int index, Object object, Text text) {
		if (isMarked(index, object)) {
			markedText = text;
		}
	}
	
	public Text getMarkedText() {
		return markedText;
	}
	
}
