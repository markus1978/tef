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
 * A representation of the model object '<em><b>Core Abstractions Classifiers Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsClassifiersClassifier()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsClassifiersClassifier extends CoreAbstractionsNamespacesNamespace {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsClassifiersFeature}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsClassifiersFeature#getFeaturingClassifier <em>Featuring Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsClassifiersClassifier_Feature()
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersFeature#getFeaturingClassifier
	 * @model opposite="featuringClassifier" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsClassifiersFeature> getFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsClassifiersFeature> allFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanciationInstance instanciate();

} // CoreAbstractionsClassifiersClassifier
