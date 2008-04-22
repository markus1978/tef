package hub.sam.tef.ocl;

import hub.sam.tef.editor.popup.AbstractOpenPopupEditor;
import hub.sam.tef.editor.popup.ClosePopupEditorAction;
import hub.sam.tef.editor.popup.IPopupEditor;
import hub.sam.tef.editor.popup.PopupEditorInput;
import hub.sam.tef.editor.popup.AbstractOpenPopupEditor.Closer;
import hub.sam.tef.tsl.TslException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * A normal TEF editor for OCL texts. In contrast to other editors, this one
 * needs someone, who sets a context. The context can be set to the
 * OclEditorDelegate of this editor.
 */
public class OclPopupEditor extends OclTextEditor implements IPopupEditor {

	private AbstractOpenPopupEditor.Closer fPopupCloser = null;
	private IEditingDomainProvider fEditingDomainProvider = null;
	
	public OclPopupEditor() {
		super();
		initialiseDocumentProvider();
	}

	@Override
	public void close(boolean store) {
		Assert.isNotNull(fPopupCloser);
		Assert.isNotNull(fEditingDomainProvider);
		
		if (store) {
			PopupEditorInput editorInput = (PopupEditorInput)getEditorInput();
			EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl)
					editorInput.getEditedObject();
			
			String value = getSourceViewer().getDocument().get();
			
			EditingDomain editingDomain = fEditingDomainProvider.getEditingDomain();
			Command command = SetCommand.create(editingDomain, entry,
					EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature(
								EcorePackage.ESTRING_TO_STRING_MAP_ENTRY__VALUE), value);
			editingDomain.getCommandStack().execute(command);
		}		
		fPopupCloser.close();
	}

	public void reduceSyntax(EClass metaClass) throws TslException {
		// do nothing
	}

	public void setCloser(Closer closer) {
		fPopupCloser = closer;		
	}

	public void setEditingDomainProvider(
			IEditingDomainProvider editingDomainProvider) {
		fEditingDomainProvider = editingDomainProvider;	
	}
	
	protected void initialiseDocumentProvider() {
		setDocumentProvider(new DocumentProvider());
	}
	
	private class DocumentProvider extends FileDocumentProvider implements IDocumentProvider {

		@Override
		protected IDocument createDocument(Object element) throws CoreException {
			Assert.isTrue(element instanceof PopupEditorInput);
			PopupEditorInput editorInput = (PopupEditorInput)element;
			
			EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl)
					editorInput.getEditedObject();
			
			IDocument result = new Document();
			result.set(entry.getValue());
			
			OclPopupEditor.this.setContext(entry.eContainer().eContainer());
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
	
	public static final String CLOSE_POPUP_EDITOR_ACTION_ID = "hub.sam.tef.closePopupEditor";

	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {		
		super.editorContextMenuAboutToShow(menu);
		addAction(menu, TEF_CONTEXT_MENU_GROUP, 
				ClosePopupEditorAction.ACTION_DEFINITION_ID);
		
	}

	@Override
	protected void createActions() {
		super.createActions();		
		setAction(ClosePopupEditorAction.ACTION_DEFINITION_ID, 
				new ClosePopupEditorAction(this));
	}

}