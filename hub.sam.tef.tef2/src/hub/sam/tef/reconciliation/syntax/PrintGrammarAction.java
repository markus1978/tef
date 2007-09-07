package hub.sam.tef.reconciliation.syntax;

import hub.sam.tef.AbstractTEFEditor;
import hub.sam.tef.documents.TEFDocument;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class PrintGrammarAction implements IEditorActionDelegate {

	private IEditorPart editor = null;
	
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = targetEditor;
	}

	public void run(IAction action) {
		new ParserInterface(((TEFDocument)((AbstractTEFEditor)editor).getDocument()).getTopLevelTemplate()).printGrammar();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(editor instanceof AbstractTEFEditor);
	}

}
