package hub.sam.util.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterates like [a, b, c, A, 1, 2, I, ROOT]
 */
public class DepthFirstLeafFirstTreeIterator<T extends ITree, E> extends TreeIterator<T, E> {

	private final Map<T, Iterator<T>> siblingIterators = new HashMap<T, Iterator<T>>();
	private boolean ended = false;
	
	public DepthFirstLeafFirstTreeIterator(T tree) {		
		super(tree);	
		initializeCurrentNode();
	}
	

	@Override
	protected void initializeCurrentNode() {
		initializeCurrentNode((T)getRootNode());
	}
	
	private void initializeCurrentNode(T rootNode) {
		T iterator = rootNode;
		while(iterator.getChildNodes().size() > 0) {
			Iterator<T> siblingIterator = iterator.getChildNodes().iterator();
			siblingIterators.put(iterator, siblingIterator);
			iterator = siblingIterator.next();
		}
		setCurrentNode(iterator);
	}

	@Override
	public T next() {		
		T result = getCurrentNode();
		T parent = (T)result.getParent();
		if (parent != null) {
			Iterator<T> currentSiblingIterator = siblingIterators.get(parent);
			if (currentSiblingIterator.hasNext()) {			
				initializeCurrentNode(currentSiblingIterator.next());			
			} else {
				setCurrentNode(parent);
			}
		} else {
			ended = true;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		return !ended;
	}	
}