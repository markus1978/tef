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
 * A representation of the model object '<em><b>Communication Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CommunicationContext#getProcess <em>Process</em>}</li>
 *   <li>{@link hub.sam.sdl.CommunicationContext#getPendingEvents <em>Pending Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationContext()
 * @model abstract="true"
 * @generated
 */
public interface CommunicationContext extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Process</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CommunicationProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationContext_Process()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CommunicationProcess> getProcess();

	/**
	 * Returns the value of the '<em><b>Pending Events</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CommunicationEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pending Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pending Events</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationContext_PendingEvents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CommunicationEvent> getPendingEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void update();

} // CommunicationContext
