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
 * A representation of the model object '<em><b>Core Abstractions Instances Instance Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSlot <em>Slot</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceSpecification()
 * @model
 * @generated
 */
public interface CoreAbstractionsInstancesInstanceSpecification extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Slot</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsInstancesSlot}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceSpecification_Slot()
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance
	 * @model opposite="owningInstance" containment="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsInstancesSlot> getSlot();

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceSpecification_Classifier()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsClassifiersClassifier> getClassifier();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(CoreAbstractionsExpressionsValueSpecification)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceSpecification_Specification()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsExpressionsValueSpecification getSpecification();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(CoreAbstractionsExpressionsValueSpecification value);

} // CoreAbstractionsInstancesInstanceSpecification
