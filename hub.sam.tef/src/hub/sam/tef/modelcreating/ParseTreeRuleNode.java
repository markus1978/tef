package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tsl.WhiteSpace;

import org.eclipse.emf.ecore.EObject;

public final class ParseTreeRuleNode extends ParseTreeNode {
	
	private final Rule fRule;

	public ParseTreeRuleNode(Rule rule) {
		super();
		fRule = rule;
	}
	
	public Rule getRule() {
		return fRule;
	}

	@Override
	protected String getNodeValueString() {
		return fRule.toString();
	}	

	@Override
	public Object createModel(ModelCreatingContext context, Object parentNodeValue) 
			throws ModelCreatingException {
		ValueBinding valueBinding = fRule.getValueBinding();
				
		Object myNodeValue = null;
		if (valueBinding != null) {
			myNodeValue = context.getSemanticsProvider().getValueCreationSemanitcs(valueBinding).
					createValue(this, context, valueBinding);
		} else {
			myNodeValue = parentNodeValue;
		}
			
		int i = 0;
		Object childNodeValue = null;
		loop: for (Symbol rhsPart: ((SimpleRule)fRule).getRhs()) {
			if (rhsPart instanceof WhiteSpace) {
				continue loop;
			}
			ParseTreeNode childNode = getChildNodes().get(i++);
			Object newChildNodeValue = childNode.createModel(context, myNodeValue);
			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (newChildNodeValue != null &&
					propertyBinding != null && 
					propertyBinding instanceof CompositeBinding) {				
				CompositeBinding compositeBinding = (CompositeBinding)propertyBinding;
				context.getSemanticsProvider().getPropertyCreationSemantics(compositeBinding).addValue(
						childNode, myNodeValue, newChildNodeValue, context, compositeBinding);								
			} else if (newChildNodeValue != null) {
				if (childNodeValue != null) {
					throw new ModelCreatingException("Multiple unbound values in one rule created.");
				} else {
					childNodeValue = newChildNodeValue;
				}
			}
		}
		
		if (valueBinding != null) {
			return myNodeValue;
		} else {
			return childNodeValue;
		}
	}

	@Override
	public Object resolveModel(ModelCreatingContext context, ResolutionState resolutionState)
			throws ModelCreatingException {
				
		ValueBinding valueBinding = fRule.getValueBinding();
		if (valueBinding != null) {
			resolutionState.acceptLooseActual(valueBinding);
		}

		int i = 0;
		loop: for (Symbol rhsPart: ((SimpleRule)fRule).getRhs()) {
			if (rhsPart instanceof WhiteSpace) {
				continue loop;
			}
			
			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding != null) {
				if (propertyBinding instanceof CompositeBinding) {
					Object actual = resolutionState.getValueForBinding(propertyBinding);
					ResolutionState newState = new ResolutionState(resolutionState);
					if (actual instanceof EObject) {
						newState.setLooseActual((EObject)actual);
					}					
					getChildNodes().get(i++).resolveModel(context, newState);
				} else if (propertyBinding instanceof ReferenceBinding) {		
					ReferenceBinding referenceBinding = (ReferenceBinding)propertyBinding;
					UnresolvableReferenceError error = context.getSemanticsProvider().
								getPropertyResolutionSemantics(referenceBinding).resolve(
								getChildNodes().get(i++), resolutionState.getActual(), null, 
								context, referenceBinding);
					if (error != null) {
						context.addError(error);
					}
				} else {
					throw new ModelCreatingException(new TslException("Unexpected property binding."));
				}
			} else { 
				getChildNodes().get(i++).resolveModel(context, resolutionState);
			}		
			
		}
		
		return resolutionState.getActual();
	}	
}
