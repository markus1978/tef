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
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;


/**
 * This is a ValueTemplate that represents different types of 
 * values.
 */
public abstract class ChoiceTemplate<AbstractType> extends ValueTemplate<AbstractType> {
	
	private final ValueTemplate<? extends AbstractType>[] fAlternativeTemplates;
	
	public ChoiceTemplate(Template template) {
		super(template);
		this.fAlternativeTemplates = createAlternativeTemplates();
	}

	/**
	 * @return A set of value templates. These are the templates for all
	 *         possible values for this template.
	 */
	public abstract ValueTemplate<? extends AbstractType>[] createAlternativeTemplates();

	@Override
	public List<Proposal> getProposals() {
		List<Proposal> result = new Vector<Proposal>();
		for(ValueTemplate<? extends AbstractType> alternativeTemplate: fAlternativeTemplates) {
			result.addAll(alternativeTemplate.getProposals());
		}
		return result;
	}
	
	@Override
	public Text createView(AbstractType model, IValueChangeListener<AbstractType> changeListener) {		
			for(ValueTemplate alternativeTemplate: fAlternativeTemplates) {
				if (alternativeTemplate.isTemplateFor(model)) {
					return alternativeTemplate.createView(model, changeListener);				
				}
			}
			return null;
	}	
	
	public ICommand getCommandForProposal(Proposal proposal, IModelElement owner, 
			String property, int index) {
		for(ValueTemplate template: fAlternativeTemplates) {
			if (template.getProposals().contains(proposal)) {
				return template.getCommandForProposal(proposal, owner, property, index);
			}
		}
		return null;		
	}
}
