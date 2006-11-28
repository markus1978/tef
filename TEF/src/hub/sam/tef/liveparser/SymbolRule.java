package hub.sam.tef.liveparser;

import java.util.Arrays;
import java.util.List;

public class SymbolRule extends SyntaxRule {
	
	private final List<Object> fSymbols;
	
	public SymbolRule(Object symbol, Object[] symbols) {
		super(symbol);
		fSymbols = Arrays.asList(symbols);
	}
	public List<Object> getSymbols() {
		return fSymbols;
	}
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof SymbolRule) {
			return ((SymbolRule)obj).fSymbols.equals(fSymbols);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return fSymbols.hashCode() + super.hashCode();
	}
	
	@Override
	public String toString() {
		return getSymbol() + "->" + fSymbols;
	}
}
