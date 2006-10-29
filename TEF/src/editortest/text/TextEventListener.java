package editortest.text;

import java.util.List;
import java.util.Vector;

public abstract class TextEventListener<ContextType extends Text> {

	public boolean verifyEvent(TextEvent event, ContextType context) {
		return false;
	}
	
	public boolean handleEvent(TextEvent event, ContextType context) {
		return false;
	}
	
	public List<Proposal> getProposals(int offset, ContextType context) {
		return new Vector<Proposal>();
	}	
}
