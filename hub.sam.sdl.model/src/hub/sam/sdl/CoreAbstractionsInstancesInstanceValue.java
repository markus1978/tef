/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Instances Instance Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceValue#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceValue()
 * @model
 * @generated
 */
public interface CoreAbstractionsInstancesInstanceValue extends CoreAbstractionsExpressionsValueSpecification {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(CoreAbstractionsInstancesInstanceSpecification)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsInstancesInstanceValue_Instance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsInstancesInstanceSpecification getInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceValue#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(CoreAbstractionsInstancesInstanceSpecification value);

} // CoreAbstractionsInstancesInstanceValue
