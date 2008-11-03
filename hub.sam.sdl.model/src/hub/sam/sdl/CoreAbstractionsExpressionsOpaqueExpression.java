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
 * A representation of the model object '<em><b>Core Abstractions Expressions Opaque Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getBody <em>Body</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsOpaqueExpression()
 * @model
 * @generated
 */
public interface CoreAbstractionsExpressionsOpaqueExpression extends CoreAbstractionsExpressionsValueSpecification {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsOpaqueExpression_Body()
	 * @model
	 * @generated
	 */
	EList<String> getBody();

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsOpaqueExpression_Language()
	 * @model
	 * @generated
	 */
	EList<String> getLanguage();

} // CoreAbstractionsExpressionsOpaqueExpression
