/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlSpecification#getPackages <em>Packages</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlSpecification#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlSpecification()
 * @model
 * @generated
 */
public interface SdlSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSpecification_Packages()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(SdlAgent)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSpecification_System()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlAgent getSystem();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSpecification#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(SdlAgent value);

} // SdlSpecification
