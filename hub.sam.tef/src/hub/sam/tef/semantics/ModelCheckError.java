package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

public class ModelCheckError extends AbstractError {

	private final EObject fCause;
	private final int fSeverity;

	/**
	 * Creates a new model check error with status {@link IStatus#ERROR}.
	 * 
	 * @param message
	 * @param cause
	 */
	public ModelCheckError(String message, EObject cause) {
		this(message, cause, IStatus.ERROR);
	}

	/**
	 * @param message
	 * @param cause
	 * @param severity
	 *            one of the constants from {@link IStatus}
	 */
	public ModelCheckError(String message, EObject cause, int severity) {
		super(message);
		fCause = cause;
		fSeverity = severity;
	}

	@Override
	public Position getPosition(Object context) {
		return ((IModelCreatingContext) context).getTreeNodeForObject(fCause).getPosition();
	}

	@Override
	public int getSeverity() {
		return fSeverity;
	}
}
