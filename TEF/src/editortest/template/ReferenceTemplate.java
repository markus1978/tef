package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.template.text.IdentifierText;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public class ReferenceTemplate extends PropertyTemplate {		
	
	class MyModelEventHandler extends ModelEventListener {

		private final CompoundText fText;			
		
		public MyModelEventHandler(final CompoundText text) {
			super();
			fText = text;
		}

		@Override
		public void propertyChanged(Object value, String property) {			
			if (property.equals(getProperty())) {
				fText.removeText();			
				IModelElement valueModel = (IModelElement)value;
				if (valueModel == null) {
					fText.addText(new FixText("<broken-ref>"));
				} else {
					fText.addText(fIdentifierTemplate.createText(valueModel));
				}					
			}
		}		
	}
	
	class MyTextEventHandler extends TextEventListener {	
		private final ReferenceTemplate fTemplate;	
		private final IModelElement fModel;

		public MyTextEventHandler(final ReferenceTemplate template, final IModelElement model) {
			super();
			fTemplate = template;
			fModel = model;			
		}

		@Override
		public List<Proposal> getProposals(int offset, Text context) {
			return fTemplate.getProposals();
		}

		@Override
		public boolean handleEvent(TextEvent event, Text context) {
			IModelElement value = fTemplate.getElementForProposal(event.getText());
			if (value != null) {
				fModel.setValue(fTemplate.getProperty(), value);
				return true;
			} else {
				return false;
			}
		}		
	}
	
	static class MyReferenceProposalStrategy implements IReferenceProposalStrategy {
		private final IModel fModel;		
		public MyReferenceProposalStrategy(final IModel model) {
			super();
			fModel = model;
		}
		public List<Proposal> getProposals(IMetaModelElement type) {
			List<Proposal> result = new Vector<Proposal>();
			for(IModelElement element: fModel.getElements(type)) {
				result.add(getProposalForElement(element));
			}
			return result;
		}	
		private Proposal getProposalForElement(IModelElement element) {
			return new Proposal((String)element.getValue("name"), 
					(String)element.getValue("name"));
		}
	}
	
	private final IMetaModelElement fTypeModel;
	private final IReferenceProposalStrategy fStrategy;
	private final Template fIdentifierTemplate;
	
	public ReferenceTemplate(IModel model, String property, IMetaModelElement metaModel,
			IMetaModelElement typeModel, 
			IReferenceProposalStrategy strategy) {
		super(model, property, metaModel);
		this.fTypeModel = typeModel;
		this.fStrategy = strategy;
		this.fIdentifierTemplate = 
			new IdentifierTemplate(getModel(), "name", getMetaModel(), true);
	}	
	
	public ReferenceTemplate(IModel model, String property, 
			IMetaModelElement metaModel, IMetaModelElement typeModel) { 
		super(model, property, metaModel);
		this.fTypeModel = typeModel;
		this.fStrategy = new MyReferenceProposalStrategy(getModel());
		this.fIdentifierTemplate = 
			new IdentifierTemplate(getModel(), "name", getMetaModel(), true);
	}

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		return null;
	}

	@Override
	public Text createText(IModelElement model) {		
		CompoundText result = new CompoundText();
		IModelElement valueModel = (IModelElement)model.getValue(getProperty());
		if (valueModel == null) {
			result.addText(new FixText("<broken-ref>"));
		} else {
			result.addText(fIdentifierTemplate.createText(valueModel));
		}	
		model.addChangeListener(new MyModelEventHandler(result));
		result.addEventHandler(new MyTextEventHandler(this, model));
		return result;
	}
		
	protected IModelElement getElementForProposal(String name) {
		for(IModelElement element: getModel().getElements(fTypeModel)) {
			if (element.getValue("name").equals(name)) {
				return element;
			}
		}
		return null;
	}
	
	public List<Proposal> getProposals() {
		return fStrategy.getProposals(fTypeModel);
	}
}
