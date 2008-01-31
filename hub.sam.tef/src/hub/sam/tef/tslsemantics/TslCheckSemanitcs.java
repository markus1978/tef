package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
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
		} else if (value instanceof PropertyBinding) {
			checkPropertyBinding((PropertyBinding)value, context);
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
	
	private void checkPropertyBinding(PropertyBinding binding, IModelCreatingContext context) 
			throws ModelCreatingException {
		Syntax syntax = (Syntax)context.getResource().getContents().get(0);
		NonTerminal symbol = (NonTerminal)binding.eContainer();
		if (binding.getProperty() == null) {
			context.addError(new ModelCheckError(
					"Binding property of this binding could not be resolved.", binding)); 
			return;
		}
		EClassifier propertyType = binding.getProperty().getEType();
		
		if (propertyType == null || propertyType.getName() == null) {
			return;
		}

		boolean oneDoesNotMatch = false;
		String valueType = null;
		try {
			for (Rule rule: getRulesWithValueBinding(symbol, 
					new ArrayList<Rule>(), new HashSet<Symbol>(), syntax)) {
				boolean typesDontMatch = false;
				ValueBinding valueBinding = rule.getValueBinding();
				if (valueBinding instanceof ElementBinding) {
					if (propertyType instanceof EClass) {
						if (!((EClass)propertyType).isSuperTypeOf(
								((ElementBinding)valueBinding).getMetaclass())) {
							typesDontMatch = true;
							valueType = ((ElementBinding)valueBinding).getMetaclass().getName();
						}
					}					
				} else if (valueBinding instanceof PrimitiveBinding) {
					// TODO
				} else if (valueBinding instanceof ConstantBinding) {
					String typeString = ((ConstantBinding)valueBinding).getType();
					if (typeString != null && !typeString.equals(propertyType.getName())) {
						typesDontMatch = true;
						valueType = typeString;
					}
				}
				oneDoesNotMatch |= typesDontMatch;
			}
		} catch (TslException ex) {
			throw new ModelCreatingException(ex);
		}
		if (oneDoesNotMatch) {
			context.addError(new ModelCheckError(
					"Binding type " + propertyType.getName() + " does not " +
							"match the value type " + valueType, binding));
		}
	}
	
	private Collection<Rule> getRulesWithValueBinding(NonTerminal symbol, 
			Collection<Rule> rules, Collection<Symbol> visistedSymbols, Syntax syntax) throws TslException {
		for (Rule rule: syntax.getRulesForNonTerminal(symbol)) {
			if (rule.getValueBinding() == null) {
				loop: for (Symbol rhsPart: ((SimpleRule)rule).getRhs()) {
					if (rhsPart instanceof NonTerminal && !visistedSymbols.contains(rhsPart)) {
						visistedSymbols.add(rhsPart);
						getRulesWithValueBinding((NonTerminal)rhsPart, rules, visistedSymbols, 
								syntax);
						break loop;
					}
				}
			} else {
				rules.add(rule);
			}
		}
		return rules;
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
