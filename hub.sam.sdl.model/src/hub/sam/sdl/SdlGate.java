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
 * A representation of the model object '<em><b>Sdl Gate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlGate#getReceive <em>Receive</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlGate#getSend <em>Send</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlGate#getChannelEnd <em>Channel End</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlGate#getAgentType <em>Agent Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlGate()
 * @model
 * @generated
 */
public interface SdlGate extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Receive</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlSignal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlGate_Receive()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SdlSignal> getReceive();

	/**
	 * Returns the value of the '<em><b>Send</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlSignal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlGate_Send()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SdlSignal> getSend();

	/**
	 * Returns the value of the '<em><b>Channel End</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlChannelEnd}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannelEnd#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel End</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlGate_ChannelEnd()
	 * @see hub.sam.sdl.SdlChannelEnd#getGate
	 * @model opposite="gate" ordered="false"
	 * @generated
	 */
	EList<SdlChannelEnd> getChannelEnd();

	/**
	 * Returns the value of the '<em><b>Agent Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentType#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Type</em>' container reference.
	 * @see #setAgentType(SdlAgentType)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlGate_AgentType()
	 * @see hub.sam.sdl.SdlAgentType#getGate
	 * @model opposite="gate" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SdlAgentType getAgentType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlGate#getAgentType <em>Agent Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Type</em>' container reference.
	 * @see #getAgentType()
	 * @generated
	 */
	void setAgentType(SdlAgentType value);

} // SdlGate
