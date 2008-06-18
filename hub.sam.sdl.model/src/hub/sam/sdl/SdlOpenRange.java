/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Open Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlOpenRange#getOperation <em>Operation</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlOpenRange#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlOpenRange()
 * @model
 * @generated
 */
public interface SdlOpenRange extends SdlRange {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(SdlOperation)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOpenRange_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlOperation getOperation();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOpenRange#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(SdlOperation value);

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
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOpenRange_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getExpression();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOpenRange#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(EvaluationExpression value);

} // SdlOpenRange
