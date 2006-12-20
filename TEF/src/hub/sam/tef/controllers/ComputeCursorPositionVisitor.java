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

public class ComputeCursorPositionVisitor extends AbstractOffsetBasedVisitor {

	private final boolean fNextPos;
	private final boolean fJumpPos;	
	private int result = -1;

	public ComputeCursorPositionVisitor(int forOffset, final boolean nextPos, final boolean jumpPos) {
		super(forOffset);
		fNextPos = nextPos;
		fJumpPos = jumpPos;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		// empty		
	}

	public void visitText(Text visitedText, int atOffset) {
		int absolutOffset = visitedText.getAbsolutOffset(atOffset);
		Text runningText = fNextPos ? visitedText : visitedText.nextText(atOffset);
		boolean first = true;
		while (result == -1) {
			CursorMovementStrategy cursorMovementStrategy = runningText.getElement(CursorMovementStrategy.class);
			if (cursorMovementStrategy == null || (!cursorMovementStrategy.isEdit() && !cursorMovementStrategy.isHold())) {
				Text nextText;
				if (fNextPos) {
					nextText = runningText.nextText();
				} else {
					nextText = runningText.prevText();
				}
				if (nextText == runningText) {
					result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
				} else {
					runningText = nextText;
				}
			} else if (cursorMovementStrategy.isEdit() && first) {
				int runningTextOffset = runningText.getAbsolutOffset(0);
				if (runningTextOffset <= absolutOffset && runningTextOffset + runningText.getLength() >= absolutOffset) {
					result = absolutOffset;
				} else {
					result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
				}
			} else if (cursorMovementStrategy.isHold()) {
				result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
			}
			first = false;
		}
	}

	public int getResult() {
		return result;
	}	
	
	public boolean hasResult() {
		return result != -1;
	}
}
