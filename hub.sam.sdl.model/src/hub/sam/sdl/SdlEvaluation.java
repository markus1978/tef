/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlEvaluation#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlEvaluation()
 * @model abstract="true"
 * @generated
 */
public interface SdlEvaluation extends EvaluationEvaluation {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(SdlInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlEvaluation_Context()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlInstance getContext();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlEvaluation#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SdlInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model cRequired="true" cOrdered="false"
	 * @generated
	 */
	void updateContext(SdlInstance c);

} // SdlEvaluation
