package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.template.text.IdentifierText;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public class IdentifierTemplate extends PropertyTemplate {

	class NameTextChangedListener extends TextEventListener<IdentifierText> {		
		private final IModelElement fModel;
		
		public NameTextChangedListener(final IModelElement model) {
			super();
			fModel = model;
		}

		@Override
		public boolean handleEvent(TextEvent event, IdentifierText context) {	
			if (verifyEvent(event, context)) {
				setIdentifier(fModel, context.editText(event));
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean verifyEvent(TextEvent event, IdentifierText context) {
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
	
	public IdentifierTemplate(IModel model, String property, 
			IMetaModelElement metaModel) {
		super(model, property, metaModel);
		fReadOnly = false;
	}
	
	public IdentifierTemplate(IModel model, String property, 
			IMetaModelElement metaModel, boolean readOnly) {
		super(model, property, metaModel);
		fReadOnly = readOnly;
	}

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
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
		return result;
	}	
}
