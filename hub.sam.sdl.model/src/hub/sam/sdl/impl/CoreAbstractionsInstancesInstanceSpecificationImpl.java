/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification;
import hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification;
import hub.sam.sdl.CoreAbstractionsInstancesSlot;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Instances Instance Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceSpecificationImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceSpecificationImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceSpecificationImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreAbstractionsInstancesInstanceSpecificationImpl extends CoreAbstractionsNamespacesNamedElementImpl implements CoreAbstractionsInstancesInstanceSpecification {
	/**
	 * The cached value of the '{@link #getSlot() <em>Slot</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsInstancesSlot> slot;

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersClassifier> classifier;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsExpressionsValueSpecification specification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsInstancesInstanceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsInstancesInstanceSpecification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsInstancesSlot> getSlot() {
		if (slot == null) {
			slot = new EObjectContainmentWithInverseEList<CoreAbstractionsInstancesSlot>(CoreAbstractionsInstancesSlot.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE);
		}
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getClassifier() {
		if (classifier == null) {
			classifier = new EObjectResolvingEList<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER);
		}
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsValueSpecification getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(CoreAbstractionsExpressionsValueSpecification newSpecification, NotificationChain msgs) {
		CoreAbstractionsExpressionsValueSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION, oldSpecification, newSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(CoreAbstractionsExpressionsValueSpecification newSpecification) {
		if (newSpecification != specification) {
			NotificationChain msgs = null;
			if (specification != null)
				msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION, null, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION, null, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION, newSpecification, newSpecification));
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSlot()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				return ((InternalEList<?>)getSlot()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION:
				return basicSetSpecification(null, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				return getSlot();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER:
				return getClassifier();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION:
				return getSpecification();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				getSlot().clear();
				getSlot().addAll((Collection<? extends CoreAbstractionsInstancesSlot>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER:
				getClassifier().clear();
				getClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION:
				setSpecification((CoreAbstractionsExpressionsValueSpecification)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				getSlot().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER:
				getClassifier().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION:
				setSpecification((CoreAbstractionsExpressionsValueSpecification)null);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT:
				return slot != null && !slot.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER:
				return classifier != null && !classifier.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION:
				return specification != null;
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsInstancesInstanceSpecificationImpl
