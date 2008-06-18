/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationEvent;
import hub.sam.sdl.CommunicationListener;
import hub.sam.sdl.CommunicationProcess;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentInstance;
import hub.sam.sdl.SdlCompositeStateInstance;
import hub.sam.sdl.SdlInputInstance;
import hub.sam.sdl.SdlState;
import hub.sam.sdl.SdlStateInstance;
import hub.sam.sdl.SdlStateStatus;

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
 * An implementation of the model object '<em><b>Sdl Composite State Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getInput <em>Input</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getActualState <em>Actual State</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getState <em>State</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getTriggered <em>Triggered</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlCompositeStateInstanceImpl extends SdlInstanceImpl implements SdlCompositeStateInstance {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationListener> input;

	/**
	 * The cached value of the '{@link #getActualState() <em>Actual State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualState()
	 * @generated
	 * @ordered
	 */
	protected SdlStateInstance actualState;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected SdlStateInstance state;

	/**
	 * The cached value of the '{@link #getTriggered() <em>Triggered</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggered()
	 * @generated
	 * @ordered
	 */
	protected SdlInputInstance triggered;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentInstance sender;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final SdlStateStatus STATUS_EDEFAULT = SdlStateStatus.STARTED;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected SdlStateStatus status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlCompositeStateInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlCompositeStateInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationListener> getInput() {
		if (input == null) {
			input = new EObjectContainmentEList<CommunicationListener>(CommunicationListener.class, this, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT);
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateInstance getActualState() {
		if (actualState != null && actualState.eIsProxy()) {
			InternalEObject oldActualState = (InternalEObject)actualState;
			actualState = (SdlStateInstance)eResolveProxy(oldActualState);
			if (actualState != oldActualState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE, oldActualState, actualState));
			}
		}
		return actualState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateInstance basicGetActualState() {
		return actualState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualState(SdlStateInstance newActualState) {
		SdlStateInstance oldActualState = actualState;
		actualState = newActualState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE, oldActualState, actualState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateInstance getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetState(SdlStateInstance newState, NotificationChain msgs) {
		SdlStateInstance oldState = state;
		state = newState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE, oldState, newState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(SdlStateInstance newState) {
		if (newState != state) {
			NotificationChain msgs = null;
			if (state != null)
				msgs = ((InternalEObject)state).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE, null, msgs);
			if (newState != null)
				msgs = ((InternalEObject)newState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE, null, msgs);
			msgs = basicSetState(newState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE, newState, newState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getOwningInstance() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE) return null;
		return (SdlAgentInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(SdlAgentInstance newOwningInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningInstance(SdlAgentInstance newOwningInstance) {
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE && newOwningInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR, SdlAgentInstance.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlInputInstance getTriggered() {
		return triggered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTriggered(SdlInputInstance newTriggered, NotificationChain msgs) {
		SdlInputInstance oldTriggered = triggered;
		triggered = newTriggered;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED, oldTriggered, newTriggered);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggered(SdlInputInstance newTriggered) {
		if (newTriggered != triggered) {
			NotificationChain msgs = null;
			if (triggered != null)
				msgs = ((InternalEObject)triggered).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED, null, msgs);
			if (newTriggered != null)
				msgs = ((InternalEObject)newTriggered).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED, null, msgs);
			msgs = basicSetTriggered(newTriggered, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED, newTriggered, newTriggered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getSender() {
		if (sender != null && sender.eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (SdlAgentInstance)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(SdlAgentInstance newSender) {
		SdlAgentInstance oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(SdlStateStatus newStatus) {
		SdlStateStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializeStates() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void executeTransition() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void executeAction() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void enterState(SdlState s) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void leaveActualState() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String consume(CommunicationListener listener, CommunicationEvent event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void run() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void start() {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((SdlAgentInstance)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT:
				return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE:
				return basicSetState(null, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED:
				return basicSetTriggered(null, msgs);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR, SdlAgentInstance.class, msgs);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT:
				return getInput();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE:
				if (resolve) return getActualState();
				return basicGetActualState();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE:
				return getState();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				return getOwningInstance();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED:
				return getTriggered();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATUS:
				return getStatus();
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT:
				getInput().clear();
				getInput().addAll((Collection<? extends CommunicationListener>)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE:
				setActualState((SdlStateInstance)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE:
				setState((SdlStateInstance)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				setOwningInstance((SdlAgentInstance)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED:
				setTriggered((SdlInputInstance)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER:
				setSender((SdlAgentInstance)newValue);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATUS:
				setStatus((SdlStateStatus)newValue);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT:
				getInput().clear();
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE:
				setActualState((SdlStateInstance)null);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE:
				setState((SdlStateInstance)null);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				setOwningInstance((SdlAgentInstance)null);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED:
				setTriggered((SdlInputInstance)null);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER:
				setSender((SdlAgentInstance)null);
				return;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT:
				return input != null && !input.isEmpty();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE:
				return actualState != null;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATE:
				return state != null;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE:
				return getOwningInstance() != null;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED:
				return triggered != null;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__SENDER:
				return sender != null;
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__STATUS:
				return status != STATUS_EDEFAULT;
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
		if (baseClass == CommunicationProcess.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT: return EmfSdlPackage.COMMUNICATION_PROCESS__INPUT;
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
		if (baseClass == CommunicationProcess.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.COMMUNICATION_PROCESS__INPUT: return EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__INPUT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //SdlCompositeStateInstanceImpl
