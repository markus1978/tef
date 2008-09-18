package hub.sam.tef.editor;

import org.eclipse.jface.text.source.Annotation;

public class ErrorAnnotation extends Annotation {

	public static final String TEF_ERROR = "hub.sam.tef.error";
	
	public ErrorAnnotation(String message) {
		super(TEF_ERROR, false, message);
	}
}
