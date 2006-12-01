package hub.sam.tef.liveparser;

import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.util.Arrays;
import java.util.List;

public class SymbolRule extends SyntaxRule {
	
	private final List<Object> fSymbols;	
	private final String fMetaModelElementName;
	private final String[] fProperties;
	
	public SymbolRule(Object symbol, Object[] symbols, String metaModelElementName, String[] properties) {
		super(symbol);
		fSymbols = Arrays.asList(symbols);
		fMetaModelElementName = metaModelElementName;
		fProperties = properties;
	}
	
	protected SymbolRule(Object symbol, Object[] symbols) {
		super(symbol);
		fSymbols = Arrays.asList(symbols);
		fMetaModelElementName = null;
		fProperties = null;
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
	
	public String getMetaModelElementName() {
		return fMetaModelElementName;
	}
	
	public String[] getProperties() {
		return fProperties;
	}
}
