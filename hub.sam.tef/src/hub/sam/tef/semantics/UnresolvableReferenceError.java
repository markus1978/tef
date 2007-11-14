package hub.sam.tef.semantics;

import org.eclipse.jface.text.Position;

import hub.sam.tef.modelcreating.ParseTreeNode;

/**
 * This error indicated that a reference could not be resolved due to 
 * an user mistake.
 */
public class UnresolvableReferenceError extends AbstractError {
	
	private final ParseTreeNode fCause;

	public UnresolvableReferenceError(String message,
			ParseTreeNode cause) {
		super(message);
		fCause = cause;
	}

	@Override
	public Position getPosition(Object context) {
		return fCause.getPosition();
	}	
}
