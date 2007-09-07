package hub.sam.tef.reconciliation.syntax;

import hub.sam.tef.annotations.ErrorAnnotation;

import org.eclipse.jface.text.source.Annotation;

@Deprecated
public class SyntaxError extends Annotation {
	
	public SyntaxError(String errorMsg) {
		super(ErrorAnnotation.TEF_ERROR, false, "Syntax error: " + errorMsg);
	}
	
}
