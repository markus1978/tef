package hub.sam.tef.annotations;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;

public interface IAnnotationModelProvider {
	
	public void addAnnotation(Annotation annotation, Position position);
	
	public void clearAnnotations();
	
}
