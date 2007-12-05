package hub.sam.tef.popupactions;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class Format implements IEditorActionDelegate {

	private TextEditor fEditor = null;
	
	public Format() {
		super();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		Assert.isTrue(fEditor != null);
		
		// TODO confirmation dialog if errors in the editor
		
		Resource resource = fEditor.getCurrentModel();
		PrettyPrinter printer = new PrettyPrinter(fEditor.getSyntax(), fEditor.getSemanticsProvider());
		// TODO select the proper layout manager
		printer.setLayout(new BlockLayout());
		
		EList<EObject> contents = resource.getContents();
		if (contents.size() != 1) {
			// TODO confirmation dialog;
		}
		EObject root = contents.get(0);
		try {
			PrettyPrintState result = printer.print(root);
			String newContent = result.getContent();
			fEditor.updateCurrentText(newContent);
		} catch (ModelCreatingException e) {
			// TODO Error dialog
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof TextEditor) {
			fEditor = ((TextEditor)targetEditor);
		} else {
			fEditor = null;
		}
	}	
}
