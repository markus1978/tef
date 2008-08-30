package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * Reference resolution semantics is only used for element references. A reference
 * resolution semantics determines how reference resolution handles properties of a
 * specific type.
 */
public interface IElementReferenceResolutionSemantics {
	/**
	 * This method is used during resolution. It is supposed to resolve a given
	 * reference value and return the referenced object value.
	 * 
	 * @param parseTreeNode
	 *            is the node that represents the reference.
	 * @param actual
	 *            is the object with the property that the value will eventually
	 *            be added to.
	 * @param value
	 *            the value that describes the reference. This might be null. In
	 *            this cases the value has to be determined from the parse tree
	 *            node.
	 * @param context
	 *            the actual model creation state.
	 * @param targetClassifier
	 *            is the classifier to which the value may be resolved.
	 * @throws ModelCreatingException,
	 *             if anything goes wrong/unexpected.
	 * @throws UnresolveableReferenceErrorException,
	 *             if the reference could not be resolved. This exception has to
	 *             contain the reason.
	 * 
	 * @returns the referenced object.
	 */
	public EObject resolve(ParseTreeNode parseTreeNode, Object actual,
			Object value, IModelCreatingContext context, EClassifier targetClassifier)
			throws ModelCreatingException, UnresolveableReferenceErrorException;
}
