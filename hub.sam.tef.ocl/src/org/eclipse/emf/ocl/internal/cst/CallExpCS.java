/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCallExpCS()
 * @model
 * @generated
 */
public interface CallExpCS extends OCLExpressionCS {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(OCLExpressionCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCallExpCS_Source()
	 * @model
	 * @generated
	 */
	OCLExpressionCS getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Accessor</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ocl.internal.cst.DotOrArrowEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessor</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.DotOrArrowEnum
	 * @see #setAccessor(DotOrArrowEnum)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCallExpCS_Accessor()
	 * @model
	 * @generated
	 */
	DotOrArrowEnum getAccessor();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getAccessor <em>Accessor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessor</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.DotOrArrowEnum
	 * @see #getAccessor()
	 * @generated
	 */
	void setAccessor(DotOrArrowEnum value);

	/**
	 * Returns the value of the '<em><b>Simple Name CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name CS</em>' reference.
	 * @see #setSimpleNameCS(SimpleNameCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCallExpCS_SimpleNameCS()
	 * @model
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.CallExpCS#getSimpleNameCS <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

} // CallExpCS
