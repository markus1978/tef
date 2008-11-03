/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier;
import hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization;
import hub.sam.sdl.EmfSdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Generalizations Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsGeneralizationImpl#getSpecific <em>Specific</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsGeneralizationImpl#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreAbstractionsGeneralizationsGeneralizationImpl extends CoreAbstractionsRelationshipsDirectedRelationshipImpl implements CoreAbstractionsGeneralizationsGeneralization {
	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsGeneralizationsClassifier general;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsGeneralizationsGeneralizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsGeneralization();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsGeneralizationsClassifier getSpecific() {
		if (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC) return null;
		return (CoreAbstractionsGeneralizationsClassifier)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecific(CoreAbstractionsGeneralizationsClassifier newSpecific, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecific, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecific(CoreAbstractionsGeneralizationsClassifier newSpecific) {
		if (newSpecific != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC && newSpecific != null)) {
			if (EcoreUtil.isAncestor(this, newSpecific))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecific != null)
				msgs = ((InternalEObject)newSpecific).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION, CoreAbstractionsGeneralizationsClassifier.class, msgs);
			msgs = basicSetSpecific(newSpecific, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC, newSpecific, newSpecific));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsGeneralizationsClassifier getGeneral() {
		if (general != null && general.eIsProxy()) {
			InternalEObject oldGeneral = (InternalEObject)general;
			general = (CoreAbstractionsGeneralizationsClassifier)eResolveProxy(oldGeneral);
			if (general != oldGeneral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL, oldGeneral, general));
			}
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsGeneralizationsClassifier basicGetGeneral() {
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneral(CoreAbstractionsGeneralizationsClassifier newGeneral) {
		CoreAbstractionsGeneralizationsClassifier oldGeneral = general;
		general = newGeneral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL, oldGeneral, general));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecific((CoreAbstractionsGeneralizationsClassifier)otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				return basicSetSpecific(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION, CoreAbstractionsGeneralizationsClassifier.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				return getSpecific();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL:
				if (resolve) return getGeneral();
				return basicGetGeneral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				setSpecific((CoreAbstractionsGeneralizationsClassifier)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL:
				setGeneral((CoreAbstractionsGeneralizationsClassifier)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				setSpecific((CoreAbstractionsGeneralizationsClassifier)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL:
				setGeneral((CoreAbstractionsGeneralizationsClassifier)null);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC:
				return getSpecific() != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL:
				return general != null;
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsGeneralizationsGeneralizationImpl
