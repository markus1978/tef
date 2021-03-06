/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CollectionRangeCS#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionRangeCS()
 * @model
 * @generated
 */
public interface CollectionRangeCS extends CollectionLiteralPartCS {
	/**
	 * Returns the value of the '<em><b>Last Expression CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Expression CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Expression CS</em>' reference.
	 * @see #setLastExpressionCS(OCLExpressionCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionRangeCS_LastExpressionCS()
	 * @model extendedMetaData="name='lastOclExpressionCS'"
	 * @generated
	 */
	OCLExpressionCS getLastExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CollectionRangeCS#getLastExpressionCS <em>Last Expression CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Expression CS</em>' reference.
	 * @see #getLastExpressionCS()
	 * @generated
	 */
	void setLastExpressionCS(OCLExpressionCS value);

} // CollectionRangeCS
