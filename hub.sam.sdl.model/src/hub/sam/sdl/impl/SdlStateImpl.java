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
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAction;
import hub.sam.sdl.SdlState;

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
 * An implementation of the model object '<em><b>Sdl State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlStateImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateImpl#getType <em>Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateImpl#getExit <em>Exit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlStateImpl extends SdlNamedStateImpl implements SdlState {
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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsTypedElementsType type;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlState();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier() {
		if (featuringClassifier == null) {
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (CoreAbstractionsTypedElementsType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_STATE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CoreAbstractionsTypedElementsType newType) {
		CoreAbstractionsTypedElementsType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAction> getEntry() {
		if (entry == null) {
			entry = new EObjectContainmentEList<SdlAction>(SdlAction.class, this, EmfSdlPackage.SDL_STATE__ENTRY);
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
			exit = new EObjectContainmentEList<SdlAction>(SdlAction.class, this, EmfSdlPackage.SDL_STATE__EXIT);
		}
		return exit;
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE__ENTRY:
				return ((InternalEList<?>)getEntry()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE__EXIT:
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_STATE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EmfSdlPackage.SDL_STATE__ENTRY:
				return getEntry();
			case EmfSdlPackage.SDL_STATE__EXIT:
				return getExit();
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE__TYPE:
				setType((CoreAbstractionsTypedElementsType)newValue);
				return;
			case EmfSdlPackage.SDL_STATE__ENTRY:
				getEntry().clear();
				getEntry().addAll((Collection<? extends SdlAction>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE__EXIT:
				getExit().clear();
				getExit().addAll((Collection<? extends SdlAction>)newValue);
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_STATE__TYPE:
				setType((CoreAbstractionsTypedElementsType)null);
				return;
			case EmfSdlPackage.SDL_STATE__ENTRY:
				getEntry().clear();
				return;
			case EmfSdlPackage.SDL_STATE__EXIT:
				getExit().clear();
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
			case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_STATE__TYPE:
				return type != null;
			case EmfSdlPackage.SDL_STATE__ENTRY:
				return entry != null && !entry.isEmpty();
			case EmfSdlPackage.SDL_STATE__EXIT:
				return exit != null && !exit.isEmpty();
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
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE__TYPE: return EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
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
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_STATE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPE: return EmfSdlPackage.SDL_STATE__TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlStateImpl
