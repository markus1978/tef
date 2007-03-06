package hub.sam.tef.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class InternalCollection<T> implements ICollection<T> {

	private final Collection<T> fValues = new Vector<T>();
	
	public int size() {
		return fValues.size();
	}

	public Iterator<T> iterator() {
		return fValues.iterator();
	}
	
	public void add(T value) {
		fValues.add(value);
	}

}
