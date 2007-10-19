package hub.sam.tef.reconciliation.syntax;

public interface ISyntaxProvider {
	
	/**
	 * Provides a unique name used as symbol during parsing.
	 */
	public String getNonTerminal();
	
	/**
	 * Provides parser rules.
	 */
	public String[][] getRules();
	
}
