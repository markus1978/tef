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
 * A representation of the model object '<em><b>Evaluation Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationEvaluation#getSubEvaluation <em>Sub Evaluation</em>}</li>
 *   <li>{@link hub.sam.sdl.EvaluationEvaluation#getEvaluation_value <em>Evaluation value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationEvaluation()
 * @model
 * @generated
 */
public interface EvaluationEvaluation extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.EvaluationEvaluation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Evaluation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Evaluation</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationEvaluation_SubEvaluation()
	 * @model containment="true"
	 * @generated
	 */
	EList<EvaluationEvaluation> getSubEvaluation();

	/**
	 * Returns the value of the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation value</em>' reference.
	 * @see #setEvaluation_value(InstanciationValue)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationEvaluation_Evaluation_value()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	InstanciationValue getEvaluation_value();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationEvaluation#getEvaluation_value <em>Evaluation value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation value</em>' reference.
	 * @see #getEvaluation_value()
	 * @generated
	 */
	void setEvaluation_value(InstanciationValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeSubEvaluations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model cRequired="true" cOrdered="false"
	 * @generated
	 */
	void updateContext(InstanciationInstance c);

} // EvaluationEvaluation
