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
package editortest.emf.model;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;

import org.eclipse.emf.ecore.EClass;


public class EMFMetaModelElement implements IMetaModelElement {

	private final EClass fMetaElement;
	
	public EMFMetaModelElement(final EClass metaElement) {
		super();
		fMetaElement = metaElement;
	}
	
	public boolean isMetaModelFor(IModelElement e) {
		if (e.getMetaElement() instanceof EMFMetaModelElement) {
			return fMetaElement.isSuperTypeOf(((EMFMetaModelElement)e.getMetaElement()).fMetaElement);
		} else {
			return false;
		}
	}

	public EClass getEMFObject() {
		return fMetaElement;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EMFMetaModelElement) {
			return fMetaElement.equals(((EMFMetaModelElement)obj).fMetaElement);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fMetaElement.hashCode();
	}

	@Override
	public String toString() {
		return fMetaElement.getName();
	}	
	
}
