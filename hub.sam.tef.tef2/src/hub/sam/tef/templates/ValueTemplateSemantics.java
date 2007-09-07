package hub.sam.tef.templates;

import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;

public abstract class ValueTemplateSemantics implements ISyntaxProvider {

	private final ValueTemplate fTemplate;
	
	protected ValueTemplateSemantics(ValueTemplate template) {
		this.fTemplate = template;
	}
	
	public String getNonTerminal() {		
		return fTemplate.getType().toString();
	}
}
