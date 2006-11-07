package editortest.text.visitors;

import editortest.text.Text;
import editortest.text.TextEvent;

public interface ITextEventListener {
	
	public boolean verifyEvent(Text text, TextEvent event);
	
	public boolean handleEvent(Text text, TextEvent event);
	
}
