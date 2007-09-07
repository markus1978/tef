package hub.sam.tef.annotations;

import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.documents.ILanguageModelProvider;
import hub.sam.tef.models.IModelElement;

import org.eclipse.jface.text.Position;

public class SemanticsContext {

	private final IDocumentModelProvider fDocumentModelProvider;
	private final ILanguageModelProvider fLanguageModelProvider;
	private final IModelElement fNewModel;
	
	private final IIdentifierResolver fResolver;
	private final IChecker fChecker;
	
	private boolean reconciliationIsTriggered = false;

	public SemanticsContext(final IDocumentModelProvider documentProvider, final ILanguageModelProvider languageModelProvider,
			IModelElement newModel) {
		super();
		fDocumentModelProvider = documentProvider;
		fLanguageModelProvider = languageModelProvider;
		fNewModel = newModel;
		fResolver = fLanguageModelProvider.getIdentityResolver();
		fChecker = fLanguageModelProvider.getChecker();
	}

	public IAnnotationModelProvider getAnnotationModelProvider() {
		return fDocumentModelProvider.getAnnotationModelProvider();
	}	
	
	public void addModelElementOccurence(IModelElement element, Position occurence) {
		fDocumentModelProvider.addModelElementOccurence(element, occurence);		
	}
		
	public IIdentifierResolver getIdentifierResolver() {
		return fResolver;
	}
	
	public IChecker getChecker() {
		return fChecker;
	}
	
	public IModelElement getNewModel() {
		return fNewModel;
	}
	
	/**
	 * Allows checker or identifier resolver to trigger an additional reconciliation.
	 * This feature is helpful, if some circumstances for a earlier element have changed.
	 */
	public void triggerReconciliation() {
		reconciliationIsTriggered = true;
	}
	
	public boolean reconciliationIsTriggered() {
		return reconciliationIsTriggered;
	}
	
	public void clear() {
		getAnnotationModelProvider().clearAnnotations();
	}
}
