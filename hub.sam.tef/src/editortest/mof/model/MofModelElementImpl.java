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

import hub.sam.tef.models.AbstractModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.ModelEventListener;


public class MofModelElementImpl extends AbstractModelElement {
	
	private final cmof.reflection.Object fObject;	

	public MofModelElementImpl(final cmof.reflection.Object object) {
		super(object);
		fObject = object;
	}

	@Override
	protected void addChangeListenerToPlatformElement(ModelEventListener listener) {
		fObject.addListener(new PropertyChangeListenerWrapper(listener));
	}

	@Override
	protected void removeChangeListenerFromPlatformElement(ModelEventListener listener) {
		fObject.removeListener(new PropertyChangeListenerWrapper(listener));		
	}

	protected java.lang.Object getValueFromPlatformElement(String property) {
		java.lang.Object result = fObject.get(property);
		return Mof.objectFromMofObject(result);
	}
	
	public IMetaModelElement getMetaElement() {
		return new MofMetaModelElementImpl(fObject.getMetaClass());
	}

	protected void setValueToPlatformElement(String property, java.lang.Object value) {
		fObject.set(property, Mof.mofObjectFromObject(value));
	}
	
	public cmof.reflection.Object getMofObject() {
		return fObject;
	}

	
	public void delete() {
		fObject.delete();	
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MofModelElementImpl) {
			return fObject.equals(((MofModelElementImpl)obj).fObject);
		} else {
			return false;
		}
	}	

	@Override
	public int hashCode() {
		return fObject.hashCode();
	}
}
