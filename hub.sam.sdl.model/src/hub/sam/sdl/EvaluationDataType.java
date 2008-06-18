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
 * A representation of the model object '<em><b>Evaluation Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationDataType#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationDataType()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationDataType extends CoreAbstractionsTypedElementsType {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.EvaluationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationDataType_Literal()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EvaluationLiteral> getLiteral();

} // EvaluationDataType
