/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationBehavioralFeatureAccess;
import hub.sam.sdl.EvaluationExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Behavioral Feature Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessImpl#getBehavioralFeatureAccess_argument <em>Behavioral Feature Access argument</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessImpl#getBehavioralFeature <em>Behavioral Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EvaluationBehavioralFeatureAccessImpl extends EObjectImpl implements EvaluationBehavioralFeatureAccess {
	/**
	 * The cached value of the '{@link #getBehavioralFeatureAccess_argument() <em>Behavioral Feature Access argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralFeatureAccess_argument()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationExpression> behavioralFeatureAccess_argument;

	/**
	 * The cached value of the '{@link #getBehavioralFeature() <em>Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsBehavioralFeaturesBehavioralFeature behavioralFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationBehavioralFeatureAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationExpression> getBehavioralFeatureAccess_argument() {
		if (behavioralFeatureAccess_argument == null) {
			behavioralFeatureAccess_argument = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT);
		}
		return behavioralFeatureAccess_argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsBehavioralFeaturesBehavioralFeature getBehavioralFeature() {
		if (behavioralFeature != null && behavioralFeature.eIsProxy()) {
			InternalEObject oldBehavioralFeature = (InternalEObject)behavioralFeature;
			behavioralFeature = (CoreAbstractionsBehavioralFeaturesBehavioralFeature)eResolveProxy(oldBehavioralFeature);
			if (behavioralFeature != oldBehavioralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
			}
		}
		return behavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsBehavioralFeaturesBehavioralFeature basicGetBehavioralFeature() {
		return behavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavioralFeature(CoreAbstractionsBehavioralFeaturesBehavioralFeature newBehavioralFeature) {
		CoreAbstractionsBehavioralFeaturesBehavioralFeature oldBehavioralFeature = behavioralFeature;
		behavioralFeature = newBehavioralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				return ((InternalEList<?>)getBehavioralFeatureAccess_argument()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				return getBehavioralFeatureAccess_argument();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE:
				if (resolve) return getBehavioralFeature();
				return basicGetBehavioralFeature();
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				getBehavioralFeatureAccess_argument().clear();
				getBehavioralFeatureAccess_argument().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)newValue);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				getBehavioralFeatureAccess_argument().clear();
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)null);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				return behavioralFeatureAccess_argument != null && !behavioralFeatureAccess_argument.isEmpty();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE:
				return behavioralFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //EvaluationBehavioralFeatureAccessImpl
