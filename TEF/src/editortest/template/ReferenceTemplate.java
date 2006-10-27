package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.tefwidgets.IdentifierText;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;

public class ReferenceTemplate extends PropertyTemplate {		
	
	public ReferenceTemplate(String property, IMetaModelElement metaModel) {
		super(property, metaModel);
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
		return result;
	}

}
