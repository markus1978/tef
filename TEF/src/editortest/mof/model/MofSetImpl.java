package editortest.mof.model;

import java.util.Iterator;

import cmof.common.ReflectiveCollection;
import editortest.model.ICollection;

public class MofSetImpl<E> extends Mof implements ICollection<E> {

	private final ReflectiveCollection<E> fCollection;
	
	public MofSetImpl(final ReflectiveCollection<? extends E> collection) {
		super();
		fCollection = (ReflectiveCollection<E>)collection;
	}

	protected ReflectiveCollection<E> getCollection() {
		return fCollection;
	}
	
	public void add(E element) {
		fCollection.add(mofObjectFromObject(element));
	}
	
	class MyIterator implements Iterator {
		private final Iterator fBase;

		public MyIterator(final Iterator base) {
			super();
			fBase = base;
		}
		public boolean hasNext() {
			return fBase.hasNext();
		}
		public Object next() {
			Object result = fBase.next();
			return objectFromMofObject(result);
		}
		public void remove() {			
		}				
	}

	public Iterator<E> iterator() {
		return new MyIterator(fCollection.iterator());
	}

	public int size() {
		return fCollection.size();
	}	
	
	public boolean remove(E element) {
		return fCollection.remove(mofObjectFromObject(element));
	}

	
	public void replace(E oldElement, E newElement) {
		remove(oldElement);
		add(newElement);
	}
	 
}
