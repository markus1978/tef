package hub.sam.tef.parse;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.util.trees.ITree;

import java.util.List;

public class TextBasedUpdatedAST extends AST<TextBasedUpdatedAST, TextBasedAST> {

	private final Template template;
	
	public TextBasedUpdatedAST(final String symbol, Template template) {
		super(null, symbol);
		this.template = template;
	}
	
	public void setReferenceToOldASTNode(TextBasedAST oldAST) {
		setElement(oldAST);
		oldAST.setReused();
	}
	
	public boolean referencesOldASTNode() {
		return getElement() != null && getElement() instanceof ITree;
	}

	@Override
	public String toString() {	
		if (referencesOldASTNode()) {
			return getElement().toString();
		} else {			
			return "%(" + getSymbol() + super.toString() + ")";
		}	
	}
	
	
	public void topDownInclusionOfOldAST(TextBasedAST oldAST) {
		if (referencesOldASTNode()) {
			return;
		}
		if (!oldAST.isReused() && oldAST.getSymbol().equals(getSymbol()) && 
				oldAST.getChildSymbols().equals(getChildSymbols())) {
			setReferenceToOldASTNode(oldAST);
			int i = 0;
			List<TextBasedAST> oldASTChildren = oldAST.getChildNodes();
			for (TextBasedUpdatedAST child: getChildNodes()) {
				child.topDownInclusionOfOldAST(oldASTChildren.get(i++));
			}
		} else {
			return;
		}
	}
	
	public void addTerminal(int position, String value, Rule rule) {
		if (template instanceof ElementTemplate) {			
			String property = ((ElementTemplate)template).getPropertyForRuleAndPosition(rule, position);
			if (property != null) {
				// otherwise it would be a terminal
				putStringValueForProperty(property, value);
			}
		} // in all other cases it must be a token
	}

}
