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

import java.util.Collection;
import java.util.Vector;

import hub.sam.tef.reconciliation.syntax.ISyntaxHighlightProvider;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Terminal templates create simple fix views. Can be used for
 * terminals, like keywords, parathesis, whitespaces, etc.
 */
public class TerminalTemplate extends Template implements ISyntaxProvider, ISyntaxHighlightProvider {
	
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

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)this;
		} else if (ISyntaxHighlightProvider.class == adapter) {
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

	public Collection<IRule> getHighlightRules() {
		Collection<IRule> result = new Vector<IRule>();		
		if (fTerminalText.matches("[a-zA-Z]*")) {
			IToken token = new Token(
					new TextAttribute(getColor(), null, SWT.BOLD));
			WordRule rule = new WordRule(new IWordDetector() {
				public boolean isWordPart(char c) {
					return Character.isJavaIdentifierStart(c);
				}

				public boolean isWordStart(char c) {
					return Character.isJavaIdentifierPart(c);
				}				
			});
			rule.addWord(fTerminalText, token);
			result.add(rule);
		}
		return result;
	}
	
	protected Color getColor() {
		return new Color(Display.getCurrent(), new RGB(120,120,0));
	}

	@Override
	protected Object getId() {
		return fTerminalText;
	}			
}
