package editortest.mof.editor;

import hub.sam.mof.Repository;
import hub.sam.tef.TEFDocument;
import hub.sam.tef.TEFDocumentProvider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.EditorsUI;

import editortest.mof.model.MofModel;

public class MofDocumentProvider extends TEFDocumentProvider {
	@Override
	protected IDocument createEmptyDocument()  {
		return TEFDocument.createDocumentForModelDocument(new MofDocument());		
	}
	
	@Override
	protected final void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {
		MofModel model = (MofModel)((TEFDocument)document).getModelDocument().getModel();
		if (element instanceof IFileEditorInput) {		
			IFile file = ((IFileEditorInput)element).getFile();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				Repository.getLocalRepository().writeExtentToXmi(out, model.getMetaModel(), model.getExtent());
			} catch (Exception e) {
				String message= "Error creating XMI";
				IStatus s= new Status(IStatus.ERROR, EditorsUI.PLUGIN_ID, IStatus.OK, message, e);
				throw new CoreException(s);
			}			
			try {				
				file.setContents(new ByteArrayInputStream(out.toByteArray()), false, false, monitor);
			} catch (Exception e) {
				String message= "Error wrting XMI";
				IStatus s= new Status(IStatus.ERROR, EditorsUI.PLUGIN_ID, IStatus.OK, message, e);
				throw new CoreException(s);
			}
		} else {
			super.doSaveDocument(monitor, element, document, overwrite);
		}
		
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream, 
			String encoding) throws CoreException {
		((TEFDocument)document).getModelDocument().setContent(new MofModel(contentStream), null);		
	}
}
