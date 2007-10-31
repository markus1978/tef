package hub.sam.tef.reconciliation.treerepresentation;

import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.models.IModelElement;

/**
 * A ASTProvider provides functionality to create parse trees from models,
 * models from parse trees, and resolve references in a model, according to a
 * template. The provider is owned and given by the template that it is a
 * provider for. It is called ASTProvider because it basically describes the
 * relation between model and abstract syntax tree.
 * 
 * All the operations are working recursive. They usually work on a tree or
 * model representation and after they did what they do, they have to call the
 * according operations provides by the templates of their subelements on the
 * corrosponding sub-elements.
 */
public interface IASTProvider {
	
	/**
	 * Creates the parse tree representation for a model element.
	 * @param owner The element that owns the element of interest.
	 * @param property The property under which the element of interest is stored.
	 * @param model The element of interest.
	 * @param isComposite Tells if this element is owned by composition.
	 * @param layout The layout that is used to arrange the model elements in the text.
	 * @return The newly created ASTNode.
	 */
	public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout);
	
	/**
	 * Creates a model element from a tree representation. It does not resovle
	 * any references, it only creates composite elements. The created element
	 * is created as a child of a given owner and stored under a given
	 * attribute.
	 * 
	 * @param owner
	 *            The owner of the element to create.
	 * @param property
	 *            The property that this element is stored under.
	 * @param tree
	 *            The parse tree representation of the element.
	 * @param isComposite
	 *            A boolean that tells if this element is a composite of the
	 *            owner. If it is not, this method will create mock object as a place holder for the real element.
	 * @return The created element.
	 */
	public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite);
	
	/**
	 * Resolves references in an existing model. All place holder mock-up
	 * elements that where created in
	 * {@link #createCompositeModel(IModelElement, String, ASTNode, boolean)}
	 * will be removed and replaced by the real elements.
	 * 
	 * @param owner
	 *            The owner of the element to create.
	 * @param property
	 *            The property that this element is stored under.
	 * @param tree
	 *            The parse tree representation of the element.
	 * @param isComposite
	 *            A boolean that tells if this element is a composite of the
	 *            owner. If it is, this method will not do much.
	 * @param context
	 *            The semantic context used for analysis. For example it
	 *            provides everything necessary to resolve the elements.
	 * @return The resolved element.
	 */
	public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context);
	
}
