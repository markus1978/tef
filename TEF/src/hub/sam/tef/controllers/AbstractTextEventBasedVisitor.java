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

public abstract class AbstractTextEventBasedVisitor<ListenerType> extends AbstractOffsetBasedVisitor {

	private final TextEvent fEvent;
	private boolean result = false;
	
	public AbstractTextEventBasedVisitor(final TextEvent event) {
		super(event.getBegin());
		fEvent = event;
	}	

	protected final TextEvent getEvent() {
		return fEvent;
	}
	
	protected final TextEvent getEvent(int offset) {
		return new TextEvent(fEvent, offset);
	}
	
	protected final void updateEvent(TextEvent adoptedEvent, int offset) {
		fEvent.updateFromOffset(adoptedEvent, offset);
	}
	
	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);			
	}

	public void visitText(Text visitedText, int atOffset) {
		int absolutOffset = visitedText.getAbsolutOffset(0);
		TextEvent adoptedEvent = getEvent(getEvent().getBegin() - absolutOffset);
		if (result || (adoptedEvent.getEnd() > visitedText.getLength())) {
			return;
		} else {						
			loop: for(ListenerType eventHandler: getHandler(visitedText)) {				
				result |= dealWithEvent(adoptedEvent, visitedText, eventHandler);
				if (result) {
					updateEvent(adoptedEvent, absolutOffset);
					break loop;
				}
			}				
		}
	}

	public boolean getResult() {
		return result;
	}
	
	protected abstract boolean dealWithEvent(TextEvent event, Text visitedText,
			ListenerType handler);
	
	protected abstract Iterable<ListenerType> getHandler(Text visitedText);
}
