package hub.sam.tef.models.extensions;

import hub.sam.tef.models.ISequence;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SequenceExtension extends Extension implements ISequence {

	private final List fValues = new Vector();
	private final List<Integer> fIndeces = new Vector<Integer>();
	private final ModelElementExtension fSource;
	private final String fProperty;	
	
	public SequenceExtension(final ModelElementExtension source, final String property) {
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
		fIndeces.add(size() - 1);
	}

	protected final void addValue(Object value, int index) {
		fValues.add(value);
		fIndeces.add(index);
	}
	
	protected final void removeValue(Object value) {
		int index = fValues.indexOf(value);
		fValues.remove(value);
		fIndeces.remove(index);
	}
	
	private final ISequence getSource() {
		return (ISequence)fSource.getValueFromPlatformElement(fProperty);
	}

	public int size() {
		return getSource().size() + fValues.size();
	}

	// TODO performance
	public Iterator iterator() {
		List result = new Vector();
		for (Object value: getSource()) {
			result.add(value);
		}
		for(int i = 0; i < fValues.size(); i++) {
			result.add(fIndeces.get(i), fValues.get(i));
		}
		return result.iterator();
	}	
}
