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

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.ICommandFactory;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;

public class EMFCommandFactory implements ICommandFactory {

	private final EditingDomain fEditDomain;
	private final EMFModel model;
		
	protected EMFCommandFactory(final EditingDomain editDomain, final EMFModel model) {
		super();
		fEditDomain = editDomain;
		this.model = model;
	}

	public ICommand add(IModelElement owner, String property, Object value, int position) {		
		return new EMFCommand(AddCommand.create(fEditDomain, ((EMFModelElement)owner).getEMFObject(), 
				((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(value), position));
	}

	public ICommand add(IModelElement owner, String property, Object value) {
		return new EMFCommand(AddCommand.create(fEditDomain, ((EMFModelElement)owner).getEMFObject(), 
				((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(value)));
	}

	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property, int position) {		
		return new EMFCommand(new CreateChildCommand(fEditDomain, 
				((EMFModelElement)owner).getEMFObject(),				
				((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(model.createElement(type)), position, 
				null));
	}

	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property) {
		return new EMFCommand(new CreateChildCommand(fEditDomain, 
				((EMFModelElement)owner).getEMFObject(),				
				((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(model.createElement(type)), 
				null));
	}

	public ICommand remove(IModelElement owner, String property, Object value) {
		return new EMFCommand(RemoveCommand.create(fEditDomain, 
				((EMFModelElement)owner).getEMFObject(), ((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(value)));
	}
	
	public ICommand delete(Object element) {
		return new EMFCommand(DeleteCommand.create(fEditDomain, EMFModel.getEMFObjectForModel(element)));
	}

	public ICommand replace(IModelElement owner, String property, Object oldValue, Object newValue) {
		Collection replacement = new Vector();
		replacement.add(EMFModel.getEMFObjectForModel(newValue));
		return new EMFCommand(ReplaceCommand.create(fEditDomain, 
				((EMFModelElement)owner).getEMFObject(), ((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(oldValue), replacement));
	}

	public ICommand set(IModelElement owner, String property, Object value) { 
		return new EMFCommand(SetCommand.create(fEditDomain, 
				((EMFModelElement)owner).getEMFObject(), ((EMFModelElement)owner).getEMFFeatureForProperty(property), 
				EMFModel.getEMFObjectForModel(value)));
	}

	public ICommand add(ICollection list, Object value) {
		return new EMFCommand(new AddCommand(fEditDomain, 
				((EMFSequence)list).getEMFObject(), EMFModel.getEMFObjectForModel(value)));
	}

	public ICommand remove(ICollection list, Object value) {
		return new EMFCommand(new RemoveCommand(fEditDomain, 
				((EMFSequence)list).getEMFObject(), EMFModel.getEMFObjectForModel(value)));
	}

	
}
