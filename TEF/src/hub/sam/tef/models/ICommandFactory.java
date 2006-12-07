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
