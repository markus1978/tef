/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hub.sam.sdl.EmfSdlFactory
 * @model kind="package"
 * @generated
 */
public interface EmfSdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sdl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.hub.sam.generated.de/SDL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SDL";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfSdlPackage eINSTANCE = hub.sam.sdl.impl.EmfSdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsElementsElementImpl <em>Core Abstractions Elements Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsElementsElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsElementsElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_ELEMENTS_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Elements Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationCommunicatorImpl <em>Communication Communicator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationCommunicatorImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationCommunicator()
	 * @generated
	 */
	int COMMUNICATION_COMMUNICATOR = 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COMMUNICATOR__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COMMUNICATOR__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Medium</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COMMUNICATOR__MEDIUM = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Communicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COMMUNICATOR_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationContextImpl <em>Communication Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationContextImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationContext()
	 * @generated
	 */
	int COMMUNICATION_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CONTEXT__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CONTEXT__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Context process</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CONTEXT__CONTEXT_PROCESS = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pending Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CONTEXT__PENDING_EVENTS = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communication Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CONTEXT_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationEventImpl <em>Communication Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationEventImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationEvent()
	 * @generated
	 */
	int COMMUNICATION_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Communication Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationEventTypeImpl <em>Communication Event Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationEventTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationEventType()
	 * @generated
	 */
	int COMMUNICATION_EVENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__OWNED_ELEMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__OWNER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__OWNED_COMMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__QUALIFIED_NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__NAMESPACE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE__IDENTIFIER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Communication Event Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_TYPE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsOwnershipsElementImpl <em>Core Abstractions Ownerships Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsOwnershipsElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsOwnershipsElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT = 41;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Ownerships Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsNamespacesNamedElementImpl <em>Core Abstractions Namespaces Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsNamespacesNamedElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsNamespacesNamedElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT = 39;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Core Abstractions Namespaces Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsClassifiersFeatureImpl <em>Core Abstractions Classifiers Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsClassifiersFeatureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsClassifiersFeature()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE = 17;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Classifiers Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationInputImpl <em>Communication Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationInputImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationInput()
	 * @generated
	 */
	int COMMUNICATION_INPUT = 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__LINE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__COLUMN = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__OWNED_ELEMENT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__OWNER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__OWNED_COMMENT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__NAME = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__QUALIFIED_NAME = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__NAMESPACE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__IDENTIFIER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT__TYPE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communication Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INPUT_FEATURE_COUNT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationListenerImpl <em>Communication Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationListenerImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationListener()
	 * @generated
	 */
	int COMMUNICATION_LISTENER = 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LISTENER__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LISTENER__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Communication Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LISTENER_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationMediumImpl <em>Communication Medium</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationMediumImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationMedium()
	 * @generated
	 */
	int COMMUNICATION_MEDIUM = 6;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIUM__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIUM__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Associated Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Medium</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIUM_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CommunicationProcessImpl <em>Communication Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CommunicationProcessImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCommunicationProcess()
	 * @generated
	 */
	int COMMUNICATION_PROCESS = 7;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PROCESS__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PROCESS__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Process input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PROCESS__PROCESS_INPUT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PROCESS_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ConcreteSyntaxSdlIdentifierImpl <em>Concrete Syntax Sdl Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ConcreteSyntaxSdlIdentifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConcreteSyntaxSdlIdentifier()
	 * @generated
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER = 8;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER__NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER__QUALIFIER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concrete Syntax Sdl Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_IDENTIFIER_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ConcreteSyntaxSdlPathItemImpl <em>Concrete Syntax Sdl Path Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ConcreteSyntaxSdlPathItemImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConcreteSyntaxSdlPathItem()
	 * @generated
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM = 9;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM__KIND = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM__NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concrete Syntax Sdl Path Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_PATH_ITEM_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ConcreteSyntaxSdlQualifierImpl <em>Concrete Syntax Sdl Qualifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ConcreteSyntaxSdlQualifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConcreteSyntaxSdlQualifier()
	 * @generated
	 */
	int CONCRETE_SYNTAX_SDL_QUALIFIER = 10;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_QUALIFIER__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_QUALIFIER__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Path Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concrete Syntax Sdl Qualifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_QUALIFIER_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAbstractStateImpl <em>Sdl Abstract State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAbstractStateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAbstractState()
	 * @generated
	 */
	int SDL_ABSTRACT_STATE = 68;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlPseudoStateImpl <em>Sdl Pseudo State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlPseudoStateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPseudoState()
	 * @generated
	 */
	int SDL_PSEUDO_STATE = 115;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ConnectorImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 12;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsNamespacesNamespaceImpl <em>Core Abstractions Namespaces Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsNamespacesNamespaceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsNamespacesNamespace()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE = 40;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsBehavioralFeaturesBehavioralFeatureImpl <em>Core Abstractions Behavioral Features Behavioral Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsBehavioralFeaturesBehavioralFeatureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsBehavioralFeaturesBehavioralFeature()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE = 13;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsBehavioralFeaturesParameterImpl <em>Core Abstractions Behavioral Features Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsBehavioralFeaturesParameterImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsBehavioralFeaturesParameter()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER = 14;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsChangeabilitiesStructuralFeatureImpl <em>Core Abstractions Changeabilities Structural Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsChangeabilitiesStructuralFeatureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsChangeabilitiesStructuralFeature()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CHANGEABILITIES_STRUCTURAL_FEATURE = 15;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsClassifiersClassifierImpl <em>Core Abstractions Classifiers Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsClassifiersClassifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsClassifiersClassifier()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER = 16;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsCommentsCommentImpl <em>Core Abstractions Comments Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsCommentsCommentImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsCommentsComment()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT = 18;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsNamedElementImpl <em>Core Abstractions Constraints Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsConstraintsNamedElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsConstraintsNamedElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT = 20;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsConstraintImpl <em>Core Abstractions Constraints Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsConstraintsConstraintImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsConstraintsConstraint()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT = 19;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsNamespaceImpl <em>Core Abstractions Constraints Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsConstraintsNamespaceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsConstraintsNamespace()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE = 21;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsExpressionsValueSpecificationImpl <em>Core Abstractions Expressions Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsExpressionsValueSpecificationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsExpressionsValueSpecification()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION = 25;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsExpressionsExpressionImpl <em>Core Abstractions Expressions Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsExpressionsExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsExpressionsExpression()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION = 23;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsExpressionsOpaqueExpressionImpl <em>Core Abstractions Expressions Opaque Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsExpressionsOpaqueExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsExpressionsOpaqueExpression()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION = 24;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsTypedElementsTypeImpl <em>Core Abstractions Typed Elements Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsTypedElementsTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsTypedElementsType()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE = 47;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl <em>Core Abstractions Generalizations Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsGeneralizationsClassifier()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER = 26;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsRelationshipImpl <em>Core Abstractions Relationships Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsRelationshipsRelationshipImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsRelationshipsRelationship()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP = 44;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl <em>Core Abstractions Relationships Directed Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsRelationshipsDirectedRelationship()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP = 43;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsGeneralizationImpl <em>Core Abstractions Generalizations Generalization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsGeneralizationsGeneralizationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsGeneralizationsGeneralization()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION = 27;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceSpecificationImpl <em>Core Abstractions Instances Instance Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceSpecificationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsInstancesInstanceSpecification()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION = 28;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceValueImpl <em>Core Abstractions Instances Instance Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsInstancesInstanceValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsInstancesInstanceValue()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE = 29;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsInstancesSlotImpl <em>Core Abstractions Instances Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsInstancesSlotImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsInstancesSlot()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT = 30;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralSpecificationImpl <em>Core Abstractions Literals Literal Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralSpecificationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralSpecification()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION = 34;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralBooleanImpl <em>Core Abstractions Literals Literal Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralBooleanImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralBoolean()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN = 31;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralIntegerImpl <em>Core Abstractions Literals Literal Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralIntegerImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralInteger()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER = 32;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralNullImpl <em>Core Abstractions Literals Literal Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralNullImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralNull()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL = 33;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralStringImpl <em>Core Abstractions Literals Literal String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralStringImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralString()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING = 35;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralUnlimitedNaturalImpl <em>Core Abstractions Literals Literal Unlimited Natural</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsLiteralsLiteralUnlimitedNaturalImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsLiteralsLiteralUnlimitedNatural()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL = 36;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicitiesMultiplicityElementImpl <em>Core Abstractions Multiplicities Multiplicity Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsMultiplicitiesMultiplicityElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsMultiplicitiesMultiplicityElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT = 37;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl <em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsMultiplicityExpressionsMultiplicityElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT = 38;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsRedefinitionsRedefinableElementImpl <em>Core Abstractions Redefinitions Redefinable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsRedefinitionsRedefinableElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsRedefinitionsRedefinableElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT = 42;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsStructuralFeaturesStructuralFeatureImpl <em>Core Abstractions Structural Features Structural Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsStructuralFeaturesStructuralFeatureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsStructuralFeaturesStructuralFeature()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE = 45;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsSuperClassifierImpl <em>Core Abstractions Super Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsSuperClassifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsSuperClassifier()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER = 46;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsTypedElementsTypedElementImpl <em>Core Abstractions Typed Elements Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsTypedElementsTypedElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsTypedElementsTypedElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT = 48;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.CoreAbstractionsVisibilitiesNamedElementImpl <em>Core Abstractions Visibilities Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.CoreAbstractionsVisibilitiesNamedElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsVisibilitiesNamedElement()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_VISIBILITIES_NAMED_ELEMENT = 49;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessImpl <em>Evaluation Behavioral Feature Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationBehavioralFeatureAccess()
	 * @generated
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS = 50;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl <em>Evaluation Behavioral Feature Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationBehavioralFeatureAccessExpression()
	 * @generated
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION = 51;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationDataTypeImpl <em>Evaluation Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationDataTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationDataType()
	 * @generated
	 */
	int EVALUATION_DATA_TYPE = 52;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationEvaluationImpl <em>Evaluation Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationEvaluation()
	 * @generated
	 */
	int EVALUATION_EVALUATION = 53;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationExpressionImpl <em>Evaluation Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationExpression()
	 * @generated
	 */
	int EVALUATION_EXPRESSION = 54;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationFeatureAccessExpressionImpl <em>Evaluation Feature Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationFeatureAccessExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationFeatureAccessExpression()
	 * @generated
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION = 55;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationLiteralImpl <em>Evaluation Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationLiteralImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationLiteral()
	 * @generated
	 */
	int EVALUATION_LITERAL = 56;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.EvaluationLiteralExpressionImpl <em>Evaluation Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.EvaluationLiteralExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getEvaluationLiteralExpression()
	 * @generated
	 */
	int EVALUATION_LITERAL_EXPRESSION = 57;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ForkImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 58;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.StartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.StartImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getStart()
	 * @generated
	 */
	int START = 139;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.HistoryImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getHistory()
	 * @generated
	 */
	int HISTORY = 59;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.InstanciationCreateImpl <em>Instanciation Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.InstanciationCreateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getInstanciationCreate()
	 * @generated
	 */
	int INSTANCIATION_CREATE = 60;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.InstanciationInstanceImpl <em>Instanciation Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.InstanciationInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getInstanciationInstance()
	 * @generated
	 */
	int INSTANCIATION_INSTANCE = 61;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.InstanciationMultiplicityFeatureImpl <em>Instanciation Multiplicity Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.InstanciationMultiplicityFeatureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getInstanciationMultiplicityFeature()
	 * @generated
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE = 62;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.InstanciationSlotImpl <em>Instanciation Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.InstanciationSlotImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getInstanciationSlot()
	 * @generated
	 */
	int INSTANCIATION_SLOT = 63;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.InstanciationValueImpl <em>Instanciation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.InstanciationValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getInstanciationValue()
	 * @generated
	 */
	int INSTANCIATION_VALUE = 64;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.JoinImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 65;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlDataValueImpl <em>Sdl Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlDataValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlDataValue()
	 * @generated
	 */
	int SDL_DATA_VALUE = 87;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlPrimitiveValueImpl <em>Sdl Primitive Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlPrimitiveValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPrimitiveValue()
	 * @generated
	 */
	int SDL_PRIMITIVE_VALUE = 111;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.PidValueImpl <em>Pid Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.PidValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPidValue()
	 * @generated
	 */
	int PID_VALUE = 66;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.StopImpl <em>Stop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.StopImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getStop()
	 * @generated
	 */
	int STOP = 140;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ReturnImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 67;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlActionImpl <em>Sdl Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlActionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAction()
	 * @generated
	 */
	int SDL_ACTION = 69;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAgentImpl <em>Sdl Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAgentImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAgent()
	 * @generated
	 */
	int SDL_AGENT = 70;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlInstanceImpl <em>Sdl Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlInstance()
	 * @generated
	 */
	int SDL_INSTANCE = 95;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAgentInstanceImpl <em>Sdl Agent Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAgentInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAgentInstance()
	 * @generated
	 */
	int SDL_AGENT_INSTANCE = 71;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAgentInstanceSetImpl <em>Sdl Agent Instance Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAgentInstanceSetImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAgentInstanceSet()
	 * @generated
	 */
	int SDL_AGENT_INSTANCE_SET = 72;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlBehaviorElementImpl <em>Sdl Behavior Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlBehaviorElementImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlBehaviorElement()
	 * @generated
	 */
	int SDL_BEHAVIOR_ELEMENT = 76;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAgentTypeImpl <em>Sdl Agent Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAgentTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAgentType()
	 * @generated
	 */
	int SDL_AGENT_TYPE = 73;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlAssignmentImpl <em>Sdl Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlAssignmentImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAssignment()
	 * @generated
	 */
	int SDL_ASSIGNMENT = 74;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlBehaviorImpl <em>Sdl Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlBehaviorImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlBehavior()
	 * @generated
	 */
	int SDL_BEHAVIOR = 75;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlChannelImpl <em>Sdl Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlChannelImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlChannel()
	 * @generated
	 */
	int SDL_CHANNEL = 77;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlChannelEndImpl <em>Sdl Channel End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlChannelEndImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlChannelEnd()
	 * @generated
	 */
	int SDL_CHANNEL_END = 78;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlChannelPathImpl <em>Sdl Channel Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlChannelPathImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlChannelPath()
	 * @generated
	 */
	int SDL_CHANNEL_PATH = 79;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlTriggerImpl <em>Sdl Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlTriggerImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlTrigger()
	 * @generated
	 */
	int SDL_TRIGGER = 134;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlChoiceImpl <em>Sdl Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlChoiceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlChoice()
	 * @generated
	 */
	int SDL_CHOICE = 80;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlNamespaceImpl <em>Sdl Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlNamespaceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlNamespace()
	 * @generated
	 */
	int SDL_NAMESPACE = 100;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlClassifierImpl <em>Sdl Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlClassifierImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlClassifier()
	 * @generated
	 */
	int SDL_CLASSIFIER = 81;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlRangeImpl <em>Sdl Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlRangeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlRange()
	 * @generated
	 */
	int SDL_RANGE = 116;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlClosedRangeImpl <em>Sdl Closed Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlClosedRangeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlClosedRange()
	 * @generated
	 */
	int SDL_CLOSED_RANGE = 82;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlCompositeStateImpl <em>Sdl Composite State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlCompositeStateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlCompositeState()
	 * @generated
	 */
	int SDL_COMPOSITE_STATE = 83;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlCompositeStateInstanceImpl <em>Sdl Composite State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlCompositeStateInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlCompositeStateInstance()
	 * @generated
	 */
	int SDL_COMPOSITE_STATE_INSTANCE = 84;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlCreateImpl <em>Sdl Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlCreateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlCreate()
	 * @generated
	 */
	int SDL_CREATE = 85;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlDataTypeImpl <em>Sdl Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlDataTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlDataType()
	 * @generated
	 */
	int SDL_DATA_TYPE = 86;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlElseImpl <em>Sdl Else</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlElseImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlElse()
	 * @generated
	 */
	int SDL_ELSE = 88;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlEvaluationImpl <em>Sdl Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlEvaluation()
	 * @generated
	 */
	int SDL_EVALUATION = 89;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlGateImpl <em>Sdl Gate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlGateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlGate()
	 * @generated
	 */
	int SDL_GATE = 90;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlGeneralValueImpl <em>Sdl General Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlGeneralValueImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlGeneralValue()
	 * @generated
	 */
	int SDL_GENERAL_VALUE = 91;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlImidiateImpl <em>Sdl Imidiate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlImidiateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlImidiate()
	 * @generated
	 */
	int SDL_IMIDIATE = 92;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlInputImpl <em>Sdl Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlInputImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlInput()
	 * @generated
	 */
	int SDL_INPUT = 93;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlInputInstanceImpl <em>Sdl Input Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlInputInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlInputInstance()
	 * @generated
	 */
	int SDL_INPUT_INSTANCE = 94;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlLiteralImpl <em>Sdl Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlLiteralImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlLiteral()
	 * @generated
	 */
	int SDL_LITERAL = 96;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlLiteralEvaluationImpl <em>Sdl Literal Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlLiteralEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlLiteralEvaluation()
	 * @generated
	 */
	int SDL_LITERAL_EVALUATION = 97;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlLiteralExpressionImpl <em>Sdl Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlLiteralExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlLiteralExpression()
	 * @generated
	 */
	int SDL_LITERAL_EXPRESSION = 98;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlNamedStateImpl <em>Sdl Named State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlNamedStateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlNamedState()
	 * @generated
	 */
	int SDL_NAMED_STATE = 99;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE__TRIGGER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Named State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMED_STATE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlNowExpressionImpl <em>Sdl Now Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlNowExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlNowExpression()
	 * @generated
	 */
	int SDL_NOW_EXPRESSION = 101;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlOpenRangeImpl <em>Sdl Open Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlOpenRangeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlOpenRange()
	 * @generated
	 */
	int SDL_OPEN_RANGE = 102;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlOperationImpl <em>Sdl Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlOperationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlOperation()
	 * @generated
	 */
	int SDL_OPERATION = 103;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlOperationCallImpl <em>Sdl Operation Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlOperationCallImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlOperationCall()
	 * @generated
	 */
	int SDL_OPERATION_CALL = 104;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlOperationEvaluationImpl <em>Sdl Operation Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlOperationEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlOperationEvaluation()
	 * @generated
	 */
	int SDL_OPERATION_EVALUATION = 105;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlOutputImpl <em>Sdl Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlOutputImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlOutput()
	 * @generated
	 */
	int SDL_OUTPUT = 106;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlPackageImpl <em>Sdl Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlPackageImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPackage()
	 * @generated
	 */
	int SDL_PACKAGE = 107;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlVariableImpl <em>Sdl Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlVariableImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlVariable()
	 * @generated
	 */
	int SDL_VARIABLE = 135;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlParameterImpl <em>Sdl Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlParameterImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlParameter()
	 * @generated
	 */
	int SDL_PARAMETER = 108;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlPidExpressionImpl <em>Sdl Pid Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlPidExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPidExpression()
	 * @generated
	 */
	int SDL_PID_EXPRESSION = 109;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlPidExpressionEvaluationImpl <em>Sdl Pid Expression Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlPidExpressionEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPidExpressionEvaluation()
	 * @generated
	 */
	int SDL_PID_EXPRESSION_EVALUATION = 110;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlProcedureImpl <em>Sdl Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlProcedureImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlProcedure()
	 * @generated
	 */
	int SDL_PROCEDURE = 112;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlProcedureCallImpl <em>Sdl Procedure Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlProcedureCallImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlProcedureCall()
	 * @generated
	 */
	int SDL_PROCEDURE_CALL = 113;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlProcedureFrameImpl <em>Sdl Procedure Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlProcedureFrameImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlProcedureFrame()
	 * @generated
	 */
	int SDL_PROCEDURE_FRAME = 114;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlRangeConditionImpl <em>Sdl Range Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlRangeConditionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlRangeCondition()
	 * @generated
	 */
	int SDL_RANGE_CONDITION = 117;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlSetImpl <em>Sdl Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlSetImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlSet()
	 * @generated
	 */
	int SDL_SET = 119;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlResetImpl <em>Sdl Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlResetImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlReset()
	 * @generated
	 */
	int SDL_RESET = 118;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlSignalImpl <em>Sdl Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlSignalImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlSignal()
	 * @generated
	 */
	int SDL_SIGNAL = 120;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlSignalInstanceImpl <em>Sdl Signal Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlSignalInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlSignalInstance()
	 * @generated
	 */
	int SDL_SIGNAL_INSTANCE = 121;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlSplitImpl <em>Sdl Split</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlSplitImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlSplit()
	 * @generated
	 */
	int SDL_SPLIT = 123;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStateImpl <em>Sdl State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStateImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlState()
	 * @generated
	 */
	int SDL_STATE = 124;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStateAutomatonImpl <em>Sdl State Automaton</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStateAutomatonImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStateAutomaton()
	 * @generated
	 */
	int SDL_STATE_AUTOMATON = 125;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStateInstanceImpl <em>Sdl State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStateInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStateInstance()
	 * @generated
	 */
	int SDL_STATE_INSTANCE = 126;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStateNodeImpl <em>Sdl State Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStateNodeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStateNode()
	 * @generated
	 */
	int SDL_STATE_NODE = 127;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStatePartitionImpl <em>Sdl State Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStatePartitionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStatePartition()
	 * @generated
	 */
	int SDL_STATE_PARTITION = 128;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStatePartitionInstanceImpl <em>Sdl State Partition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStatePartitionInstanceImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStatePartitionInstance()
	 * @generated
	 */
	int SDL_STATE_PARTITION_INSTANCE = 129;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlStateTypeImpl <em>Sdl State Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlStateTypeImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStateType()
	 * @generated
	 */
	int SDL_STATE_TYPE = 130;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlTimerImpl <em>Sdl Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlTimerImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlTimer()
	 * @generated
	 */
	int SDL_TIMER = 131;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlTimerActiveExpressionImpl <em>Sdl Timer Active Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlTimerActiveExpressionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlTimerActiveExpression()
	 * @generated
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION = 132;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlTransitionImpl <em>Sdl Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlTransitionImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlTransition()
	 * @generated
	 */
	int SDL_TRANSITION = 133;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlVariableAccessImpl <em>Sdl Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlVariableAccessImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlVariableAccess()
	 * @generated
	 */
	int SDL_VARIABLE_ACCESS = 136;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlVariableAccessEvaluationImpl <em>Sdl Variable Access Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlVariableAccessEvaluationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlVariableAccessEvaluation()
	 * @generated
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION = 137;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlVariableSlotImpl <em>Sdl Variable Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlVariableSlotImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlVariableSlot()
	 * @generated
	 */
	int SDL_VARIABLE_SLOT = 138;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.SdlSpecificationImpl <em>Sdl Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.SdlSpecificationImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlSpecification()
	 * @generated
	 */
	int SDL_SPECIFICATION = 122;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__LINE = SDL_NAMED_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__COLUMN = SDL_NAMED_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__OWNED_ELEMENT = SDL_NAMED_STATE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__OWNER = SDL_NAMED_STATE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__OWNED_COMMENT = SDL_NAMED_STATE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__NAME = SDL_NAMED_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__QUALIFIED_NAME = SDL_NAMED_STATE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__NAMESPACE = SDL_NAMED_STATE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__IDENTIFIER = SDL_NAMED_STATE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__TRIGGER = SDL_NAMED_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__FEATURING_CLASSIFIER = SDL_NAMED_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__TYPED_ELEMENT_TYPE = SDL_NAMED_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__ENTRY = SDL_NAMED_STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE__EXIT = SDL_NAMED_STATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_FEATURE_COUNT = SDL_NAMED_STATE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.impl.ConcreteSyntaxSdlStateListImpl <em>Concrete Syntax Sdl State List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.impl.ConcreteSyntaxSdlStateListImpl
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConcreteSyntaxSdlStateList()
	 * @generated
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST = 11;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__LINE = SDL_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__COLUMN = SDL_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__OWNED_ELEMENT = SDL_STATE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__OWNER = SDL_STATE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__OWNED_COMMENT = SDL_STATE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__NAME = SDL_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__QUALIFIED_NAME = SDL_STATE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__NAMESPACE = SDL_STATE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__IDENTIFIER = SDL_STATE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__TRIGGER = SDL_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__FEATURING_CLASSIFIER = SDL_STATE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__TYPED_ELEMENT_TYPE = SDL_STATE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__ENTRY = SDL_STATE__ENTRY;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__EXIT = SDL_STATE__EXIT;

	/**
	 * The feature id for the '<em><b>Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST__NAMES = SDL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concrete Syntax Sdl State List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_SDL_STATE_LIST_FEATURE_COUNT = SDL_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ABSTRACT_STATE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ABSTRACT_STATE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ABSTRACT_STATE__TRIGGER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Abstract State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ABSTRACT_STATE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PSEUDO_STATE__LINE = SDL_ABSTRACT_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PSEUDO_STATE__COLUMN = SDL_ABSTRACT_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PSEUDO_STATE__TRIGGER = SDL_ABSTRACT_STATE__TRIGGER;

	/**
	 * The number of structural features of the '<em>Sdl Pseudo State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PSEUDO_STATE_FEATURE_COUNT = SDL_ABSTRACT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__OWNED_ELEMENT = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__OWNER = SDL_PSEUDO_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__OWNED_COMMENT = SDL_PSEUDO_STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = SDL_PSEUDO_STATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__QUALIFIED_NAME = SDL_PSEUDO_STATE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAMESPACE = SDL_PSEUDO_STATE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__IDENTIFIER = SDL_PSEUDO_STATE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Namespaces Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Behavioral Features Behavioral Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Behavioral Features Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CHANGEABILITIES_STRUCTURAL_FEATURE__IS_READ_ONLY = 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Changeabilities Structural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CHANGEABILITIES_STRUCTURAL_FEATURE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Classifiers Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__BODY = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT__ANNOTATED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Comments Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_COMMENTS_COMMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__NAMESPACE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Constraints Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__LINE = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__COLUMN = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__OWNED_ELEMENT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__OWNER = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__OWNED_COMMENT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__NAMESPACE = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constrained Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Constraints Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT_FEATURE_COUNT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__LINE = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__COLUMN = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_ELEMENT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNER = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_COMMENT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__NAMESPACE = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Constraints Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE_FEATURE_COUNT = CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Core Abstractions Expressions Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__LINE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__COLUMN = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__OWNED_ELEMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__OWNER = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__OWNED_COMMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__SYMBOL = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__OPERAND = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Expressions Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION_FEATURE_COUNT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__LINE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__COLUMN = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__OWNED_ELEMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__OWNER = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__OWNED_COMMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__BODY = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION__LANGUAGE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Expressions Opaque Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION_FEATURE_COUNT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Core Abstractions Typed Elements Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Core Abstractions Generalizations Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Relationship related Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Relationships Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__LINE = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__COLUMN = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNER = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_COMMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Relationship related Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directed Relationship source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Directed Relationship target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Relationships Directed Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT = CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__LINE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__COLUMN = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__OWNED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__OWNER = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__OWNED_COMMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Relationship related Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__RELATIONSHIP_RELATED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directed Relationship source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__DIRECTED_RELATIONSHIP_SOURCE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE;

	/**
	 * The feature id for the '<em><b>Directed Relationship target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__DIRECTED_RELATIONSHIP_TARGET = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET;

	/**
	 * The feature id for the '<em><b>Specific</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__GENERAL = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Generalizations Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION_FEATURE_COUNT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SLOT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__CLASSIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION__SPECIFICATION = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Instances Instance Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__LINE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__COLUMN = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__OWNED_ELEMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__OWNER = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__OWNED_COMMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE__INSTANCE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Instances Instance Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE_FEATURE_COUNT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owning Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__OWNING_INSTANCE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__VALUE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Defining Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT__DEFINING_FEATURE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Instances Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_INSTANCES_SLOT_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT = CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__LINE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__COLUMN = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__OWNED_ELEMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__OWNER = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__OWNED_COMMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN__VALUE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN_FEATURE_COUNT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__LINE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__COLUMN = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__OWNED_ELEMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__OWNER = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__OWNED_COMMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER__VALUE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER_FEATURE_COUNT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL__LINE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL__COLUMN = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL__OWNED_ELEMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL__OWNER = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL__OWNED_COMMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL_FEATURE_COUNT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__LINE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__COLUMN = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__OWNED_ELEMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__OWNER = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__OWNED_COMMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING__VALUE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING_FEATURE_COUNT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__LINE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__COLUMN = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__OWNED_ELEMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__OWNER = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__OWNED_COMMENT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL__VALUE = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Literals Literal Unlimited Natural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL_FEATURE_COUNT = CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_ORDERED = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_UNIQUE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__LOWER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__UPPER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Core Abstractions Multiplicities Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lower Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Abstractions Redefinitions Redefinable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__LINE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__COLUMN = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_ELEMENT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_COMMENT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAME = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__QUALIFIED_NAME = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAMESPACE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__IDENTIFIER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Structural Features Structural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT = CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Core Abstractions Super Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_SUPER_CLASSIFIER_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Typed Elements Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_VISIBILITIES_NAMED_ELEMENT__VISIBILITY = 0;

	/**
	 * The number of structural features of the '<em>Core Abstractions Visibilities Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ABSTRACTIONS_VISIBILITIES_NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = 0;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Evaluation Behavioral Feature Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Evaluation Behavioral Feature Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Data Type literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evaluation Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_DATA_TYPE_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EVALUATION__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EVALUATION__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EVALUATION__SUB_EVALUATION = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EVALUATION__EVALUATION_VALUE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Evaluation Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EVALUATION_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__OWNED_ELEMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__OWNER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__OWNED_COMMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__QUALIFIED_NAME = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__NAMESPACE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__IDENTIFIER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__SUB_EXPRESSION = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION__TYPE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Evaluation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_EXPRESSION_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__LINE = EVALUATION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__COLUMN = EVALUATION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT = EVALUATION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNER = EVALUATION_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT = EVALUATION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__NAME = EVALUATION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME = EVALUATION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__NAMESPACE = EVALUATION_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__IDENTIFIER = EVALUATION_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION = EVALUATION_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__TYPE = EVALUATION_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evaluation Feature Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT = EVALUATION_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Evaluation Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__LINE = EVALUATION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__COLUMN = EVALUATION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__OWNED_ELEMENT = EVALUATION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__OWNER = EVALUATION_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__OWNED_COMMENT = EVALUATION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__NAME = EVALUATION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__QUALIFIED_NAME = EVALUATION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__NAMESPACE = EVALUATION_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__IDENTIFIER = EVALUATION_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__SUB_EXPRESSION = EVALUATION_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__TYPE = EVALUATION_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION__LITERAL = EVALUATION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evaluation Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_LITERAL_EXPRESSION_FEATURE_COUNT = EVALUATION_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__LINE = START__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__COLUMN = START__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__TRIGGER = START__TRIGGER;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = START_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE__BEHAVIORAL_FEATURE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE__CREATE_CLASSIFIER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instanciation Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_CREATE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_INSTANCE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_INSTANCE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_INSTANCE__SLOT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instanciation Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_INSTANCE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__LINE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__COLUMN = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__OWNED_ELEMENT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__OWNER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__OWNED_COMMENT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__NAME = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__QUALIFIED_NAME = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__NAMESPACE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__IDENTIFIER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__IS_ORDERED = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__IS_UNIQUE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__LOWER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE__UPPER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Instanciation Multiplicity Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_MULTIPLICITY_FEATURE_FEATURE_COUNT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Slot value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_SLOT__SLOT_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Instanciation Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_SLOT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_VALUE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_VALUE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Instanciation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIATION_VALUE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_VALUE__LINE = INSTANCIATION_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_VALUE__COLUMN = INSTANCIATION_VALUE__COLUMN;

	/**
	 * The number of structural features of the '<em>Sdl Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_VALUE_FEATURE_COUNT = INSTANCIATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PRIMITIVE_VALUE__LINE = SDL_DATA_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PRIMITIVE_VALUE__COLUMN = SDL_DATA_VALUE__COLUMN;

	/**
	 * The number of structural features of the '<em>Sdl Primitive Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PRIMITIVE_VALUE_FEATURE_COUNT = SDL_DATA_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_VALUE__LINE = SDL_PRIMITIVE_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_VALUE__COLUMN = SDL_PRIMITIVE_VALUE__COLUMN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_VALUE__VALUE = SDL_PRIMITIVE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pid Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_VALUE_FEATURE_COUNT = SDL_PRIMITIVE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The number of structural features of the '<em>Stop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__LINE = STOP__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__COLUMN = STOP__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__TRIGGER = STOP__TRIGGER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__EXPRESSION = STOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = STOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ACTION__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ACTION__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Sdl Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ACTION_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__IS_ORDERED = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__IS_UNIQUE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__LOWER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__UPPER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Associated Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__ASSOCIATED_CLASSIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT__TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Sdl Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE__LINE = INSTANCIATION_INSTANCE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE__COLUMN = INSTANCIATION_INSTANCE__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE__SLOT = INSTANCIATION_INSTANCE__SLOT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE__VARIABLE = INSTANCIATION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE__CONTAINING_INSTANCE = INSTANCIATION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INSTANCE_FEATURE_COUNT = INSTANCIATION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__LINE = SDL_INSTANCE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__COLUMN = SDL_INSTANCE__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__SLOT = SDL_INSTANCE__SLOT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__VARIABLE = SDL_INSTANCE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__CONTAINING_INSTANCE = SDL_INSTANCE__CONTAINING_INSTANCE;

	/**
	 * The feature id for the '<em><b>Agent Instance Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__AGENT_INSTANCE_SET = SDL_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__BEHAVIOR = SDL_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Instance Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__OWNING_INSTANCE_SET = SDL_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__PARENT = SDL_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Offspring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE__OFFSPRING = SDL_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sdl Agent Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_FEATURE_COUNT = SDL_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Slot value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__SLOT_VALUE = INSTANCIATION_SLOT__SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__LINE = INSTANCIATION_SLOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__COLUMN = INSTANCIATION_SLOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context process</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__CONTEXT_PROCESS = INSTANCIATION_SLOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pending Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__PENDING_EVENTS = INSTANCIATION_SLOT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__VALUE = INSTANCIATION_SLOT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__PROCESS = INSTANCIATION_SLOT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Queue</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__INPUT_QUEUE = INSTANCIATION_SLOT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Agent Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET__AGENT_INSTANCE = INSTANCIATION_SLOT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Sdl Agent Instance Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_INSTANCE_SET_FEATURE_COUNT = INSTANCIATION_SLOT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR_ELEMENT__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR_ELEMENT__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Sdl Behavior Element behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Behavior Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__LINE = SDL_BEHAVIOR_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__COLUMN = SDL_BEHAVIOR_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Sdl Behavior Element behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR = SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNED_ELEMENT = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNED_COMMENT = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__NAME = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__QUALIFIED_NAME = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__NAMESPACE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__IDENTIFIER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNED_MEMBER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__MEMBER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNED_TYPE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__FEATURE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__GENERALIZATION = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__GENERAL = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__VARIABLE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__PROCEDURE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__FEATURING_CLASSIFIER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__BEHAVIORAL_FEATURE_PARAMETER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__AGENT = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__KIND = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Owned Agent Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__OWNED_AGENT_TYPE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__CHANNEL = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__BEHAVIOR = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__PARAMETER = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE__GATE = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 23;

	/**
	 * The number of structural features of the '<em>Sdl Agent Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_AGENT_TYPE_FEATURE_COUNT = SDL_BEHAVIOR_ELEMENT_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ASSIGNMENT__LINE = SDL_ACTION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ASSIGNMENT__COLUMN = SDL_ACTION__COLUMN;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ASSIGNMENT__EXPRESSION = SDL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ASSIGNMENT__VARIABLE = SDL_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ASSIGNMENT_FEATURE_COUNT = SDL_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Sdl Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_BEHAVIOR_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__PATH = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Agent Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL__AGENT_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__LINE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__COLUMN = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__OWNED_ELEMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__OWNER = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__OWNED_COMMENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__AGENT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__GATE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__OPPOSITE = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END__CHANNEL = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl Channel End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_END_FEATURE_COUNT = CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__LINE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__COLUMN = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__OWNED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__OWNER = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__OWNED_COMMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Relationship related Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__RELATIONSHIP_RELATED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Directed Relationship source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__DIRECTED_RELATIONSHIP_SOURCE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE;

	/**
	 * The feature id for the '<em><b>Directed Relationship target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__DIRECTED_RELATIONSHIP_TARGET = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__NAME = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__QUALIFIED_NAME = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__NAMESPACE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__IDENTIFIER = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__SOURCE = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__TARGET = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__SIGNAL = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Related Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__RELATED_ELEMENT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH__CHANNEL = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Sdl Channel Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHANNEL_PATH_FEATURE_COUNT = CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__LINE = COMMUNICATION_INPUT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__COLUMN = COMMUNICATION_INPUT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__OWNED_ELEMENT = COMMUNICATION_INPUT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__OWNER = COMMUNICATION_INPUT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__OWNED_COMMENT = COMMUNICATION_INPUT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__NAME = COMMUNICATION_INPUT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__QUALIFIED_NAME = COMMUNICATION_INPUT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__NAMESPACE = COMMUNICATION_INPUT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__IDENTIFIER = COMMUNICATION_INPUT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__FEATURING_CLASSIFIER = COMMUNICATION_INPUT__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__TYPED_ELEMENT_TYPE = COMMUNICATION_INPUT__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__TYPE = COMMUNICATION_INPUT__TYPE;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER__TRANSITION = COMMUNICATION_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRIGGER_FEATURE_COUNT = COMMUNICATION_INPUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__LINE = SDL_TRIGGER__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__COLUMN = SDL_TRIGGER__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__OWNED_ELEMENT = SDL_TRIGGER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__OWNER = SDL_TRIGGER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__OWNED_COMMENT = SDL_TRIGGER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__NAME = SDL_TRIGGER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__QUALIFIED_NAME = SDL_TRIGGER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__NAMESPACE = SDL_TRIGGER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__IDENTIFIER = SDL_TRIGGER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__FEATURING_CLASSIFIER = SDL_TRIGGER__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__TYPED_ELEMENT_TYPE = SDL_TRIGGER__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__TYPE = SDL_TRIGGER__TYPE;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__TRANSITION = SDL_TRIGGER__TRANSITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE__CONDITION = SDL_TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CHOICE_FEATURE_COUNT = SDL_TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE__OWNED_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NAMESPACE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__LINE = SDL_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__COLUMN = SDL_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__OWNED_ELEMENT = SDL_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__OWNER = SDL_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__OWNED_COMMENT = SDL_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__NAME = SDL_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__QUALIFIED_NAME = SDL_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__NAMESPACE = SDL_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__IDENTIFIER = SDL_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__OWNED_MEMBER = SDL_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__MEMBER = SDL_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__OWNED_TYPE = SDL_NAMESPACE__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__FEATURE = SDL_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__GENERALIZATION = SDL_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__GENERAL = SDL_NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__VARIABLE = SDL_NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER__PROCEDURE = SDL_NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sdl Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLASSIFIER_FEATURE_COUNT = SDL_NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RANGE__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RANGE__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The number of structural features of the '<em>Sdl Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RANGE_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLOSED_RANGE__LINE = SDL_RANGE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLOSED_RANGE__COLUMN = SDL_RANGE__COLUMN;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLOSED_RANGE__UPPER = SDL_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLOSED_RANGE__LOWER = SDL_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Closed Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CLOSED_RANGE_FEATURE_COUNT = SDL_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__TRIGGER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__ENTRY = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__EXIT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE__TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sdl Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__LINE = SDL_INSTANCE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__COLUMN = SDL_INSTANCE__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__SLOT = SDL_INSTANCE__SLOT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__VARIABLE = SDL_INSTANCE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__CONTAINING_INSTANCE = SDL_INSTANCE__CONTAINING_INSTANCE;

	/**
	 * The feature id for the '<em><b>Process input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__PROCESS_INPUT = SDL_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__ACTUAL_STATE = SDL_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__STATE = SDL_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__INPUT = SDL_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__OWNING_INSTANCE = SDL_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Triggered</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__TRIGGERED = SDL_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__SENDER = SDL_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE__STATUS = SDL_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Sdl Composite State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_COMPOSITE_STATE_INSTANCE_FEATURE_COUNT = SDL_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__LINE = INSTANCIATION_CREATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__COLUMN = INSTANCIATION_CREATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = INSTANCIATION_CREATE__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__BEHAVIORAL_FEATURE = INSTANCIATION_CREATE__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__CREATE_CLASSIFIER = INSTANCIATION_CREATE__CREATE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__AGENT = INSTANCIATION_CREATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE__CLASSIFIER = INSTANCIATION_CREATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_CREATE_FEATURE_COUNT = INSTANCIATION_CREATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__LINE = EVALUATION_DATA_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__COLUMN = EVALUATION_DATA_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__OWNED_ELEMENT = EVALUATION_DATA_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__OWNER = EVALUATION_DATA_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__OWNED_COMMENT = EVALUATION_DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__NAME = EVALUATION_DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__QUALIFIED_NAME = EVALUATION_DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__NAMESPACE = EVALUATION_DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__IDENTIFIER = EVALUATION_DATA_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Data Type literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__DATA_TYPE_LITERAL = EVALUATION_DATA_TYPE__DATA_TYPE_LITERAL;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__OWNED_MEMBER = EVALUATION_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__MEMBER = EVALUATION_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__LITERAL = EVALUATION_DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE__OPERATION = EVALUATION_DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_DATA_TYPE_FEATURE_COUNT = EVALUATION_DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__LINE = SDL_CHOICE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__COLUMN = SDL_CHOICE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__OWNED_ELEMENT = SDL_CHOICE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__OWNER = SDL_CHOICE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__OWNED_COMMENT = SDL_CHOICE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__NAME = SDL_CHOICE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__QUALIFIED_NAME = SDL_CHOICE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__NAMESPACE = SDL_CHOICE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__IDENTIFIER = SDL_CHOICE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__FEATURING_CLASSIFIER = SDL_CHOICE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__TYPED_ELEMENT_TYPE = SDL_CHOICE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__TYPE = SDL_CHOICE__TYPE;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__TRANSITION = SDL_CHOICE__TRANSITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE__CONDITION = SDL_CHOICE__CONDITION;

	/**
	 * The number of structural features of the '<em>Sdl Else</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_ELSE_FEATURE_COUNT = SDL_CHOICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION__LINE = EVALUATION_EVALUATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION__COLUMN = EVALUATION_EVALUATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION__SUB_EVALUATION = EVALUATION_EVALUATION__SUB_EVALUATION;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION__EVALUATION_VALUE = EVALUATION_EVALUATION__EVALUATION_VALUE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION__CONTEXT = EVALUATION_EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_EVALUATION_FEATURE_COUNT = EVALUATION_EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__RECEIVE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Send</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__SEND = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Channel End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__CHANNEL_END = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Agent Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE__AGENT_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GATE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GENERAL_VALUE__LINE = SDL_DATA_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GENERAL_VALUE__COLUMN = SDL_DATA_VALUE__COLUMN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GENERAL_VALUE__VALUE = SDL_DATA_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl General Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_GENERAL_VALUE_FEATURE_COUNT = SDL_DATA_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__LINE = SDL_TRIGGER__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__COLUMN = SDL_TRIGGER__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__OWNED_ELEMENT = SDL_TRIGGER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__OWNER = SDL_TRIGGER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__OWNED_COMMENT = SDL_TRIGGER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__NAME = SDL_TRIGGER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__QUALIFIED_NAME = SDL_TRIGGER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__NAMESPACE = SDL_TRIGGER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__IDENTIFIER = SDL_TRIGGER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__FEATURING_CLASSIFIER = SDL_TRIGGER__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__TYPED_ELEMENT_TYPE = SDL_TRIGGER__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__TYPE = SDL_TRIGGER__TYPE;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE__TRANSITION = SDL_TRIGGER__TRANSITION;

	/**
	 * The number of structural features of the '<em>Sdl Imidiate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_IMIDIATE_FEATURE_COUNT = SDL_TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__TRANSITION = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__PARAMETER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT__SIGNAL = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sdl Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT_INSTANCE__LINE = COMMUNICATION_LISTENER__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT_INSTANCE__COLUMN = COMMUNICATION_LISTENER__COLUMN;

	/**
	 * The feature id for the '<em><b>Owning State Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT_INSTANCE__OWNING_STATE_INSTANCE = COMMUNICATION_LISTENER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Input Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_INPUT_INSTANCE_FEATURE_COUNT = COMMUNICATION_LISTENER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__LINE = EVALUATION_LITERAL__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__COLUMN = EVALUATION_LITERAL__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__OWNED_ELEMENT = EVALUATION_LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__OWNER = EVALUATION_LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__OWNED_COMMENT = EVALUATION_LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__NAME = EVALUATION_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__QUALIFIED_NAME = EVALUATION_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__NAMESPACE = EVALUATION_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL__IDENTIFIER = EVALUATION_LITERAL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_FEATURE_COUNT = EVALUATION_LITERAL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__LINE = SDL_EVALUATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__COLUMN = SDL_EVALUATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__SUB_EVALUATION = SDL_EVALUATION__SUB_EVALUATION;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__EVALUATION_VALUE = SDL_EVALUATION__EVALUATION_VALUE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__CONTEXT = SDL_EVALUATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION__VALUE = SDL_EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Literal Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EVALUATION_FEATURE_COUNT = SDL_EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__LINE = EVALUATION_LITERAL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__COLUMN = EVALUATION_LITERAL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__OWNED_ELEMENT = EVALUATION_LITERAL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__OWNER = EVALUATION_LITERAL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__OWNED_COMMENT = EVALUATION_LITERAL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__NAME = EVALUATION_LITERAL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__QUALIFIED_NAME = EVALUATION_LITERAL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__NAMESPACE = EVALUATION_LITERAL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__IDENTIFIER = EVALUATION_LITERAL_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_LITERAL_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__SUB_EXPRESSION = EVALUATION_LITERAL_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__TYPE = EVALUATION_LITERAL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__LITERAL = EVALUATION_LITERAL_EXPRESSION__LITERAL;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION__VALUE = EVALUATION_LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_LITERAL_EXPRESSION_FEATURE_COUNT = EVALUATION_LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__LINE = EVALUATION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__COLUMN = EVALUATION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__OWNED_ELEMENT = EVALUATION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__OWNER = EVALUATION_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__OWNED_COMMENT = EVALUATION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__NAME = EVALUATION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__QUALIFIED_NAME = EVALUATION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__NAMESPACE = EVALUATION_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__IDENTIFIER = EVALUATION_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__SUB_EXPRESSION = EVALUATION_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION__TYPE = EVALUATION_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Sdl Now Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_NOW_EXPRESSION_FEATURE_COUNT = EVALUATION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPEN_RANGE__LINE = SDL_RANGE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPEN_RANGE__COLUMN = SDL_RANGE__COLUMN;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPEN_RANGE__OPERATION = SDL_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPEN_RANGE__EXPRESSION = SDL_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Open Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPEN_RANGE_FEATURE_COUNT = SDL_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__LINE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__COLUMN = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__OWNED_ELEMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__OWNER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__OWNED_COMMENT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__QUALIFIED_NAME = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__NAMESPACE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__IDENTIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__OWNED_MEMBER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__MEMBER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION__PARAMETER = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sdl Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_FEATURE_COUNT = CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__BEHAVIORAL_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__LINE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__COLUMN = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__OWNED_ELEMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__OWNER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__OWNED_COMMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__QUALIFIED_NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__NAMESPACE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__IDENTIFIER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__TYPED_ELEMENT_TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__SUB_EXPRESSION = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL__FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Operation Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_CALL_FEATURE_COUNT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__LINE = SDL_EVALUATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__COLUMN = SDL_EVALUATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__SUB_EVALUATION = SDL_EVALUATION__SUB_EVALUATION;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__EVALUATION_VALUE = SDL_EVALUATION__EVALUATION_VALUE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__CONTEXT = SDL_EVALUATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION__VALUE = SDL_EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Operation Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OPERATION_EVALUATION_FEATURE_COUNT = SDL_EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__LINE = SDL_ACTION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__COLUMN = SDL_ACTION__COLUMN;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = SDL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__BEHAVIORAL_FEATURE = SDL_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__CREATE_CLASSIFIER = SDL_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sdl Output classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__SDL_OUTPUT_CLASSIFIER = SDL_ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__VIA = SDL_ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__TYPE = SDL_ACTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT__TO = SDL_ACTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Sdl Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_OUTPUT_FEATURE_COUNT = SDL_ACTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__LINE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__COLUMN = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__OWNED_ELEMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__OWNER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__OWNED_COMMENT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__QUALIFIED_NAME = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__NAMESPACE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__IDENTIFIER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__OWNED_MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__MEMBER = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__OWNED_TYPE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE__NESTED_PACKAGE = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PACKAGE_FEATURE_COUNT = CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__LINE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__COLUMN = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__OWNED_ELEMENT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__OWNER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__OWNED_COMMENT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__NAME = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__QUALIFIED_NAME = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__NAMESPACE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__IDENTIFIER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__TYPE = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE__INIT_EXPRESSION = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_FEATURE_COUNT = CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__LINE = SDL_VARIABLE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__COLUMN = SDL_VARIABLE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__OWNED_ELEMENT = SDL_VARIABLE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__OWNER = SDL_VARIABLE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__OWNED_COMMENT = SDL_VARIABLE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__NAME = SDL_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__QUALIFIED_NAME = SDL_VARIABLE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__NAMESPACE = SDL_VARIABLE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__IDENTIFIER = SDL_VARIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__FEATURING_CLASSIFIER = SDL_VARIABLE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__TYPED_ELEMENT_TYPE = SDL_VARIABLE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__TYPE = SDL_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__INIT_EXPRESSION = SDL_VARIABLE__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER__KIND = SDL_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PARAMETER_FEATURE_COUNT = SDL_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__LINE = EVALUATION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__COLUMN = EVALUATION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__OWNED_ELEMENT = EVALUATION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__OWNER = EVALUATION_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__OWNED_COMMENT = EVALUATION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__NAME = EVALUATION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__QUALIFIED_NAME = EVALUATION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__NAMESPACE = EVALUATION_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__IDENTIFIER = EVALUATION_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__SUB_EXPRESSION = EVALUATION_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__TYPE = EVALUATION_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION__KIND = EVALUATION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Pid Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_FEATURE_COUNT = EVALUATION_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION__LINE = SDL_EVALUATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION__COLUMN = SDL_EVALUATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION__SUB_EVALUATION = SDL_EVALUATION__SUB_EVALUATION;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION__EVALUATION_VALUE = SDL_EVALUATION__EVALUATION_VALUE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION__CONTEXT = SDL_EVALUATION__CONTEXT;

	/**
	 * The number of structural features of the '<em>Sdl Pid Expression Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PID_EXPRESSION_EVALUATION_FEATURE_COUNT = SDL_EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__LINE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__COLUMN = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__OWNED_ELEMENT = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__OWNER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__OWNED_COMMENT = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__NAME = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__QUALIFIED_NAME = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__NAMESPACE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__IDENTIFIER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__OWNED_MEMBER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__MEMBER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__MEMBER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__FEATURING_CLASSIFIER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__BEHAVIORAL_FEATURE_PARAMETER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__TYPED_ELEMENT_TYPE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sdl Behavior Element behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__OWNED_TYPE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__FEATURE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__GENERALIZATION = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__GENERAL = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__VARIABLE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__PROCEDURE = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__PARAMETER = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Procedure State Automaton</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Sdl Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FEATURE_COUNT = CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__BEHAVIORAL_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__LINE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__COLUMN = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__OWNED_ELEMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__OWNER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__OWNED_COMMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__QUALIFIED_NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__NAMESPACE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__IDENTIFIER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__TYPED_ELEMENT_TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__SUB_EXPRESSION = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__CREATE_CLASSIFIER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL__PROCEDURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Procedure Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_CALL_FEATURE_COUNT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME__LINE = SDL_INSTANCE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME__COLUMN = SDL_INSTANCE__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME__SLOT = SDL_INSTANCE__SLOT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME__VARIABLE = SDL_INSTANCE__VARIABLE;

	/**
	 * The feature id for the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME__CONTAINING_INSTANCE = SDL_INSTANCE__CONTAINING_INSTANCE;

	/**
	 * The number of structural features of the '<em>Sdl Procedure Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_PROCEDURE_FRAME_FEATURE_COUNT = SDL_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Range Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RANGE_CONDITION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__LINE = SDL_OUTPUT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__COLUMN = SDL_OUTPUT__COLUMN;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = SDL_OUTPUT__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__BEHAVIORAL_FEATURE = SDL_OUTPUT__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__CREATE_CLASSIFIER = SDL_OUTPUT__CREATE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Sdl Output classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__SDL_OUTPUT_CLASSIFIER = SDL_OUTPUT__SDL_OUTPUT_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__VIA = SDL_OUTPUT__VIA;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__TYPE = SDL_OUTPUT__TYPE;

	/**
	 * The feature id for the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__TO = SDL_OUTPUT__TO;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__CLASSIFIER = SDL_OUTPUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET__EXPRESSION = SDL_OUTPUT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SET_FEATURE_COUNT = SDL_OUTPUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__LINE = SDL_SET__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__COLUMN = SDL_SET__COLUMN;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = SDL_SET__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__BEHAVIORAL_FEATURE = SDL_SET__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Create classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__CREATE_CLASSIFIER = SDL_SET__CREATE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Sdl Output classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__SDL_OUTPUT_CLASSIFIER = SDL_SET__SDL_OUTPUT_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__VIA = SDL_SET__VIA;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__TYPE = SDL_SET__TYPE;

	/**
	 * The feature id for the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__TO = SDL_SET__TO;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__CLASSIFIER = SDL_SET__CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET__EXPRESSION = SDL_SET__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Sdl Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_RESET_FEATURE_COUNT = SDL_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__LINE = COMMUNICATION_EVENT_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__COLUMN = COMMUNICATION_EVENT_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__OWNED_ELEMENT = COMMUNICATION_EVENT_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__OWNER = COMMUNICATION_EVENT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__OWNED_COMMENT = COMMUNICATION_EVENT_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__NAME = COMMUNICATION_EVENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__QUALIFIED_NAME = COMMUNICATION_EVENT_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__NAMESPACE = COMMUNICATION_EVENT_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__IDENTIFIER = COMMUNICATION_EVENT_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__OWNED_MEMBER = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__MEMBER = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__FEATURING_CLASSIFIER = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__OWNED_TYPE = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__FEATURE = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__GENERALIZATION = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__GENERAL = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__VARIABLE = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__PROCEDURE = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL__PARAMETER = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Sdl Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_FEATURE_COUNT = COMMUNICATION_EVENT_TYPE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__LINE = COMMUNICATION_EVENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__COLUMN = COMMUNICATION_EVENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__SLOT = COMMUNICATION_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__VARIABLE = COMMUNICATION_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containing Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__CONTAINING_INSTANCE = COMMUNICATION_EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__PARAMETER = COMMUNICATION_EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__SENDER = COMMUNICATION_EVENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE__RECEIVER = COMMUNICATION_EVENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Sdl Signal Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SIGNAL_INSTANCE_FEATURE_COUNT = COMMUNICATION_EVENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPECIFICATION__PACKAGES = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPECIFICATION__SYSTEM = 1;

	/**
	 * The number of structural features of the '<em>Sdl Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>Question</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT__QUESTION = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Answer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT__ANSWER = SDL_PSEUDO_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sdl Split</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_SPLIT_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__LINE = SDL_BEHAVIOR__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__COLUMN = SDL_BEHAVIOR__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__OWNED_ELEMENT = SDL_BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__OWNER = SDL_BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__OWNED_COMMENT = SDL_BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__NAME = SDL_BEHAVIOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__QUALIFIED_NAME = SDL_BEHAVIOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__NAMESPACE = SDL_BEHAVIOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__IDENTIFIER = SDL_BEHAVIOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__OWNED_MEMBER = SDL_BEHAVIOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__MEMBER = SDL_BEHAVIOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__STATE = SDL_BEHAVIOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__TRANSITION = SDL_BEHAVIOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Named State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__NAMED_STATE = SDL_BEHAVIOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON__START = SDL_BEHAVIOR_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Sdl State Automaton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_AUTOMATON_FEATURE_COUNT = SDL_BEHAVIOR_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Sdl State Instance actual State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE = 0;

	/**
	 * The number of structural features of the '<em>Sdl State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_INSTANCE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_NODE__LINE = SDL_PSEUDO_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_NODE__COLUMN = SDL_PSEUDO_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_NODE__TRIGGER = SDL_PSEUDO_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_NODE__STATE = SDL_PSEUDO_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl State Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_NODE_FEATURE_COUNT = SDL_PSEUDO_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__LINE = SDL_STATE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__COLUMN = SDL_STATE__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__OWNED_ELEMENT = SDL_STATE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__OWNER = SDL_STATE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__OWNED_COMMENT = SDL_STATE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__NAME = SDL_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__QUALIFIED_NAME = SDL_STATE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__NAMESPACE = SDL_STATE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__IDENTIFIER = SDL_STATE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__TRIGGER = SDL_STATE__TRIGGER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__FEATURING_CLASSIFIER = SDL_STATE__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__TYPED_ELEMENT_TYPE = SDL_STATE__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__ENTRY = SDL_STATE__ENTRY;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__EXIT = SDL_STATE__EXIT;

	/**
	 * The feature id for the '<em><b>Partition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION__PARTITION = SDL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl State Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION_FEATURE_COUNT = SDL_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sdl State Instance actual State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE = SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE;

	/**
	 * The feature id for the '<em><b>Actual State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE = SDL_STATE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl State Partition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_PARTITION_INSTANCE_FEATURE_COUNT = SDL_STATE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__LINE = SDL_CLASSIFIER__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__COLUMN = SDL_CLASSIFIER__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__OWNED_ELEMENT = SDL_CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__OWNER = SDL_CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__OWNED_COMMENT = SDL_CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__NAME = SDL_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__QUALIFIED_NAME = SDL_CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__NAMESPACE = SDL_CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__IDENTIFIER = SDL_CLASSIFIER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__OWNED_MEMBER = SDL_CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__MEMBER = SDL_CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__OWNED_TYPE = SDL_CLASSIFIER__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__FEATURE = SDL_CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__GENERALIZATION = SDL_CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__GENERAL = SDL_CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__VARIABLE = SDL_CLASSIFIER__VARIABLE;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__PROCEDURE = SDL_CLASSIFIER__PROCEDURE;

	/**
	 * The feature id for the '<em><b>Medium</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__MEDIUM = SDL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State Automaton</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__STATE_AUTOMATON = SDL_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE__STATE = SDL_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sdl State Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_STATE_TYPE_FEATURE_COUNT = SDL_CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__LINE = SDL_SIGNAL__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__COLUMN = SDL_SIGNAL__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__OWNED_ELEMENT = SDL_SIGNAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__OWNER = SDL_SIGNAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__OWNED_COMMENT = SDL_SIGNAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__NAME = SDL_SIGNAL__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__QUALIFIED_NAME = SDL_SIGNAL__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__NAMESPACE = SDL_SIGNAL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__IDENTIFIER = SDL_SIGNAL__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__OWNED_MEMBER = SDL_SIGNAL__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__MEMBER = SDL_SIGNAL__MEMBER;

	/**
	 * The feature id for the '<em><b>Featuring Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__FEATURING_CLASSIFIER = SDL_SIGNAL__FEATURING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Behavioral Feature parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__BEHAVIORAL_FEATURE_PARAMETER = SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__OWNED_TYPE = SDL_SIGNAL__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__FEATURE = SDL_SIGNAL__FEATURE;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__GENERALIZATION = SDL_SIGNAL__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__GENERAL = SDL_SIGNAL__GENERAL;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__VARIABLE = SDL_SIGNAL__VARIABLE;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__PROCEDURE = SDL_SIGNAL__PROCEDURE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER__PARAMETER = SDL_SIGNAL__PARAMETER;

	/**
	 * The number of structural features of the '<em>Sdl Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_FEATURE_COUNT = SDL_SIGNAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__BEHAVIORAL_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__LINE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__COLUMN = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__OWNED_ELEMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__OWNER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__OWNED_COMMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__QUALIFIED_NAME = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__NAMESPACE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__IDENTIFIER = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__TYPED_ELEMENT_TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__SUB_EXPRESSION = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__TYPE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__ARGUMENT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Behavioral Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The number of structural features of the '<em>Sdl Timer Active Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TIMER_ACTIVE_EXPRESSION_FEATURE_COUNT = EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__LINE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__COLUMN = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__ACTION = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__SOURCE = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__TARGET = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION__TRIGGER = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sdl Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_TRANSITION_FEATURE_COUNT = CORE_ABSTRACTIONS_ELEMENTS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__LINE = EVALUATION_FEATURE_ACCESS_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__COLUMN = EVALUATION_FEATURE_ACCESS_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__OWNED_ELEMENT = EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__OWNER = EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__OWNED_COMMENT = EVALUATION_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__NAME = EVALUATION_FEATURE_ACCESS_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__QUALIFIED_NAME = EVALUATION_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__NAMESPACE = EVALUATION_FEATURE_ACCESS_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__IDENTIFIER = EVALUATION_FEATURE_ACCESS_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Typed Element type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__TYPED_ELEMENT_TYPE = EVALUATION_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Sub Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__SUB_EXPRESSION = EVALUATION_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__TYPE = EVALUATION_FEATURE_ACCESS_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Feature Access Expression feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__FEATURE_ACCESS_EXPRESSION_FEATURE = EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS__FEATURE = EVALUATION_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_FEATURE_COUNT = EVALUATION_FEATURE_ACCESS_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__LINE = SDL_EVALUATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__COLUMN = SDL_EVALUATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Sub Evaluation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__SUB_EVALUATION = SDL_EVALUATION__SUB_EVALUATION;

	/**
	 * The feature id for the '<em><b>Evaluation value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__EVALUATION_VALUE = SDL_EVALUATION__EVALUATION_VALUE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__CONTEXT = SDL_EVALUATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION__VALUE = SDL_EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Variable Access Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_ACCESS_EVALUATION_FEATURE_COUNT = SDL_EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Slot value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_SLOT__SLOT_VALUE = INSTANCIATION_SLOT__SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_SLOT__VALUE = INSTANCIATION_SLOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sdl Variable Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDL_VARIABLE_SLOT_FEATURE_COUNT = INSTANCIATION_SLOT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind <em>Concrete Syntax Sdl Scope Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getConcreteSyntaxSdlScopeUnitKind()
	 * @generated
	 */
	int CONCRETE_SYNTAX_SDL_SCOPE_UNIT_KIND = 141;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind <em>Core Abstractions Visibilities Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getCoreAbstractionsVisibilitiesVisibilityKind()
	 * @generated
	 */
	int CORE_ABSTRACTIONS_VISIBILITIES_VISIBILITY_KIND = 142;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.SdlAgentKind <em>Sdl Agent Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.SdlAgentKind
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlAgentKind()
	 * @generated
	 */
	int SDL_AGENT_KIND = 143;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.SdlParameterKind <em>Sdl Parameter Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.SdlParameterKind
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlParameterKind()
	 * @generated
	 */
	int SDL_PARAMETER_KIND = 144;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.SdlPidExpressionKind <em>Sdl Pid Expression Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.SdlPidExpressionKind
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlPidExpressionKind()
	 * @generated
	 */
	int SDL_PID_EXPRESSION_KIND = 145;

	/**
	 * The meta object id for the '{@link hub.sam.sdl.SdlStateStatus <em>Sdl State Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.sdl.SdlStateStatus
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getSdlStateStatus()
	 * @generated
	 */
	int SDL_STATE_STATUS = 146;

	/**
	 * The meta object id for the '<em>Primitive Types Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPrimitiveTypesBoolean()
	 * @generated
	 */
	int PRIMITIVE_TYPES_BOOLEAN = 147;

	/**
	 * The meta object id for the '<em>Primitive Types Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPrimitiveTypesInteger()
	 * @generated
	 */
	int PRIMITIVE_TYPES_INTEGER = 148;

	/**
	 * The meta object id for the '<em>Primitive Types Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPrimitiveTypesObject()
	 * @generated
	 */
	int PRIMITIVE_TYPES_OBJECT = 149;

	/**
	 * The meta object id for the '<em>Primitive Types String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPrimitiveTypesString()
	 * @generated
	 */
	int PRIMITIVE_TYPES_STRING = 150;

	/**
	 * The meta object id for the '<em>Primitive Types Unlimited Natural</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see hub.sam.sdl.impl.EmfSdlPackageImpl#getPrimitiveTypesUnlimitedNatural()
	 * @generated
	 */
	int PRIMITIVE_TYPES_UNLIMITED_NATURAL = 151;


	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationCommunicator <em>Communication Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Communicator</em>'.
	 * @see hub.sam.sdl.CommunicationCommunicator
	 * @generated
	 */
	EClass getCommunicationCommunicator();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CommunicationCommunicator#getMedium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Medium</em>'.
	 * @see hub.sam.sdl.CommunicationCommunicator#getMedium()
	 * @see #getCommunicationCommunicator()
	 * @generated
	 */
	EReference getCommunicationCommunicator_Medium();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationContext <em>Communication Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Context</em>'.
	 * @see hub.sam.sdl.CommunicationContext
	 * @generated
	 */
	EClass getCommunicationContext();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CommunicationContext#getContext_process <em>Context process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Context process</em>'.
	 * @see hub.sam.sdl.CommunicationContext#getContext_process()
	 * @see #getCommunicationContext()
	 * @generated
	 */
	EReference getCommunicationContext_Context_process();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CommunicationContext#getPendingEvents <em>Pending Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pending Events</em>'.
	 * @see hub.sam.sdl.CommunicationContext#getPendingEvents()
	 * @see #getCommunicationContext()
	 * @generated
	 */
	EReference getCommunicationContext_PendingEvents();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationEvent <em>Communication Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Event</em>'.
	 * @see hub.sam.sdl.CommunicationEvent
	 * @generated
	 */
	EClass getCommunicationEvent();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationEventType <em>Communication Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Event Type</em>'.
	 * @see hub.sam.sdl.CommunicationEventType
	 * @generated
	 */
	EClass getCommunicationEventType();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationInput <em>Communication Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Input</em>'.
	 * @see hub.sam.sdl.CommunicationInput
	 * @generated
	 */
	EClass getCommunicationInput();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CommunicationInput#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.CommunicationInput#getType()
	 * @see #getCommunicationInput()
	 * @generated
	 */
	EReference getCommunicationInput_Type();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationListener <em>Communication Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Listener</em>'.
	 * @see hub.sam.sdl.CommunicationListener
	 * @generated
	 */
	EClass getCommunicationListener();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationMedium <em>Communication Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Medium</em>'.
	 * @see hub.sam.sdl.CommunicationMedium
	 * @generated
	 */
	EClass getCommunicationMedium();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CommunicationMedium#getAssociatedClassifier <em>Associated Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Classifier</em>'.
	 * @see hub.sam.sdl.CommunicationMedium#getAssociatedClassifier()
	 * @see #getCommunicationMedium()
	 * @generated
	 */
	EReference getCommunicationMedium_AssociatedClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CommunicationProcess <em>Communication Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Process</em>'.
	 * @see hub.sam.sdl.CommunicationProcess
	 * @generated
	 */
	EClass getCommunicationProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CommunicationProcess#getProcess_input <em>Process input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Process input</em>'.
	 * @see hub.sam.sdl.CommunicationProcess#getProcess_input()
	 * @see #getCommunicationProcess()
	 * @generated
	 */
	EReference getCommunicationProcess_Process_input();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier <em>Concrete Syntax Sdl Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax Sdl Identifier</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlIdentifier
	 * @generated
	 */
	EClass getConcreteSyntaxSdlIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getName()
	 * @see #getConcreteSyntaxSdlIdentifier()
	 * @generated
	 */
	EAttribute getConcreteSyntaxSdlIdentifier_Name();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Qualifier</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlIdentifier#getQualifier()
	 * @see #getConcreteSyntaxSdlIdentifier()
	 * @generated
	 */
	EReference getConcreteSyntaxSdlIdentifier_Qualifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem <em>Concrete Syntax Sdl Path Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax Sdl Path Item</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlPathItem
	 * @generated
	 */
	EClass getConcreteSyntaxSdlPathItem();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlPathItem#getKind()
	 * @see #getConcreteSyntaxSdlPathItem()
	 * @generated
	 */
	EAttribute getConcreteSyntaxSdlPathItem_Kind();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlPathItem#getName()
	 * @see #getConcreteSyntaxSdlPathItem()
	 * @generated
	 */
	EAttribute getConcreteSyntaxSdlPathItem_Name();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.ConcreteSyntaxSdlQualifier <em>Concrete Syntax Sdl Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax Sdl Qualifier</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlQualifier
	 * @generated
	 */
	EClass getConcreteSyntaxSdlQualifier();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.ConcreteSyntaxSdlQualifier#getPathItem <em>Path Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path Item</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlQualifier#getPathItem()
	 * @see #getConcreteSyntaxSdlQualifier()
	 * @generated
	 */
	EReference getConcreteSyntaxSdlQualifier_PathItem();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.ConcreteSyntaxSdlStateList <em>Concrete Syntax Sdl State List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax Sdl State List</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlStateList
	 * @generated
	 */
	EClass getConcreteSyntaxSdlStateList();

	/**
	 * Returns the meta object for the attribute list '{@link hub.sam.sdl.ConcreteSyntaxSdlStateList#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Names</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlStateList#getNames()
	 * @see #getConcreteSyntaxSdlStateList()
	 * @generated
	 */
	EAttribute getConcreteSyntaxSdlStateList_Names();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see hub.sam.sdl.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature <em>Core Abstractions Behavioral Features Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Behavioral Features Behavioral Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature
	 * @generated
	 */
	EClass getCoreAbstractionsBehavioralFeaturesBehavioralFeature();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature#getBehavioralFeature_parameter <em>Behavioral Feature parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Behavioral Feature parameter</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature#getBehavioralFeature_parameter()
	 * @see #getCoreAbstractionsBehavioralFeaturesBehavioralFeature()
	 * @generated
	 */
	EReference getCoreAbstractionsBehavioralFeaturesBehavioralFeature_BehavioralFeature_parameter();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter <em>Core Abstractions Behavioral Features Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Behavioral Features Parameter</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter
	 * @generated
	 */
	EClass getCoreAbstractionsBehavioralFeaturesParameter();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature <em>Core Abstractions Changeabilities Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Changeabilities Structural Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature
	 * @generated
	 */
	EClass getCoreAbstractionsChangeabilitiesStructuralFeature();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature#isIsReadOnly <em>Is Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Read Only</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature#isIsReadOnly()
	 * @see #getCoreAbstractionsChangeabilitiesStructuralFeature()
	 * @generated
	 */
	EAttribute getCoreAbstractionsChangeabilitiesStructuralFeature_IsReadOnly();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier <em>Core Abstractions Classifiers Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Classifiers Classifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersClassifier
	 * @generated
	 */
	EClass getCoreAbstractionsClassifiersClassifier();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersClassifier#getFeature()
	 * @see #getCoreAbstractionsClassifiersClassifier()
	 * @generated
	 */
	EReference getCoreAbstractionsClassifiersClassifier_Feature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsClassifiersFeature <em>Core Abstractions Classifiers Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Classifiers Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersFeature
	 * @generated
	 */
	EClass getCoreAbstractionsClassifiersFeature();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsClassifiersFeature#getFeaturingClassifier <em>Featuring Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Featuring Classifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersFeature#getFeaturingClassifier()
	 * @see #getCoreAbstractionsClassifiersFeature()
	 * @generated
	 */
	EReference getCoreAbstractionsClassifiersFeature_FeaturingClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsCommentsComment <em>Core Abstractions Comments Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Comments Comment</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsCommentsComment
	 * @generated
	 */
	EClass getCoreAbstractionsCommentsComment();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsCommentsComment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsCommentsComment#getBody()
	 * @see #getCoreAbstractionsCommentsComment()
	 * @generated
	 */
	EAttribute getCoreAbstractionsCommentsComment_Body();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsCommentsComment#getAnnotatedElement <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotated Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsCommentsComment#getAnnotatedElement()
	 * @see #getCoreAbstractionsCommentsComment()
	 * @generated
	 */
	EReference getCoreAbstractionsCommentsComment_AnnotatedElement();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint <em>Core Abstractions Constraints Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Constraints Constraint</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint
	 * @generated
	 */
	EClass getCoreAbstractionsConstraintsConstraint();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext()
	 * @see #getCoreAbstractionsConstraintsConstraint()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsConstraint_Context();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getSpecification()
	 * @see #getCoreAbstractionsConstraintsConstraint()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsConstraint_Specification();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getConstrainedElement <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constrained Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getConstrainedElement()
	 * @see #getCoreAbstractionsConstraintsConstraint()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsConstraint_ConstrainedElement();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement <em>Core Abstractions Constraints Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Constraints Named Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamedElement
	 * @generated
	 */
	EClass getCoreAbstractionsConstraintsNamedElement();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Namespace</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamedElement#getNamespace()
	 * @see #getCoreAbstractionsConstraintsNamedElement()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsNamedElement_Namespace();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace <em>Core Abstractions Constraints Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Constraints Namespace</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace
	 * @generated
	 */
	EClass getCoreAbstractionsConstraintsNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedRule <em>Owned Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rule</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedRule()
	 * @see #getCoreAbstractionsConstraintsNamespace()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsNamespace_OwnedRule();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Member</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedMember()
	 * @see #getCoreAbstractionsConstraintsNamespace()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsNamespace_OwnedMember();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getMember()
	 * @see #getCoreAbstractionsConstraintsNamespace()
	 * @generated
	 */
	EReference getCoreAbstractionsConstraintsNamespace_Member();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsElementsElement <em>Core Abstractions Elements Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Elements Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsElementsElement
	 * @generated
	 */
	EClass getCoreAbstractionsElementsElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsElementsElement#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsElementsElement#getLine()
	 * @see #getCoreAbstractionsElementsElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsElementsElement_Line();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsElementsElement#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsElementsElement#getColumn()
	 * @see #getCoreAbstractionsElementsElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsElementsElement_Column();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression <em>Core Abstractions Expressions Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Expressions Expression</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsExpression
	 * @generated
	 */
	EClass getCoreAbstractionsExpressionsExpression();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsExpression#getSymbol()
	 * @see #getCoreAbstractionsExpressionsExpression()
	 * @generated
	 */
	EAttribute getCoreAbstractionsExpressionsExpression_Symbol();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operand</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsExpression#getOperand()
	 * @see #getCoreAbstractionsExpressionsExpression()
	 * @generated
	 */
	EReference getCoreAbstractionsExpressionsExpression_Operand();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression <em>Core Abstractions Expressions Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Expressions Opaque Expression</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression
	 * @generated
	 */
	EClass getCoreAbstractionsExpressionsOpaqueExpression();

	/**
	 * Returns the meta object for the attribute list '{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Body</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getBody()
	 * @see #getCoreAbstractionsExpressionsOpaqueExpression()
	 * @generated
	 */
	EAttribute getCoreAbstractionsExpressionsOpaqueExpression_Body();

	/**
	 * Returns the meta object for the attribute list '{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Language</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression#getLanguage()
	 * @see #getCoreAbstractionsExpressionsOpaqueExpression()
	 * @generated
	 */
	EAttribute getCoreAbstractionsExpressionsOpaqueExpression_Language();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification <em>Core Abstractions Expressions Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Expressions Value Specification</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification
	 * @generated
	 */
	EClass getCoreAbstractionsExpressionsValueSpecification();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier <em>Core Abstractions Generalizations Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Generalizations Classifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier
	 * @generated
	 */
	EClass getCoreAbstractionsGeneralizationsClassifier();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneralization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generalization</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneralization()
	 * @see #getCoreAbstractionsGeneralizationsClassifier()
	 * @generated
	 */
	EReference getCoreAbstractionsGeneralizationsClassifier_Generalization();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>General</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier#getGeneral()
	 * @see #getCoreAbstractionsGeneralizationsClassifier()
	 * @generated
	 */
	EReference getCoreAbstractionsGeneralizationsClassifier_General();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization <em>Core Abstractions Generalizations Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Generalizations Generalization</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization
	 * @generated
	 */
	EClass getCoreAbstractionsGeneralizationsGeneralization();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specific</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getSpecific()
	 * @see #getCoreAbstractionsGeneralizationsGeneralization()
	 * @generated
	 */
	EReference getCoreAbstractionsGeneralizationsGeneralization_Specific();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>General</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization#getGeneral()
	 * @see #getCoreAbstractionsGeneralizationsGeneralization()
	 * @generated
	 */
	EReference getCoreAbstractionsGeneralizationsGeneralization_General();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification <em>Core Abstractions Instances Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Instances Instance Specification</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification
	 * @generated
	 */
	EClass getCoreAbstractionsInstancesInstanceSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slot</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSlot()
	 * @see #getCoreAbstractionsInstancesInstanceSpecification()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesInstanceSpecification_Slot();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Classifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getClassifier()
	 * @see #getCoreAbstractionsInstancesInstanceSpecification()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesInstanceSpecification_Classifier();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification#getSpecification()
	 * @see #getCoreAbstractionsInstancesInstanceSpecification()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesInstanceSpecification_Specification();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceValue <em>Core Abstractions Instances Instance Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Instances Instance Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceValue
	 * @generated
	 */
	EClass getCoreAbstractionsInstancesInstanceValue();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceValue#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceValue#getInstance()
	 * @see #getCoreAbstractionsInstancesInstanceValue()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesInstanceValue_Instance();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot <em>Core Abstractions Instances Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Instances Slot</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot
	 * @generated
	 */
	EClass getCoreAbstractionsInstancesSlot();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot#getOwningInstance()
	 * @see #getCoreAbstractionsInstancesSlot()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesSlot_OwningInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot#getValue()
	 * @see #getCoreAbstractionsInstancesSlot()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesSlot_Value();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot#getDefiningFeature <em>Defining Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defining Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot#getDefiningFeature()
	 * @see #getCoreAbstractionsInstancesSlot()
	 * @generated
	 */
	EReference getCoreAbstractionsInstancesSlot_DefiningFeature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean <em>Core Abstractions Literals Literal Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal Boolean</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralBoolean();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean#isValue()
	 * @see #getCoreAbstractionsLiteralsLiteralBoolean()
	 * @generated
	 */
	EAttribute getCoreAbstractionsLiteralsLiteralBoolean_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger <em>Core Abstractions Literals Literal Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal Integer</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralInteger();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger#getValue()
	 * @see #getCoreAbstractionsLiteralsLiteralInteger()
	 * @generated
	 */
	EAttribute getCoreAbstractionsLiteralsLiteralInteger_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralNull <em>Core Abstractions Literals Literal Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal Null</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralNull
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralNull();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralSpecification <em>Core Abstractions Literals Literal Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal Specification</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralSpecification
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralSpecification();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralString <em>Core Abstractions Literals Literal String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal String</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralString
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralString();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralString#getValue()
	 * @see #getCoreAbstractionsLiteralsLiteralString()
	 * @generated
	 */
	EAttribute getCoreAbstractionsLiteralsLiteralString_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural <em>Core Abstractions Literals Literal Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Literals Literal Unlimited Natural</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural
	 * @generated
	 */
	EClass getCoreAbstractionsLiteralsLiteralUnlimitedNatural();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural#getValue()
	 * @see #getCoreAbstractionsLiteralsLiteralUnlimitedNatural()
	 * @generated
	 */
	EAttribute getCoreAbstractionsLiteralsLiteralUnlimitedNatural_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement <em>Core Abstractions Multiplicities Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Multiplicities Multiplicity Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement
	 * @generated
	 */
	EClass getCoreAbstractionsMultiplicitiesMultiplicityElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsOrdered()
	 * @see #getCoreAbstractionsMultiplicitiesMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#isIsUnique()
	 * @see #getCoreAbstractionsMultiplicitiesMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_IsUnique();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getLower()
	 * @see #getCoreAbstractionsMultiplicitiesMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_Lower();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement#getUpper()
	 * @see #getCoreAbstractionsMultiplicitiesMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_Upper();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement <em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement
	 * @generated
	 */
	EClass getCoreAbstractionsMultiplicityExpressionsMultiplicityElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getLower()
	 * @see #getCoreAbstractionsMultiplicityExpressionsMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_Lower();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getUpper()
	 * @see #getCoreAbstractionsMultiplicityExpressionsMultiplicityElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_Upper();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getUpperValue <em>Upper Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getUpperValue()
	 * @see #getCoreAbstractionsMultiplicityExpressionsMultiplicityElement()
	 * @generated
	 */
	EReference getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_UpperValue();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getLowerValue <em>Lower Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Value</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement#getLowerValue()
	 * @see #getCoreAbstractionsMultiplicityExpressionsMultiplicityElement()
	 * @generated
	 */
	EReference getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_LowerValue();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement <em>Core Abstractions Namespaces Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Namespaces Named Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement
	 * @generated
	 */
	EClass getCoreAbstractionsNamespacesNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getName()
	 * @see #getCoreAbstractionsNamespacesNamedElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsNamespacesNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getQualifiedName()
	 * @see #getCoreAbstractionsNamespacesNamedElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsNamespacesNamedElement_QualifiedName();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Namespace</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getNamespace()
	 * @see #getCoreAbstractionsNamespacesNamedElement()
	 * @generated
	 */
	EReference getCoreAbstractionsNamespacesNamedElement_Namespace();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement#getIdentifier()
	 * @see #getCoreAbstractionsNamespacesNamedElement()
	 * @generated
	 */
	EReference getCoreAbstractionsNamespacesNamedElement_Identifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace <em>Core Abstractions Namespaces Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Namespaces Namespace</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamespace
	 * @generated
	 */
	EClass getCoreAbstractionsNamespacesNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Member</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getOwnedMember()
	 * @see #getCoreAbstractionsNamespacesNamespace()
	 * @generated
	 */
	EReference getCoreAbstractionsNamespacesNamespace_OwnedMember();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamespace#getMember()
	 * @see #getCoreAbstractionsNamespacesNamespace()
	 * @generated
	 */
	EReference getCoreAbstractionsNamespacesNamespace_Member();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement <em>Core Abstractions Ownerships Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Ownerships Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement
	 * @generated
	 */
	EClass getCoreAbstractionsOwnershipsElement();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedElement()
	 * @see #getCoreAbstractionsOwnershipsElement()
	 * @generated
	 */
	EReference getCoreAbstractionsOwnershipsElement_OwnedElement();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwner()
	 * @see #getCoreAbstractionsOwnershipsElement()
	 * @generated
	 */
	EReference getCoreAbstractionsOwnershipsElement_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedComment <em>Owned Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Comment</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement#getOwnedComment()
	 * @see #getCoreAbstractionsOwnershipsElement()
	 * @generated
	 */
	EReference getCoreAbstractionsOwnershipsElement_OwnedComment();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement <em>Core Abstractions Redefinitions Redefinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Redefinitions Redefinable Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement
	 * @generated
	 */
	EClass getCoreAbstractionsRedefinitionsRedefinableElement();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinedElement <em>Redefined Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinedElement()
	 * @see #getCoreAbstractionsRedefinitionsRedefinableElement()
	 * @generated
	 */
	EReference getCoreAbstractionsRedefinitionsRedefinableElement_RedefinedElement();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinitionContext <em>Redefinition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefinition Context</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinitionContext()
	 * @see #getCoreAbstractionsRedefinitionsRedefinableElement()
	 * @generated
	 */
	EReference getCoreAbstractionsRedefinitionsRedefinableElement_RedefinitionContext();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship <em>Core Abstractions Relationships Directed Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Relationships Directed Relationship</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship
	 * @generated
	 */
	EClass getCoreAbstractionsRelationshipsDirectedRelationship();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_source <em>Directed Relationship source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Directed Relationship source</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_source()
	 * @see #getCoreAbstractionsRelationshipsDirectedRelationship()
	 * @generated
	 */
	EReference getCoreAbstractionsRelationshipsDirectedRelationship_DirectedRelationship_source();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_target <em>Directed Relationship target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Directed Relationship target</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_target()
	 * @see #getCoreAbstractionsRelationshipsDirectedRelationship()
	 * @generated
	 */
	EReference getCoreAbstractionsRelationshipsDirectedRelationship_DirectedRelationship_target();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsRelationshipsRelationship <em>Core Abstractions Relationships Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Relationships Relationship</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsRelationship
	 * @generated
	 */
	EClass getCoreAbstractionsRelationshipsRelationship();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsRelationshipsRelationship#getRelationship_relatedElement <em>Relationship related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relationship related Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsRelationship#getRelationship_relatedElement()
	 * @see #getCoreAbstractionsRelationshipsRelationship()
	 * @generated
	 */
	EReference getCoreAbstractionsRelationshipsRelationship_Relationship_relatedElement();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature <em>Core Abstractions Structural Features Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Structural Features Structural Feature</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature
	 * @generated
	 */
	EClass getCoreAbstractionsStructuralFeaturesStructuralFeature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier <em>Core Abstractions Super Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Super Classifier</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsSuperClassifier
	 * @generated
	 */
	EClass getCoreAbstractionsSuperClassifier();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsSuperClassifier#isIsAbstract()
	 * @see #getCoreAbstractionsSuperClassifier()
	 * @generated
	 */
	EAttribute getCoreAbstractionsSuperClassifier_IsAbstract();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#getInheritedMember <em>Inherited Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherited Member</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsSuperClassifier#getInheritedMember()
	 * @see #getCoreAbstractionsSuperClassifier()
	 * @generated
	 */
	EReference getCoreAbstractionsSuperClassifier_InheritedMember();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>General</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsSuperClassifier#getGeneral()
	 * @see #getCoreAbstractionsSuperClassifier()
	 * @generated
	 */
	EReference getCoreAbstractionsSuperClassifier_General();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsTypedElementsType <em>Core Abstractions Typed Elements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Typed Elements Type</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsTypedElementsType
	 * @generated
	 */
	EClass getCoreAbstractionsTypedElementsType();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement <em>Core Abstractions Typed Elements Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Typed Elements Typed Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement
	 * @generated
	 */
	EClass getCoreAbstractionsTypedElementsTypedElement();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getTypedElement_type <em>Typed Element type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Element type</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement#getTypedElement_type()
	 * @see #getCoreAbstractionsTypedElementsTypedElement()
	 * @generated
	 */
	EReference getCoreAbstractionsTypedElementsTypedElement_TypedElement_type();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement <em>Core Abstractions Visibilities Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Abstractions Visibilities Named Element</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement
	 * @generated
	 */
	EClass getCoreAbstractionsVisibilitiesNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement#getVisibility()
	 * @see #getCoreAbstractionsVisibilitiesNamedElement()
	 * @generated
	 */
	EAttribute getCoreAbstractionsVisibilitiesNamedElement_Visibility();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess <em>Evaluation Behavioral Feature Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Behavioral Feature Access</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccess
	 * @generated
	 */
	EClass getEvaluationBehavioralFeatureAccess();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeatureAccess_argument <em>Behavioral Feature Access argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavioral Feature Access argument</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeatureAccess_argument()
	 * @see #getEvaluationBehavioralFeatureAccess()
	 * @generated
	 */
	EReference getEvaluationBehavioralFeatureAccess_BehavioralFeatureAccess_argument();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeature <em>Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavioral Feature</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccess#getBehavioralFeature()
	 * @see #getEvaluationBehavioralFeatureAccess()
	 * @generated
	 */
	EReference getEvaluationBehavioralFeatureAccess_BehavioralFeature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression <em>Evaluation Behavioral Feature Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Behavioral Feature Access Expression</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression
	 * @generated
	 */
	EClass getEvaluationBehavioralFeatureAccessExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getArgument()
	 * @see #getEvaluationBehavioralFeatureAccessExpression()
	 * @generated
	 */
	EReference getEvaluationBehavioralFeatureAccessExpression_Argument();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getBehavioralFeatureAccessExpression_feature <em>Behavioral Feature Access Expression feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavioral Feature Access Expression feature</em>'.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression#getBehavioralFeatureAccessExpression_feature()
	 * @see #getEvaluationBehavioralFeatureAccessExpression()
	 * @generated
	 */
	EReference getEvaluationBehavioralFeatureAccessExpression_BehavioralFeatureAccessExpression_feature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationDataType <em>Evaluation Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Data Type</em>'.
	 * @see hub.sam.sdl.EvaluationDataType
	 * @generated
	 */
	EClass getEvaluationDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.EvaluationDataType#getDataType_literal <em>Data Type literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Type literal</em>'.
	 * @see hub.sam.sdl.EvaluationDataType#getDataType_literal()
	 * @see #getEvaluationDataType()
	 * @generated
	 */
	EReference getEvaluationDataType_DataType_literal();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationEvaluation <em>Evaluation Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Evaluation</em>'.
	 * @see hub.sam.sdl.EvaluationEvaluation
	 * @generated
	 */
	EClass getEvaluationEvaluation();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.EvaluationEvaluation#getSubEvaluation <em>Sub Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Evaluation</em>'.
	 * @see hub.sam.sdl.EvaluationEvaluation#getSubEvaluation()
	 * @see #getEvaluationEvaluation()
	 * @generated
	 */
	EReference getEvaluationEvaluation_SubEvaluation();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationEvaluation#getEvaluation_value <em>Evaluation value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluation value</em>'.
	 * @see hub.sam.sdl.EvaluationEvaluation#getEvaluation_value()
	 * @see #getEvaluationEvaluation()
	 * @generated
	 */
	EReference getEvaluationEvaluation_Evaluation_value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationExpression <em>Evaluation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Expression</em>'.
	 * @see hub.sam.sdl.EvaluationExpression
	 * @generated
	 */
	EClass getEvaluationExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.EvaluationExpression#getSubExpression <em>Sub Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expression</em>'.
	 * @see hub.sam.sdl.EvaluationExpression#getSubExpression()
	 * @see #getEvaluationExpression()
	 * @generated
	 */
	EReference getEvaluationExpression_SubExpression();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.EvaluationExpression#getType()
	 * @see #getEvaluationExpression()
	 * @generated
	 */
	EReference getEvaluationExpression_Type();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationFeatureAccessExpression <em>Evaluation Feature Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Feature Access Expression</em>'.
	 * @see hub.sam.sdl.EvaluationFeatureAccessExpression
	 * @generated
	 */
	EClass getEvaluationFeatureAccessExpression();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationFeatureAccessExpression#getFeatureAccessExpression_feature <em>Feature Access Expression feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Access Expression feature</em>'.
	 * @see hub.sam.sdl.EvaluationFeatureAccessExpression#getFeatureAccessExpression_feature()
	 * @see #getEvaluationFeatureAccessExpression()
	 * @generated
	 */
	EReference getEvaluationFeatureAccessExpression_FeatureAccessExpression_feature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationLiteral <em>Evaluation Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Literal</em>'.
	 * @see hub.sam.sdl.EvaluationLiteral
	 * @generated
	 */
	EClass getEvaluationLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.EvaluationLiteralExpression <em>Evaluation Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Literal Expression</em>'.
	 * @see hub.sam.sdl.EvaluationLiteralExpression
	 * @generated
	 */
	EClass getEvaluationLiteralExpression();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.EvaluationLiteralExpression#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see hub.sam.sdl.EvaluationLiteralExpression#getLiteral()
	 * @see #getEvaluationLiteralExpression()
	 * @generated
	 */
	EReference getEvaluationLiteralExpression_Literal();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see hub.sam.sdl.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see hub.sam.sdl.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.InstanciationCreate <em>Instanciation Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciation Create</em>'.
	 * @see hub.sam.sdl.InstanciationCreate
	 * @generated
	 */
	EClass getInstanciationCreate();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.InstanciationCreate#getCreate_classifier <em>Create classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Create classifier</em>'.
	 * @see hub.sam.sdl.InstanciationCreate#getCreate_classifier()
	 * @see #getInstanciationCreate()
	 * @generated
	 */
	EReference getInstanciationCreate_Create_classifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.InstanciationInstance <em>Instanciation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciation Instance</em>'.
	 * @see hub.sam.sdl.InstanciationInstance
	 * @generated
	 */
	EClass getInstanciationInstance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.InstanciationInstance#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot</em>'.
	 * @see hub.sam.sdl.InstanciationInstance#getSlot()
	 * @see #getInstanciationInstance()
	 * @generated
	 */
	EReference getInstanciationInstance_Slot();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.InstanciationMultiplicityFeature <em>Instanciation Multiplicity Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciation Multiplicity Feature</em>'.
	 * @see hub.sam.sdl.InstanciationMultiplicityFeature
	 * @generated
	 */
	EClass getInstanciationMultiplicityFeature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.InstanciationSlot <em>Instanciation Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciation Slot</em>'.
	 * @see hub.sam.sdl.InstanciationSlot
	 * @generated
	 */
	EClass getInstanciationSlot();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.InstanciationSlot#getSlot_value <em>Slot value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slot value</em>'.
	 * @see hub.sam.sdl.InstanciationSlot#getSlot_value()
	 * @see #getInstanciationSlot()
	 * @generated
	 */
	EReference getInstanciationSlot_Slot_value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.InstanciationValue <em>Instanciation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciation Value</em>'.
	 * @see hub.sam.sdl.InstanciationValue
	 * @generated
	 */
	EClass getInstanciationValue();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see hub.sam.sdl.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.PidValue <em>Pid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pid Value</em>'.
	 * @see hub.sam.sdl.PidValue
	 * @generated
	 */
	EClass getPidValue();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.PidValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see hub.sam.sdl.PidValue#getValue()
	 * @see #getPidValue()
	 * @generated
	 */
	EReference getPidValue_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see hub.sam.sdl.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.Return#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see hub.sam.sdl.Return#getExpression()
	 * @see #getReturn()
	 * @generated
	 */
	EReference getReturn_Expression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAbstractState <em>Sdl Abstract State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Abstract State</em>'.
	 * @see hub.sam.sdl.SdlAbstractState
	 * @generated
	 */
	EClass getSdlAbstractState();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAbstractState#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trigger</em>'.
	 * @see hub.sam.sdl.SdlAbstractState#getTrigger()
	 * @see #getSdlAbstractState()
	 * @generated
	 */
	EReference getSdlAbstractState_Trigger();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAction <em>Sdl Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Action</em>'.
	 * @see hub.sam.sdl.SdlAction
	 * @generated
	 */
	EClass getSdlAction();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAgent <em>Sdl Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Agent</em>'.
	 * @see hub.sam.sdl.SdlAgent
	 * @generated
	 */
	EClass getSdlAgent();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlAgent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.SdlAgent#getType()
	 * @see #getSdlAgent()
	 * @generated
	 */
	EReference getSdlAgent_Type();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAgentInstance <em>Sdl Agent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Agent Instance</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance
	 * @generated
	 */
	EClass getSdlAgentInstance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet <em>Agent Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Agent Instance Set</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet()
	 * @see #getSdlAgentInstance()
	 * @generated
	 */
	EReference getSdlAgentInstance_AgentInstanceSet();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlAgentInstance#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance#getBehavior()
	 * @see #getSdlAgentInstance()
	 * @generated
	 */
	EReference getSdlAgentInstance_Behavior();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet <em>Owning Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance Set</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet()
	 * @see #getSdlAgentInstance()
	 * @generated
	 */
	EReference getSdlAgentInstance_OwningInstanceSet();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlAgentInstance#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance#getParent()
	 * @see #getSdlAgentInstance()
	 * @generated
	 */
	EReference getSdlAgentInstance_Parent();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlAgentInstance#getOffspring <em>Offspring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Offspring</em>'.
	 * @see hub.sam.sdl.SdlAgentInstance#getOffspring()
	 * @see #getSdlAgentInstance()
	 * @generated
	 */
	EReference getSdlAgentInstance_Offspring();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAgentInstanceSet <em>Sdl Agent Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Agent Instance Set</em>'.
	 * @see hub.sam.sdl.SdlAgentInstanceSet
	 * @generated
	 */
	EClass getSdlAgentInstanceSet();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentInstanceSet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getValue()
	 * @see #getSdlAgentInstanceSet()
	 * @generated
	 */
	EReference getSdlAgentInstanceSet_Value();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlAgentInstanceSet#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Process</em>'.
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getProcess()
	 * @see #getSdlAgentInstanceSet()
	 * @generated
	 */
	EReference getSdlAgentInstanceSet_Process();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentInstanceSet#getInputQueue <em>Input Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Queue</em>'.
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getInputQueue()
	 * @see #getSdlAgentInstanceSet()
	 * @generated
	 */
	EReference getSdlAgentInstanceSet_InputQueue();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance <em>Agent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Agent Instance</em>'.
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance()
	 * @see #getSdlAgentInstanceSet()
	 * @generated
	 */
	EReference getSdlAgentInstanceSet_AgentInstance();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAgentType <em>Sdl Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Agent Type</em>'.
	 * @see hub.sam.sdl.SdlAgentType
	 * @generated
	 */
	EClass getSdlAgentType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentType#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agent</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getAgent()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_Agent();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlAgentType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getKind()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EAttribute getSdlAgentType_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentType#getOwnedAgentType <em>Owned Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Agent Type</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getOwnedAgentType()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_OwnedAgentType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentType#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channel</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getChannel()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_Channel();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlAgentType#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getBehavior()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_Behavior();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getParameter()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlAgentType#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gate</em>'.
	 * @see hub.sam.sdl.SdlAgentType#getGate()
	 * @see #getSdlAgentType()
	 * @generated
	 */
	EReference getSdlAgentType_Gate();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlAssignment <em>Sdl Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Assignment</em>'.
	 * @see hub.sam.sdl.SdlAssignment
	 * @generated
	 */
	EClass getSdlAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlAssignment#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see hub.sam.sdl.SdlAssignment#getExpression()
	 * @see #getSdlAssignment()
	 * @generated
	 */
	EReference getSdlAssignment_Expression();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see hub.sam.sdl.SdlAssignment#getVariable()
	 * @see #getSdlAssignment()
	 * @generated
	 */
	EReference getSdlAssignment_Variable();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlBehavior <em>Sdl Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Behavior</em>'.
	 * @see hub.sam.sdl.SdlBehavior
	 * @generated
	 */
	EClass getSdlBehavior();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlBehaviorElement <em>Sdl Behavior Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Behavior Element</em>'.
	 * @see hub.sam.sdl.SdlBehaviorElement
	 * @generated
	 */
	EClass getSdlBehaviorElement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlBehaviorElement#getSdlBehaviorElement_behavior <em>Sdl Behavior Element behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sdl Behavior Element behavior</em>'.
	 * @see hub.sam.sdl.SdlBehaviorElement#getSdlBehaviorElement_behavior()
	 * @see #getSdlBehaviorElement()
	 * @generated
	 */
	EReference getSdlBehaviorElement_SdlBehaviorElement_behavior();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlChannel <em>Sdl Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Channel</em>'.
	 * @see hub.sam.sdl.SdlChannel
	 * @generated
	 */
	EClass getSdlChannel();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlChannel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see hub.sam.sdl.SdlChannel#getPath()
	 * @see #getSdlChannel()
	 * @generated
	 */
	EReference getSdlChannel_Path();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlChannel#getAgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Agent Type</em>'.
	 * @see hub.sam.sdl.SdlChannel#getAgentType()
	 * @see #getSdlChannel()
	 * @generated
	 */
	EReference getSdlChannel_AgentType();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlChannelEnd <em>Sdl Channel End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Channel End</em>'.
	 * @see hub.sam.sdl.SdlChannelEnd
	 * @generated
	 */
	EClass getSdlChannelEnd();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlChannelEnd#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Agent</em>'.
	 * @see hub.sam.sdl.SdlChannelEnd#getAgent()
	 * @see #getSdlChannelEnd()
	 * @generated
	 */
	EReference getSdlChannelEnd_Agent();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlChannelEnd#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gate</em>'.
	 * @see hub.sam.sdl.SdlChannelEnd#getGate()
	 * @see #getSdlChannelEnd()
	 * @generated
	 */
	EReference getSdlChannelEnd_Gate();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlChannelEnd#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see hub.sam.sdl.SdlChannelEnd#getOpposite()
	 * @see #getSdlChannelEnd()
	 * @generated
	 */
	EReference getSdlChannelEnd_Opposite();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlChannelEnd#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Channel</em>'.
	 * @see hub.sam.sdl.SdlChannelEnd#getChannel()
	 * @see #getSdlChannelEnd()
	 * @generated
	 */
	EReference getSdlChannelEnd_Channel();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlChannelPath <em>Sdl Channel Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Channel Path</em>'.
	 * @see hub.sam.sdl.SdlChannelPath
	 * @generated
	 */
	EClass getSdlChannelPath();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlChannelPath#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see hub.sam.sdl.SdlChannelPath#getSource()
	 * @see #getSdlChannelPath()
	 * @generated
	 */
	EReference getSdlChannelPath_Source();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlChannelPath#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see hub.sam.sdl.SdlChannelPath#getTarget()
	 * @see #getSdlChannelPath()
	 * @generated
	 */
	EReference getSdlChannelPath_Target();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlChannelPath#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signal</em>'.
	 * @see hub.sam.sdl.SdlChannelPath#getSignal()
	 * @see #getSdlChannelPath()
	 * @generated
	 */
	EReference getSdlChannelPath_Signal();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlChannelPath#getRelatedElement <em>Related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Related Element</em>'.
	 * @see hub.sam.sdl.SdlChannelPath#getRelatedElement()
	 * @see #getSdlChannelPath()
	 * @generated
	 */
	EReference getSdlChannelPath_RelatedElement();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlChannelPath#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Channel</em>'.
	 * @see hub.sam.sdl.SdlChannelPath#getChannel()
	 * @see #getSdlChannelPath()
	 * @generated
	 */
	EReference getSdlChannelPath_Channel();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlChoice <em>Sdl Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Choice</em>'.
	 * @see hub.sam.sdl.SdlChoice
	 * @generated
	 */
	EClass getSdlChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlChoice#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see hub.sam.sdl.SdlChoice#getCondition()
	 * @see #getSdlChoice()
	 * @generated
	 */
	EReference getSdlChoice_Condition();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlClassifier <em>Sdl Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Classifier</em>'.
	 * @see hub.sam.sdl.SdlClassifier
	 * @generated
	 */
	EClass getSdlClassifier();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlClassifier#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see hub.sam.sdl.SdlClassifier#getVariable()
	 * @see #getSdlClassifier()
	 * @generated
	 */
	EReference getSdlClassifier_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlClassifier#getProcedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedure</em>'.
	 * @see hub.sam.sdl.SdlClassifier#getProcedure()
	 * @see #getSdlClassifier()
	 * @generated
	 */
	EReference getSdlClassifier_Procedure();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlClosedRange <em>Sdl Closed Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Closed Range</em>'.
	 * @see hub.sam.sdl.SdlClosedRange
	 * @generated
	 */
	EClass getSdlClosedRange();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlClosedRange#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper</em>'.
	 * @see hub.sam.sdl.SdlClosedRange#getUpper()
	 * @see #getSdlClosedRange()
	 * @generated
	 */
	EReference getSdlClosedRange_Upper();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlClosedRange#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower</em>'.
	 * @see hub.sam.sdl.SdlClosedRange#getLower()
	 * @see #getSdlClosedRange()
	 * @generated
	 */
	EReference getSdlClosedRange_Lower();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlCompositeState <em>Sdl Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Composite State</em>'.
	 * @see hub.sam.sdl.SdlCompositeState
	 * @generated
	 */
	EClass getSdlCompositeState();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlCompositeState#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.SdlCompositeState#getType()
	 * @see #getSdlCompositeState()
	 * @generated
	 */
	EReference getSdlCompositeState_Type();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlCompositeStateInstance <em>Sdl Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Composite State Instance</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance
	 * @generated
	 */
	EClass getSdlCompositeStateInstance();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlCompositeStateInstance#getActualState <em>Actual State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual State</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getActualState()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_ActualState();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlCompositeStateInstance#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getState()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_State();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlCompositeStateInstance#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getInput()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_Input();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_OwningInstance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlCompositeStateInstance#getTriggered <em>Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Triggered</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getTriggered()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_Triggered();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlCompositeStateInstance#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getSender()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EReference getSdlCompositeStateInstance_Sender();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlCompositeStateInstance#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getStatus()
	 * @see #getSdlCompositeStateInstance()
	 * @generated
	 */
	EAttribute getSdlCompositeStateInstance_Status();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlCreate <em>Sdl Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Create</em>'.
	 * @see hub.sam.sdl.SdlCreate
	 * @generated
	 */
	EClass getSdlCreate();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlCreate#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Agent</em>'.
	 * @see hub.sam.sdl.SdlCreate#getAgent()
	 * @see #getSdlCreate()
	 * @generated
	 */
	EReference getSdlCreate_Agent();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlCreate#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see hub.sam.sdl.SdlCreate#getClassifier()
	 * @see #getSdlCreate()
	 * @generated
	 */
	EReference getSdlCreate_Classifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlDataType <em>Sdl Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Data Type</em>'.
	 * @see hub.sam.sdl.SdlDataType
	 * @generated
	 */
	EClass getSdlDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlDataType#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see hub.sam.sdl.SdlDataType#getLiteral()
	 * @see #getSdlDataType()
	 * @generated
	 */
	EReference getSdlDataType_Literal();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlDataType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see hub.sam.sdl.SdlDataType#getOperation()
	 * @see #getSdlDataType()
	 * @generated
	 */
	EReference getSdlDataType_Operation();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlDataValue <em>Sdl Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Data Value</em>'.
	 * @see hub.sam.sdl.SdlDataValue
	 * @generated
	 */
	EClass getSdlDataValue();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlElse <em>Sdl Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Else</em>'.
	 * @see hub.sam.sdl.SdlElse
	 * @generated
	 */
	EClass getSdlElse();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlEvaluation <em>Sdl Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Evaluation</em>'.
	 * @see hub.sam.sdl.SdlEvaluation
	 * @generated
	 */
	EClass getSdlEvaluation();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlEvaluation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see hub.sam.sdl.SdlEvaluation#getContext()
	 * @see #getSdlEvaluation()
	 * @generated
	 */
	EReference getSdlEvaluation_Context();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlGate <em>Sdl Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Gate</em>'.
	 * @see hub.sam.sdl.SdlGate
	 * @generated
	 */
	EClass getSdlGate();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlGate#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receive</em>'.
	 * @see hub.sam.sdl.SdlGate#getReceive()
	 * @see #getSdlGate()
	 * @generated
	 */
	EReference getSdlGate_Receive();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlGate#getSend <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Send</em>'.
	 * @see hub.sam.sdl.SdlGate#getSend()
	 * @see #getSdlGate()
	 * @generated
	 */
	EReference getSdlGate_Send();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlGate#getChannelEnd <em>Channel End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Channel End</em>'.
	 * @see hub.sam.sdl.SdlGate#getChannelEnd()
	 * @see #getSdlGate()
	 * @generated
	 */
	EReference getSdlGate_ChannelEnd();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlGate#getAgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Agent Type</em>'.
	 * @see hub.sam.sdl.SdlGate#getAgentType()
	 * @see #getSdlGate()
	 * @generated
	 */
	EReference getSdlGate_AgentType();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlGeneralValue <em>Sdl General Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl General Value</em>'.
	 * @see hub.sam.sdl.SdlGeneralValue
	 * @generated
	 */
	EClass getSdlGeneralValue();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlGeneralValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlGeneralValue#getValue()
	 * @see #getSdlGeneralValue()
	 * @generated
	 */
	EAttribute getSdlGeneralValue_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlImidiate <em>Sdl Imidiate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Imidiate</em>'.
	 * @see hub.sam.sdl.SdlImidiate
	 * @generated
	 */
	EClass getSdlImidiate();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlInput <em>Sdl Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Input</em>'.
	 * @see hub.sam.sdl.SdlInput
	 * @generated
	 */
	EClass getSdlInput();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlInput#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlInput#getParameter()
	 * @see #getSdlInput()
	 * @generated
	 */
	EReference getSdlInput_Parameter();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlInput#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see hub.sam.sdl.SdlInput#getSignal()
	 * @see #getSdlInput()
	 * @generated
	 */
	EReference getSdlInput_Signal();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlInputInstance <em>Sdl Input Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Input Instance</em>'.
	 * @see hub.sam.sdl.SdlInputInstance
	 * @generated
	 */
	EClass getSdlInputInstance();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.sdl.SdlInputInstance#getOwningStateInstance <em>Owning State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State Instance</em>'.
	 * @see hub.sam.sdl.SdlInputInstance#getOwningStateInstance()
	 * @see #getSdlInputInstance()
	 * @generated
	 */
	EReference getSdlInputInstance_OwningStateInstance();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlInstance <em>Sdl Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Instance</em>'.
	 * @see hub.sam.sdl.SdlInstance
	 * @generated
	 */
	EClass getSdlInstance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlInstance#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see hub.sam.sdl.SdlInstance#getVariable()
	 * @see #getSdlInstance()
	 * @generated
	 */
	EReference getSdlInstance_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlInstance#getContainingInstance <em>Containing Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Containing Instance</em>'.
	 * @see hub.sam.sdl.SdlInstance#getContainingInstance()
	 * @see #getSdlInstance()
	 * @generated
	 */
	EReference getSdlInstance_ContainingInstance();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlLiteral <em>Sdl Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Literal</em>'.
	 * @see hub.sam.sdl.SdlLiteral
	 * @generated
	 */
	EClass getSdlLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlLiteralEvaluation <em>Sdl Literal Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Literal Evaluation</em>'.
	 * @see hub.sam.sdl.SdlLiteralEvaluation
	 * @generated
	 */
	EClass getSdlLiteralEvaluation();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlLiteralEvaluation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlLiteralEvaluation#getValue()
	 * @see #getSdlLiteralEvaluation()
	 * @generated
	 */
	EReference getSdlLiteralEvaluation_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlLiteralExpression <em>Sdl Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Literal Expression</em>'.
	 * @see hub.sam.sdl.SdlLiteralExpression
	 * @generated
	 */
	EClass getSdlLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlLiteralExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlLiteralExpression#getValue()
	 * @see #getSdlLiteralExpression()
	 * @generated
	 */
	EAttribute getSdlLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlNamedState <em>Sdl Named State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Named State</em>'.
	 * @see hub.sam.sdl.SdlNamedState
	 * @generated
	 */
	EClass getSdlNamedState();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlNamespace <em>Sdl Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Namespace</em>'.
	 * @see hub.sam.sdl.SdlNamespace
	 * @generated
	 */
	EClass getSdlNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlNamespace#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see hub.sam.sdl.SdlNamespace#getOwnedType()
	 * @see #getSdlNamespace()
	 * @generated
	 */
	EReference getSdlNamespace_OwnedType();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlNowExpression <em>Sdl Now Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Now Expression</em>'.
	 * @see hub.sam.sdl.SdlNowExpression
	 * @generated
	 */
	EClass getSdlNowExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlOpenRange <em>Sdl Open Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Open Range</em>'.
	 * @see hub.sam.sdl.SdlOpenRange
	 * @generated
	 */
	EClass getSdlOpenRange();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOpenRange#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see hub.sam.sdl.SdlOpenRange#getOperation()
	 * @see #getSdlOpenRange()
	 * @generated
	 */
	EReference getSdlOpenRange_Operation();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlOpenRange#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see hub.sam.sdl.SdlOpenRange#getExpression()
	 * @see #getSdlOpenRange()
	 * @generated
	 */
	EReference getSdlOpenRange_Expression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlOperation <em>Sdl Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Operation</em>'.
	 * @see hub.sam.sdl.SdlOperation
	 * @generated
	 */
	EClass getSdlOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlOperation#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlOperation#getParameter()
	 * @see #getSdlOperation()
	 * @generated
	 */
	EReference getSdlOperation_Parameter();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlOperationCall <em>Sdl Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Operation Call</em>'.
	 * @see hub.sam.sdl.SdlOperationCall
	 * @generated
	 */
	EClass getSdlOperationCall();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOperationCall#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see hub.sam.sdl.SdlOperationCall#getFeature()
	 * @see #getSdlOperationCall()
	 * @generated
	 */
	EReference getSdlOperationCall_Feature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlOperationEvaluation <em>Sdl Operation Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Operation Evaluation</em>'.
	 * @see hub.sam.sdl.SdlOperationEvaluation
	 * @generated
	 */
	EClass getSdlOperationEvaluation();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOperationEvaluation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlOperationEvaluation#getValue()
	 * @see #getSdlOperationEvaluation()
	 * @generated
	 */
	EReference getSdlOperationEvaluation_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlOutput <em>Sdl Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Output</em>'.
	 * @see hub.sam.sdl.SdlOutput
	 * @generated
	 */
	EClass getSdlOutput();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOutput#getSdlOutput_classifier <em>Sdl Output classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sdl Output classifier</em>'.
	 * @see hub.sam.sdl.SdlOutput#getSdlOutput_classifier()
	 * @see #getSdlOutput()
	 * @generated
	 */
	EReference getSdlOutput_SdlOutput_classifier();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOutput#getVia <em>Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Via</em>'.
	 * @see hub.sam.sdl.SdlOutput#getVia()
	 * @see #getSdlOutput()
	 * @generated
	 */
	EReference getSdlOutput_Via();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlOutput#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.SdlOutput#getType()
	 * @see #getSdlOutput()
	 * @generated
	 */
	EReference getSdlOutput_Type();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlOutput#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To</em>'.
	 * @see hub.sam.sdl.SdlOutput#getTo()
	 * @see #getSdlOutput()
	 * @generated
	 */
	EReference getSdlOutput_To();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlPackage <em>Sdl Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Package</em>'.
	 * @see hub.sam.sdl.SdlPackage
	 * @generated
	 */
	EClass getSdlPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlPackage#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Package</em>'.
	 * @see hub.sam.sdl.SdlPackage#getNestedPackage()
	 * @see #getSdlPackage()
	 * @generated
	 */
	EReference getSdlPackage_NestedPackage();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlParameter <em>Sdl Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Parameter</em>'.
	 * @see hub.sam.sdl.SdlParameter
	 * @generated
	 */
	EClass getSdlParameter();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlParameter#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hub.sam.sdl.SdlParameter#getKind()
	 * @see #getSdlParameter()
	 * @generated
	 */
	EAttribute getSdlParameter_Kind();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlPidExpression <em>Sdl Pid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Pid Expression</em>'.
	 * @see hub.sam.sdl.SdlPidExpression
	 * @generated
	 */
	EClass getSdlPidExpression();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.sdl.SdlPidExpression#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hub.sam.sdl.SdlPidExpression#getKind()
	 * @see #getSdlPidExpression()
	 * @generated
	 */
	EAttribute getSdlPidExpression_Kind();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlPidExpressionEvaluation <em>Sdl Pid Expression Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Pid Expression Evaluation</em>'.
	 * @see hub.sam.sdl.SdlPidExpressionEvaluation
	 * @generated
	 */
	EClass getSdlPidExpressionEvaluation();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlPrimitiveValue <em>Sdl Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Primitive Value</em>'.
	 * @see hub.sam.sdl.SdlPrimitiveValue
	 * @generated
	 */
	EClass getSdlPrimitiveValue();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlProcedure <em>Sdl Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Procedure</em>'.
	 * @see hub.sam.sdl.SdlProcedure
	 * @generated
	 */
	EClass getSdlProcedure();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlProcedure#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlProcedure#getParameter()
	 * @see #getSdlProcedure()
	 * @generated
	 */
	EReference getSdlProcedure_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlProcedure#getProcedureStateAutomaton <em>Procedure State Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Procedure State Automaton</em>'.
	 * @see hub.sam.sdl.SdlProcedure#getProcedureStateAutomaton()
	 * @see #getSdlProcedure()
	 * @generated
	 */
	EReference getSdlProcedure_ProcedureStateAutomaton();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlProcedureCall <em>Sdl Procedure Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Procedure Call</em>'.
	 * @see hub.sam.sdl.SdlProcedureCall
	 * @generated
	 */
	EClass getSdlProcedureCall();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlProcedureCall#getProcedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Procedure</em>'.
	 * @see hub.sam.sdl.SdlProcedureCall#getProcedure()
	 * @see #getSdlProcedureCall()
	 * @generated
	 */
	EReference getSdlProcedureCall_Procedure();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlProcedureFrame <em>Sdl Procedure Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Procedure Frame</em>'.
	 * @see hub.sam.sdl.SdlProcedureFrame
	 * @generated
	 */
	EClass getSdlProcedureFrame();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlPseudoState <em>Sdl Pseudo State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Pseudo State</em>'.
	 * @see hub.sam.sdl.SdlPseudoState
	 * @generated
	 */
	EClass getSdlPseudoState();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlRange <em>Sdl Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Range</em>'.
	 * @see hub.sam.sdl.SdlRange
	 * @generated
	 */
	EClass getSdlRange();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlRangeCondition <em>Sdl Range Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Range Condition</em>'.
	 * @see hub.sam.sdl.SdlRangeCondition
	 * @generated
	 */
	EClass getSdlRangeCondition();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlReset <em>Sdl Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Reset</em>'.
	 * @see hub.sam.sdl.SdlReset
	 * @generated
	 */
	EClass getSdlReset();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlSet <em>Sdl Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Set</em>'.
	 * @see hub.sam.sdl.SdlSet
	 * @generated
	 */
	EClass getSdlSet();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlSet#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see hub.sam.sdl.SdlSet#getClassifier()
	 * @see #getSdlSet()
	 * @generated
	 */
	EReference getSdlSet_Classifier();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlSet#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see hub.sam.sdl.SdlSet#getExpression()
	 * @see #getSdlSet()
	 * @generated
	 */
	EReference getSdlSet_Expression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlSignal <em>Sdl Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Signal</em>'.
	 * @see hub.sam.sdl.SdlSignal
	 * @generated
	 */
	EClass getSdlSignal();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlSignal#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlSignal#getParameter()
	 * @see #getSdlSignal()
	 * @generated
	 */
	EReference getSdlSignal_Parameter();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlSignalInstance <em>Sdl Signal Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Signal Instance</em>'.
	 * @see hub.sam.sdl.SdlSignalInstance
	 * @generated
	 */
	EClass getSdlSignalInstance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlSignalInstance#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see hub.sam.sdl.SdlSignalInstance#getParameter()
	 * @see #getSdlSignalInstance()
	 * @generated
	 */
	EReference getSdlSignalInstance_Parameter();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlSignalInstance#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see hub.sam.sdl.SdlSignalInstance#getSender()
	 * @see #getSdlSignalInstance()
	 * @generated
	 */
	EReference getSdlSignalInstance_Sender();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlSignalInstance#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see hub.sam.sdl.SdlSignalInstance#getReceiver()
	 * @see #getSdlSignalInstance()
	 * @generated
	 */
	EReference getSdlSignalInstance_Receiver();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlSplit <em>Sdl Split</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Split</em>'.
	 * @see hub.sam.sdl.SdlSplit
	 * @generated
	 */
	EClass getSdlSplit();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlSplit#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Question</em>'.
	 * @see hub.sam.sdl.SdlSplit#getQuestion()
	 * @see #getSdlSplit()
	 * @generated
	 */
	EReference getSdlSplit_Question();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlSplit#getAnswer <em>Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Answer</em>'.
	 * @see hub.sam.sdl.SdlSplit#getAnswer()
	 * @see #getSdlSplit()
	 * @generated
	 */
	EReference getSdlSplit_Answer();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlState <em>Sdl State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State</em>'.
	 * @see hub.sam.sdl.SdlState
	 * @generated
	 */
	EClass getSdlState();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlState#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry</em>'.
	 * @see hub.sam.sdl.SdlState#getEntry()
	 * @see #getSdlState()
	 * @generated
	 */
	EReference getSdlState_Entry();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlState#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exit</em>'.
	 * @see hub.sam.sdl.SdlState#getExit()
	 * @see #getSdlState()
	 * @generated
	 */
	EReference getSdlState_Exit();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStateAutomaton <em>Sdl State Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Automaton</em>'.
	 * @see hub.sam.sdl.SdlStateAutomaton
	 * @generated
	 */
	EClass getSdlStateAutomaton();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlStateAutomaton#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see hub.sam.sdl.SdlStateAutomaton#getState()
	 * @see #getSdlStateAutomaton()
	 * @generated
	 */
	EReference getSdlStateAutomaton_State();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlStateAutomaton#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition</em>'.
	 * @see hub.sam.sdl.SdlStateAutomaton#getTransition()
	 * @see #getSdlStateAutomaton()
	 * @generated
	 */
	EReference getSdlStateAutomaton_Transition();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlStateAutomaton#getNamedState <em>Named State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Named State</em>'.
	 * @see hub.sam.sdl.SdlStateAutomaton#getNamedState()
	 * @see #getSdlStateAutomaton()
	 * @generated
	 */
	EReference getSdlStateAutomaton_NamedState();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlStateAutomaton#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see hub.sam.sdl.SdlStateAutomaton#getStart()
	 * @see #getSdlStateAutomaton()
	 * @generated
	 */
	EReference getSdlStateAutomaton_Start();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStateInstance <em>Sdl State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Instance</em>'.
	 * @see hub.sam.sdl.SdlStateInstance
	 * @generated
	 */
	EClass getSdlStateInstance();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlStateInstance#getSdlStateInstance_actualState <em>Sdl State Instance actual State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sdl State Instance actual State</em>'.
	 * @see hub.sam.sdl.SdlStateInstance#getSdlStateInstance_actualState()
	 * @see #getSdlStateInstance()
	 * @generated
	 */
	EReference getSdlStateInstance_SdlStateInstance_actualState();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStateNode <em>Sdl State Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Node</em>'.
	 * @see hub.sam.sdl.SdlStateNode
	 * @generated
	 */
	EClass getSdlStateNode();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlStateNode#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>State</em>'.
	 * @see hub.sam.sdl.SdlStateNode#getState()
	 * @see #getSdlStateNode()
	 * @generated
	 */
	EReference getSdlStateNode_State();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStatePartition <em>Sdl State Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Partition</em>'.
	 * @see hub.sam.sdl.SdlStatePartition
	 * @generated
	 */
	EClass getSdlStatePartition();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlStatePartition#getPartition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partition</em>'.
	 * @see hub.sam.sdl.SdlStatePartition#getPartition()
	 * @see #getSdlStatePartition()
	 * @generated
	 */
	EReference getSdlStatePartition_Partition();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStatePartitionInstance <em>Sdl State Partition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Partition Instance</em>'.
	 * @see hub.sam.sdl.SdlStatePartitionInstance
	 * @generated
	 */
	EClass getSdlStatePartitionInstance();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.sdl.SdlStatePartitionInstance#getActualState <em>Actual State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actual State</em>'.
	 * @see hub.sam.sdl.SdlStatePartitionInstance#getActualState()
	 * @see #getSdlStatePartitionInstance()
	 * @generated
	 */
	EReference getSdlStatePartitionInstance_ActualState();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlStateType <em>Sdl State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl State Type</em>'.
	 * @see hub.sam.sdl.SdlStateType
	 * @generated
	 */
	EClass getSdlStateType();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlStateType#getStateAutomaton <em>State Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Automaton</em>'.
	 * @see hub.sam.sdl.SdlStateType#getStateAutomaton()
	 * @see #getSdlStateType()
	 * @generated
	 */
	EReference getSdlStateType_StateAutomaton();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlStateType#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see hub.sam.sdl.SdlStateType#getState()
	 * @see #getSdlStateType()
	 * @generated
	 */
	EReference getSdlStateType_State();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlTimer <em>Sdl Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Timer</em>'.
	 * @see hub.sam.sdl.SdlTimer
	 * @generated
	 */
	EClass getSdlTimer();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlTimerActiveExpression <em>Sdl Timer Active Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Timer Active Expression</em>'.
	 * @see hub.sam.sdl.SdlTimerActiveExpression
	 * @generated
	 */
	EClass getSdlTimerActiveExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlTransition <em>Sdl Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Transition</em>'.
	 * @see hub.sam.sdl.SdlTransition
	 * @generated
	 */
	EClass getSdlTransition();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlTransition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see hub.sam.sdl.SdlTransition#getAction()
	 * @see #getSdlTransition()
	 * @generated
	 */
	EReference getSdlTransition_Action();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see hub.sam.sdl.SdlTransition#getSource()
	 * @see #getSdlTransition()
	 * @generated
	 */
	EReference getSdlTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see hub.sam.sdl.SdlTransition#getTarget()
	 * @see #getSdlTransition()
	 * @generated
	 */
	EReference getSdlTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlTransition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see hub.sam.sdl.SdlTransition#getTrigger()
	 * @see #getSdlTransition()
	 * @generated
	 */
	EReference getSdlTransition_Trigger();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlTrigger <em>Sdl Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Trigger</em>'.
	 * @see hub.sam.sdl.SdlTrigger
	 * @generated
	 */
	EClass getSdlTrigger();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlTrigger#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transition</em>'.
	 * @see hub.sam.sdl.SdlTrigger#getTransition()
	 * @see #getSdlTrigger()
	 * @generated
	 */
	EReference getSdlTrigger_Transition();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlVariable <em>Sdl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Variable</em>'.
	 * @see hub.sam.sdl.SdlVariable
	 * @generated
	 */
	EClass getSdlVariable();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.sdl.SdlVariable#getType()
	 * @see #getSdlVariable()
	 * @generated
	 */
	EReference getSdlVariable_Type();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlVariable#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see hub.sam.sdl.SdlVariable#getInitExpression()
	 * @see #getSdlVariable()
	 * @generated
	 */
	EReference getSdlVariable_InitExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlVariableAccess <em>Sdl Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Variable Access</em>'.
	 * @see hub.sam.sdl.SdlVariableAccess
	 * @generated
	 */
	EClass getSdlVariableAccess();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlVariableAccess#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see hub.sam.sdl.SdlVariableAccess#getFeature()
	 * @see #getSdlVariableAccess()
	 * @generated
	 */
	EReference getSdlVariableAccess_Feature();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlVariableAccessEvaluation <em>Sdl Variable Access Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Variable Access Evaluation</em>'.
	 * @see hub.sam.sdl.SdlVariableAccessEvaluation
	 * @generated
	 */
	EClass getSdlVariableAccessEvaluation();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.sdl.SdlVariableAccessEvaluation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlVariableAccessEvaluation#getValue()
	 * @see #getSdlVariableAccessEvaluation()
	 * @generated
	 */
	EReference getSdlVariableAccessEvaluation_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlVariableSlot <em>Sdl Variable Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Variable Slot</em>'.
	 * @see hub.sam.sdl.SdlVariableSlot
	 * @generated
	 */
	EClass getSdlVariableSlot();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlVariableSlot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see hub.sam.sdl.SdlVariableSlot#getValue()
	 * @see #getSdlVariableSlot()
	 * @generated
	 */
	EReference getSdlVariableSlot_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see hub.sam.sdl.Start
	 * @generated
	 */
	EClass getStart();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.Stop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop</em>'.
	 * @see hub.sam.sdl.Stop
	 * @generated
	 */
	EClass getStop();

	/**
	 * Returns the meta object for class '{@link hub.sam.sdl.SdlSpecification <em>Sdl Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sdl Specification</em>'.
	 * @see hub.sam.sdl.SdlSpecification
	 * @generated
	 */
	EClass getSdlSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.sdl.SdlSpecification#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see hub.sam.sdl.SdlSpecification#getPackages()
	 * @see #getSdlSpecification()
	 * @generated
	 */
	EReference getSdlSpecification_Packages();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.sdl.SdlSpecification#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see hub.sam.sdl.SdlSpecification#getSystem()
	 * @see #getSdlSpecification()
	 * @generated
	 */
	EReference getSdlSpecification_System();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind <em>Concrete Syntax Sdl Scope Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Concrete Syntax Sdl Scope Unit Kind</em>'.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind
	 * @generated
	 */
	EEnum getConcreteSyntaxSdlScopeUnitKind();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind <em>Core Abstractions Visibilities Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Core Abstractions Visibilities Visibility Kind</em>'.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesVisibilityKind
	 * @generated
	 */
	EEnum getCoreAbstractionsVisibilitiesVisibilityKind();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.SdlAgentKind <em>Sdl Agent Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sdl Agent Kind</em>'.
	 * @see hub.sam.sdl.SdlAgentKind
	 * @generated
	 */
	EEnum getSdlAgentKind();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.SdlParameterKind <em>Sdl Parameter Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sdl Parameter Kind</em>'.
	 * @see hub.sam.sdl.SdlParameterKind
	 * @generated
	 */
	EEnum getSdlParameterKind();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.SdlPidExpressionKind <em>Sdl Pid Expression Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sdl Pid Expression Kind</em>'.
	 * @see hub.sam.sdl.SdlPidExpressionKind
	 * @generated
	 */
	EEnum getSdlPidExpressionKind();

	/**
	 * Returns the meta object for enum '{@link hub.sam.sdl.SdlStateStatus <em>Sdl State Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sdl State Status</em>'.
	 * @see hub.sam.sdl.SdlStateStatus
	 * @generated
	 */
	EEnum getSdlStateStatus();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Primitive Types Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Primitive Types Boolean</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPrimitiveTypesBoolean();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Primitive Types Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Primitive Types Integer</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPrimitiveTypesInteger();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Primitive Types Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Primitive Types Object</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPrimitiveTypesObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Primitive Types String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Primitive Types String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPrimitiveTypesString();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Primitive Types Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Primitive Types Unlimited Natural</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPrimitiveTypesUnlimitedNatural();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmfSdlFactory getEmfSdlFactory();

} //EmfSdlPackage
