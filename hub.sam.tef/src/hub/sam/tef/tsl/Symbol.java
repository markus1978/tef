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
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Symbol#getPropertyBinding <em>Property Binding</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Symbol#getActionBinding <em>Action Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getSymbol()
 * @model abstract="true"
 * @generated
 */
public interface Symbol extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Binding</em>' containment reference.
	 * @see #setPropertyBinding(PropertyBinding)
	 * @see hub.sam.tef.tsl.TslPackage#getSymbol_PropertyBinding()
	 * @model containment="true"
	 * @generated
	 */
	PropertyBinding getPropertyBinding();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Symbol#getPropertyBinding <em>Property Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Binding</em>' containment reference.
	 * @see #getPropertyBinding()
	 * @generated
	 */
	void setPropertyBinding(PropertyBinding value);

	/**
	 * Returns the value of the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Binding</em>' containment reference.
	 * @see #setActionBinding(ActionBinding)
	 * @see hub.sam.tef.tsl.TslPackage#getSymbol_ActionBinding()
	 * @model containment="true"
	 * @generated
	 */
	ActionBinding getActionBinding();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Symbol#getActionBinding <em>Action Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Binding</em>' containment reference.
	 * @see #getActionBinding()
	 * @generated
	 */
	void setActionBinding(ActionBinding value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getRCCSymbol();

} // Symbol
