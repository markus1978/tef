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
import org.eclipse.emf.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.emf.ocl.internal.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.CollectionRangeCSImpl#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRangeCSImpl extends CollectionLiteralPartCSImpl implements CollectionRangeCS {
	/**
	 * The cached value of the '{@link #getLastExpressionCS() <em>Last Expression CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS lastExpressionCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRangeCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.COLLECTION_RANGE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getLastExpressionCS() {
		if (lastExpressionCS != null && lastExpressionCS.eIsProxy()) {
			InternalEObject oldLastExpressionCS = (InternalEObject)lastExpressionCS;
			lastExpressionCS = (OCLExpressionCS)eResolveProxy(oldLastExpressionCS);
			if (lastExpressionCS != oldLastExpressionCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, oldLastExpressionCS, lastExpressionCS));
			}
		}
		return lastExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS basicGetLastExpressionCS() {
		return lastExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastExpressionCS(OCLExpressionCS newLastExpressionCS) {
		OCLExpressionCS oldLastExpressionCS = lastExpressionCS;
		lastExpressionCS = newLastExpressionCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, oldLastExpressionCS, lastExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
				if (resolve) return getLastExpressionCS();
				return basicGetLastExpressionCS();
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
			case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((OCLExpressionCS)newValue);
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
			case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((OCLExpressionCS)null);
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
			case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
				return lastExpressionCS != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionRangeCSImpl
