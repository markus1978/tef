package hub.sam.util.trees;

import java.util.List;

public interface ITree <T extends ITree, E> {
	
	public E getElement();
	
	public List<T> getChildNodes();
	
	public T getParent();
}
