package hub.sam.tef.tslsemantics;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;

import org.eclipse.emf.ecore.EObject;

public class TslCheckSemanitcs implements IValueCheckSemantics {

	@Override
	public void check(ParseTreeNode parseTreeNode,
			ModelCreatingContext context, EObject value, ElementBinding binding)
			throws ModelCreatingException {
		if (value instanceof Syntax) {
			((Syntax)value).check(context);
		} else if (value instanceof ElementBinding) {
			checkElementBinding((ElementBinding)value, context);
		}
	}
	
	private void checkElementBinding(ElementBinding binding, ModelCreatingContext context) {
		// check the meta-class of element bindings
		if (binding.getMetaclass() == null) {
			context.addError(new ModelCheckError("Element binding without meta-class.", binding));
		} else {
			if (binding.getMetaclass().isAbstract()) {
				context.addError(new ModelCheckError("Element binding with abstract meta-class.", binding));
			}
		}
		
		// check whether this binding is always used in the presents of a
		// property binding
		Rule rule = (Rule)binding.eContainer();
		if (!isCoveredByAPropertyBinding(rule, (Syntax)context.getContents().get(0), 
				new HashSet<Rule>(), true)) {
			context.addError(new ModelCheckError("Binding is not covered by a property binding", binding));
		}
	}
	
	private boolean isCoveredByAPropertyBinding(Rule rule, Syntax syntax,
			Collection<Rule> visitedRules, boolean first) {
		if (!first && rule.getValueBinding() != null) {
			return false;
		}
		if (visitedRules.contains(rule)) {
			return true;
		} else {
			visitedRules.add(rule);
		}
		for (Rule usingRule: syntax.getRulesForUsedNonTerminal(rule.getLhs())) {
			boolean usesSymbolWithoutPropertyBinding = false;
			loop: for (Symbol rhsPartOfUsingRule: usingRule.getRhs()) {
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
		return true;
	}
}
