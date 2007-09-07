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
package hub.sam.tef.emf;

import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.emf.model.EMFModel;
import hub.sam.tef.models.IModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PlatformUI;


/**
 * This document provider provides TEF documents based on EMF models. A document
 * is a part of editing domain. The model is identified based on a URI obtained
 * from the editor input. 
 */
public abstract class EMFTextDocumentProvider extends AbstractEMFDocumentProvider {
			
	private IModel loadModel(Resource resource, EditingDomain domain) {
		return new EMFModel(getFactory(), getPackage(), resource, domain);
	}
	
	/*
	 * This is used by the eclipse framework to put contents into the document.
	 */
	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		if (editorInput instanceof IStorageEditorInput) {
			// we enter the content manually override the normal eclipse behaviour, which is tailored for
			// normal text files.
			return setDocumentContentManually(document,
					((IStorageEditorInput) editorInput).getStorage()
							.getContents(), encoding);
		}
		return false;
	}
	
	/**
	 * This can be used to set the document contents manually not using the normal eclipse framework
	 * to do it.
	 */
	public boolean setDocumentContentManually(IDocument document, InputStream contentStream, String encoding) throws CoreException {
		Reader in= null;
		String contents = null;
		try {

			if (encoding == null)
				encoding= getDefaultEncoding();

			in= new BufferedReader(new InputStreamReader(contentStream, encoding), DEFAULT_FILE_SIZE);
			StringBuffer buffer= new StringBuffer(DEFAULT_FILE_SIZE);
			char[] readBuffer= new char[2048];
			int n= in.read(readBuffer);
			while (n > 0) {
				buffer.append(readBuffer, 0, n);
				n= in.read(readBuffer);
			}

			contents = buffer.toString();

		} catch (IOException x) {
			String message= (x.getMessage() != null ? x.getMessage() : ""); //$NON-NLS-1$
			IStatus s= new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, IStatus.OK, message, x);
			throw new CoreException(s);
		} finally {
			try {
				if (in != null)
					in.close();
				else
					contentStream.close();
			} catch (IOException x) {
			}
		}
		
			
		EditingDomain editingDomain = getEditingDomain();
		URI resourceId = null;
		try {
			resourceId = new URIConverterImpl().normalize(URI.createURI("file://" + File.createTempFile("teftempfile", ".xml").getAbsolutePath()));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		Resource resource = editingDomain.getResourceSet().createResource(resourceId);
		//resource = prepareResource(resource);
		if (editingDomain.isReadOnly(resource)) {
			throw new RuntimeException("try to edit a read only resource");
		}
		IModel model = loadModel(resource, editingDomain);											
		((TEFDocument)document).setInitialTextContext(model, resourceId, contents);
		return true;
	}	
	
	protected ElementInfo getElementInfo(Object element) {
		ElementInfo info = super.getElementInfo(element);
		if (info != null) {
			info.fModel = null;
		}
		return info;
	}
	
	@Override
	protected final void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {		
		super.doSaveDocument(monitor, element, document, overwrite);
	}
	
	
}
