/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.PathNameCS;
import org.eclipse.emf.ocl.internal.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.EnumLiteralExpCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.EnumLiteralExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumLiteralExpCSImpl extends LiteralExpCSImpl implements EnumLiteralExpCS {
	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.ENUM_LITERAL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		if (pathNameCS != null && pathNameCS.eIsProxy()) {
			InternalEObject oldPathNameCS = (InternalEObject)pathNameCS;
			pathNameCS = (PathNameCS)eResolveProxy(oldPathNameCS);
			if (pathNameCS != oldPathNameCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
			}
		}
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS basicGetPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		if (simpleNameCS != null && simpleNameCS.eIsProxy()) {
			InternalEObject oldSimpleNameCS = (InternalEObject)simpleNameCS;
			simpleNameCS = (SimpleNameCS)eResolveProxy(oldSimpleNameCS);
			if (simpleNameCS != oldSimpleNameCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
			}
		}
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS basicGetSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS:
				if (resolve) return getPathNameCS();
				return basicGetPathNameCS();
			case CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS:
				if (resolve) return getSimpleNameCS();
				return basicGetSimpleNameCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)newValue);
				return;
			case CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)null);
				return;
			case CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.ENUM_LITERAL_EXP_CS__PATH_NAME_CS:
				return pathNameCS != null;
			case CSTPackage.ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumLiteralExpCSImpl
