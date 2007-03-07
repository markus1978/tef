package hub.sam.tef;

import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.source.Annotation;

public class ErrorAnnotation extends TEFAnnotation {

	public ErrorAnnotation(final Text text) {
		super(new Annotation("hub.sam.tef.error", false, "An error..."), text);
	}

	public void addToAnnotationModel(IAnnotationModelProvider model) {
		model.addAnnotation(this);		
	}
	
	public void removeFromAnnotationModel(IAnnotationModelProvider model) {
		model.removeAnnotation(this);
	}
	
}
