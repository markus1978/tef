package editortest.tefwidgets;

import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.widgets.ChangeText;
import editortest.widgets.TextEvent;
import editortest.widgets.TextEventListener;

public class IdentifierText extends ChangeText {

	public String editText(TextEvent e) {
		return new StringBuffer(getContent()).replace(e.getBegin(), e.getEnd(), e.getText()).toString();
	}
}
