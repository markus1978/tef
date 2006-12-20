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

/**
 * This represents a edge node in a text hierarchy with changing content. 
 * Opposite to {@link FixText}.
 */
public class ChangeText extends Text {
	
	private boolean isNull = false;
	
	/**
	 * Changes the content of this Text. When this Text is not
	 * {@link Text#isHidden()} it will imidiatly shown in the eclipse view. It
	 * will in all cases cause notification to all handler registred via
	 * {@link Text#addTextChangeListener(IContentChangeListener).
	 * 
	 * @param text
	 *            The new content of this Text. If it the content is null, "<null>" will
	 *            be used as content.
	 */
	public void setText(String text) {
		if (text == null) {
			changeContent(0, getLength(), "<null>");
			isNull = true;
		} else {
			changeContent(0, getLength(), text);
			isNull = false;
		}
	}

	/**
	 * @return True if this Text content's is "<null>".
	 */
	public boolean isNull() {
		return isNull;
	}
}
