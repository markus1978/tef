package hub.sam.tef.expressions;

import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IActionDelegate;

public class ExpressionsEvaluate implements IActionDelegate {

	private IFile selectedResource = null;
	
	public void run(IAction action) {
		System.out.println("Evaluating: " + selectedResource.toString());
		
		ExpressionsDocumentProvider documentProvide = new ExpressionsDocumentProvider();
		ExpressionsDocument document = (ExpressionsDocument)documentProvide.createEmptyDocument();				
				
		try {
			documentProvide.setDocumentContent(document, selectedResource, null);
		} catch (CoreException e) {
			e.printStackTrace();
			return;
		}
					
		IModelElement topLevelElement = document.getModelProvider().getTopLevelElement();
		if (topLevelElement != null) {
			System.out.print(((EMFModelElement)topLevelElement).getEMFObject());
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedResource = (IFile)((ITreeSelection)selection).getFirstElement();		
	}	
}
