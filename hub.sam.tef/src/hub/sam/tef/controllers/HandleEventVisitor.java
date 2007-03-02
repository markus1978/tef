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

import hub.sam.tef.views.Text;

public class HandleEventVisitor extends AbstractTextEventBasedVisitor<ITextEventListener> {	
	
	public HandleEventVisitor(TextEvent event) {
		super(event);
	}

	@Override
	protected boolean dealWithEvent(TextEvent event, Text visitedText, ITextEventListener handler) {
		if (handler.verifyEvent(visitedText, event)) {
			return handler.handleEvent(visitedText, event);
		} else {
			return false;
		}
	}

	@Override
	protected Iterable<ITextEventListener> getHandler(Text visitedText) {
		return visitedText.getAllElements(ITextEventListener.class);
	}	
	
}
