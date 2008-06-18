/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.util;

import hub.sam.sdl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.sdl.EmfSdlPackage
 * @generated
 */
public class EmfSdlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmfSdlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfSdlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EmfSdlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmfSdlSwitch<Adapter> modelSwitch =
		new EmfSdlSwitch<Adapter>() {
			@Override
			public Adapter caseSdlCreate(SdlCreate object) {
				return createSdlCreateAdapter();
			}
			@Override
			public Adapter caseSdlAssignment(SdlAssignment object) {
				return createSdlAssignmentAdapter();
			}
			@Override
			public Adapter caseSdlReset(SdlReset object) {
				return createSdlResetAdapter();
			}
			@Override
			public Adapter caseSdlOutput(SdlOutput object) {
				return createSdlOutputAdapter();
			}
			@Override
			public Adapter caseSdlSignalInstance(SdlSignalInstance object) {
				return createSdlSignalInstanceAdapter();
			}
			@Override
			public Adapter caseSdlSet(SdlSet object) {
				return createSdlSetAdapter();
			}
			@Override
			public Adapter caseSdlAgentInstance(SdlAgentInstance object) {
				return createSdlAgentInstanceAdapter();
			}
			@Override
			public Adapter caseSdlDataValue(SdlDataValue object) {
				return createSdlDataValueAdapter();
			}
			@Override
			public Adapter caseSdlAgent(SdlAgent object) {
				return createSdlAgentAdapter();
			}
			@Override
			public Adapter caseSdlProcedure(SdlProcedure object) {
				return createSdlProcedureAdapter();
			}
			@Override
			public Adapter caseSdlAgentInstanceSet(SdlAgentInstanceSet object) {
				return createSdlAgentInstanceSetAdapter();
			}
			@Override
			public Adapter caseSdlVariable(SdlVariable object) {
				return createSdlVariableAdapter();
			}
			@Override
			public Adapter caseSdlAgentType(SdlAgentType object) {
				return createSdlAgentTypeAdapter();
			}
			@Override
			public Adapter caseSdlDataType(SdlDataType object) {
				return createSdlDataTypeAdapter();
			}
			@Override
			public Adapter caseSdlVariableSlot(SdlVariableSlot object) {
				return createSdlVariableSlotAdapter();
			}
			@Override
			public Adapter caseSdlChannel(SdlChannel object) {
				return createSdlChannelAdapter();
			}
			@Override
			public Adapter caseSdlChannelEnd(SdlChannelEnd object) {
				return createSdlChannelEndAdapter();
			}
			@Override
			public Adapter caseSdlChannelPath(SdlChannelPath object) {
				return createSdlChannelPathAdapter();
			}
			@Override
			public Adapter caseSdlGate(SdlGate object) {
				return createSdlGateAdapter();
			}
			@Override
			public Adapter caseSdlSignal(SdlSignal object) {
				return createSdlSignalAdapter();
			}
			@Override
			public Adapter caseSdlTimer(SdlTimer object) {
				return createSdlTimerAdapter();
			}
			@Override
			public Adapter caseSdlTrigger(SdlTrigger object) {
				return createSdlTriggerAdapter();
			}
			@Override
			public Adapter caseSdlInputInstance(SdlInputInstance object) {
				return createSdlInputInstanceAdapter();
			}
			@Override
			public Adapter caseSdlVariableAccessEvaluation(SdlVariableAccessEvaluation object) {
				return createSdlVariableAccessEvaluationAdapter();
			}
			@Override
			public Adapter caseSdlVariableAccess(SdlVariableAccess object) {
				return createSdlVariableAccessAdapter();
			}
			@Override
			public Adapter caseSdlProcedureFrame(SdlProcedureFrame object) {
				return createSdlProcedureFrameAdapter();
			}
			@Override
			public Adapter caseSdlOpenRange(SdlOpenRange object) {
				return createSdlOpenRangeAdapter();
			}
			@Override
			public Adapter caseSdlTimerActiveExpression(SdlTimerActiveExpression object) {
				return createSdlTimerActiveExpressionAdapter();
			}
			@Override
			public Adapter caseSdlOperation(SdlOperation object) {
				return createSdlOperationAdapter();
			}
			@Override
			public Adapter caseSdlRange(SdlRange object) {
				return createSdlRangeAdapter();
			}
			@Override
			public Adapter caseSdlProcedureCall(SdlProcedureCall object) {
				return createSdlProcedureCallAdapter();
			}
			@Override
			public Adapter caseSdlLiteralExpression(SdlLiteralExpression object) {
				return createSdlLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseSdlNowExpression(SdlNowExpression object) {
				return createSdlNowExpressionAdapter();
			}
			@Override
			public Adapter caseSdlPidExpression(SdlPidExpression object) {
				return createSdlPidExpressionAdapter();
			}
			@Override
			public Adapter caseSdlRangeCondition(SdlRangeCondition object) {
				return createSdlRangeConditionAdapter();
			}
			@Override
			public Adapter caseSdlOperationCall(SdlOperationCall object) {
				return createSdlOperationCallAdapter();
			}
			@Override
			public Adapter caseSdlLiteral(SdlLiteral object) {
				return createSdlLiteralAdapter();
			}
			@Override
			public Adapter caseSdlClosedRange(SdlClosedRange object) {
				return createSdlClosedRangeAdapter();
			}
			@Override
			public Adapter caseSdlParameter(SdlParameter object) {
				return createSdlParameterAdapter();
			}
			@Override
			public Adapter caseSdlPackage(SdlPackage object) {
				return createSdlPackageAdapter();
			}
			@Override
			public Adapter caseConnector(Connector object) {
				return createConnectorAdapter();
			}
			@Override
			public Adapter caseJoin(Join object) {
				return createJoinAdapter();
			}
			@Override
			public Adapter caseHistory(History object) {
				return createHistoryAdapter();
			}
			@Override
			public Adapter caseReturn(Return object) {
				return createReturnAdapter();
			}
			@Override
			public Adapter caseFork(Fork object) {
				return createForkAdapter();
			}
			@Override
			public Adapter caseSdlBehaviorElement(SdlBehaviorElement object) {
				return createSdlBehaviorElementAdapter();
			}
			@Override
			public Adapter caseSdlAbstractState(SdlAbstractState object) {
				return createSdlAbstractStateAdapter();
			}
			@Override
			public Adapter caseSdlAction(SdlAction object) {
				return createSdlActionAdapter();
			}
			@Override
			public Adapter caseSdlChoice(SdlChoice object) {
				return createSdlChoiceAdapter();
			}
			@Override
			public Adapter caseSdlBehavior(SdlBehavior object) {
				return createSdlBehaviorAdapter();
			}
			@Override
			public Adapter caseSdlCompositeState(SdlCompositeState object) {
				return createSdlCompositeStateAdapter();
			}
			@Override
			public Adapter caseSdlElse(SdlElse object) {
				return createSdlElseAdapter();
			}
			@Override
			public Adapter caseSdlCompositeStateInstance(SdlCompositeStateInstance object) {
				return createSdlCompositeStateInstanceAdapter();
			}
			@Override
			public Adapter caseSdlPseudoState(SdlPseudoState object) {
				return createSdlPseudoStateAdapter();
			}
			@Override
			public Adapter caseSdlInput(SdlInput object) {
				return createSdlInputAdapter();
			}
			@Override
			public Adapter caseSdlImidiate(SdlImidiate object) {
				return createSdlImidiateAdapter();
			}
			@Override
			public Adapter caseSdlStateInstance(SdlStateInstance object) {
				return createSdlStateInstanceAdapter();
			}
			@Override
			public Adapter caseSdlStateNode(SdlStateNode object) {
				return createSdlStateNodeAdapter();
			}
			@Override
			public Adapter caseSdlStatePartitionInstance(SdlStatePartitionInstance object) {
				return createSdlStatePartitionInstanceAdapter();
			}
			@Override
			public Adapter caseSdlStateAutomaton(SdlStateAutomaton object) {
				return createSdlStateAutomatonAdapter();
			}
			@Override
			public Adapter caseSdlState(SdlState object) {
				return createSdlStateAdapter();
			}
			@Override
			public Adapter caseSdlStatePartition(SdlStatePartition object) {
				return createSdlStatePartitionAdapter();
			}
			@Override
			public Adapter caseSdlTransition(SdlTransition object) {
				return createSdlTransitionAdapter();
			}
			@Override
			public Adapter caseSdlStateType(SdlStateType object) {
				return createSdlStateTypeAdapter();
			}
			@Override
			public Adapter caseSdlSplit(SdlSplit object) {
				return createSdlSplitAdapter();
			}
			@Override
			public Adapter caseStart(Start object) {
				return createStartAdapter();
			}
			@Override
			public Adapter caseStop(Stop object) {
				return createStopAdapter();
			}
			@Override
			public Adapter caseSdlClassifier(SdlClassifier object) {
				return createSdlClassifierAdapter();
			}
			@Override
			public Adapter caseSdlNamespace(SdlNamespace object) {
				return createSdlNamespaceAdapter();
			}
			@Override
			public Adapter caseSdlNamedState(SdlNamedState object) {
				return createSdlNamedStateAdapter();
			}
			@Override
			public Adapter caseSdlInstance(SdlInstance object) {
				return createSdlInstanceAdapter();
			}
			@Override
			public Adapter caseSdlOperationEvaluation(SdlOperationEvaluation object) {
				return createSdlOperationEvaluationAdapter();
			}
			@Override
			public Adapter caseSdlEvaluation(SdlEvaluation object) {
				return createSdlEvaluationAdapter();
			}
			@Override
			public Adapter caseSdlLiteralEvaluation(SdlLiteralEvaluation object) {
				return createSdlLiteralEvaluationAdapter();
			}
			@Override
			public Adapter caseSdlPrimitiveValue(SdlPrimitiveValue object) {
				return createSdlPrimitiveValueAdapter();
			}
			@Override
			public Adapter caseSdlPidExpressionEvaluation(SdlPidExpressionEvaluation object) {
				return createSdlPidExpressionEvaluationAdapter();
			}
			@Override
			public Adapter casePidValue(PidValue object) {
				return createPidValueAdapter();
			}
			@Override
			public Adapter caseSdlGeneralValue(SdlGeneralValue object) {
				return createSdlGeneralValueAdapter();
			}
			@Override
			public Adapter caseConcreteSyntaxSdlQualifier(ConcreteSyntaxSdlQualifier object) {
				return createConcreteSyntaxSdlQualifierAdapter();
			}
			@Override
			public Adapter caseConcreteSyntaxSdlPathItem(ConcreteSyntaxSdlPathItem object) {
				return createConcreteSyntaxSdlPathItemAdapter();
			}
			@Override
			public Adapter caseConcreteSyntaxSdlIdentifier(ConcreteSyntaxSdlIdentifier object) {
				return createConcreteSyntaxSdlIdentifierAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsTypedElementsType(CoreAbstractionsTypedElementsType object) {
				return createCoreAbstractionsTypedElementsTypeAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsTypedElementsTypedElement(CoreAbstractionsTypedElementsTypedElement object) {
				return createCoreAbstractionsTypedElementsTypedElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsBehavioralFeaturesParameter(CoreAbstractionsBehavioralFeaturesParameter object) {
				return createCoreAbstractionsBehavioralFeaturesParameterAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(CoreAbstractionsBehavioralFeaturesBehavioralFeature object) {
				return createCoreAbstractionsBehavioralFeaturesBehavioralFeatureAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsStructuralFeaturesStructuralFeature(CoreAbstractionsStructuralFeaturesStructuralFeature object) {
				return createCoreAbstractionsStructuralFeaturesStructuralFeatureAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsCommentsComment(CoreAbstractionsCommentsComment object) {
				return createCoreAbstractionsCommentsCommentAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsOwnershipsElement(CoreAbstractionsOwnershipsElement object) {
				return createCoreAbstractionsOwnershipsElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsInstancesInstanceSpecification(CoreAbstractionsInstancesInstanceSpecification object) {
				return createCoreAbstractionsInstancesInstanceSpecificationAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsInstancesInstanceValue(CoreAbstractionsInstancesInstanceValue object) {
				return createCoreAbstractionsInstancesInstanceValueAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsInstancesSlot(CoreAbstractionsInstancesSlot object) {
				return createCoreAbstractionsInstancesSlotAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsElementsElement(CoreAbstractionsElementsElement object) {
				return createCoreAbstractionsElementsElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsVisibilitiesNamedElement(CoreAbstractionsVisibilitiesNamedElement object) {
				return createCoreAbstractionsVisibilitiesNamedElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsConstraintsNamedElement(CoreAbstractionsConstraintsNamedElement object) {
				return createCoreAbstractionsConstraintsNamedElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsConstraintsNamespace(CoreAbstractionsConstraintsNamespace object) {
				return createCoreAbstractionsConstraintsNamespaceAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsConstraintsConstraint(CoreAbstractionsConstraintsConstraint object) {
				return createCoreAbstractionsConstraintsConstraintAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsNamespacesNamedElement(CoreAbstractionsNamespacesNamedElement object) {
				return createCoreAbstractionsNamespacesNamedElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsNamespacesNamespace(CoreAbstractionsNamespacesNamespace object) {
				return createCoreAbstractionsNamespacesNamespaceAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsSuperClassifier(CoreAbstractionsSuperClassifier object) {
				return createCoreAbstractionsSuperClassifierAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsClassifiersFeature(CoreAbstractionsClassifiersFeature object) {
				return createCoreAbstractionsClassifiersFeatureAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsClassifiersClassifier(CoreAbstractionsClassifiersClassifier object) {
				return createCoreAbstractionsClassifiersClassifierAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsExpressionsExpression(CoreAbstractionsExpressionsExpression object) {
				return createCoreAbstractionsExpressionsExpressionAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsExpressionsValueSpecification(CoreAbstractionsExpressionsValueSpecification object) {
				return createCoreAbstractionsExpressionsValueSpecificationAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsExpressionsOpaqueExpression(CoreAbstractionsExpressionsOpaqueExpression object) {
				return createCoreAbstractionsExpressionsOpaqueExpressionAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsMultiplicityExpressionsMultiplicityElement(CoreAbstractionsMultiplicityExpressionsMultiplicityElement object) {
				return createCoreAbstractionsMultiplicityExpressionsMultiplicityElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralInteger(CoreAbstractionsLiteralsLiteralInteger object) {
				return createCoreAbstractionsLiteralsLiteralIntegerAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralString(CoreAbstractionsLiteralsLiteralString object) {
				return createCoreAbstractionsLiteralsLiteralStringAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralBoolean(CoreAbstractionsLiteralsLiteralBoolean object) {
				return createCoreAbstractionsLiteralsLiteralBooleanAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralNull(CoreAbstractionsLiteralsLiteralNull object) {
				return createCoreAbstractionsLiteralsLiteralNullAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralSpecification(CoreAbstractionsLiteralsLiteralSpecification object) {
				return createCoreAbstractionsLiteralsLiteralSpecificationAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsLiteralsLiteralUnlimitedNatural(CoreAbstractionsLiteralsLiteralUnlimitedNatural object) {
				return createCoreAbstractionsLiteralsLiteralUnlimitedNaturalAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsRedefinitionsRedefinableElement(CoreAbstractionsRedefinitionsRedefinableElement object) {
				return createCoreAbstractionsRedefinitionsRedefinableElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsChangeabilitiesStructuralFeature(CoreAbstractionsChangeabilitiesStructuralFeature object) {
				return createCoreAbstractionsChangeabilitiesStructuralFeatureAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsMultiplicitiesMultiplicityElement(CoreAbstractionsMultiplicitiesMultiplicityElement object) {
				return createCoreAbstractionsMultiplicitiesMultiplicityElementAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsGeneralizationsGeneralization(CoreAbstractionsGeneralizationsGeneralization object) {
				return createCoreAbstractionsGeneralizationsGeneralizationAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsGeneralizationsClassifier(CoreAbstractionsGeneralizationsClassifier object) {
				return createCoreAbstractionsGeneralizationsClassifierAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsRelationshipsRelationship(CoreAbstractionsRelationshipsRelationship object) {
				return createCoreAbstractionsRelationshipsRelationshipAdapter();
			}
			@Override
			public Adapter caseCoreAbstractionsRelationshipsDirectedRelationship(CoreAbstractionsRelationshipsDirectedRelationship object) {
				return createCoreAbstractionsRelationshipsDirectedRelationshipAdapter();
			}
			@Override
			public Adapter caseInstanciationInstance(InstanciationInstance object) {
				return createInstanciationInstanceAdapter();
			}
			@Override
			public Adapter caseInstanciationSlot(InstanciationSlot object) {
				return createInstanciationSlotAdapter();
			}
			@Override
			public Adapter caseInstanciationValue(InstanciationValue object) {
				return createInstanciationValueAdapter();
			}
			@Override
			public Adapter caseInstanciationCreate(InstanciationCreate object) {
				return createInstanciationCreateAdapter();
			}
			@Override
			public Adapter caseInstanciationMultiplicityFeature(InstanciationMultiplicityFeature object) {
				return createInstanciationMultiplicityFeatureAdapter();
			}
			@Override
			public Adapter caseEvaluationDataType(EvaluationDataType object) {
				return createEvaluationDataTypeAdapter();
			}
			@Override
			public Adapter caseEvaluationExpression(EvaluationExpression object) {
				return createEvaluationExpressionAdapter();
			}
			@Override
			public Adapter caseEvaluationLiteralExpression(EvaluationLiteralExpression object) {
				return createEvaluationLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseEvaluationFeatureAccessExpression(EvaluationFeatureAccessExpression object) {
				return createEvaluationFeatureAccessExpressionAdapter();
			}
			@Override
			public Adapter caseEvaluationLiteral(EvaluationLiteral object) {
				return createEvaluationLiteralAdapter();
			}
			@Override
			public Adapter caseEvaluationEvaluation(EvaluationEvaluation object) {
				return createEvaluationEvaluationAdapter();
			}
			@Override
			public Adapter caseEvaluationBehavioralFeatureAccessExpression(EvaluationBehavioralFeatureAccessExpression object) {
				return createEvaluationBehavioralFeatureAccessExpressionAdapter();
			}
			@Override
			public Adapter caseEvaluationBehavioralFeatureAccess(EvaluationBehavioralFeatureAccess object) {
				return createEvaluationBehavioralFeatureAccessAdapter();
			}
			@Override
			public Adapter caseCommunicationProcess(CommunicationProcess object) {
				return createCommunicationProcessAdapter();
			}
			@Override
			public Adapter caseCommunicationEventType(CommunicationEventType object) {
				return createCommunicationEventTypeAdapter();
			}
			@Override
			public Adapter caseCommunicationContext(CommunicationContext object) {
				return createCommunicationContextAdapter();
			}
			@Override
			public Adapter caseCommunicationListener(CommunicationListener object) {
				return createCommunicationListenerAdapter();
			}
			@Override
			public Adapter caseCommunicationEvent(CommunicationEvent object) {
				return createCommunicationEventAdapter();
			}
			@Override
			public Adapter caseCommunicationInput(CommunicationInput object) {
				return createCommunicationInputAdapter();
			}
			@Override
			public Adapter caseCommunicationMedium(CommunicationMedium object) {
				return createCommunicationMediumAdapter();
			}
			@Override
			public Adapter caseCommunicationCommunicator(CommunicationCommunicator object) {
				return createCommunicationCommunicatorAdapter();
			}
			@Override
			public Adapter caseSdlSpecification(SdlSpecification object) {
				return createSdlSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlCreate <em>Sdl Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlCreate
	 * @generated
	 */
	public Adapter createSdlCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAssignment <em>Sdl Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAssignment
	 * @generated
	 */
	public Adapter createSdlAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlReset <em>Sdl Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlReset
	 * @generated
	 */
	public Adapter createSdlResetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlOutput <em>Sdl Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlOutput
	 * @generated
	 */
	public Adapter createSdlOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlSignalInstance <em>Sdl Signal Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlSignalInstance
	 * @generated
	 */
	public Adapter createSdlSignalInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlSet <em>Sdl Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlSet
	 * @generated
	 */
	public Adapter createSdlSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAgentInstance <em>Sdl Agent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAgentInstance
	 * @generated
	 */
	public Adapter createSdlAgentInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlDataValue <em>Sdl Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlDataValue
	 * @generated
	 */
	public Adapter createSdlDataValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAgent <em>Sdl Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAgent
	 * @generated
	 */
	public Adapter createSdlAgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlProcedure <em>Sdl Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlProcedure
	 * @generated
	 */
	public Adapter createSdlProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAgentInstanceSet <em>Sdl Agent Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAgentInstanceSet
	 * @generated
	 */
	public Adapter createSdlAgentInstanceSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlVariable <em>Sdl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlVariable
	 * @generated
	 */
	public Adapter createSdlVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAgentType <em>Sdl Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAgentType
	 * @generated
	 */
	public Adapter createSdlAgentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlDataType <em>Sdl Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlDataType
	 * @generated
	 */
	public Adapter createSdlDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlVariableSlot <em>Sdl Variable Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlVariableSlot
	 * @generated
	 */
	public Adapter createSdlVariableSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlChannel <em>Sdl Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlChannel
	 * @generated
	 */
	public Adapter createSdlChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlChannelEnd <em>Sdl Channel End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlChannelEnd
	 * @generated
	 */
	public Adapter createSdlChannelEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlChannelPath <em>Sdl Channel Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlChannelPath
	 * @generated
	 */
	public Adapter createSdlChannelPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlGate <em>Sdl Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlGate
	 * @generated
	 */
	public Adapter createSdlGateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlSignal <em>Sdl Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlSignal
	 * @generated
	 */
	public Adapter createSdlSignalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlTimer <em>Sdl Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlTimer
	 * @generated
	 */
	public Adapter createSdlTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlTrigger <em>Sdl Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlTrigger
	 * @generated
	 */
	public Adapter createSdlTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlInputInstance <em>Sdl Input Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlInputInstance
	 * @generated
	 */
	public Adapter createSdlInputInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlVariableAccessEvaluation <em>Sdl Variable Access Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlVariableAccessEvaluation
	 * @generated
	 */
	public Adapter createSdlVariableAccessEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlVariableAccess <em>Sdl Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlVariableAccess
	 * @generated
	 */
	public Adapter createSdlVariableAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlProcedureFrame <em>Sdl Procedure Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlProcedureFrame
	 * @generated
	 */
	public Adapter createSdlProcedureFrameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlOpenRange <em>Sdl Open Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlOpenRange
	 * @generated
	 */
	public Adapter createSdlOpenRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlTimerActiveExpression <em>Sdl Timer Active Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlTimerActiveExpression
	 * @generated
	 */
	public Adapter createSdlTimerActiveExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlOperation <em>Sdl Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlOperation
	 * @generated
	 */
	public Adapter createSdlOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlRange <em>Sdl Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlRange
	 * @generated
	 */
	public Adapter createSdlRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlProcedureCall <em>Sdl Procedure Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlProcedureCall
	 * @generated
	 */
	public Adapter createSdlProcedureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlLiteralExpression <em>Sdl Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlLiteralExpression
	 * @generated
	 */
	public Adapter createSdlLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlNowExpression <em>Sdl Now Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlNowExpression
	 * @generated
	 */
	public Adapter createSdlNowExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlPidExpression <em>Sdl Pid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlPidExpression
	 * @generated
	 */
	public Adapter createSdlPidExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlRangeCondition <em>Sdl Range Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlRangeCondition
	 * @generated
	 */
	public Adapter createSdlRangeConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlOperationCall <em>Sdl Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlOperationCall
	 * @generated
	 */
	public Adapter createSdlOperationCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlLiteral <em>Sdl Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlLiteral
	 * @generated
	 */
	public Adapter createSdlLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlClosedRange <em>Sdl Closed Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlClosedRange
	 * @generated
	 */
	public Adapter createSdlClosedRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlParameter <em>Sdl Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlParameter
	 * @generated
	 */
	public Adapter createSdlParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlPackage <em>Sdl Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlPackage
	 * @generated
	 */
	public Adapter createSdlPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Connector
	 * @generated
	 */
	public Adapter createConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Join
	 * @generated
	 */
	public Adapter createJoinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.History
	 * @generated
	 */
	public Adapter createHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Return
	 * @generated
	 */
	public Adapter createReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Fork
	 * @generated
	 */
	public Adapter createForkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlBehaviorElement <em>Sdl Behavior Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlBehaviorElement
	 * @generated
	 */
	public Adapter createSdlBehaviorElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAbstractState <em>Sdl Abstract State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAbstractState
	 * @generated
	 */
	public Adapter createSdlAbstractStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlAction <em>Sdl Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlAction
	 * @generated
	 */
	public Adapter createSdlActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlChoice <em>Sdl Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlChoice
	 * @generated
	 */
	public Adapter createSdlChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlBehavior <em>Sdl Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlBehavior
	 * @generated
	 */
	public Adapter createSdlBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlCompositeState <em>Sdl Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlCompositeState
	 * @generated
	 */
	public Adapter createSdlCompositeStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlElse <em>Sdl Else</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlElse
	 * @generated
	 */
	public Adapter createSdlElseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlCompositeStateInstance <em>Sdl Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlCompositeStateInstance
	 * @generated
	 */
	public Adapter createSdlCompositeStateInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlPseudoState <em>Sdl Pseudo State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlPseudoState
	 * @generated
	 */
	public Adapter createSdlPseudoStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlInput <em>Sdl Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlInput
	 * @generated
	 */
	public Adapter createSdlInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlImidiate <em>Sdl Imidiate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlImidiate
	 * @generated
	 */
	public Adapter createSdlImidiateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStateInstance <em>Sdl State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStateInstance
	 * @generated
	 */
	public Adapter createSdlStateInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStateNode <em>Sdl State Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStateNode
	 * @generated
	 */
	public Adapter createSdlStateNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStatePartitionInstance <em>Sdl State Partition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStatePartitionInstance
	 * @generated
	 */
	public Adapter createSdlStatePartitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStateAutomaton <em>Sdl State Automaton</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStateAutomaton
	 * @generated
	 */
	public Adapter createSdlStateAutomatonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlState <em>Sdl State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlState
	 * @generated
	 */
	public Adapter createSdlStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStatePartition <em>Sdl State Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStatePartition
	 * @generated
	 */
	public Adapter createSdlStatePartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlTransition <em>Sdl Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlTransition
	 * @generated
	 */
	public Adapter createSdlTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlStateType <em>Sdl State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlStateType
	 * @generated
	 */
	public Adapter createSdlStateTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlSplit <em>Sdl Split</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlSplit
	 * @generated
	 */
	public Adapter createSdlSplitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Start
	 * @generated
	 */
	public Adapter createStartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.Stop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.Stop
	 * @generated
	 */
	public Adapter createStopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlClassifier <em>Sdl Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlClassifier
	 * @generated
	 */
	public Adapter createSdlClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlNamespace <em>Sdl Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlNamespace
	 * @generated
	 */
	public Adapter createSdlNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlNamedState <em>Sdl Named State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlNamedState
	 * @generated
	 */
	public Adapter createSdlNamedStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlInstance <em>Sdl Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlInstance
	 * @generated
	 */
	public Adapter createSdlInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlOperationEvaluation <em>Sdl Operation Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlOperationEvaluation
	 * @generated
	 */
	public Adapter createSdlOperationEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlEvaluation <em>Sdl Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlEvaluation
	 * @generated
	 */
	public Adapter createSdlEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlLiteralEvaluation <em>Sdl Literal Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlLiteralEvaluation
	 * @generated
	 */
	public Adapter createSdlLiteralEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlPrimitiveValue <em>Sdl Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlPrimitiveValue
	 * @generated
	 */
	public Adapter createSdlPrimitiveValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlPidExpressionEvaluation <em>Sdl Pid Expression Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlPidExpressionEvaluation
	 * @generated
	 */
	public Adapter createSdlPidExpressionEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.PidValue <em>Pid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.PidValue
	 * @generated
	 */
	public Adapter createPidValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlGeneralValue <em>Sdl General Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlGeneralValue
	 * @generated
	 */
	public Adapter createSdlGeneralValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.ConcreteSyntaxSdlQualifier <em>Concrete Syntax Sdl Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlQualifier
	 * @generated
	 */
	public Adapter createConcreteSyntaxSdlQualifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.ConcreteSyntaxSdlPathItem <em>Concrete Syntax Sdl Path Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlPathItem
	 * @generated
	 */
	public Adapter createConcreteSyntaxSdlPathItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.ConcreteSyntaxSdlIdentifier <em>Concrete Syntax Sdl Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.ConcreteSyntaxSdlIdentifier
	 * @generated
	 */
	public Adapter createConcreteSyntaxSdlIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsTypedElementsType <em>Core Abstractions Typed Elements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsTypedElementsType
	 * @generated
	 */
	public Adapter createCoreAbstractionsTypedElementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement <em>Core Abstractions Typed Elements Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsTypedElementsTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter <em>Core Abstractions Behavioral Features Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter
	 * @generated
	 */
	public Adapter createCoreAbstractionsBehavioralFeaturesParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature <em>Core Abstractions Behavioral Features Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature
	 * @generated
	 */
	public Adapter createCoreAbstractionsBehavioralFeaturesBehavioralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature <em>Core Abstractions Structural Features Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature
	 * @generated
	 */
	public Adapter createCoreAbstractionsStructuralFeaturesStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsCommentsComment <em>Core Abstractions Comments Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsCommentsComment
	 * @generated
	 */
	public Adapter createCoreAbstractionsCommentsCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsOwnershipsElement <em>Core Abstractions Ownerships Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsOwnershipsElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsOwnershipsElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification <em>Core Abstractions Instances Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification
	 * @generated
	 */
	public Adapter createCoreAbstractionsInstancesInstanceSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsInstancesInstanceValue <em>Core Abstractions Instances Instance Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesInstanceValue
	 * @generated
	 */
	public Adapter createCoreAbstractionsInstancesInstanceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsInstancesSlot <em>Core Abstractions Instances Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsInstancesSlot
	 * @generated
	 */
	public Adapter createCoreAbstractionsInstancesSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsElementsElement <em>Core Abstractions Elements Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsElementsElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsElementsElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement <em>Core Abstractions Visibilities Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsVisibilitiesNamedElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsVisibilitiesNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamedElement <em>Core Abstractions Constraints Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamedElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsConstraintsNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace <em>Core Abstractions Constraints Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace
	 * @generated
	 */
	public Adapter createCoreAbstractionsConstraintsNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint <em>Core Abstractions Constraints Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsConstraint
	 * @generated
	 */
	public Adapter createCoreAbstractionsConstraintsConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement <em>Core Abstractions Namespaces Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamedElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsNamespacesNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsNamespacesNamespace <em>Core Abstractions Namespaces Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsNamespacesNamespace
	 * @generated
	 */
	public Adapter createCoreAbstractionsNamespacesNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier <em>Core Abstractions Super Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsSuperClassifier
	 * @generated
	 */
	public Adapter createCoreAbstractionsSuperClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsClassifiersFeature <em>Core Abstractions Classifiers Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersFeature
	 * @generated
	 */
	public Adapter createCoreAbstractionsClassifiersFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsClassifiersClassifier <em>Core Abstractions Classifiers Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsClassifiersClassifier
	 * @generated
	 */
	public Adapter createCoreAbstractionsClassifiersClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression <em>Core Abstractions Expressions Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsExpression
	 * @generated
	 */
	public Adapter createCoreAbstractionsExpressionsExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification <em>Core Abstractions Expressions Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification
	 * @generated
	 */
	public Adapter createCoreAbstractionsExpressionsValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression <em>Core Abstractions Expressions Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsExpressionsOpaqueExpression
	 * @generated
	 */
	public Adapter createCoreAbstractionsExpressionsOpaqueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement <em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsMultiplicityExpressionsMultiplicityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger <em>Core Abstractions Literals Literal Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralInteger
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralIntegerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralString <em>Core Abstractions Literals Literal String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralString
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean <em>Core Abstractions Literals Literal Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralBoolean
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralNull <em>Core Abstractions Literals Literal Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralNull
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralSpecification <em>Core Abstractions Literals Literal Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralSpecification
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural <em>Core Abstractions Literals Literal Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsLiteralsLiteralUnlimitedNatural
	 * @generated
	 */
	public Adapter createCoreAbstractionsLiteralsLiteralUnlimitedNaturalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement <em>Core Abstractions Redefinitions Redefinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsRedefinitionsRedefinableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature <em>Core Abstractions Changeabilities Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsChangeabilitiesStructuralFeature
	 * @generated
	 */
	public Adapter createCoreAbstractionsChangeabilitiesStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement <em>Core Abstractions Multiplicities Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement
	 * @generated
	 */
	public Adapter createCoreAbstractionsMultiplicitiesMultiplicityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization <em>Core Abstractions Generalizations Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization
	 * @generated
	 */
	public Adapter createCoreAbstractionsGeneralizationsGeneralizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier <em>Core Abstractions Generalizations Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier
	 * @generated
	 */
	public Adapter createCoreAbstractionsGeneralizationsClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsRelationshipsRelationship <em>Core Abstractions Relationships Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsRelationship
	 * @generated
	 */
	public Adapter createCoreAbstractionsRelationshipsRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship <em>Core Abstractions Relationships Directed Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship
	 * @generated
	 */
	public Adapter createCoreAbstractionsRelationshipsDirectedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.InstanciationInstance <em>Instanciation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.InstanciationInstance
	 * @generated
	 */
	public Adapter createInstanciationInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.InstanciationSlot <em>Instanciation Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.InstanciationSlot
	 * @generated
	 */
	public Adapter createInstanciationSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.InstanciationValue <em>Instanciation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.InstanciationValue
	 * @generated
	 */
	public Adapter createInstanciationValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.InstanciationCreate <em>Instanciation Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.InstanciationCreate
	 * @generated
	 */
	public Adapter createInstanciationCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.InstanciationMultiplicityFeature <em>Instanciation Multiplicity Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.InstanciationMultiplicityFeature
	 * @generated
	 */
	public Adapter createInstanciationMultiplicityFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationDataType <em>Evaluation Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationDataType
	 * @generated
	 */
	public Adapter createEvaluationDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationExpression <em>Evaluation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationExpression
	 * @generated
	 */
	public Adapter createEvaluationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationLiteralExpression <em>Evaluation Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationLiteralExpression
	 * @generated
	 */
	public Adapter createEvaluationLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationFeatureAccessExpression <em>Evaluation Feature Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationFeatureAccessExpression
	 * @generated
	 */
	public Adapter createEvaluationFeatureAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationLiteral <em>Evaluation Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationLiteral
	 * @generated
	 */
	public Adapter createEvaluationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationEvaluation <em>Evaluation Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationEvaluation
	 * @generated
	 */
	public Adapter createEvaluationEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression <em>Evaluation Behavioral Feature Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression
	 * @generated
	 */
	public Adapter createEvaluationBehavioralFeatureAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.EvaluationBehavioralFeatureAccess <em>Evaluation Behavioral Feature Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.EvaluationBehavioralFeatureAccess
	 * @generated
	 */
	public Adapter createEvaluationBehavioralFeatureAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationProcess <em>Communication Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationProcess
	 * @generated
	 */
	public Adapter createCommunicationProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationEventType <em>Communication Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationEventType
	 * @generated
	 */
	public Adapter createCommunicationEventTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationContext <em>Communication Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationContext
	 * @generated
	 */
	public Adapter createCommunicationContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationListener <em>Communication Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationListener
	 * @generated
	 */
	public Adapter createCommunicationListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationEvent <em>Communication Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationEvent
	 * @generated
	 */
	public Adapter createCommunicationEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationInput <em>Communication Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationInput
	 * @generated
	 */
	public Adapter createCommunicationInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationMedium <em>Communication Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationMedium
	 * @generated
	 */
	public Adapter createCommunicationMediumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.CommunicationCommunicator <em>Communication Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.CommunicationCommunicator
	 * @generated
	 */
	public Adapter createCommunicationCommunicatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.sdl.SdlSpecification <em>Sdl Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.sdl.SdlSpecification
	 * @generated
	 */
	public Adapter createSdlSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EmfSdlAdapterFactory
