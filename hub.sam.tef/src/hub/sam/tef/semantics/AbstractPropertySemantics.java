package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.util.MyIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
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
	 * with the given reference value (usually a name). Returns the one object
	 * that fits these conditions or throws an {@link AmbiguousReferenceException}.
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
	public static EObject resolve(IIdentificationScheme idScheme,
			Object localId, EObject context, EClassifier type,
			Iterable<Object> contents) throws ModelCreatingException,
			AmbiguousReferenceException {
		List<EObject> result = resolveAll(idScheme, localId, context, type, contents);
		if (result.size() == 0) {
			return null;
		} else if (result.size() > 1) {
			throw new AmbiguousReferenceException();
		} else {
			return result.get(0);
		}
	}
	
	/**
	 * An overload for {@link this#resolve(String, Object, EClassifier, Iterable)}.
	 */	
	protected static EObject resolve(IIdentificationScheme idScheme, Object localId,
			EObject context, EClassifier type,
			Iterator<Object> contents) throws ModelCreatingException, AmbiguousReferenceException {
		return resolve(idScheme, localId, context, type, new MyIterable<Object>(contents));
	}
	
	/**
	 * An overload for {@link this#resolveAll(String, Object, EClassifier, Iterable)}.
	 */
	protected static List<EObject> resolveAll(IIdentificationScheme idScheme,
			Object localId, EObject context, EClassifier type,
			Iterator<Object> contents) throws ModelCreatingException {
		return resolveAll(idScheme, localId, context, type,
				new MyIterable<Object>(contents));
	}
	
	/**
	 * Helper to resolve a value based on the property type and a id property.
	 * This method goes through all the model objects in the given contents. For all
	 * model-objects that fit the type of the given property, it compared the
	 * value of the given id property (usually the name attribute of the object)
	 * with the given reference value (usually a name). Returns all object that fit these
	 * conditions.
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
	private static List<EObject> resolveAll(IIdentificationScheme idScheme, 
			Object localId, EObject context, EClassifier type, Iterable<Object> contents) throws ModelCreatingException {
		List<EObject> result = new ArrayList<EObject>();		
		EClassifier classifier = type;
		Object[] globalIds = idScheme.getGlobalIdentities(localId, context);
		for (Object notifierContent: contents) {			
			if (notifierContent instanceof EObject) {
				EObject content = (EObject)notifierContent;
				EClass classOfNext = content.eClass();
				if (classifier instanceof EClass &&
						((EClass)classifier).isSuperTypeOf(classOfNext)) {
					for(Object globalId: globalIds) {
						if (idScheme.getIdentitiy(content).equals(globalId)) {
							result.add(content);
						}
					}
				}
			}
		}
		return result;
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
}
