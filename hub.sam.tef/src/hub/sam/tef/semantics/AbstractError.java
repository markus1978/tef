package hub.sam.tef.semantics;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.Position;

public abstract class AbstractError {
	
	private final String fMessage;

	public AbstractError(String message) {
		super();
		fMessage = message;
	}
	
	public String getMessage() {
		return fMessage;
	}

	/**
	 * @return the position of the error in the text causing the error. It
	 *         describes the range in the text that causes the error.
	 */
	public abstract Position getPosition(Object context);
	
	/**
	 * @return the default severity {@link IStatus#ERROR}
	 */
	public int getSeverity() {
		return IStatus.ERROR;
	}
}
