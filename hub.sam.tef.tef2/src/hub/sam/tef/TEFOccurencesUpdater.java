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

import hub.sam.tef.documents.TEFDocument;

import java.util.Map;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * This class is responsible for managing occurences marks. There is one
 * instance per editor.
 */
public class TEFOccurencesUpdater implements ISelectionChangedListener {
	
	private final AbstractTEFEditor fEditor;
	private Annotation[] oldOccurenceAnnotations = new Annotation[] {};
	
	public TEFOccurencesUpdater(AbstractTEFEditor editor) {
		((IPostSelectionProvider)editor.getSelectionProvider()).addPostSelectionChangedListener(this);
		this.fEditor = editor;
	}
	
	public final void selectionChanged(SelectionChangedEvent event) {
		ISourceViewer viewer = (ISourceViewer)event.getSource();
		IDocument  document = viewer.getDocument();
		IAnnotationModel annotationModel = viewer.getAnnotationModel();
	
		Map<Annotation, Position> newOccurenceAnnotations = 
				((TEFDocument)document).createNewOccurenceAnnotations(viewer);
		
		((IAnnotationModelExtension)annotationModel).replaceAnnotations(oldOccurenceAnnotations, 
				newOccurenceAnnotations);					
		oldOccurenceAnnotations = newOccurenceAnnotations.keySet().toArray(new Annotation[] {});
	}
}
