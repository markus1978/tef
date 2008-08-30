/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;

import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.etsl.ExtendedRule#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.etsl.EtslPackage#getExtendedRule()
 * @model
 * @generated
 */
public interface ExtendedRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(Rhs)
	 * @see hub.sam.tef.etsl.EtslPackage#getExtendedRule_Rhs()
	 * @model containment="true"
	 * @generated
	 */
	Rhs getRhs();

	/**
	 * Sets the value of the '{@link hub.sam.tef.etsl.ExtendedRule#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Rhs value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	EList<SimpleRule> createSimpleRules();

} // ExtendedRule
