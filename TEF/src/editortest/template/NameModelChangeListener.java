package editortest.template;

import editortest.model.ModelEventListener;
import editortest.tefwidgets.IdentifierText;

public class NameModelChangeListener extends AbstractModelChangeListener {
	private final IdentifierText fIdentifierText;
	private final String fProperty;
	
	public NameModelChangeListener(final IdentifierText identifierText,
			final String property) {
		super();
		fIdentifierText = identifierText;
		fProperty = property;
	}

	@Override
	public void propertyChanged(Object value, String property) {
		if (property.equals(fProperty)) {
			fIdentifierText.setText((String)value);
		}			
	}		
}
