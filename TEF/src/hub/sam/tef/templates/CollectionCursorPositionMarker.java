package hub.sam.tef.templates;

import hub.sam.tef.views.Text;


public class CollectionCursorPositionMarker {

	private final int fPosition;
	private final Object fObject; 
	private Text markedText = null;

	public CollectionCursorPositionMarker(final int position) {
		super();
		fPosition = position;
		fObject = null;
	}
	
	public CollectionCursorPositionMarker(final Object object) {
		fPosition = -1;
		fObject = object;
	}
	
	private boolean isMarked(int index, Object object) {
		if (fPosition == -1) {
			return object.equals(fObject);
		} else {
			return fPosition == index;
		}
	}
	
	public void mark(int index, Object object, Text text) {
		if (isMarked(index, object)) {
			markedText = text;
		}
	}
	
	public Text getMarkedText() {
		return markedText;
	}
	
}
