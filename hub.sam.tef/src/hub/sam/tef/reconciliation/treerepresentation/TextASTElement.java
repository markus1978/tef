package hub.sam.tef.reconciliation.treerepresentation;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.templates.Template;

public class TextASTElement implements IASTElement {

	private final Rule fRule;
	private final Template fTemplate;
	private ASTElementNode fTreeRepresentation = null;
	
	public TextASTElement(final Rule rule, final Template template) {
		super();
		fRule = rule;
		fTemplate = template;
	}
	
	public String getSymbol() {
		return getSyntaxProvider().getNonTerminal();
	}

	public ISyntaxProvider getSyntaxProvider() {
		return fTemplate.getAdapter(ISyntaxProvider.class);
	}	

	public String toString() {
		return fTemplate.getAdapter(ISyntaxProvider.class).getNonTerminal();	
	}

	public Template getTemplate() {
		return fTemplate;
	}

	public void setAST(ASTElementNode treeNode) {
		this.fTreeRepresentation = treeNode;
		
	}

	public void dispose() {
		fTreeRepresentation = null;
	}

	public boolean isActive() {
		return fTreeRepresentation != null;
	}
	
	
}
