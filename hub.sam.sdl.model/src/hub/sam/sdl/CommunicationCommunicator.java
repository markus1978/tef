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
 * A representation of the model object '<em><b>Communication Communicator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CommunicationCommunicator#getMedium <em>Medium</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationCommunicator()
 * @model abstract="true"
 * @generated
 */
public interface CommunicationCommunicator extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Medium</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CommunicationMedium}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CommunicationMedium#getAssociatedClassifier <em>Associated Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Medium</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Medium</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationCommunicator_Medium()
	 * @see hub.sam.sdl.CommunicationMedium#getAssociatedClassifier
	 * @model opposite="associatedClassifier" ordered="false"
	 * @generated
	 */
	EList<CommunicationMedium> getMedium();

} // CommunicationCommunicator
