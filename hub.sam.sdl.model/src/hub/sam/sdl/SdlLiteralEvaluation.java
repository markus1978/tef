/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Literal Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlLiteralEvaluation#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlLiteralEvaluation()
 * @model
 * @generated
 */
public interface SdlLiteralEvaluation extends SdlEvaluation {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(SdlDataValue)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlLiteralEvaluation_Value()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlDataValue getValue();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlLiteralEvaluation#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(SdlDataValue value);

} // SdlLiteralEvaluation
