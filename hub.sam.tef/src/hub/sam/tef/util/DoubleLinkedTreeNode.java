package hub.sam.tef.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class DoubleLinkedTreeNode<T extends DoubleLinkedTreeNode> {
		
	private T fParent;
	private final List<T> fChildren = new ArrayList<T>();
		
	public void addChild(T child) {
		fChildren.add(child);
		child.fParent = this;
	}
		
	public Collection<T> getChildren() {
		return Collections.unmodifiableCollection(fChildren);
	}
	
	public T getParent() {
		return fParent;
	}
	
	public void dispose() {
		for(T child: fChildren) {
			child.dispose();
		}
		fParent = null;
		fChildren.clear();
	}
	
	public boolean isLeave() {
		return fChildren.size() == 0;
	}
	
	public Collection<T> getLeaves() {
		return collectLeaves(new ArrayList<T>());
	}
	
	public void removeLastChild() {
		fChildren.remove(fChildren.size() - 1);
	}
	
	private Collection<T> collectLeaves(Collection<T> leaves) {
		if (isLeave()) {
			leaves.add((T)this);
		} else {
			for (T child: fChildren) {
				child.collectLeaves(leaves);
			}
		}
		return leaves;
	}
}
