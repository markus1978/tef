package hub.sam.tef.ocl;

import hub.sam.tef.emf.EMFDocumentProvider;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;


public class OclDocumentProvider extends EMFDocumentProvider {

	private final OclDocumentProviderDelegator fDelegator = new OclDocumentProviderDelegator();
	
	@Override
	public EditingDomain getEditingDomain() {
		return fDelegator.getEditingDomain();
	}

	@Override
	protected Iterable<EFactory> getFactory() {
		return fDelegator.getFactory();
	}

	@Override
	protected Iterable<EPackage> getPackage() {
		return fDelegator.getPackage();
	}

	@Override
	protected IDocument createEmptyDocument() {
		return fDelegator.createEmptyDocument();
	}
}
