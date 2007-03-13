/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef.views;

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
		if (offset == -1) {
			return "";
		} else {
			return getContent(begin + offset, end + offset);
		}
	}	
	
	/**
	 * Forwards the visitor to all childrens. Afterwards the visitor is handed
	 * to this text.
	 * 
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
	 * 
	 * @param before
	 *            The text to be added.
	 * @param text
	 *            The reference text.
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
			//changeContent(removed, 0, removed.getLength(), "");
			removed.setContainer(null);
			return true;
		}
	}
	
	public void removeText(int position) {
		Text removed = texts.get(position);
		if (!removed.isHidden()) {
			removed.changeContent(0, removed.getLength(), "");
		}
		texts.remove(position);
		removed.setContainer(null);
	}
	
	/**
	 * Replaces on text in this compound through another. The old Text will be
	 * unhooked and thus hidden, the new text will be hooked and therefore
	 * shown. The oldText must be a Text of this compound the text must not be a
	 * Text hooked in any text hierarchy.
	 */
	public void replaceText(Text oldText, Text newText) {
		if (texts.contains(oldText)) {
			if (oldText.isHidden()) {
				throw new RuntimeException("assert");
			}
			oldText.changeContent(0, oldText.getLength(), newText.getContent());
			texts.set(texts.indexOf(oldText), newText);
			oldText.setContainer(null);
			boolean newTextWasHidden = newText.isHidden() && !this.isHidden();
			newText.replaceContainer(this);
			if (newTextWasHidden) {
				newText.show();
			}
				
		} else {
			throw new RuntimeException("assert");
		}
					
		/*
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
		*/
	}
	
	/**
	 * @return All Texts of this compound.
	 */
	public List<Text> getTexts() {
		return Collections.unmodifiableList(texts);
	}
	
	/**
	 * Returns all texts at an offset with the beginning of this text as
	 * 0-reference. Text cannot be placed "on each other". This means no two
	 * texts can represent the same part of a document. But since text can have
	 * length 0 more than one text can be found at a single offset.
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
	protected final void hide() {
		super.hide();
		for (Text text: texts) {
			text.hide();
		}
	}

	@Override
	protected final void show() {
		for (Text text: texts) {
			text.show();
		}
		super.show();
	}	
	
	/**
	 * @return The first leaf in this sub tree.
	 */
	public Text first() {		
		if (texts.size() == 0) {
			return this;
		} else {
			Text firstText = texts.get(0);
			if (firstText instanceof CompoundText) {
				return ((CompoundText)firstText).first();
			} else {
				return firstText;
			}
		}
	}
	
	/**
	 * @return The last leaf in this sub tree.
	 */
	public Text last() {		
		if (texts.size() == 0) {
			return this;
		} else {
			Text lastText = texts.get(texts.size() -1);
			if (lastText instanceof CompoundText) {
				return ((CompoundText)lastText).last();
			} else {
				return lastText;
			}
		}
	}

	@Override
	public void dispose() {
		for(Text child: texts) {
			child.dispose();
		}
		super.dispose();
		//texts.clear();
	}	
	
}
