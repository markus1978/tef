package hub.sam.tef.ocl;

import hub.sam.tef.emf.EMFTextDocumentProvider;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;

public class OclTextDocumentProvider extends EMFTextDocumentProvider {

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

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		boolean result = super.setDocumentContent(document, editorInput, encoding);
		if (result) {
			// TODO: just temp for the OCL editor
			((OclDocument)document).setContext(
					org.eclipse.emf.examples.extlibrary.EXTLibraryPackage.eINSTANCE.getWriter());
		}
		return result;
	}
}
