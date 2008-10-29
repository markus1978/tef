/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Literals Literal Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsLiteralsLiteralInteger()
 * @model
 * @generated
 */
public interface CoreAbstractionsLiteralsLiteralInteger extends CoreAbstractionsLiteralsLiteralSpecification {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsLiteralsLiteralInteger_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	boolean isComputable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int integerValue();

} // CoreAbstractionsLiteralsLiteralInteger
