package hub.sam.tef.parse;

import hub.sam.tef.TEFEditor;
import hub.sam.tef.TEFModelDocument;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.Template;
import hub.sam.tef.treerepresentation.ITreeRepresentationFromModelProvider;
import hub.sam.tef.treerepresentation.TreeRepresentation;

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
		TEFModelDocument document = ((TEFEditor)editor).getDocument().getModelDocument();
		Template topLevelTemplate = document.getTopLevelTemplate();
		IModelElement model = document.getDocumentText().getTexts().get(0).getElement(IModelElement.class);
		TreeRepresentation representation = topLevelTemplate.getAdapter(ITreeRepresentationFromModelProvider.class).
				createTreeRepresentation(null, null, model);
		representation.print(System.out);
		System.out.println(representation.getElement().getContent());
		//new ParserInterface(document.getTopLevelTemplate()).test(document.getDocumentText());
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(true); // always on
	}

}
