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
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;

public abstract class SingleValueTemplate<ModelType> extends PropertyTemplate<ModelType> {
	
	public SingleValueTemplate(ElementTemplate elementTemplate, String property) {
		super(elementTemplate, property);
	}	
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new SyntaxProvider();
		} else if (IASTProvider.class == adapter) {
			return (T)new TreeRepresentationProvider();
		} else if (ISemanticProvider.class == adapter) {
			return (T)new SemanticProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			return getValueTemplate().getAdapter(IASTProvider.class).
					createTreeRepresentation(null, null, ((IModelElement)model).getValue(property), true, layout);			
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {
			return getValueTemplate().getAdapter(IASTProvider.class).
					createCompositeModel(owner, property, tree, true);
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {
			return getValueTemplate().getAdapter(IASTProvider.class).
					createReferenceModel(owner, property, tree, true, context);
		}					
	}

	class SyntaxProvider implements ISyntaxProvider {			
		public String getNonTerminal() {
			return getValueTemplate().getAdapter(ISyntaxProvider.class).getNonTerminal();
		}

		public String[][] getRules() {
			return new String[][] {};
		}					
	}
	
	class SemanticProvider implements ISemanticProvider {
		
		public void check(ASTElementNode representation, SemanticsContext context) {		
			getValueTemplate().getAdapter(ISemanticProvider.class).
					check(representation, context);		
		}		
	}
		
}
