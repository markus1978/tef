package hub.sam.tef.reconciliation.treerepresentation;

import java.util.Collections;
import java.util.List;

import hub.sam.util.container.IDisposable;
import hub.sam.util.trees.AbstractTree;

public abstract class ASTNode extends AbstractTree<ASTNode, IASTElement> {
	
	protected ASTElementNode parent = null;
	protected ASTNode previous = null;
	
	private IASTElement fElement;	
	
	protected ASTNode(final IASTElement contents) {
		super();
		this.fElement = contents;
	}
	
	public final ASTElementNode getParent() {
		return parent;
	}

	public List<? extends ASTNode> getChildNodes() {
		return Collections.EMPTY_LIST;
	}

	public final IASTElement getElement() {
		return fElement;
	}
	
	public final void setElement(IASTElement contents) {
		if (fElement != null && fElement instanceof IDisposable) {
			((IDisposable)fElement).dispose();
		}
		fElement = contents;
		if (this instanceof ASTElementNode) {
			contents.setAST((ASTElementNode)this);
		}
	}
	
	public abstract int getLength();
	
	public final int getOffsetWithInParent(int offset) {
		if (previous == null) {
			return offset;
		} else {
			return previous.getOffsetWithInParent(0) + previous.getLength() + offset; 
		}
	}
	
	public final int getAbsoluteOffset(int offset) {
		if (parent == null) {
			return offset;
		} else {
			return parent.getAbsoluteOffset(0) + getOffsetWithInParent(offset);
		}
	}	
	
	public abstract String getContent();
	
	public abstract void dispose();
}
