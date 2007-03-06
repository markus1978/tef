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
 * This class is responsible for marking the selected element. There is one
 * instance per editor.
 */
public class SelectedElementMarker implements ISelectionChangedListener {
	private final Annotation fObjectMarker = new Annotation("testeditor.currentobjectmarker", false, "A MARK");
	private final TEFEditor fEditor;
	
	private Text currentSelectedText = null;
	private Position currentObjectMarkerPosition = null;
	
	
	public SelectedElementMarker(final TEFEditor editor) {
		super();
		fEditor = editor;		
		fEditor.getSelectionProvider().addSelectionChangedListener(this);
	}
	
	public void selectionChanged(SelectionChangedEvent event) {
		update((ISourceViewer)event.getSource());
	}


	public void update(ISourceViewer fSourceViewer) {
		int offset = fSourceViewer.getTextWidget().getCaretOffset();
		
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)fSourceViewer.getDocument()).getModelDocument().getDocumentText().process(visitor, offset);
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
