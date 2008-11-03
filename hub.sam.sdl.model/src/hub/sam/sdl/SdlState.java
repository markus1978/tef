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
 * A representation of the model object '<em><b>Sdl State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlState#getEntry <em>Entry</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlState#getExit <em>Exit</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlState()
 * @model
 * @generated
 */
public interface SdlState extends SdlNamedState, CoreAbstractionsStructuralFeaturesStructuralFeature {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlState_Entry()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAction> getEntry();

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlState_Exit()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAction> getExit();

} // SdlState
