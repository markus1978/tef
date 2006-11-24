package hub.sam.tef.models;

import hub.sam.tef.views.Text;

public interface IModelElement {

	public Object getValue(String property);
	
	//public void setValue(String property, Object value);		
	
	public void addChangeListener(ModelEventListener listener);
	
	public void removeChangeListener(ModelEventListener listener);
	
	//public void delete();
	
	public IMetaModelElement getMetaElement();
	
	public void registerOccurence(Text text);
	
	public Text[] getRegisteredOccureces();
}
