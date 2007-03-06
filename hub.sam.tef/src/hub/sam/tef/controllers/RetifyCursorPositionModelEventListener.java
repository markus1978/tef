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

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;


/**
 * Normally a ModelEventListener is only used to react to model changes and
 * update a representing view accordingly. This listener however
 * should be used for that plus that it allows the view to change the actual
 * cursor postion.
 */
public abstract class RetifyCursorPositionModelEventListener extends TransientTextModelEventListener {

	private final Text fShownText;
	private final ICursorPostionProvider fCursorPostionProvider;
	
	public RetifyCursorPositionModelEventListener(IModelElement model, Text aShownText, 
			ICursorPostionProvider cursorPositionProvider) {
		super(model, aShownText);
		fShownText = aShownText;
		fCursorPostionProvider = cursorPositionProvider;
	}

	/**
	 * Set a cursor postion that is used the next time that the document changes
	 * are propagated to the hosting platform editor.
	 * 
	 * @param text
	 *            The text where the cursor should be placed.
	 * @param offset
	 *            A offset relative to the beginning of the text.
	 */
	protected final void setNewCursorPosition(Text text, int offset) {		
		if (!fShownText.isHidden()) {			
			fCursorPostionProvider.setNewCursorPosition(text, offset);
		}
	}
}
