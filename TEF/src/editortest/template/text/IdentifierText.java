package editortest.template.text;

import editortest.text.ChangeText;
import editortest.text.visitors.TextEvent;

public class IdentifierText extends ChangeText {

	public String editText(TextEvent e) {
		return new StringBuffer(getContent()).replace(e.getBegin(), e.getEnd(), e.getText()).toString();
	}
}
