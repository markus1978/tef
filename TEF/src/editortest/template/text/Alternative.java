package editortest.template.text;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import editortest.template.AlternativeTemplate;
import editortest.text.CompoundText;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

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
