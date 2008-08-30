package hub.sam.tef.editor.popup;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.editor.model.ModelDocumentProvider;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class PopupDocumentProvider extends ModelDocumentProvider implements IDocumentProvider {
	
	private final PopupEditor fEditor;	

	public PopupDocumentProvider(PopupEditor editor) {
		super(editor);
		fEditor = editor;		
	}

	/**
	 * TODO this is very similar to the method in ModelDocumentProvider
	 */
	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		Assert.isTrue(element instanceof PopupEditorInput);
		PopupEditorInput editorInput = (PopupEditorInput)element;		
		
		// TODO take this from the host editor
		Resource resource = editorInput.getEditedObject().eResource();
		if (resource == null) {
			// TODO handle error ?
			Assert.isTrue(false);
		}
		fEditor.setModel(resource);		
		Document result = new Document();
		
		EObject root = editorInput.getEditedObject();
		fEditor.setEditedObject(root);
		PrettyPrinter printer = fEditor.createPrettyPrinter();
		printer.setLayout(fEditor.createLayout());
		String content = null;
		try {
			content = printer.print(root).toString();
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
		Assert.isTrue(false, "A popup editor cannot be saved.");
	}

	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}	
}