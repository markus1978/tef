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

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ISyntaxHighlightProvider;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;

import java.util.Collection;
import java.util.Vector;

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


public class FlagTemplate extends PrimitiveValueTemplate<Boolean> {
	
	private final String fFlagKeyword;

	public FlagTemplate(Template template, String flagKeywork) {
		super(template, template.getModelProvider().getModel().getType(Boolean.class));
		fFlagKeyword = flagKeywork;
	}	
	
	class ActualValue {
		boolean value;
	}

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {	
		return null;
	}		
	
	@Override
	protected Object getObjectValueFromStringValue(String value) {
		return fFlagKeyword.equals(value);
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new SyntaxProvider();
		} else if (IASTProvider.class == adapter) {
			return (T)new TreeRepresentationProvider();
		} else if (ISemanticProvider.class == adapter) {
			return (T)new SemanticProvider();
		} else if (ISyntaxHighlightProvider.class == adapter) {
			return (T)new SyntaxHighlightProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class SyntaxProvider implements ISyntaxProvider {		
		public String getNonTerminal() {
			return "Flag_" + fFlagKeyword;
		}

		public String[][] getRules() {		
			return new String[][] {
					new String[] { getNonTerminal() , "'" + fFlagKeyword + "'" },
					new String[] { getNonTerminal() },
			};
		}		
	}
	
	class SyntaxHighlightProvider implements ISyntaxHighlightProvider {
		public Collection<IRule> getHighlightRules() {
			Collection<IRule> result = new Vector<IRule>();
			if (fFlagKeyword.matches("[a-zA-Z]*")) {
				IToken token = new Token(
						new TextAttribute(new Color(Display.getCurrent(), new RGB(120,120,0)), null, SWT.BOLD));
				WordRule rule = new WordRule(new IWordDetector() {
					public boolean isWordPart(char c) {
						return Character.isJavaIdentifierStart(c);
					}

					public boolean isWordStart(char c) {
						return Character.isJavaIdentifierPart(c);
					}				
				});
				rule.addWord(fFlagKeyword, token);
				result.add(rule);
			}
			return result;
		}	
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			ASTElementNode result = new ASTElementNode(new ModelASTElement(FlagTemplate.this, null));			
			if ((Boolean)model) {
				result.addNodeObject(fFlagKeyword);							
			} 
			return result;
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {			
			if (((ASTElementNode)tree).getChildNodes().size() == 1) {
				return FlagTemplate.super.getAdapter(IASTProvider.class).
						createCompositeModel(owner, property, ((ASTElementNode)tree).getChildNodes().get(0), true);
			}
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {		
			return null;
		}				
	}
	
	class SemanticProvider implements ISemanticProvider {

		public void check(ASTElementNode representation, SemanticsContext context) {
			// empty	
		}		
	}
	
	@Override
	protected Object getId() {
		return fFlagKeyword;
	}		
}
