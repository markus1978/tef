/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Syntax Sdl Path Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getKind <em>Kind</em>}</li>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlPathItem()
 * @model
 * @generated
 */
public interface ConcreteSyntaxSdlPathItem extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind
	 * @see #setKind(ConcreteSyntaxSdlScopeUnitKind)
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlPathItem_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConcreteSyntaxSdlScopeUnitKind getKind();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ConcreteSyntaxSdlScopeUnitKind value);

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
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlPathItem_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ConcreteSyntaxSdlPathItem
