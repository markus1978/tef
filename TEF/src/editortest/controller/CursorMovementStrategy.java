package editortest.controller;

public class CursorMovementStrategy {

	private final boolean fEdit;
	private final boolean fHold;
	
	public CursorMovementStrategy(final boolean edit, final boolean hold) {
		super();
		fEdit = edit;
		fHold = hold;
	}

	public boolean isEdit() {
		return fEdit;
	}

	public boolean isHold() {
		return fHold;
	}	
		
}
