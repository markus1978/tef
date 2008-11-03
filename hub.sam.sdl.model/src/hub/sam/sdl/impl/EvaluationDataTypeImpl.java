/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationDataType;
import hub.sam.sdl.EvaluationLiteral;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.EvaluationDataTypeImpl#getDataType_literal <em>Data Type literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EvaluationDataTypeImpl extends CoreAbstractionsTypedElementsTypeImpl implements EvaluationDataType {
	/**
	 * The cached value of the '{@link #getDataType_literal() <em>Data Type literal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType_literal()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationLiteral> dataType_literal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getEvaluationDataType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationLiteral> getDataType_literal() {
		if (dataType_literal == null) {
			dataType_literal = new EObjectContainmentEList<EvaluationLiteral>(EvaluationLiteral.class, this, EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL);
		}
		return dataType_literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL:
				return ((InternalEList<?>)getDataType_literal()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL:
				return getDataType_literal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL:
				getDataType_literal().clear();
				getDataType_literal().addAll((Collection<? extends EvaluationLiteral>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL:
				getDataType_literal().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL:
				return dataType_literal != null && !dataType_literal.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EvaluationDataTypeImpl
