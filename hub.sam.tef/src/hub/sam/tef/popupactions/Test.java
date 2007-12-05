package hub.sam.tef.popupactions;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.tsl.TslFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class Test implements IEditorActionDelegate {

	private TextEditor fEditor = null;
	
	public Test() {
		super();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		Assert.isTrue(fEditor != null);
		PrettyPrinter printer = new PrettyPrinter(fEditor.getSyntax(), fEditor.getSemanticsProvider());
		printer.setLayout(new BlockLayout());

		EObject root = TslFactory.eINSTANCE.createSimpleRule();
		try {
			PrettyPrintState result = printer.print(root);
			String newContent = result.getContent();
			System.out.println(newContent);
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
			fEditor = (TextEditor)targetEditor;
		} else {
			fEditor = null;
		}
	}	
}
