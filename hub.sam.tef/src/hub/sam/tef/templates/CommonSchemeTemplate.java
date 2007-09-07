package hub.sam.tef.templates;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;

/**
 * CommonSchemeTemplate is a special ValueTemplate that allows the same
 * representation for several meta-elements. Sometimes there are notations that
 * contain specific syntactical idioms that represent multiple concepts and the
 * right concept cannot be choosen from syntax, only from the semantic context
 * of the element. An example are single identifiers in OCL, they can represent
 * variable expressions, property calls of self, or type expressions.
 * 
 * A CommonSchemeTemplate combines different alternative templates and a scheme
 * template. The scheme template provides the syntax of the idiom, the
 * altervative template the different meta-model elements. The right alternative
 * is chooses during the reference resolution in a reconciliation run. During
 * composition the scheme template is used to create a representation for the
 * syntax, during reference resolution this is replaced by a representation
 * according to the choosen alternative.
 * 
 * The used scheme template has to implement {@link #getAdapter(Class)}.
 * CommonSchemeTemplate will use this method to obtain to different ASTProvider
 * adoptors: {@link IASTProvider} and {@link ISchemeASTProvider}. The reason is
 * that scheme template has to mime the {@link IASTProvider} functionality of
 * this class, but must also provide a provider for the scheme template itself.
 * The {@link ISchemeASTProvider} should be a delegate of the original
 * {@link IASTProvider} of the scheme template, the {@link IASTProvider} has to
 * be the provider that this class would return.
 */
public abstract class CommonSchemeTemplate extends ValueTemplate<IModelElement> {

	private ElementTemplate schemeTemplate = null;
	private ElementTemplate[] alternativeTemplates = null;
	
	public CommonSchemeTemplate(Template template, IType type) {
		super(template, type);
	}
	
	/**
	 * Callback to provide the scheme template. This template is used for
	 * parsing and creating an intermediate representation for the syntactical
	 * idiom that is desribed by this template.
	 */
	protected abstract ElementTemplate createSchemeTemplate();	
	
	/**
	 * Callback to provide the alternative templates. These templates are used
	 * for the actual representation of an element when its concrete nature can
	 * be determined. The chooses alternative template is used to create the
	 * final representation of the according meta-model element.
	 */
	protected abstract ElementTemplate[] createAlternatives();		
	
	/**
	 * Callback to change the original parse result, created based on the scheme
	 * template, towards a parse tree that is expected by the choosen
	 * alternative template. After the right alternative template is choosen,
	 * this method is called to prepare the parse tree for this alternative.
	 * 
	 * @param tree
	 *            The tree to change.
	 * @param alternative
	 *            The choosen alternative.
	 */
	protected abstract void adoptTree(ASTElementNode tree, ElementTemplate alternative);
	
	/**
	 * Callback that is used to determine the right alternative. First, a
	 * representation based on the scheme template is generated. Based on this,
	 * this method has to choose the right alternative.
	 * 
	 * @param owner
	 *            The element that owns the model element of interest.
	 * @param property
	 *            The property that this model element of interest is stored
	 *            under.
	 * @param tree
	 *            The parse tree based on the scheme template.
	 * @param isComposite
	 *            A boolean that tells if the element of interest is owned by
	 *            composition.
	 * @param context
	 *            The semantic context used to analyse the current model.
	 * @return A member of the alternative templates.
	 */
	protected abstract ElementTemplate selectAlternative(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context);
	
	private final ElementTemplate getSchemeTemplate() {
		if (schemeTemplate == null) {
			schemeTemplate = createSchemeTemplate();
		}
		return schemeTemplate;
	}
	
	protected final ElementTemplate[] getAlternativeTemplates() {
		if (alternativeTemplates == null) {
			alternativeTemplates = createAlternatives();		
		}
		return alternativeTemplates;
	}			

	@Override
	public Template[] getNestedTemplates() {
		return new Template[] { getSchemeTemplate() };
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IASTProvider.class == adapter || ISemanticProvider.class == adapter) {
			return (T)new ASTAndSemanticsProvider();
		} else if (ISyntaxProvider.class == adapter) {
			return (T)new SyntaxProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class SyntaxProvider implements ISyntaxProvider {
		public String getNonTerminal() {
			return getSchemeTemplate().getAdapter(ISyntaxProvider.class).getNonTerminal();
		}

		public String[][] getRules() {
			return getSchemeTemplate().getAdapter(ISyntaxProvider.class).getRules();
		}		
	}
	
	class ASTAndSemanticsProvider implements IASTProvider, ISemanticProvider {
		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {
			return getSchemeTemplate().getAdapter(ISchemeASTProvider.class).createCompositeModel(owner, property, tree, isComposite);
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {
			IModelElement schemeElement = ((ModelASTElement)tree.getElement()).getModelElement();
			ElementTemplate choosenAlternative = selectAlternative(owner, property, tree, isComposite, context);
			
			if (isComposite) {
				getModel().getCommandFactory().delete(schemeElement).execute();
				adoptTree((ASTElementNode)tree, choosenAlternative);
				choosenAlternative.getAdapter(IASTProvider.class).
						createCompositeModel(owner, property, tree, isComposite);
			} else {
				throw new RuntimeException("not implemented.");
			}
			
			return choosenAlternative.getAdapter(IASTProvider.class).createReferenceModel(owner, property, tree, isComposite, context);			
		}

		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			if (model instanceof ICollection) {
				model = ((ICollection)model).iterator().next();
			}
			for (ValueTemplate alternative: getAlternativeTemplates()) {
				if (alternative.isTemplateFor(model)) {
					return alternative.getAdapter(IASTProvider.class).createTreeRepresentation(owner, 
							property, model, true, layout);																		
				}
			}
			throw new RuntimeException("assert");
		}
		
		public void check(ASTElementNode representation, SemanticsContext context) {
			representation.getElement().getTemplate().getAdapter(ISemanticProvider.class).check(representation, context);		
		}				
	}
}
