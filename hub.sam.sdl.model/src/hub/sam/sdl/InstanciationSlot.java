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
 * A representation of the model object '<em><b>Instanciation Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.InstanciationSlot#getSlot_value <em>Slot value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationSlot()
 * @model abstract="true"
 * @generated
 */
public interface InstanciationSlot extends EObject {
	/**
	 * Returns the value of the '<em><b>Slot value</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.InstanciationValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot value</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getInstanciationSlot_Slot_value()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InstanciationValue> getSlot_value();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void createInitialValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initialize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vRequired="true" vOrdered="false"
	 * @generated
	 */
	void updateValue(InstanciationValue v);

} // InstanciationSlot
