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
 * A representation of the model object '<em><b>Core Abstractions Constraints Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedRule <em>Owned Rule</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamespace()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsConstraintsNamespace extends CoreAbstractionsConstraintsNamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Rule</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Rule</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamespace_OwnedRule()
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext
	 * @model opposite="context" containment="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsConstraintsConstraint> getOwnedRule();

	/**
	 * Returns the value of the '<em><b>Owned Member</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Member</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Member</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamespace_OwnedMember()
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace
	 * @model opposite="namespace" containment="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsConstraintsNamedElement> getOwnedMember();

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamespace_Member()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsConstraintsNamedElement> getMember();

} // CoreAbstractionsConstraintsNamespace
