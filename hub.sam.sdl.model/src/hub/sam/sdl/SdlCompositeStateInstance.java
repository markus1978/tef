/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Composite State Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getActualState <em>Actual State</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getState <em>State</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getInput <em>Input</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getTriggered <em>Triggered</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getSender <em>Sender</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlCompositeStateInstance#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance()
 * @model
 * @generated
 */
public interface SdlCompositeStateInstance extends SdlInstance, CommunicationProcess {
	/**
	 * Returns the value of the '<em><b>Actual State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual State</em>' reference.
	 * @see #setActualState(SdlStateInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_ActualState()
	 * @model required="true"
	 * @generated
	 */
	SdlStateInstance getActualState();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getActualState <em>Actual State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual State</em>' reference.
	 * @see #getActualState()
	 * @generated
	 */
	void setActualState(SdlStateInstance value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference.
	 * @see #setState(SdlStateInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_State()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlStateInstance getState();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getState <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' containment reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(SdlStateInstance value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlInputInstance}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlInputInstance#getOwningStateInstance <em>Owning State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_Input()
	 * @see hub.sam.sdl.SdlInputInstance#getOwningStateInstance
	 * @model opposite="owningStateInstance" containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlInputInstance> getInput();

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentInstance#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_OwningInstance()
	 * @see hub.sam.sdl.SdlAgentInstance#getBehavior
	 * @model opposite="behavior" transient="false" ordered="false"
	 * @generated
	 */
	SdlAgentInstance getOwningInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(SdlAgentInstance value);

	/**
	 * Returns the value of the '<em><b>Triggered</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggered</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggered</em>' containment reference.
	 * @see #setTriggered(SdlInputInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_Triggered()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlInputInstance getTriggered();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getTriggered <em>Triggered</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triggered</em>' containment reference.
	 * @see #getTriggered()
	 * @generated
	 */
	void setTriggered(SdlInputInstance value);

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
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_Sender()
	 * @model ordered="false"
	 * @generated
	 */
	SdlAgentInstance getSender();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(SdlAgentInstance value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.SdlStateStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see hub.sam.sdl.SdlStateStatus
	 * @see #setStatus(SdlStateStatus)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeStateInstance_Status()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlStateStatus getStatus();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeStateInstance#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see hub.sam.sdl.SdlStateStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(SdlStateStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeStates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void executeTransition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void executeAction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sRequired="true" sOrdered="false"
	 * @generated
	 */
	void enterState(SdlState s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void leaveActualState();

} // SdlCompositeStateInstance
