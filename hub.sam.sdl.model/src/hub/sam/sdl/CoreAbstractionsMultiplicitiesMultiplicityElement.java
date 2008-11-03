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
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsUnique <em>Is Unique</em>}</li>
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
	 * @see #setIsOrdered(boolean)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_IsOrdered()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_IsUnique()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_Lower()
	 * @model ordered="false"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsMultiplicitiesMultiplicityElement_Upper()
	 * @model ordered="false"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int lowerBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int upperBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	boolean isMultivalued();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" CRequired="true" COrdered="false"
	 * @generated
	 */
	boolean includesCardinality(int C);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" MRequired="true" MOrdered="false"
	 * @generated
	 */
	boolean includesMultiplicity(CoreAbstractionsMultiplicitiesMultiplicityElement M);

} // CoreAbstractionsMultiplicitiesMultiplicityElement
