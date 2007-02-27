package hub.sam.util.trees;

import java.util.Iterator;

public abstract class TreeIterator<T extends ITree, E> implements Iterator<T> {

	private final T rootNode;
	private T currentNode;	
	
	public TreeIterator(T tree) {
		this.rootNode = tree;
	}
		
	protected abstract void initializeCurrentNode();
	
	protected T getCurrentNode() {
		return this.currentNode;
	}
	
	protected void setCurrentNode(T tree) {
		this.currentNode = tree;
	}
	
	protected ITree getRootNode() {
		return this.rootNode;
	}
	
	public abstract boolean hasNext();
	
	public abstract T next();
	
	public static <T extends ITree, E> void visitTree(TreeIterator<T, E> iterator, ITreeVisitor<T, E> visitor) {
		while (iterator.hasNext()) {
			visitor.visit(iterator.next());
		}
	}

	public void remove() {
		throw new RuntimeException();	
	}
}
