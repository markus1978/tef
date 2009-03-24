package hub.sam.tef.prettyprinting;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.util.ModelObjectPropertiesValueIterator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

/**
 * A pretty print state describes the current state of a pretty printer. It
 * contains the so-far printed content; the object that is currently been
 * printed (actual), and a property iterator for this actual object.
 * 
 * When the pretty printer navigates a model multiple states are created. Each
 * time the printer navigates "down" into new property value, a new state is
 * created. Therefore each state always only contains iterators and text for the
 * currently printed value. After pretty printing for this value is over, the
 * printed text has to be append to the old state (the state used to print the
 * "container" of the value).
 */
public class PrettyPrintState {
	private Object actual;	
	private ModelObjectPropertiesValueIterator fIterator = null;
	private final StringBuffer buffer = new StringBuffer();
	private Map<EObject, Position> objectPositions = new HashMap<EObject, Position>(); 
		
	public PrettyPrintState(Object actual) {
		super();
		this.actual = actual;
		if (actual instanceof EObject) {
			fIterator = new ModelObjectPropertiesValueIterator((EObject)actual);
		}
	}
	
	/**
	 * Creates a copy of a given old state.
	 */
	public PrettyPrintState(PrettyPrintState oldState) {
		this.actual = oldState.actual;
 		if (oldState.fIterator != null) {
 			fIterator = new ModelObjectPropertiesValueIterator(oldState.fIterator);
 		}
	}
	
	/**
	 * Checks whether the giving binding is a reasonable value binding for the
	 * actual value.
	 */
	public boolean fitsBinding(ValueBinding binding) {
		if (actual == null) {
			return true;
		}
		if (binding instanceof ElementBinding) {
			return ((EObject)actual).eClass().getEAllSuperTypes().contains(
							((ElementBinding)binding).getMetaclass()) ||
					((EObject)actual).eClass().equals(
							((ElementBinding)binding).getMetaclass());
		} else {
			return true;
		}
	}
	
	/**
	 * @return the actually printed value.
	 */
	public Object getActual() {
		return this.actual;
	}

	/**
	 * @return true if there is still a value to be printed for the property in the
	 *         given property binding. For single value properties, this is
	 *         always true if this property has a value.
	 */
	public boolean hasValueForBinding(PropertyBinding binding) throws ModelCreatingException {
		if (actual == null) {
			return false;
		}
		if (!(actual instanceof EObject)) {
			throw new ModelCreatingException(
					new TslException("Property binding in the scope of a primitive value."));
		}
		boolean result = fIterator.hasNext(binding.getProperty());
		return result || binding.getDefault() != null;
	}
	
	/**
	 * @return the next value to be printed for the property in the given
	 *         property binding. For single value properties, its same value is
	 *         always returned.
	 */
	public Object getValueForBinding(PropertyBinding binding) throws ModelCreatingException {
		Assert.isTrue(actual != null);
		if (!(actual instanceof EObject)) {
			throw new ModelCreatingException(
					new TslException("Property binding in the scope of a primitive value."));
		}
		if (fIterator.hasNext(binding.getProperty())) {
			return fIterator.next(binding.getProperty());
		} else {
			return binding.getDefault();
		}
	}
	
	public Map<EObject, Position> getObjectPositions() {
	    return objectPositions;
	}
	
	/**
	 * Appends a state. When an empty state is used to print a sub-model, it can
	 * be appended to the state of the model. Append deals with the printed text
	 * and the current actual iterator.
	 */
	public void append(PrettyPrintState state) {
		int start = buffer.length();
	    buffer.append(state.buffer);
		for (EObject object: state.objectPositions.keySet()) {		    
		    Position position = state.objectPositions.get(object);
		    position.offset += start;
		    objectPositions.put(object, position);
		}
		if (state.actual instanceof EObject) {
		    objectPositions.put((EObject) state.actual, new Position(start, buffer.length() - start));
		}
		if (actual == state.actual) {
			if (state.fIterator != null) {
				fIterator = new ModelObjectPropertiesValueIterator(state.fIterator);
			}
		}		
	}
	
	/**
	 * Prints a string to the printed text.
	 */
	public void append(String string) {
		buffer.append(string);
	}
	
	/**
	 * @return the so-far printed text.
	 */
	@Deprecated
	public String getContent() {
		return buffer.toString();
	}

	/**
	 * @return the so-far printed text.
	 */
	public String toString () {
		return buffer.toString();
	}
}
