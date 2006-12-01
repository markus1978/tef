package hub.sam.tef.liveparser;

public class ASTNode {
	private final SyntaxRule fRule;
	
	public ASTNode(final SyntaxRule rule) {
		super();
		fRule = rule;
	}
	
	protected SyntaxRule getRule() {
		return fRule;
	}

	public Object getSymbol() {
		return fRule.getSymbol();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SymbolASTNode) {
			return getSymbol().equals(((SymbolASTNode)obj).getSymbol());
		} else {
			return getSymbol().equals(obj);
		}
	}

	@Override
	public int hashCode() {
		return getSymbol().hashCode();
	}	
}
