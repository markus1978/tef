/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentInstance;
import hub.sam.sdl.SdlAgentInstanceSet;
import hub.sam.sdl.SdlChannelPath;
import hub.sam.sdl.SdlCompositeStateInstance;
import hub.sam.sdl.SdlGate;
import hub.sam.sdl.SdlSignalInstance;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Agent Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceImpl#getAgentInstanceSet <em>Agent Instance Set</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceImpl#getOwningInstanceSet <em>Owning Instance Set</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceImpl#getOffspring <em>Offspring</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlAgentInstanceImpl extends SdlInstanceImpl implements SdlAgentInstance {
	/**
	 * The cached value of the '{@link #getAgentInstanceSet() <em>Agent Instance Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentInstanceSet()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentInstanceSet agentInstanceSet;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected SdlCompositeStateInstance behavior;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentInstance parent;

	/**
	 * The cached value of the '{@link #getOffspring() <em>Offspring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffspring()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentInstance offspring;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlAgentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlAgentInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstanceSet getAgentInstanceSet() {
		return agentInstanceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAgentInstanceSet(SdlAgentInstanceSet newAgentInstanceSet, NotificationChain msgs) {
		SdlAgentInstanceSet oldAgentInstanceSet = agentInstanceSet;
		agentInstanceSet = newAgentInstanceSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET, oldAgentInstanceSet, newAgentInstanceSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentInstanceSet(SdlAgentInstanceSet newAgentInstanceSet) {
		if (newAgentInstanceSet != agentInstanceSet) {
			NotificationChain msgs = null;
			if (agentInstanceSet != null)
				msgs = ((InternalEObject)agentInstanceSet).eInverseRemove(this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE, SdlAgentInstanceSet.class, msgs);
			if (newAgentInstanceSet != null)
				msgs = ((InternalEObject)newAgentInstanceSet).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE, SdlAgentInstanceSet.class, msgs);
			msgs = basicSetAgentInstanceSet(newAgentInstanceSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET, newAgentInstanceSet, newAgentInstanceSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCompositeStateInstance getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(SdlCompositeStateInstance newBehavior, NotificationChain msgs) {
		SdlCompositeStateInstance oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR, oldBehavior, newBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(SdlCompositeStateInstance newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE, SdlCompositeStateInstance.class, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE, SdlCompositeStateInstance.class, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR, newBehavior, newBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstanceSet getOwningInstanceSet() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET) return null;
		return (SdlAgentInstanceSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstanceSet(SdlAgentInstanceSet newOwningInstanceSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstanceSet, EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningInstanceSet(SdlAgentInstanceSet newOwningInstanceSet) {
		if (newOwningInstanceSet != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET && newOwningInstanceSet != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstanceSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstanceSet != null)
				msgs = ((InternalEObject)newOwningInstanceSet).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__VALUE, SdlAgentInstanceSet.class, msgs);
			msgs = basicSetOwningInstanceSet(newOwningInstanceSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET, newOwningInstanceSet, newOwningInstanceSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (SdlAgentInstance)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SdlAgentInstance newParent) {
		SdlAgentInstance oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getOffspring() {
		if (offspring != null && offspring.eIsProxy()) {
			InternalEObject oldOffspring = (InternalEObject)offspring;
			offspring = (SdlAgentInstance)eResolveProxy(oldOffspring);
			if (offspring != oldOffspring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING, oldOffspring, offspring));
			}
		}
		return offspring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance basicGetOffspring() {
		return offspring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffspring(SdlAgentInstance newOffspring) {
		SdlAgentInstance oldOffspring = offspring;
		offspring = newOffspring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING, oldOffspring, offspring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializeBehavior() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstanceSet leadsTo(SdlChannelPath path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlChannelPath> continuesWith(SdlChannelPath path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispatchSignal(SdlSignalInstance s, SdlGate via) {
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				if (agentInstanceSet != null)
					msgs = ((InternalEObject)agentInstanceSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET, null, msgs);
				return basicSetAgentInstanceSet((SdlAgentInstanceSet)otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				if (behavior != null)
					msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR, null, msgs);
				return basicSetBehavior((SdlCompositeStateInstance)otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstanceSet((SdlAgentInstanceSet)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				return basicSetAgentInstanceSet(null, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				return basicSetBehavior(null, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				return basicSetOwningInstanceSet(null, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__VALUE, SdlAgentInstanceSet.class, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				return getAgentInstanceSet();
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				return getBehavior();
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				return getOwningInstanceSet();
			case EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING:
				if (resolve) return getOffspring();
				return basicGetOffspring();
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				setAgentInstanceSet((SdlAgentInstanceSet)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				setBehavior((SdlCompositeStateInstance)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				setOwningInstanceSet((SdlAgentInstanceSet)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT:
				setParent((SdlAgentInstance)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING:
				setOffspring((SdlAgentInstance)newValue);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				setAgentInstanceSet((SdlAgentInstanceSet)null);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				setBehavior((SdlCompositeStateInstance)null);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				setOwningInstanceSet((SdlAgentInstanceSet)null);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT:
				setParent((SdlAgentInstance)null);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING:
				setOffspring((SdlAgentInstance)null);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET:
				return agentInstanceSet != null;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__BEHAVIOR:
				return behavior != null;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET:
				return getOwningInstanceSet() != null;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__PARENT:
				return parent != null;
			case EmfSdlPackage.SDL_AGENT_INSTANCE__OFFSPRING:
				return offspring != null;
		}
		return super.eIsSet(featureID);
	}

} //SdlAgentInstanceImpl
