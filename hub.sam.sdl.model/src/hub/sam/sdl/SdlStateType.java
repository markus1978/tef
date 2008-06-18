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
 * A representation of the model object '<em><b>Sdl State Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlStateType#getStateAutomaton <em>State Automaton</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlStateType#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateType()
 * @model
 * @generated
 */
public interface SdlStateType extends SdlClassifier, CommunicationCommunicator {
	/**
	 * Returns the value of the '<em><b>State Automaton</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Automaton</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Automaton</em>' containment reference.
	 * @see #setStateAutomaton(SdlStateAutomaton)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateType_StateAutomaton()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlStateAutomaton getStateAutomaton();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlStateType#getStateAutomaton <em>State Automaton</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Automaton</em>' containment reference.
	 * @see #getStateAutomaton()
	 * @generated
	 */
	void setStateAutomaton(SdlStateAutomaton value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateType_State()
	 * @model containment="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<SdlState> getState();

} // SdlStateType
