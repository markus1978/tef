package editortest.template.text;

import editortest.text.CompoundText;
import editortest.text.Text;

public class Alternative extends CompoundText {
	
	private boolean isSet = false;
	
	public boolean isSet() {
		return isSet;
	}
	
	public void setAlternative(Text newText) {
		addText(newText);
		isSet = true;
	}
}
