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
 * A representation of the model object '<em><b>Sdl Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlInput#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlInput#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlInput()
 * @model
 * @generated
 */
public interface SdlInput extends CoreAbstractionsTypedElementsTypedElement, SdlTrigger {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInput_Parameter()
	 * @model
	 * @generated
	 */
	EList<SdlVariable> getParameter();

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' reference.
	 * @see #setSignal(SdlSignal)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInput_Signal()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlSignal getSignal();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlInput#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(SdlSignal value);

} // SdlInput
