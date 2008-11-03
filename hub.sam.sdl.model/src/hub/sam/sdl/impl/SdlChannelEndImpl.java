/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgent;
import hub.sam.sdl.SdlChannelEnd;
import hub.sam.sdl.SdlChannelPath;
import hub.sam.sdl.SdlGate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Channel End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelEndImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelEndImpl#getGate <em>Gate</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelEndImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelEndImpl#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlChannelEndImpl extends CoreAbstractionsOwnershipsElementImpl implements SdlChannelEnd {
	/**
	 * The cached value of the '{@link #getAgent() <em>Agent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgent()
	 * @generated
	 * @ordered
	 */
	protected SdlAgent agent;

	/**
	 * The cached value of the '{@link #getGate() <em>Gate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGate()
	 * @generated
	 * @ordered
	 */
	protected SdlGate gate;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected SdlChannelEnd opposite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlChannelEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlChannelEnd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgent getAgent() {
		if (agent != null && agent.eIsProxy()) {
			InternalEObject oldAgent = (InternalEObject)agent;
			agent = (SdlAgent)eResolveProxy(oldAgent);
			if (agent != oldAgent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_CHANNEL_END__AGENT, oldAgent, agent));
			}
		}
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgent basicGetAgent() {
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgent(SdlAgent newAgent) {
		SdlAgent oldAgent = agent;
		agent = newAgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_END__AGENT, oldAgent, agent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGate getGate() {
		if (gate != null && gate.eIsProxy()) {
			InternalEObject oldGate = (InternalEObject)gate;
			gate = (SdlGate)eResolveProxy(oldGate);
			if (gate != oldGate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_CHANNEL_END__GATE, oldGate, gate));
			}
		}
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGate basicGetGate() {
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGate(SdlGate newGate, NotificationChain msgs) {
		SdlGate oldGate = gate;
		gate = newGate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_END__GATE, oldGate, newGate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGate(SdlGate newGate) {
		if (newGate != gate) {
			NotificationChain msgs = null;
			if (gate != null)
				msgs = ((InternalEObject)gate).eInverseRemove(this, EmfSdlPackage.SDL_GATE__CHANNEL_END, SdlGate.class, msgs);
			if (newGate != null)
				msgs = ((InternalEObject)newGate).eInverseAdd(this, EmfSdlPackage.SDL_GATE__CHANNEL_END, SdlGate.class, msgs);
			msgs = basicSetGate(newGate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_END__GATE, newGate, newGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelEnd getOpposite() {
		if (opposite != null && opposite.eIsProxy()) {
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (SdlChannelEnd)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelEnd basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(SdlChannelEnd newOpposite) {
		SdlChannelEnd oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelPath getChannel() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_END__CHANNEL) return null;
		return (SdlChannelPath)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannel(SdlChannelPath newChannel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newChannel, EmfSdlPackage.SDL_CHANNEL_END__CHANNEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(SdlChannelPath newChannel) {
		if (newChannel != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_END__CHANNEL && newChannel != null)) {
			if (EcoreUtil.isAncestor(this, newChannel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newChannel != null)
				msgs = ((InternalEObject)newChannel).eInverseAdd(this, EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT, SdlChannelPath.class, msgs);
			msgs = basicSetChannel(newChannel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_END__CHANNEL, newChannel, newChannel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				if (gate != null)
					msgs = ((InternalEObject)gate).eInverseRemove(this, EmfSdlPackage.SDL_GATE__CHANNEL_END, SdlGate.class, msgs);
				return basicSetGate((SdlGate)otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetChannel((SdlChannelPath)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				return basicSetGate(null, msgs);
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				return basicSetChannel(null, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT, SdlChannelPath.class, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL_END__AGENT:
				if (resolve) return getAgent();
				return basicGetAgent();
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				if (resolve) return getGate();
				return basicGetGate();
			case EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				return getChannel();
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
			case EmfSdlPackage.SDL_CHANNEL_END__AGENT:
				setAgent((SdlAgent)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				setGate((SdlGate)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE:
				setOpposite((SdlChannelEnd)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				setChannel((SdlChannelPath)newValue);
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
			case EmfSdlPackage.SDL_CHANNEL_END__AGENT:
				setAgent((SdlAgent)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				setGate((SdlGate)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE:
				setOpposite((SdlChannelEnd)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				setChannel((SdlChannelPath)null);
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
			case EmfSdlPackage.SDL_CHANNEL_END__AGENT:
				return agent != null;
			case EmfSdlPackage.SDL_CHANNEL_END__GATE:
				return gate != null;
			case EmfSdlPackage.SDL_CHANNEL_END__OPPOSITE:
				return opposite != null;
			case EmfSdlPackage.SDL_CHANNEL_END__CHANNEL:
				return getChannel() != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlChannelEndImpl
