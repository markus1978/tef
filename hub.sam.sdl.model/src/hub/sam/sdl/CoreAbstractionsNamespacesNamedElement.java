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
 * A representation of the model object '<em><b>Core Abstractions Namespaces Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsNamespacesNamedElement extends CoreAbstractionsOwnershipsElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamedElement_Name()
	 * @model ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamedElement_QualifiedName()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see #setNamespace(CoreAbstractionsNamespacesNamespace)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamedElement_Namespace()
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getOwnedMember
	 * @model opposite="ownedMember" transient="false" derived="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsNamespacesNamespace getNamespace();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace <em>Namespace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' container reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(CoreAbstractionsNamespacesNamespace value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(ConcreteSyntaxSdlIdentifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsNamespacesNamedElement_Identifier()
	 * @model ordered="false"
	 * @generated
	 */
	ConcreteSyntaxSdlIdentifier getIdentifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(ConcreteSyntaxSdlIdentifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamespace> allNamespaces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nRequired="true" nOrdered="false" nsRequired="true" nsOrdered="false"
	 * @generated
	 */
	boolean isDistinguishableFrom(CoreAbstractionsNamespacesNamedElement n, CoreAbstractionsNamespacesNamespace ns);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String separator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String qualifiedName();

} // CoreAbstractionsNamespacesNamedElement
