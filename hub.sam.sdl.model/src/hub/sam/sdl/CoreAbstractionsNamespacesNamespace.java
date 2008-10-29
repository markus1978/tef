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
 * A representation of the model object '<em><b>Core Abstractions Namespaces Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamespace()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsNamespacesNamespace extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Member</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Member</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Member</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamespace_OwnedMember()
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace
	 * @model opposite="namespace" containment="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember();

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamespace_Member()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> getMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true" elementOrdered="false"
	 * @generated
	 */
	EList<String> getNamesOfMember(CoreAbstractionsNamespacesNamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean membersAreDistinguishable();

} // CoreAbstractionsNamespacesNamespace
