/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationLiteralExpression#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationLiteralExpression()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationLiteralExpression extends EvaluationExpression {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(EvaluationLiteral)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationLiteralExpression_Literal()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EvaluationLiteral getLiteral();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationLiteralExpression#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(EvaluationLiteral value);

} // EvaluationLiteralExpression
