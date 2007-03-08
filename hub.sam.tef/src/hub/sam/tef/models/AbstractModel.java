package hub.sam.tef.models;

import hub.sam.tef.models.extensions.DelegateCommandFactory;

import java.util.HashMap;
import java.util.Map;


public abstract class AbstractModel implements IModel {

	private ICommandFactory fFactory = null;
	private Map<IModelElement, IModelElementExtension> fExtensions = new HashMap<IModelElement, IModelElementExtension>();
	private final Object editedResource;
	
	public AbstractModel(final Object editedResource) {
		super();
		this.editedResource = editedResource;
	}

	protected abstract ICommandFactory createCommandFactory();

	public final ICommandFactory getCommandFactory() {
		if (fFactory == null) {
			fFactory = new DelegateCommandFactory(createCommandFactory());
		}
		return fFactory;
	}

	public ICollection getOutermostCompositesOfEditedResource() {
		return getOutermostComposites(editedResource);
	}		
	
}
