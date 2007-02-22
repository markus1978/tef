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

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.Text;

import java.util.Collections;
import java.util.List;


/**
 * ValueTemplates describe values. They are opposite to PropertyTemplates, which
 * describe properties, the container of values. In a Template hierarchy
 * ValueTemplates and PropertyTemplates alternate along a path.
 */
public abstract class ValueTemplate<ModelType> extends Template {
	
	public ValueTemplate(Template template, IType type) {
		super(template);
		this.fType = type;
	}
	
	public ValueTemplate(DocumentText document, IType type) {
		super(document);
		this.fType = type;
	}
	
	private final IType fType;
	
	public IType getType() {
		return fType;
	}
	
	/**
	 * Creates a view for the models that should be displayed as described by
	 * this template. It also installes a given changeListener. This listener is
	 * expected to be notified when a user event to the created view should lead
	 * to a change in the model.
	 * 
	 * @param model
	 *            The model, e.g. the value.
	 * @param changeListener
	 *            A change listener that has to be notified when the value is
	 *            changes by the user.
	 * @return The created view.
	 */
	public abstract Text createView(ModelType model, IValueChangeListener<ModelType> changeListener);
	
	public boolean isTemplateFor(ModelType model) {
		return true;
	}
	
	/**
	 * This method takes a view created for an old value and changes it to fit
	 * the new value. This method is used after a model change event occured.
	 * 
	 * @param view
	 *            The view representing the old model.
	 * @param value
	 *            The new model for the given view.
	 *     
	 * @return The updated view.
	 */
	public void updateView(Text view, ModelType value) {
		//emtpy
	}
	
	/**
	 * Returns content assist proposals for editing the value.
	 * 
	 * @return A list of proposals.
	 */
	public List<Proposal> getProposals() {
		return Collections.EMPTY_LIST;
	}
	
	public ICommand getCommandForProposal(Proposal proposal, IModelElement owner, 
			String property, int index) {
		return null;
	}

	@Override
	public String getNonTerminal() {
		return getType().toString();
	}

}
