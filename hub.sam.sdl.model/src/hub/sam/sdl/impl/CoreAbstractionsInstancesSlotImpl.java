/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification;
import hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification;
import hub.sam.sdl.CoreAbstractionsInstancesSlot;
import hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Instances Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesSlotImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesSlotImpl#getValue <em>Value</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesSlotImpl#getDefiningFeature <em>Defining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreAbstractionsInstancesSlotImpl extends CoreAbstractionsOwnershipsElementImpl implements CoreAbstractionsInstancesSlot {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsExpressionsValueSpecification> value;

	/**
	 * The cached value of the '{@link #getDefiningFeature() <em>Defining Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningFeature()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsStructuralFeaturesStructuralFeature definingFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsInstancesSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsInstancesSlot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsInstancesInstanceSpecification getOwningInstance() {
		if (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE) return null;
		return (CoreAbstractionsInstancesInstanceSpecification)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(CoreAbstractionsInstancesInstanceSpecification newOwningInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningInstance(CoreAbstractionsInstancesInstanceSpecification newOwningInstance) {
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE && newOwningInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT, CoreAbstractionsInstancesInstanceSpecification.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsExpressionsValueSpecification> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<CoreAbstractionsExpressionsValueSpecification>(CoreAbstractionsExpressionsValueSpecification.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsStructuralFeaturesStructuralFeature getDefiningFeature() {
		if (definingFeature != null && definingFeature.eIsProxy()) {
			InternalEObject oldDefiningFeature = (InternalEObject)definingFeature;
			definingFeature = (CoreAbstractionsStructuralFeaturesStructuralFeature)eResolveProxy(oldDefiningFeature);
			if (definingFeature != oldDefiningFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE, oldDefiningFeature, definingFeature));
			}
		}
		return definingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsStructuralFeaturesStructuralFeature basicGetDefiningFeature() {
		return definingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningFeature(CoreAbstractionsStructuralFeaturesStructuralFeature newDefiningFeature) {
		CoreAbstractionsStructuralFeaturesStructuralFeature oldDefiningFeature = definingFeature;
		definingFeature = newDefiningFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE, oldDefiningFeature, definingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((CoreAbstractionsInstancesInstanceSpecification)otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT, CoreAbstractionsInstancesInstanceSpecification.class, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				return getOwningInstance();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE:
				return getValue();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE:
				if (resolve) return getDefiningFeature();
				return basicGetDefiningFeature();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				setOwningInstance((CoreAbstractionsInstancesInstanceSpecification)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends CoreAbstractionsExpressionsValueSpecification>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE:
				setDefiningFeature((CoreAbstractionsStructuralFeaturesStructuralFeature)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				setOwningInstance((CoreAbstractionsInstancesInstanceSpecification)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE:
				getValue().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE:
				setDefiningFeature((CoreAbstractionsStructuralFeaturesStructuralFeature)null);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE:
				return getOwningInstance() != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE:
				return value != null && !value.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE:
				return definingFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsInstancesSlotImpl
