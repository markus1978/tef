package hub.sam.tef.expressions;

import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.documents.TEFDocumentProvider;
import hub.sam.tef.emf.model.EMFModelElement;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class ExpressionsEvaluate implements IObjectActionDelegate {

	private IResource resource = null;
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// emtpy
	}
	
	class Editor extends ExpressionsEditor {
		@Override
		public TEFDocumentProvider createDocumentProvider() {
			return super.createDocumentProvider();
		}							
	}	
	
	private IDocumentProvider documentProvider = new Editor().createDocumentProvider();
	
	public EObject useModelFromResource(IResource resource) {				
		IFileEditorInput element = new FileEditorInput((IFile)resource);
		try {
			documentProvider.connect(element);
		} catch (CoreException e) {				
			e.printStackTrace();
		}
		TEFDocument document = (TEFDocument)documentProvider.getDocument(element);
		return ((EMFModelElement)document.getModelProvider().getTopLevelElement()).
					getEMFObject();								
	}
	
	public void stopUsingModelFromResource(IResource resource) {
		IFileEditorInput element = new FileEditorInput((IFile)resource);
		documentProvider.disconnect(element);		
	}

	@Override
	public void run(IAction action) {
		if (resource != null) {
			EObject topLevelElement = useModelFromResource(resource);						
			System.out.println("Evaluate resource ... " + topLevelElement);
			stopUsingModelFromResource(resource);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		resource = (IResource)((IStructuredSelection)selection).getFirstElement();
	}

}
