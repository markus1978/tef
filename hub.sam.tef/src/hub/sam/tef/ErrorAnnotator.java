package hub.sam.tef;

import hub.sam.tef.controllers.IAnnotationModelProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

public class ErrorAnnotator implements ISelectionChangedListener, IAnnotationModelProvider {
	
	private Collection<TEFAnnotation> oldAnnotations = new Vector<TEFAnnotation>();
	private Collection<TEFAnnotation> newAnnotations = new Vector<TEFAnnotation>();
	
	private final IAnnotationModelExtension fAnnotationModel;
	

	public ErrorAnnotator(final IAnnotationModelExtension annotationModel) {
		super();
		fAnnotationModel = annotationModel;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		Annotation[] oldAnnotations = new Annotation[this.oldAnnotations.size()];
		int i = 0;
		for (TEFAnnotation old: this.oldAnnotations) {
			oldAnnotations[i++] = old.getAnnotation();
		}
		Map<Annotation, Position> newAnnotations = new HashMap<Annotation, Position>();
		for (TEFAnnotation newAnnotation: this.newAnnotations) {
			newAnnotations.put(newAnnotation.getAnnotation(), newAnnotation.getPosition());
		}				
		fAnnotationModel.replaceAnnotations(oldAnnotations, newAnnotations);
		this.oldAnnotations = new Vector<TEFAnnotation>();
		this.newAnnotations = new Vector<TEFAnnotation>();
	}			

	public void addAnnotation(TEFAnnotation annotation) {
		newAnnotations.add(annotation);
	}
	
	public void removeAnnotation(TEFAnnotation annotation) {
		oldAnnotations.add(annotation);
	}
	
	
}
