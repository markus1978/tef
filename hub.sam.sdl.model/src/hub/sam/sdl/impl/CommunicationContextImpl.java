/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationContext;
import hub.sam.sdl.CommunicationEvent;
import hub.sam.sdl.CommunicationProcess;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CommunicationContextImpl#getContext_process <em>Context process</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CommunicationContextImpl#getPendingEvents <em>Pending Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommunicationContextImpl extends CoreAbstractionsElementsElementImpl implements CommunicationContext {
	/**
	 * The cached value of the '{@link #getContext_process() <em>Context process</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext_process()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationProcess> context_process;

	/**
	 * The cached value of the '{@link #getPendingEvents() <em>Pending Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPendingEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationEvent> pendingEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCommunicationContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationProcess> getContext_process() {
		if (context_process == null) {
			context_process = new EObjectResolvingEList<CommunicationProcess>(CommunicationProcess.class, this, EmfSdlPackage.COMMUNICATION_CONTEXT__CONTEXT_PROCESS);
		}
		return context_process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationEvent> getPendingEvents() {
		if (pendingEvents == null) {
			pendingEvents = new EObjectContainmentEList<CommunicationEvent>(CommunicationEvent.class, this, EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS);
		}
		return pendingEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void update() {
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
			case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS:
				return ((InternalEList<?>)getPendingEvents()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.COMMUNICATION_CONTEXT__CONTEXT_PROCESS:
				return getContext_process();
			case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS:
				return getPendingEvents();
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
			case EmfSdlPackage.COMMUNICATION_CONTEXT__CONTEXT_PROCESS:
				getContext_process().clear();
				getContext_process().addAll((Collection<? extends CommunicationProcess>)newValue);
				return;
			case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS:
				getPendingEvents().clear();
				getPendingEvents().addAll((Collection<? extends CommunicationEvent>)newValue);
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
			case EmfSdlPackage.COMMUNICATION_CONTEXT__CONTEXT_PROCESS:
				getContext_process().clear();
				return;
			case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS:
				getPendingEvents().clear();
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
			case EmfSdlPackage.COMMUNICATION_CONTEXT__CONTEXT_PROCESS:
				return context_process != null && !context_process.isEmpty();
			case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS:
				return pendingEvents != null && !pendingEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CommunicationContextImpl
