/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAssignment#getExpression <em>Expression</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAssignment#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAssignment()
 * @model
 * @generated
 */
public interface SdlAssignment extends SdlAction {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(EvaluationExpression)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAssignment_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getExpression();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAssignment#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(EvaluationExpression value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(SdlVariable)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAssignment_Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlVariable getVariable();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAssignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(SdlVariable value);

} // SdlAssignment
