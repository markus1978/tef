package hub.sam.tef;

import hub.sam.tef.views.Text;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;

public class TEFAnnotation {

	private final Annotation annotation;
	private final Text fText;
	
	public TEFAnnotation(final Annotation annotation, final Text position) {
		super();
		this.annotation = annotation;
		this.fText = position;
	}
	
	public Annotation getAnnotation() {
		return annotation;
	}
	
	public Position getPosition() {
		return new Position(fText.getAbsolutOffset(0), fText.getLength());
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof ErrorMarker) {
			return fText.equals(((TEFAnnotation)arg0).fText) && annotation.getType().equals(((TEFAnnotation)arg0).annotation.getType());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fText.hashCode();
	}
}
