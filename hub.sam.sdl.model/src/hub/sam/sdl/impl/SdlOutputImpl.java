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
import hub.sam.sdl.SdlGate;
import hub.sam.sdl.SdlOutput;
import hub.sam.sdl.SdlSignal;

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
 * An implementation of the model object '<em><b>Sdl Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getBehavioralFeature <em>Behavioral Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getVia <em>Via</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getType <em>Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOutputImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlOutputImpl extends SdlActionImpl implements SdlOutput {
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
	 * The cached value of the '{@link #getVia() <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVia()
	 * @generated
	 * @ordered
	 */
	protected SdlGate via;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SdlSignal type;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected EvaluationExpression to;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlOutput();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.SDL_OUTPUT__ARGUMENT);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE, oldBehavioralFeature, behavioralFeature));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_OUTPUT__CLASSIFIER, oldClassifier, classifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__CLASSIFIER, oldClassifier, classifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGate getVia() {
		if (via != null && via.eIsProxy()) {
			InternalEObject oldVia = (InternalEObject)via;
			via = (SdlGate)eResolveProxy(oldVia);
			if (via != oldVia) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_OUTPUT__VIA, oldVia, via));
			}
		}
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGate basicGetVia() {
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVia(SdlGate newVia) {
		SdlGate oldVia = via;
		via = newVia;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__VIA, oldVia, via));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSignal getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (SdlSignal)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_OUTPUT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSignal basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SdlSignal newType) {
		SdlSignal oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationExpression getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo(EvaluationExpression newTo, NotificationChain msgs) {
		EvaluationExpression oldTo = to;
		to = newTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__TO, oldTo, newTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(EvaluationExpression newTo) {
		if (newTo != to) {
			NotificationChain msgs = null;
			if (to != null)
				msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_OUTPUT__TO, null, msgs);
			if (newTo != null)
				msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_OUTPUT__TO, null, msgs);
			msgs = basicSetTo(newTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_OUTPUT__TO, newTo, newTo));
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
			case EmfSdlPackage.SDL_OUTPUT__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_OUTPUT__TO:
				return basicSetTo(null, msgs);
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
			case EmfSdlPackage.SDL_OUTPUT__ARGUMENT:
				return getArgument();
			case EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE:
				if (resolve) return getBehavioralFeature();
				return basicGetBehavioralFeature();
			case EmfSdlPackage.SDL_OUTPUT__CLASSIFIER:
				if (resolve) return getClassifier();
				return basicGetClassifier();
			case EmfSdlPackage.SDL_OUTPUT__VIA:
				if (resolve) return getVia();
				return basicGetVia();
			case EmfSdlPackage.SDL_OUTPUT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EmfSdlPackage.SDL_OUTPUT__TO:
				return getTo();
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
			case EmfSdlPackage.SDL_OUTPUT__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)newValue);
				return;
			case EmfSdlPackage.SDL_OUTPUT__CLASSIFIER:
				setClassifier((CoreAbstractionsClassifiersClassifier)newValue);
				return;
			case EmfSdlPackage.SDL_OUTPUT__VIA:
				setVia((SdlGate)newValue);
				return;
			case EmfSdlPackage.SDL_OUTPUT__TYPE:
				setType((SdlSignal)newValue);
				return;
			case EmfSdlPackage.SDL_OUTPUT__TO:
				setTo((EvaluationExpression)newValue);
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
			case EmfSdlPackage.SDL_OUTPUT__ARGUMENT:
				getArgument().clear();
				return;
			case EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE:
				setBehavioralFeature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)null);
				return;
			case EmfSdlPackage.SDL_OUTPUT__CLASSIFIER:
				setClassifier((CoreAbstractionsClassifiersClassifier)null);
				return;
			case EmfSdlPackage.SDL_OUTPUT__VIA:
				setVia((SdlGate)null);
				return;
			case EmfSdlPackage.SDL_OUTPUT__TYPE:
				setType((SdlSignal)null);
				return;
			case EmfSdlPackage.SDL_OUTPUT__TO:
				setTo((EvaluationExpression)null);
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
			case EmfSdlPackage.SDL_OUTPUT__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE:
				return behavioralFeature != null;
			case EmfSdlPackage.SDL_OUTPUT__CLASSIFIER:
				return classifier != null;
			case EmfSdlPackage.SDL_OUTPUT__VIA:
				return via != null;
			case EmfSdlPackage.SDL_OUTPUT__TYPE:
				return type != null;
			case EmfSdlPackage.SDL_OUTPUT__TO:
				return to != null;
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
				case EmfSdlPackage.SDL_OUTPUT__ARGUMENT: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__ARGUMENT;
				case EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE;
				default: return -1;
			}
		}
		if (baseClass == InstanciationCreate.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_OUTPUT__CLASSIFIER: return EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER;
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
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__ARGUMENT: return EmfSdlPackage.SDL_OUTPUT__ARGUMENT;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE: return EmfSdlPackage.SDL_OUTPUT__BEHAVIORAL_FEATURE;
				default: return -1;
			}
		}
		if (baseClass == InstanciationCreate.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.INSTANCIATION_CREATE__CLASSIFIER: return EmfSdlPackage.SDL_OUTPUT__CLASSIFIER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlOutputImpl
