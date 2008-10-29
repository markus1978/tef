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
 * A representation of the model object '<em><b>Core Abstractions Behavioral Features Behavioral Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsBehavioralFeaturesBehavioralFeature()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsBehavioralFeaturesBehavioralFeature extends CoreAbstractionsNamespacesNamespace, CoreAbstractionsClassifiersFeature {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsBehavioralFeaturesBehavioralFeature_Parameter()
	 * @model derived="true"
	 * @generated
	 */
	EList<CoreAbstractionsBehavioralFeaturesParameter> getParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nRequired="true" nOrdered="false" nsRequired="true" nsOrdered="false"
	 * @generated
	 */
	boolean isDistinguishableFrom(CoreAbstractionsNamespacesNamedElement n, CoreAbstractionsNamespacesNamespace ns);

} // CoreAbstractionsBehavioralFeaturesBehavioralFeature
