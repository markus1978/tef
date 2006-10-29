package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.model.Set;
import editortest.tefwidgets.Abitrary;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public abstract class AbitraryTemplate extends Template<Set<IModelElement>> {
	
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
				IModelElement newElement = getElementTemplate().createModelFromEvent(event);
				fModel.add(newElement);
				return true;
			} else {
				return false;
			}			
		}		
	}
	
	public abstract Template<IModelElement> createElementTemplate();
	
	public final Template<IModelElement> getElementTemplate() {
		if (fElementTemplate == null) {
			fElementTemplate = createElementTemplate();
		}
		return fElementTemplate;
	}
	
	private Template<IModelElement> fElementTemplate = null;

	@Override
	public List<Proposal> getProposals() {
		return getElementTemplate().getProposals();
	}

	@Override
	public Text createText(Set<IModelElement> model) {
		Abitrary result = new Abitrary();
		result.addEventHandler(new MyTextEventListener(model));
		model.addChangeListener(new MyModelEventListener(result));
		for(IModelElement element: model) {
			if (getElementTemplate().isTemplateFor(element)) {
				result.addElement(getElementTemplate().createText(element));
			}
		}
		return result;
	}			
	
	public Text createTextForElement(IModelElement elementModel) {
		return getElementTemplate().createText(elementModel);
	}

	@Override
	public Set<IModelElement> createModelFromEvent(TextEvent event) {	
		return null;
	}
}
