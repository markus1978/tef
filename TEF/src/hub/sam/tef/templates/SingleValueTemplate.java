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

import hub.sam.tef.controllers.AbstractRequestHandler;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.controllers.RetifyCursorPositionModelEventListener;
import hub.sam.tef.liveparser.SymbolASTNode;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

public abstract class SingleValueTemplate<ModelType> extends PropertyTemplate<ModelType> {
	
	public SingleValueTemplate(ElementTemplate elementTemplate, String property) {
		super(elementTemplate, property);
	}
	
	class ModelEventListener extends RetifyCursorPositionModelEventListener {
		private final IModelElement fModel;
		private final Text valueView;
		
		public ModelEventListener(final IModelElement model, final Text valueView) {
			super(model, valueView);
			fModel = model;
			this.valueView = valueView;
		}

		@Override
		public void propertyChanged(Object element, String property) {
			if (property == getProperty()) {
				getValueTemplate().updateView(valueView, (ModelType)fModel.getValue(property));				
				setNewCursorPosition(valueView, 0);				
				valueView.update();				
			}			
		}	
	}
	
	class ValueChangeListener extends AbstractRequestHandler<ModelType> 
			implements IValueChangeListener<ModelType> {
		
		public ValueChangeListener(final IModelElement owner, String property) {
			super(owner, property, null);			
		}
		
		public void valueChanges(ModelType newValue) {
			getModel().getCommandFactory().set(getOwner(), getProperty(), newValue).execute();
		}

		public void valueChanges(SymbolASTNode node) {
			node.createModelElements(getModel(), getOwner(), getProperty());
		}

		public void newValue(Proposal proposal, ValueTemplate<ModelType> template) {
			template.getCommandForProposal(proposal, getOwner(), getProperty(), 0).execute();			
		}

		public void removeValue() {
			getModel().getCommandFactory().delete(getOwner().getValue(getProperty())).execute();
		}						
	}
	
	@Override
	public Text createView(final IModelElement model) {
		ModelType value = (ModelType)model.getValue(getProperty());
		final Text result = getValueTemplate().createView(value, 
				new ValueChangeListener(model, getProperty()));
		new ModelEventListener(model, result); // activates itself once the view is shown
		return result;
	}	
}
