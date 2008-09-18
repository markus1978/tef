package hub.sam.tef.editor;

import org.eclipse.jface.text.source.Annotation;

public class WarningAnnotation extends Annotation {

	public static final String TEF_WARNING = "hub.sam.tef.warning";

	public WarningAnnotation(String message) {
		super(TEF_WARNING, false, message);
	}
}
