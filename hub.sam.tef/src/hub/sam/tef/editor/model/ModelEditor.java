/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Daniel Sadilek
 *                         Dirk Fahland
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

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

import org.eclipse.core.runtime.Assert;
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
 * 	<li>layout manager</li>
 * </ul>
 */
public abstract class ModelEditor extends TextEditor {
	
	private Resource fResource;

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
	 * cycle of this editor instance.
	 */
	public void setModel(Resource resource) {
		Assert.isNotNull(resource, "Given resource must not be null.");
		fResource = resource;
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
	 * @return text representation of the current model, produced
	 * by the editors pretty printer
	 * 
	 * @author Dirk Fahland
	 */
	public String getCurrentPrettyPrintedText() {
		PrettyPrinter printer = createPrettyPrinter();
		printer.setLayout(createLayout());
		if (getCurrentModel() == null
			|| getCurrentModel().getContents().isEmpty()
			|| getCurrentModel().getContents().get(0) == null)
		{
			return getCurrentText(); 
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
	 * Overrides the {@link TextEditor}s behavior, which returns the first resource in the resource
	 * set. Because there may be more than one resource in the resource set of a model editor, we
	 * return the model this editor was created for.
	 * 
	 * @see hub.sam.tef.editor.text.TextEditor#getCurrentModel()
	 */
	@Override
	public Resource getCurrentModel() {
		return fResource;
	}

	/**
	 * In a model editor, the {@link IModelCreatingContext} already contains a reference to the
	 * editor's resource. Therefore, this method does not have to do anything (in contrast to the
	 * {@link TextEditor}).
	 * 
	 * @see hub.sam.tef.editor.text.TextEditor#updateStoreResource(hub.sam.tef.modelcreating.IModelCreatingContext)
	 * 
	 * @author Dirk Fahland
	 */
	@Override
	protected Resource updateStoreResource(IModelCreatingContext context) {
		final Resource contextResource = context.getResource();
		Resource storeResource = getCurrentModel(); 
		
		Assert.isTrue(storeResource != null, "null resource in the model editor");
		
		// update the current resource of the editor
		if (storeResource != contextResource) {
			// move model from the context resource to the editor resource
			storeResource.getContents().clear();
			storeResource.getContents().addAll(contextResource.getContents());				
		}
		fResource = storeResource;
		
		return getCurrentModel();
	}
	
	/**
	 * Waits for possibly running reconciling. Does only save if there is
	 * no error in the model.
	 */
	@Override
	public void doSave(final IProgressMonitor progressMonitor) {
		new Thread() {
			@Override
			public void run() {
				waitForReconciliation();

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
