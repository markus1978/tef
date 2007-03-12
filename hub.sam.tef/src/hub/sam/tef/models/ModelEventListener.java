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
package hub.sam.tef.models;

import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;

public abstract class ModelEventListener {
	
	private final Text fView;	
	private final IModelElement fModel;

	public ModelEventListener(final Text view, final IModelElement model) {
		super();
		fView = view;
		fModel = model;
		fView.addTextStatusListener(new ITextStatusListener() {

			public void disposed() {
				model.removeChangeListener(ModelEventListener.this);
			}

			public void hidden() {
				
			}

			public void shown() {
				
			}
			
		});
	}
	
	protected final Text getView() { 
		return fView;		
	}
	
	protected final IModelElement getModelElement() {
		return fModel;
	}
	
	public void propertyChanged(Object element, String property) {
		
	}
}
