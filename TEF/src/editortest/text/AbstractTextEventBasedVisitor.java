package editortest.text;

public abstract class AbstractTextEventBasedVisitor extends AbstractOffsetBasedVisitor {

	private final TextEvent fEvent;
	private boolean result = false;
	
	public AbstractTextEventBasedVisitor(final TextEvent event) {
		super(event.getBegin());
		fEvent = event;
	}	

	protected final TextEvent getEvent() {
		return fEvent;
	}
	
	protected final TextEvent getEvent(int offset) {
		return new TextEvent(fEvent, offset);
	}
	
	protected final void updateEvent(TextEvent adoptedEvent, int offset) {
		fEvent.updateFromOffset(adoptedEvent, offset);
	}
	
	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		// empty			
	}

	public void visitText(Text visitedText, int atOffset) {
		int absolutOffset = visitedText.getAbsolutOffset(0);
		TextEvent adoptedEvent = getEvent(getEvent().getBegin() - absolutOffset);
		if (result || (adoptedEvent.getEnd() > visitedText.getLength())) {
			return;
		} else {						
			loop: for(TextEventListener eventHandler: visitedText.getEventHandler()) {				
				result |= dealWithEvent(adoptedEvent, visitedText, eventHandler);
				if (result) {
					updateEvent(adoptedEvent, absolutOffset);
					break loop;
				}
			}				
		}
	}

	public boolean getResult() {
		return result;
	}
	
	protected abstract boolean dealWithEvent(TextEvent event, Text visitedText,
			TextEventListener handler);
}
