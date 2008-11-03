/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlSet#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlSet#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlSet()
 * @model
 * @generated
 */
public interface SdlSet extends SdlOutput {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(SdlTimer)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSet_Classifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlTimer getClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSet#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(SdlTimer value);

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
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSet_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getExpression();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSet#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(EvaluationExpression value);

} // SdlSet
