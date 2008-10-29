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
 * A representation of the model object '<em><b>Core Abstractions Ownerships Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedComment <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsOwnershipsElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsOwnershipsElement extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Element</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsOwnershipsElement_OwnedElement()
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner
	 * @model opposite="owner" containment="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getOwnedElement();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(CoreAbstractionsOwnershipsElement)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsOwnershipsElement_Owner()
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedElement
	 * @model opposite="ownedElement" transient="false" derived="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsOwnershipsElement getOwner();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(CoreAbstractionsOwnershipsElement value);

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsCommentsComment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Comment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsOwnershipsElement_OwnedComment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsCommentsComment> getOwnedComment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> allOwnedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean mustBeOwned();

} // CoreAbstractionsOwnershipsElement
