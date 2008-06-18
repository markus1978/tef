/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature;
import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter;
import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsCommentsComment;
import hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier;
import hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.SdlAgent;
import hub.sam.sdl.SdlAgentKind;
import hub.sam.sdl.SdlAgentType;
import hub.sam.sdl.SdlChannel;
import hub.sam.sdl.SdlClassifier;
import hub.sam.sdl.SdlGate;
import hub.sam.sdl.SdlNamespace;
import hub.sam.sdl.SdlProcedure;
import hub.sam.sdl.SdlVariable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Agent Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getMember <em>Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getOwnedAgentType <em>Owned Agent Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentTypeImpl#getGate <em>Gate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlAgentTypeImpl extends SdlBehaviorElementImpl implements SdlAgentType {
	/**
	 * The cached value of the '{@link #getOwnedElement() <em>Owned Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> ownedElement;

	/**
	 * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComment()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsCommentsComment> ownedComment;

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
	 * The cached value of the '{@link #getOwnedMember() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> ownedMember;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> member;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsTypedElementsType> ownedType;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersFeature> feature;

	/**
	 * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralization()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsGeneralization> generalization;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsClassifier> general;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlVariable> variable;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlProcedure> procedure;

	/**
	 * The cached value of the '{@link #getFeaturingClassifier() <em>Featuring Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturingClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersClassifier> featuringClassifier;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsBehavioralFeaturesParameter> parameter;

	/**
	 * The cached value of the '{@link #getAgent() <em>Agent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgent()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlAgent> agent;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final SdlAgentKind KIND_EDEFAULT = SdlAgentKind.PROCESS;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected SdlAgentKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedAgentType() <em>Owned Agent Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAgentType()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlAgentType> ownedAgentType;

	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlChannel> channel;

	/**
	 * The cached value of the '{@link #getGate() <em>Gate</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGate()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlGate> gate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlAgentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlAgentType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getOwnedElement() {
		if (ownedElement == null) {
			ownedElement = new EObjectContainmentWithInverseEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER);
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsOwnershipsElement getOwner() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_TYPE__OWNER) return null;
		return (CoreAbstractionsOwnershipsElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(CoreAbstractionsOwnershipsElement newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EmfSdlPackage.SDL_AGENT_TYPE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(CoreAbstractionsOwnershipsElement newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_TYPE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsCommentsComment> getOwnedComment() {
		if (ownedComment == null) {
			ownedComment = new EObjectContainmentEList<CoreAbstractionsCommentsComment>(CoreAbstractionsCommentsComment.class, this, EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT);
		}
		return ownedComment;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsNamespacesNamespace getNamespace() {
		if (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE) return null;
		return (CoreAbstractionsNamespacesNamespace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(CoreAbstractionsNamespacesNamespace newNamespace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNamespace, EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(CoreAbstractionsNamespacesNamespace newNamespace) {
		if (newNamespace != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE && newNamespace != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE, newNamespace, newNamespace));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER, oldIdentifier, identifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE);
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getMember() {
		if (member == null) {
			member = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_AGENT_TYPE__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsTypedElementsType> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentEList<CoreAbstractionsTypedElementsType>(CoreAbstractionsTypedElementsType.class, this, EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersFeature>(CoreAbstractionsClassifiersFeature.class, this, EmfSdlPackage.SDL_AGENT_TYPE__FEATURE, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER);
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsGeneralization> getGeneralization() {
		if (generalization == null) {
			generalization = new EObjectContainmentWithInverseEList<CoreAbstractionsGeneralizationsGeneralization>(CoreAbstractionsGeneralizationsGeneralization.class, this, EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC);
		}
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> getGeneral() {
		if (general == null) {
			general = new EObjectResolvingEList<CoreAbstractionsGeneralizationsClassifier>(CoreAbstractionsGeneralizationsClassifier.class, this, EmfSdlPackage.SDL_AGENT_TYPE__GENERAL);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlVariable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<SdlVariable>(SdlVariable.class, this, EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlProcedure> getProcedure() {
		if (procedure == null) {
			procedure = new EObjectContainmentEList<SdlProcedure>(SdlProcedure.class, this, EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE);
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier() {
		if (featuringClassifier == null) {
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsBehavioralFeaturesParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectResolvingEList<CoreAbstractionsBehavioralFeaturesParameter>(CoreAbstractionsBehavioralFeaturesParameter.class, this, EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAgent> getAgent() {
		if (agent == null) {
			agent = new EObjectContainmentEList<SdlAgent>(SdlAgent.class, this, EmfSdlPackage.SDL_AGENT_TYPE__AGENT);
		}
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(SdlAgentKind newKind) {
		SdlAgentKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT_TYPE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAgentType> getOwnedAgentType() {
		if (ownedAgentType == null) {
			ownedAgentType = new EObjectContainmentEList<SdlAgentType>(SdlAgentType.class, this, EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE);
		}
		return ownedAgentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlChannel> getChannel() {
		if (channel == null) {
			channel = new EObjectContainmentWithInverseEList<SdlChannel>(SdlChannel.class, this, EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL, EmfSdlPackage.SDL_CHANNEL__AGENT_TYPE);
		}
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlGate> getGate() {
		if (gate == null) {
			gate = new EObjectContainmentWithInverseEList<SdlGate>(SdlGate.class, this, EmfSdlPackage.SDL_AGENT_TYPE__GATE, EmfSdlPackage.SDL_GATE__AGENT_TYPE);
		}
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String isDistinguishableFrom(CoreAbstractionsNamespacesNamedElement n, CoreAbstractionsNamespacesNamespace ns) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> general() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> parents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String conformsTo(CoreAbstractionsGeneralizationsClassifier other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> allFeatures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationInstance instanciate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String conformsTo(CoreAbstractionsTypedElementsType other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNamesOfMember(CoreAbstractionsNamespacesNamedElement element) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String membersAreDistinguishable() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public EList<CoreAbstractionsOwnershipsElement> allOwnedElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String mustBeOwned() {
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElement()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((CoreAbstractionsOwnershipsElement)otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNamespace((CoreAbstractionsNamespacesNamespace)otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralization()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeaturingClassifier()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChannel()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGate()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				return ((InternalEList<?>)getOwnedElement()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				return basicSetOwner(null, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				return basicSetNamespace(null, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
				return ((InternalEList<?>)getAgent()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
				return ((InternalEList<?>)getOwnedAgentType()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				return ((InternalEList<?>)getChannel()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				return ((InternalEList<?>)getGate()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER, CoreAbstractionsNamespacesNamespace.class, msgs);
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				return getOwnedElement();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				return getOwner();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
				return getOwnedComment();
			case EmfSdlPackage.SDL_AGENT_TYPE__NAME:
				return getName();
			case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME:
				return getQualifiedName();
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				return getNamespace();
			case EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.SDL_AGENT_TYPE__MEMBER:
				return getMember();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
				return getOwnedType();
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				return getFeature();
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				return getGeneralization();
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERAL:
				return getGeneral();
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
				return getProcedure();
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER:
				return getParameter();
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
				return getAgent();
			case EmfSdlPackage.SDL_AGENT_TYPE__KIND:
				return getKind();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
				return getOwnedAgentType();
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				return getChannel();
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				return getGate();
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				getOwnedElement().clear();
				getOwnedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends CoreAbstractionsCommentsComment>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__NAME:
				setName((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends CoreAbstractionsTypedElementsType>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends CoreAbstractionsClassifiersFeature>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends CoreAbstractionsGeneralizationsGeneralization>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsGeneralizationsClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends SdlVariable>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends SdlProcedure>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends CoreAbstractionsBehavioralFeaturesParameter>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
				getAgent().clear();
				getAgent().addAll((Collection<? extends SdlAgent>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__KIND:
				setKind((SdlAgentKind)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
				getOwnedAgentType().clear();
				getOwnedAgentType().addAll((Collection<? extends SdlAgentType>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				getChannel().clear();
				getChannel().addAll((Collection<? extends SdlChannel>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				getGate().clear();
				getGate().addAll((Collection<? extends SdlGate>)newValue);
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				getOwnedElement().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)null);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)null);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)null);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__MEMBER:
				getMember().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				getFeature().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				getGeneralization().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERAL:
				getGeneral().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
				getVariable().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
				getProcedure().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
				getAgent().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
				getOwnedAgentType().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				getChannel().clear();
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				getGate().clear();
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
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
				return ownedElement != null && !ownedElement.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNER:
				return getOwner() != null;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE:
				return getNamespace() != null;
			case EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER:
				return identifier != null;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__MEMBER:
				return member != null && !member.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE:
				return feature != null && !feature.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERAL:
				return general != null && !general.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
				return variable != null && !variable.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
				return agent != null && !agent.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__KIND:
				return kind != KIND_EDEFAULT;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
				return ownedAgentType != null && !ownedAgentType.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
				return channel != null && !channel.isEmpty();
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
				return gate != null && !gate.isEmpty();
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
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;
				case EmfSdlPackage.SDL_AGENT_TYPE__OWNER: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;
				case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;
				case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;
				case EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;
				case EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;
				case EmfSdlPackage.SDL_AGENT_TYPE__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE: return EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION;
				case EmfSdlPackage.SDL_AGENT_TYPE__GENERAL: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE: return EmfSdlPackage.SDL_CLASSIFIER__VARIABLE;
				case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE: return EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER: return EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__PARAMETER;
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
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT: return EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER: return EmfSdlPackage.SDL_AGENT_TYPE__OWNER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT: return EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME: return EmfSdlPackage.SDL_AGENT_TYPE__NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME: return EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE: return EmfSdlPackage.SDL_AGENT_TYPE__NAMESPACE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER: return EmfSdlPackage.SDL_AGENT_TYPE__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER: return EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER: return EmfSdlPackage.SDL_AGENT_TYPE__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE: return EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE: return EmfSdlPackage.SDL_AGENT_TYPE__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION: return EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION;
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL: return EmfSdlPackage.SDL_AGENT_TYPE__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE: return EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE;
				case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE: return EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_AGENT_TYPE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__PARAMETER: return EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER;
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
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //SdlAgentTypeImpl
