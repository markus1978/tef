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
package hub.sam.tef.controllers;

public class CursorMovementStrategy {

	private final boolean fEdit;
	private final boolean fHold;
	
	/**
	 * This strategy detemines how the curser behaves when the user tries to
	 * set it on a view. 
	 * @param edit When true the curser hold at any position in the text.
	 * @param hold When true the curser holds at the text.
	 */
	public CursorMovementStrategy(final boolean edit, final boolean hold) {
		super();
		fEdit = edit;
		fHold = hold;
	}

	public boolean isEdit() {
		return fEdit;
	}

	public boolean isHold() {
		return fHold;
	}	
		
}
