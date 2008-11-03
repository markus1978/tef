/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Channel End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlChannelEnd#getAgent <em>Agent</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelEnd#getGate <em>Gate</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelEnd#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelEnd#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelEnd()
 * @model
 * @generated
 */
public interface SdlChannelEnd extends CoreAbstractionsOwnershipsElement {
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
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelEnd_Agent()
	 * @model ordered="false"
	 * @generated
	 */
	SdlAgent getAgent();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelEnd#getAgent <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent</em>' reference.
	 * @see #getAgent()
	 * @generated
	 */
	void setAgent(SdlAgent value);

	/**
	 * Returns the value of the '<em><b>Gate</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlGate#getChannelEnd <em>Channel End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gate</em>' reference.
	 * @see #setGate(SdlGate)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelEnd_Gate()
	 * @see hub.sam.sdl.SdlGate#getChannelEnd
	 * @model opposite="channelEnd" ordered="false"
	 * @generated
	 */
	SdlGate getGate();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelEnd#getGate <em>Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gate</em>' reference.
	 * @see #getGate()
	 * @generated
	 */
	void setGate(SdlGate value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(SdlChannelEnd)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelEnd_Opposite()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	SdlChannelEnd getOpposite();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelEnd#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(SdlChannelEnd value);

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannelPath#getRelatedElement <em>Related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' container reference.
	 * @see #setChannel(SdlChannelPath)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelEnd_Channel()
	 * @see hub.sam.sdl.SdlChannelPath#getRelatedElement
	 * @model opposite="relatedElement" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SdlChannelPath getChannel();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelEnd#getChannel <em>Channel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' container reference.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(SdlChannelPath value);

} // SdlChannelEnd
