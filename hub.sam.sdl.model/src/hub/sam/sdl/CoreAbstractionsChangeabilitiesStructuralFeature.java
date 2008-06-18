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
 * A representation of the model object '<em><b>Core Abstractions Changeabilities Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature#getIsReadOnly <em>Is Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsChangeabilitiesStructuralFeature()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsChangeabilitiesStructuralFeature extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Read Only</em>' attribute.
	 * @see #setIsReadOnly(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsChangeabilitiesStructuralFeature_IsReadOnly()
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String getIsReadOnly();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature#getIsReadOnly <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Read Only</em>' attribute.
	 * @see #getIsReadOnly()
	 * @generated
	 */
	void setIsReadOnly(String value);

} // CoreAbstractionsChangeabilitiesStructuralFeature
