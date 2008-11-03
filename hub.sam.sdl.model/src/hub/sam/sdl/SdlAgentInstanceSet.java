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
 * A representation of the model object '<em><b>Sdl Agent Instance Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAgentInstanceSet#getValue <em>Value</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstanceSet#getProcess <em>Process</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstanceSet#getInputQueue <em>Input Queue</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance <em>Agent Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstanceSet()
 * @model
 * @generated
 */
public interface SdlAgentInstanceSet extends InstanciationSlot, CommunicationContext {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAgentInstance}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet <em>Owning Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstanceSet_Value()
	 * @see hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet
	 * @model opposite="owningInstanceSet" containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAgentInstance> getValue();

	/**
	 * Returns the value of the '<em><b>Process</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlCompositeStateInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstanceSet_Process()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<SdlCompositeStateInstance> getProcess();

	/**
	 * Returns the value of the '<em><b>Input Queue</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlSignalInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Queue</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Queue</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstanceSet_InputQueue()
	 * @model containment="true"
	 * @generated
	 */
	EList<SdlSignalInstance> getInputQueue();

	/**
	 * Returns the value of the '<em><b>Agent Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet <em>Agent Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Instance</em>' container reference.
	 * @see #setAgentInstance(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstanceSet_AgentInstance()
	 * @see hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet
	 * @model opposite="agentInstanceSet" transient="false" ordered="false"
	 * @generated
	 */
	SdlAgentInstance getAgentInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance <em>Agent Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Instance</em>' container reference.
	 * @see #getAgentInstance()
	 * @generated
	 */
	void setAgentInstance(SdlAgentInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model agentRequired="true" agentOrdered="false"
	 * @generated
	 */
	void terminate(SdlAgentInstance agent);

} // SdlAgentInstanceSet
