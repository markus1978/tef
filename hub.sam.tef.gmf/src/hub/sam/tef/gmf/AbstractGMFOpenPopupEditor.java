package hub.sam.tef.gmf;

import hub.sam.tef.editor.popup.AbstractOpenPopupEditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class AbstractGMFOpenPopupEditor extends AbstractOpenPopupEditor {
	
	private GraphicalEditPart selectedElement = null;

	@Override
	protected Point getPosition() {
		org.eclipse.draw2d.geometry.Point topLeft = selectedElement.getFigure().getBounds().getTopLeft();
		Point selectionPoint = new Point(topLeft.x+80, topLeft.y+10);		
		
		Composite composite = selectedElement.getViewer().getControl().getParent();
		while (composite.getParent() != null) {
			selectionPoint.x += composite.getBounds().x;
			selectionPoint.y += composite.getBounds().y;
			composite = composite.getParent();
		}
		return selectionPoint;
	}

	@Override
	protected EObject getSelectedObject() {
		return ((View)selectedElement.getModel()).getElement();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selectedElement = (GraphicalEditPart)
				((IStructuredSelection)selection).getFirstElement();
	}

	@Override
	protected IEditingDomainProvider getEditingDomainProvider() {
		return new IEditingDomainProvider() {
			public EditingDomain getEditingDomain() {
				return selectedElement.getEditingDomain();
			}			
		};
	}

	@Override
	protected Control getControl() {
		return ((DiagramEditor)hostPart).getDiagramGraphicalViewer().getControl();
	}	
	
	
}