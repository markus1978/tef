package editortest.emf.model;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

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

	
}
