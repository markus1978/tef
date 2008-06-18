/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Input Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlInputInstance#getOwningStateInstance <em>Owning State Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlInputInstance()
 * @model
 * @generated
 */
public interface SdlInputInstance extends CommunicationListener {
	/**
	 * Returns the value of the '<em><b>Owning State Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning State Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning State Instance</em>' reference.
	 * @see #setOwningStateInstance(SdlCompositeStateInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInputInstance_OwningStateInstance()
	 * @model ordered="false"
	 * @generated
	 */
	SdlCompositeStateInstance getOwningStateInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlInputInstance#getOwningStateInstance <em>Owning State Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State Instance</em>' reference.
	 * @see #getOwningStateInstance()
	 * @generated
	 */
	void setOwningStateInstance(SdlCompositeStateInstance value);

} // SdlInputInstance
