/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationContextDeclCS#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.OperationContextDeclCS#getPrePostOrBodyDecls <em>Pre Post Or Body Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS extends ContextDeclCS {
	/**
	 * Returns the value of the '<em><b>Operation CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation CS</em>' reference.
	 * @see #setOperationCS(OperationCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationContextDeclCS_OperationCS()
	 * @model
	 * @generated
	 */
	OperationCS getOperationCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.OperationContextDeclCS#getOperationCS <em>Operation CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation CS</em>' reference.
	 * @see #getOperationCS()
	 * @generated
	 */
	void setOperationCS(OperationCS value);

	/**
	 * Returns the value of the '<em><b>Pre Post Or Body Decls</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.internal.cst.PrePostOrBodyDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Post Or Body Decls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Post Or Body Decls</em>' reference list.
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getOperationContextDeclCS_PrePostOrBodyDecls()
	 * @model type="org.eclipse.emf.ocl.internal.cst.PrePostOrBodyDeclCS" required="true"
	 * @generated
	 */
	EList getPrePostOrBodyDecls();

} // OperationContextDeclCS
