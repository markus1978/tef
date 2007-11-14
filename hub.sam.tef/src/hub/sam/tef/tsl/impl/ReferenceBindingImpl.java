/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReferenceBindingImpl extends PropertyBindingImpl implements ReferenceBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.REFERENCE_BINDING;
	}
	
	@Override
	public String toString() {
		if (getProperty() == null) {
			return "reference(null)";
		} else {
			return "reference(" + getProperty().getName() + ")";
		}
	}
} //ReferenceBindingImpl
