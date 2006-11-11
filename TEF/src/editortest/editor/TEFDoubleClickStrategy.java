package editortest.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

import editortest.text.Text;
import editortest.text.controller.ComputeSelectionVisitor;

public class TEFDoubleClickStrategy implements 
		ITextDoubleClickStrategy {
	
	public void doubleClicked(ITextViewer viewer) {
		int offset = viewer.getSelectedRange().x;
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		Text selectedText = visitor.getResult(); 
		IRegion region = new Region(selectedText.getAbsolutOffset(0), selectedText.getLength());
		
		if (region != null && region.getLength() > 0) {
			viewer.setSelectedRange(region.getOffset(), region.getLength());
		}
	}
}
