/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCommunicationListener()
 * @model abstract="true"
 * @generated
 */
public interface CommunicationListener extends CoreAbstractionsElementsElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" eRequired="true" eOrdered="false"
	 * @generated
	 */
	boolean listensTo(CommunicationEvent e);

} // CommunicationListener
