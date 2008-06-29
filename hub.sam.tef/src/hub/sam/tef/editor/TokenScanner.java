/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
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

package hub.sam.tef.editor;

import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.tokens.TokenDescriptor;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.util.EObjectHelper;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class TokenScanner extends RuleBasedScanner {

	public TokenScanner(Syntax syntax) {
		super();		
		configure(syntax);
	}

	/**
	 * extend the given syntax with missing rules and text-rendering
	 * methods provided by the standard framework and various extension
	 * points
	 * 
	 * @param syntax editor syntax object to be extended
	 * 
	 * @author Markus Scheidgen, Dirk Fahland
	 */
	private void configure(Syntax syntax) {
		List<IRule> rules = new Vector<IRule>();
		
		// add a rule for each keyword
		Iterator<EObject> it = syntax.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof FixTerminal) {
				String terminal = ((FixTerminal)next).getTerminal();
				if (terminal.matches("[a-zA-Z]*")) {
					IToken token = new Token(new TextAttribute(
							new Color(Display.getCurrent(), new RGB(120,120,0)), null, 
							SWT.BOLD));
					WordRule rule = new WordRule(new IWordDetector() {
						public boolean isWordPart(char c) {
							return Character.isLetter(c);
						}

						public boolean isWordStart(char c) {
							return Character.isLetter(c);
						}				
					});
					rule.addWord(terminal, token);
					rules.add(rule);
				}					
			}
		}	
		
		// add the text-rendering rules taken from token definitions
		for(TokenDescriptor token: 
				TokenDescriptor.getRegisteredTokenDescriptors()) {
			if (EObjectHelper.contains(syntax.getPattern(), token.getRccPattern()))
			{
				List<IRule> tokenRules = token.getHighlightRules();
				if (tokenRules != null) {
					rules.addAll(tokenRules);
				}
			}
		}
		
		// add the rules taken from primitive types
		for(PrimitiveTypeDescriptor primitiveType: 
				PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
			IRule rule = primitiveType.getHighlightRule();
			if (rule != null) {
				rules.add(rule);
			}
		}
		
		setRules(rules.toArray(new IRule[]{}));		
	}
}
