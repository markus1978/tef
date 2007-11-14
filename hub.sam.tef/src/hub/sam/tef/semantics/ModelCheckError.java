package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

public class ModelCheckError extends AbstractError {

	private final EObject fCause;

	public ModelCheckError(String message, EObject cause) {
		super(message);
		fCause = cause;
	}

	@Override
	public Position getPosition(Object context) {
		return ((ModelCreatingContext)context).getTreeNodeForObject(fCause).getPosition();
	}	
}
