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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The cached value of the '{@link #getOwningStateInstance() <em>Owning State Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningStateInstance()
	 * @generated
	 * @ordered
	 */
	protected SdlCompositeStateInstance owningStateInstance;

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
		if (owningStateInstance != null && owningStateInstance.eIsProxy()) {
			InternalEObject oldOwningStateInstance = (InternalEObject)owningStateInstance;
			owningStateInstance = (SdlCompositeStateInstance)eResolveProxy(oldOwningStateInstance);
			if (owningStateInstance != oldOwningStateInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE, oldOwningStateInstance, owningStateInstance));
			}
		}
		return owningStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCompositeStateInstance basicGetOwningStateInstance() {
		return owningStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningStateInstance(SdlCompositeStateInstance newOwningStateInstance) {
		SdlCompositeStateInstance oldOwningStateInstance = owningStateInstance;
		owningStateInstance = newOwningStateInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE, oldOwningStateInstance, owningStateInstance));
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
				if (resolve) return getOwningStateInstance();
				return basicGetOwningStateInstance();
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
				return owningStateInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlInputInstanceImpl
