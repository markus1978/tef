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
 * A representation of the model object '<em><b>Core Abstractions Generalizations Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsClassifier()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsGeneralizationsClassifier extends CoreAbstractionsTypedElementsType, CoreAbstractionsClassifiersClassifier {
	/**
	 * Returns the value of the '<em><b>Generalization</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalization</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalization</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsClassifier_Generalization()
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific
	 * @model opposite="specific" containment="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsGeneralizationsGeneralization> getGeneralization();

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsGeneralizationsClassifier_General()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsGeneralizationsClassifier> getGeneral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsGeneralizationsClassifier> general();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsGeneralizationsClassifier> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" otherRequired="true" otherOrdered="false"
	 * @generated
	 */
	boolean conformsTo(CoreAbstractionsGeneralizationsClassifier other);

} // CoreAbstractionsGeneralizationsClassifier
