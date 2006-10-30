package editortest.mof;

import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;

import editortest.editor.TEFDocument;
import editortest.editor.TEFDocumentProvider;
import editortest.mof.model.MofModel;

public class MofDocumentProvider extends TEFDocumentProvider {
	@Override
	protected IDocument createEmptyDocument()  {
		return new MofDocument();		
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		System.out.println("saved.");		
	}
	
	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream, 
			String encoding) throws CoreException {
		((TEFDocument)document).setContent(new MofModel(contentStream));		
	}
}
