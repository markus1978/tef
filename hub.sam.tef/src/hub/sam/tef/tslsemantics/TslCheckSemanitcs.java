/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.ActionBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ElementReferenceBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Statement;
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
import org.eclipse.emf.ecore.EReference;

/**
 * check the structure of a TSL grammar to identify errors
 * 
 * @author Markus Scheidgen
 * @author Dirk Fahland
 *
 */
public class TslCheckSemanitcs implements IValueCheckSemantics {

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
	
	/**
	 * @param binding
	 * @param context
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	private void checkElementBinding(ElementBinding binding, IModelCreatingContext context) 
			throws ModelCreatingException {
		Rule rule = (Rule)binding.eContainer();
		
		// check the meta-class of element bindings
		if (binding.getMetaclass() == null) {
			context.addError(new ModelCheckError("Element binding without meta-class.", binding));
		} else {
			if (binding.getMetaclass().isAbstract() || binding instanceof ElementReferenceBinding)
			{
				boolean allUsagesAreReferences = true;
				for (PropertyBinding usage: getCoveringPropertyBindings(rule, 
						(Syntax)context.getResource().getContents().get(0), 
						new HashSet<Rule>(), true))
				{
					if (!(usage instanceof ReferenceBinding)) {
						allUsagesAreReferences = false;
					}
				}
				if (binding.getMetaclass().isAbstract() && !allUsagesAreReferences) {
					context.addError(new ModelCheckError("Element binding with abstract meta-class that is used in composite bindings.", binding));
				}
				if (binding instanceof ElementReferenceBinding && !allUsagesAreReferences) {
					context.addError(new ModelCheckError("Element reference binding that is used in composite bindings.\n Use element binding and covering referencing binding instead.", binding));
				}
			}
		}
		

		// check whether this binding is always used in the presence of a
		// property binding		
		if (!isCoveredByAPropertyBinding(rule, (Syntax)context.getResource().getContents().get(0), 
				new HashSet<Rule>(), true))
		{
			context.addError(new ModelCheckError("Binding is not covered by a property binding", binding));
		}
	}
	
	private void checkPropertyBinding(PropertyBinding binding, IModelCreatingContext context) 
			throws ModelCreatingException {
		// Type checking is only performed for composite, for references it is 
		// type checking is the responsibility of name resolution.
		if (binding instanceof ReferenceBinding) {			
			return;
		}
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
			loop: for (Rule rule: getRulesWithValueBinding(symbol, 
					new ArrayList<Rule>(), new HashSet<Symbol>(), syntax)) {
				boolean typesDontMatch = false;
				ValueBinding valueBinding = rule.getValueBinding();
				if (valueBinding instanceof ElementBinding) {
					if (valueBinding instanceof ElementReferenceBinding) {
						// FIXME
					}
					if (propertyType instanceof EClass) {
						EClass metaclass = ((ElementBinding)valueBinding).getMetaclass();
						if (metaclass == null) {
							continue loop;
						}
						if (!((EClass)propertyType).isSuperTypeOf(
								metaclass)) {
							typesDontMatch = true;
							valueType = metaclass.getName();
						}						
					}					
				} else if (valueBinding instanceof PrimitiveBinding) {
					// FIXME
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
		
		if (binding.getProperty() instanceof EReference && 
				!((EReference)binding.getProperty()).isContainment()) {
			ActionBinding actionBinding = ((Symbol)binding.eContainer()).getActionBinding();
			if (   !(actionBinding != null && actionBinding.getStatements().size() > 0)
					// a composite binding is illegal on a reference binding property only
					// if it refers to a ElementReferenceBinding
					&& symbolReferencesElement(symbol, syntax) )
			{
				context.addError(new ModelCheckError(
						"The property given in that composite binding is not a composite property.", binding));	
			}
			
		}				
	}
	
	/**
	 * Check the current syntax whether the given symbol can be resolved to an object
	 * reference.
	 * @param symbol	non-terminal symbol to check resolution capabilities
	 * @param syntax  syntax containing the rules
	 * @return true iff there exists a rule that resolves the symbol to a reference binding
	 * @throws TslException
	 */
	private boolean symbolReferencesElement(NonTerminal symbol, Syntax syntax) {
		try {
			Collection<Rule> rules = getRulesWithValueBinding(symbol, new ArrayList<Rule>(), new HashSet<Symbol>(), syntax);
			for (Rule rule : rules) {
				if (rule.getValueBinding() instanceof ElementReferenceBinding)
					return true;
			}
			return false;
		} catch (TslException e) {
			return true;
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
	
	/**
	 * check whether a given rule is covered by a property binding
	 * this check helps to identify element creations that are not bound by
	 * a composite binding or reference binding or action statement
	 * 
	 * @param rule the rule that shall be covered
	 * @param syntax the syntax definition that contains the rule
	 * @param visitedRules rules that have been visited in the (recursive) check
	 * @param first whether this is the first call in the recursion
	 * @return true iff rule is covered by a property binding or statement
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen,
	 * @author Dirk Fahland
	 */
	private boolean isCoveredByAPropertyBinding(Rule rule, Syntax syntax,
			Collection<Rule> visitedRules, boolean first) throws ModelCreatingException
	{
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
				SimpleRule usingRule_s = (SimpleRule)usingRule;
				int usesSymbolWithoutPropertyBinding = 0;
				boolean symbolWithoutPropertyBinding[] = new boolean[usingRule_s.getRhs().size()];
				
				for (int i_rhs = 0; i_rhs < usingRule_s.getRhs().size(); i_rhs++)
				{
					Symbol rhsPartOfUsingRule = usingRule_s.getRhs().get(i_rhs);
					if (rhsPartOfUsingRule instanceof NonTerminal
						&& ((NonTerminal)rhsPartOfUsingRule).getName().equals(rule.getLhs().getName()))
					{
						// the current symbol descends to the created element we
						// are checking for
						if (rhsPartOfUsingRule.getPropertyBinding() == null) {
							usesSymbolWithoutPropertyBinding++;
							symbolWithoutPropertyBinding[i_rhs] = true;
						}
					}
				}
				
				if (usesSymbolWithoutPropertyBinding > 0) {
					// not covered, check remaining action binding
					// statements of this rule
					for (int i_rhs = 0; i_rhs < usingRule_s.getRhs().size(); i_rhs++)
					{
						Symbol rhsPartOfUsingRule = usingRule_s.getRhs().get(i_rhs);
						if (rhsPartOfUsingRule.getActionBinding() != null) {
							ActionBinding actionBinding = rhsPartOfUsingRule.getActionBinding();
							for (Statement st : actionBinding.getStatements()) {
								for (Integer parameterIndex : st.getMethodParameters()) {
									// found: the referencing symbol that has no property binding
									// is used in the statement, so the value is bound
									if (symbolWithoutPropertyBinding[parameterIndex])
									{
										usesSymbolWithoutPropertyBinding--;
										symbolWithoutPropertyBinding[parameterIndex]= false;
									}
								}
							}
						}
					}
				}
				
				// there is still a symbol in this rule that causes the creation
				// of the value of concern but does not bind it, so check whether
				// this rule is covered
				if (usesSymbolWithoutPropertyBinding > 0 && 
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
