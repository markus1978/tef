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
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getBehavioralFeature <em>Behavioral Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.InstanciationCreateImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InstanciationCreateImpl extends CoreAbstractionsElementsElementImpl implements InstanciationCreate {
	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationExpression> argument;

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
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsClassifiersClassifier classifier;

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
	public EList<EvaluationExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT);
		}
		return argument;
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
	public CoreAbstractionsClassifiersClassifier getClassifier() {
		if (classifier != null && classifier.eIsProxy()) {
			InternalEObject oldClassifier = (InternalEObject)classifier;
			classifier = (CoreAbstractionsClassifiersClassifier)eResolveProxy(oldClassifier);
			if (classifier != oldClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER, oldClassifier, classifier));
			}
		}
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersClassifier basicGetClassifier() {
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifier(CoreAbstractionsClassifiersClassifier newClassifier) {
		CoreAbstractionsClassifiersClassifier oldClassifier = classifier;
		classifier = newClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER, oldClassifier, classifier));
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
			case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT:
				return getArgument();
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				if (resolve) return getBehavioralFeature();
				return basicGetBehavioralFeature();
			case EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER:
				if (resolve) return getClassifier();
				return basicGetClassifier();
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
			case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)newValue);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER:
				setClassifier((CoreAbstractionsClassifiersClassifier)newValue);
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
			case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT:
				getArgument().clear();
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)null);
				return;
			case EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER:
				setClassifier((CoreAbstractionsClassifiersClassifier)null);
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
			case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE:
				return behavioralFeature != null;
			case EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER:
				return classifier != null;
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
				case EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__ARGUMENT;
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
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__ARGUMENT: return EmfSdlPackage.INSTANCIATION_CREATE__ARGUMENT;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE: return EmfSdlPackage.INSTANCIATION_CREATE__BEHAVIORAL_FEATURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InstanciationCreateImpl
