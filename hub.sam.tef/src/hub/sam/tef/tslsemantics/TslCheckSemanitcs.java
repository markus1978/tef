package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public class TslCheckSemanitcs implements IValueCheckSemantics {

	@Override
	public void check(ParseTreeNode parseTreeNode,
			IModelCreatingContext context, EObject value, ElementBinding binding)
			throws ModelCreatingException {
		if (value instanceof Syntax) {
			((Syntax)value).replaceExtendedRules(context);
			((Syntax)value).check(context);
		} else if (value instanceof ElementBinding) {
			checkElementBinding((ElementBinding)value, context);
		}
	}
	
	private void checkElementBinding(ElementBinding binding, IModelCreatingContext context) 
			throws ModelCreatingException {
		Rule rule = (Rule)binding.eContainer();
		
		// check the meta-class of element bindings
		if (binding.getMetaclass() == null) {
			context.addError(new ModelCheckError("Element binding without meta-class.", binding));
		} else {
			if (binding.getMetaclass().isAbstract()) {
				boolean allUsagesAreReferences = true;
				for (PropertyBinding usage: getCoveringPropertyBindings(rule, 
						(Syntax)context.getResource().getContents().get(0), 
						new HashSet<Rule>(), true)) {
					if (!(usage instanceof ReferenceBinding)) {
						allUsagesAreReferences = false;
					}
				}
				if (!allUsagesAreReferences) {
					context.addError(new ModelCheckError("Element binding with abstract meta-class that is used in composite bindings.", binding));
				}
			}
		}
		
		// check whether this binding is always used in the presents of a
		// property binding		
		if (!isCoveredByAPropertyBinding(rule, (Syntax)context.getResource().getContents().get(0), 
				new HashSet<Rule>(), true)) {
			context.addError(new ModelCheckError("Binding is not covered by a property binding", binding));
		}
	}
	
	private Collection<PropertyBinding> getCoveringPropertyBindings(Rule rule, Syntax syntax,
			Collection<Rule> visitedRules, boolean first) throws ModelCreatingException {
		Collection<PropertyBinding> result = new HashSet<PropertyBinding>();
		
		if (!first && rule.getValueBinding() != null) {
			return result;
		}
		if (visitedRules.contains(rule)) {
			return result;
		} else {
			visitedRules.add(rule);
		}
		try {
			for (Rule usingRule: syntax.getRulesForUsedNonTerminal(rule.getLhs())) {
				boolean usesSymbolWithoutPropertyBinding = false;
				for (Symbol rhsPartOfUsingRule: ((SimpleRule)usingRule).getRhs()) {
					if (rhsPartOfUsingRule instanceof NonTerminal && 
							((NonTerminal)rhsPartOfUsingRule).getName().equals(rule.getLhs().getName())) {													
						if (rhsPartOfUsingRule.getPropertyBinding() == null) {
							usesSymbolWithoutPropertyBinding = true;						
						} else {
							result.add(rhsPartOfUsingRule.getPropertyBinding());
						}
					}
				}
				if (usesSymbolWithoutPropertyBinding) {
					result.addAll(getCoveringPropertyBindings(usingRule, syntax, visitedRules, false));
				} 
			}
		} catch (TslException ex) {
			throw new ModelCreatingException(ex);
		}
		return result;
	}
	
	private boolean isCoveredByAPropertyBinding(Rule rule, Syntax syntax,
			Collection<Rule> visitedRules, boolean first) throws ModelCreatingException {
		if (!first && rule.getValueBinding() != null) {
			return false;
		}
		if (visitedRules.contains(rule)) {
			return true;
		} else {
			visitedRules.add(rule);
		}
		try {
			for (Rule usingRule: syntax.getRulesForUsedNonTerminal(rule.getLhs())) {
				boolean usesSymbolWithoutPropertyBinding = false;
				loop: for (Symbol rhsPartOfUsingRule: ((SimpleRule)usingRule).getRhs()) {
					if (rhsPartOfUsingRule instanceof NonTerminal && 
							((NonTerminal)rhsPartOfUsingRule).getName().equals(rule.getLhs().getName()) &&
							rhsPartOfUsingRule.getPropertyBinding() == null) {
						usesSymbolWithoutPropertyBinding = true;
						break loop;
					}
				}
				if (usesSymbolWithoutPropertyBinding && 
						!isCoveredByAPropertyBinding(usingRule, syntax, visitedRules, false)) {
					return false;
				}			
			}
		} catch (TslException ex) {
			throw new ModelCreatingException(ex);
		}
		return true;
	}
}
