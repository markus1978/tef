/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentType;
import hub.sam.sdl.SdlChannelEnd;
import hub.sam.sdl.SdlGate;
import hub.sam.sdl.SdlSignal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Gate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlGateImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlGateImpl#getSend <em>Send</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlGateImpl#getChannelEnd <em>Channel End</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlGateImpl#getAgentType <em>Agent Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlGateImpl extends CoreAbstractionsNamespacesNamedElementImpl implements SdlGate {
	/**
	 * The cached value of the '{@link #getReceive() <em>Receive</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceive()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlSignal> receive;

	/**
	 * The cached value of the '{@link #getSend() <em>Send</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSend()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlSignal> send;

	/**
	 * The cached value of the '{@link #getChannelEnd() <em>Channel End</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlChannelEnd> channelEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlGateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlGate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlSignal> getReceive() {
		if (receive == null) {
			receive = new EObjectResolvingEList<SdlSignal>(SdlSignal.class, this, EmfSdlPackage.SDL_GATE__RECEIVE);
		}
		return receive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlSignal> getSend() {
		if (send == null) {
			send = new EObjectResolvingEList<SdlSignal>(SdlSignal.class, this, EmfSdlPackage.SDL_GATE__SEND);
		}
		return send;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlChannelEnd> getChannelEnd() {
		if (channelEnd == null) {
			channelEnd = new EObjectWithInverseResolvingEList<SdlChannelEnd>(SdlChannelEnd.class, this, EmfSdlPackage.SDL_GATE__CHANNEL_END, EmfSdlPackage.SDL_CHANNEL_END__GATE);
		}
		return channelEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentType getAgentType() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_GATE__AGENT_TYPE) return null;
		return (SdlAgentType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAgentType(SdlAgentType newAgentType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAgentType, EmfSdlPackage.SDL_GATE__AGENT_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentType(SdlAgentType newAgentType) {
		if (newAgentType != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_GATE__AGENT_TYPE && newAgentType != null)) {
			if (EcoreUtil.isAncestor(this, newAgentType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAgentType != null)
				msgs = ((InternalEObject)newAgentType).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_TYPE__GATE, SdlAgentType.class, msgs);
			msgs = basicSetAgentType(newAgentType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_GATE__AGENT_TYPE, newAgentType, newAgentType));
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
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChannelEnd()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAgentType((SdlAgentType)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				return ((InternalEList<?>)getChannelEnd()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				return basicSetAgentType(null, msgs);
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
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_AGENT_TYPE__GATE, SdlAgentType.class, msgs);
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
			case EmfSdlPackage.SDL_GATE__RECEIVE:
				return getReceive();
			case EmfSdlPackage.SDL_GATE__SEND:
				return getSend();
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				return getChannelEnd();
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				return getAgentType();
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
			case EmfSdlPackage.SDL_GATE__RECEIVE:
				getReceive().clear();
				getReceive().addAll((Collection<? extends SdlSignal>)newValue);
				return;
			case EmfSdlPackage.SDL_GATE__SEND:
				getSend().clear();
				getSend().addAll((Collection<? extends SdlSignal>)newValue);
				return;
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				getChannelEnd().clear();
				getChannelEnd().addAll((Collection<? extends SdlChannelEnd>)newValue);
				return;
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				setAgentType((SdlAgentType)newValue);
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
			case EmfSdlPackage.SDL_GATE__RECEIVE:
				getReceive().clear();
				return;
			case EmfSdlPackage.SDL_GATE__SEND:
				getSend().clear();
				return;
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				getChannelEnd().clear();
				return;
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				setAgentType((SdlAgentType)null);
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
			case EmfSdlPackage.SDL_GATE__RECEIVE:
				return receive != null && !receive.isEmpty();
			case EmfSdlPackage.SDL_GATE__SEND:
				return send != null && !send.isEmpty();
			case EmfSdlPackage.SDL_GATE__CHANNEL_END:
				return channelEnd != null && !channelEnd.isEmpty();
			case EmfSdlPackage.SDL_GATE__AGENT_TYPE:
				return getAgentType() != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlGateImpl
