package hub.sam.tef.util;

import java.util.Iterator;

public class MyIterable<E> implements Iterable<E> {
	private final Iterator<E> fIterator;		
	public MyIterable(Iterator<E> iterator) {
		super();
		fIterator = iterator;
	}
	public Iterator<E> iterator() {
		return fIterator;
	}		
}
