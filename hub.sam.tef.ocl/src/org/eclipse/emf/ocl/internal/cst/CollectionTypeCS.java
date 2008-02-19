/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CollectionTypeCS#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CollectionTypeCS#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionTypeCS()
 * @model
 * @generated
 */
public interface CollectionTypeCS extends TypeCS {
	/**
	 * Returns the value of the '<em><b>Collection Type Identifier</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ocl.internal.cst.CollectionTypeIdentifierEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Type Identifier</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.CollectionTypeIdentifierEnum
	 * @see #setCollectionTypeIdentifier(CollectionTypeIdentifierEnum)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionTypeCS_CollectionTypeIdentifier()
	 * @model
	 * @generated
	 */
	CollectionTypeIdentifierEnum getCollectionTypeIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CollectionTypeCS#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Type Identifier</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.CollectionTypeIdentifierEnum
	 * @see #getCollectionTypeIdentifier()
	 * @generated
	 */
	void setCollectionTypeIdentifier(CollectionTypeIdentifierEnum value);

	/**
	 * Returns the value of the '<em><b>Type CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type CS</em>' reference.
	 * @see #setTypeCS(TypeCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionTypeCS_TypeCS()
	 * @model
	 * @generated
	 */
	TypeCS getTypeCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CollectionTypeCS#getTypeCS <em>Type CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type CS</em>' reference.
	 * @see #getTypeCS()
	 * @generated
	 */
	void setTypeCS(TypeCS value);

} // CollectionTypeCS
