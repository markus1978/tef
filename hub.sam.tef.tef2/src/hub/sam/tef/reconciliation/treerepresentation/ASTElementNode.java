package hub.sam.tef.reconciliation.treerepresentation;

import hub.sam.util.container.IDisposable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ASTElementNode extends ASTNode {
	
	private final Collection<IASTChangedListener> fListeners = new Vector<IASTChangedListener>();	
	private final List<ASTNode> fContents = new Vector<ASTNode>();
	private final Map<Object, Integer> fContentsMap = new HashMap<Object, Integer>();
	private final Map<Object, Integer> fChildrensMap = new HashMap<Object, Integer>();
	private final StringBuffer fStringContent = new StringBuffer("");	
	private final Map<Integer, RepresentationChangedListener> fChangeListeners = new 	HashMap<Integer, RepresentationChangedListener>();
	private final List<ASTElementNode> fChildren = new Vector<ASTElementNode>();
			
	private final Collection<IDisposable> fComponents = new Vector<IDisposable>();
			
	public ASTElementNode(IASTElement contents) {
		super(contents);	
		contents.setAST(this);
	}

	class RepresentationChangedListener implements IASTChangedListener {
		private final ASTElementNode node;
	
		public RepresentationChangedListener(final ASTElementNode node) {
			super();
			this.node = node;
		}

		public void contentChanged(int start, int length, String text) {
			replaceContent(start + node.getOffsetWithInParent(0), length, text);
		}		
	}
	
	public void addNodeObject(Object key, Object content) {
		if (content == null) {
			return;
		}
		ASTNode treeRepresentationContent = createTreeRepresentationContent(content);		
		
		// add conent
		int index = fContents.size();
		if (key != null) {
			fContentsMap.put(key, index);
		}		
		fContents.add(treeRepresentationContent);				
		
		if (content instanceof ASTElementNode) {
			// add listeners
			RepresentationChangedListener listener = new RepresentationChangedListener((ASTElementNode)content);
			fChangeListeners.put(index, listener);
			((ASTElementNode)content).addRepresentationChangedListener(listener);
			
			// add content as child
			if (key != null) {
				fChildrensMap.put(key, fChildren.size());
			}
			fChildren.add((ASTElementNode)content);
		}		
		
		// set parent/previous of content
		treeRepresentationContent.parent = this;
		treeRepresentationContent.previous = (fContents.size() <= 1) ? null : fContents.get(fContents.size() - 2);
		
		// add string content		
		addContent(treeRepresentationContent.getContent());
		//checkConsistency();
	}

	public void addNodeObject(Object content) {
		addNodeObject(null, content);
	}
	
	private ASTNode createTreeRepresentationContent(Object content) {
		if (content instanceof ASTNode) {
			return (ASTNode)content;
		} else {
			return new PrimitiveTreeRepresentation(content);
		}
	}	
	
	public void changeNodeObject(Object key, Object newContentAsObject) {
		//int startIndexOfOldContent = startIndexOf(key);
		int index = fContentsMap.get(key);
		ASTNode oldContent = fContents.get(index);		
		int startIndexOfOldContent = oldContent.getOffsetWithInParent(0);
		ASTNode newObject = createTreeRepresentationContent(newContentAsObject);
		fContents.set(index, newObject);
		int oldContentLength = oldContent.getLength();
		
		// dispose the old content
		newObject.parent = this;
		newObject.previous = oldContent;		
		oldContent.parent = null;
		oldContent.previous = null;
		oldContent.dispose();
		
		// replace content as child
		Integer childIndex = fChildrensMap.get(key);
		if (childIndex != null) {
			if (newContentAsObject instanceof ASTElementNode) {
				fChildren.set(childIndex, (ASTElementNode)newContentAsObject);
			} else {
				fChildren.remove(childIndex);
			}
		} else {
			if (newContentAsObject instanceof ASTElementNode) {
				throw new RuntimeException("assert");
			}
		}

		// reset the listeners
		RepresentationChangedListener listener = fChangeListeners.get(index);
		if (listener != null) {
			((ASTElementNode)oldContent).removeRepresentationChangedListener(listener);
		}
		if (newContentAsObject instanceof ASTElementNode) {
			((ASTElementNode)newContentAsObject).addRepresentationChangedListener(
					new RepresentationChangedListener((ASTElementNode)newContentAsObject));
		} else {
			fChangeListeners.remove(index);
		}		
		
		// replace the string content
		replaceContent(startIndexOfOldContent, oldContentLength, newObject.getContent());		
	}
	
	public ASTNode getNode(Object key) {
		Integer index = fContentsMap.get(key); 
		if (index == null) {
			return null;
		} else {
			return fContents.get(fContentsMap.get(key));
		}
	}
	
	public void changeNodeKey(Object oldKey, Object newKey) {
		Integer index = fContentsMap.get(oldKey);
		if (index != null) {
			fContentsMap.remove(oldKey);
			fContentsMap.put(newKey, index);
		}
	}
	
	public ASTNode getNode(int offset) {
		int i = 0;
		for (ASTNode content: fContents) {
			if (offset >= i && offset < i + content.getLength()) {
				return content;
			} else {
				i += content.getLength();
			}
		}
		return null;
	}
	
	public int getLength() {
		return fStringContent.length();
	}
	
	private void replaceContent(int start, int length, String stringContent) {
		fStringContent.replace(start, start + length, stringContent);		
		//recalculateStartingIndices(contentIndex, stringContent.length() - length);		
		checkConsistency();
		fireContentChangedListener(start, length, stringContent);
	}
	
	private void addContent(String content) {
		int oldLength = getLength();
		fStringContent.append(content);
		fireContentChangedListener(oldLength, 0, content);
	}

	public String getContent() {
		return fStringContent.toString();
	}
	
	public void dispose() {
		for (IDisposable component: fComponents) {
			component.dispose();
		}
		for (RepresentationChangedListener listener: fChangeListeners.values()) {
			listener.node.removeRepresentationChangedListener(listener);
		}
		fChangeListeners.clear();
		getElement().dispose();
		for (Object content: fContents) {
			if (content instanceof ASTElementNode) {
				((ASTElementNode)content).getElement().dispose();
				((ASTElementNode)content).dispose();
			}
		}
		
		fContents.clear();
		fContentsMap.clear();
		//fStartIndexes.clear();
	}
	
	public void addRepresentationChangedListener(IASTChangedListener listener) {
		fListeners.add(listener);
	}
	
	public void removeRepresentationChangedListener(IASTChangedListener listener) {
		fListeners.remove(listener);
	}
	
	protected void fireContentChangedListener(int start, int length, String text) {
		for (IASTChangedListener listener: fListeners) {
			listener.contentChanged(start, length, text);
		}
	}
	
	public void registerComponentListener(IDisposable component) {
		fComponents.add(component);
	}
	
	public void disconnect() {
		for (IDisposable component: fComponents) {
			component.dispose();
		}
		fComponents.clear();
		for (Object content: fContents) {
			if (content instanceof ASTElementNode) {				
				((ASTElementNode)content).disconnect();
			}
		}
	}

	public List<ASTElementNode> getChildNodes() {
		return Collections.unmodifiableList(fChildren);
	}
	
	public String toString() {		
		return getElement().toString() + "[" + getContent() + "]";	
	}
	
	public boolean checkConsistency() {
		// content
		{
			StringBuffer required = new StringBuffer("");		
			for (ASTNode content: fContents) {				
					required.append(content.getContent());				
			}
			if (!required.toString().equals(getContent())) {
				throw new RuntimeException("assert");
			}
		}	
		return true;
	}
	
	
}
