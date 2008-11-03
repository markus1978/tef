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
 * A representation of the model object '<em><b>Sdl State Partition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlStatePartitionInstance#getActualState <em>Actual State</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlStatePartitionInstance()
 * @model
 * @generated
 */
public interface SdlStatePartitionInstance extends SdlStateInstance {
	/**
	 * Returns the value of the '<em><b>Actual State</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlStateInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual State</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlStatePartitionInstance_ActualState()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<SdlStateInstance> getActualState();

} // SdlStatePartitionInstance
