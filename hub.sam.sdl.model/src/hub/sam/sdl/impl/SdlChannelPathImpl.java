/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlChannel;
import hub.sam.sdl.SdlChannelEnd;
import hub.sam.sdl.SdlChannelPath;
import hub.sam.sdl.SdlSignal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Channel Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getSource <em>Source</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getRelatedElement <em>Related Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlChannelPathImpl#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlChannelPathImpl extends CoreAbstractionsRelationshipsDirectedRelationshipImpl implements SdlChannelPath {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ConcreteSyntaxSdlIdentifier identifier;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SdlChannelEnd source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SdlChannelEnd target;

	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlSignal> signal;

	/**
	 * The cached value of the '{@link #getRelatedElement() <em>Related Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlChannelEnd> relatedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlChannelPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlChannelPath();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsNamespacesNamespace getNamespace() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE) return null;
		return (CoreAbstractionsNamespacesNamespace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(CoreAbstractionsNamespacesNamespace newNamespace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNamespace, EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(CoreAbstractionsNamespacesNamespace newNamespace) {
		if (newNamespace != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE && newNamespace != null)) {
			if (EcoreUtil.isAncestor(this, newNamespace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNamespace != null)
				msgs = ((InternalEObject)newNamespace).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER, CoreAbstractionsNamespacesNamespace.class, msgs);
			msgs = basicSetNamespace(newNamespace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE, newNamespace, newNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlIdentifier getIdentifier() {
		if (identifier != null && identifier.eIsProxy()) {
			InternalEObject oldIdentifier = (InternalEObject)identifier;
			identifier = (ConcreteSyntaxSdlIdentifier)eResolveProxy(oldIdentifier);
			if (identifier != oldIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER, oldIdentifier, identifier));
			}
		}
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlIdentifier basicGetIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(ConcreteSyntaxSdlIdentifier newIdentifier) {
		ConcreteSyntaxSdlIdentifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelEnd getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(SdlChannelEnd newSource, NotificationChain msgs) {
		SdlChannelEnd oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SdlChannelEnd newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelEnd getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(SdlChannelEnd newTarget, NotificationChain msgs) {
		SdlChannelEnd oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SdlChannelEnd newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_CHANNEL_PATH__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_CHANNEL_PATH__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlSignal> getSignal() {
		if (signal == null) {
			signal = new EObjectResolvingEList<SdlSignal>(SdlSignal.class, this, EmfSdlPackage.SDL_CHANNEL_PATH__SIGNAL);
		}
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlChannelEnd> getRelatedElement() {
		if (relatedElement == null) {
			relatedElement = new EObjectContainmentWithInverseEList<SdlChannelEnd>(SdlChannelEnd.class, this, EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT, EmfSdlPackage.SDL_CHANNEL_END__CHANNEL);
		}
		return relatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannel getChannel() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL) return null;
		return (SdlChannel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannel(SdlChannel newChannel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newChannel, EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(SdlChannel newChannel) {
		if (newChannel != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL && newChannel != null)) {
			if (EcoreUtil.isAncestor(this, newChannel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newChannel != null)
				msgs = ((InternalEObject)newChannel).eInverseAdd(this, EmfSdlPackage.SDL_CHANNEL__PATH, SdlChannel.class, msgs);
			msgs = basicSetChannel(newChannel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL, newChannel, newChannel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamespace> allNamespaces() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinguishableFrom(CoreAbstractionsNamespacesNamedElement n, CoreAbstractionsNamespacesNamespace ns) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String separator() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String qualifiedName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNamespace((CoreAbstractionsNamespacesNamespace)otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRelatedElement()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetChannel((SdlChannel)otherEnd, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				return basicSetNamespace(null, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE:
				return basicSetSource(null, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__TARGET:
				return basicSetTarget(null, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				return ((InternalEList<?>)getRelatedElement()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER, CoreAbstractionsNamespacesNamespace.class, msgs);
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.SDL_CHANNEL__PATH, SdlChannel.class, msgs);
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAME:
				return getName();
			case EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME:
				return getQualifiedName();
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				return getNamespace();
			case EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE:
				return getSource();
			case EmfSdlPackage.SDL_CHANNEL_PATH__TARGET:
				return getTarget();
			case EmfSdlPackage.SDL_CHANNEL_PATH__SIGNAL:
				return getSignal();
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				return getRelatedElement();
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				return getChannel();
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAME:
				setName((String)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE:
				setSource((SdlChannelEnd)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__TARGET:
				setTarget((SdlChannelEnd)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SIGNAL:
				getSignal().clear();
				getSignal().addAll((Collection<? extends SdlSignal>)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				getRelatedElement().clear();
				getRelatedElement().addAll((Collection<? extends SdlChannelEnd>)newValue);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				setChannel((SdlChannel)newValue);
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE:
				setSource((SdlChannelEnd)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__TARGET:
				setTarget((SdlChannelEnd)null);
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SIGNAL:
				getSignal().clear();
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				getRelatedElement().clear();
				return;
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				setChannel((SdlChannel)null);
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
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE:
				return getNamespace() != null;
			case EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER:
				return identifier != null;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SOURCE:
				return source != null;
			case EmfSdlPackage.SDL_CHANNEL_PATH__TARGET:
				return target != null;
			case EmfSdlPackage.SDL_CHANNEL_PATH__SIGNAL:
				return signal != null && !signal.isEmpty();
			case EmfSdlPackage.SDL_CHANNEL_PATH__RELATED_ELEMENT:
				return relatedElement != null && !relatedElement.isEmpty();
			case EmfSdlPackage.SDL_CHANNEL_PATH__CHANNEL:
				return getChannel() != null;
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
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_CHANNEL_PATH__NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;
				case EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;
				case EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;
				case EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;
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
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME: return EmfSdlPackage.SDL_CHANNEL_PATH__NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME: return EmfSdlPackage.SDL_CHANNEL_PATH__QUALIFIED_NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE: return EmfSdlPackage.SDL_CHANNEL_PATH__NAMESPACE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER: return EmfSdlPackage.SDL_CHANNEL_PATH__IDENTIFIER;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //SdlChannelPathImpl
