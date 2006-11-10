package editortest.model;

import editortest.text.Text;

public interface IModelElement {

	public Object getValue(String property);
	
	public void setValue(String property, Object value);		
	
	public void addChangeListener(ModelEventListener listener);
	
	public void delete();
	
	public IMetaModelElement getMetaElement();
	
	public void registerOccurence(Text text);
	
	public Text[] getRegisteredOccureces();
}
