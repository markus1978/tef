/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAbstractState;
import hub.sam.sdl.SdlAction;
import hub.sam.sdl.SdlBehavior;
import hub.sam.sdl.SdlCompositeState;
import hub.sam.sdl.SdlNamedState;
import hub.sam.sdl.SdlState;
import hub.sam.sdl.SdlStateType;
import hub.sam.sdl.SdlTrigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Composite State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlCompositeStateImpl extends CoreAbstractionsTypedElementsTypedElementImpl implements SdlCompositeState {
	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlTrigger> trigger;

	/**
	 * The cached value of the '{@link #getFeaturingClassifier() <em>Featuring Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturingClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersClassifier> featuringClassifier;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlAction> entry;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlAction> exit;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SdlStateType type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlCompositeStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlCompositeState();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlTrigger> getTrigger() {
		if (trigger == null) {
			trigger = new EObjectContainmentEList<SdlTrigger>(SdlTrigger.class, this, EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER);
		}
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier() {
		if (featuringClassifier == null) {
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAction> getEntry() {
		if (entry == null) {
			entry = new EObjectContainmentEList<SdlAction>(SdlAction.class, this, EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY);
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAction> getExit() {
		if (exit == null) {
			exit = new EObjectContainmentEList<SdlAction>(SdlAction.class, this, EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT);
		}
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (SdlStateType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SdlStateType newType) {
		SdlStateType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeaturingClassifier()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
				return ((InternalEList<?>)getTrigger()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
				return ((InternalEList<?>)getEntry()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				return ((InternalEList<?>)getExit()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
				return getTrigger();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
				return getEntry();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				return getExit();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
				getTrigger().clear();
				getTrigger().addAll((Collection<? extends SdlTrigger>)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
				getEntry().clear();
				getEntry().addAll((Collection<? extends SdlAction>)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				getExit().clear();
				getExit().addAll((Collection<? extends SdlAction>)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE:
				setType((SdlStateType)newValue);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
				getTrigger().clear();
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
				getEntry().clear();
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				getExit().clear();
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE:
				setType((SdlStateType)null);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
				return trigger != null && !trigger.isEmpty();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
				return entry != null && !entry.isEmpty();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				return exit != null && !exit.isEmpty();
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TYPE:
				return type != null;
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
		if (baseClass == SdlAbstractState.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER: return EmfSdlPackage.SDL_ABSTRACT_STATE__TRIGGER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamedState.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SdlState.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY: return EmfSdlPackage.SDL_STATE__ENTRY;
				case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT: return EmfSdlPackage.SDL_STATE__EXIT;
				default: return -1;
			}
		}
		if (baseClass == SdlBehavior.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == SdlAbstractState.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_ABSTRACT_STATE__TRIGGER: return EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamedState.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SdlState.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_STATE__ENTRY: return EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY;
				case EmfSdlPackage.SDL_STATE__EXIT: return EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT;
				default: return -1;
			}
		}
		if (baseClass == SdlBehavior.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlCompositeStateImpl
