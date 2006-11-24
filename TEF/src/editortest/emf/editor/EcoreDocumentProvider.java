package editortest.emf.editor;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.models.IModel;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;

import editortest.emf.model.EMFModel;

public class EcoreDocumentProvider extends TEFDocumentProvider {

	private final EPackage fEcorePackage = EcorePackage.eINSTANCE;
	private final EFactory fEcoreFactory = EcoreFactory.eINSTANCE;
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new EcoreDocument();		
	}
		
	protected void setDocumentContent(IDocument document, IModel model) throws CoreException {		
		((TEFDocument)document).setContent(model);		
	}
	
	private IModel loadModel(Resource resource) {
		return new EMFModel(fEcoreFactory, fEcorePackage, resource);
	}
	
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		if (editorInput instanceof IStorageEditorInput) {
			IStorage storage= ((IStorageEditorInput) editorInput).getStorage();						
			EditingDomain editingDomain = EcoreEditor.getSharedEditingDomain();
			Resource resource = editingDomain.getResourceSet().getResource(URI.createURI(storage.getFullPath().toString()), true);
			IModel model = loadModel(resource);								
			setDocumentContent(document, model);

			return true;
		}
		return false;
	}
	
	@Override
	protected final void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {		
		if (element instanceof IEditorInput) {
			IEditorInput editorInput = (IEditorInput)element;
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage= ((IStorageEditorInput) editorInput).getStorage();						
				EditingDomain editingDomain = EcoreEditor.getSharedEditingDomain();
				Resource resource = editingDomain.getResourceSet().getResource(URI.createURI(storage.getFullPath().toString()), true);
				try {
					resource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO
					throw new RuntimeException(e);
				}
			}
		}		
	}
}
