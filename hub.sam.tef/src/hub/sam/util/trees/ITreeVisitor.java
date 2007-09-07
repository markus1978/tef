package hub.sam.util.trees;

public interface ITreeVisitor<T extends ITree, E> {
	
	public void visit(T tree);
	
}
