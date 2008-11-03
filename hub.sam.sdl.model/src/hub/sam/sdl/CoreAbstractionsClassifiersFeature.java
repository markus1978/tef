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
 * A representation of the model object '<em><b>Core Abstractions Classifiers Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsClassifiersFeature#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsClassifiersFeature()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsClassifiersFeature extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Featuring Classifier</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featuring Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featuring Classifier</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsClassifiersFeature_FeaturingClassifier()
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersClassifier#getFeature
	 * @model opposite="feature" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier();

} // CoreAbstractionsClassifiersFeature
