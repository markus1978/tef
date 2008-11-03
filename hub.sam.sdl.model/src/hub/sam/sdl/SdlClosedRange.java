/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Closed Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlClosedRange#getUpper <em>Upper</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlClosedRange#getLower <em>Lower</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlClosedRange()
 * @model
 * @generated
 */
public interface SdlClosedRange extends SdlRange {
	/**
	 * Returns the value of the '<em><b>Upper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' containment reference.
	 * @see #setUpper(SdlOpenRange)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlClosedRange_Upper()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlOpenRange getUpper();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlClosedRange#getUpper <em>Upper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' containment reference.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(SdlOpenRange value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' containment reference.
	 * @see #setLower(SdlOpenRange)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlClosedRange_Lower()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlOpenRange getLower();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlClosedRange#getLower <em>Lower</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' containment reference.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(SdlOpenRange value);

} // SdlClosedRange
