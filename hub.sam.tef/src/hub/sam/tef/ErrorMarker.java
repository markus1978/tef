package hub.sam.tef;

import hub.sam.tef.views.Text;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;

public class ErrorMarker {
	
	private final Annotation annotation = new  Annotation("hub.sam.tef.error", false, "An error");
	private IAnnotationModel annotationModel = null;
	private final Text fText;

	public ErrorMarker(final Text text) {
		super();
		fText = text;
	}

	public void addToAnnotationModel(IAnnotationModel model) {
		model.addAnnotation(annotation, new Position(fText.getAbsolutOffset(0), fText.getLength()));
	}
	
	public void removeFromAnnotationModel() {
		if (annotationModel != null) {
			annotationModel.removeAnnotation(annotation);
		}
	}
}
