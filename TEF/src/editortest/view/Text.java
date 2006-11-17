package editortest.view;

import hub.sam.util.MultiMap;
import hub.sam.util.container.AbstractContainer;
import hub.sam.util.container.IContainer;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import editortest.controller.TextEvent;

/**
 * A Text is the representation of a String displayed in an eclipse editor. The
 * idea is to represented the hole content of a document with a set of texts.
 * The text is only shown in an editor when it is child (not necessarily a
 * direct child) of a {@link DocumentText}. A Text can be observed for status
 * changes ({@link ITextStatusListener}) which occur when the Text is hooked
 * into a DocumentText or unhooked from a DocumentText, e.g. shown and hidden in
 * a eclipse view. Text form a tree like structure ({@link CompoundText}).
 * Texts play the role of views in a model view controller pattern. Events, like
 * the user editing the text, are dispatched to the according text and can be
 * used through listeners ({@link TextEvent}, {@link TextEventListener}).
 * Changes in the contents of text can be observed too ({@link IContentChangeListener}).
 * Texts build a recursive tree structure ({@link CompoundText}) and can be
 * traversed using the visitor pattern ({@link ITextVisitor}). General
 * elements can be added, setted and retrieved from a text (@link
 * {@link IContainer}).
 */
public abstract class Text extends AbstractContainer { 
	
	private int length = 0;	
	private CompoundText container = null;
	private StringBuffer content = new StringBuffer("");
	private boolean shown = false;
	
	private final List<IContentChangeListener> fChangeListener = new Vector<IContentChangeListener>();
	private final List<ITextStatusListener> fStatusListener = new Vector<ITextStatusListener>();
	private MultiMap<Object, Object> fHandler = null;
	private Map<Object, Object> fAttachedValues = null; 
	
	public Text() {
		this.container = null;
	}
	
	/**
	 * Returns the contents of this text.
	 */
	public final String getContent(int begin, int end) {
		if (container != null) {
			return container.getContent(this, begin, end);
		} else {				
			return content.substring(begin, end);
		}
	}
	
	/**
	 * Returns the contents of this text.
	 */
	public final String getContent() {
		return getContent(0, getLength());
	}
	
	/**
	 * Changes the content of this text.
	 */
	public void changeContent(int begin, int end, String text) {
		if (container != null) {
			length = length - (end - begin) + text.length();
			container.changeContent(this, begin, end, text);			
		} else {
			content.replace(begin, end, text);
		}
		for (IContentChangeListener changeListener: fChangeListener) {
			changeListener.contentChanged(this);
		}
	}
	
	/**
	 * Returns the length of this text.
	 */
	public final int getLength() {
		if (container != null) {
			return length;
		} else {
			return content.length();
		}
	}
	
	/**
	 * Sets the container text of this text. The container is the parent node in a
	 * tree of texts. The text is only shown in an editor when it is child 
	 * (not necessarily a direct child) of a {@link DocumentText}.
	 */
	protected final void setContainer(CompoundText container) {
		this.container = container;
		if (container == null && content == null) {
			content = new StringBuffer("");
			hidden();
		} else {
			changeContent(0,0, content.toString());
			if (container != null) {
				shown();
			}
		}
		if (this.container != null) {
			content = null;
		}
	}
	
	/**
	 * Like setContainer, but the actual content of this text is not put into the container. 
	 * The container is not changed, ergo this text is not shown.
	 */
	protected final void replaceContainer(CompoundText container) {		
		if (container == null) {
			content = new StringBuffer(getContent());
			hidden();
		} else {	
			if (content != null) {
				length = content.length();
				content = null;
			}
			shown();
		}
		this.container = container;
	}
	
	/**
	 * Returns the container of this text or null if it is a root node. The container is the parent node in a
	 * tree of texts.
	 */
	public final CompoundText getContainer() {
		return container;
	}
	
	/**
	 * Lets the visitor visit this text and all its children recursivly. The
	 * given offset is handed to the visitor. It should refer to the begining of
	 * this text as 0-reference.
	 */
	public void process(ITextVisitor visitor, int atOffset) {
		visitor.visitText(this, atOffset);
	}
	
	/**
	 * Returns the absolute offset based on an offset relative to the beginning
	 * of this text. This text has a specific position in the overall document.
	 * The given offset is understood as an offset to the beginning of this text
	 * as 0-reference. The returned offset is calculated relative to the
	 * 0-position of the overall document.
	 */
	public final int getAbsolutOffset(int offset) {
		if (container == null) {
			return offset;
		} else {
			return container.getAbsolutOffset(0) + container.getBeginOf(this) + offset;
		}
	}

	/**
	 * Adds a listener that is informed about changes in the content of this
	 * text. The content also changes when a children of this text chanegs its
	 * content.
	 */
	public void addTextChangeListener(IContentChangeListener textChangeListener) {
		this.fChangeListener.add(textChangeListener);
	}
	
	/**
	 * Adds a listener that is informed about hooking and unhooking of this text
	 * into a DocumentText, e.g. this Text appearing and disappearing in an
	 * eclipse view.
	 */
	public void addTextStatusListener(ITextStatusListener statusListener) {
		this.fStatusListener.add(statusListener);
	}
	
	/**
	 * This method is called when this text is displayed, usually when its
	 * container is set.
	 */
	protected void shown() {
		this.shown = true;
		for(ITextStatusListener listener: fStatusListener) {
			listener.shown();
		}
	}
	
	/**
	 * This method is called when this text is hidden, usually when its
	 * container is unset or replaced.
	 */
	protected void hidden() {
		this.shown = false;
		for(ITextStatusListener listener: fStatusListener) {
			listener.hidden();
		}
	}
	
	/**
	 * Determines whether this Text is hooked into an DocumentText, this is
	 * wheather it is shown or hidden in an eclipse view.
	 * 
	 * @return True if this Text isn't shown, false otherwise.
	 */
	public boolean isHidden() {
		return !shown;
	}
	
	/**
	 * @return The next sibling in the document text hierarchy, or this when it
	 *         has no sibling.
	 */
	public Text nextText() {
		if (container == null) {
			return this;
		} else {
			int index = container.getTexts().indexOf(this);
			if (index + 1 < container.getTexts().size()) {
				Text result = container.getTexts().get(index+1);
				if (result instanceof CompoundText) {
					return ((CompoundText)result).first();
				} else {
					return result;
				}
			} else {
				Text result = container.nextText();
				if (result == container) {
					return this;
				}
				if (result instanceof CompoundText) {
					return ((CompoundText)result).first();
				} else {
					return result;
				}				
			}
		}
	}
	
	/**
	 * Returns the sibling of this text that also lay over the given offset.
	 * @param offset The offset relative to this text.
	 * @return The next sibling or this text.
	 */
	public Text nextText(int offset) {
		Text result = nextText();
		if (offset == getLength()) {
			return result.nextText(offset - getLength());
		} else {
			return this;
		}
	}
	
	/**
	 * @return The previous sibling in the document text hierarchy, or this when it
	 *         has no sibling.
	 */
	public Text prevText() {
		if (container == null) {
			return this;
		} else {
			int index = container.getTexts().indexOf(this);
			if (index > 0) {
				Text result = container.getTexts().get(index-1);
				if (result instanceof CompoundText) {
					return ((CompoundText)result).last();
				} else {
					return result;
				}
			} else {
				Text result = container.prevText();
				if (result == container) {
					return this;
				}
				if (result instanceof CompoundText) {
					return ((CompoundText)result).last();
				} else {
					return result;
				}				
			}
		}
	}
	
	@Override
	public String toString() {
		return getContent();
	}
}
