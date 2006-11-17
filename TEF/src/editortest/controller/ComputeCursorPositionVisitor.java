package editortest.controller;

import editortest.view.CompoundText;
import editortest.view.Text;

public class ComputeCursorPositionVisitor extends AbstractOffsetBasedVisitor {

	private final boolean fNextPos;
	private final boolean fJumpPos;	
	private int result = -1;

	public ComputeCursorPositionVisitor(int forOffset, final boolean nextPos, final boolean jumpPos) {
		super(forOffset);
		fNextPos = nextPos;
		fJumpPos = jumpPos;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		// empty		
	}

	public void visitText(Text visitedText, int atOffset) {
		int absolutOffset = visitedText.getAbsolutOffset(atOffset);
		Text runningText = fNextPos ? visitedText : visitedText.nextText(atOffset);
		boolean first = true;
		while (result == -1) {
			CursorMovementStrategy cursorMovementStrategy = runningText.getElement(CursorMovementStrategy.class);
			if (cursorMovementStrategy == null || (!cursorMovementStrategy.isEdit() && !cursorMovementStrategy.isHold())) {
				Text nextText;
				if (fNextPos) {
					nextText = runningText.nextText();
				} else {
					nextText = runningText.prevText();
				}
				if (nextText == runningText) {
					result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
				} else {
					runningText = nextText;
				}
			} else if (cursorMovementStrategy.isEdit() && first) {
				int runningTextOffset = runningText.getAbsolutOffset(0);
				if (runningTextOffset <= absolutOffset && runningTextOffset + runningText.getLength() >= absolutOffset) {
					result = absolutOffset;
				} else {
					result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
				}
			} else if (cursorMovementStrategy.isHold()) {
				result = runningText.getAbsolutOffset(fNextPos ? 0 : runningText.getLength());
			}
			first = false;
		}
	}

	public int getResult() {
		return result;
	}	
	
	public boolean hasResult() {
		return result != -1;
	}
}
