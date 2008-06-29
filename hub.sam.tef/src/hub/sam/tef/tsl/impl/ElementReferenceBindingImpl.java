/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.ElementReferenceBinding;
import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Reference Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ElementReferenceBindingImpl extends ElementBindingImpl implements ElementReferenceBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementReferenceBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.ELEMENT_REFERENCE_BINDING;
	}

	@Override
	public String toString() {
		if (getMetaclass() == null) {
			return "elementRef(null)";
		} else {
			return "elementRef(" + getMetaclass().getName() + ")";
		}
	}	
} //ElementReferenceBindingImpl
