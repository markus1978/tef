package hub.sam.tef.liveparser;

public class ValueToken implements IToken {

	private final String fValue;
	private final IToken fDefinition;
		
	public ValueToken(final IToken definition, final String value) {
		super();
		fValue = value;
		fDefinition = definition;
	}

	public boolean isPrefix(String string) {
		return fDefinition.isPrefix(string);
	}

	public String match(String string) {
		return fDefinition.match(string);
	}	
	
	public String getValue() {
		return fValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ValueToken) {
			return ((ValueToken)obj).fDefinition.equals(fDefinition); 
		} else {
			return fDefinition.equals(obj);
		}
	}

	@Override
	public int hashCode() {
		return fDefinition.hashCode();
	}

	@Override
	public String toString() {
		return fDefinition.toString();
	}	
}
