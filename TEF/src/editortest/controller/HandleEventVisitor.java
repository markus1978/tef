package editortest.controller;

import editortest.view.Text;

public class HandleEventVisitor extends AbstractTextEventBasedVisitor<ITextEventListener> {	
	
	public HandleEventVisitor(TextEvent event) {
		super(event);
	}

	@Override
	protected boolean dealWithEvent(TextEvent event, Text visitedText, ITextEventListener handler) {
		return handler.handleEvent(visitedText, event);
	}

	@Override
	protected Iterable<ITextEventListener> getHandler(Text visitedText) {
		return visitedText.getHandler(ITextEventListener.class);
	}	
	
}
