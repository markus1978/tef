package hub.sam.tef.editor.popup;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TreeItem;

/**
 * A concrete implementation for the object-contribution action that opens a 
 * TEF editor within EMF tree editors.
 */
public class EMFOpenPopupEditor extends AbstractOpenPopupEditor {

	private EObject selectedObject = null;	
	
	/**
	 * The editor window position is calculated based on the objects view
	 * position within the model tree.
	 */
	@Override
	protected Point getPosition() {
		TreeItem treeItem = ((TreeViewer) ((IViewerProvider) hostPart)
				.getViewer()).getTree().getSelection()[0];
		Rectangle selectionBounds = treeItem.getBounds();
		
		Composite composite = treeItem.getParent();
		while (composite.getParent() != null) {
			selectionBounds.x += composite.getBounds().x;
			selectionBounds.y += composite.getBounds().y;
			composite = composite.getParent();
		}
		return new Point(selectionBounds.x, selectionBounds.y);
	}

	@Override
	protected EObject getSelectedObject() {
		return selectedObject;
	}
		
	public void selectionChanged(IAction action, ISelection selection) {
		selectedObject = (EObject)((StructuredSelection)selection).getFirstElement();
	}

	@Override
	protected IEditingDomainProvider getEditingDomainProvider() {
		return (IEditingDomainProvider)hostPart;
	}

	@Override
	protected Control getControl() {
		return ((TreeViewer) 
			((IViewerProvider) hostPart).getViewer()).getTree();
	}
}
