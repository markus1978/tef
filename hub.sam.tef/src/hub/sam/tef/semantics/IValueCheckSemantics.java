package hub.sam.tef.semantics;

import org.eclipse.emf.ecore.EObject;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.tsl.ElementBinding;

public interface IValueCheckSemantics {

	/**
	 * Allows to check the given value and add errors to the given context.
	 * 
	 * @param parseTreeNode is the node that represents the value.
	 * @param context the creating context, can be used to add the detected errors to.
	 * @param value the value to be checked.
	 * @param binding the minding that his value was created from.
	 * 
	 * @throws ModelCreatingException, if anything unexpected happens.
	 */
	public void check(ParseTreeNode parseTreeNode, ModelCreatingContext context,
			EObject value, ElementBinding binding) throws ModelCreatingException;
}
