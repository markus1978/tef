package hub.sam.tef.semantics;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An identification scheme based on a single attribute. Otherwise it works like
 * the {@link DefaultIdentificationScheme}.
 */
public class IdAttributeIdentificationScheme implements IIdentificationScheme {
	
	private String fAttributeName = null;
	private EStructuralFeature fAttribute = null;
	
	public IdAttributeIdentificationScheme(String attributeName) {
		fAttributeName = attributeName;
	}
	
	public IdAttributeIdentificationScheme(EStructuralFeature attribute) {
		fAttribute = attribute;
	}
	
	private EStructuralFeature getIdAttribute(EObject object) {
		if (fAttribute == null) {
			return object.eClass().getEStructuralFeature(fAttributeName);
		} else {
			return fAttribute;
		}
	}

	public Object[] getGlobalIdentities(Object identifier, EObject context,
			EClassifier type) {
		return new Object[] { identifier };
	}

	public Object getIdentitiy(EObject object) {
		return object.eGet(getIdAttribute(object));
	}

	public String getLocalIdentity(EObject object, EObject context) {
		Object id = getIdentitiy(object);
		if (id instanceof String) {
			return (String)id;
		} else {
			return null;
		}
	}	
}
