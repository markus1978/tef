package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.tsl.CompositeBinding;

/**
 * Property creation semantics is only used for composite properties. A property
 * creation semantics determines how model creation handles properties of a
 * specific type.
 */
public interface IPropertyCreationSemantics {
	/**
	 * This method is used during model creating. It is supposed to add given
	 * value to the property of a given model object.
	 * 
	 * @param parseTreeNode
	 *            is the node that represents the value.
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
	 */
	public void addValue(ParseTreeNode parseTreeNode, Object actual,
			Object value, IModelCreatingContext context, CompositeBinding binding)
			throws ModelCreatingException;
}
