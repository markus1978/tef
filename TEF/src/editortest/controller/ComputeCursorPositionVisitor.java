package editortest.controller;

import java.util.List;

import editortest.template.HoldFlag;
import editortest.view.ChangeText;
import editortest.view.CompoundText;
import editortest.view.Text;

public class ComputeCursorPositionVisitor extends AbstractOffsetBasedVisitor {

	private final boolean fNextPos;
	private final boolean fJumpPos;
	private boolean haveResult = false;
	private int result = 0;

	public ComputeCursorPositionVisitor(int forOffset, final boolean nextPos, final boolean jumpPos) {
		super(forOffset);
		fNextPos = nextPos;
		fJumpPos = jumpPos;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		if (fNextPos) {
			loop: for (Text innerText: visitedText.getTexts()) {
				if (haveResult) {			
					break loop;
				}			
				if (visitedText.getBeginOf(innerText) >= atOffset) {
					innerText.process(this, 0);
				}
			}
		} else {
			List<Text> innerTexts = visitedText.getTexts();
			loop: for (int i = innerTexts.size() - 1; i >= 0; i--) {
				if (haveResult) {			
					break loop;
				}			
				if (visitedText.getBeginOf(innerTexts.get(i)) <= atOffset) {
					innerTexts.get(i).process(this, innerTexts.get(i).getLength());
				}
			}
		}
	}

	public void visitText(Text visitedText, int atOffset) {
		if (!haveResult) {
			if (visitedText instanceof ChangeText) {
				result = visitedText.getAbsolutOffset(atOffset);
				haveResult = true;
			} 
			if (visitedText.getElement(HoldFlag.class) != null) {
				result = visitedText.getAbsolutOffset(0);
				haveResult = true;
			}
		}
	}

	public int getResult() {
		return result;
	}	
	
	public boolean hasResult() {
		return haveResult;
	}
}
