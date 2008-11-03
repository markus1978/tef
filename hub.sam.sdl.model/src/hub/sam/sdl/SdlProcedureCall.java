/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlProcedureCall#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlProcedureCall()
 * @model
 * @generated
 */
public interface SdlProcedureCall extends EvaluationBehavioralFeatureAccessExpression, InstanciationCreate, SdlAction {
	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' reference.
	 * @see #setProcedure(SdlProcedure)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlProcedureCall_Procedure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlProcedure getProcedure();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlProcedureCall#getProcedure <em>Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure</em>' reference.
	 * @see #getProcedure()
	 * @generated
	 */
	void setProcedure(SdlProcedure value);

} // SdlProcedureCall
