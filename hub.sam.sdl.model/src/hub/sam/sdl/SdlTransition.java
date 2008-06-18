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
 * A representation of the model object '<em><b>Sdl Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlTransition#getAction <em>Action</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlTransition#getSource <em>Source</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlTransition#getTarget <em>Target</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlTransition#getTrigger <em>Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlTransition()
 * @model
 * @generated
 */
public interface SdlTransition extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlTransition_Action()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAction> getAction();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SdlAbstractState)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlTransition_Source()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlAbstractState getSource();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlTransition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SdlAbstractState value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SdlAbstractState)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlTransition_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlAbstractState getTarget();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlTransition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SdlAbstractState value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(SdlTrigger)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlTransition_Trigger()
	 * @model containment="true" required="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlTrigger getTrigger();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlTransition#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(SdlTrigger value);

} // SdlTransition
