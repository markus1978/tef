/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Syntax Sdl Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlIdentifier()
 * @model
 * @generated
 */
public interface ConcreteSyntaxSdlIdentifier extends CoreAbstractionsElementsElement {
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
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlIdentifier_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' containment reference.
	 * @see #setQualifier(ConcreteSyntaxSdlQualifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlIdentifier_Qualifier()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ConcreteSyntaxSdlQualifier getQualifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getQualifier <em>Qualifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' containment reference.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(ConcreteSyntaxSdlQualifier value);

} // ConcreteSyntaxSdlIdentifier
