package hub.sam.tef.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

public class EObjectHelper {
	
	/**
	 * @return an attribute of the given object that is highly
	 * probable to contain a local id for the given object. Local
	 * id means that it only identifies this object within its container.
	 * 
	 * the id attribute is either the id attribute of the objects class
	 * (in this case it has to be a global id attribute); an attribute
	 * called name, or any other non many string valued attribute that is
	 * set.
	 * 
	 * If no such attribute can be found, null is returned.
	 */
	public static EAttribute getIdAttribute(EObject object) {
		EClass eClass = object.eClass();
		
		// try the obvious: id attribute, or attribute called name
		EAttribute idAttribute = eClass.getEIDAttribute();
		if (idAttribute != null) {
			return idAttribute;
		} else {
			Object nameFeature = eClass.getEStructuralFeature("name");
			if (nameFeature != null && nameFeature instanceof EAttribute) {
				return (EAttribute)nameFeature;
			}
		}
		
		// try to find a single valued string attribute
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isMany() && 
					attribute.getEType().equals(
					EcorePackage.eINSTANCE.getEString())) {
				if (object.eIsSet(attribute)) {
					return attribute;
				}
			}
		}
		return null;
	}
	
	/**
	 * @return Returns a highly probable local id of the given object. Local
	 *         means that this id might only identify the object within its
	 *         container. If no attribute id can be found for the object, its
	 *         class is used as id.
	 */
	public static Object getLocalId(EObject object) {
		EAttribute idAttribute = getIdAttribute(object);
		Object idValue = null;
		if (idAttribute != null) {
			idValue = object.eGet(idAttribute);
		} else {
			idValue = object.eClass();
		}
		return idValue;
	}
	
	/**
	 * @return a highly probably global id for the given object. Uses
	 *         {@link #getLocalId(EObject), #getIdAttribute(EObject)}.
	 *         TODO unused???
	 */
	public static List<Object> getFullQuallifiedId(EObject object) {
		List<Object> result = new ArrayList<Object>();
		appendId(object, result);
		return result;
	}
	
	/**
	 * Helper for {@link #getFullQuallifiedId(EObject)}.
	 */
	private static void appendId(EObject object, List<Object> appendTo) {
		EObject container = object.eContainer();
		if (container != null) {
			appendId(container, appendTo);
		}
		appendTo.add(getLocalId(object));
	}
}
