/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Create</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlCreate#getAgent <em>Agent</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCreate#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlCreate()
 * @model
 * @generated
 */
public interface SdlCreate extends InstanciationCreate, SdlAction {
	/**
	 * Returns the value of the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent</em>' reference.
	 * @see #setAgent(SdlAgent)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCreate_Agent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlAgent getAgent();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCreate#getAgent <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent</em>' reference.
	 * @see #getAgent()
	 * @generated
	 */
	void setAgent(SdlAgent value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(SdlAgentType)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCreate_Classifier()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlAgentType getClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCreate#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(SdlAgentType value);

} // SdlCreate
