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
import hub.sam.tef.views.ITextVisitor;
import hub.sam.tef.views.Text;

import java.util.Collections;


/**
 * This abstract visitor visits only the texts that lay at a given position in the
 * document.
 */
public abstract class AbstractOffsetBasedVisitor implements ITextVisitor {

	private final int forOffset;
		
	/** 
	 * @param forOffset A position in the document. This visitor decents only into
	 * children that represent a part of the document at this offset.
	 */
	public AbstractOffsetBasedVisitor(final int forOffset) {
		super();		
		this.forOffset = forOffset;
	}

	public final Iterable<Text> decentInto(CompoundText text) {
		int absolutOffset = text.getAbsolutOffset(0);
		if (absolutOffset <= forOffset) {
			return text.getInnerTextAt(forOffset - text.getAbsolutOffset(0));
		} else {
			return Collections.emptyList();
		}
	}	
}
