/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
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
package editortest.emf.ecore;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.models.IModel;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;

import editortest.emf.model.EMFModel;

public abstract class EMFDocumentProvider extends TEFDocumentProvider {
	
	protected abstract Iterable<EPackage> getPackage();
	protected abstract Iterable<EFactory> getFactory();
	protected abstract EditingDomain getEditingDomain();
		
	protected void setDocumentContent(IDocument document, IModel model) throws CoreException {		
		((TEFDocument)document).setContent(model);		
	}
	
	private IModel loadModel(Resource resource, EditingDomain domain) {
		return new EMFModel(getFactory(), getPackage(), resource, domain);
	}
	
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		if (editorInput instanceof IStorageEditorInput) {
			IStorage storage= ((IStorageEditorInput) editorInput).getStorage();						
			EditingDomain editingDomain = getEditingDomain();
			Resource resource = editingDomain.getResourceSet().getResource(URI.createURI(storage.getFullPath().toString()), true);
			IModel model = loadModel(resource, editingDomain);								
			setDocumentContent(document, model);

			return true;
		}
		return false;
	}
	
	@Override
	protected final void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {		
		if (element instanceof IEditorInput) {
			IEditorInput editorInput = (IEditorInput)element;
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage= ((IStorageEditorInput) editorInput).getStorage();						
				EditingDomain editingDomain = getEditingDomain();
				Resource resource = editingDomain.getResourceSet().getResource(URI.createURI(storage.getFullPath().toString()), true);
				try {
					resource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO
					throw new RuntimeException(e);
				}
			}
		}		
	}
}
