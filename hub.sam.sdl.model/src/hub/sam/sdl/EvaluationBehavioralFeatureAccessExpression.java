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
 * A representation of the model object '<em><b>Evaluation Behavioral Feature Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getArgument <em>Argument</em>}</li>
 *   <li>{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getBehavioralFeatureAccessExpression_feature <em>Behavioral Feature Access Expression feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccessExpression()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationBehavioralFeatureAccessExpression extends EvaluationBehavioralFeatureAccess, EvaluationFeatureAccessExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.EvaluationExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccessExpression_Argument()
	 * @model containment="true"
	 * @generated
	 */
	EList<EvaluationExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Behavioral Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Feature Access Expression feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioral Feature Access Expression feature</em>' reference.
	 * @see #setBehavioralFeatureAccessExpression_feature(CoreAbstractionsBehavioralFeaturesBehavioralFeature)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccessExpression_BehavioralFeatureAccessExpression_feature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsBehavioralFeaturesBehavioralFeature getBehavioralFeatureAccessExpression_feature();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getBehavioralFeatureAccessExpression_feature <em>Behavioral Feature Access Expression feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavioral Feature Access Expression feature</em>' reference.
	 * @see #getBehavioralFeatureAccessExpression_feature()
	 * @generated
	 */
	void setBehavioralFeatureAccessExpression_feature(CoreAbstractionsBehavioralFeaturesBehavioralFeature value);

} // EvaluationBehavioralFeatureAccessExpression
