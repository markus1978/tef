package editortest.controller;

public class CursorMovementStrategy {

	private final boolean fEdit;
	private final boolean fHold;
	
	/**
	 * This strategy detemines how the curser behaves when the user tries to
	 * set it on a view. 
	 * @param edit When true the curser hold at any position in the text.
	 * @param hold When true the curser holds at the text.
	 */
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
