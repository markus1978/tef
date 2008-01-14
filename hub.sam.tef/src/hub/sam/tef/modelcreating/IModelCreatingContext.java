package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.util.IAdaptable;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
public interface IModelCreatingContext extends IAdaptable {

	/**
	 * Adds a given object to the model resource in this context.
	 */
	public void addCreatedObject(EObject object);
	
	/**
	 * A data type used to characterise a resolution. A resolution describes a
	 * resolved reference between an owner and a referenced object based on a
	 * reference feature.
	 */
	public class Resolution {
		private final EObject fOwner;
		private final EObject fReferencedObject;
		private final EReference fReference;
		public Resolution(EObject owner, EObject referencedObject,
				EReference reference) {
			super();
			fOwner = owner;
			fReferencedObject = referencedObject;
			fReference = reference;
		}
		public EObject getOwner() {
			return fOwner;
		}
		public EObject getReferencedObject() {
			return fReferencedObject;
		}
		public EReference getReference() {
			return fReference;
		}		
		
	}
	
	/**
	 * Adds a resolution to the states. Resolved references are not set
	 * right-away; resolutions are collected and then executed within a single
	 * command.
	 */
	public void addResolution(Resolution resolution);
		
	/**
	 * Executes all collected resolution at once.
	 */
	public void executeResolutions();
	
	
	/**
	 * Returns the resource with all the edited model. Do not modify this
	 * directly.
	 */
	public Resource getResource();

	/**
	 * @return the text that the model is created from.
	 */
	public String getText();
	
	public ISemanticsProvider getSemanticsProvider();
	
	/**
	 * Adds an error to the context. These errors are used to be displayed to
	 * the user via an editor.
	 */
	public void addError(AbstractError error);	
	
	public Collection<AbstractError> getErrors();
	
	/**
	 * @return the parse tree node that represent the given object. The object
	 *         must be created within this context.
	 */
	public ParseTreeRuleNode getTreeNodeForObject(EObject object);	
	
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
	public void trace(EObject source, EObject target);
	
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
	public EObject instantiate(EClass metaClass, ParseTreeRuleNode node) 
			throws ModelCreatingException;	
}
