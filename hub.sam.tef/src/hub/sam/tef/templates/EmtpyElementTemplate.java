package hub.sam.tef.templates;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;

public abstract class EmtpyElementTemplate extends ValueTemplate<IModelElement> {
	private Template[] fTemplates;
	private final IMetaModelElement fMetaModelElement;
	
	public EmtpyElementTemplate(Template template, IMetaModelElement metaModelElement) {
		super(template, metaModelElement);
		this.fMetaModelElement = metaModelElement;		
	}

	/**
	 * @return A set of value templates. These are the templates for all
	 *         possible values for this template.
	 */
	public abstract Template[] createTemplates();
	
	@Override
	public Template[] getNestedTemplates() {
		if (fTemplates == null) {
			fTemplates = createTemplates();
		}
		return fTemplates;
	}
	
	/**
	 * Returns true for those meta model elements that this element template
	 * provides representations for.
	 */
	@Override
	public boolean isTemplateFor(IModelElement model) {
		if (model instanceof IModelElement) {
			for (Template subTemplate: getNestedTemplates()) {
				if (subTemplate instanceof ValueTemplate) {				
					return ((ValueTemplate)subTemplate).isTemplateFor(model);
				}
			}
			throw new RuntimeException("assert");
		} else {
			return super.isTemplateFor(model);
		}
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
		if (getAlternativeSymbol() == null) {
			return super.getId();
		} else {
			return getAlternativeSymbol();
		}
	}

	class ModelUpdater extends ValueTemplateSemantics implements ISyntaxProvider {
				
		protected ModelUpdater(ValueTemplate template) {
			super(template);		
		}		

		@Override
		public String getNonTerminal() {
			String alternativeNonTerminal = getAlternativeSymbol();
			return alternativeNonTerminal == null  ? super.getNonTerminal() : alternativeNonTerminal;
		}

		public String[][] getRules() {
			
			String[] result = new String[getNestedTemplates().length + 1];
			result[0] = getNonTerminal();
			int i = 1;
			for(Template subTemplate: getNestedTemplates()) {
				result[i++] = subTemplate.getAdapter(ISyntaxProvider.class).getNonTerminal();
			}
			return new String[][] { result };					
		}			
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String notused, Object model, boolean isComposite, AbstractLayoutManager layout) {			
			if (model instanceof ICollection) {
				model = ((ICollection)model).iterator().next();
			}
			ModelASTElement contents = new ModelASTElement(EmtpyElementTemplate.this, (IModelElement)model);
			ASTElementNode treeRepresentation = new ASTElementNode(contents);
			for (Template subTemplate: getNestedTemplates()) {
				if (subTemplate instanceof ValueTemplate) {
					treeRepresentation.addNodeObject(subTemplate.getAdapter(IASTProvider.class).
							createTreeRepresentation(owner, notused, model, true, layout));
				} else if (subTemplate instanceof TerminalTemplate) {
					treeRepresentation.addNodeObject(((TerminalTemplate)subTemplate).getTerminalText());
				} else if (subTemplate instanceof WhitespaceTemplate) {
					treeRepresentation.addNodeObject(((WhitespaceTemplate)subTemplate).getSpace(layout));
				} else {
					throw new RuntimeException("assert");
				}
			}
			return treeRepresentation;
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {			
			ASTNode childTree = tree.getChildNodes().get(0);			
			IModelElement result = (IModelElement) childTree.getElement().getTemplate().getAdapter(IASTProvider.class).
					createCompositeModel(owner, property, childTree, isComposite);
			tree.setElement(new ModelASTElement(tree.getElement().getTemplate(), result));
			return result;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {
			ASTNode childTree = tree.getChildNodes().get(0);			
			IModelElement result = (IModelElement) childTree.getElement().getTemplate().getAdapter(IASTProvider.class).
					createReferenceModel(owner, property, childTree, isComposite, context);			
			return result;
		}				
	}
		
	class SemanticProvider implements ISemanticProvider {
		public void check(ASTElementNode representation, SemanticsContext context) {		
			ASTElementNode nextNode = ((ASTElementNode)representation).getChildNodes().get(0);
			nextNode.getElement().getTemplate().getAdapter(ISemanticProvider.class).
					check(nextNode, context);
		}		
	}
}
