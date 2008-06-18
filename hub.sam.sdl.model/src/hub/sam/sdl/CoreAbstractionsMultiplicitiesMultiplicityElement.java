/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Multiplicities Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getLower <em>Lower</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsMultiplicitiesMultiplicityElement extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_IsOrdered()
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String getIsOrdered();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #getIsOrdered()
	 * @generated
	 */
	void setIsOrdered(String value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_IsUnique()
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String getIsUnique();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #getIsUnique()
	 * @generated
	 */
	void setIsUnique(String value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_Lower()
	 * @model dataType="hub.sam.sdl.PrimitiveTypesInteger" ordered="false"
	 * @generated
	 */
	String getLower();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(String value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_Upper()
	 * @model dataType="hub.sam.sdl.PrimitiveTypesUnlimitedNatural" ordered="false"
	 * @generated
	 */
	String getUpper();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesInteger" required="true" ordered="false"
	 * @generated
	 */
	String lowerBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesUnlimitedNatural" required="true" ordered="false"
	 * @generated
	 */
	String upperBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false"
	 * @generated
	 */
	String isMultivalued();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false" CDataType="hub.sam.sdl.PrimitiveTypesInteger" CRequired="true" COrdered="false"
	 * @generated
	 */
	String includesCardinality(String C);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="hub.sam.sdl.PrimitiveTypesBoolean" required="true" ordered="false" MRequired="true" MOrdered="false"
	 * @generated
	 */
	String includesMultiplicity(CoreAbstractionsMultiplicitiesMultiplicityElement M);

} // CoreAbstractionsMultiplicitiesMultiplicityElement
