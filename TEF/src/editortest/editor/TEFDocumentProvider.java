package editortest.editor;

import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.StorageDocumentProvider;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;

import editortest.mof.model.MofModel;
import editortest.mof.template.TestMofDocument;

public class TEFDocumentProvider extends StorageDocumentProvider {
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new EclipseDocument();		
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		System.out.println("saved.");		
	}
	
	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream, 
			String encoding) throws CoreException {
		((EclipseDocument)document).setContent(new MofModel(contentStream));		
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		return new AnnotationModel();
	}
	
}
