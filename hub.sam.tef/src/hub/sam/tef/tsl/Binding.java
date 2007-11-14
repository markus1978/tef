/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Binding#getBindingId <em>Binding Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Id</em>' attribute.
	 * @see #setBindingId(String)
	 * @see hub.sam.tef.tsl.TslPackage#getBinding_BindingId()
	 * @model
	 * @generated
	 */
	String getBindingId();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Binding#getBindingId <em>Binding Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Id</em>' attribute.
	 * @see #getBindingId()
	 * @generated
	 */
	void setBindingId(String value);

} // Binding
