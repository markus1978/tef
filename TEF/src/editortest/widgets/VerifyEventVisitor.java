package editortest.widgets;

public class VerifyEventVisitor extends AbstractTextEventBasedVisitor {
	
	public VerifyEventVisitor(TextEvent event) {
		super(event);
	}

	@Override
	protected boolean dealWithEvent(TextEvent event, Text visitedText, TextEventListener handler) {
		return handler.verifyEvent(event, visitedText);
	}
}
