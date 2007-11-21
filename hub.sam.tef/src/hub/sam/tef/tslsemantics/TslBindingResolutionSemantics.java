/**
 * 
 */
package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tslsemantics.TslModelCreaatingContext.IEcoreModel;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class TslBindingResolutionSemantics extends
		AbstractPropertySemantics implements IPropertyResolutionSemantics,
		IPropertyCreationSemantics {

	/**
	 * Is bound to the platform URI for the referenced meta-model.
	 */
	@Override
	public void addValue(ParseTreeNode parseTreeNode, Object actual,
			Object value, ModelCreatingContext context,
			CompositeBinding binding) throws ModelCreatingException {
		try {
			((IEcoreModel)context.getAdapter(IEcoreModel.class)).loadModel((String)value);
		} catch (Exception ex) {
			context.addError(new Error(parseTreeNode.getPosition(), "Cannot load ecore file: " + 
					ex.getLocalizedMessage()));
		}
	}
	
	private EClass findCorrespondingElementBinding(PropertyBinding propertyBinding,
			Rule owningRule, Syntax syntax, Collection<Rule> visitedRules) throws ModelCreatingException {
		if (visitedRules.contains(owningRule)) {
			return null;
		} else {
			visitedRules.add(owningRule);
		}
		ValueBinding valueBinding = owningRule.getValueBinding();
		if (valueBinding != null) {
			if (valueBinding instanceof ElementBinding) {
				EClass metaClass = ((ElementBinding)valueBinding).getMetaclass();
				if (metaClass == null) {
					// TODO error -> cannot forward reference ...
				}
				return metaClass;
			}
		}
		try {
			for (Rule nextOwningRule: syntax.getRulesForUsedNonTerminal(owningRule.getLhs())) {
				EClass metaClass = findCorrespondingElementBinding(propertyBinding, 
						nextOwningRule, syntax, visitedRules);
				if (metaClass != null) {
					return metaClass;
				}
			}
		} catch (TslException ex) {
			throw new ModelCreatingException(ex);
		}
		return null;
	}
	
	/**
	 * Helper function that gets the rule that directly or indirectly is a
	 * container for the given object.
	 */
	private Rule getContainingRule(EObject object) {
		while (object != null) {
			if (object instanceof Rule) {
				return (Rule)object;
			} else {
				object = object.eContainer();
			}
		}
		return null;
	}

	@Override
	public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode,
			Object actual, Object value, ModelCreatingContext context,
			ReferenceBinding binding) throws ModelCreatingException {			
		String id = parseTreeNode.getNodeText();				
		EObject resolution = null;			
		if (actual instanceof PropertyBinding) {
			EClass correspondingMetaClass = findCorrespondingElementBinding(
					(PropertyBinding)actual, 
					getContainingRule((EObject)actual), 
					(Syntax)context.getContents().get(0), new HashSet<Rule>());
			if (correspondingMetaClass == null) {
				return new UnresolvableReferenceError( 
						"Cannot resolve the meta-class for the given property",
						parseTreeNode);
			}
			for (EStructuralFeature feature: 
					correspondingMetaClass.getEAllStructuralFeatures()) {
				if (feature.getName().equals(id)) {
					resolution = feature;
				} 
			}
			if (resolution == null) {
				return new UnresolvableReferenceError(
						"Class " + correspondingMetaClass.getName() + 
						" does not contain a structural feature with the given name",
						parseTreeNode);
			}
		} else {							
			try {
				resolution = resolve("name", id, binding.getProperty()
						.getEType(), context.getAdapter(IEcoreModel.class).getAllContents());
			} catch (AmbiguousReferenceException ex) {
				context.addError(new Error(parseTreeNode.getPosition(), 
						"Reference is ambiguous"));				
			}				
		}
		if (resolution != null) {
			setValue((EObject) actual, resolution, binding
					.getProperty());
			return null;
		} else {
			return new UnresolvableReferenceError(
					"Could not resolve " + id + ".", parseTreeNode);
		}			
	}
}