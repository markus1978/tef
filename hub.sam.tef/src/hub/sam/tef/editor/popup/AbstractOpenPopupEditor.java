package hub.sam.tef.editor.popup;

import hub.sam.tef.TEFPlugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.EditorPart;

/**
 * This action implementation is an abstract implementation of an object
 * contribution action that opens a TEF editor window within a host editor.
 * Inheriting concrete implementations have to provide the EMF object to be
 * edited, the position of the editor window, access to the hosting GUI control
 * and edit part.
 */
public abstract class AbstractOpenPopupEditor implements IObjectActionDelegate {
	protected IWorkbenchPart hostPart = null;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		hostPart = targetPart;		
	}
	
	protected IPopupEditor createEditor(Shell shell) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		
		String metaModelUri = null;
		Resource metaModelResource = getSelectedObject().eClass().eResource();
		if (metaModelResource != null && metaModelResource.getURI() != null) {
			metaModelUri = metaModelResource.getURI().toString();
		}
		
		String metaModelPackage = null;
		if (metaModelUri == null) {
			metaModelPackage = getSelectedObject().eClass().getEPackage().getName();
		}
		
		IConfigurationElement[] elements = 
				reg.getConfigurationElementsFor(TEFPlugin.PLUGIN_ID, 
				"popupeditor");
		for (IConfigurationElement element: elements) {
			PopupEditor popupEditor = null;
			if ((metaModelUri != null && metaModelUri.equals(element.getAttribute("metaModelURI"))) ||
			    (metaModelUri == null && metaModelPackage.equals(element.getAttribute("metaModelPackage")))) {
				try {
					popupEditor = 
							(PopupEditor)element.createExecutableExtension("class");							
				} catch (Exception e) {
					TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
							Status.ERROR, "could not instantiate a popup editor", e));
					MessageDialog.openError(shell, "Cannot open pop-up editor!", 
							"Cannot open pop-up editor! Could not instantiate a pop-up editor" +
							"that is registered for the meta-model of this model.");
					return null;
				}								
				return popupEditor;
			}
		}
		MessageDialog.openError(shell, "Cannot open pop-up editor!", 
				"Cannot open pop-up editor! There is no registered pop-up editor" +
				"for the meta-model of this model.");
		
		return null;
	}	
	
	protected abstract EObject getSelectedObject();
	protected abstract Point getPosition();
	protected abstract IEditingDomainProvider getEditingDomainProvider();
	protected abstract Control getControl();
	
	public void run(IAction action) {
		final Shell fShell = hostPart.getSite().getShell();
		final Decorations fEditorComposite = new Decorations(fShell, SWT.RESIZE);
		fEditorComposite.setLayout(new FillLayout());
		fEditorComposite.setLocation(getPosition());		
				
		IPopupEditor tefEditor = createEditor(fShell);
		if (tefEditor == null) {
			return;
		}
		
 		try {													
			tefEditor.reduceSyntax(getSelectedObject().eClass());
			tefEditor.init((IEditorSite)hostPart.getSite(), 
					new PopupEditorInput(
							((IFileEditorInput)((EditorPart)hostPart).getEditorInput()).getFile(),
							getSelectedObject()));
 			tefEditor.setEditingDomainProvider(getEditingDomainProvider()); 					 		
			tefEditor.createPartControl(fEditorComposite);			
		
			fEditorComposite.pack();
			fEditorComposite.setSize(500, 150);
					
			fEditorComposite.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					if (okToUse(fEditorComposite)) {
						fEditorComposite.setVisible(false);
						fEditorComposite.dispose();
					} else {
						TEFPlugin.getDefault().getLog().log(
								new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
								"could not close a popup editor"));	
						try {
							fEditorComposite.setVisible(false);
							fEditorComposite.dispose();
						} catch (Exception ex) {
							// ingnore
						}
					}
				}			
			});
			
			if (!okToUse(fEditorComposite)) {
				TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
						"could not instantiate a popup editor"));
				MessageDialog.openError(fShell, "Cannot open pop-up editor!", 
						"Cannot open pop-up editor! Editor widget is not usable.");
				try {
					fEditorComposite.setVisible(false);
					fEditorComposite.dispose();
				} catch (Exception e) {
					// ingnore
				}
			}
			
			fEditorComposite.setVisible(true);		
			fEditorComposite.setFocus();
			
			tefEditor.setCloser(
				new Closer(tefEditor, getControl(), fEditorComposite));
		
		} catch (Exception e) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
					Status.ERROR, "could not instantiate a popup editor", e));
			MessageDialog.openError(fShell, "Cannot open pop-up editor!", 
					"Cannot open pop-up editor! Unexpected exception: " + e.getLocalizedMessage());
			fEditorComposite.dispose();
			tefEditor.dispose();
			return;
		}
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
	public static class Closer implements ControlListener, MouseListener, DisposeListener, FocusListener {

		private IPopupEditor fEditor;
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
		public Closer(IPopupEditor editor, Control control, Decorations editorComposite) {
			super();
			fEditor = editor;
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
			fEditor.close(false);
		}

		public void controlMoved(ControlEvent e) {
			fEditor.close(false);
		}

		public void mouseDown(MouseEvent e) {
			fEditor.close(false);
		}

		public void mouseUp(MouseEvent e) {
		}

		public void mouseDoubleClick(MouseEvent e) {
			fEditor.close(false);
		}

		public void focusGained(FocusEvent e) {
		}		

		public void focusLost(FocusEvent e) {
			fEditor.close(false);
		}

		public void widgetDisposed(DisposeEvent e) {
			fEditor.close(false);
		}	
		
		public void close() {
			uninstall();
			fEditorComposite.setVisible(false);
			fEditorComposite.dispose();
		}
	}
}
