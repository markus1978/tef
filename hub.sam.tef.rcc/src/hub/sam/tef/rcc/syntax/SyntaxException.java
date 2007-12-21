package hub.sam.tef.rcc.syntax;

public class SyntaxException extends Exception {
	private static final long serialVersionUID = 1L;

	public SyntaxException(String msg)	{
		super(msg);
	}

	public SyntaxException(String message, Throwable cause) {
		super(message, cause);	
	}	
}