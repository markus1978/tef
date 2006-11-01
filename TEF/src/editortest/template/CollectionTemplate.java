package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.model.ICollection;
import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.template.text.Abitrary;
import editortest.text.IProposalListener;
import editortest.text.Proposal;
import editortest.text.Text;

public abstract class CollectionTemplate extends PropertyTemplate {
		
	public CollectionTemplate(IModel model, String property, 
			IMetaModelElement metaModel) {
		super(model, property, metaModel);
	}
	
	public abstract Template getElementTemplate();
	
	class MyModelEventListener extends ModelEventListener {
		private final Abitrary fText;

		public MyModelEventListener(final Abitrary text) {
			super();
			fText = text;
		}

		@Override
		public void elementAdded(Object element, int index) {
			fText.addElement(getElementTemplate().createText((IModelElement)element));
		}		
	}
	
	class MyTextEventListener implements IProposalListener {
		private final ICollection<IModelElement> fModel;

		public MyTextEventListener(final ICollection<IModelElement> model) {
			super();
			fModel = model;
		}
		
		public List getProposals(Text context, int offset) {
			List<Proposal> result = new Vector<Proposal>();		
			result.addAll(getElementTemplate().getProposals());		
			return result;
		}

		
		public boolean insertProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {				
				IModelElement newElement = (IModelElement)getElementTemplate().createModelFromProposal(proposal);
				fModel.add(newElement);
				return true;
			} else {
				return false;
			}			
		}		
	}
	
	@Override
	public List<Proposal> getProposals() {
		return getElementTemplate().getProposals();
	}

	@Override
	public IModelElement createModelFromProposal(Proposal proposal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text createText(IModelElement model) {
		Abitrary result = new Abitrary();
		ICollection elements = (ICollection)model.getValue(getProperty());
		result.addProposalHandler(new MyTextEventListener(elements));
		elements.addChangeListener(new MyModelEventListener(result));
		for (Object element: (ICollection)model.getValue(getProperty())) {
			if (getElementTemplate().isTemplateFor(element)) {
				result.addElement(getElementTemplate().createText((IModelElement)element));
			}
		}		
		return result;
	}		
}
