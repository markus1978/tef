/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlProcedure#getProcedureStateAutomaton <em>Procedure State Automaton</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlProcedure()
 * @model
 * @generated
 */
public interface SdlProcedure extends CoreAbstractionsBehavioralFeaturesBehavioralFeature, CoreAbstractionsTypedElementsTypedElement, SdlBehaviorElement, SdlClassifier {
	/**
	 * Returns the value of the '<em><b>Procedure State Automaton</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure State Automaton</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure State Automaton</em>' containment reference.
	 * @see #setProcedureStateAutomaton(SdlStateAutomaton)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlProcedure_ProcedureStateAutomaton()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlStateAutomaton getProcedureStateAutomaton();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlProcedure#getProcedureStateAutomaton <em>Procedure State Automaton</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure State Automaton</em>' containment reference.
	 * @see #getProcedureStateAutomaton()
	 * @generated
	 */
	void setProcedureStateAutomaton(SdlStateAutomaton value);

} // SdlProcedure
