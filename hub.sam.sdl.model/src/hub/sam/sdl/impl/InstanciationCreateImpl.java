/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature;
import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationBehavioralFeatureAccess;
import hub.sam.sdl.EvaluationExpression;
import hub.sam.sdl.InstanciationCreate;
import hub.sam.sdl.InstanciationInstance;

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
 * An implementation of the model object '<em><b>Instanciation Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getBehavioralFeatureAccess_argument <em>Behavioral Feature Access argument</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getBehavioralFeature <em>Behavioral Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getCreate_classifier <em>Create classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InstanciationCreateImpl extends CoreAbstractionsElementsElementImpl implements InstanciationCreate {
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
	 * The cached value of the '{@link #getCreate_classifier() <em>Create classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreate_classifier()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsClassifiersClassifier create_classifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanciationCreateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getInstanciationCreate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationExpression> getBehavioralFeatureAccess_argument() {
		if (behavioralFeatureAccess_argument == null) {
			behavioralFeatureAccess_argument = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersClassifier getCreate_classifier() {
		if (create_classifier != null && create_classifier.eIsProxy()) {
			InternalEObject oldCreate_classifier = (InternalEObject)create_classifier;
			create_classifier = (CoreAbstractionsClassifiersClassifier)eResolveProxy(oldCreate_classifier);
			if (create_classifier != oldCreate_classifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER, oldCreate_classifier, create_classifier));
			}
		}
		return create_classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersClassifier basicGetCreate_classifier() {
		return create_classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate_classifier(CoreAbstractionsClassifiersClassifier newCreate_classifier) {
		CoreAbstractionsClassifiersClassifier oldCreate_classifier = create_classifier;
		create_classifier = newCreate_classifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER, oldCreate_classifier, create_classifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationInstance create(InstanciationInstance context) {
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
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
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
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				return getBehavioralFeatureAccess_argument();
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				if (resolve) return getBehavioralFeature();
				return basicGetBehavioralFeature();
			case EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER:
				if (resolve) return getCreate_classifier();
				return basicGetCreate_classifier();
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
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				getBehavioralFeatureAccess_argument().clear();
				getBehavioralFeatureAccess_argument().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)newValue);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER:
				setCreate_classifier((CoreAbstractionsClassifiersClassifier)newValue);
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
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				getBehavioralFeatureAccess_argument().clear();
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)null);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER:
				setCreate_classifier((CoreAbstractionsClassifiersClassifier)null);
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
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT:
				return behavioralFeatureAccess_argument != null && !behavioralFeatureAccess_argument.isEmpty();
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				return behavioralFeature != null;
			case EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER:
				return create_classifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EvaluationBehavioralFeatureAccess.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;
				case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EvaluationBehavioralFeatureAccess.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT: return EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE: return EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InstanciationCreateImpl
