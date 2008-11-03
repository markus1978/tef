/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlInstance;
import hub.sam.sdl.SdlVariable;
import hub.sam.sdl.SdlVariableSlot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlInstanceImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlInstanceImpl#getContainingInstance <em>Containing Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SdlInstanceImpl extends InstanciationInstanceImpl implements SdlInstance {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected SdlVariableSlot variable;

	/**
	 * The cached value of the '{@link #getContainingInstance() <em>Containing Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainingInstance()
	 * @generated
	 * @ordered
	 */
	protected SdlInstance containingInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableSlot getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(SdlVariableSlot newVariable, NotificationChain msgs) {
		SdlVariableSlot oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INSTANCE__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(SdlVariableSlot newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_INSTANCE__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_INSTANCE__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INSTANCE__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlInstance getContainingInstance() {
		return containingInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingInstance(SdlInstance newContainingInstance, NotificationChain msgs) {
		SdlInstance oldContainingInstance = containingInstance;
		containingInstance = newContainingInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE, oldContainingInstance, newContainingInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingInstance(SdlInstance newContainingInstance) {
		if (newContainingInstance != containingInstance) {
			NotificationChain msgs = null;
			if (containingInstance != null)
				msgs = ((InternalEObject)containingInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE, null, msgs);
			if (newContainingInstance != null)
				msgs = ((InternalEObject)newContainingInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE, null, msgs);
			msgs = basicSetContainingInstance(newContainingInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE, newContainingInstance, newContainingInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableSlot resolveSlot(SdlVariable v) {
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
			case EmfSdlPackage.SDL_INSTANCE__VARIABLE:
				return basicSetVariable(null, msgs);
			case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE:
				return basicSetContainingInstance(null, msgs);
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
			case EmfSdlPackage.SDL_INSTANCE__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE:
				return getContainingInstance();
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
			case EmfSdlPackage.SDL_INSTANCE__VARIABLE:
				setVariable((SdlVariableSlot)newValue);
				return;
			case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE:
				setContainingInstance((SdlInstance)newValue);
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
			case EmfSdlPackage.SDL_INSTANCE__VARIABLE:
				setVariable((SdlVariableSlot)null);
				return;
			case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE:
				setContainingInstance((SdlInstance)null);
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
			case EmfSdlPackage.SDL_INSTANCE__VARIABLE:
				return variable != null;
			case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE:
				return containingInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlInstanceImpl
