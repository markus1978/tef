package editortest.emf.ocl.annotations;

import org.eclipse.emf.ecore.EObject;

public class AbstractOclIdentifierResolver {
	
	protected EObject selfVar = null;
	
	public void setSelfVar(EObject context) {
		this.selfVar = context;
	}
}
