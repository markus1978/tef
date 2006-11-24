package hub.sam.tef.models;

public interface IModel {
	
	public Iterable<IModelElement> getElements(IMetaModelElement metaElement);
	
	public ICommandFactory getCommandFactory();
	
	//public IModelElement createElement(IMetaModelElement metaElement);
	
	public IMetaModelElement getMetaElement(String name);
	
	public ICollection getOutermostComposites();
}
