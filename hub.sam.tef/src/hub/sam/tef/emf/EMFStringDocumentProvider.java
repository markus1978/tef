package hub.sam.tef.emf;

import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.emf.model.EMFModel;
import hub.sam.tef.models.IModel;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;

public abstract class EMFStringDocumentProvider extends AbstractEMFDocumentProvider {
	
	private String contents = null;
			
	private IModel loadModel(Resource resource, EditingDomain domain) {
		return new EMFModel(getFactory(), getPackage(), resource, domain);
	}
	
	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		
		EditingDomain editingDomain = getEditingDomain();
		URI resourceId = null;
		try {
			resourceId = new URIConverterImpl().normalize(URI.createURI("file://" + File.createTempFile("teftempfile", ".xml").getAbsolutePath()));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		Resource resource = editingDomain.getResourceSet().createResource(resourceId);
		//resource = prepareResource(resource);
		if (editingDomain.isReadOnly(resource)) {
			throw new RuntimeException("try to edit a read only resource");
		}
		IModel model = loadModel(resource, editingDomain);											
		((TEFDocument)document).setInitialTextContext(model, resourceId, contents);
		return true;		
	}
	
	protected ElementInfo getElementInfo(Object element) {
		ElementInfo info = super.getElementInfo(element);
		if (info != null) {
			info.fModel = null;
		}
		return info;
	}
	
	@Override
	protected final void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {			
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}	
}