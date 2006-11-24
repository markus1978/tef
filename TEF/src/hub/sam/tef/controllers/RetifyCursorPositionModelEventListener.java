package hub.sam.tef.controllers;

import hub.sam.tef.TEFSourceViewer;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.ModelEventListener;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.source.SourceViewer;


/**
 * Normally a ModelEventListener is only used to react to model changes and
 * update a representing view accordingly. This listener however
 * should be used for that plus that it allows the view to change the actual
 * cursor postion.
 */
public abstract class RetifyCursorPositionModelEventListener extends TransientTextModelEventListener {

	private final Text fShownText;
	
	public RetifyCursorPositionModelEventListener(IModelElement model, Text aShownText) {
		super(model, aShownText);
		fShownText = aShownText;		
	}

	/**
	 * Set a cursor postion that is used the next time that the document changes
	 * are propagated to the hosting platform editor.
	 * 
	 * @param text
	 *            The text where the cursor should be placed.
	 * @param offset
	 *            A offset relative to the beginning of the text.
	 */
	protected final void setNewCursorPosition(Text text, int offset) {
		TEFSourceViewer viewer = getViewer();
		if (viewer != null) {
			int newCursorPosition = text.getAbsolutOffset(offset);
			ComputeCursorPositionVisitor visitor = new ComputeCursorPositionVisitor(newCursorPosition, true, false);
			text.process(visitor, offset);
			if (visitor.hasResult()) {
				viewer.setNewCursorPosition(visitor.getResult());
			} else {
				viewer.setNewCursorPosition(newCursorPosition);				
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
