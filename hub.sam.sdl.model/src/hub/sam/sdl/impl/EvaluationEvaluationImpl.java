/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationEvaluation;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.InstanciationValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.EvaluationEvaluationImpl#getSubEvaluation <em>Sub Evaluation</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationEvaluationImpl#getEvaluation_value <em>Evaluation value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvaluationEvaluationImpl extends CoreAbstractionsElementsElementImpl implements EvaluationEvaluation {
	/**
	 * The cached value of the '{@link #getSubEvaluation() <em>Sub Evaluation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubEvaluation()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationEvaluation> subEvaluation;

	/**
	 * The cached value of the '{@link #getEvaluation_value() <em>Evaluation value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation_value()
	 * @generated
	 * @ordered
	 */
	protected InstanciationValue evaluation_value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationEvaluationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getEvaluationEvaluation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationEvaluation> getSubEvaluation() {
		if (subEvaluation == null) {
			subEvaluation = new EObjectContainmentEList<EvaluationEvaluation>(EvaluationEvaluation.class, this, EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION);
		}
		return subEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationValue getEvaluation_value() {
		if (evaluation_value != null && evaluation_value.eIsProxy()) {
			InternalEObject oldEvaluation_value = (InternalEObject)evaluation_value;
			evaluation_value = (InstanciationValue)eResolveProxy(oldEvaluation_value);
			if (evaluation_value != oldEvaluation_value) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE, oldEvaluation_value, evaluation_value));
			}
		}
		return evaluation_value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationValue basicGetEvaluation_value() {
		return evaluation_value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluation_value(InstanciationValue newEvaluation_value) {
		InstanciationValue oldEvaluation_value = evaluation_value;
		evaluation_value = newEvaluation_value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE, oldEvaluation_value, evaluation_value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializeSubEvaluations() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void updateContext(InstanciationInstance c) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION:
				return ((InternalEList<?>)getSubEvaluation()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION:
				return getSubEvaluation();
			case EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE:
				if (resolve) return getEvaluation_value();
				return basicGetEvaluation_value();
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
			case EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION:
				getSubEvaluation().clear();
				getSubEvaluation().addAll((Collection<? extends EvaluationEvaluation>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE:
				setEvaluation_value((InstanciationValue)newValue);
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
			case EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION:
				getSubEvaluation().clear();
				return;
			case EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE:
				setEvaluation_value((InstanciationValue)null);
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
			case EmfSdlPackage.EVALUATION_EVALUATION__SUB_EVALUATION:
				return subEvaluation != null && !subEvaluation.isEmpty();
			case EmfSdlPackage.EVALUATION_EVALUATION__EVALUATION_VALUE:
				return evaluation_value != null;
		}
		return super.eIsSet(featureID);
	}

} //EvaluationEvaluationImpl
