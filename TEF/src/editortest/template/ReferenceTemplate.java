package editortest.template;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.tefwidgets.IdentifierText;
import editortest.widgets.Proposal;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;
import editortest.widgets.TextEventListener;

public class ReferenceTemplate extends PropertyTemplate {		
	
	class MyModelEventHandler extends ModelEventListener {

		private final IdentifierText fText;			
		
		public MyModelEventHandler(final IdentifierText text) {
			super();
			fText = text;
		}

		@Override
		public void propertyChanged(Object value, String property) {
			try {
			IModelElement valueModel = (IModelElement)value;
			if (valueModel == null) {
				fText.setText("<broken-ref>");
			} else {
				fText.setText((String)valueModel.getValue("name"));
			}
			} catch (Throwable e) {
				e.printStackTrace();
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
	
	private final IMetaModelElement fTypeModel;
	
	public ReferenceTemplate(String property, IMetaModelElement metaModel,
			IMetaModelElement typeModel) {
		super(property, metaModel);
		this.fTypeModel = typeModel;
	}	

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		return null;
	}

	@Override
	public Text createText(IModelElement model) {		
		IdentifierText result = new IdentifierText();
		IModelElement valueModel = (IModelElement)model.getValue(getProperty());
		if (valueModel == null) {
			result.setText("<broken-ref>");
		} else {
			result.setText((String)valueModel.getValue("name"));
			valueModel.addModelEventListener(new NameModelChangeListener(
					result, "name"));
		}	
		model.addModelEventListener(new MyModelEventHandler(result));
		result.addEventHandler(new MyTextEventHandler(this, model));
		return result;
	}
	
	protected Proposal getProposalForElement(IModelElement element) {
		return new Proposal((String)element.getValue("name"), 
				(String)element.getValue("name"));
	}	
	
	protected IModelElement getElementForProposal(String name) {
		for(IModelElement element: fTypeModel.getInstances()) {
			if (element.getValue("name").equals(name)) {
				return element;
			}
		}
		return null;
	}


	@Override
	public List<Proposal> getProposals() {
		List<Proposal> result = new Vector<Proposal>();
		for(IModelElement element: 
				fTypeModel.getInstances()) {
			result.add(getProposalForElement(element));
		}
		return result;
	}	
}
