package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.controller.IProposalListener;
import editortest.controller.Proposal;
import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.Text;

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
		CompoundText result = new CompoundText();		
		createValueView(result, model);	
		result.addHandler(IProposalListener.class, new IProposalListener(){
			public List<Proposal> getProposals(Text context, int offset) {
				return ReferenceTemplate.this.getProposals();
			}
			
			public boolean insertProposal(Text text, int offset, Proposal proposal) {			
				IModelElement value = getElementForProposal(proposal);
				if (value != null) {
					changeListener.valueChanges(value);					
					return true;
				} else {
					return false;
				}
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
			brokenRef.putAttribute(HoldFlag.class, new HoldFlag());
			((CompoundText)view).addText(brokenRef);
		} else {
			((CompoundText)view).addText(fIdentifierTemplate.createView(value));
		}
	}

	protected IModelElement getElementForProposal(Proposal proposal) {
		for(IModelElement element: getModel().getElements(fTypeModel)) {
			if (element.getValue("name").equals(proposal.getContextDisplayString())) {
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
	public IModelElement createModelFromProposal(Proposal proposal) {
		return getElementForProposal(proposal);
	}
}
