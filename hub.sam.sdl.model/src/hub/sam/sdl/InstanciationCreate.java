/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instanciation Create</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.InstanciationCreate#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationCreate()
 * @model abstract="true"
 * @generated
 */
public interface InstanciationCreate extends CoreAbstractionsElementsElement, EvaluationBehavioralFeatureAccess {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(CoreAbstractionsClassifiersClassifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationCreate_Classifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsClassifiersClassifier getClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.InstanciationCreate#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(CoreAbstractionsClassifiersClassifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	InstanciationInstance create(InstanciationInstance context);

} // InstanciationCreate
