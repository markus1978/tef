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

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * Pretty prints models to make them available for the editor.
 * 
 * @author Markus Scheidgen
 * @author <a href="mailto:sadilek@informatik.hu-berlin.de">Daniel Sadilek</a>
 * @author Dirk Fahland
 */
public class ModelDocumentProvider extends FileDocumentProvider implements IDocumentProvider {

	private final ModelEditor fEditor;
	private Map<EObject, Position> objectPositions = null;

	public ModelDocumentProvider(ModelEditor editor) {
		super();
		fEditor = editor;
	}

	@Override
	protected boolean setDocumentContent(final IDocument document, IEditorInput editorInput)
			throws CoreException {
		Assert.isTrue(editorInput instanceof IFileEditorInput);
		IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;

		// If the model is already loaded, this method was called to update the model contents from
		// the file system.

		if (fEditor.getCurrentModel() != null) {
			modelDispose();
		}

		final Resource resource = loadXMI(fileEditorInput);
		fEditor.setModel(resource);

		boolean changed = updateDocumentContents(document, resource);
		return changed;
	}

	/**
	 * Unloads the current model when the last editor for it has been closed.
	 * 
	 * @see org.eclipse.ui.editors.text.FileDocumentProvider#disposeElementInfo(java.lang.Object,
	 *      org.eclipse.ui.texteditor.AbstractDocumentProvider.ElementInfo)
	 */
	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		modelDispose();
		super.disposeElementInfo(element, info);
	}

	/**
	 * Unloads the current model.
	 */
	protected void modelDispose() {
		fEditor.getCurrentModel().unload();
	}

	/**
	 * Pretty prints the model and updates the document with the result.
	 * 
	 * @param document
	 * @param resource
	 * @return
	 * @throws CoreException
	 */
	protected boolean updateDocumentContents(IDocument document, Resource resource)
			throws CoreException {
		String content = "";
		if (!resource.getContents().isEmpty()) {
			EObject root = resource.getContents().get(0);
			PrettyPrinter printer = fEditor.createPrettyPrinter();
			printer.setLayout(fEditor.createLayout());
			try {
			    PrettyPrintState state = printer.print(root);
			    objectPositions = state.getObjectPositions();
				content = state.toString();
			} catch (ModelCreatingException e) {
				throw new CoreException(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
						"Could not pretty print the model", e));
			}
		}

		boolean changed = !document.get().equals(content);
		if (changed) {
			document.set(content);
		}
		return changed;
	}
	
	public Map<EObject, Position> getObjectPositions() {
        return objectPositions;
    }

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput,
			String encoding) throws CoreException {
		return setDocumentContent(document, editorInput);
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream)
			throws CoreException {
		throw new UnsupportedOperationException("Cannot read model from stream.");
	}

	/**
	 * Save the current model of the editor, method must be called within an operation.
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
			boolean overwrite) throws CoreException {
		Resource resourceToSave = fEditor.getCurrentModel();
		try {
			resourceToSave.save(null);
		} catch (IOException e) {
			throw new CoreException(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Couldn't save the model", e));
		} catch (UnsupportedOperationException e) {
			throw new CoreException(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Resource does not support save operation.", e));
		}
	}

	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}

	protected Resource loadXMI(IFileEditorInput editorInput) throws CoreException {
		ResourceSet resourceSet = fEditor.createResourceSet();

		for (EPackage metaModelPackage : fEditor.getMetaModelPackages()) {
			resourceSet.getPackageRegistry().put(metaModelPackage.getNsURI(), metaModelPackage);
		}
		Resource resource = null;
		try {
			URI exampleModelFile = URI.createPlatformResourceURI(editorInput.getFile()
					.getFullPath().toString(), true);
			resource = resourceSet.getResource(exampleModelFile, true);
		} catch (Throwable e) {
			throw new CoreException(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
					"Could not load the model", e));
		}
		return resource;
	}
}
