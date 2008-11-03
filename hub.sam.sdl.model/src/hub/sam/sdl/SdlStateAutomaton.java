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
 * A representation of the model object '<em><b>Sdl State Automaton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlStateAutomaton#getState <em>State</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlStateAutomaton#getTransition <em>Transition</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlStateAutomaton#getNamedState <em>Named State</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlStateAutomaton#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateAutomaton()
 * @model
 * @generated
 */
public interface SdlStateAutomaton extends SdlBehavior, CoreAbstractionsNamespacesNamespace {
	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAbstractState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateAutomaton_State()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAbstractState> getState();

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateAutomaton_Transition()
	 * @model containment="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<SdlTransition> getTransition();

	/**
	 * Returns the value of the '<em><b>Named State</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlNamedState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named State</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateAutomaton_NamedState()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlNamedState> getNamedState();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(Start)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateAutomaton_Start()
	 * @model containment="true" required="true" derived="true" ordered="false"
	 * @generated
	 */
	Start getStart();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlStateAutomaton#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Start value);

} // SdlStateAutomaton
