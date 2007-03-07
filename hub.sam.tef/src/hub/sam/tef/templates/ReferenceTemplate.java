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
import hub.sam.tef.models.InternalModelElement;
import hub.sam.tef.models.ModelEventListener;
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
		createValueView(result, model);	
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
		createValueView(view, value);	
	}

	private void createValueView(Text view, IModelElement value) {
		if (value == null) {
			//Text brokenRef = (new FixText("<broken-ref>"));
			//brokenRef.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(false, true));
			//((CompoundText)view).addText(brokenRef);
			InternalModelElement mock = new InternalModelElement(fTypeModel);
			mock.setValue("name", "<broken>");
			value = mock;
			value.addChangeListener(new ModelEventListener() {
				@Override
				public void propertyChanged(Object element, String property) {
					System.out.println("identifier changed ... " + property); 
					/*
					 * TODO
					 * find the identified object, or create a error decoration (maybe as part of a reconciler)
					 * if identified relpace the mock object by  a real object
					 */ 
				}				
			});
			final Text errorText = fIdentifierTemplate.getView(value, null);
			errorText.addTextStatusListener(new ITextStatusListener() {
				private final ErrorAnnotation fError = new ErrorAnnotation(errorText);
				public void hidden() {					
					fError.removeFromAnnotationModel(getAnnotationModelProvider());					
				}

				public void shown() {
					fError.addToAnnotationModel(getAnnotationModelProvider());
				}				
			});
			((CompoundText)view).addText(errorText);
			
		} else { 
			((CompoundText)view).addText(fIdentifierTemplate.getView(value, null));
		}		
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

}
