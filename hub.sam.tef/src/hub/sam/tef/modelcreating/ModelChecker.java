package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ValueBinding;

import org.eclipse.emf.ecore.EObject;

/**
 * Checks a model based on {@link IValueCheckSemantics}.
 */
public class ModelChecker {
	
	/**
	 * Navigates a model based on composition and applies given value check
	 * semantics to all model elements. Eventual model check errors are added to
	 * the given context.
	 * 
	 * @param object
	 *            the object to be check. Also all content of this object will
	 *            be checked.
	 * @param context
	 *            the context for the model checking. Provides the semantics and
	 *            stores all errors.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens.
	 */
	public void checkModel(EObject object, IModelCreatingContext context)  throws ModelCreatingException {
		ParseTreeRuleNode nodeOfObject = context.getTreeNodeForObject(object);
		if (nodeOfObject == null) {
			// This only happens for objects that were not created by model creation.
			// These objects might have been implicitly created through EMF/the meta-model.
			return;
		}
		ValueBinding binding = nodeOfObject.getRule().getValueBinding();
		IValueCheckSemantics checkSemantics = context.getSemanticsProvider().
				getValueCheckSemantics((ElementBinding)binding);
		if (checkSemantics != null) {
			checkSemantics.check(nodeOfObject, context, object, (ElementBinding)binding);			
		}
		for(EObject content: object.eContents()) {		
			checkModel(content, context);
		}
	}
}
