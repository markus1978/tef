package hub.sam.tef.models;


public abstract class AbstractModel implements IModel {

	private ICommandFactory fFactory = null;
	
	protected abstract ICommandFactory createCommandFactory();

	public final ICommandFactory getCommandFactory() {
		if (fFactory == null) {
			fFactory = new DelegateCommandFactory(createCommandFactory());
		}
		return fFactory;
	}	

}
