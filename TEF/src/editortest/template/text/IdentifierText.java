package editortest.template.text;

import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.text.ChangeText;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public class IdentifierText extends ChangeText {

	public String editText(TextEvent e) {
		return new StringBuffer(getContent()).replace(e.getBegin(), e.getEnd(), e.getText()).toString();
	}
}
