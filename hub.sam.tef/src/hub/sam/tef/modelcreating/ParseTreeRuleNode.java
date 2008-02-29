package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
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
import org.eclipse.emf.ecore.EReference;

public final class ParseTreeRuleNode extends ParseTreeNode {
	
	private final Rule fRule;
	private Object value = null;

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
	public Object createModel(IModelCreatingContext context, Object parentNodeValue) 
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
			
			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding instanceof ReferenceBinding) {
				continue loop;
			}
			
			Object newChildNodeValue = childNode.createModel(context, myNodeValue);			
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
			value = myNodeValue;
			return myNodeValue;
		} else {
			return childNodeValue;
		}
	}

	@Override
	public Object resolveModel(IModelCreatingContext context, ResolutionState resolutionState)
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
			ParseTreeNode childNode = getChildNodes().get(i++);
			if (propertyBinding != null) {
				if (propertyBinding instanceof CompositeBinding) {
					Object actual = resolutionState.getValueForBinding(propertyBinding);
					ResolutionState newState = new ResolutionState(resolutionState);
					if (actual instanceof EObject) {
						newState.setLooseActual((EObject)actual);
					}					
					childNode.resolveModel(context, newState);
				} else if (propertyBinding instanceof ReferenceBinding) {		
					ReferenceBinding referenceBinding = (ReferenceBinding)propertyBinding;
					try {
						EObject referencedObject = context.getSemanticsProvider().
								getPropertyResolutionSemantics(referenceBinding).resolve(
								childNode, resolutionState.getActual(), null, 
								context, referenceBinding);
						context.addResolution(new IModelCreatingContext.Resolution(
								(EObject)resolutionState.getActual(), 
								referencedObject,
								(EReference)referenceBinding.getProperty()));
						context.addOccurence(referencedObject, childNode.getPosition()); 
					} catch (UnresolveableReferenceErrorException ex) {
						context.addError(ex.getError());
					}
				} else {
					throw new ModelCreatingException(new TslException("Unexpected property binding."));
				}
			} else { 
				childNode.resolveModel(context, resolutionState);
			}		
			
		}
		
		return resolutionState.getActual();
	}

	/**
	 * After {@link #createModel(IModelCreatingContext, Object)} was called for
	 * this node, the node contains the model value that was created during
	 * model creation.
	 * 
	 * @return the model value that was created for this node, if the nodes rule
	 *         contained a value binding.
	 */
	public Object getValue() {
		return value;
	}
	
	
}
