/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlBehaviorElement#getSdlBehaviorElement_behavior <em>Sdl Behavior Element behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlBehaviorElement()
 * @model abstract="true"
 * @generated
 */
public interface SdlBehaviorElement extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Sdl Behavior Element behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sdl Behavior Element behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sdl Behavior Element behavior</em>' containment reference.
	 * @see #setSdlBehaviorElement_behavior(SdlBehavior)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlBehaviorElement_SdlBehaviorElement_behavior()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlBehavior getSdlBehaviorElement_behavior();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlBehaviorElement#getSdlBehaviorElement_behavior <em>Sdl Behavior Element behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sdl Behavior Element behavior</em>' containment reference.
	 * @see #getSdlBehaviorElement_behavior()
	 * @generated
	 */
	void setSdlBehaviorElement_behavior(SdlBehavior value);

} // SdlBehaviorElement
