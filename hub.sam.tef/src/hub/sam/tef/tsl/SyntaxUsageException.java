package hub.sam.tef.tsl;

/**
 * This exception is only used to report an fully unexpected behaviour, a
 * so called error. This can be any error associated with the usage of a 
 * syntax definition.
 */
public class SyntaxUsageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SyntaxUsageException() {
		super();
	}

	public SyntaxUsageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SyntaxUsageException(String arg0) {
		super(arg0);
	}

	public SyntaxUsageException(Throwable arg0) {
		super(arg0);
	}

}
