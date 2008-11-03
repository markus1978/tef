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
 * A representation of the model object '<em><b>Sdl Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlOperation#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlOperation()
 * @model
 * @generated
 */
public interface SdlOperation extends CoreAbstractionsTypedElementsTypedElement, CoreAbstractionsBehavioralFeaturesBehavioralFeature {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlOperation_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<SdlParameter> getParameter();

} // SdlOperation
