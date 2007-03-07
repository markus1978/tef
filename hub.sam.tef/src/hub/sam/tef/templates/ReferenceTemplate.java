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

import hub.sam.tef.ErrorAnnotation;
import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.ModelEventListener;
import hub.sam.tef.models.extensions.InternalModelElement;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;


public abstract class ReferenceTemplate extends ValueTemplate<IModelElement> {		

	private final IMetaModelElement fTypeModel;
	private final IReferenceProposalStrategy fStrategy;
	private final ElementTemplate fIdentifierTemplate;
	
	public ReferenceTemplate(Template template, IMetaModelElement typeModel, 
			IReferenceProposalStrategy strategy) {
		super(template, typeModel);
		this.fTypeModel = typeModel;
		if (strategy == null) {
			fStrategy = new IReferenceProposalStrategy() {
				public List<Proposal> getProposals(IMetaModelElement type) {
					List<Proposal> result = new Vector<Proposal>();
					for(IModelElement element: getModelProvider().getModel().getElements(type)) {
						result.add(getProposalForElement(element));
					}
					return result;
				}	
				private Proposal getProposalForElement(IModelElement element) {
					return new Proposal((String)element.getValue("name"), null, 0);
				}
			};
		} else {
			fStrategy = strategy;
		}
		this.fIdentifierTemplate = getElementTemplate();
	}	
	
	protected abstract ElementTemplate getElementTemplate();
	
	@Override
	public Template[] getNestedTemplates() {
		return new Template[] { fIdentifierTemplate };
	}
	
	@Override
	public Text createView(IModelElement model, final IValueChangeListener<IModelElement> changeListener) {		
		final CompoundText result = new CompoundText();		
		createValueView(result, model, changeListener);	
		result.addElement(IProposalHandler.class, new IProposalHandler(){
			public List<Proposal> getProposals(Text context, int offset) {
				return ReferenceTemplate.this.getProposals();
			}
			
			public boolean handleProposal(Text text, int offset, Proposal proposal) {			
				IModelElement value = getElementForProposal(proposal);
				if (value != null) {
					changeListener.valueChanges(value);					
					return true;
				} else {
					return false;
				}
			}

			public ProposalKind getProposalKind() {
				return ProposalKind.change;
			}	
			
		});
		return result;
	}
	
	@Override
	public void updateView(Text view, IModelElement value) {
		((CompoundText)view).removeText();					
		createValueView(view, value, null);	
	}

	private void createValueView(Text view, IModelElement value, final IValueChangeListener<IModelElement> changeListener) {
		final Text text = fIdentifierTemplate.getView(value, null);
		if (value instanceof InternalModelElement) {			
			text.addTextStatusListener(new ITextStatusListener() {
				private final ErrorAnnotation fError = new ErrorAnnotation(text);
				public void hidden() {					
					fError.removeFromAnnotationModel(getAnnotationModelProvider());					
				}

				public void shown() {
					fError.addToAnnotationModel(getAnnotationModelProvider());
				}				
			});
			value.addChangeListener(new ModelEventListener() {				
				@Override
				public void propertyChanged(Object element, String property) {				
					for(Proposal proposal: getProposals()) {
						if (mockObjectFitsProposal(proposal, (IModelElement)element)) {
							changeListener.valueChanges(getElementForProposal(proposal));
							return;
						}
					}
				}			
			});
		}
		((CompoundText)view).addText(text);
	}
	
	@Override
	public ICommand getCommandToCreateADefaultValue(final IModelElement owner, String property, boolean composite) {
		IModelElement mock = fIdentifierTemplate.createMockObject(); 		
		return getModel().getCommandFactory().set(owner, property, mock);
	}

	private IModelElement getElementForProposal(Proposal proposal) {
		for(IModelElement element: getModelProvider().getModel().getElements(fTypeModel)) {
			String name = (String)element.getValue("name");
			if (name != null && name.equals(proposal.getContextDisplayString())) {
				return element;
			}
		}
		return null;
	}
	
	@Override
	public List<Proposal> getProposals() {
		return fStrategy.getProposals(fTypeModel);
	}
	
	@Override
	public ICommand getCommandForProposal(Proposal proposal, IModelElement owner, 
			String property, int index) {
		return getModelProvider().getModel().getCommandFactory().add(owner, property, getElementForProposal(proposal), index);		
	}

	@Override
	public String getNonTerminal() {
		return super.getNonTerminal() + "_ref";
	}

	@Override
	public String[][] getRules() {
		return new String[][] {{ getNonTerminal(), fIdentifierTemplate.getNonTerminal() }};
	}

	public boolean mockObjectFitsProposal(Proposal proposal, IModelElement mock) {
		return  getElementForProposal(proposal).getValue("name").equals(mock.getValue("name"));
	}
}
