package hub.sam.tef.models;

import org.eclipse.core.runtime.Status;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.models.extensions.DelegateCommandFactory;

public abstract class AbstractModel implements IModel {

	private ICommandFactory fFactory = null;	
	private final Object editedResourceId;
	
	public AbstractModel(final Object editedResourceId) {
		super();
		this.editedResourceId = editedResourceId;
	}

	protected abstract ICommandFactory createCommandFactory();

	public final ICommandFactory getCommandFactory() {
		if (fFactory == null) {
			fFactory = new DelegateCommandFactory(createCommandFactory());
		}
		return fFactory;
	}

	public ICollection getOutermostCompositesOfEditedResource() {
		return getOutermostComposites(editedResourceId);
	}		
	
	final public void replaceOutermostComposite(Object resourceId, IModelElement oldElement, IModelElement newElement) {		
		ICollection outermostComposites = getOutermostComposites(resourceId);
		if (!outermostComposites.contains(oldElement)) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR,
					TEFPlugin.PLUGIN_ID, Status.OK, 
					"old composite is not part of the model",
					null));			
		}
		int size = outermostComposites.size();
		getCommandFactory().remove(outermostComposites, oldElement).execute();		
		getCommandFactory().add(getOutermostComposites(resourceId), newElement).execute();
		if (getOutermostComposites(resourceId).size() > size) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR,
					TEFPlugin.PLUGIN_ID, Status.OK, 
					"composite was edit and not replaced",
					null));			
		}
	}

	public Iterable<IModelElement> getElementExceptEditedResource(IMetaModelElement metaElement) {
		return getElements(metaElement, editedResourceId);
	}
		
}
