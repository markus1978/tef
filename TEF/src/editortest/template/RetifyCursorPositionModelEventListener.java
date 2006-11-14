package editortest.template;

import org.eclipse.jface.text.source.SourceViewer;

import editortest.controller.ComputeCursorPositionVisitor;
import editortest.editor.TEFSourceViewer;
import editortest.model.ModelEventListener;
import editortest.view.DocumentText;
import editortest.view.Text;

public abstract class RetifyCursorPositionModelEventListener extends ModelEventListener {

	private final Text fShownText;
	
	public RetifyCursorPositionModelEventListener(Text aShownText) {
		super();
		fShownText = aShownText;		
	}

	protected void setNewCursorPosition(Text text, int offset) {
		SourceViewer viewer = getViewer();
		if (viewer != null) {
			int newCursorPosition = text.getAbsolutOffset(offset);
			ComputeCursorPositionVisitor visitor = new ComputeCursorPositionVisitor(newCursorPosition, true, false);
			text.process(visitor, newCursorPosition - text.getAbsolutOffset(0));
			if (visitor.hasResult()) {
				viewer.getTextWidget().setSelection(visitor.getResult());
			} else {
				viewer.getTextWidget().setSelection(newCursorPosition);
			}
		}
	}
	
	private TEFSourceViewer getViewer() {
		Text aShownText = fShownText;
		while(aShownText.getContainer() != null) {
			aShownText = aShownText.getContainer();
		}
		if (aShownText instanceof DocumentText) {
			return ((DocumentText)aShownText).getViewer();
		} else {
			return null;
		}
	}
}
