package hub.sam.tef.reconciliation.treerepresentation;

public class PrimitiveTreeRepresentation extends ASTNode {

	private Object fPrimitive;

	public PrimitiveTreeRepresentation(Object primitive) {
		super(null);
		fPrimitive = primitive;
	}

	@Override
	public int getLength() {
		return fPrimitive.toString().length();
	}

	@Override
	public void dispose() {
		// emtpy
	}

	@Override
	public String getContent() {
		return fPrimitive.toString();
	}		
}
