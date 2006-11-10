package editortest.text;

import java.util.Collections;
import java.util.List;
import java.util.Vector;


/**
 * This specialisation of Text is used as a node with children in a tree of
 * texts. It allows to add children to it and forwards visitors of this text to
 * its children. A CompoundText represents the contents of all its children. It
 * hasn't a content of its own.
 */
public class CompoundText extends Text {

	private final List<Text> texts = new Vector<Text>();

	/**
	 * This should only be used by childrens of this text to realise
	 * {@link Text#changeContent(int, int, String)}.
	 */
	protected final void changeContent(Text inner, int begin, int end, String text) {
		int offset = getBeginOf(inner);
		changeContent(begin + offset, end + offset, text);
	}

	/**
	 * This should only be used by childrens of this text to realise
	 * {@link Text#getContent(int, int)}.
	 */
	protected final String getContent(Text inner, int begin, int end) {
		int offset = getBeginOf(inner);
		return getContent(begin + offset, end + offset);
	}	
	
	/**
	 * Forwards the visitor to all childrens. Afterwards the visitor is handed to
	 * this text.
	 * @see Text#process(ITextVisitor, int)
	 */
	@Override
	public final void process(ITextVisitor visitor, int atOffset) {
		for (Text innerText: visitor.decentInto(this)) {
			innerText.process(visitor, atOffset - getBeginOf(innerText));
		}
		visitor.visitCompoundText(this, atOffset);
	}

	/**
	 * Adds a child text to the end of this {@link CompoundText}.
	 */
	public void addText(Text text) {
		texts.add(text);
		text.setContainer(this);
	}
	
	/**
	 * Adds a child text before the given reference text.
	 * @param before The text to be added.
	 * @param text The reference text.
	 */
	public void addTextBefore(Text before, Text text) {
		if (before == null) {
			texts.add(text);
		} else {
			texts.add(texts.indexOf(before), text);		
		}
		text.setContainer(this);
	}
	
	public void addTextAt(int index, Text text) {		
		texts.add(index, text);
		text.setContainer(this);
	}
	
	/**
	 * Removes the last text from this compoud.
	 */
	public boolean removeText() {
		if (texts.size() == 0) {
			return false;
		} else{
			Text removed = texts.remove(texts.size() - 1);
			changeContent(removed, 1, removed.getLength() + 1, "");
			removed.setContainer(null);
			return true;
		}
	}
	
	/**
	 * Replaces on text in this compound through another.
	 */
	public void replaceText(Text oldText, Text newText) {
		int oldLength = getLength();
		int beginOfOldText = getBeginOf(oldText);
		String newContent = newText.getContent();		
		oldText.replaceContainer(null);
		changeContent(beginOfOldText, oldText.getLength(), newContent);
		texts.set(texts.indexOf(oldText), newText);
		newText.replaceContainer(this);		
		
		if (oldLength - oldText.getLength() + newText.getLength() != getLength()) {
			System.out.println("wrong length");
		}
	}
	
	public List<Text> getTexts() {
		return Collections.unmodifiableList(texts);
	}
	
	/**
	 * Returns all texts at an offset with the beginning of this text as 0-reference.
	 * Text cannot be placed "on each other". This means no two texts can represent 
	 * the same part of a document. But since text can have length 0 more than one
	 * text can be found at a single offset.
	 */
    public List<Text> getInnerTextAt(int offset) {
		List<Text> result = new Vector<Text>();
		int pos = 0;
		loop: for (Text inner: texts) {
			int nextPos = pos + inner.getLength();
			if (offset >= pos && offset <= nextPos) {
				result.add(inner);
				if (offset != pos && offset != nextPos) {
					break loop;
				}
			}			
			pos = nextPos;
		}	
		return result;
	}
	
	/**
	 * Returns the beginning of the given text relative to the beginning of this
	 * text.
	 */
	public int getBeginOf(Text innerText) {
		int pos = 0;
		for (Text inner: texts) {
			if (inner == innerText) {
				return pos;
			} else {
				pos += inner.getLength();
			}
		}
		return -1;
	}

	@Override
	protected final void hidden() {
		super.hidden();
		for (Text text: texts) {
			text.hidden();
		}
	}

	@Override
	protected final void shown() {
		super.shown();
		for (Text text: texts) {
			text.shown();
		}
	}	
}
