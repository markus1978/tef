package hub.sam.tef.modelcreating;


public final class ParseTreeValueNode extends ParseTreeNode {
	private final Object fValue;

	public ParseTreeValueNode(Object value) {
		super();
		fValue = value;
	}

	@Override
	protected String getNodeValueString() {
		return fValue.toString();
	}

	@Override
	public Object createModel(IModelCreatingContext context, Object actual)
			throws ModelCreatingException {
		return null;
	}

	@Override
	public Object resolveModel(IModelCreatingContext context,
			ResolutionState resolutionState) throws ModelCreatingException {
		return fValue;
	}	
}
