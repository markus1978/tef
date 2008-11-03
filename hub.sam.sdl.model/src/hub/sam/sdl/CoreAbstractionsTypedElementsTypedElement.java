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
 *   <li>{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getTypedElement_type <em>Typed Element type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsTypedElementsTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsTypedElementsTypedElement extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Element type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Element type</em>' reference.
	 * @see #setTypedElement_type(CoreAbstractionsTypedElementsType)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsTypedElementsTypedElement_TypedElement_type()
	 * @model ordered="false"
	 * @generated
	 */
	CoreAbstractionsTypedElementsType getTypedElement_type();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getTypedElement_type <em>Typed Element type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Element type</em>' reference.
	 * @see #getTypedElement_type()
	 * @generated
	 */
	void setTypedElement_type(CoreAbstractionsTypedElementsType value);

} // CoreAbstractionsTypedElementsTypedElement
