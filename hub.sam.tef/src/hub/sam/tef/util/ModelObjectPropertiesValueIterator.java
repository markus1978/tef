package hub.sam.tef.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A model object property value iterator allows to iterate through multi-valued
 * properties. All properties can be iterated simultaniously. This iterator is
 * like a map of iterators with the model objects structural features as key.
 */
public class ModelObjectPropertiesValueIterator {

	/**
	 * All property values are read from this object.
	 */
	private final org.eclipse.emf.ecore.EObject fObject;
	/**
	 * This map is used to iterate through the indices of the value lists for
	 * all multi-valued properties.
	 */
	private Map<EStructuralFeature, Integer> indexes = 
		new HashMap<EStructuralFeature, Integer>();
	
	
	public ModelObjectPropertiesValueIterator(EObject object) {
		super();
		fObject = object;
	}
	
	/**
	 * Creates a copy.
	 */
	public ModelObjectPropertiesValueIterator(ModelObjectPropertiesValueIterator original) {
		fObject = original.fObject;
		appendIndexes(original);
	}


	/**
	 * Used to copy the internal iterators.
	 * 
	 * @param original
	 *            the iterator to copy.
	 */
	private void appendIndexes(ModelObjectPropertiesValueIterator original) {
		for (EStructuralFeature key: original.indexes.keySet()) {
			indexes.put(key, (int)original.indexes.get(key));
		}
	}
	
	/**
	 * Returns true if there is a next value in the property.
	 * 
	 * @param property 
	 *            is the property.
	 * @return true if there is a next value in the property. For single valued
	 *         properties true is returned if a value is set, false if the
	 *         property is null. For a collection, true is also returned even if
	 *         the collection does not contain another value, but should contain
	 *         a value based on the properties lower bound.
	 */
	@SuppressWarnings("unchecked")
	public boolean hasNext(EStructuralFeature property) {		
		Object value = fObject.eGet(property);
		if (value == null) {
			return true;
		}
		if (value instanceof EList) {
			EList collectionValue = (EList)value;
			Integer index = indexes.get(property);
			if (index == null) {
				index = 0;
				indexes.put(property, index);
			}			
			if (collectionValue.size() > index) {
				return true;
			} else {
				if (property.getLowerBound() > index) {
					return true;
				} else {
					return false;
				}
			}			
		} else {
			return true;
		}
	}
	
	/**
	 * Reads the next value from a property.
	 * 
	 * @param binding
	 *            is the binding that provides the property (TODO, why not use
	 *            the property directly).
	 * @return the next value of the property. For single valued properties,
	 *         this value is returned, no matter how often this value is read.
	 *         For collections, the next value is returned. If there is no next
	 *         value, but there should be a next value based on the properties
	 *         lower bound, null is return. If there is no next value, and there
	 *         also shouldn't be a next value based on the properties lower
	 *         bound, an exception is thrown.
	 * @throws ArrayIndexOutOfBoundsException,
	 *             if there is no next property value and there is no next value
	 *             supposed to be.
	 */
	@SuppressWarnings("unchecked")
	public Object next(EStructuralFeature property) {	
		Object value = fObject.eGet(property);
		if (value == null) {
			return null;
		}
		if (value instanceof EList) {
			EList collectionValue = (EList)value;
			Integer index = indexes.get(property);
			if (index == null) {
				index = 0;
				indexes.put(property, index);
			}			
			if (collectionValue.size() > index) {
				indexes.put(property, index + 1);
				return collectionValue.get(index);
			} else {
				if (property.getLowerBound() > index) {					
					indexes.put(property, index + 1);
					return null;
				} else {					
					throw new ArrayIndexOutOfBoundsException();
				}				
			}			
		}
		return value;
	}
}
