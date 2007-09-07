package hub.sam.tef.reconciliation.syntax;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;

public interface IElementSyntaxProvider extends ISyntaxProvider {
	/**
	 * Returns the property that is referred to by the position-thd element in the rule.
	 */
	public String getPropertyForRuleAndPosition(Rule rule, int position);
	
}
