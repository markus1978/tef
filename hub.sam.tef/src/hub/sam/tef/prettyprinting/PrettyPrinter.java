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

package hub.sam.tef.prettyprinting;

import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.UnknownWhitespaceRole;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.semantics.IDefaultValuePrintSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PatternTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tsl.WhiteSpace;

import org.eclipse.emf.ecore.EObject;

/**
 * A pretty printer created a string from a model a syntax.
 */
public class PrettyPrinter {
	
	private final Syntax fSyntax;	
	private AbstractLayoutManager layout = null;
	private final ISemanticsProvider fSemanticsProvider;

	/**
	 * @param syntax
	 *            a syntax for the models that will be printed with this
	 *            printer.
	 * @param valueSemantics
	 *            a semantics registry used to determine the print semantics of
	 *            primitive values.
	 */
	public PrettyPrinter(Syntax syntax, ISemanticsProvider semanticsProvider) {
		super();
		fSyntax = syntax;
		fSemanticsProvider = semanticsProvider;
	}
	
	/**
	 * Pretty prints the given object.
	 * 
	 * @param root
	 *            the object to be printed (of course, depending on the syntax
	 *            all contained objects will also be printed)
	 * @return a pretty print state that contains the printed content.
	 * @throws ModelCreatingException, if anything unexpected happens.
	 */
	public PrettyPrintState print(EObject root) throws ModelCreatingException {
		layout.setup();
		PrettyPrintState state = new PrettyPrintState(root);
		if (!print(fSyntax.getStart(), state)) {
			throw new ModelCreatingException("Object is not pretty printable with the used syntax.");
		} else {
			return state;
		}
	}
	
	/**
	 * Pretty prints the model object given through a pretty print state using a
	 * non terminal as syntactical description for this kind of model element.<br/>
	 * 
	 * The syntax description and the meta-model of the given object must not
	 * necessarily fit to each other. In this non fitting cases this method
	 * returns false. The pretty print state given to this method should be
	 * invalidated, because the method might have printed something wrong into
	 * the state.
	 * 
	 * This method tries all rules with the given non terminal as left hand side
	 * symbol ordered by priority. The first rule that allows printing the
	 * object, finally prints the object. If non of the rules allows printing,
	 * false is returned.
	 * 
	 * @param nonTerminal
	 *            is a non-terminal that represents the syntax used for the
	 *            model element to print.
	 * @param state
	 *            a pretty print state that contains the model element to be
	 *            printed as actual object. Anything printed by this method is
	 *            appended to the state.
	 * @return true, if the model object could be printed.
	 * @throws ModelCreatingException, if anything unexpected happens.
	 */
	public boolean print(NonTerminal nonTerminal, PrettyPrintState state) throws ModelCreatingException {
		try {
			for (Rule continuation: fSyntax.getRulesForNonTerminal(nonTerminal)) {
				ValueBinding valueBinding = continuation.getValueBinding();
				if (valueBinding != null && valueBinding instanceof ElementBinding &&
						!state.fitsBinding(valueBinding)) {
					return false;							
				} 
				PrettyPrintState nextState = new PrettyPrintState(state);
				boolean successful = print(continuation, nextState, false);
				if (successful) {
					state.append(nextState);
					return true;
				} 			
			}
		} catch (TslException e) {
			throw new ModelCreatingException(e);
		}
		return false;
	}
	
	/**
	 * Prints the object given through a pretty print state using a rule as
	 * syntactical description for this kind of model element.<br/>
	 * 
	 * The same restrictions and behaviour as in
	 * {@link this#print(NonTerminal, PrettyPrintState)}.
	 * @throws ModelCreatingException, if anything unexpected happens.
	 */
	public boolean print(Rule rule, PrettyPrintState state, boolean force)  throws ModelCreatingException {
		ValueBinding valueBinding = rule.getValueBinding();
		if (valueBinding != null && !force) {
			// try the semantics to print the actual value
			IValuePrintSemantics semantics = fSemanticsProvider.getValuePrintSemantics(valueBinding);
			if (semantics != null) {
				PrettyPrintState continuationState = new PrettyPrintState(state);
				boolean success = semantics.printValue(state.getActual(), valueBinding, 
						continuationState, this);
				if (success) {
					state.append(continuationState);
					return true;
				} else {
					if (valueBinding instanceof ConstantBinding) {
						return false; // TODO very very bad design. This is just a hack, because sometimes
						// the used prettyprint model requires to continue with this grammar rules, but in
						// case of constants its wrong to continue.
					}
				}
			}
		}
		loop: for (Symbol rhsPart: ((SimpleRule)rule).getRhs()) {
			if (rhsPart instanceof NonTerminal) {
				PropertyBinding propertyBinding = rhsPart.getPropertyBinding();			 			
				PrettyPrintState continuationState = null;
				if (propertyBinding != null) {
					if (!state.hasValueForBinding(propertyBinding)) {						
						return false;
					} else {					
						Object valueForBinding = state.getValueForBinding(propertyBinding);
						if (valueForBinding == null) {
							IDefaultValuePrintSemantics semantics =
								fSemanticsProvider.getDefaultValuePrintSemantics(propertyBinding);
							if (semantics != null) {
								continuationState = new PrettyPrintState(state);
								boolean success = semantics.printDefaultValue(
										state.getActual(), propertyBinding, continuationState);
								if (success) {
									state.append(continuationState);
									continue loop;
								}			
							}
							return false;
						} else {
							continuationState = new PrettyPrintState(valueForBinding);
						}
					}
				} else {
					continuationState = new PrettyPrintState(state);
				}
				boolean successful = print((NonTerminal)rhsPart, continuationState);
				if (!successful) {
					return false;
				} else {					
					state.append(continuationState);					
				}
			} else if (rhsPart instanceof FixTerminal) {				
				state.append(((FixTerminal)rhsPart).getTerminal());				
			} else if (rhsPart instanceof PatternTerminal) {		
				// this should not be reached since the semantics of rules containing
				// patterns should provide semantics that print the value so the pretty
				// printer does not has to print primitive values
				throw new ModelCreatingException(
						new TslException("Pattern rule without value semanitcs."));								
			} else if (rhsPart instanceof WhiteSpace) {
				String role = ((WhiteSpace)rhsPart).getRole();
				try {
					state.append(layout.getSpace(role));
				} catch (UnknownWhitespaceRole ex) {
					throw new ModelCreatingException(ex);
				}
			}			
		}
		return true;
	}
	
	/**
	 * Sets the layout manager used by this pretty printer to print
	 * white-spaces.
	 */
	public void setLayout(AbstractLayoutManager layout) {
		this.layout = layout;
	}

	/**
	 * @return layout manager of this pretty printer, required
	 * for inheriting PrettyPrinter implementations
	 * @author Dirk Fahland
	 */
	protected AbstractLayoutManager getLayoutManager () {
		return layout;
	}
}
