package hub.sam.tef.liveparser;

public class SyntaxRule {

	private final Object fSymbol;
	
	public SyntaxRule(Object symbol) {
		fSymbol = symbol;
	}
	
	public Object getSymbol() {
		return fSymbol;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SyntaxRule) {
			return ((SyntaxRule)obj).fSymbol.equals(fSymbol);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fSymbol.hashCode();
	}
	
}
