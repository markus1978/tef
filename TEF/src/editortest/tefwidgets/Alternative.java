package editortest.tefwidgets;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import editortest.template.AlternativeTemplate;
import editortest.widgets.CompoundText;
import editortest.widgets.Proposal;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;
import editortest.widgets.TextEventListener;

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
