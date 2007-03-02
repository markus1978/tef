package hub.sam.tef.parse;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import hub.sam.util.trees.AbstractChildTree;

public abstract class AST<TreeType extends AST, ElementType> 
		extends AbstractChildTree<TreeType, ElementType> {

	private final String symbol;
	private final Map<String, String> stringValuesForProperties = new HashMap<String, String>();
	
	public AST(ElementType element, String symbol) {
		super(element);
		this.symbol = symbol;
	}

	public void print(PrintStream out) {
		print(out, 0);
	}
	
	private void print(PrintStream out, int depth) {
		for (int i = 0; i < depth; i++) {
			out.print(" ");
		}
		out.println(toString());
		for (AST child: getChildNodes()) {
			child.print(out, depth +3);
		}
	}


	public String getSymbol() {
		return symbol;
	}
	
	public List<String> getChildSymbols() {
		List<String> result = new Vector<String>();
		for (AST child: getChildNodes()) {
			result.add(child.getSymbol());
		}
		return result;
	}	
	
	
	public String getStringValueForProperty(String property) {
		return stringValuesForProperties.get(property);
	}
	
	protected void putStringValueForProperty(String property, String value) {
		stringValuesForProperties.put(property, value);
	}
	
	protected Collection<String> getProperties() {
		return stringValuesForProperties.keySet();
	}
	

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("");	
		for (String property: getProperties()) {
			result.append(" " + property + ":" + getStringValueForProperty(property));
		}
		return result.toString();
	}
	
}
