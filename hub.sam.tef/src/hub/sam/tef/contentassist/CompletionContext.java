package hub.sam.tef.contentassist;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class CompletionContext {

	private final String fContent;	
	private String identifierPrefix = "";
	private final Resource fCurrentModel;
	
	public CompletionContext(String content, Resource currentModel) {
		super();
		fContent = content;
		fCurrentModel = currentModel;
	}

	public String getContent() {
		return fContent;
	}

	public String getIdentifierPrefix() {
		return identifierPrefix;
	}

	public void setIdentifierPrefix(String identifierPrefix) {
		this.identifierPrefix = identifierPrefix;
	}
	
	public int getCompletionOffset() {
		return fContent.length();
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
