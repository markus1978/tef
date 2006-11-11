package editortest.controller;

import editortest.view.Text;

public interface ITextEventListener {
	
	public boolean verifyEvent(Text text, TextEvent event);
	
	public boolean handleEvent(Text text, TextEvent event);
	
}
