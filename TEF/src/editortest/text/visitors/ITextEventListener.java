package editortest.text.visitors;

import editortest.text.Text;

public interface ITextEventListener {
	
	public boolean verifyEvent(Text text, TextEvent event);
	
	public boolean handleEvent(Text text, TextEvent event);
	
}
