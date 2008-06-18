/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentType;
import hub.sam.sdl.SdlChannel;
import hub.sam.sdl.SdlChannelPath;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelImpl#getPath <em>Path</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelImpl#getAgentType <em>Agent Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlChannelImpl extends CoreAbstractionsNamespacesNamedElementImpl implements SdlChannel {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlChannelPath> path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlChannel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlChannelPath> getPath() {
		if (path == null) {
			path = new EObjectContainmentWithInverseEList<SdlChannelPath>(SdlChannelPath.class, this, EmfSdlPackage.SDL_CHANNEL__PATH, EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentType getAgentType() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE) return null;
		return (SdlAgentType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAgentType(SdlAgentType newAgentType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAgentType, EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentType(SdlAgentType newAgentType) {
		if (newAgentType != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE && newAgentType != null)) {
			if (EcoreUtil.isAncestor(this, newAgentType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAgentType != null)
				msgs = ((InternalEObject)newAgentType).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL, SdlAgentType.class, msgs);
			msgs = basicSetAgentType(newAgentType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE, newAgentType, newAgentType));
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPath()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
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
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL, SdlAgentType.class, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				return getPath();
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends SdlChannelPath>)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				getPath().clear();
				return;
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
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
			case EmfSdlPackage.SDL_CHANNEL__PATH:
				return path != null && !path.isEmpty();
			case EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE:
				return getAgentType() != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlChannelImpl
