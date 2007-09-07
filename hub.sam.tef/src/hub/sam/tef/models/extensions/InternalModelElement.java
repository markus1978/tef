package hub.sam.tef.models.extensions;

import hub.sam.tef.emf.model.IOccurence;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelChangeListener;
import hub.sam.tef.models.IModelElement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class InternalModelElement implements IModelElement {

	private final IMetaModelElement fMetaModel;
	private final Collection<IModelChangeListener> fListeners = new Vector<IModelChangeListener>();
	private final Map<String, Object> fValues = new HashMap<String, Object>();	
	
	public InternalModelElement(final IMetaModelElement metaModel) {
		super();
		fMetaModel = metaModel;
	}

	public void addChangeListener(IModelChangeListener listener) {
		fListeners.add(listener);
	}

	public IMetaModelElement getMetaElement() {
		return fMetaModel;
	}

	public IOccurence[] getRegisteredOccureces() {
		return new IOccurence[0];
	}

	public Object getValue(String property) {
		return fValues.get(property);
	}
	
	public void setValue(String property, Object value) {
		fValues.put(property, value);
		for (IModelChangeListener listener: fListeners) {
			listener.propertyChanged(this, property);
		}
	}

	public void removeChangeListener(IModelChangeListener listener) {
		fListeners.remove(listener);
	}

	public ICollection getComponents() {
		return new ICollection() {
			public boolean contains(Object object) {
				return false;
			}
			public int size() {
				return 0;
			}
			public Iterator iterator() {
				return new Iterator() {
					public boolean hasNext() {
						return false;
					}
					public Object next() {					
						return null;
					}
					public void remove() {
						
					}									
				};
			}			
		};
	}
	
}
