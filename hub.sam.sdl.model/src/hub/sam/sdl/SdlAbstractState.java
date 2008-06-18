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
 * A representation of the model object '<em><b>Sdl Abstract State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAbstractState#getTrigger <em>Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAbstractState()
 * @model abstract="true"
 * @generated
 */
public interface SdlAbstractState extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAbstractState_Trigger()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlTrigger> getTrigger();

} // SdlAbstractState
