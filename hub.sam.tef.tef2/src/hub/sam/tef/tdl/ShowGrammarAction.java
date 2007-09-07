package hub.sam.tef.tdl;

import hub.sam.tef.AbstractTEFEditor;
import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ParserInterface;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.tdl.model.Syntax;
import hub.sam.tef.templates.Template;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class ShowGrammarAction implements IEditorActionDelegate {

	private IEditorPart editor = null;
	
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = targetEditor;
	}

	public void run(IAction action) {
		IModelElement syntaxAsElement = ((TDLDocument)((AbstractTEFEditor)editor).getDocument())
				.getModelProvider().getTopLevelElement();
		final TDLTextEditor editor = (TDLTextEditor)this.editor;
		TemplateFactory factory = new TemplateFactory(); 
		Template topLevelTemplate = factory.createTemplate(new IDocumentModelProvider() {
			public void addModelElementOccurence(IModelElement element, Position occurence) {
			}

			public IAnnotationModelProvider getAnnotationModelProvider() {
				return null;
			}

			public IModel getModel() {
				return editor.getDocument().getModelProvider().getModel();
			}

			public String getText() {
				return null;
			}

			public IModelElement getTopLevelElement() {
				return null;
			}

			public void resetModelElementOccurences() {
			}			
		}, ((Syntax)((EMFModelElement)syntaxAsElement).getEMFObject()).getTopLevelTemplate());		
		new ParserInterface(topLevelTemplate).printGrammar();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(editor == null || editor instanceof TDLTextEditor);
	}

}
