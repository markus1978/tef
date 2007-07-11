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
package hub.sam.tef.expressions;

import hub.sam.tef.emf.EMFDocumentProvider;

import java.util.Vector;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;

import expressions.ExpressionsFactory;
import expressions.ExpressionsPackage;

public class ExpressionsDocumentProvider extends EMFDocumentProvider {

	private final EPackage fPackage = ExpressionsPackage.eINSTANCE;
	private final EFactory fFactory = ExpressionsFactory.eINSTANCE;

	@Override
	protected Iterable<EFactory> getFactory() {
		Vector<EFactory> result = new Vector<EFactory>();
		result.add(fFactory);
		return result;
	}
	
	@Override
	protected Iterable<EPackage> getPackage() {
		Vector<EPackage> result = new Vector<EPackage>();
		result.add(fPackage);
		return result;
	}
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new ExpressionsDocument();		
	}
	
	@Override
	public EditingDomain getEditingDomain() {
		return EcoreEditor.getSharedEditingDomain();
	}
	
}
