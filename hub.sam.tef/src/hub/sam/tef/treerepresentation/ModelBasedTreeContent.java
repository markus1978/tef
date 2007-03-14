package hub.sam.tef.treerepresentation;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.templates.Template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ModelBasedTreeContent extends TreeContents {
	
	private final Template fTemplate;
	private final IModelElement fModel;
	
	private final List<Object> fContents = new Vector<Object>();
	private final List<Integer> fStartIndexes = new Vector<Integer>();
	private final Map<Object, Integer> fContentsMap = new HashMap<Object, Integer>();
	private final StringBuffer fStringContent = new StringBuffer("");
	
	private final Map<Integer, ContentChangedListener> fContentChangeListeners = new 	HashMap<Integer, ContentChangedListener>();
	
	class ContentChangedListener implements IContentChangedListener {
		protected final int index;		
		
		public ContentChangedListener(final int index) {
			super();
			this.index = index;
		}

		public void contentChanged(int start, int length, String text) {
			replaceStringContent(start + fStartIndexes.get(index), length, text);
		}		
	}
	
	public ModelBasedTreeContent(final Template template, final IModelElement model) {
		super();
		fTemplate = template;
		fModel = model;
	}

	@Override
	public IModelElement getModel() {
		return fModel;
	}

	@Override
	public Template getTemplate() {
		return fTemplate;
	}
	
	public void addContent(Object key, Object content) {
		int index = fContents.size();
		fContentsMap.put(key, index);
		addContent(content);
		if (content instanceof TreeContents) {
			ContentChangedListener listener = new ContentChangedListener(index);
			fContentChangeListeners.put(index, listener);
			((TreeContents)content).addContentChangedListener(listener);
		}
	}

	public void addContent(Object content) {
		fContents.add(content);
		String stringContent = stringOfContent(content);
		fStartIndexes.add(fStartIndexes.get(fStartIndexes.size() - 1) + stringContent.length());
		addStringContent(stringContent);
	}
	
	public void changeContent(Object key, Object newContent) {
		int startIndexOfOldContent = startIndexOf(key);
		int index = fContentsMap.get(key);
		Object oldContent = fContents.get(index);		
		fContents.set(index, newContent);
		int oldContentLength = lengthOfContent(oldContent);
		if (oldContent instanceof TreeContents) {			
			((TreeContents)oldContent).dispose();
		}
		int newContentLength = lengthOfContent(newContent);
		for (int i = index; i < fStartIndexes.size(); i++) {
			fStartIndexes.set(i, fStartIndexes.get(i) - oldContentLength + newContentLength);
		}

		ContentChangedListener listener = fContentChangeListeners.get(index);
		if (listener == null) {
			listener = new ContentChangedListener(index);
		} else {
			((TreeContents)oldContent).removeContentChangedListener(listener);
		}
		if (newContent instanceof TreeContents) {
			((TreeContents)newContent).addContentChangedListener(listener);
		} else {
			fContentChangeListeners.remove(index);
		}
		replaceStringContent(startIndexOfOldContent, oldContentLength, stringOfContent(newContent));		
	}
	
	public int getLength() {
		return fStringContent.length();
	}
	
	private int startIndexOf(Object key) {
		return fStartIndexes.get(fContentsMap.get(key));
	}
	
	private void replaceStringContent(int start, int length, String newContent) {
		fStringContent.replace(start, start + length, newContent);
		fireContentChangedListener(start, length, newContent);
	}
	
	private void addStringContent(String content) {
		int oldLength = getLength();
		fStringContent.append(content);
		fireContentChangedListener(oldLength, 0, content);
	}
	
	private int lengthOfContent(Object content) {
		if (content instanceof TreeContents) {
			return ((TreeContents)content).getLength();
		} else {
			return content.toString().length();
		}
	}
	
	private String stringOfContent(Object content) {
		if (content instanceof TreeContents) {
			return ((TreeContents)content).getContent();
		} else {
			return content.toString();
		}
	}

	@Override
	public String getContent() {
		return fStringContent.toString();
	}
	
	@Override
	public void dispose() {
		for (ContentChangedListener listener: fContentChangeListeners.values()) {
			((TreeContents)fContents.get(listener.index)).removeContentChangedListener(listener);
		}
		fContentChangeListeners.clear();
		for (Object content: fContents) {
			if (content instanceof TreeContents) {				
				((TreeContents)content).dispose();
			}
		}
		
		fContents.clear();
		fContentsMap.clear();
		fStartIndexes.clear();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(fTemplate.getAdapter(ISyntaxProvider.class).getNonTerminal() + " ");
		return result.toString();
	}
}
