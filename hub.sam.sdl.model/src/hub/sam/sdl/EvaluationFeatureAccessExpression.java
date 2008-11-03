/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Feature Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.EvaluationFeatureAccessExpression#getFeatureAccessExpression_feature <em>Feature Access Expression feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationFeatureAccessExpression()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationFeatureAccessExpression extends EvaluationExpression {
	/**
	 * Returns the value of the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Access Expression feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Access Expression feature</em>' reference.
	 * @see #setFeatureAccessExpression_feature(CoreAbstractionsClassifiersFeature)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationFeatureAccessExpression_FeatureAccessExpression_feature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsClassifiersFeature getFeatureAccessExpression_feature();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationFeatureAccessExpression#getFeatureAccessExpression_feature <em>Feature Access Expression feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Access Expression feature</em>' reference.
	 * @see #getFeatureAccessExpression_feature()
	 * @generated
	 */
	void setFeatureAccessExpression_feature(CoreAbstractionsClassifiersFeature value);

} // EvaluationFeatureAccessExpression
