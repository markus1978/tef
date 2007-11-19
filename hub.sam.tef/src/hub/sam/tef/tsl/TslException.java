package hub.sam.tef.tsl;

/**
 * This exception is only used to report an fully unexpected behavior, a
 * so called error. This can be any error associated with the usage of a 
 * syntax definition.
 */
public class TslException extends Exception {
	private static final long serialVersionUID = 1L;

	public TslException() {
		super();
	}

	public TslException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TslException(String arg0) {
		super(arg0);
	}

	public TslException(Throwable arg0) {
		super(arg0);
	}

}
