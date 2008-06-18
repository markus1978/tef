/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Signal Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlSignalInstance#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlSignalInstance#getSender <em>Sender</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlSignalInstance#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlSignalInstance()
 * @model
 * @generated
 */
public interface SdlSignalInstance extends CommunicationEvent, SdlInstance {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(SdlVariableSlot)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSignalInstance_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	SdlVariableSlot getParameter();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSignalInstance#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(SdlVariableSlot value);

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSignalInstance_Sender()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlAgentInstance getSender();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSignalInstance#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(SdlAgentInstance value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' reference.
	 * @see #setReceiver(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSignalInstance_Receiver()
	 * @model ordered="false"
	 * @generated
	 */
	SdlAgentInstance getReceiver();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSignalInstance#getReceiver <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(SdlAgentInstance value);

} // SdlSignalInstance
