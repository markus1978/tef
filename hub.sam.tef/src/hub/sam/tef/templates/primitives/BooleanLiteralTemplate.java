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
package hub.sam.tef.templates.primitives;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.PrimitiveTreeRepresentation;
import hub.sam.tef.templates.Template;

public class BooleanLiteralTemplate extends PrimitiveValueLiteralTemplate<Boolean>{
	
	public BooleanLiteralTemplate(Template template) {
		super(template, template.getModelProvider().getModel().getType(Integer.class));
	}

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {
		return getModel().getCommandFactory().set(owner, property, true);
	}			
	
	@Override
	protected Object getObjectValueFromStringValue(String value) {
		return new Boolean(value);
	}

	@Override
	protected String getNonTerminal() {
		return "'true'|'false'";
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new SyntaxProvider();
		} else if (IASTProvider.class == adapter){
			return (T)new TreeRepresentationProvider();
		} else if (ISemanticProvider.class == adapter) {
			return (T)new ISemanticProvider() {
				public void check(ASTElementNode representation, SemanticsContext context) {
				}				
			};
		} else {
			return super.getAdapter(adapter);
		}
	}
		
	class SyntaxProvider implements ISyntaxProvider {	
		public String getNonTerminal() {
			return "BooleanLiterals";
		}
		public String[][] getRules() {
			return new String[][] { new String[] {"BooleanLiterals", "'true'"}, new String[] {"BooleanLiterals", "'false'"}};
		}
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			return new PrimitiveTreeRepresentation((model == null) ? "false" : model);
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {
			getModel().getCommandFactory().set(owner, property, 
					getObjectValueFromStringValue(tree.getContent())).execute();
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {		
			return null;
		}			
	}

	@Override
	protected IRule getHightlightRule(IToken token) {
		WordRule result = new WordRule(new IWordDetector() {
			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierStart(c);
			}

			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierPart(c);
			}				
		});
		result.addWord("true", token);
		result.addWord("false", token);
		return result;
	}	

	@Override
	protected TextAttribute getHighlightAttribute() {
		return new TextAttribute(new Color(Display.getCurrent(), new RGB(0,0,160)), 
				null, SWT.NORMAL);
	}	
}
