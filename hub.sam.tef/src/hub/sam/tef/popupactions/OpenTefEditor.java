package hub.sam.tef.popupactions;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.editor.PopupEditor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class OpenTefEditor implements IObjectActionDelegate {

	private IWorkbenchPart hostPart = null;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		hostPart = targetPart;
		
	}
	
	private PopupEditor createEditor() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		
		IConfigurationElement[] elements = 
				reg.getConfigurationElementsFor(TEFPlugin.PLUGIN_ID, 
				"popupeditor");
		for (IConfigurationElement element: elements) {
			PopupEditor popupEditor = null;
			// TODO a reasonable selection of the right extension
			if ("hub.sam.tef.ecore.popupeditor1".equals(element.getAttribute("name"))) {
				try {
					popupEditor = 
							(PopupEditor)element.createExecutableExtension("class");							
				} catch (Exception e) {
					TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
							Status.ERROR, "could not instantiate a popup editor", e));
				}
				return popupEditor;
			}
		}
		// TODO dont allow this when no editor is registred
		Assert.isTrue(false, "no popup editor registred");
		return null;
	}
	
	protected Control createTextEditor(Shell shell) {	
		PopupEditor tefEditor = createEditor();
		try {											
			tefEditor.init((IEditorSite)hostPart.getSite(), 
					((EcoreEditor)hostPart).getEditorInput());												
			tefEditor.createPartControl(shell);			
		} catch (Exception e) {
			// TODO
			throw new RuntimeException(e);
		}				
		return tefEditor.getWidget();
	}

	@Override
	public void run(IAction action) {
		TreeItem treeItem = ((TreeViewer) ((IViewerProvider) hostPart)
				.getViewer()).getTree().getSelection()[0];
		Rectangle selectionBounds = treeItem.getBounds();
		
		Composite composite = treeItem.getParent();
		while (composite != null) {
			selectionBounds.x += composite.getBounds().x;
			selectionBounds.y += composite.getBounds().y;
			composite = composite.getParent();
		} 		
		
		final Shell fShell= new Shell(hostPart.getSite().getShell(), SWT.RESIZE );		
		fShell.setLayout(new FillLayout());
		fShell.setLocation(new Point(selectionBounds.x, selectionBounds.y));		
				
		Control textEditor =  createTextEditor(fShell);
		
		fShell.pack();
		fShell.setSize(500, 300);
				
		fShell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (okToUse(fShell)) {
					fShell.setVisible(false);
					fShell.dispose();
				} else {
					// TODO Error
					return;	
				}
				System.out.println("update the model");
			}			
		});
		
		if (!okToUse(fShell) || !okToUse(textEditor)) {
			// TODO Error
			return;		
		}
		
		fShell.setVisible(true);		
		fShell.setFocus();		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("");
	}
	
	/**
	 * Returns whether the widget is <code>null</code> or disposed.
	 *
	 * @param widget the widget to check
	 * @return <code>true</code> if the widget is neither <code>null</code> nor disposed
	 */
	public static boolean okToUse(Widget widget) {
		return (widget != null && !widget.isDisposed());
	}
}
