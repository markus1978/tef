package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A default implementation for a model creating context.
 */
public class ModelCreatingContext implements IModelCreatingContext {
	
	/**
	 * The resource that will contain the model.
	 */
	private Resource fResource;
	
	/**
	 * All the packages of the meta-types that might be instantiated during
	 * model creation.
	 */
	private final EPackage[] fPackages;
	
	/**
	 * The hole document/model as text.
	 */
	private String fText;	
	
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
	 * @param packages
	 *            the packages that contain all the meta-model elements. This is
	 *            used to instantiate model objects. It is not recommended to
	 *            create your instances yourself, since maybe the context will
	 *            add them automatically to the resource (TODO).
	 * @param semanticsProvider
	 *            provides the semantics provider for the given syntax
	 * 
	 * @param resource
	 *            a container for the created model.
	 * 
	 * @param text
	 *            that the model is created from.
	 */
	public ModelCreatingContext(EPackage[] packages, 
			ISemanticsProvider semanticsProvider, Resource resource, String text) {
		super();
		fPackages = packages;		
		fSemanticsProvider = semanticsProvider;
		fResource = resource;
		fText = text;
	}
		
	/**
	 * Initialises this model creating context for model creating into a
	 * specific resource, for a input text.
	 * 
	 * @param resource
	 *            a (empty) resource that contains the created model. Even
	 *            though model object are created using this context, the
	 *            resource is not filled automatically (TODO). TODO should be
	 *            created in this class ???
	 * @param text
	 *            the text document that the model is created from.
	 */
	public void initialise(Resource resource, String text) {
		fResource = resource;
		fText = text;
	}

	/**
	 * Adds a given object to the model resource in this context.
	 */
	@Override
	public void addCreatedObject(EObject object) {		
		fResource.getContents().add(object);		
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
	 * Connects two objects with each other. The tree node of the source object
	 * will also become the tree node of the target object. This helps in the
	 * context of model transformation to define traces from objects to their
	 * original textual representation.
	 * 
	 * @param source
	 *            is the object that already has a textual representation.
	 * @param target
	 *            is the object created from the source object that needs a
	 *            trace to a textual representation.
	 */
	public void trace(EObject source, EObject target) {
		fNodesForObjects.put(target, fNodesForObjects.get(source));
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

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addResolution(Resolution resolution) {
		if (resolution.getReference().isMany()) {
			((EList)resolution.getOwner().eGet(resolution.getReference())).add(
					resolution.getReferencedObject());
		} else {
			resolution.getOwner().eSet(resolution.getReference(), 
					resolution.getReferencedObject());
		}
	}

	@Override
	public void executeResolutions() {
		// empty
	}		
}
