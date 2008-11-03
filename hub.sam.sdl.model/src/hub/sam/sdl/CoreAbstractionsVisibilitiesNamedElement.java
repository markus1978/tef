/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Visibilities Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsVisibilitiesNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsVisibilitiesNamedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind
	 * @see #setVisibility(CoreAbstractionsVisibilitiesVisibilityKind)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsVisibilitiesNamedElement_Visibility()
	 * @model ordered="false"
	 * @generated
	 */
	CoreAbstractionsVisibilitiesVisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(CoreAbstractionsVisibilitiesVisibilityKind value);

} // CoreAbstractionsVisibilitiesNamedElement
