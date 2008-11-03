/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlBehavior;
import hub.sam.sdl.SdlBehaviorElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlBehaviorElementImpl#getSdlBehaviorElement_behavior <em>Sdl Behavior Element behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SdlBehaviorElementImpl extends CoreAbstractionsElementsElementImpl implements SdlBehaviorElement {
	/**
	 * The cached value of the '{@link #getSdlBehaviorElement_behavior() <em>Sdl Behavior Element behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSdlBehaviorElement_behavior()
	 * @generated
	 * @ordered
	 */
	protected SdlBehavior sdlBehaviorElement_behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlBehaviorElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlBehaviorElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlBehavior getSdlBehaviorElement_behavior() {
		return sdlBehaviorElement_behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSdlBehaviorElement_behavior(SdlBehavior newSdlBehaviorElement_behavior, NotificationChain msgs) {
		SdlBehavior oldSdlBehaviorElement_behavior = sdlBehaviorElement_behavior;
		sdlBehaviorElement_behavior = newSdlBehaviorElement_behavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, oldSdlBehaviorElement_behavior, newSdlBehaviorElement_behavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSdlBehaviorElement_behavior(SdlBehavior newSdlBehaviorElement_behavior) {
		if (newSdlBehaviorElement_behavior != sdlBehaviorElement_behavior) {
			NotificationChain msgs = null;
			if (sdlBehaviorElement_behavior != null)
				msgs = ((InternalEObject)sdlBehaviorElement_behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, null, msgs);
			if (newSdlBehaviorElement_behavior != null)
				msgs = ((InternalEObject)newSdlBehaviorElement_behavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, null, msgs);
			msgs = basicSetSdlBehaviorElement_behavior(newSdlBehaviorElement_behavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, newSdlBehaviorElement_behavior, newSdlBehaviorElement_behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return basicSetSdlBehaviorElement_behavior(null, msgs);
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
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return getSdlBehaviorElement_behavior();
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
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				setSdlBehaviorElement_behavior((SdlBehavior)newValue);
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
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				setSdlBehaviorElement_behavior((SdlBehavior)null);
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
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return sdlBehaviorElement_behavior != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlBehaviorElementImpl
