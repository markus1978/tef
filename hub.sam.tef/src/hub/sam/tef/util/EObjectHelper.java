/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
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

package hub.sam.tef.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EObjectHelper {
	
	/**
	 * @return an attribute of the given object that is highly
	 * probable to contain a local id for the given object. Local
	 * id means that it only identifies this object within its container.
	 * 
	 * the id attribute is either the id attribute of the objects class
	 * (in this case it has to be a global id attribute); an attribute
	 * called name, or any other non many string valued attribute that is
	 * set.
	 * 
	 * If no such attribute can be found, null is returned.
	 */
	public static EAttribute getIdAttribute(EObject object) {
		EClass eClass = object.eClass();
		
		// try the obvious: id attribute, or attribute called name
		EAttribute idAttribute = eClass.getEIDAttribute();
		if (idAttribute != null) {
			return idAttribute;
		} else {
			Object nameFeature = eClass.getEStructuralFeature("name");
			if (nameFeature != null && nameFeature instanceof EAttribute) {
				return (EAttribute)nameFeature;
			}
		}
		
		// try to find a single valued string attribute
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isMany() && 
					attribute.getEType().equals(
					EcorePackage.eINSTANCE.getEString())) {
				if (object.eIsSet(attribute)) {
					return attribute;
				}
			}
		}
		return null;
	}
	
	/**
	 * @return Returns a highly probable local id of the given object. Local
	 *         means that this id might only identify the object within its
	 *         container. If no attribute id can be found for the object, its
	 *         class is used as id.
	 */
	public static Object getLocalId(EObject object) {
		EAttribute idAttribute = getIdAttribute(object);
		Object idValue = null;
		if (idAttribute != null) {
			idValue = object.eGet(idAttribute);
		} else {
			idValue = object.eClass();
		}
		return idValue;
	}
	
	/**
	 * @return a highly probably global id for the given object. Uses
	 *         {@link #getLocalId(EObject), #getIdAttribute(EObject)}.
	 *         TODO unused???
	 */
	public static List<Object> getFullQuallifiedId(EObject object) {
		List<Object> result = new ArrayList<Object>();
		appendId(object, result);
		return result;
	}
	
	/**
	 * Helper for {@link #getFullQuallifiedId(EObject)}.
	 */
	private static void appendId(EObject object, List<Object> appendTo) {
		EObject container = object.eContainer();
		if (container != null) {
			appendId(container, appendTo);
		}
		appendTo.add(getLocalId(object));
	}

	/**
	 * Check whether list contains object o from a given start index onwards.
	 * @param list list to check
	 * @param o object to be contained in list
	 * @param fromIndex
	 * @return index of the first occurrence of o in list from fromIndex onwards 
	 * 
	 * @author Dirk Fahland
	 */
	public static int indexOf(EList<? extends EObject> list, EObject o, int fromIndex)
	{
		if (fromIndex < 0)
			fromIndex = 0;
	
		ListIterator<? extends EObject> it = list.listIterator(fromIndex);
		while (it.hasNext()) {
			int i = it.nextIndex();
			EObject element = it.next();
			if (o == null) {
				if (element == null)
					return i;
			}
			else if (o == element || o.equals(element) || EcoreUtil.equals(o, element))
			{
				return i;
			}
		}
		return -1;
	  }
	  
	  
	/**
	 * @param list list to check
	 * @param o object to be contained in list
	 * @return true if the list contains a structurally equal object o
	 * 
	 * @author Dirk Fahland
	 */
	public static boolean contains(EList<? extends EObject> list, EObject o) 
	{
		return (indexOf(list,o,0) >= 0);
	}
}
