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
 * A representation of the model object '<em><b>Message Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpCS()
 * @model
 * @generated
 */
public interface MessageExpCS extends OCLExpressionCS {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OCLExpressionCS)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpCS_Target()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ocl.internal.cst.MessageExpKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.MessageExpKind
	 * @see #setKind(MessageExpKind)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpCS_Kind()
	 * @model
	 * @generated
	 */
	MessageExpKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.MessageExpKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MessageExpKind value);

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
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpCS_SimpleNameCS()
	 * @model
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.MessageExpCS#getSimpleNameCS <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.internal.cst.OCLMessageArgCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpCS_Arguments()
	 * @model type="org.eclipse.emf.ocl.internal.cst.OCLMessageArgCS" containment="true"
	 * @generated
	 */
	EList getArguments();

} // MessageExpCS
