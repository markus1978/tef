package editortest.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;

import editortest.text.ComputeSelectionVisitor;

public class TEFDoubleClickStrategy implements 
		ITextDoubleClickStrategy {
	
	public void doubleClicked(ITextViewer viewer) {
		int offset = viewer.getSelectedRange().x;
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		IRegion region = visitor.getResult();
		
		if (region != null && region.getLength() > 0) {
			viewer.setSelectedRange(region.getOffset(), region.getLength());
		}
	}
}
