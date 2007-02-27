package hub.sam.util.trees;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public abstract class AbstractChildTree<T extends AbstractChildTree, E> extends AbstractTree<T, E> {

	private final E fElement;
	private final List<T> children = new Vector<T>();
	private T parent;
	
	public AbstractChildTree(E element) {
		fElement = element;
	}
	
	public final List<T> getChildNodes() {
		return Collections.unmodifiableList(children);
	}

	public final E getElement() {
		return fElement;
	}

	public final T getParent() {
		return parent;
	}

	public final void addChild(ITree child) {
		if (child instanceof AbstractChildTree) {
			T actChild = (T)child;
			actChild.parent = this;
			children.add(actChild);
		} else {
			throw new RuntimeException("assert");
		}
	}
	
	public final boolean removeChild(ITree child) {
		if (child instanceof AbstractChildTree) {
			T actChild = (T)child;
			actChild.parent = null;
			return children.remove(actChild);
		} else {
			throw new RuntimeException("assert");
		}
	}
}
