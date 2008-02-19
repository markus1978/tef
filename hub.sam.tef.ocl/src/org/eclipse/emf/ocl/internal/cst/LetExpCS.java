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
 * A representation of the model object '<em><b>Let Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.LetExpCS#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.LetExpCS#getInExpression <em>In Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLetExpCS()
 * @model
 * @generated
 */
public interface LetExpCS extends OCLExpressionCS {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.internal.cst.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLetExpCS_Variables()
	 * @model type="org.eclipse.emf.ocl.internal.cst.VariableCS" required="true"
	 * @generated
	 */
	EList getVariables();

	/**
	 * Returns the value of the '<em><b>In Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Expression</em>' reference.
	 * @see #setInExpression(OCLExpressionCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLetExpCS_InExpression()
	 * @model
	 * @generated
	 */
	OCLExpressionCS getInExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.LetExpCS#getInExpression <em>In Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Expression</em>' reference.
	 * @see #getInExpression()
	 * @generated
	 */
	void setInExpression(OCLExpressionCS value);

} // LetExpCS
