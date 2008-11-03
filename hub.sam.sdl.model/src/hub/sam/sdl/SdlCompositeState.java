/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlCompositeState#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeState()
 * @model
 * @generated
 */
public interface SdlCompositeState extends CoreAbstractionsTypedElementsTypedElement, SdlState, SdlBehavior {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SdlStateType)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlCompositeState_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlStateType getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlCompositeState#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SdlStateType value);

} // SdlCompositeState
