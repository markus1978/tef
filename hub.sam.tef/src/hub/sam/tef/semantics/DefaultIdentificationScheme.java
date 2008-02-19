package hub.sam.tef.semantics;

import hub.sam.tef.util.EObjectHelper;

import org.eclipse.emf.ecore.EObject;

/**
 * A default identification scheme that relies on possible name attributes of
 * elements. It does not distinguish between global and local ids, there are not
 * namespaces or other advanced concepts.
 */
public class DefaultIdentificationScheme implements IIdentificationScheme {

	public static DefaultIdentificationScheme INSTANCE = new DefaultIdentificationScheme();
	
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context) {
		if (identifier instanceof EObject) {
			return new Object[] { EObjectHelper.getLocalId((EObject)identifier) };
		} else {
			return new Object[] {identifier};
		}
	}

	@Override
	public Object getIdentitiy(EObject object) {
		return EObjectHelper.getLocalId(object);
	}

	@Override
	public String getLocalIdentity(EObject object, EObject context) {
		return (String)getIdentitiy(object);
	}
}
