package hub.sam.tef.liveparser;

public class TerminalASTNode extends ASTNode {
		
	private final String fValue;	
				
	public TerminalASTNode(TokenRule rule, final String value) {
		super(rule);		
		fValue = value;
	}	

	@Override
	protected TokenRule getRule() {
		return (TokenRule)super.getRule();
	}

	public String getValue() {
		return fValue;
	}
	
	public IToken getToken() {
		return getRule().getToken();
	}
}
