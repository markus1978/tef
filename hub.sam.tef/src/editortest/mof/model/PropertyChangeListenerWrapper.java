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

import hub.sam.tef.models.ModelEventListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.swt.widgets.Listener;


public class PropertyChangeListenerWrapper implements PropertyChangeListener {

	private final ModelEventListener fListener;

	public PropertyChangeListenerWrapper(final ModelEventListener listener) {
		super();
		fListener = listener;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		Object value = evt.getNewValue();
		
		if (value instanceof cmof.reflection.Object) {
			value = new MofModelElementImpl((cmof.reflection.Object)value);
		}
		fListener.propertyChanged(value, evt.getPropertyName());		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropertyChangeListenerWrapper) {
			return ((PropertyChangeListenerWrapper)obj).fListener.equals(fListener);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fListener.hashCode();
	}		
	
	
	
}
