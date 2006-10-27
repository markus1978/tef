package editortest.widgets;

public class HandleEventVisitor extends AbstractTextEventBasedVisitor {	
	
	public HandleEventVisitor(TextEvent event) {
		super(event);
	}

	@Override
	protected boolean dealWithEvent(TextEvent event, Text visitedText, TextEventListener handler) {
		return handler.handleEvent(event, visitedText);
	}
}
