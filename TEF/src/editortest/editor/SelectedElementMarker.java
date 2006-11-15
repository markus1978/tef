package editortest.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;

import editortest.controller.ComputeSelectionVisitor;
import editortest.view.Text;

/**
 * This class is responsible for marking the selected element. There is one
 * instance per editor.
 */
public class SelectedElementMarker {
	private final Annotation fObjectMarker = new Annotation("testeditor.currentobjectmarker", false, "A MARK");
	private final TEFSourceViewer fSourceViewer;
	
	private Text currentSelectedText = null;
	private Position currentObjectMarkerPosition = null;
	
	
	public SelectedElementMarker(final TEFSourceViewer sourceViewer) {
		super();
		fSourceViewer = sourceViewer;
	}

	public void setActualCursorPosition() {
		int offset = fSourceViewer.getTextWidget().getCaretOffset();
		
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)fSourceViewer.getDocument()).getDocument().process(visitor, offset);
		IAnnotationModel model = fSourceViewer.getAnnotationModel();
		Text selectedText = visitor.getResult();		
		if (selectedText  == currentSelectedText) {		
			return;
		}	else {
			currentSelectedText = selectedText;
		}
	
		IRegion region;
		if (selectedText == null) {
			region = null;
		} else {
			region = new Region(selectedText.getAbsolutOffset(0), selectedText.getLength());
		}
		if (region != null) {
			Position newObjectMarkerPosition = new Position(region.getOffset(), region.getLength());
			if (!newObjectMarkerPosition.equals(currentObjectMarkerPosition)) {
				model.removeAnnotation(fObjectMarker);
				model.addAnnotation(fObjectMarker, newObjectMarkerPosition);
				currentObjectMarkerPosition = newObjectMarkerPosition;
			}
		} else {
			model.removeAnnotation(fObjectMarker);
		}						
	}
}
