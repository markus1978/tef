package hub.sam.tef.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import hub.sam.tef.views.Text;

public class InternalModelElement implements IModelElement {

	private final IMetaModelElement fMetaModel;
	private final Collection<ModelEventListener> fListeners = new Vector<ModelEventListener>();
	private final Map<String, Object> fValues = new HashMap<String, Object>();	
	
	public InternalModelElement(final IMetaModelElement metaModel) {
		super();
		fMetaModel = metaModel;
	}

	public void addChangeListener(ModelEventListener listener) {
		fListeners.add(listener);
	}

	public IMetaModelElement getMetaElement() {
		return fMetaModel;
	}

	public Text[] getRegisteredOccureces() {
		return new Text[0];
	}

	public Object getValue(String property) {
		return fValues.get(property);
	}
	
	public void setValue(String property, Object value) {
		fValues.put(property, value);
	}

	public void registerOccurence(Text text) {
		// empty
	}

	public void removeChangeListener(ModelEventListener listener) {
		fListeners.remove(listener);
	}

}
