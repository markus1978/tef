/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Expressions Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsValueSpecification()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsExpressionsValueSpecification extends CoreAbstractionsOwnershipsElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String isComputable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesInteger" required="true" ordered="false"
	 * @generated
	 */
	String integerValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String booleanValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesString" required="true" ordered="false"
	 * @generated
	 */
	String stringValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesUnlimitedNatural" required="true" ordered="false"
	 * @generated
	 */
	String unlimitedValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String isNull();

} // CoreAbstractionsExpressionsValueSpecification
