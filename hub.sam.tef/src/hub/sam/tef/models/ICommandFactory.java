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

public interface ICommandFactory {

	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property, int position);
	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property);
	public ICommand replace(IModelElement owner, String property, Object oldValue, Object newValue);
	public ICommand delete(Object element);
	public ICommand remove(IModelElement owner, String property, Object value);	
	public ICommand set(IModelElement owner, String property, Object value);
	public ICommand add(IModelElement owner, String property, Object value, int position);
	public ICommand add(IModelElement owner, String property, Object value);
	
}
