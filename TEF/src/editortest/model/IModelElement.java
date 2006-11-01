package editortest.model;

public interface IModelElement {

	public Object getValue(String property);
	
	public void setValue(String property, Object value);		
	
	public void addChangeListener(ModelEventListener listener);
	
	public IMetaModelElement getMetaElement();
}
