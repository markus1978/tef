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
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
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
		// TODO don't allow this when no editor is registered
		Assert.isTrue(false, "no popup editor registred");
		return null;
	}
	
	protected void createTextEditor(Composite hostComposite) {	
		PopupEditor tefEditor = createEditor();
		try {											
			tefEditor.init((IEditorSite)hostPart.getSite(), 
					((EcoreEditor)hostPart).getEditorInput());												
			tefEditor.createPartControl(hostComposite);			
		} catch (Exception e) {
			// TODO
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void run(IAction action) {
		TreeItem treeItem = ((TreeViewer) ((IViewerProvider) hostPart)
				.getViewer()).getTree().getSelection()[0];
		Rectangle selectionBounds = treeItem.getBounds();
		
		Composite composite = treeItem.getParent();
		while (composite.getParent() != null) {
			selectionBounds.x += composite.getBounds().x;
			selectionBounds.y += composite.getBounds().y;
			composite = composite.getParent();
		} 		
		
		final Shell fShell = hostPart.getSite().getShell();
		final Decorations fEditorComposite = new Decorations(fShell, SWT.RESIZE);		
			
		
		fEditorComposite.setLayout(new FillLayout());
		fEditorComposite.setLocation(new Point(selectionBounds.x, selectionBounds.y));		
				
		createTextEditor(fEditorComposite);
		
		fEditorComposite.pack();
		fEditorComposite.setSize(500, 300);
				
		fEditorComposite.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (okToUse(fEditorComposite)) {
					fEditorComposite.setVisible(false);
					fEditorComposite.dispose();
				} else {
					// TODO Error
					return;	
				}
				System.out.println("update the model(1)");
			}			
		});
		
		if (!okToUse(fEditorComposite)) {
			// TODO Error
			return;		
		}
		
		fEditorComposite.setVisible(true);		
		fEditorComposite.setFocus();
		
		new Closer(((TreeViewer) ((IViewerProvider) hostPart)
				.getViewer()).getTree(), fEditorComposite);
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
	
	/**
	 * A combined listener for all the events that cause the pop-up editor to close.
	 */
	class Closer implements ControlListener, MouseListener, DisposeListener, FocusListener {

		private Shell fShell;
		private final Control fControl;	
		private final Decorations fEditorComposite;	

		/**
		 * The created closer installs itself to the given element. It
		 * works after the fire&forget principle.
		 * 
		 * @param control the widget that hosts the pop-up editor.
		 * @param editorComposite the widget that is the editor.
		 */
		public Closer(Control control, Decorations editorComposite) {
			super();
			fControl = control;
			fEditorComposite = editorComposite;
			install();
		}

		private void install() {
			if (okToUse(fControl)) {

				Shell shell= fControl.getShell();
				fShell= shell;
				shell.addControlListener(this);
				fControl.addMouseListener(this);
				fControl.addDisposeListener(this);
				fControl.addFocusListener(this);
				fControl.addControlListener(this);
			}
		}

		private void uninstall() {
			if (okToUse(fShell))
				fShell.removeControlListener(this);

			if (okToUse(fControl)) {
				fControl.removeMouseListener(this);
				fControl.removeDisposeListener(this);
				fControl.removeFocusListener(this);
				fControl.removeControlListener(this);
			}	
		}

		public void controlResized(ControlEvent e) {
			hide();
		}

		public void controlMoved(ControlEvent e) {
			hide();
		}

		public void mouseDown(MouseEvent e) {
			hide();
		}

		public void mouseUp(MouseEvent e) {
		}

		public void mouseDoubleClick(MouseEvent e) {
			hide();
		}

		public void focusGained(FocusEvent e) {
		}		

		public void focusLost(FocusEvent e) {
			hide();
		}

		public void widgetDisposed(DisposeEvent e) {
			hide();
		}	
		
		private void hide() {
			uninstall();
			fEditorComposite.setVisible(false);
			fEditorComposite.dispose();
		}
	}
}
