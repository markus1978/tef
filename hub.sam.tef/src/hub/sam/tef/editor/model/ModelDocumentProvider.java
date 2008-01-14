package hub.sam.tef.editor.model;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import java.io.IOException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class ModelDocumentProvider extends FileDocumentProvider implements IDocumentProvider {
	
	private final ModelEditor fEditor;	

	public ModelDocumentProvider(ModelEditor editor) {
		super();
		fEditor = editor;
	}

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		Assert.isTrue(element instanceof IFileEditorInput);
		IFileEditorInput editorInput = (IFileEditorInput)element;
		
		Resource resource = loadXMI(editorInput);
		fEditor.setModel(resource);
		Document result = new Document();
		
		EObject root = resource.getContents().get(0);
		PrettyPrinter printer = new PrettyPrinter(
				fEditor.getSyntax(), fEditor.getSemanticsProvider());
		printer.setLayout(fEditor.createLayout());
		String content = null;
		try {
			content = printer.print(root).getContent();
		} catch (ModelCreatingException e) {
			throw new CoreException(new Status(
					Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Could not pretty print the model", e));
		}
		result.set(content);
		return result;
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {			
		Resource resourceToSave = fEditor.getCurrentModel();	
		resourceToSave.getContents().set(0, fEditor.getCurrentModel().getContents().get(0));
		try {
			resourceToSave.save(null);
		} catch (IOException e) {
			throw new CoreException(new Status(
					Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Couldn't save the model", e));
		}		
	}

	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}	

	protected Resource loadXMI(IFileEditorInput editorInput) throws CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();		
		
		for (EPackage metaModelPackage: fEditor.getMetaModelPackages()) {			
			resourceSet.getPackageRegistry().put(metaModelPackage.getNsURI(), metaModelPackage);
		}
		Resource resource = null;
		try {
			URI exampleModelFile = URI.createFileURI(editorInput.getFile().getFullPath().toString());
			resource = resourceSet.getResource(exampleModelFile, true);
		} catch (Throwable e) {
			throw new CoreException(new Status(
					Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Could not pretty print the model", e));
		}
		return resource;
	}
}
