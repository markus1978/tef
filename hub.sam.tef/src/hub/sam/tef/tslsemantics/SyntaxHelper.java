package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

public class SyntaxHelper {

	/**
	 * Tries to find a meta-class that covers a syntax rule.
	 * 
	 * @param rule
	 *            is the rule that is analysed.
	 * @param syntax
	 *            the syntax with that rule.
	 * @param visitedRules
	 *            a collection of rules not to consider for analysis
	 * @return null or a meta-model class.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens.
	 */
	public static EClass findCorrespondingElementBinding(
			Rule rule, Syntax syntax, Collection<Rule> visitedRules) throws ModelCreatingException {
		if (visitedRules.contains(rule)) {
			return null;
		} else {
			visitedRules.add(rule);
		}
		ValueBinding valueBinding = rule.getValueBinding();
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
			for (Rule nextOwningRule: syntax.getRulesForUsedNonTerminal(rule.getLhs())) {
				EClass metaClass = findCorrespondingElementBinding(
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

}
