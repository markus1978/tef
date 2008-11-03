/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Behavioral Feature Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeatureAccess_argument <em>Behavioral Feature Access argument</em>}</li>
 *   <li>{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeature <em>Behavioral Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccess()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationBehavioralFeatureAccess extends EObject {
	/**
	 * Returns the value of the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.EvaluationExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Feature Access argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioral Feature Access argument</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccess_BehavioralFeatureAccess_argument()
	 * @model containment="true"
	 * @generated
	 */
	EList<EvaluationExpression> getBehavioralFeatureAccess_argument();

	/**
	 * Returns the value of the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioral Feature</em>' reference.
	 * @see #setBehavioralFeature(CoreAbstractionsBehavioralFeaturesBehavioralFeature)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationBehavioralFeatureAccess_BehavioralFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsBehavioralFeaturesBehavioralFeature getBehavioralFeature();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeature <em>Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavioral Feature</em>' reference.
	 * @see #getBehavioralFeature()
	 * @generated
	 */
	void setBehavioralFeature(CoreAbstractionsBehavioralFeaturesBehavioralFeature value);

} // EvaluationBehavioralFeatureAccess
