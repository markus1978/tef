/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Constraints Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsConstraintsNamedElement extends CoreAbstractionsOwnershipsElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see #setNamespace(CoreAbstractionsConstraintsNamespace)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsNamedElement_Namespace()
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedMember
	 * @model opposite="ownedMember" transient="false" derived="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsConstraintsNamespace getNamespace();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace <em>Namespace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' container reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(CoreAbstractionsConstraintsNamespace value);

} // CoreAbstractionsConstraintsNamedElement
