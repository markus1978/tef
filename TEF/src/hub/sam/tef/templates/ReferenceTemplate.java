package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;


public abstract class ReferenceTemplate extends ValueTemplate<IModelElement> {		

	private final IMetaModelElement fTypeModel;
	private final IReferenceProposalStrategy fStrategy;
	private final ElementTemplate fIdentifierTemplate;
	
	public ReferenceTemplate(Template template, IMetaModelElement typeModel, 
			IReferenceProposalStrategy strategy) {
		super(template);
		this.fTypeModel = typeModel;
		if (strategy == null) {
			fStrategy = new IReferenceProposalStrategy() {
				public List<Proposal> getProposals(IMetaModelElement type) {
					List<Proposal> result = new Vector<Proposal>();
					for(IModelElement element: getModel().getElements(type)) {
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
			Text brokenRef = (new FixText("<broken-ref>"));
			brokenRef.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(false, true));
			((CompoundText)view).addText(brokenRef);
		} else {
			((CompoundText)view).addText(fIdentifierTemplate.createView(value));
		}
	}
	
	private IModelElement getElementForProposal(Proposal proposal) {
		for(IModelElement element: getModel().getElements(fTypeModel)) {
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
		return getModel().getCommandFactory().add(owner, property, getElementForProposal(proposal), index);		
	}
}
