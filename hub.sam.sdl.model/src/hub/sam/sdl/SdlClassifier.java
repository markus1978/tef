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
 * A representation of the model object '<em><b>Sdl Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlClassifier#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlClassifier#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlClassifier()
 * @model abstract="true"
 * @generated
 */
public interface SdlClassifier extends SdlNamespace, CoreAbstractionsGeneralizationsClassifier {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlClassifier_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlVariable> getVariable();

	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlProcedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlClassifier_Procedure()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlProcedure> getProcedure();

} // SdlClassifier
