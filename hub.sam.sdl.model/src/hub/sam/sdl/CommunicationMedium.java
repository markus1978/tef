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
 * A representation of the model object '<em><b>Communication Medium</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CommunicationMedium#getAssociatedClassifier <em>Associated Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationMedium()
 * @model abstract="true"
 * @generated
 */
public interface CommunicationMedium extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Associated Classifier</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CommunicationCommunicator}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CommunicationCommunicator#getMedium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Classifier</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationMedium_AssociatedClassifier()
	 * @see hub.sam.sdl.CommunicationCommunicator#getMedium
	 * @model opposite="medium" required="true" ordered="false"
	 * @generated
	 */
	EList<CommunicationCommunicator> getAssociatedClassifier();

} // CommunicationMedium
