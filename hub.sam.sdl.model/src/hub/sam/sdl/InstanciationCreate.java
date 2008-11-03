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
 *   <li>{@link hub.sam.sdl.InstanciationCreate#getCreate_classifier <em>Create classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationCreate()
 * @model abstract="true"
 * @generated
 */
public interface InstanciationCreate extends CoreAbstractionsElementsElement, EvaluationBehavioralFeatureAccess {
	/**
	 * Returns the value of the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create classifier</em>' reference.
	 * @see #setCreate_classifier(CoreAbstractionsClassifiersClassifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationCreate_Create_classifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsClassifiersClassifier getCreate_classifier();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.InstanciationCreate#getCreate_classifier <em>Create classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create classifier</em>' reference.
	 * @see #getCreate_classifier()
	 * @generated
	 */
	void setCreate_classifier(CoreAbstractionsClassifiersClassifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	InstanciationInstance create(InstanciationInstance context);

} // InstanciationCreate
