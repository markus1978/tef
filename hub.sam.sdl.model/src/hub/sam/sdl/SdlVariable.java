/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlVariable#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlVariable()
 * @model
 * @generated
 */
public interface SdlVariable extends CoreAbstractionsStructuralFeaturesStructuralFeature, CoreAbstractionsTypedElementsTypedElement {
	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(EvaluationExpression)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlVariable_InitExpression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getInitExpression();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlVariable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(EvaluationExpression value);

} // SdlVariable
