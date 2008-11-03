/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl State Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlStateInstance#getSdlStateInstance_actualState <em>Sdl State Instance actual State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateInstance()
 * @model
 * @generated
 */
public interface SdlStateInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Sdl State Instance actual State</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlStateInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sdl State Instance actual State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sdl State Instance actual State</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStateInstance_SdlStateInstance_actualState()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SdlStateInstance> getSdlStateInstance_actualState();

} // SdlStateInstance
