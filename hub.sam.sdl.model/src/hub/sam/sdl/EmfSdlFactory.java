/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.sdl.EmfSdlPackage
 * @generated
 */
public interface EmfSdlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfSdlFactory eINSTANCE = hub.sam.sdl.impl.EmfSdlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Communication Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Event</em>'.
	 * @generated
	 */
	CommunicationEvent createCommunicationEvent();

	/**
	 * Returns a new object of class '<em>Concrete Syntax Sdl Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax Sdl Identifier</em>'.
	 * @generated
	 */
	ConcreteSyntaxSdlIdentifier createConcreteSyntaxSdlIdentifier();

	/**
	 * Returns a new object of class '<em>Concrete Syntax Sdl Path Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax Sdl Path Item</em>'.
	 * @generated
	 */
	ConcreteSyntaxSdlPathItem createConcreteSyntaxSdlPathItem();

	/**
	 * Returns a new object of class '<em>Concrete Syntax Sdl Qualifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax Sdl Qualifier</em>'.
	 * @generated
	 */
	ConcreteSyntaxSdlQualifier createConcreteSyntaxSdlQualifier();

	/**
	 * Returns a new object of class '<em>Concrete Syntax Sdl State List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax Sdl State List</em>'.
	 * @generated
	 */
	ConcreteSyntaxSdlStateList createConcreteSyntaxSdlStateList();

	/**
	 * Returns a new object of class '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector</em>'.
	 * @generated
	 */
	Connector createConnector();

	/**
	 * Returns a new object of class '<em>Core Abstractions Comments Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Comments Comment</em>'.
	 * @generated
	 */
	CoreAbstractionsCommentsComment createCoreAbstractionsCommentsComment();

	/**
	 * Returns a new object of class '<em>Core Abstractions Constraints Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Constraints Constraint</em>'.
	 * @generated
	 */
	CoreAbstractionsConstraintsConstraint createCoreAbstractionsConstraintsConstraint();

	/**
	 * Returns a new object of class '<em>Core Abstractions Expressions Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Expressions Expression</em>'.
	 * @generated
	 */
	CoreAbstractionsExpressionsExpression createCoreAbstractionsExpressionsExpression();

	/**
	 * Returns a new object of class '<em>Core Abstractions Expressions Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Expressions Opaque Expression</em>'.
	 * @generated
	 */
	CoreAbstractionsExpressionsOpaqueExpression createCoreAbstractionsExpressionsOpaqueExpression();

	/**
	 * Returns a new object of class '<em>Core Abstractions Generalizations Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Generalizations Generalization</em>'.
	 * @generated
	 */
	CoreAbstractionsGeneralizationsGeneralization createCoreAbstractionsGeneralizationsGeneralization();

	/**
	 * Returns a new object of class '<em>Core Abstractions Instances Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Instances Instance Specification</em>'.
	 * @generated
	 */
	CoreAbstractionsInstancesInstanceSpecification createCoreAbstractionsInstancesInstanceSpecification();

	/**
	 * Returns a new object of class '<em>Core Abstractions Instances Instance Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Instances Instance Value</em>'.
	 * @generated
	 */
	CoreAbstractionsInstancesInstanceValue createCoreAbstractionsInstancesInstanceValue();

	/**
	 * Returns a new object of class '<em>Core Abstractions Instances Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Instances Slot</em>'.
	 * @generated
	 */
	CoreAbstractionsInstancesSlot createCoreAbstractionsInstancesSlot();

	/**
	 * Returns a new object of class '<em>Core Abstractions Literals Literal Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Literals Literal Boolean</em>'.
	 * @generated
	 */
	CoreAbstractionsLiteralsLiteralBoolean createCoreAbstractionsLiteralsLiteralBoolean();

	/**
	 * Returns a new object of class '<em>Core Abstractions Literals Literal Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Literals Literal Integer</em>'.
	 * @generated
	 */
	CoreAbstractionsLiteralsLiteralInteger createCoreAbstractionsLiteralsLiteralInteger();

	/**
	 * Returns a new object of class '<em>Core Abstractions Literals Literal Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Literals Literal Null</em>'.
	 * @generated
	 */
	CoreAbstractionsLiteralsLiteralNull createCoreAbstractionsLiteralsLiteralNull();

	/**
	 * Returns a new object of class '<em>Core Abstractions Literals Literal String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Literals Literal String</em>'.
	 * @generated
	 */
	CoreAbstractionsLiteralsLiteralString createCoreAbstractionsLiteralsLiteralString();

	/**
	 * Returns a new object of class '<em>Core Abstractions Literals Literal Unlimited Natural</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Abstractions Literals Literal Unlimited Natural</em>'.
	 * @generated
	 */
	CoreAbstractionsLiteralsLiteralUnlimitedNatural createCoreAbstractionsLiteralsLiteralUnlimitedNatural();

	/**
	 * Returns a new object of class '<em>Evaluation Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation Evaluation</em>'.
	 * @generated
	 */
	EvaluationEvaluation createEvaluationEvaluation();

	/**
	 * Returns a new object of class '<em>Fork</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork</em>'.
	 * @generated
	 */
	Fork createFork();

	/**
	 * Returns a new object of class '<em>History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History</em>'.
	 * @generated
	 */
	History createHistory();

	/**
	 * Returns a new object of class '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join</em>'.
	 * @generated
	 */
	Join createJoin();

	/**
	 * Returns a new object of class '<em>Pid Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pid Value</em>'.
	 * @generated
	 */
	PidValue createPidValue();

	/**
	 * Returns a new object of class '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return</em>'.
	 * @generated
	 */
	Return createReturn();

	/**
	 * Returns a new object of class '<em>Sdl Agent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Agent</em>'.
	 * @generated
	 */
	SdlAgent createSdlAgent();

	/**
	 * Returns a new object of class '<em>Sdl Agent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Agent Instance</em>'.
	 * @generated
	 */
	SdlAgentInstance createSdlAgentInstance();

	/**
	 * Returns a new object of class '<em>Sdl Agent Instance Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Agent Instance Set</em>'.
	 * @generated
	 */
	SdlAgentInstanceSet createSdlAgentInstanceSet();

	/**
	 * Returns a new object of class '<em>Sdl Agent Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Agent Type</em>'.
	 * @generated
	 */
	SdlAgentType createSdlAgentType();

	/**
	 * Returns a new object of class '<em>Sdl Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Assignment</em>'.
	 * @generated
	 */
	SdlAssignment createSdlAssignment();

	/**
	 * Returns a new object of class '<em>Sdl Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Behavior</em>'.
	 * @generated
	 */
	SdlBehavior createSdlBehavior();

	/**
	 * Returns a new object of class '<em>Sdl Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Channel</em>'.
	 * @generated
	 */
	SdlChannel createSdlChannel();

	/**
	 * Returns a new object of class '<em>Sdl Channel End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Channel End</em>'.
	 * @generated
	 */
	SdlChannelEnd createSdlChannelEnd();

	/**
	 * Returns a new object of class '<em>Sdl Channel Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Channel Path</em>'.
	 * @generated
	 */
	SdlChannelPath createSdlChannelPath();

	/**
	 * Returns a new object of class '<em>Sdl Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Choice</em>'.
	 * @generated
	 */
	SdlChoice createSdlChoice();

	/**
	 * Returns a new object of class '<em>Sdl Closed Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Closed Range</em>'.
	 * @generated
	 */
	SdlClosedRange createSdlClosedRange();

	/**
	 * Returns a new object of class '<em>Sdl Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Composite State</em>'.
	 * @generated
	 */
	SdlCompositeState createSdlCompositeState();

	/**
	 * Returns a new object of class '<em>Sdl Composite State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Composite State Instance</em>'.
	 * @generated
	 */
	SdlCompositeStateInstance createSdlCompositeStateInstance();

	/**
	 * Returns a new object of class '<em>Sdl Create</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Create</em>'.
	 * @generated
	 */
	SdlCreate createSdlCreate();

	/**
	 * Returns a new object of class '<em>Sdl Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Data Type</em>'.
	 * @generated
	 */
	SdlDataType createSdlDataType();

	/**
	 * Returns a new object of class '<em>Sdl Else</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Else</em>'.
	 * @generated
	 */
	SdlElse createSdlElse();

	/**
	 * Returns a new object of class '<em>Sdl Gate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Gate</em>'.
	 * @generated
	 */
	SdlGate createSdlGate();

	/**
	 * Returns a new object of class '<em>Sdl General Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl General Value</em>'.
	 * @generated
	 */
	SdlGeneralValue createSdlGeneralValue();

	/**
	 * Returns a new object of class '<em>Sdl Imidiate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Imidiate</em>'.
	 * @generated
	 */
	SdlImidiate createSdlImidiate();

	/**
	 * Returns a new object of class '<em>Sdl Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Input</em>'.
	 * @generated
	 */
	SdlInput createSdlInput();

	/**
	 * Returns a new object of class '<em>Sdl Input Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Input Instance</em>'.
	 * @generated
	 */
	SdlInputInstance createSdlInputInstance();

	/**
	 * Returns a new object of class '<em>Sdl Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Literal</em>'.
	 * @generated
	 */
	SdlLiteral createSdlLiteral();

	/**
	 * Returns a new object of class '<em>Sdl Literal Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Literal Evaluation</em>'.
	 * @generated
	 */
	SdlLiteralEvaluation createSdlLiteralEvaluation();

	/**
	 * Returns a new object of class '<em>Sdl Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Literal Expression</em>'.
	 * @generated
	 */
	SdlLiteralExpression createSdlLiteralExpression();

	/**
	 * Returns a new object of class '<em>Sdl Now Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Now Expression</em>'.
	 * @generated
	 */
	SdlNowExpression createSdlNowExpression();

	/**
	 * Returns a new object of class '<em>Sdl Open Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Open Range</em>'.
	 * @generated
	 */
	SdlOpenRange createSdlOpenRange();

	/**
	 * Returns a new object of class '<em>Sdl Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Operation</em>'.
	 * @generated
	 */
	SdlOperation createSdlOperation();

	/**
	 * Returns a new object of class '<em>Sdl Operation Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Operation Call</em>'.
	 * @generated
	 */
	SdlOperationCall createSdlOperationCall();

	/**
	 * Returns a new object of class '<em>Sdl Operation Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Operation Evaluation</em>'.
	 * @generated
	 */
	SdlOperationEvaluation createSdlOperationEvaluation();

	/**
	 * Returns a new object of class '<em>Sdl Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Output</em>'.
	 * @generated
	 */
	SdlOutput createSdlOutput();

	/**
	 * Returns a new object of class '<em>Sdl Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Package</em>'.
	 * @generated
	 */
	SdlPackage createSdlPackage();

	/**
	 * Returns a new object of class '<em>Sdl Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Parameter</em>'.
	 * @generated
	 */
	SdlParameter createSdlParameter();

	/**
	 * Returns a new object of class '<em>Sdl Pid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Pid Expression</em>'.
	 * @generated
	 */
	SdlPidExpression createSdlPidExpression();

	/**
	 * Returns a new object of class '<em>Sdl Pid Expression Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Pid Expression Evaluation</em>'.
	 * @generated
	 */
	SdlPidExpressionEvaluation createSdlPidExpressionEvaluation();

	/**
	 * Returns a new object of class '<em>Sdl Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Procedure</em>'.
	 * @generated
	 */
	SdlProcedure createSdlProcedure();

	/**
	 * Returns a new object of class '<em>Sdl Procedure Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Procedure Call</em>'.
	 * @generated
	 */
	SdlProcedureCall createSdlProcedureCall();

	/**
	 * Returns a new object of class '<em>Sdl Procedure Frame</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Procedure Frame</em>'.
	 * @generated
	 */
	SdlProcedureFrame createSdlProcedureFrame();

	/**
	 * Returns a new object of class '<em>Sdl Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Range</em>'.
	 * @generated
	 */
	SdlRange createSdlRange();

	/**
	 * Returns a new object of class '<em>Sdl Range Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Range Condition</em>'.
	 * @generated
	 */
	SdlRangeCondition createSdlRangeCondition();

	/**
	 * Returns a new object of class '<em>Sdl Reset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Reset</em>'.
	 * @generated
	 */
	SdlReset createSdlReset();

	/**
	 * Returns a new object of class '<em>Sdl Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Set</em>'.
	 * @generated
	 */
	SdlSet createSdlSet();

	/**
	 * Returns a new object of class '<em>Sdl Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Signal</em>'.
	 * @generated
	 */
	SdlSignal createSdlSignal();

	/**
	 * Returns a new object of class '<em>Sdl Signal Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Signal Instance</em>'.
	 * @generated
	 */
	SdlSignalInstance createSdlSignalInstance();

	/**
	 * Returns a new object of class '<em>Sdl Split</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Split</em>'.
	 * @generated
	 */
	SdlSplit createSdlSplit();

	/**
	 * Returns a new object of class '<em>Sdl State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State</em>'.
	 * @generated
	 */
	SdlState createSdlState();

	/**
	 * Returns a new object of class '<em>Sdl State Automaton</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Automaton</em>'.
	 * @generated
	 */
	SdlStateAutomaton createSdlStateAutomaton();

	/**
	 * Returns a new object of class '<em>Sdl State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Instance</em>'.
	 * @generated
	 */
	SdlStateInstance createSdlStateInstance();

	/**
	 * Returns a new object of class '<em>Sdl State Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Node</em>'.
	 * @generated
	 */
	SdlStateNode createSdlStateNode();

	/**
	 * Returns a new object of class '<em>Sdl State Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Partition</em>'.
	 * @generated
	 */
	SdlStatePartition createSdlStatePartition();

	/**
	 * Returns a new object of class '<em>Sdl State Partition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Partition Instance</em>'.
	 * @generated
	 */
	SdlStatePartitionInstance createSdlStatePartitionInstance();

	/**
	 * Returns a new object of class '<em>Sdl State Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl State Type</em>'.
	 * @generated
	 */
	SdlStateType createSdlStateType();

	/**
	 * Returns a new object of class '<em>Sdl Timer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Timer</em>'.
	 * @generated
	 */
	SdlTimer createSdlTimer();

	/**
	 * Returns a new object of class '<em>Sdl Timer Active Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Timer Active Expression</em>'.
	 * @generated
	 */
	SdlTimerActiveExpression createSdlTimerActiveExpression();

	/**
	 * Returns a new object of class '<em>Sdl Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Transition</em>'.
	 * @generated
	 */
	SdlTransition createSdlTransition();

	/**
	 * Returns a new object of class '<em>Sdl Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Trigger</em>'.
	 * @generated
	 */
	SdlTrigger createSdlTrigger();

	/**
	 * Returns a new object of class '<em>Sdl Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Variable</em>'.
	 * @generated
	 */
	SdlVariable createSdlVariable();

	/**
	 * Returns a new object of class '<em>Sdl Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Variable Access</em>'.
	 * @generated
	 */
	SdlVariableAccess createSdlVariableAccess();

	/**
	 * Returns a new object of class '<em>Sdl Variable Access Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Variable Access Evaluation</em>'.
	 * @generated
	 */
	SdlVariableAccessEvaluation createSdlVariableAccessEvaluation();

	/**
	 * Returns a new object of class '<em>Sdl Variable Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Variable Slot</em>'.
	 * @generated
	 */
	SdlVariableSlot createSdlVariableSlot();

	/**
	 * Returns a new object of class '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start</em>'.
	 * @generated
	 */
	Start createStart();

	/**
	 * Returns a new object of class '<em>Stop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop</em>'.
	 * @generated
	 */
	Stop createStop();

	/**
	 * Returns a new object of class '<em>Sdl Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sdl Specification</em>'.
	 * @generated
	 */
	SdlSpecification createSdlSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmfSdlPackage getEmfSdlPackage();

} //EmfSdlFactory
