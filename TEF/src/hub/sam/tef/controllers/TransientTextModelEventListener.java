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
import hub.sam.tef.models.ModelEventListener;
import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;

/**
 * This is a special model event listener for views that may be hidden in the future.
 * This listener registeres a {@link ITextStatusListener} at a given text and will
 * remove itself from the model is will be attached to.
 */
public abstract class TransientTextModelEventListener extends ModelEventListener {

	private boolean active;
	
	public TransientTextModelEventListener(final IModelElement model, Text text) {
		active = !text.isHidden();		
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {
				if (active) {
					model.removeChangeListener(TransientTextModelEventListener.this);
					active = false;
				}
			}

			public void shown() {
				if (!active) {
					model.addChangeListener(TransientTextModelEventListener.this);
					active = true;
				}
			}			
		});
	}
	
	public boolean isActive() {
		return active;
	}
		
}
