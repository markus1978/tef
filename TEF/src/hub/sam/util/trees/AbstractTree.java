package hub.sam.util.trees;

import java.util.List;


public abstract class AbstractTree<T extends AbstractTree, E> implements ITree<T, E> {

	@Override
	public boolean equals(Object obj) {
		E element = getElement();
		if (element == null) {
			return element == obj;
		} else {
			if (obj instanceof ITree) {
				return element.equals(((ITree)obj).getElement());
			} else {
				return false;
			}
		}
	}

	@Override
	public int hashCode() {
		return getElement().hashCode();
	}
	
	public  static final <T extends ITree, E extends Object> String dumpTree(T tree) {		
		final StringBuffer result = new StringBuffer();
		TreeIterator.visitTree(new DepthFirstLeafFirstTreeIterator<T, E>(tree), new ITreeVisitor<T, E>() {
			public void visit(T tree) {
				result.append(tree.toString());
				result.append(" ");
			}			
		});
		return result.toString();
	}	
	
	public T getFirstChild() {
		List<T> childNodes = getChildNodes();
		return (childNodes.size() > 0) ? childNodes.get(0) : null;		
	}
	
	public T getFirstLeaf() {
		T result = getFirstChild();
		while (result != null && result.getFirstChild() != null) {
			result = (T)result.getFirstChild();
		}
		return result;
	}
	
	public T getNextSibling() {
		T parent = getParent();
		if (parent == null) {
			return null;
		} else {
			List<T> parentsChildren = parent.getChildNodes();
			int myIndex = parentsChildren.indexOf(this);
			if (parentsChildren.size() > myIndex + 1) {
				return parentsChildren.get(myIndex + 1);
			} else {
				return null;
			}
		}
	}
	
	public T getNextSiblingsLeaf() {
		T nextSibling = getNextSibling();
		if (nextSibling == null) {
			return null;
		} else {
			T result = (T)nextSibling.getFirstLeaf();
			if (result == null) {
				return nextSibling;
			} else {
				return result;
			}
		}
	}
	
	public boolean isLeaf() {
		return getChildNodes().size() == 0;
	}
}
