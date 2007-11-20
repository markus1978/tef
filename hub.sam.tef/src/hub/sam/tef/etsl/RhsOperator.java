/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhs Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.etsl.RhsOperator#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.etsl.EtslPackage#getRhsOperator()
 * @model
 * @generated
 */
public interface RhsOperator extends Rhs {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(Rhs)
	 * @see hub.sam.tef.etsl.EtslPackage#getRhsOperator_Operand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Rhs getOperand();

	/**
	 * Sets the value of the '{@link hub.sam.tef.etsl.RhsOperator#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(Rhs value);

} // RhsOperator
