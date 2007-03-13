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
package hub.sam.tef.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.parse.TextBasedAST;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;


/**
 * Terminal templates create simple fix views. Can be used for
 * terminals, like keywords, parathesis, whitespaces, etc.
 */
public class TerminalTemplate extends Template implements ISyntaxProvider {
	
	public static final TextAttribute KEY_WORD_HIGHLIGHT = new TextAttribute(
			Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
	public static final TextAttribute FLAG_HIGHLIGHT = new TextAttribute(
			Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.BOLD);
	
	private final String fTerminalText;
	private final TextAttribute fHighlight;

	public TerminalTemplate(Template template, final String terminalText) {
		super(template);
		fTerminalText = terminalText;
		fHighlight = null;
	}

	/**
	 * @param terminalText
	 *            The string that views of this template will show.
	 * @param highlight
	 *            The TextAttribute that will be automatically applied to the
	 *            view, use it for syntax highlighting.
	 */
	public TerminalTemplate(Template template, final String terminalText, final TextAttribute highlight) {
		super(template);
		fTerminalText = terminalText;
		fHighlight = highlight;
	}

	protected Text createView() {
		Text result =  new FixText(fTerminalText);
		if (fHighlight != null) {
			result.setElement(TextAttribute.class, fHighlight);
		}
		return result;
	}
	
	/**
	 * Returns the created view for the given model. It adds additional objects to the view. For example it
	 * puts the used template into the view.
	 */
	public final Text getView() {
		Text result = createView();
		result.setElement(Template.class, this);
		return result;
	}	

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)this;
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	public String getTerminalText() {
		return fTerminalText;
	}

	public String getNonTerminal() {
		return "'" + fTerminalText + "'";
	}

	public String[][] getRules() {
		return new String[][] {};
	}

	public TextBasedAST createAST(TextBasedAST parent,  IModelElement model, Text text) {	
		return null;
	}	
}
