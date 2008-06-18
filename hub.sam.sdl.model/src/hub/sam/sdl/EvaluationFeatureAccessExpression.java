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
 *   <li>{@link hub.sam.sdl.EvaluationFeatureAccessExpression#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationFeatureAccessExpression()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationFeatureAccessExpression extends EvaluationExpression {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(CoreAbstractionsClassifiersFeature)
	 * @see hub.sam.sdl.EmfSdlPackage#getEvaluationFeatureAccessExpression_Feature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsClassifiersFeature getFeature();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.EvaluationFeatureAccessExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(CoreAbstractionsClassifiersFeature value);

} // EvaluationFeatureAccessExpression
