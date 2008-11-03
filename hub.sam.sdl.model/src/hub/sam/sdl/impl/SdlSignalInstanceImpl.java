/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.InstanciationSlot;
import hub.sam.sdl.SdlAgentInstance;
import hub.sam.sdl.SdlInstance;
import hub.sam.sdl.SdlSignalInstance;
import hub.sam.sdl.SdlVariable;
import hub.sam.sdl.SdlVariableSlot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Signal Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getContainingInstance <em>Containing Instance</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalInstanceImpl#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlSignalInstanceImpl extends CommunicationEventImpl implements SdlSignalInstance {
	/**
	 * The cached value of the '{@link #getSlot() <em>Slot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated
	 * @ordered
	 */
	protected InstanciationSlot slot;

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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected SdlVariableSlot parameter;

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
	 * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentInstance receiver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlSignalInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlSignalInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationSlot getSlot() {
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSlot(InstanciationSlot newSlot, NotificationChain msgs) {
		InstanciationSlot oldSlot = slot;
		slot = newSlot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT, oldSlot, newSlot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlot(InstanciationSlot newSlot) {
		if (newSlot != slot) {
			NotificationChain msgs = null;
			if (slot != null)
				msgs = ((InternalEObject)slot).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT, null, msgs);
			if (newSlot != null)
				msgs = ((InternalEObject)newSlot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT, null, msgs);
			msgs = basicSetSlot(newSlot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT, newSlot, newSlot));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE, oldVariable, newVariable);
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
				msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE, newVariable, newVariable));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE, oldContainingInstance, newContainingInstance);
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
				msgs = ((InternalEObject)containingInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE, null, msgs);
			if (newContainingInstance != null)
				msgs = ((InternalEObject)newContainingInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE, null, msgs);
			msgs = basicSetContainingInstance(newContainingInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE, newContainingInstance, newContainingInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableSlot getParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter(SdlVariableSlot newParameter, NotificationChain msgs) {
		SdlVariableSlot oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER, oldParameter, newParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(SdlVariableSlot newParameter) {
		if (newParameter != parameter) {
			NotificationChain msgs = null;
			if (parameter != null)
				msgs = ((InternalEObject)parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER, null, msgs);
			if (newParameter != null)
				msgs = ((InternalEObject)newParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER, null, msgs);
			msgs = basicSetParameter(newParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER, newParameter, newParameter));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER, oldSender, sender));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getReceiver() {
		if (receiver != null && receiver.eIsProxy()) {
			InternalEObject oldReceiver = (InternalEObject)receiver;
			receiver = (SdlAgentInstance)eResolveProxy(oldReceiver);
			if (receiver != oldReceiver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER, oldReceiver, receiver));
			}
		}
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance basicGetReceiver() {
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiver(SdlAgentInstance newReceiver) {
		SdlAgentInstance oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER, oldReceiver, receiver));
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
	public void createSlots() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initialize() {
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
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT:
				return basicSetSlot(null, msgs);
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE:
				return basicSetVariable(null, msgs);
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE:
				return basicSetContainingInstance(null, msgs);
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER:
				return basicSetParameter(null, msgs);
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
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT:
				return getSlot();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE:
				return getContainingInstance();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER:
				return getParameter();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER:
				if (resolve) return getReceiver();
				return basicGetReceiver();
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
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT:
				setSlot((InstanciationSlot)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE:
				setVariable((SdlVariableSlot)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE:
				setContainingInstance((SdlInstance)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER:
				setParameter((SdlVariableSlot)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER:
				setSender((SdlAgentInstance)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER:
				setReceiver((SdlAgentInstance)newValue);
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
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT:
				setSlot((InstanciationSlot)null);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE:
				setVariable((SdlVariableSlot)null);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE:
				setContainingInstance((SdlInstance)null);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER:
				setParameter((SdlVariableSlot)null);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER:
				setSender((SdlAgentInstance)null);
				return;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER:
				setReceiver((SdlAgentInstance)null);
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
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT:
				return slot != null;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE:
				return variable != null;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE:
				return containingInstance != null;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__PARAMETER:
				return parameter != null;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SENDER:
				return sender != null;
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE__RECEIVER:
				return receiver != null;
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
		if (baseClass == InstanciationInstance.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT: return EmfSdlPackage.INSTANCIATION_INSTANCE__SLOT;
				default: return -1;
			}
		}
		if (baseClass == SdlInstance.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE: return EmfSdlPackage.SDL_INSTANCE__VARIABLE;
				case EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE: return EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE;
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
		if (baseClass == InstanciationInstance.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.INSTANCIATION_INSTANCE__SLOT: return EmfSdlPackage.SDL_SIGNAL_INSTANCE__SLOT;
				default: return -1;
			}
		}
		if (baseClass == SdlInstance.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_INSTANCE__VARIABLE: return EmfSdlPackage.SDL_SIGNAL_INSTANCE__VARIABLE;
				case EmfSdlPackage.SDL_INSTANCE__CONTAINING_INSTANCE: return EmfSdlPackage.SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlSignalInstanceImpl
