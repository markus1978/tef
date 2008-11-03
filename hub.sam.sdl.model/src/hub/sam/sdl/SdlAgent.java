/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAgent#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgent()
 * @model
 * @generated
 */
public interface SdlAgent extends CoreAbstractionsTypedElementsTypedElement, InstanciationMultiplicityFeature, CommunicationMedium {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SdlAgentType)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgent_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlAgentType getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgent#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SdlAgentType value);

} // SdlAgent
