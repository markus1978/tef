package hub.sam.tef.parse;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

public interface ISyntaxProvider {

	
	/**
	 * Provides a unique name used as symbol during parsing.
	 */
	public String getNonTerminal();
	
	/**
	 * Provides parser rules.
	 */
	public String[][] getRules();
	
	public TextBasedAST createAST(TextBasedAST parent, IModelElement model, Text text);
	
}
