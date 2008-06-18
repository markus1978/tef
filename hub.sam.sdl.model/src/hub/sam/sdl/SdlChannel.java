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
 * A representation of the model object '<em><b>Sdl Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlChannel#getPath <em>Path</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannel#getAgentType <em>Agent Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannel()
 * @model
 * @generated
 */
public interface SdlChannel extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlChannelPath}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannelPath#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannel_Path()
	 * @see hub.sam.sdl.SdlChannelPath#getChannel
	 * @model opposite="channel" containment="true" required="true" upper="2" ordered="false"
	 * @generated
	 */
	EList<SdlChannelPath> getPath();

	/**
	 * Returns the value of the '<em><b>Agent Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentType#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Type</em>' container reference.
	 * @see #setAgentType(SdlAgentType)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannel_AgentType()
	 * @see hub.sam.sdl.SdlAgentType#getChannel
	 * @model opposite="channel" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SdlAgentType getAgentType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannel#getAgentType <em>Agent Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Type</em>' container reference.
	 * @see #getAgentType()
	 * @generated
	 */
	void setAgentType(SdlAgentType value);

} // SdlChannel
