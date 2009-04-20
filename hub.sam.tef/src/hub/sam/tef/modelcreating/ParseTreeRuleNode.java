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

package hub.sam.tef.modelcreating;

import hub.sam.tef.modelcreating.IModelCreatingContext.ActionStatementEvaluationTime;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementReferenceBinding;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Statement;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tsl.WhiteSpace;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Traverse the syntax tree and build a model based on the grammar rules,
 * annotations and statements. Model construction happens in two passes: first
 * the model elements are created by a recursive execution of
 * <code>{@link #createModel(IModelCreatingContext, Object)}</code> then
 * references are resolved and non-local model changes are performed by a
 * recursive execution of
 * <code>{@link #resolveModel(IModelCreatingContext, ResolutionState)}</code>
 * 
 * @author Markus Scheidgen
 * @author Dirk Fahland
 */
public final class ParseTreeRuleNode extends ParseTreeNode {

	private final Rule fRule;
	private Object value = null;
	private Object[] childValues;
	private boolean[] childValuesUsed;

	public ParseTreeRuleNode(Rule rule) {
		super();
		fRule = rule;

		// has a right hand side, allow each RHS node to have a value
		if (rule instanceof SimpleRule) {
			childValues = new Object[((SimpleRule) rule).getRhs().size()];
			childValuesUsed = new boolean[childValues.length];
			for (int i = 0; i < childValuesUsed.length; i++)
				childValuesUsed[i] = false;
		}
	}

	public Rule getRule() {
		return fRule;
	}

	@Override
	protected String getNodeValueString() {
		return fRule.toString();
	}

	/**
	 * traverse the abstract syntax tree and build the model based on the
	 * grammar rule annotations
	 * 
	 * @param context
	 *            stores the current knowledge about the model creation
	 * @param parentNodeValue
	 *            value created at the parent node
	 * @return value created (or inherited) at this node
	 * 
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	@Override
	public Object createModel(IModelCreatingContext context,
			Object parentNodeValue) throws ModelCreatingException {
		ValueBinding valueBinding = fRule.getValueBinding();

		Object myNodeValue = null;
		if (valueBinding != null) {
			// the node has a value binding, create a new value based on the
			// binding
			myNodeValue = context.getSemanticsProvider()
					.getValueCreationSemanitcs(valueBinding).createValue(this,
							context, valueBinding);
		} else {
			// the node inherits the value from its parent
			myNodeValue = parentNodeValue;
		}

		if (!(fRule instanceof SimpleRule))
			throw new ModelCreatingException(
					"ERROR: trying to create a model based on a rule with no right-hand side: "
							+ fRule);

		SimpleRule ruleRhs = (SimpleRule) fRule;

		// System.err.println("rule size: "+ruleRhs.getRhs().size()+", array
		// size: "+)
		// evaluate the right hand side of the rule, symbol by symbol
		int indexNonWhiteSpace = 0; // number of nonWhiteSpace-node
		loop: for (int currentRhsPart = 0; currentRhsPart < ruleRhs.getRhs()
				.size(); currentRhsPart++) {
			Symbol rhsPart = ruleRhs.getRhs().get(currentRhsPart);

			if (rhsPart instanceof WhiteSpace) { // skip white spaces
				continue loop;
			}

			// get current child from the parse tree
			ParseTreeNode childNode = getChildNodes().get(indexNonWhiteSpace);
			indexNonWhiteSpace++; // update designated index

			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding instanceof ReferenceBinding) {
				try {
					childNode.setAdditionalValue(childNode.createModel(context,
							myNodeValue));
				} catch (ModelCreatingException ex) {
					// FIXME this is ok, because usually we don't need this. And
					// if needed
					// the user should know.
					// Maybe its better if the user could say that he needs it
					// explicitely.
					// BTW, I have no idea why it is not always working.
				}
				// skip reference binding
			} else {
				// is a composite binding: descend the tree and create
				// further elements
				// store value as the current value of this symbol, the
				// value will be used in resolveModel()
				childValues[currentRhsPart] = childNode.createModel(context,
						myNodeValue);
				if (childValues[currentRhsPart] != null
						&& propertyBinding != null
						&& propertyBinding instanceof CompositeBinding) {
					// bind newly created element based on the composite binding
					CompositeBinding compositeBinding = (CompositeBinding) propertyBinding;
					context.getSemanticsProvider()
							.getPropertyCreationSemantics(compositeBinding)
							.addValue(childNode, myNodeValue,
									childValues[currentRhsPart], context,
									compositeBinding);
					// the value is bound
					childValuesUsed[currentRhsPart] = true;
				}
			}
			// check whether statements of the current rule are sound and
			// mark referenced child values as used
			if (rhsPart.getActionBinding() != null
					&& rhsPart.getActionBinding().getStatements() != null) {
				checkActionStatement(currentRhsPart);					
			}
		}

		// check unbound values:
		// remember the first unbound child node value, it will be passed
		// and stored as this node's value unless there is another value
		// binding
		Object unboundValue = null; // the only unbound child node value
		int unboundIndex = -1;
		for (int valueIndex = 0; valueIndex < childValues.length; valueIndex++) {
			if (childValues[valueIndex] != null && !childValuesUsed[valueIndex]) {
				if (unboundValue == null) { // child node value is unset
					unboundValue = childValues[valueIndex];
					unboundIndex = valueIndex;
				} else { // two child node values
					String errorMsg = "Multiple unbound and unused values in one rule created.";
					errorMsg += "\n" + "Rule: " + fRule + "\n" + "has value: "
							+ unboundValue + "\n"
							+ "and gets new value at node #" + valueIndex
							+ ": " + childValues[valueIndex];
					// throw new ModelCreatingException(errorMsg);
					System.err.println(errorMsg);
				}
			}
		}

		if (valueBinding != null) {
			value = myNodeValue;

			if (unboundIndex >= 0) { // this block is for error diagnosis
										// only
				String errorMsg = "Found unbound and unused value in rule that already has a return value.";
				errorMsg += "\n" + "Rule: " + fRule + "\n"
						+ "Return value of the rule: " + myNodeValue + "\n"
						+ "Unbound value at node #" + unboundValue + ": "
						+ childValues[unboundIndex];
				// throw new ModelCreatingException(errorMsg);
				System.err.println(errorMsg);
			}
		} else {
			// store the unique passed value as this node's value
			value = unboundValue;
		}
		return value;
	}
	
	/**
	 * traverse the abstract syntax tree after create and execute action statements 
	 * at create time
	 * 
	 * @param context
	 *            stores the current knowledge about the model creation
	 * @param parentNodeValue
	 *            value created at the parent node
	 * 
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen
	 */
	public void postCreate(IModelCreatingContext context) throws ModelCreatingException {
		SimpleRule ruleRhs = (SimpleRule) fRule;

		// System.err.println("rule size: "+ruleRhs.getRhs().size()+", array
		// size: "+)
		// evaluate the right hand side of the rule, symbol by symbol
		int indexNonWhiteSpace = 0; // number of nonWhiteSpace-node
		loop: for (int currentRhsPart = 0; currentRhsPart < ruleRhs.getRhs()
				.size(); currentRhsPart++) {
			Symbol rhsPart = ruleRhs.getRhs().get(currentRhsPart);

			if (rhsPart instanceof WhiteSpace) { // skip white spaces
				continue loop;
			}

			// get current child from the parse tree
			ParseTreeNode childNode = getChildNodes().get(indexNonWhiteSpace);
			indexNonWhiteSpace++; // update designated index

			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding instanceof ReferenceBinding) {
				// skip reference binding
			} else {
				childNode.postCreate(context);
			}
			// check whether statements of the current rule are sound and
			// mark referenced child values as used
			if (rhsPart.getActionBinding() != null
					&& rhsPart.getActionBinding().getStatements() != null) {
				evaluateActionBindings(context, currentRhsPart, rhsPart,
						ActionStatementEvaluationTime.create);	
			}
		}
	}

	/**
	 * resolve references in the model and execute statements based on the
	 * current values to complete the model, requires that
	 * <code>{@link #createModel(IModelCreatingContext, Object)}</code> has
	 * been called before on the given context
	 * 
	 * @param context
	 *            stores the available knowledge on the creation of the model
	 * @param aResolutionState
	 *            stores the most recent candidate for binding reference values
	 * 
	 * @return the value of this node after resolving all references and
	 *         executing all statements
	 * 
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	@Override
	public Object resolveModel(IModelCreatingContext context,
			ResolutionState aResolutionState) throws ModelCreatingException {

		ResolutionState resolutionState;

		ValueBinding valueBinding = fRule.getValueBinding();
		if (valueBinding != null) {
			// in case of a value binding, encapsulate the reference value
			// of this node in its own resolution state
			resolutionState = new ResolutionState(aResolutionState);
			// for element reference bindings, the loose actual is the value of
			// the rule's
			// LHS node, set this value explicitly (this should be consistent
			// with any
			// surrounding composite binding
			if (value instanceof EObject
					&& valueBinding instanceof ElementReferenceBinding)
				resolutionState.setLooseActual((EObject) value);
			if (valueBinding instanceof PrimitiveBinding
					|| valueBinding instanceof ConstantBinding)
				resolutionState.setLooseActualArbitrary(value);
			// and make the local value the candidate value for
			// reference resolutions
			resolutionState.acceptLooseActual(valueBinding);
		} else {
			resolutionState = aResolutionState;
		}

		SimpleRule ruleRhs = (SimpleRule) fRule;

		// evaluate references according to the right hand side of the node's
		// rule
		int indexNonWhiteSpace = 0; // number of nonWhiteSpace-node
		loop: for (int currentRhsPart = 0; currentRhsPart < ruleRhs.getRhs()
				.size(); currentRhsPart++) {
			Symbol rhsPart = ruleRhs.getRhs().get(currentRhsPart);

			if (rhsPart instanceof WhiteSpace) { // skip white spaces
				continue loop;
			}

			// get current child from the parse tree
			ParseTreeNode childNode = getChildNodes().get(indexNonWhiteSpace);
			indexNonWhiteSpace++; // update designated index

			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding != null) {
				if (propertyBinding instanceof CompositeBinding) {
					// in case of composite bindings, descend the
					// tree and resolve the model for the subtree
					try {
						Object actual = resolutionState
								.getValueForBinding(propertyBinding);

						ResolutionState newState = new ResolutionState(
								resolutionState);
						if (actual instanceof EObject) {
							newState.setLooseActual((EObject) actual);
						}
						childNode.resolveModel(context, newState);
						// childValue for this node has been determined already
						// in #createModel(), so do nothing here, is this
						// correct?
					} catch (NullPointerException npe) {
						System.err.println("error resolving " + propertyBinding
								+ " in rule " + fRule + " at " + rhsPart
								+ " in " + resolutionState);
						context.addError(new hub.sam.tef.semantics.Error(this
								.getPosition(), "Null-pointer exception during resolution."));
					}
				} else if (propertyBinding instanceof ReferenceBinding) {
					// in case of reference bindings resolve the current
					// candidate value based on the current context to an
					// existing model element and set the value of the
					// reference binding of this node's model element
					ReferenceBinding referenceBinding = (ReferenceBinding) propertyBinding;
					try {
						EObject referencedObject = context
								.getSemanticsProvider()
								.getPropertyResolutionSemantics(
										referenceBinding).resolve(childNode,
										resolutionState.getActual(),
										childNode.getAdditionalValue(),
										context, referenceBinding);
						context
								.addResolution(new IModelCreatingContext.Resolution(
										(EObject) resolutionState.getActual(),
										referencedObject,
										(EReference) referenceBinding
												.getProperty()));
						context.addOccurence(referencedObject, childNode
								.getPosition());

						// the resolved object is the value of this rule node
						childValues[currentRhsPart] = referencedObject;
					} catch (UnresolveableReferenceErrorException ex) {
						context.addError(ex.getError());
					} catch (ModelCreatingException mce) {
						System.err.println("error resolving " + propertyBinding
								+ " in rule " + fRule + " at " + rhsPart);
						context.addError(new hub.sam.tef.semantics.Error(this
								.getPosition(), mce.getLocalizedMessage()));
					}
				} else {
					throw new ModelCreatingException(new TslException(
							"Unexpected property binding."));
				}
			} else {
				// assume that the resolution returns the node's actual value
				childValues[currentRhsPart] = childNode.resolveModel(context,
						resolutionState);
			}			
		}

		// if the value binding is an element reference binding, the current
		// node value is not a model element, but describes a model element that
		// needs to be resolved in the model, this can only be done here, after
		// all
		// nodes of the rule have been evaluated
		if (valueBinding != null
				&& valueBinding instanceof ElementReferenceBinding) {
			ElementReferenceBinding erBinding = (ElementReferenceBinding) valueBinding;
			try {
				// is it feasible to use the object to resolve as its own
				// context?
				Object objectToResolve = resolutionState.getActual();
				Object contextObject = resolutionState.getActual();
				EObject referencedObject = context.getSemanticsProvider()
						.getElementReferenceResolutionSemantics(erBinding)
						.resolve(this, contextObject, objectToResolve, context,
								erBinding.getMetaclass());
				context.addOccurence(referencedObject, this.getPosition());
				// the resolved object is the value of this rule node
				this.value = referencedObject;
				resolutionState.setLooseActual(referencedObject);
				resolutionState.acceptLooseActual(erBinding);
			} catch (UnresolveableReferenceErrorException ex) {
				context.addError(ex.getError());
			} catch (ModelCreatingException mce) {
				System.err.println("error resolving " + erBinding + " in rule "
						+ fRule + " at " + fRule.getLhs());
				context.addError(new hub.sam.tef.semantics.Error(this
						.getPosition(), mce.getLocalizedMessage()));
			}
		}
		// get the actual value that was resolved at last
		return resolutionState.getActual();
	}

	/**
	 * traverse the abstract syntax tree after resolve and execute action statements 
	 * at resolve time
	 * 
	 * @param context
	 *            stores the current knowledge about the model creation
	 * @param parentNodeValue
	 *            value created at the parent node
	 * 
	 * @throws ModelCreatingException
	 * 
	 * @author Markus Scheidgen
	 */
	public void postResolve(IModelCreatingContext context) throws ModelCreatingException {
		SimpleRule ruleRhs = (SimpleRule) fRule;

		// System.err.println("rule size: "+ruleRhs.getRhs().size()+", array
		// size: "+)
		// evaluate the right hand side of the rule, symbol by symbol
		int indexNonWhiteSpace = 0; // number of nonWhiteSpace-node
		loop: for (int currentRhsPart = 0; currentRhsPart < ruleRhs.getRhs()
				.size(); currentRhsPart++) {
			Symbol rhsPart = ruleRhs.getRhs().get(currentRhsPart);

			if (rhsPart instanceof WhiteSpace) { // skip white spaces
				continue loop;
			}

			// get current child from the parse tree
			ParseTreeNode childNode = getChildNodes().get(indexNonWhiteSpace);
			indexNonWhiteSpace++; // update designated index

			PropertyBinding propertyBinding = rhsPart.getPropertyBinding();
			if (propertyBinding instanceof ReferenceBinding) {
				// skip reference binding
			} else {
				childNode.postResolve(context);
			}
			// check whether statements of the current rule are sound and
			// mark referenced child values as used
			if (rhsPart.getActionBinding() != null
					&& rhsPart.getActionBinding().getStatements() != null) {
				evaluateActionBindings(context, currentRhsPart, rhsPart,
						ActionStatementEvaluationTime.resolve);	
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private void evaluateActionBindings(IModelCreatingContext context,
			int currentRhsPart, Symbol rhsPart,
			ActionStatementEvaluationTime time) {
		Object nodeValue = this.value;
		ParseTreeNode node = this;
		while (node != null && nodeValue == null) {
			node = node.getParent();
			if (node instanceof ParseTreeRuleNode) {
				nodeValue = ((ParseTreeRuleNode)node).value;
			}
		}
		
		// evaluate action binding for this symbol: iterate all statements,
		// construct parameters for method calls (check validity), and
		// mark referenced values as used		
		if (rhsPart.getActionBinding() != null
				&& rhsPart.getActionBinding().getStatements() != null) {
			if (checkActionStatement(currentRhsPart)) {
				EList<Statement> statements = rhsPart.getActionBinding()
						.getStatements();
				for (Statement st : statements) {
					EList<Object> methodParameters = new BasicEList<Object>();
					// populate the parameter list by resolving indices
					// to existing child values (or this node's value)
					for (Integer parameterIndex : st.getMethodParameters()) {
						if (parameterIndex == -1)
							methodParameters.add(nodeValue);
						else
							methodParameters.add(childValues[parameterIndex]);
					}
					// parameters populated, call evaluation method
					if (time == ActionStatementEvaluationTime.resolve) {
						try {
							context.evaluateActionStatement(st.getMethodName(),
									methodParameters);
						} catch (ModelCreatingException mce) {
							context.addError(new hub.sam.tef.semantics.Error(this
									.getPosition(), mce.getLocalizedMessage()));	
						}
					}
					try {						
						context.evaluateActionStatement(st.getMethodName(),
								methodParameters, time);
					} catch (ModelCreatingException mce) {
						context.addError(new hub.sam.tef.semantics.Error(this
								.getPosition(), mce.getLocalizedMessage()));
					}
				}
			}
		}
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

	/**
	 * update this node's fields on usage of its child node values and generate
	 * error/warning messages if unused values are detected
	 * 
	 * @param currentRhsPart
	 *            index of the current rhs part (position in the rule)
	 * @return false iff an error was detected
	 * 
	 * @author Dirk Fahland
	 */
	private boolean checkActionStatement(int currentRhsPart) {
		SimpleRule ruleRhs = (SimpleRule) fRule;
		Symbol rhsPart = ruleRhs.getRhs().get(currentRhsPart);

		// evaluate action binding for this symbol: iterate all statements,
		// and check validity of parameters
		// this block is for error diagnosis only
		EList<Statement> statements = rhsPart.getActionBinding()
				.getStatements();
		try {
			for (Statement st : statements) {
				// check use of parameters
				for (Integer parameterIndex : st.getMethodParameters()) {
					if (parameterIndex > currentRhsPart) {
						String symbolName;

						if (parameterIndex >= ruleRhs.getRhs().size())
							symbolName = "undefined symbol $" + parameterIndex;
						else
							symbolName = "symbol '"
									+ ruleRhs.getRhs().get(parameterIndex)
									+ "'";

						String errorMsg = "Tried to access undefined Parse Tree Node value of "
								+ symbolName
								+ " at symbol '"
								+ rhsPart
								+ "' in rule: " + fRule;
						errorMsg += "\n"
								+ "skipping all method calls at symbol '"
								+ rhsPart + "', starting at call '"
								+ st.getMethodName() + "'";
						throw new ModelCreatingException(errorMsg);
					}
					if (parameterIndex != -1) // value is used
						childValuesUsed[parameterIndex] = true;
				}
			}
		} catch (ModelCreatingException e) {
			// error in statement evaluation, catch and continue in the rule
			System.err.println(e.getLocalizedMessage());
			return false;
		}
		return true;
	}
}
