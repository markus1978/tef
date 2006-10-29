package editortest.text;

import java.util.Collections;
import java.util.Vector;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

import editortest.tefwidgets.IdentifierText;

public final class ComputeSelectionVisitor extends AbstractOffsetBasedVisitor {

	private IRegion result = null;
		
	public ComputeSelectionVisitor(final int forOffset) {
		super(forOffset);				
	}
	
	private void selectText(Text selectedText) {
		int absolutOffset = selectedText.getAbsolutOffset(0);
		result = new Region(absolutOffset, selectedText.getLength());
	}

	public void visitText(Text visitedText, int atOffset) {
		if (visitedText instanceof IdentifierText) {
			selectText(visitedText);
		}
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		if (result == null) {
			selectText(visitedText);
		}
	}	
	
	public IRegion getResult() {
		return result;
	}
}
