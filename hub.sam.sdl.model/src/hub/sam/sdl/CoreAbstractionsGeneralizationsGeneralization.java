/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Generalizations Generalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific <em>Specific</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsGeneralization()
 * @model
 * @generated
 */
public interface CoreAbstractionsGeneralizationsGeneralization extends CoreAbstractionsRelationshipsDirectedRelationship {
	/**
	 * Returns the value of the '<em><b>Specific</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneralization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific</em>' container reference.
	 * @see #setSpecific(CoreAbstractionsGeneralizationsClassifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsGeneralization_Specific()
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneralization
	 * @model opposite="generalization" required="true" transient="false" ordered="false"
	 * @generated
	 */
	CoreAbstractionsGeneralizationsClassifier getSpecific();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific <em>Specific</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific</em>' container reference.
	 * @see #getSpecific()
	 * @generated
	 */
	void setSpecific(CoreAbstractionsGeneralizationsClassifier value);

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference.
	 * @see #setGeneral(CoreAbstractionsGeneralizationsClassifier)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsGeneralization_General()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsGeneralizationsClassifier getGeneral();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getGeneral <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General</em>' reference.
	 * @see #getGeneral()
	 * @generated
	 */
	void setGeneral(CoreAbstractionsGeneralizationsClassifier value);

} // CoreAbstractionsGeneralizationsGeneralization
