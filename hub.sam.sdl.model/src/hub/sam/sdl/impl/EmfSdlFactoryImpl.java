/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfSdlFactoryImpl extends EFactoryImpl implements EmfSdlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmfSdlFactory init() {
		try {
			EmfSdlFactory theEmfSdlFactory = (EmfSdlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.hub.sam.generated.de/SDL"); 
			if (theEmfSdlFactory != null) {
				return theEmfSdlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmfSdlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfSdlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmfSdlPackage.COMMUNICATION_EVENT: return createCommunicationEvent();
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_IDENTIFIER: return createConcreteSyntaxSdlIdentifier();
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_PATH_ITEM: return createConcreteSyntaxSdlPathItem();
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER: return createConcreteSyntaxSdlQualifier();
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_STATE_LIST: return createConcreteSyntaxSdlStateList();
			case EmfSdlPackage.CONNECTOR: return createConnector();
			case EmfSdlPackage.CORE_ABSTRACTIONS_COMMENTS_COMMENT: return createCoreAbstractionsCommentsComment();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT: return createCoreAbstractionsConstraintsConstraint();
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION: return createCoreAbstractionsExpressionsExpression();
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION: return createCoreAbstractionsExpressionsOpaqueExpression();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION: return createCoreAbstractionsGeneralizationsGeneralization();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION: return createCoreAbstractionsInstancesInstanceSpecification();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE: return createCoreAbstractionsInstancesInstanceValue();
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT: return createCoreAbstractionsInstancesSlot();
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN: return createCoreAbstractionsLiteralsLiteralBoolean();
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER: return createCoreAbstractionsLiteralsLiteralInteger();
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL: return createCoreAbstractionsLiteralsLiteralNull();
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING: return createCoreAbstractionsLiteralsLiteralString();
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL: return createCoreAbstractionsLiteralsLiteralUnlimitedNatural();
			case EmfSdlPackage.EVALUATION_EVALUATION: return createEvaluationEvaluation();
			case EmfSdlPackage.FORK: return createFork();
			case EmfSdlPackage.HISTORY: return createHistory();
			case EmfSdlPackage.JOIN: return createJoin();
			case EmfSdlPackage.PID_VALUE: return createPidValue();
			case EmfSdlPackage.RETURN: return createReturn();
			case EmfSdlPackage.SDL_AGENT: return createSdlAgent();
			case EmfSdlPackage.SDL_AGENT_INSTANCE: return createSdlAgentInstance();
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET: return createSdlAgentInstanceSet();
			case EmfSdlPackage.SDL_AGENT_TYPE: return createSdlAgentType();
			case EmfSdlPackage.SDL_ASSIGNMENT: return createSdlAssignment();
			case EmfSdlPackage.SDL_BEHAVIOR: return createSdlBehavior();
			case EmfSdlPackage.SDL_CHANNEL: return createSdlChannel();
			case EmfSdlPackage.SDL_CHANNEL_END: return createSdlChannelEnd();
			case EmfSdlPackage.SDL_CHANNEL_PATH: return createSdlChannelPath();
			case EmfSdlPackage.SDL_CHOICE: return createSdlChoice();
			case EmfSdlPackage.SDL_CLOSED_RANGE: return createSdlClosedRange();
			case EmfSdlPackage.SDL_COMPOSITE_STATE: return createSdlCompositeState();
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE: return createSdlCompositeStateInstance();
			case EmfSdlPackage.SDL_CREATE: return createSdlCreate();
			case EmfSdlPackage.SDL_DATA_TYPE: return createSdlDataType();
			case EmfSdlPackage.SDL_ELSE: return createSdlElse();
			case EmfSdlPackage.SDL_GATE: return createSdlGate();
			case EmfSdlPackage.SDL_GENERAL_VALUE: return createSdlGeneralValue();
			case EmfSdlPackage.SDL_IMIDIATE: return createSdlImidiate();
			case EmfSdlPackage.SDL_INPUT: return createSdlInput();
			case EmfSdlPackage.SDL_INPUT_INSTANCE: return createSdlInputInstance();
			case EmfSdlPackage.SDL_LITERAL: return createSdlLiteral();
			case EmfSdlPackage.SDL_LITERAL_EVALUATION: return createSdlLiteralEvaluation();
			case EmfSdlPackage.SDL_LITERAL_EXPRESSION: return createSdlLiteralExpression();
			case EmfSdlPackage.SDL_NOW_EXPRESSION: return createSdlNowExpression();
			case EmfSdlPackage.SDL_OPEN_RANGE: return createSdlOpenRange();
			case EmfSdlPackage.SDL_OPERATION: return createSdlOperation();
			case EmfSdlPackage.SDL_OPERATION_CALL: return createSdlOperationCall();
			case EmfSdlPackage.SDL_OPERATION_EVALUATION: return createSdlOperationEvaluation();
			case EmfSdlPackage.SDL_OUTPUT: return createSdlOutput();
			case EmfSdlPackage.SDL_PACKAGE: return createSdlPackage();
			case EmfSdlPackage.SDL_PARAMETER: return createSdlParameter();
			case EmfSdlPackage.SDL_PID_EXPRESSION: return createSdlPidExpression();
			case EmfSdlPackage.SDL_PID_EXPRESSION_EVALUATION: return createSdlPidExpressionEvaluation();
			case EmfSdlPackage.SDL_PROCEDURE: return createSdlProcedure();
			case EmfSdlPackage.SDL_PROCEDURE_CALL: return createSdlProcedureCall();
			case EmfSdlPackage.SDL_PROCEDURE_FRAME: return createSdlProcedureFrame();
			case EmfSdlPackage.SDL_RANGE: return createSdlRange();
			case EmfSdlPackage.SDL_RANGE_CONDITION: return createSdlRangeCondition();
			case EmfSdlPackage.SDL_RESET: return createSdlReset();
			case EmfSdlPackage.SDL_SET: return createSdlSet();
			case EmfSdlPackage.SDL_SIGNAL: return createSdlSignal();
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE: return createSdlSignalInstance();
			case EmfSdlPackage.SDL_SPECIFICATION: return createSdlSpecification();
			case EmfSdlPackage.SDL_SPLIT: return createSdlSplit();
			case EmfSdlPackage.SDL_STATE: return createSdlState();
			case EmfSdlPackage.SDL_STATE_AUTOMATON: return createSdlStateAutomaton();
			case EmfSdlPackage.SDL_STATE_INSTANCE: return createSdlStateInstance();
			case EmfSdlPackage.SDL_STATE_NODE: return createSdlStateNode();
			case EmfSdlPackage.SDL_STATE_PARTITION: return createSdlStatePartition();
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE: return createSdlStatePartitionInstance();
			case EmfSdlPackage.SDL_STATE_TYPE: return createSdlStateType();
			case EmfSdlPackage.SDL_TIMER: return createSdlTimer();
			case EmfSdlPackage.SDL_TIMER_ACTIVE_EXPRESSION: return createSdlTimerActiveExpression();
			case EmfSdlPackage.SDL_TRANSITION: return createSdlTransition();
			case EmfSdlPackage.SDL_TRIGGER: return createSdlTrigger();
			case EmfSdlPackage.SDL_VARIABLE: return createSdlVariable();
			case EmfSdlPackage.SDL_VARIABLE_ACCESS: return createSdlVariableAccess();
			case EmfSdlPackage.SDL_VARIABLE_ACCESS_EVALUATION: return createSdlVariableAccessEvaluation();
			case EmfSdlPackage.SDL_VARIABLE_SLOT: return createSdlVariableSlot();
			case EmfSdlPackage.START: return createStart();
			case EmfSdlPackage.STOP: return createStop();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_SCOPE_UNIT_KIND:
				return createConcreteSyntaxSdlScopeUnitKindFromString(eDataType, initialValue);
			case EmfSdlPackage.CORE_ABSTRACTIONS_VISIBILITIES_VISIBILITY_KIND:
				return createCoreAbstractionsVisibilitiesVisibilityKindFromString(eDataType, initialValue);
			case EmfSdlPackage.SDL_AGENT_KIND:
				return createSdlAgentKindFromString(eDataType, initialValue);
			case EmfSdlPackage.SDL_PARAMETER_KIND:
				return createSdlParameterKindFromString(eDataType, initialValue);
			case EmfSdlPackage.SDL_PID_EXPRESSION_KIND:
				return createSdlPidExpressionKindFromString(eDataType, initialValue);
			case EmfSdlPackage.SDL_STATE_STATUS:
				return createSdlStateStatusFromString(eDataType, initialValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_BOOLEAN:
				return createPrimitiveTypesBooleanFromString(eDataType, initialValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_INTEGER:
				return createPrimitiveTypesIntegerFromString(eDataType, initialValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_OBJECT:
				return createPrimitiveTypesObjectFromString(eDataType, initialValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_STRING:
				return createPrimitiveTypesStringFromString(eDataType, initialValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_UNLIMITED_NATURAL:
				return createPrimitiveTypesUnlimitedNaturalFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_SCOPE_UNIT_KIND:
				return convertConcreteSyntaxSdlScopeUnitKindToString(eDataType, instanceValue);
			case EmfSdlPackage.CORE_ABSTRACTIONS_VISIBILITIES_VISIBILITY_KIND:
				return convertCoreAbstractionsVisibilitiesVisibilityKindToString(eDataType, instanceValue);
			case EmfSdlPackage.SDL_AGENT_KIND:
				return convertSdlAgentKindToString(eDataType, instanceValue);
			case EmfSdlPackage.SDL_PARAMETER_KIND:
				return convertSdlParameterKindToString(eDataType, instanceValue);
			case EmfSdlPackage.SDL_PID_EXPRESSION_KIND:
				return convertSdlPidExpressionKindToString(eDataType, instanceValue);
			case EmfSdlPackage.SDL_STATE_STATUS:
				return convertSdlStateStatusToString(eDataType, instanceValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_BOOLEAN:
				return convertPrimitiveTypesBooleanToString(eDataType, instanceValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_INTEGER:
				return convertPrimitiveTypesIntegerToString(eDataType, instanceValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_OBJECT:
				return convertPrimitiveTypesObjectToString(eDataType, instanceValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_STRING:
				return convertPrimitiveTypesStringToString(eDataType, instanceValue);
			case EmfSdlPackage.PRIMITIVE_TYPES_UNLIMITED_NATURAL:
				return convertPrimitiveTypesUnlimitedNaturalToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationEvent createCommunicationEvent() {
		CommunicationEventImpl communicationEvent = new CommunicationEventImpl();
		return communicationEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlIdentifier createConcreteSyntaxSdlIdentifier() {
		ConcreteSyntaxSdlIdentifierImpl concreteSyntaxSdlIdentifier = new ConcreteSyntaxSdlIdentifierImpl();
		return concreteSyntaxSdlIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlPathItem createConcreteSyntaxSdlPathItem() {
		ConcreteSyntaxSdlPathItemImpl concreteSyntaxSdlPathItem = new ConcreteSyntaxSdlPathItemImpl();
		return concreteSyntaxSdlPathItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlQualifier createConcreteSyntaxSdlQualifier() {
		ConcreteSyntaxSdlQualifierImpl concreteSyntaxSdlQualifier = new ConcreteSyntaxSdlQualifierImpl();
		return concreteSyntaxSdlQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlStateList createConcreteSyntaxSdlStateList() {
		ConcreteSyntaxSdlStateListImpl concreteSyntaxSdlStateList = new ConcreteSyntaxSdlStateListImpl();
		return concreteSyntaxSdlStateList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsCommentsComment createCoreAbstractionsCommentsComment() {
		CoreAbstractionsCommentsCommentImpl coreAbstractionsCommentsComment = new CoreAbstractionsCommentsCommentImpl();
		return coreAbstractionsCommentsComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsConstraintsConstraint createCoreAbstractionsConstraintsConstraint() {
		CoreAbstractionsConstraintsConstraintImpl coreAbstractionsConstraintsConstraint = new CoreAbstractionsConstraintsConstraintImpl();
		return coreAbstractionsConstraintsConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsExpression createCoreAbstractionsExpressionsExpression() {
		CoreAbstractionsExpressionsExpressionImpl coreAbstractionsExpressionsExpression = new CoreAbstractionsExpressionsExpressionImpl();
		return coreAbstractionsExpressionsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsOpaqueExpression createCoreAbstractionsExpressionsOpaqueExpression() {
		CoreAbstractionsExpressionsOpaqueExpressionImpl coreAbstractionsExpressionsOpaqueExpression = new CoreAbstractionsExpressionsOpaqueExpressionImpl();
		return coreAbstractionsExpressionsOpaqueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsGeneralizationsGeneralization createCoreAbstractionsGeneralizationsGeneralization() {
		CoreAbstractionsGeneralizationsGeneralizationImpl coreAbstractionsGeneralizationsGeneralization = new CoreAbstractionsGeneralizationsGeneralizationImpl();
		return coreAbstractionsGeneralizationsGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsInstancesInstanceSpecification createCoreAbstractionsInstancesInstanceSpecification() {
		CoreAbstractionsInstancesInstanceSpecificationImpl coreAbstractionsInstancesInstanceSpecification = new CoreAbstractionsInstancesInstanceSpecificationImpl();
		return coreAbstractionsInstancesInstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsInstancesInstanceValue createCoreAbstractionsInstancesInstanceValue() {
		CoreAbstractionsInstancesInstanceValueImpl coreAbstractionsInstancesInstanceValue = new CoreAbstractionsInstancesInstanceValueImpl();
		return coreAbstractionsInstancesInstanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsInstancesSlot createCoreAbstractionsInstancesSlot() {
		CoreAbstractionsInstancesSlotImpl coreAbstractionsInstancesSlot = new CoreAbstractionsInstancesSlotImpl();
		return coreAbstractionsInstancesSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsLiteralsLiteralBoolean createCoreAbstractionsLiteralsLiteralBoolean() {
		CoreAbstractionsLiteralsLiteralBooleanImpl coreAbstractionsLiteralsLiteralBoolean = new CoreAbstractionsLiteralsLiteralBooleanImpl();
		return coreAbstractionsLiteralsLiteralBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsLiteralsLiteralInteger createCoreAbstractionsLiteralsLiteralInteger() {
		CoreAbstractionsLiteralsLiteralIntegerImpl coreAbstractionsLiteralsLiteralInteger = new CoreAbstractionsLiteralsLiteralIntegerImpl();
		return coreAbstractionsLiteralsLiteralInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsLiteralsLiteralNull createCoreAbstractionsLiteralsLiteralNull() {
		CoreAbstractionsLiteralsLiteralNullImpl coreAbstractionsLiteralsLiteralNull = new CoreAbstractionsLiteralsLiteralNullImpl();
		return coreAbstractionsLiteralsLiteralNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsLiteralsLiteralString createCoreAbstractionsLiteralsLiteralString() {
		CoreAbstractionsLiteralsLiteralStringImpl coreAbstractionsLiteralsLiteralString = new CoreAbstractionsLiteralsLiteralStringImpl();
		return coreAbstractionsLiteralsLiteralString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsLiteralsLiteralUnlimitedNatural createCoreAbstractionsLiteralsLiteralUnlimitedNatural() {
		CoreAbstractionsLiteralsLiteralUnlimitedNaturalImpl coreAbstractionsLiteralsLiteralUnlimitedNatural = new CoreAbstractionsLiteralsLiteralUnlimitedNaturalImpl();
		return coreAbstractionsLiteralsLiteralUnlimitedNatural;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationEvaluation createEvaluationEvaluation() {
		EvaluationEvaluationImpl evaluationEvaluation = new EvaluationEvaluationImpl();
		return evaluationEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fork createFork() {
		ForkImpl fork = new ForkImpl();
		return fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public History createHistory() {
		HistoryImpl history = new HistoryImpl();
		return history;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Join createJoin() {
		JoinImpl join = new JoinImpl();
		return join;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PidValue createPidValue() {
		PidValueImpl pidValue = new PidValueImpl();
		return pidValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgent createSdlAgent() {
		SdlAgentImpl sdlAgent = new SdlAgentImpl();
		return sdlAgent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstance createSdlAgentInstance() {
		SdlAgentInstanceImpl sdlAgentInstance = new SdlAgentInstanceImpl();
		return sdlAgentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentInstanceSet createSdlAgentInstanceSet() {
		SdlAgentInstanceSetImpl sdlAgentInstanceSet = new SdlAgentInstanceSetImpl();
		return sdlAgentInstanceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentType createSdlAgentType() {
		SdlAgentTypeImpl sdlAgentType = new SdlAgentTypeImpl();
		return sdlAgentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAssignment createSdlAssignment() {
		SdlAssignmentImpl sdlAssignment = new SdlAssignmentImpl();
		return sdlAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlBehavior createSdlBehavior() {
		SdlBehaviorImpl sdlBehavior = new SdlBehaviorImpl();
		return sdlBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannel createSdlChannel() {
		SdlChannelImpl sdlChannel = new SdlChannelImpl();
		return sdlChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelEnd createSdlChannelEnd() {
		SdlChannelEndImpl sdlChannelEnd = new SdlChannelEndImpl();
		return sdlChannelEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChannelPath createSdlChannelPath() {
		SdlChannelPathImpl sdlChannelPath = new SdlChannelPathImpl();
		return sdlChannelPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlChoice createSdlChoice() {
		SdlChoiceImpl sdlChoice = new SdlChoiceImpl();
		return sdlChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlClosedRange createSdlClosedRange() {
		SdlClosedRangeImpl sdlClosedRange = new SdlClosedRangeImpl();
		return sdlClosedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCompositeState createSdlCompositeState() {
		SdlCompositeStateImpl sdlCompositeState = new SdlCompositeStateImpl();
		return sdlCompositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCompositeStateInstance createSdlCompositeStateInstance() {
		SdlCompositeStateInstanceImpl sdlCompositeStateInstance = new SdlCompositeStateInstanceImpl();
		return sdlCompositeStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlCreate createSdlCreate() {
		SdlCreateImpl sdlCreate = new SdlCreateImpl();
		return sdlCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlDataType createSdlDataType() {
		SdlDataTypeImpl sdlDataType = new SdlDataTypeImpl();
		return sdlDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlElse createSdlElse() {
		SdlElseImpl sdlElse = new SdlElseImpl();
		return sdlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGate createSdlGate() {
		SdlGateImpl sdlGate = new SdlGateImpl();
		return sdlGate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlGeneralValue createSdlGeneralValue() {
		SdlGeneralValueImpl sdlGeneralValue = new SdlGeneralValueImpl();
		return sdlGeneralValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlImidiate createSdlImidiate() {
		SdlImidiateImpl sdlImidiate = new SdlImidiateImpl();
		return sdlImidiate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlInput createSdlInput() {
		SdlInputImpl sdlInput = new SdlInputImpl();
		return sdlInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlInputInstance createSdlInputInstance() {
		SdlInputInstanceImpl sdlInputInstance = new SdlInputInstanceImpl();
		return sdlInputInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlLiteral createSdlLiteral() {
		SdlLiteralImpl sdlLiteral = new SdlLiteralImpl();
		return sdlLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlLiteralEvaluation createSdlLiteralEvaluation() {
		SdlLiteralEvaluationImpl sdlLiteralEvaluation = new SdlLiteralEvaluationImpl();
		return sdlLiteralEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlLiteralExpression createSdlLiteralExpression() {
		SdlLiteralExpressionImpl sdlLiteralExpression = new SdlLiteralExpressionImpl();
		return sdlLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlNowExpression createSdlNowExpression() {
		SdlNowExpressionImpl sdlNowExpression = new SdlNowExpressionImpl();
		return sdlNowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlOpenRange createSdlOpenRange() {
		SdlOpenRangeImpl sdlOpenRange = new SdlOpenRangeImpl();
		return sdlOpenRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlOperation createSdlOperation() {
		SdlOperationImpl sdlOperation = new SdlOperationImpl();
		return sdlOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlOperationCall createSdlOperationCall() {
		SdlOperationCallImpl sdlOperationCall = new SdlOperationCallImpl();
		return sdlOperationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlOperationEvaluation createSdlOperationEvaluation() {
		SdlOperationEvaluationImpl sdlOperationEvaluation = new SdlOperationEvaluationImpl();
		return sdlOperationEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlOutput createSdlOutput() {
		SdlOutputImpl sdlOutput = new SdlOutputImpl();
		return sdlOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlPackage createSdlPackage() {
		SdlPackageImpl sdlPackage = new SdlPackageImpl();
		return sdlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlParameter createSdlParameter() {
		SdlParameterImpl sdlParameter = new SdlParameterImpl();
		return sdlParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlPidExpression createSdlPidExpression() {
		SdlPidExpressionImpl sdlPidExpression = new SdlPidExpressionImpl();
		return sdlPidExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlPidExpressionEvaluation createSdlPidExpressionEvaluation() {
		SdlPidExpressionEvaluationImpl sdlPidExpressionEvaluation = new SdlPidExpressionEvaluationImpl();
		return sdlPidExpressionEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlProcedure createSdlProcedure() {
		SdlProcedureImpl sdlProcedure = new SdlProcedureImpl();
		return sdlProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlProcedureCall createSdlProcedureCall() {
		SdlProcedureCallImpl sdlProcedureCall = new SdlProcedureCallImpl();
		return sdlProcedureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlProcedureFrame createSdlProcedureFrame() {
		SdlProcedureFrameImpl sdlProcedureFrame = new SdlProcedureFrameImpl();
		return sdlProcedureFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlRange createSdlRange() {
		SdlRangeImpl sdlRange = new SdlRangeImpl();
		return sdlRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlRangeCondition createSdlRangeCondition() {
		SdlRangeConditionImpl sdlRangeCondition = new SdlRangeConditionImpl();
		return sdlRangeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlReset createSdlReset() {
		SdlResetImpl sdlReset = new SdlResetImpl();
		return sdlReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSet createSdlSet() {
		SdlSetImpl sdlSet = new SdlSetImpl();
		return sdlSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSignal createSdlSignal() {
		SdlSignalImpl sdlSignal = new SdlSignalImpl();
		return sdlSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSignalInstance createSdlSignalInstance() {
		SdlSignalInstanceImpl sdlSignalInstance = new SdlSignalInstanceImpl();
		return sdlSignalInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSplit createSdlSplit() {
		SdlSplitImpl sdlSplit = new SdlSplitImpl();
		return sdlSplit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlState createSdlState() {
		SdlStateImpl sdlState = new SdlStateImpl();
		return sdlState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateAutomaton createSdlStateAutomaton() {
		SdlStateAutomatonImpl sdlStateAutomaton = new SdlStateAutomatonImpl();
		return sdlStateAutomaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateInstance createSdlStateInstance() {
		SdlStateInstanceImpl sdlStateInstance = new SdlStateInstanceImpl();
		return sdlStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateNode createSdlStateNode() {
		SdlStateNodeImpl sdlStateNode = new SdlStateNodeImpl();
		return sdlStateNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStatePartition createSdlStatePartition() {
		SdlStatePartitionImpl sdlStatePartition = new SdlStatePartitionImpl();
		return sdlStatePartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStatePartitionInstance createSdlStatePartitionInstance() {
		SdlStatePartitionInstanceImpl sdlStatePartitionInstance = new SdlStatePartitionInstanceImpl();
		return sdlStatePartitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateType createSdlStateType() {
		SdlStateTypeImpl sdlStateType = new SdlStateTypeImpl();
		return sdlStateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlTimer createSdlTimer() {
		SdlTimerImpl sdlTimer = new SdlTimerImpl();
		return sdlTimer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlTimerActiveExpression createSdlTimerActiveExpression() {
		SdlTimerActiveExpressionImpl sdlTimerActiveExpression = new SdlTimerActiveExpressionImpl();
		return sdlTimerActiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlTransition createSdlTransition() {
		SdlTransitionImpl sdlTransition = new SdlTransitionImpl();
		return sdlTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlTrigger createSdlTrigger() {
		SdlTriggerImpl sdlTrigger = new SdlTriggerImpl();
		return sdlTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariable createSdlVariable() {
		SdlVariableImpl sdlVariable = new SdlVariableImpl();
		return sdlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableAccess createSdlVariableAccess() {
		SdlVariableAccessImpl sdlVariableAccess = new SdlVariableAccessImpl();
		return sdlVariableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableAccessEvaluation createSdlVariableAccessEvaluation() {
		SdlVariableAccessEvaluationImpl sdlVariableAccessEvaluation = new SdlVariableAccessEvaluationImpl();
		return sdlVariableAccessEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlVariableSlot createSdlVariableSlot() {
		SdlVariableSlotImpl sdlVariableSlot = new SdlVariableSlotImpl();
		return sdlVariableSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Start createStart() {
		StartImpl start = new StartImpl();
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stop createStop() {
		StopImpl stop = new StopImpl();
		return stop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlSpecification createSdlSpecification() {
		SdlSpecificationImpl sdlSpecification = new SdlSpecificationImpl();
		return sdlSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlScopeUnitKind createConcreteSyntaxSdlScopeUnitKindFromString(EDataType eDataType, String initialValue) {
		ConcreteSyntaxSdlScopeUnitKind result = ConcreteSyntaxSdlScopeUnitKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConcreteSyntaxSdlScopeUnitKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsVisibilitiesVisibilityKind createCoreAbstractionsVisibilitiesVisibilityKindFromString(EDataType eDataType, String initialValue) {
		CoreAbstractionsVisibilitiesVisibilityKind result = CoreAbstractionsVisibilitiesVisibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoreAbstractionsVisibilitiesVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlAgentKind createSdlAgentKindFromString(EDataType eDataType, String initialValue) {
		SdlAgentKind result = SdlAgentKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSdlAgentKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlParameterKind createSdlParameterKindFromString(EDataType eDataType, String initialValue) {
		SdlParameterKind result = SdlParameterKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSdlParameterKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlPidExpressionKind createSdlPidExpressionKindFromString(EDataType eDataType, String initialValue) {
		SdlPidExpressionKind result = SdlPidExpressionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSdlPidExpressionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateStatus createSdlStateStatusFromString(EDataType eDataType, String initialValue) {
		SdlStateStatus result = SdlStateStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSdlStateStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPrimitiveTypesBooleanFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypesBooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPrimitiveTypesIntegerFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypesIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPrimitiveTypesObjectFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypesObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPrimitiveTypesStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypesStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createPrimitiveTypesUnlimitedNaturalFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypesUnlimitedNaturalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfSdlPackage getEmfSdlPackage() {
		return (EmfSdlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmfSdlPackage getPackage() {
		return EmfSdlPackage.eINSTANCE;
	}

} //EmfSdlFactoryImpl
