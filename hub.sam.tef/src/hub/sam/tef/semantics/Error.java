package hub.sam.tef.semantics;

import org.eclipse.jface.text.Position;

/**
 * Errors are user mistakes in the document. This class is used to represent
 * them, collect them, and finally display them to the user.
 */
public class Error extends AbstractError {

	private final Position fPosition;	
	
	public Error(Position position, String message) {
		super(message);
		fPosition = position;
	}
	
	@Override
	public Position getPosition(Object context) {
		return fPosition;
	}
		
}
