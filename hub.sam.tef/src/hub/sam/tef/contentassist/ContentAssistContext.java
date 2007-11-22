package hub.sam.tef.contentassist;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ContentAssistContext {

	private final int fCompletionOffset;
	private final String identifierPrefix;
	private final Resource fCurrentModel;
	
	public ContentAssistContext(int completionOffset, String identifierPrefix,
			Resource currentModel) {
		super();
		this.fCompletionOffset = completionOffset;
		this.identifierPrefix = identifierPrefix;
		fCurrentModel = currentModel;
	}	

	public String getIdentifierPrefix() {
		return identifierPrefix;
	}

	public int getCompletionOffset() {
		return fCompletionOffset;
	}
	
	/**
	 * Returns all top-level model objects in this context.
	 */
	public EList<EObject> getContents() {
		return fCurrentModel.getContents();
	}

	/**
	 * Returns all the model contents in this context.
	 */
	public TreeIterator<EObject> getAllContents() {
		return fCurrentModel.getAllContents();
	}
	
}
