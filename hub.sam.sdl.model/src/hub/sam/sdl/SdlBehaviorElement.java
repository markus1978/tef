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
 *   <li>{@link hub.sam.sdl.SdlBehaviorElement#getBehavior <em>Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlBehaviorElement()
 * @model abstract="true"
 * @generated
 */
public interface SdlBehaviorElement extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(SdlBehavior)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlBehaviorElement_Behavior()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlBehavior getBehavior();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlBehaviorElement#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(SdlBehavior value);

} // SdlBehaviorElement
