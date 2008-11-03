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
 * A representation of the model object '<em><b>Sdl Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlDataType#getLiteral <em>Literal</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlDataType#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlDataType()
 * @model
 * @generated
 */
public interface SdlDataType extends EvaluationDataType, CoreAbstractionsNamespacesNamespace {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlDataType_Literal()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlLiteral> getLiteral();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlDataType_Operation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlOperation> getOperation();

} // SdlDataType
