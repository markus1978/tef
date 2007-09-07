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

import java.util.List;
import java.util.Vector;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;


/**
 * This is a ValueTemplate that represents different types of 
 * values.
 */
public abstract class OptionalTemplate extends ValueTemplate<IModelElement> {
	
	private Template[] fOptionTemplate = null;
	private final IMetaModelElement fMetaModelElement;
	
	public OptionalTemplate(Template template, IMetaModelElement metaModelElement) {
		super(template, metaModelElement);
		this.fMetaModelElement = metaModelElement;		
	}
	
	public Template[] getOptionTemplate() {
		if (fOptionTemplate == null) {
			fOptionTemplate = createOptionTemplate();
		}
		return fOptionTemplate;
	}
	
	public ValueTemplate getValueTemplate() {
		for (Template template: getOptionTemplate()) {
			if (template instanceof ValueTemplate) {
				return (ValueTemplate)template;
			}
		}
		throw new RuntimeException("assert");
	}

	/**
	 * @return A set of value templates. These are the templates for all
	 *         possible values for this template.
	 */
	public abstract Template[] createOptionTemplate();
	
	@Override
	public Template[] getNestedTemplates() {
		return getOptionTemplate();
	}
	
	/**
	 * Returns true for those meta model elements that this element template
	 * provides representations for.
	 */
	@Override
	public boolean isTemplateFor(IModelElement model) {
		return getValueTemplate().isTemplateFor(model);		
	}	
				
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new ModelUpdater(this);
		} else if (IASTProvider.class == adapter) {			
			return (T)new TreeRepresentationProvider();
		} else if (ISemanticProvider.class == adapter) {
			return (T)new SemanticProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}	
	
	public String getAlternativeSymbol() {
		return null;
	}

	@Override
	protected Object getId() {
		return getAdapter(ISyntaxProvider.class).getNonTerminal();
	}

	class ModelUpdater extends ValueTemplateSemantics implements ISyntaxProvider {
				
		protected ModelUpdater(ValueTemplate template) {
			super(template);		
		}		

		@Override
		public String getNonTerminal() {
			return getValueTemplate().getAdapter(ISyntaxProvider.class).getNonTerminal() + "_opt";	
		}

		public String[][] getRules() {
			List<String> activeRule = new Vector<String>();
			activeRule.add(getNonTerminal());
			for (Template template: getOptionTemplate()) {
				ISyntaxProvider syntaxAdaptor = template.getAdapter(ISyntaxProvider.class);
				if (syntaxAdaptor != null) {
					activeRule.add(syntaxAdaptor.getNonTerminal());
				}
			}
			return new String[][] {
					activeRule.toArray(new String[] {}),
					new String[] { getNonTerminal() }
			};
		}			
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String notused, Object model, boolean isComposite, AbstractLayoutManager layout) {						
			if (model != null) {
				ModelASTElement contents = new ModelASTElement(OptionalTemplate.this, (IModelElement)model);
				ASTElementNode treeRepresentation = new ASTElementNode(contents);				
				for (Template template: getOptionTemplate()) {
					if (template instanceof TerminalTemplate) {
						treeRepresentation.addNodeObject(((TerminalTemplate)template).getTerminalText());
					} else if (template instanceof WhitespaceTemplate) {
						treeRepresentation.addNodeObject(((WhitespaceTemplate)template).getSpace(layout));
					} else {
						treeRepresentation.addNodeObject(template.getAdapter(IASTProvider.class).
									createTreeRepresentation(owner, notused, model, true, layout));
					}
				}
				return treeRepresentation;
			} else {
				return null;
			}
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {						
			if (tree != null && tree.getChildNodes().size() == 1) {
				ASTNode childTree = tree.getChildNodes().get(0);
				IModelElement result = (IModelElement) childTree.getElement().getTemplate().getAdapter(IASTProvider.class).
						createCompositeModel(owner, property, childTree, isComposite);
				tree.setElement(new ModelASTElement(tree.getElement().getTemplate(), result));
				return result;
			}
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {
			if (tree != null && tree.getChildNodes().size() == 1) {
				ASTNode childTree = tree.getChildNodes().get(0);			
				IModelElement result = (IModelElement) childTree.getElement().getTemplate().getAdapter(IASTProvider.class).
						createReferenceModel(owner, property, childTree, isComposite, context);			
				return result;
			}
			return null;
		}				
	}
		
	class SemanticProvider implements ISemanticProvider {		
		public void check(ASTElementNode representation, SemanticsContext context) {
			if (representation != null && representation.getChildNodes().size() == 1) {
				ASTElementNode nextNode = ((ASTElementNode)representation).getChildNodes().get(0);
				nextNode.getElement().getTemplate().getAdapter(ISemanticProvider.class).
						check(nextNode, context);
			}
		}		
	}
}
