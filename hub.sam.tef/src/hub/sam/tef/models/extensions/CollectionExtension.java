package hub.sam.tef.models.extensions;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class CollectionExtension extends Extension implements ICollection {

	private final Collection fValues = new Vector();
	private final ModelElementExtension fSource;
	private final String fProperty;	

	public CollectionExtension(final ModelElementExtension source, final String property) {
		super();
		fSource = source;
		fProperty = property;
	}

	@Override
	public Object getExtendedValue(Object originalValue) {
		return this;
	}	
	
	protected final void addValue(Object value) {
		fValues.add(value);		
	}
	
	protected final void removeValue(Object value) {
		fValues.remove(value);
	}
	
	private final ICollection getSource() {
		return (ICollection)fSource.getValueFromPlatformElement(fProperty);
	}
		
	public int size() {
		return getSource().size() + fValues.size();
	}

	public Iterator iterator() {
		return new MyIerator();
	}
	
	class MyIerator implements Iterator {
		private final Iterator originalIterator;
		private final Iterator extensionsIterator;
		private boolean inOriginalIteration = true;
				
		public MyIerator() {
			originalIterator = getSource().iterator();
			extensionsIterator = fValues.iterator();			
		}

		public boolean hasNext() {
			if (inOriginalIteration) {
				boolean result = originalIterator.hasNext();
				if (!result) {
					result = extensionsIterator.hasNext();		
				} 
				return result;
			} else {
				return extensionsIterator.hasNext();
			}
		}

		public Object next() {
			if (inOriginalIteration) {
				if (originalIterator.hasNext()) {
					return originalIterator.next();
				} else {
					inOriginalIteration = false;
					return extensionsIterator.next();
				}
			} else {
				return extensionsIterator.next();
			}
		}

		public void remove() {
			throw new RuntimeException("assert");
		}		
	}
}
