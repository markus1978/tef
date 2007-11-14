package hub.sam.tef.modelcreating;

/**
 * Is used in the case of an exception caused during model creating.
 */
public class ModelCreatingException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModelCreatingException() {
		super();
	}

	public ModelCreatingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelCreatingException(String message) {
		super(message);
	}

	public ModelCreatingException(Throwable cause) {
		super(cause);
	}

}
