/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CompositeBindingImpl extends PropertyBindingImpl implements CompositeBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.COMPOSITE_BINDING;
	}

	@Override
	public String toString() {
		if (getProperty() == null) {
			return "composite(null)";
		} else {
			return "composite(" + getProperty().getName() + ")";
		}
	}
	
} //CompositeBindingImpl
