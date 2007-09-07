package hub.sam.tef.reconciliation.syntax;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTChangedListener;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class TestParseAction implements IEditorActionDelegate {

	private IEditorPart editor = null;
	
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = targetEditor;
	}

	public void run(IAction action) {
		// emtpy
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(true); // always on
	}
	
	class RepresentationChangedListener implements IASTChangedListener {
		private String content;
		private final ASTElementNode representation;
		
		public RepresentationChangedListener(String content, final ASTElementNode representation) {
			super();
			this.content = content;
			this.representation = representation;
		}

		public void contentChanged(int start, int length, String text) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.INFO,
					TEFPlugin.PLUGIN_ID, Status.OK, "replace:" + content.substring(start, start+length) + ":" + text, null));	
			content = representation.getContent();
		}
	}

}
