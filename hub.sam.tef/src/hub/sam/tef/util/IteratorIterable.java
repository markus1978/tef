package hub.sam.tef.util;

import java.util.Iterator;

public class IteratorIterable<T> implements Iterable<T> {

	private final Iterator<T> fIterator;

	public IteratorIterable(Iterator<T> iterator) {
		super();
		fIterator = iterator;
	}

	public Iterator<T> iterator() {
		return fIterator;
	}	
}
