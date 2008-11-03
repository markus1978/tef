package hub.sam.tef.semantics;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * The identity of a model element is a value that uniquely identifies this
 * element within a model. Each language defines a function that assigns each
 * element of a language instance an identity. Example identities can be the
 * model element itself, the name of the model element, or more complex
 * construct like a full qualified name. An identifier is a value used to
 * identify a model element based on the elements identity. In simple languages,
 * identifier can often be used directly to identify model elements: if an
 * identifier and the identity of a model element are the same, this identifier
 * identifies this model element. In many languages, however, identification is
 * more complex, including name spaces, name hiding, imports, etc. In those
 * cases, an identifier depends on the context it is used in. The language must
 * define a function that assigns a set of possible identities to an identifier
 * and its context. These derived identities are then used to find a model
 * element with one of those identities.
 * 
 * Implementing classes of this interface define a identification scheme for
 * languages, by defining two functions: one that provides the identity of model
 * elements and the other that provides identities of identifiers.
 */
public interface IIdentificationScheme {

	/**
	 * @param object
	 *            that the identity must be provided for.
	 * @return the identity of the given object.
	 */
	public Object getIdentitiy(EObject object);
	
	/**
	 * @param identifier
	 *            the local identifier that global identities must be derived
	 *            from.
	 * @param context
	 *            the context that the local identifier is used in.
	 * @param type
	 *            the type of the object that the identifier is supposed to
	 *            identify
	 * @return an array of all the global identities that the local identifier
	 *         could identify.
	 */
	public Object[] getGlobalIdentities(Object identifier, EObject context, 
			EClassifier type);
	
	/**
	 * This is used to create context assist. It only works with default content
	 * assist semantics, if local identifiers are strings.
	 * 
	 * @param object
	 *            the object that the id is determined for.
	 * @param context
	 *            the context in that the local id would identify the given
	 *            object.
	 * @return the local id, or null if this scheme does not support local
	 *         string ids for the given object.
	 */
	public String getLocalIdentity(EObject object, EObject context);
}
