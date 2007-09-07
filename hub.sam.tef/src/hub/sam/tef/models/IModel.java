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
package hub.sam.tef.models;

import hub.sam.util.container.IDisposable;

public interface IModel extends IDisposable {
	
	public Iterable<IModelElement> getElements(IMetaModelElement metaElement);
	
	public Iterable<IModelElement> getElements(IMetaModelElement metaElement, Object resourceFilter);
	
	public Iterable<IModelElement> getElementExceptEditedResource(IMetaModelElement metaElement);
	
	public ICommandFactory getCommandFactory();
	
	/**
	 * Used to create mock-objects for invalid-identifier/references
	 */
	public IModelElement createElement(IMetaModelElement metaElement);
	
	public IMetaModelElement getMetaElement(String name);
	
	public IType getType(String name);
	
	public IType getType(Class theTypesJavaClass);
	
	public ICollection getOutermostComposites(Object resourceId);
	
	public ICollection getOutermostCompositesOfEditedResource();
	
	public void replaceOutermostComposite(Object resource, IModelElement oldElement, IModelElement newElement);
}
