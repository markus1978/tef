/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef;

import hub.sam.tef.controllers.ComputeSelectionVisitor;
import hub.sam.tef.models.AbstractModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;


/**
 * This class is responsible for managing occurences marks. There is one
 * instance per editor.
 */
public class OccurencesAnnotator implements ISelectionChangedListener {
	
	private IModelElement currentMarkedModelElement = null;
	private Annotation[] currentOccurencesMarker = null;
	
	public void selectionChanged(SelectionChangedEvent event) {
		update((ISourceViewer)event.getSource());	
	}

	public void update(ISourceViewer fSourceViewer) {		
		int cursorPosition = fSourceViewer.getTextWidget().getCaretOffset();		
		
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(cursorPosition);
		((TEFDocument)fSourceViewer.getDocument()).getModelDocument().getDocumentText().process(visitor, cursorPosition);
		Text selectedText = visitor.getCursorPositionText();
		IAnnotationModel model = fSourceViewer.getAnnotationModel();
		
		IModelElement modelElement = null;
		while(selectedText != null && modelElement == null) {
			modelElement = selectedText.getElement(AbstractModelElement.class);
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
