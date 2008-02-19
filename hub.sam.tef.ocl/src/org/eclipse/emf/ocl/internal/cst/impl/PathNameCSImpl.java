/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.PathNameCSImpl#getSequenceOfNames <em>Sequence Of Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathNameCSImpl extends TypeCSImpl implements PathNameCS {
	/**
	 * The cached value of the '{@link #getSequenceOfNames() <em>Sequence Of Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceOfNames()
	 * @generated
	 * @ordered
	 */
	protected EList sequenceOfNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNameCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PATH_NAME_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceOfNames() {
		if (sequenceOfNames == null) {
			sequenceOfNames = new EDataTypeUniqueEList(String.class, this, CSTPackage.PATH_NAME_CS__SEQUENCE_OF_NAMES);
		}
		return sequenceOfNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.PATH_NAME_CS__SEQUENCE_OF_NAMES:
				return getSequenceOfNames();
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
			case CSTPackage.PATH_NAME_CS__SEQUENCE_OF_NAMES:
				getSequenceOfNames().clear();
				getSequenceOfNames().addAll((Collection)newValue);
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
			case CSTPackage.PATH_NAME_CS__SEQUENCE_OF_NAMES:
				getSequenceOfNames().clear();
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
			case CSTPackage.PATH_NAME_CS__SEQUENCE_OF_NAMES:
				return sequenceOfNames != null && !sequenceOfNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sequenceOfNames: "); //$NON-NLS-1$
		result.append(sequenceOfNames);
		result.append(')');
		return result.toString();
	}

} //PathNameCSImpl
