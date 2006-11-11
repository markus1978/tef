package editortest.controller;

import editortest.text.Text;

public class VerifyEventVisitor extends AbstractTextEventBasedVisitor<ITextEventListener> {
	
	public VerifyEventVisitor(TextEvent event) {
		super(event);
	}

	@Override
	protected boolean dealWithEvent(TextEvent event, Text visitedText, ITextEventListener handler) {
		return handler.verifyEvent(visitedText, event);
	}

	@Override
	protected Iterable<ITextEventListener> getHandler(Text visitedText) {
		return visitedText.getHandler(ITextEventListener.class);
	}	
	
}
