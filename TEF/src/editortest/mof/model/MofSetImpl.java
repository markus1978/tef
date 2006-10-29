package editortest.mof.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import cmof.common.ReflectiveCollection;
import editortest.model.ModelEventListener;
import editortest.model.Set;

public class MofSetImpl<E> implements Set<E> {

	private final ReflectiveCollection<E> fCollection;
	private final Collection<ModelEventListener> fListener = new Vector<ModelEventListener>();	
	
	public MofSetImpl(final ReflectiveCollection<? extends E> collection) {
		super();
		fCollection = (ReflectiveCollection<E>)collection;
	}

	public void add(E element) {
		if (element instanceof MofModelElementImpl) {
			fCollection.add(((MofModelElementImpl)element).getMofObject());
		} else {
			fCollection.add(element);
		}
		for(ModelEventListener listener: fListener) {
			listener.elementAdded(element);
		}
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
			if (result instanceof cmof.reflection.Object) {
				return new MofModelElementImpl((cmof.reflection.Object)result);
			} else {
				return result;
			}
		}

		public void remove() {			
		}		
		
	}

	public Iterator<E> iterator() {
		return new MyIterator(fCollection.iterator());
	}

	public void addChangeListener(ModelEventListener listener) {
		fListener.add(listener);
	}		
}
