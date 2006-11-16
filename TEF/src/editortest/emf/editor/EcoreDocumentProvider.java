package editortest.emf.editor;

import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.IDocument;

import editortest.editor.TEFDocument;
import editortest.editor.TEFDocumentProvider;
import editortest.emf.model.EMFModel;

public class EcoreDocumentProvider extends TEFDocumentProvider {

	private final EPackage fEcorePackage = EcorePackage.eINSTANCE;
	private final EFactory fEcoreFactory = EcoreFactory.eINSTANCE;
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new EcoreDocument();		
	}
	
	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream, 
			String encoding) throws CoreException {
		Resource resource = new ResourceImpl();
		((TEFDocument)document).setContent(new EMFModel(fEcoreFactory, fEcorePackage, resource));		
	}
}
