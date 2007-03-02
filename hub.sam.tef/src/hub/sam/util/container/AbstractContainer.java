package hub.sam.util.container;

import java.util.HashMap;
import java.util.Map;

public class AbstractContainer implements IContainer {

	private MultiMap<Class, Object> fElements = null;
	private Map<Class, Object> fElement = null;
	
	private MultiMap<Class, Object> getElements() {
		if (fElements == null) {
			fElements = new MultiMap<Class, Object>();
		}
		return fElements;
	}

	private Map<Class, Object> getElement() {
		if (fElement == null) {
			fElement = new HashMap<Class, Object>();
		}
		return fElement;
	}
	
	public <T > void addElement(Class<T> key, T value) {
		getElements().put(key, value);
	}

	public <T> T getElement(Class<T> key) {
		return (T)getElement().get(key);
	}

	public <T> Iterable<T> getAllElements(Class<T> key) {
		return (Iterable<T>)getElements().get(key);
	}

	public <T> void removeElement(Class<T> key) {
		getElement()	.remove(key);	
	}

	public <T> void removeAllElements(Class<T> key) {
		getElements().removeKey(key);
		
	}

	public <T> void setElement(Class<T> key, T value) {
		getElement().put(key, value);
	}

}
