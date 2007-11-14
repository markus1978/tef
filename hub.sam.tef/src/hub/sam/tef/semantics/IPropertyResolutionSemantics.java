package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.tsl.ReferenceBinding;

/**
 * Property creation semantics is only used for reference properties. A property
 * creation semantics determines how reference resolution handles properties of a
 * specific type.
 */
public interface IPropertyResolutionSemantics {
	/**
	 * This method is used during resolution. It is supposed to resolve a given
	 * reference value and add the actual object value to a given property of a
	 * given model object.
	 * 
	 * @param parseTreeNode
	 *            is the node that represents the reference.
	 * @param actual
	 *            is the object with the property that the value should be added
	 *            to.
	 * @param value
	 *            the value. This might be null. In this cases the value has to
	 *            be determined from the parse tree node.
	 * @param conext
	 *            the actual model creation state.
	 * @param binding
	 *            is the binding that this semantics is attached to. This
	 *            binding is also the binding attached to the right-hand-side
	 *            symbol that caused parsing of the given tree-node.
	 * @throws ModelCreatingException,
	 *             if anything goes wrong/unexpected.
	 * @returns an {@link UnresolvableReferenceError}, if the reference could
	 *          not be resolved. This exception has to contain the reason.
	 */
	public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode, Object actual,
			Object value, ModelCreatingContext context, ReferenceBinding binding)
			throws ModelCreatingException;
}
