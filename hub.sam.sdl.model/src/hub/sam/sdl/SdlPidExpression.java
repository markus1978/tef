/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Pid Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlPidExpression#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlPidExpression()
 * @model
 * @generated
 */
public interface SdlPidExpression extends EvaluationExpression {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.SdlPidExpressionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlPidExpressionKind
	 * @see #setKind(SdlPidExpressionKind)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlPidExpression_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlPidExpressionKind getKind();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlPidExpression#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlPidExpressionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SdlPidExpressionKind value);

} // SdlPidExpression
