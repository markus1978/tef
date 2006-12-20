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
package hub.sam.tef.controllers;

import hub.sam.tef.models.IModelElement;

public class AbstractRequestHandler<ElementType> {

	private final IModelElement fOwner;
	private final String fProperty;
	private final ElementType fValue;
	
	public AbstractRequestHandler(final IModelElement owner, final String property, final ElementType value) {
		super();
		fOwner = owner;
		fProperty = property;
		fValue = value;
	}

	public IModelElement getOwner() {
		return fOwner;
	}

	public String getProperty() {
		return fProperty;
	}

	public ElementType getValue() {
		return fValue;
	}
	
	
}
