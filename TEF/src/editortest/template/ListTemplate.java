package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.model.Set;
import editortest.template.text.Abitrary;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public abstract class ListTemplate extends PropertyTemplate {
		
	public ListTemplate(String property, IMetaModelElement metaModel) {
		super(property, metaModel);
	}
	
	public abstract Template getElementTemplate();
	
	class MyModelEventListener extends ModelEventListener {
		private final Abitrary fText;

		public MyModelEventListener(final Abitrary text) {
			super();
			fText = text;
		}

		@Override
		public void elementAdded(Object element) {
			fText.addElement(getElementTemplate().createText((IModelElement)element));
		}		
	}
	
	class MyTextEventListener extends TextEventListener {
		private final Set<IModelElement> fModel;

		public MyTextEventListener(final Set<IModelElement> model) {
			super();
			fModel = model;
		}

		@Override
		public List getProposals(int offset, Text context) {
			List<Proposal> result = new Vector<Proposal>();		
			result.addAll(getElementTemplate().getProposals());		
			return result;
		}

		@Override
		public boolean handleEvent(TextEvent event, Text context) {
			boolean isProposed = false;
			for(Proposal proposal: (Iterable<Proposal>)getElementTemplate().getProposals()) {
				if (proposal.getFReplaceProposal().equals(event.getText())) {
					isProposed = true;
				}
			}
			if (isProposed) {				
				IModelElement newElement = (IModelElement)getElementTemplate().createModelFromEvent(event);
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
	public IModelElement createModelFromEvent(TextEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text createText(IModelElement model) {
		Abitrary result = new Abitrary();
		Set elements = (Set)model.getValue(getProperty());
		result.addEventHandler(new MyTextEventListener(elements));
		elements.addChangeListener(new MyModelEventListener(result));
		for (Object element: (Set)model.getValue(getProperty())) {
			if (getElementTemplate().isTemplateFor(element)) {
				result.addElement(getElementTemplate().createText((IModelElement)element));
			}
		}		
		return result;
	}		
}
