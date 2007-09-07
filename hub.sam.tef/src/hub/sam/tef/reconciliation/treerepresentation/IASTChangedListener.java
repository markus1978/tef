package hub.sam.tef.reconciliation.treerepresentation;

public interface IASTChangedListener {
	public void contentChanged(int start, int length, String text);
}
