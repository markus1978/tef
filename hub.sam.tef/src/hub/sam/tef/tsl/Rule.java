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
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Rule#getLhs <em>Lhs</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Rule#getValueBinding <em>Value Binding</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Rule#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getRule()
 * @model abstract="true"
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(NonTerminal)
	 * @see hub.sam.tef.tsl.TslPackage#getRule_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NonTerminal getLhs();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Rule#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(NonTerminal value);

	/**
	 * Returns the value of the '<em><b>Value Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Binding</em>' containment reference.
	 * @see #setValueBinding(ValueBinding)
	 * @see hub.sam.tef.tsl.TslPackage#getRule_ValueBinding()
	 * @model containment="true"
	 * @generated
	 */
	ValueBinding getValueBinding();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Rule#getValueBinding <em>Value Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Binding</em>' containment reference.
	 * @see #getValueBinding()
	 * @generated
	 */
	void setValueBinding(ValueBinding value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see hub.sam.tef.tsl.TslPackage#getRule_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Rule#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="hub.sam.tef.tsl.RccRule" required="true"
	 * @generated
	 */
	hub.sam.tef.rcc.syntax.Rule getRCCRule();

} // Rule
