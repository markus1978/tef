/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLoopExpCS()
 * @model
 * @generated
 */
public interface LoopExpCS extends CallExpCS {
	/**
	 * Returns the value of the '<em><b>Variable1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable1</em>' reference.
	 * @see #setVariable1(VariableCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLoopExpCS_Variable1()
	 * @model
	 * @generated
	 */
	VariableCS getVariable1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getVariable1 <em>Variable1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable1</em>' reference.
	 * @see #getVariable1()
	 * @generated
	 */
	void setVariable1(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Variable2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable2</em>' reference.
	 * @see #setVariable2(VariableCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLoopExpCS_Variable2()
	 * @model
	 * @generated
	 */
	VariableCS getVariable2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getVariable2 <em>Variable2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable2</em>' reference.
	 * @see #getVariable2()
	 * @generated
	 */
	void setVariable2(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' reference.
	 * @see #setBody(OCLExpressionCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getLoopExpCS_Body()
	 * @model
	 * @generated
	 */
	OCLExpressionCS getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.LoopExpCS#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpressionCS value);

} // LoopExpCS
