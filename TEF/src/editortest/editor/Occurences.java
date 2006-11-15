package editortest.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import editortest.controller.ComputeSelectionVisitor;
import editortest.model.AbstractModelElement;
import editortest.model.IModelElement;
import editortest.view.Text;

/**
 * This class is responsible for managing occurences marks. There is one
 * instance per editor.
 */
public class Occurences {
	
	private IModelElement currentMarkedModelElement = null;
	private final TEFSourceViewer fSourceViewer;	
	private Annotation[] currentOccurencesMarker = null;
	
	public Occurences(final TEFSourceViewer sourceViewer) {
		super();
		fSourceViewer = sourceViewer;
		sourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setActualCursorPosition();
			}			
		});		
	}

	public void setActualCursorPosition() {
		int cursorPosition = fSourceViewer.getTextWidget().getCaretOffset();		
		
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(cursorPosition);
		((TEFDocument)fSourceViewer.getDocument()).getDocument().process(visitor, cursorPosition);
		Text selectedText = visitor.getCursorPositionText();
		IAnnotationModel model = fSourceViewer.getAnnotationModel();
		
		IModelElement modelElement = null;
		while(selectedText != null && modelElement == null) {
			modelElement = selectedText.getAttribute(AbstractModelElement.class);
			selectedText = selectedText.getContainer();			
		}
		if (modelElement != null && modelElement.equals(currentMarkedModelElement)) {			
			return;
		} 
		
		removeOccurenceMarker(model);
		currentMarkedModelElement = modelElement;		
				
		if (modelElement != null) {
			Text[] occurences =  modelElement.getRegisteredOccureces();			
			IRegion[] occurencePositions = new IRegion[occurences.length];
			for (int i = 0; i < occurences.length; i++) {
				occurencePositions[i] = new Region(occurences[i].getAbsolutOffset(0), occurences[i].getLength());
			}

			currentOccurencesMarker = new Annotation[occurencePositions.length];
			int i = 0;
			for (IRegion occurenceMarker: occurencePositions) {
				currentOccurencesMarker[i] = new Annotation("testeditor.occurencesmarker", false, "A OCCURENCE");
				model.addAnnotation(currentOccurencesMarker[i], new Position(occurenceMarker.getOffset(), occurenceMarker.getLength()));
				i++;
			}
		}
	}	
	
	private void removeOccurenceMarker(IAnnotationModel model) {
		if (currentOccurencesMarker != null) {
			for (int i = 0; i < currentOccurencesMarker.length; i++) {
				model.removeAnnotation(currentOccurencesMarker[i]);
			}
		}
		currentOccurencesMarker = null;
	}
}
