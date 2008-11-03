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
 * A representation of the model object '<em><b>Sdl Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlPackage#getNestedPackage <em>Nested Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlPackage()
 * @model
 * @generated
 */
public interface SdlPackage extends CoreAbstractionsNamespacesNamespace, SdlNamespace {
	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlPackage_NestedPackage()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlPackage> getNestedPackage();

} // SdlPackage
