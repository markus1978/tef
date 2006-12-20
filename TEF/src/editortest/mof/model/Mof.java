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
package editortest.mof.model;

import hub.sam.tef.models.IModelElement;
import cmof.common.ReflectiveCollection;
import cmof.common.ReflectiveSequence;

public class Mof {

	protected static Object mofObjectFromObject(Object object) {
		if (object instanceof IModelElement) {
			return ((MofModelElementImpl)object).getMofObject();
		} else {
			return object;
		}
	}
	
	protected static Object objectFromMofObject(Object object) {
		if (object instanceof cmof.reflection.Object) {
			return new MofModelElementImpl((cmof.reflection.Object)object);
		} else if (object instanceof ReflectiveSequence) {
			return new MofSequenceImpl((ReflectiveSequence)object);
		} else if (object instanceof ReflectiveCollection) {		
			return new MofSetImpl((ReflectiveCollection)object);
		} else {
			return object;
		}
	}
}
