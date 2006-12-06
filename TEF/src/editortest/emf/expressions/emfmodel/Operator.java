/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link editortest.emf.expressions.emfmodel.Operator#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link editortest.emf.expressions.emfmodel.Operator#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getOperator()
 * @model abstract="true"
 * @generated
 */
public interface Operator extends Expression {
	/**
	 * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand1</em>' containment reference.
	 * @see #setOperand1(Expression)
	 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getOperator_Operand1()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOperand1();

	/**
	 * Sets the value of the '{@link editortest.emf.expressions.emfmodel.Operator#getOperand1 <em>Operand1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand1</em>' containment reference.
	 * @see #getOperand1()
	 * @generated
	 */
	void setOperand1(Expression value);

	/**
	 * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand2</em>' containment reference.
	 * @see #setOperand2(Expression)
	 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getOperator_Operand2()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOperand2();

	/**
	 * Sets the value of the '{@link editortest.emf.expressions.emfmodel.Operator#getOperand2 <em>Operand2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand2</em>' containment reference.
	 * @see #getOperand2()
	 * @generated
	 */
	void setOperand2(Expression value);

} // Operator