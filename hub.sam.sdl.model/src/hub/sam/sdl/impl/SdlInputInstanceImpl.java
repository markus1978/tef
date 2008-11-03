/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlCompositeStateInstance;
import hub.sam.sdl.SdlInputInstance;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Input Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlInputInstanceImpl#getOwningStateInstance <em>Owning State Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlInputInstanceImpl extends CommunicationListenerImpl implements SdlInputInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlInputInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlInputInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCompositeStateInstance getOwningStateInstance() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE) return null;
		return (SdlCompositeStateInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningStateInstance(SdlCompositeStateInstance newOwningStateInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningStateInstance, EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningStateInstance(SdlCompositeStateInstance newOwningStateInstance) {
		if (newOwningStateInstance != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE && newOwningStateInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningStateInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningStateInstance != null)
				msgs = ((InternalEObject)newOwningStateInstance).eInverseAdd(this, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT, SdlCompositeStateInstance.class, msgs);
			msgs = basicSetOwningStateInstance(newOwningStateInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE, newOwningStateInstance, newOwningStateInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningStateInstance((SdlCompositeStateInstance)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				return basicSetOwningStateInstance(null, msgs);
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT, SdlCompositeStateInstance.class, msgs);
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				return getOwningStateInstance();
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				setOwningStateInstance((SdlCompositeStateInstance)newValue);
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				setOwningStateInstance((SdlCompositeStateInstance)null);
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
			case EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE:
				return getOwningStateInstance() != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlInputInstanceImpl
