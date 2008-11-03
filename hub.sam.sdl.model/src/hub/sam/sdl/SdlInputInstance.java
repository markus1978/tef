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
	 * Returns the value of the '<em><b>Owning State Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlCompositeStateInstance#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning State Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning State Instance</em>' container reference.
	 * @see #setOwningStateInstance(SdlCompositeStateInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInputInstance_OwningStateInstance()
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getInput
	 * @model opposite="input" transient="false" ordered="false"
	 * @generated
	 */
	SdlCompositeStateInstance getOwningStateInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlInputInstance#getOwningStateInstance <em>Owning State Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State Instance</em>' container reference.
	 * @see #getOwningStateInstance()
	 * @generated
	 */
	void setOwningStateInstance(SdlCompositeStateInstance value);

} // SdlInputInstance
