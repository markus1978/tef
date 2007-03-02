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

import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

public final class ComputeSelectionVisitor extends AbstractOffsetBasedVisitor {
	
	private Text result = null;
	private Text cursorPostionResult = null;
		
	public ComputeSelectionVisitor(final int forOffset) {
		super(forOffset);				
	}

	public void visitText(Text visitedText, int atOffset) {
		if (result == null && visitedText.getElement(MarkFlag.class) != null) {
			result = visitedText;
		}
		if (!(visitedText instanceof CompoundText)) {
			cursorPostionResult = visitedText;
		}
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		if (result == null) {
			visitText(visitedText, atOffset);
		}
	}	
	
	public Text getResult() {
		return result;
	}
	
	public Text getCursorPositionText() {
		return cursorPostionResult;
	}
}
