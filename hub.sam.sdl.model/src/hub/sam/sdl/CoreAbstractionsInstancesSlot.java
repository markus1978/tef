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
 * A representation of the model object '<em><b>Core Abstractions Instances Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getValue <em>Value</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getDefiningFeature <em>Defining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesSlot()
 * @model
 * @generated
 */
public interface CoreAbstractionsInstancesSlot extends CoreAbstractionsOwnershipsElement {
	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(CoreAbstractionsInstancesInstanceSpecification)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesSlot_OwningInstance()
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSlot
	 * @model opposite="slot" required="true" transient="false" ordered="false"
	 * @generated
	 */
	CoreAbstractionsInstancesInstanceSpecification getOwningInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(CoreAbstractionsInstancesInstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesSlot_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<CoreAbstractionsExpressionsValueSpecification> getValue();

	/**
	 * Returns the value of the '<em><b>Defining Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Feature</em>' reference.
	 * @see #setDefiningFeature(CoreAbstractionsStructuralFeaturesStructuralFeature)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesSlot_DefiningFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsStructuralFeaturesStructuralFeature getDefiningFeature();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getDefiningFeature <em>Defining Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Feature</em>' reference.
	 * @see #getDefiningFeature()
	 * @generated
	 */
	void setDefiningFeature(CoreAbstractionsStructuralFeaturesStructuralFeature value);

} // CoreAbstractionsInstancesSlot
