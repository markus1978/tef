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

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;

public class EcoreDocumentProvider extends EMFDocumentProvider {

	private final EPackage fEcorePackage = EcorePackage.eINSTANCE;
	private final EFactory fEcoreFactory = EcoreFactory.eINSTANCE;
	@Override
	protected EFactory getFactory() {
		return fEcoreFactory;
	}
	@Override
	protected EPackage getPackage() {
		return fEcorePackage;
	}
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new EcoreDocument();		
	}
	@Override
	protected EditingDomain getEditingDomain() {
		return EcoreEditor.getSharedEditingDomain();
	}
	
	
}
