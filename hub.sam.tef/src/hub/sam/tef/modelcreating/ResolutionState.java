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

import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.util.ModelObjectPropertiesValueIterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * When a parse-tree is navigated to perform reference resolution, a resolution
 * state is used to read a model simultaneously. Each resolution state always
 * only used to navigate a single model object. While a navigated parse-tree
 * represents many model objects, the used resolution states are evolving. This
 * means during stepping down the parse-tree new states are created from old
 * ones and the actual state is notified, when a stepped into parse node
 * represents a different mode object than the last state (see
 * {@link this#acceptLooseActual()}, {@link this#setLooseActual(EObject)},
 * {@link this#setLooseActualArbitray(Object)}.
 * 
 * When symbols (or respective parse-tree nodes) with certain property bindings
 * are visited, the properties are read from the corresponding model element.
 * Which values have already been read is stored in a resolution state. A
 * resolution state therefore allows to iterate to multi-valued properties
 * implicitly. Each time a value is read from this state, internal iterators are
 * stepped through. Successful usage of such a state, require that the
 * parse-tree actually matched the model, i.e. each property contains as many
 * values as there are parse tree nodes representing these property values.
 */
public class ResolutionState {

	/**
	 * This is the model object currently active. All property values are read
	 * from this object.
	 */
	private Object actual = null;
	/**
	 * This is the model object that might become active. The problem is that
	 * when a parse tree is navigated and a composite binding is discovered a
	 * new model object is read from the actual object and this new object might
	 * become active while the child node that represents the property value is
	 * navigated. But this new "child" value is not immediatly the new actual,
	 * but only if a corresponding value binding within the sub-tree that
	 * represents the property value is detected. For all nodes in between
	 * (between property binding and corresponding value binding) the old model
	 * object is still the actual.
	 */
	private Object looseActual = null;
	
	/**
	 * This iterator is used to iterate through the properties of the actual
	 * model value.
	 */
	private ModelObjectPropertiesValueIterator fIterator = null;
	private ModelObjectPropertiesValueIterator iteratorFactory = null;
	
	public ResolutionState(Object looseActual, ModelObjectPropertiesValueIterator factory) {
		super();
		this.looseActual = looseActual;
		this.iteratorFactory = factory;
	}
	
	/**
	 * Creates a new state from an existing state. This is to copy a state. When
	 * a sub-tree is visited a copy can be used to not loose the actual state
	 * (needed for all the sibling sub-trees) due to modifications during
	 * visiting the sub-tree.
	 */
	public ResolutionState(ResolutionState oldState) {
		super();
		actual = oldState.actual;
		iteratorFactory = oldState.iteratorFactory;
		if (oldState.fIterator != null) {
			fIterator = oldState.fIterator.createIterator();
		}
		looseActual = oldState.looseActual;
	}
	
	/**
	 * @return the actual active model object that all the property values are
	 *         read from.
	 */
	public Object getActual() {
		return actual;
	}
	
	/**
	 * Sets the new potential actual object. This is done when a property value
	 * is read. This potential loose actual becomes the real actual when the
	 * corresponding value binding is detected.
	 */
	public void setLooseActual(EObject looseActual) {
		this.looseActual = looseActual;		
	}
	
	/**
	 * Sets the new potential actual object. This is done when a property value
	 * is read. This potential loose actual becomes the real actual when the
	 * corresponding value binding is detected. The loose actual may be an
	 * arbitrary object. This method allows to set arbitrary object value,
	 * e.g. Integer, instead of EObject values only.
	 * 
	 * @author Dirk Fahland
	 */
	public void setLooseActualArbitrary(Object looseActual) {
		this.looseActual = looseActual;
		// TODO: do we need special treatment here?
	}
	
	/**
	 * When the value binding that corresponds to the loose actual is detected,
	 * the potential loose actual becomes the real actual.
	 * 
	 * @param binding
	 *            the binding is used to verify the type of the loose actual.
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	public void acceptLooseActual(ValueBinding binding) {
		if (looseActual != null && binding instanceof ElementBinding) {
			EClass metaClass = ((ElementBinding)binding).getMetaclass();
			Assert.isTrue(metaClass.getInstanceClass().isAssignableFrom(looseActual.getClass()));
		}
		actual = looseActual;

		if (actual instanceof EObject)
			fIterator = iteratorFactory.createIterator((EObject)actual);
		else
			fIterator = null;	// no standard iterator for arbitrary objects
		
		looseActual = null;
	}	
	
	/**
	 * Reads the next value from a property.
	 * 
	 * @param binding
	 *            is the binding that provides the property (TODO, why not use
	 *            the property directly).
	 * @return the next value of the property. For single valued properties,
	 *         this value is returned, no matter how often this value is read.
	 * @throws ArrayIndexOutOfBoundsException,
	 *             if there is no next property value.
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	public Object getValueForBinding(PropertyBinding binding) {
		if (fIterator != null)
			return fIterator.next(binding.getProperty());
		else
			throw new ArrayIndexOutOfBoundsException("trying to access property of object "+actual+" that has no iterator.");
	}
}
