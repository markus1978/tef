/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parenthesis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link editortest.emf.expressions.emfmodel.Parenthesis#getSubexpression <em>Subexpression</em>}</li>
 * </ul>
 * </p>
 *
 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getParenthesis()
 * @model
 * @generated
 */
public interface Parenthesis extends Expression {
	/**
	 * Returns the value of the '<em><b>Subexpression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subexpression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subexpression</em>' containment reference.
	 * @see #setSubexpression(Expression)
	 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getParenthesis_Subexpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getSubexpression();

	/**
	 * Sets the value of the '{@link editortest.emf.expressions.emfmodel.Parenthesis#getSubexpression <em>Subexpression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subexpression</em>' containment reference.
	 * @see #getSubexpression()
	 * @generated
	 */
	void setSubexpression(Expression value);

} // Parenthesis