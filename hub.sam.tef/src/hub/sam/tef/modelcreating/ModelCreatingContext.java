package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Provides all information that is necessary to perform model creating. Model
 * creating contains parsing, actually creating a model from the parse tree,
 * resolving references, and model checking. A single instance of this class is
 * available as a parameter to all the methods available in the model creating
 * process.<br/>
 * 
 * TODO actually a class with this functionality should do the actual
 * parse-tree visiting and not the parse-tree itself.
 * 
 * A context maintains: 
 * <ul>
 * 	<li>the text that the model is created from</li>
 * 	<li>registries for default and custom value and property semantics</li>
 *  <li>a list of errors that occur during model creation</li>
 *  <li>a list of meta model packages</li>
 * </ul>
 */
public final class ModelCreatingContext {
	
	/**
	 * The resource that will contain the model.
	 */
	private final Resource fResource;
	
	/**
	 * All the packages of the meta-types that might be instantiated during
	 * model creation.
	 */
	private final EPackage[] fPackages;
	
	/**
	 * The hole document/model as text.
	 */
	private final String fText;	
	
	/**
	 * The list of errors (user mistakes) encountered in the text during model
	 * creation.
	 */
	private final Collection<AbstractError> fErrors = new ArrayList<AbstractError>();
	
	/**
	 * A map that relates created object with the parse tree nodes that
	 * represent them in the text.
	 */
	private final Map<EObject, ParseTreeRuleNode> fNodesForObjects = new HashMap<EObject, ParseTreeRuleNode>();
	
	private final ISemanticsProvider fSemanticsProvider;

	/**
	 * @param resource
	 *            a (empty) resource that contains the created model. Even
	 *            though model object are created using this context, the
	 *            resource is not filled automatically (TODO). TODO should be
	 *            created in this class ???
	 * @param packages
	 *            the packages that contain all the meta-model elements. This is
	 *            used to instantiate model objects. It is not recommended to
	 *            create your instances yourself, since maybe the context will
	 *            add them automatically to the resource (TODO).
	 * @param semanticsProvider
	 *            provides the semantics provider for the given syntax
	 * @param text
	 *            the text document that the model is created from.
	 */
	public ModelCreatingContext(Resource resource, EPackage[] packages,
			ISemanticsProvider semanticsProvider, String text) {
		super();
		fResource = resource;
		fPackages = packages;
		fText = text;		
		fSemanticsProvider = semanticsProvider;
	}

	/**
	 * Adds a given object to the model resource in this context.
	 */
	public void addToResource(EObject object) {		
		fResource.getContents().add(object);		
	}
	
	/**
	 * Returns all top-level model objects in this context.
	 */
	public EList<EObject> getContents() {
		return fResource.getContents();
	}

	/**
	 * Returns all the model contents in this context.
	 */
	public TreeIterator<EObject> getAllContents() {
		return fResource.getAllContents();
	}
	
	/**
	 * TODO
	 * @return
	 */
	public Resource getResource() {
		return fResource;
	}

	/**
	 * @return the text that the model is created from.
	 */
	public String getText() {
		return fText;
	}
	
	public ISemanticsProvider getSemanticsProvider() {
		return fSemanticsProvider;
	}
	
	/**
	 * Adds an error to the context. These errors are used to be displayed to
	 * the user via an editor.
	 */
	public void addError(AbstractError error) {
		this.fErrors.add(error);
	}	
	
	public Collection<AbstractError> getErrors() {
		return Collections.unmodifiableCollection(fErrors);
	}
	
	/**
	 * @return the parse tree node that represent the given object. The object
	 *         must be created within this context.
	 */
	public ParseTreeRuleNode getTreeNodeForObject(EObject object) {
		return fNodesForObjects.get(object);
	}
	
	/**
	 * Creates an instance of the given meta class. This method does NOT add the
	 * created objects to the resource automatically.
	 * 
	 * @param metaClass
	 *            is the meta class, a class with the same name must be
	 *            contained in on of the meta model packages in this context.
	 * @param node
	 *            the parse tree node that represent the instantiated model
	 *            element.
	 * @return the created model element.
	 * @throws ModelCreatingException,
	 *             if the meta class is not contained in the meta model packages
	 *             of this context.
	 */
	public EObject instantiate(EClass metaClass, ParseTreeRuleNode node) throws ModelCreatingException {
		loop: for (EPackage ePackage: fPackages) {
			EClassifier classifier = null;
			if ((classifier = ePackage.getEClassifier(metaClass.getName())) != null) {
				if (!(classifier instanceof EClass) || ((EClass)classifier).isAbstract()) {
					continue loop;
				}
				EObject result = ePackage.getEFactoryInstance().create(metaClass);
				fNodesForObjects.put(result, node);
				return result;
			}
		}
		throw new ModelCreatingException("Cannot instanitate " + metaClass.getName() + ".");
	}
}
