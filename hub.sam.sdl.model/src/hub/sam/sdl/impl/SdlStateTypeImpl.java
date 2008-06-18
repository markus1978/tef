/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationCommunicator;
import hub.sam.sdl.CommunicationMedium;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlState;
import hub.sam.sdl.SdlStateAutomaton;
import hub.sam.sdl.SdlStateType;

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
 * An implementation of the model object '<em><b>Sdl State Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlStateTypeImpl#getMedium <em>Medium</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateTypeImpl#getStateAutomaton <em>State Automaton</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateTypeImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlStateTypeImpl extends SdlClassifierImpl implements SdlStateType {
	/**
	 * The cached value of the '{@link #getMedium() <em>Medium</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedium()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationMedium> medium;

	/**
	 * The cached value of the '{@link #getStateAutomaton() <em>State Automaton</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateAutomaton()
	 * @generated
	 * @ordered
	 */
	protected SdlStateAutomaton stateAutomaton;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlState> state;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlStateTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlStateType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationMedium> getMedium() {
		if (medium == null) {
			medium = new EObjectWithInverseResolvingEList.ManyInverse<CommunicationMedium>(CommunicationMedium.class, this, EmfSdlPackage.SDL_STATE_TYPE__MEDIUM, EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER);
		}
		return medium;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateAutomaton getStateAutomaton() {
		return stateAutomaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateAutomaton(SdlStateAutomaton newStateAutomaton, NotificationChain msgs) {
		SdlStateAutomaton oldStateAutomaton = stateAutomaton;
		stateAutomaton = newStateAutomaton;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON, oldStateAutomaton, newStateAutomaton);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateAutomaton(SdlStateAutomaton newStateAutomaton) {
		if (newStateAutomaton != stateAutomaton) {
			NotificationChain msgs = null;
			if (stateAutomaton != null)
				msgs = ((InternalEObject)stateAutomaton).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON, null, msgs);
			if (newStateAutomaton != null)
				msgs = ((InternalEObject)newStateAutomaton).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON, null, msgs);
			msgs = basicSetStateAutomaton(newStateAutomaton, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON, newStateAutomaton, newStateAutomaton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlState> getState() {
		if (state == null) {
			state = new EObjectContainmentEList<SdlState>(SdlState.class, this, EmfSdlPackage.SDL_STATE_TYPE__STATE);
		}
		return state;
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMedium()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				return ((InternalEList<?>)getMedium()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
				return basicSetStateAutomaton(null, msgs);
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				return getMedium();
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
				return getStateAutomaton();
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
				return getState();
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				getMedium().clear();
				getMedium().addAll((Collection<? extends CommunicationMedium>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
				setStateAutomaton((SdlStateAutomaton)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
				getState().clear();
				getState().addAll((Collection<? extends SdlState>)newValue);
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				getMedium().clear();
				return;
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
				setStateAutomaton((SdlStateAutomaton)null);
				return;
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
				getState().clear();
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
			case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM:
				return medium != null && !medium.isEmpty();
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
				return stateAutomaton != null;
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
				return state != null && !state.isEmpty();
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
		if (baseClass == CommunicationCommunicator.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE_TYPE__MEDIUM: return EmfSdlPackage.COMMUNICATION_COMMUNICATOR__MEDIUM;
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
		if (baseClass == CommunicationCommunicator.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.COMMUNICATION_COMMUNICATOR__MEDIUM: return EmfSdlPackage.SDL_STATE_TYPE__MEDIUM;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlStateTypeImpl
