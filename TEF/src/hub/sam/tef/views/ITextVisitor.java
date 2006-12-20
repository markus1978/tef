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
 * Implementations of this interface can traverse a tree of texts. This
 * interface is also used to control the recursive decent along a tree of texts.
 */
public interface ITextVisitor {
	
	/**
	 * This method is called when this visitor visits a {@link Text} that is not
	 * a {@link CompoundText}.
	 */
	public void visitText(Text visitedText, int atOffset);
	
	/**
	 * This method is called when this visitor visits a {@link CompoundText}. A
	 * {@link CompoundText} is always visited after its children have been
	 * visited.
	 */
	public void visitCompoundText(CompoundText visitedText, int atOffset);
	
	/**
	 * This method should return all children of the given {@link CompoundText}
	 * that this visitor shall be visit before it visits the
	 * {@link CompoundText} itself. The method must only return texts that a
	 * direct children of the given text.
	 */
	public Iterable<Text> decentInto(CompoundText text);
}
