/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
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

package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.util.IAdaptable;
import hub.sam.tef.util.MultiMap;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Position;

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
	 * @return all object in the edited resource and in related resources. This
	 *         is used for content assist and reference resolution.
	 */
	public Iterable<Object> getAllContents();

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
	
	public MultiMap<EObject, Position> getOccurences();
	
	public void addOccurence(EObject object, Position position);
	
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
	
	public EPackage[] getMetaModelPackages();
	
	public enum ActionStatementEvaluationTime { create, resolve };
	
	/**
	 * Evaluates a method for non-local changes in the model creation context.
	 * The method name and its parameters are given as parameters to this method.
	 * An implementation must resolve the method name to an existing method in an
	 * existing class. The evaluating method may have a return result
	 * 
	 * @param methodName
	 *				is the name of the called method and is resolved to an existing
	 *				method.
	 * @param methodParameters
	 * 				is a list of parameters that are passed to the called method
	 * @return
	 */
	public Object evaluateActionStatement(String methodName, EList<Object> methodParameters,
			ActionStatementEvaluationTime time) throws ModelCreatingException;
	
	/**
	 * Evaluates a method for non-local changes in the model creation context.
	 * The method name and its parameters are given as parameters to this
	 * method. An implementation must resolve the method name to an existing
	 * method in an existing class. The evaluating method may have a return
	 * result
	 * 
	 * @deprecated this method is called during resolution. Use
	 *             {@link #evaluateActionStatement(String, EList, hub.sam.tef.modelcreating.IModelCreatingContext.ActionStatementEvaluationTime)}
	 *             instead, which allows to control execution time due to its
	 *             time parameter.
	 * 
	 * @param methodName
	 *            is the name of the called method and is resolved to an
	 *            existing method.
	 * @param methodParameters
	 *            is a list of parameters that are passed to the called method
	 * @return
	 */
	public Object evaluateActionStatement (String methodName, EList<Object> methodParameters)
			throws ModelCreatingException;
	
	/**
	 * This method is responsible to loosen all java references of contained objects to
	 * all this context and all contained objects to be garbage collected.
	 */
	public void destroy();
}
