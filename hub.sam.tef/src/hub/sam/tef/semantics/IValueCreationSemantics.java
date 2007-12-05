package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.tsl.ValueBinding;

/**
 * Values can be model-objects (element values) or other values (primitive
 * values). A value creation semantics determines how model creation handles values 
 * of a specific type.
 */
public interface IValueCreationSemantics {
	
	/**
	 * This method is used during model creation to create model-values from
	 * tree nodes.
	 * 
	 * @param parseTreeNode
	 *            determines the parse tree node.
	 * @param context
	 *            is the actual model creating state.
	 * @param binding
	 *            gives the binding that this semantics is attached to. This
	 *            binding is attached to the rule used to create the given
	 *            parse-tree node during parsing.
	 * @return the created model-value.
	 * @throws ModelCreatingException
	 *             if anything goes wrong/unexpected.
	 */
	public Object createValue(ParseTreeNode parseTreeNode, IModelCreatingContext context,
			ValueBinding binding) throws ModelCreatingException;
}
