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
 * A representation of the model object '<em><b>Evaluation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationExpression#getSubExpression <em>Sub Expression</em>}</li>
 *   <li>{@link hub.sam.sdl.EvaluationExpression#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationExpression()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationExpression extends CoreAbstractionsElementsElement, CoreAbstractionsTypedElementsTypedElement {
	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.EvaluationExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationExpression_SubExpression()
	 * @model containment="true"
	 * @generated
	 */
	EList<EvaluationExpression> getSubExpression();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CoreAbstractionsTypedElementsType)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationExpression_Type()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsTypedElementsType getType();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationExpression#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CoreAbstractionsTypedElementsType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EvaluationEvaluation instantiate();

} // EvaluationExpression
