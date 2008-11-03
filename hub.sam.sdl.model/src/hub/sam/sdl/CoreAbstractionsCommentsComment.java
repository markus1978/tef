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
 * A representation of the model object '<em><b>Core Abstractions Comments Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsCommentsComment#getBody <em>Body</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsCommentsComment#getAnnotatedElement <em>Annotated Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsCommentsComment()
 * @model
 * @generated
 */
public interface CoreAbstractionsCommentsComment extends CoreAbstractionsOwnershipsElement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsCommentsComment_Body()
	 * @model ordered="false"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsCommentsComment#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Annotated Element</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsCommentsComment_AnnotatedElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getAnnotatedElement();

} // CoreAbstractionsCommentsComment
