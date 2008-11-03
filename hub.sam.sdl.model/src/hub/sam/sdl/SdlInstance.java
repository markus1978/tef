/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlInstance#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlInstance#getContainingInstance <em>Containing Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlInstance()
 * @model abstract="true"
 * @generated
 */
public interface SdlInstance extends InstanciationInstance, InstanciationValue {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(SdlVariableSlot)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInstance_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlVariableSlot getVariable();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlInstance#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(SdlVariableSlot value);

	/**
	 * Returns the value of the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Instance</em>' containment reference.
	 * @see #setContainingInstance(SdlInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlInstance_ContainingInstance()
	 * @model containment="true" derived="true" ordered="false"
	 * @generated
	 */
	SdlInstance getContainingInstance();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlInstance#getContainingInstance <em>Containing Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Instance</em>' containment reference.
	 * @see #getContainingInstance()
	 * @generated
	 */
	void setContainingInstance(SdlInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" vRequired="true" vOrdered="false"
	 * @generated
	 */
	SdlVariableSlot resolveSlot(SdlVariable v);

} // SdlInstance
