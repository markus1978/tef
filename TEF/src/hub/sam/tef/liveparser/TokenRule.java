package hub.sam.tef.liveparser;

public class TokenRule extends SyntaxRule {
	private final IToken fToken;

	public TokenRule(Object symbol, final IToken token) {
		super(symbol);
		this.fToken = token;
	}

	public IToken getToken() {
		return fToken;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof TokenRule) {
			return ((TokenRule)obj).fToken.equals(fToken);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return fToken.hashCode() + super.hashCode();
	}
	
	@Override
	public String toString() {
		return getSymbol() + "->" + fToken;
	}
}
