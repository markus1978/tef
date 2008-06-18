/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Typed Elements Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsTypedElementsTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsTypedElementsTypedElement extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CoreAbstractionsTypedElementsType)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsTypedElementsTypedElement_Type()
	 * @model ordered="false"
	 * @generated
	 */
	CoreAbstractionsTypedElementsType getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CoreAbstractionsTypedElementsType value);

} // CoreAbstractionsTypedElementsTypedElement
