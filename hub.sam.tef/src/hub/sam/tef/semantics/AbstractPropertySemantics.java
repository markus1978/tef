package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingException;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A super class for property semantics that contains some helper functions
 * that might be useful for classes implementing {@link IPropertyCreationSemantics} or
 * {@link IPropertyResolutionSemantics}.
 */
public class AbstractPropertySemantics {
	
	protected static class AmbiguousReferenceException extends Exception {
		private static final long serialVersionUID = 1L;

		public AmbiguousReferenceException() {
			super();		
		}		
	}
	
	/**
	 * Helper to resolve a value based on the property type and a id property.
	 * This method goes through all the model objects in the given contents. For all
	 * model-objects that fit the type of the given property, it compared the
	 * value of the given id property (usually the name attribute of the object)
	 * with the given reference value (usually a name).
	 * 
	 * @param idPropertyName
	 *            the name of a property that is a feature of the type of
	 *            potential referenced objects. This is expected to be a
	 *            property of single multiplicity.
	 * @param referenceValue
	 *            is the value that represents the reference. This value is
	 *            compared to the value of the id property in all the potential
	 *            referenced objects.
	 * @param type
	 *            is the type of the potential referenced object. This
	 *            classifier must have a feature named after the given id
	 *            property name.
	 * @param contents
	 *            are all the potential referenced objects.
	 * 
	 * @return the resolved object, or null if no object is found.
	 */
	protected EObject resolve(String idPropertyName, Object referenceValue, EClassifier type, 
			Iterable<EObject> contents) 
			throws ModelCreatingException, AmbiguousReferenceException {				
		EObject result = null;
		EClassifier classifier = type;
		for (EObject content: contents) {					
			EClass classOfNext = content.eClass();
			if (classifier instanceof EClass &&
					((EClass)classifier).isSuperTypeOf(classOfNext)) {
				for (EAttribute possibleIdAttr: classOfNext.getEAllAttributes()) {
					if (possibleIdAttr.getName().equals(idPropertyName)) {
						if (referenceValue.equals(content.eGet(possibleIdAttr))) {
							if (result == null) {
								result = content;
							} else {
								throw new AmbiguousReferenceException();
							}
						}
					}
				}
			} 
		}
		return result;
	}
	
	/**
	 * An overload for {@link this#resolve(String, Object, EClassifier, Iterable)}.
	 */
	protected EObject resolve(String idPropertyName, Object referenceValue, EClassifier type,
			Iterator<EObject> contents) throws ModelCreatingException, AmbiguousReferenceException {
		return resolve(idPropertyName, referenceValue, type, new MyIterable<EObject>(contents));
	}
	
	/**
	 * Helper to set/add a value to a property.
	 * 
	 * @param object
	 *            is the object the value should be set/added to.
	 * @param value
	 *            the value itself.
	 * @param feature
	 *            the property that the value should be set/added to.
	 */
	@SuppressWarnings("unchecked")
	protected void setValue(EObject object, Object value, EStructuralFeature feature) {		
		if (feature.isMany()) {
			((EList)((EObject)object).eGet(feature)).add(value);
		} else {
			((EObject)object).eSet(feature, value);
		}
	}
	
	protected static class MyIterable<E> implements Iterable<E> {
		private final Iterator<E> fIterator;		
		public MyIterable(Iterator<E> iterator) {
			super();
			fIterator = iterator;
		}
		@Override
		public Iterator<E> iterator() {
			return fIterator;
		}		
	}
}
