/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CommunicationInput#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationInput()
 * @model abstract="true"
 * @generated
 */
public interface CommunicationInput extends CoreAbstractionsClassifiersFeature, CoreAbstractionsTypedElementsTypedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CommunicationEventType)
	 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationInput_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CommunicationEventType getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CommunicationInput#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CommunicationEventType value);

} // CommunicationInput
