package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.template.text.IdentifierText;
import editortest.text.ITextEventListener;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public class IdentifierTemplate extends PropertyTemplate {

	class NameTextChangedListener implements ITextEventListener {		
		private final IModelElement fModel;
		
		public NameTextChangedListener(final IModelElement model) {
			super();
			fModel = model;
		}

		public boolean handleEvent(Text context, TextEvent event) {	
			if (verifyEvent(context, event)) {
				setIdentifier(fModel, ((IdentifierText)context).editText(event));
				return true;
			} else {
				return false;
			}
		}

		public boolean verifyEvent(Text context, TextEvent event) {
			if (event.getEnd() <= context.getLength() && event.getBegin() >= 0) {
				return event.getText().matches("[a-zA-Z0-9_]*");
			} else {
				return false;
			}
		}	
	}
	
	protected String getIdentifier(IModelElement model) {
		return (String)model.getValue(getProperty());
	}
	
	protected void setIdentifier(IModelElement model, String identifier) {
		model.setValue(getProperty(), identifier);
	}
	
	private final boolean fReadOnly;
	
	public IdentifierTemplate(Template template, IModel model, String property, 
			IMetaModelElement metaModel) {
		super(template, model, property, metaModel);
		fReadOnly = false;
	}
	
	public IdentifierTemplate(Template template, IModel model, String property, 
			IMetaModelElement metaModel, boolean readOnly) {
		super(template, model, property, metaModel);
		fReadOnly = readOnly;
	}

	@Override
	public IModelElement createModelFromProposal(Proposal proposal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text createText(IModelElement model) {
		IdentifierText result = new IdentifierText();		
		String identifier = getIdentifier(model);
		if (identifier != null) {
			result.setText(identifier);
		} else {
			result.setText("<broken-ref>");
		}
		model.addChangeListener(new NameModelChangeListener(result, getProperty()));
		if (!fReadOnly) {
			result.addEventHandler(new NameTextChangedListener(model));
		}
		getDocument().getDocument().addOccurence(model, result);
		return result;
	}	
}
