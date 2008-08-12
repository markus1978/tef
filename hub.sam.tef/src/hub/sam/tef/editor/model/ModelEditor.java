package hub.sam.tef.editor.model;

import hub.sam.tef.editor.ErrorAnnotation;
import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

/**
 * Model editors do not edit text files, but files containing EMF model XMI. These model editors use
 * a specific document provider.
 * 
 * A model editor provides the following information about the used language:
 * <ul>
 * <li>layout manager</li>
 * </ul>
 */
public abstract class ModelEditor extends TextEditor {

	public ModelEditor() {
		super();
		initialiseDocumentProvider();
	}

	protected void initialiseDocumentProvider() {
		setDocumentProvider(new ModelDocumentProvider(this));
	}

	public abstract AbstractLayoutManager createLayout();

	/**
	 * Adds the given resource to the resource set of this editor. This is the primary resource that
	 * is supposed to contain the edited model. This method can only be called once in the life
	 * cycle of this editor.
	 */
	public void setModel(Resource resource) {
		fResourceSet = resource.getResourceSet();
		if (fResourceSet == null || fResourceSet.getResources().size() == 0) {
			fResourceSet = new ResourceSetImpl();
			fResourceSet.getResources().add(resource);
		}
	}

	public IModelCreatingContext createModelCreatingContext() {
		Resource currentModel = getCurrentModel();
		return new ModelCreatingContext(getMetaModelPackages(), getSemanticsProvider(),
				currentModel, getCurrentText()) {
			@Override
			public void addCreatedObject(EObject object) {
				if (getResource() != null) {
					getResource().getContents().clear();
				}
				super.addCreatedObject(object);
			}
		};
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
	}

	/**
	 * @return text representation of the current model, produced by the editors pretty printer
	 */
	@Override
	public String getCurrentText() {
		PrettyPrinter printer = createPrettyPrinter();
		printer.setLayout(createLayout());
		if (getCurrentModel() == null || getCurrentModel().getContents().isEmpty()
				|| getCurrentModel().getContents().get(0) == null) {
			return super.getCurrentText();
		} else {
			try {
				PrettyPrintState state = printer.print(getCurrentModel().getContents().get(0));
				return state.toString();
			} catch (ModelCreatingException e) {
				return null;
			}
		}
	}

	/**
	 * Waits for possibly running reconciling. Does only save if there is no error in the model.
	 */
	@Override
	public void doSave(final IProgressMonitor progressMonitor) {
		new Thread() {
			@Override
			public void run() {
				synchronized (ModelEditor.this) {

					while (isReconcileDirty) {
						try {
							ModelEditor.this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				boolean hasErrors = false;

				for (Iterator<?> annotationIt = getSourceViewer().getAnnotationModel()
						.getAnnotationIterator(); annotationIt.hasNext();) {
					if (annotationIt.next() instanceof ErrorAnnotation) {
						hasErrors = true;
						break;
					}
				}
				if (!hasErrors) {
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
						public void run() {
							ModelEditor.super.doSave(progressMonitor);
						}
					});
				} else {
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {
							MessageDialog.openWarning(ModelEditor.this.getSite().getShell(),
									"Warning", "Cannot save the document if it contains errors.");
						}
					});
				}
			}
		}.start();
	}

	/**
	 * Can be overridden by subclasses to provide a custom resource set, e.g., one with a
	 * transactional editing domain.
	 * 
	 * @return a new resource set
	 */
	protected ResourceSet createResourceSet() {
		return new ResourceSetImpl();
	}
}
