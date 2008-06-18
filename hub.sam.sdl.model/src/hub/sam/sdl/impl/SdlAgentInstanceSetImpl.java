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
import hub.sam.sdl.CoreAbstractionsElementsElement;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentInstance;
import hub.sam.sdl.SdlAgentInstanceSet;
import hub.sam.sdl.SdlSignalInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Agent Instance Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getLine <em>Line</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getPendingEvents <em>Pending Events</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getInputQueue <em>Input Queue</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl#getAgentInstance <em>Agent Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlAgentInstanceSetImpl extends InstanciationSlotImpl implements SdlAgentInstanceSet {
	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected String line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected String column = COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProcess() <em>Process</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcess()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationProcess> process;

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
	 * The cached value of the '{@link #getInputQueue() <em>Input Queue</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputQueue()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlSignalInstance> inputQueue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlAgentInstanceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlAgentInstanceSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(String newLine) {
		String oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(String newColumn) {
		String oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationProcess> getProcess() {
		if (process == null) {
			process = new EObjectResolvingEList<CommunicationProcess>(CommunicationProcess.class, this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS);
		}
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationEvent> getPendingEvents() {
		if (pendingEvents == null) {
			pendingEvents = new EObjectContainmentEList<CommunicationEvent>(CommunicationEvent.class, this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS);
		}
		return pendingEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlSignalInstance> getInputQueue() {
		if (inputQueue == null) {
			inputQueue = new EObjectContainmentEList<SdlSignalInstance>(SdlSignalInstance.class, this, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE);
		}
		return inputQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance getAgentInstance() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE) return null;
		return (SdlAgentInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAgentInstance(SdlAgentInstance newAgentInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAgentInstance, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentInstance(SdlAgentInstance newAgentInstance) {
		if (newAgentInstance != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE && newAgentInstance != null)) {
			if (EcoreUtil.isAncestor(this, newAgentInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAgentInstance != null)
				msgs = ((InternalEObject)newAgentInstance).eInverseAdd(this, EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET, SdlAgentInstance.class, msgs);
			msgs = basicSetAgentInstance(newAgentInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE, newAgentInstance, newAgentInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void terminate(SdlAgentInstance agent) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAgentInstance((SdlAgentInstance)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS:
				return ((InternalEList<?>)getPendingEvents()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE:
				return ((InternalEList<?>)getInputQueue()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				return basicSetAgentInstance(null, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET, SdlAgentInstance.class, msgs);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE:
				return getLine();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN:
				return getColumn();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS:
				return getProcess();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS:
				return getPendingEvents();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE:
				return getInputQueue();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				return getAgentInstance();
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE:
				setLine((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN:
				setColumn((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS:
				getProcess().clear();
				getProcess().addAll((Collection<? extends CommunicationProcess>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS:
				getPendingEvents().clear();
				getPendingEvents().addAll((Collection<? extends CommunicationEvent>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE:
				getInputQueue().clear();
				getInputQueue().addAll((Collection<? extends SdlSignalInstance>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				setAgentInstance((SdlAgentInstance)newValue);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS:
				getProcess().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS:
				getPendingEvents().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE:
				getInputQueue().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				setAgentInstance((SdlAgentInstance)null);
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
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE:
				return LINE_EDEFAULT == null ? line != null : !LINE_EDEFAULT.equals(line);
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN:
				return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS:
				return process != null && !process.isEmpty();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS:
				return pendingEvents != null && !pendingEvents.isEmpty();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__INPUT_QUEUE:
				return inputQueue != null && !inputQueue.isEmpty();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE:
				return getAgentInstance() != null;
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
		if (baseClass == CoreAbstractionsElementsElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE: return EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;
				case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN: return EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;
				default: return -1;
			}
		}
		if (baseClass == CommunicationContext.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS: return EmfSdlPackage.COMMUNICATION_CONTEXT__PROCESS;
				case EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS: return EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS;
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
		if (baseClass == CoreAbstractionsElementsElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE: return EmfSdlPackage.SDL_AGENT_INSTANCE_SET__LINE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN: return EmfSdlPackage.SDL_AGENT_INSTANCE_SET__COLUMN;
				default: return -1;
			}
		}
		if (baseClass == CommunicationContext.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.COMMUNICATION_CONTEXT__PROCESS: return EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PROCESS;
				case EmfSdlPackage.COMMUNICATION_CONTEXT__PENDING_EVENTS: return EmfSdlPackage.SDL_AGENT_INSTANCE_SET__PENDING_EVENTS;
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
		result.append(" (line: ");
		result.append(line);
		result.append(", column: ");
		result.append(column);
		result.append(')');
		return result.toString();
	}

} //SdlAgentInstanceSetImpl
