/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlOutput#getSdlOutput_classifier <em>Sdl Output classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlOutput#getVia <em>Via</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlOutput#getType <em>Type</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlOutput#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlOutput()
 * @model
 * @generated
 */
public interface SdlOutput extends SdlAction, InstanciationCreate {
	/**
	 * Returns the value of the '<em><b>Sdl Output classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sdl Output classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sdl Output classifier</em>' reference.
	 * @see #setSdlOutput_classifier(SdlSignal)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOutput_SdlOutput_classifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlSignal getSdlOutput_classifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOutput#getSdlOutput_classifier <em>Sdl Output classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sdl Output classifier</em>' reference.
	 * @see #getSdlOutput_classifier()
	 * @generated
	 */
	void setSdlOutput_classifier(SdlSignal value);

	/**
	 * Returns the value of the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Via</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Via</em>' reference.
	 * @see #setVia(SdlGate)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOutput_Via()
	 * @model ordered="false"
	 * @generated
	 */
	SdlGate getVia();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOutput#getVia <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' reference.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(SdlGate value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SdlSignal)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOutput_Type()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlSignal getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOutput#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SdlSignal value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' containment reference.
	 * @see #setTo(EvaluationExpression)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOutput_To()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getTo();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlOutput#getTo <em>To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' containment reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(EvaluationExpression value);

} // SdlOutput
