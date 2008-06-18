/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.util;

import hub.sam.sdl.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hub.sam.sdl.EmfSdlPackage
 * @generated
 */
public class EmfSdlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmfSdlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfSdlSwitch() {
		if (modelPackage == null) {
			modelPackage = EmfSdlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EmfSdlPackage.SDL_CREATE: {
				SdlCreate sdlCreate = (SdlCreate)theEObject;
				T result = caseSdlCreate(sdlCreate);
				if (result == null) result = caseInstanciationCreate(sdlCreate);
				if (result == null) result = caseSdlAction(sdlCreate);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlCreate);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_ASSIGNMENT: {
				SdlAssignment sdlAssignment = (SdlAssignment)theEObject;
				T result = caseSdlAssignment(sdlAssignment);
				if (result == null) result = caseSdlAction(sdlAssignment);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_RESET: {
				SdlReset sdlReset = (SdlReset)theEObject;
				T result = caseSdlReset(sdlReset);
				if (result == null) result = caseSdlSet(sdlReset);
				if (result == null) result = caseSdlOutput(sdlReset);
				if (result == null) result = caseSdlAction(sdlReset);
				if (result == null) result = caseInstanciationCreate(sdlReset);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlReset);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlReset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_OUTPUT: {
				SdlOutput sdlOutput = (SdlOutput)theEObject;
				T result = caseSdlOutput(sdlOutput);
				if (result == null) result = caseSdlAction(sdlOutput);
				if (result == null) result = caseInstanciationCreate(sdlOutput);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlOutput);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_SIGNAL_INSTANCE: {
				SdlSignalInstance sdlSignalInstance = (SdlSignalInstance)theEObject;
				T result = caseSdlSignalInstance(sdlSignalInstance);
				if (result == null) result = caseCommunicationEvent(sdlSignalInstance);
				if (result == null) result = caseSdlInstance(sdlSignalInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlSignalInstance);
				if (result == null) result = caseInstanciationValue(sdlSignalInstance);
				if (result == null) result = caseInstanciationInstance(sdlSignalInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_SET: {
				SdlSet sdlSet = (SdlSet)theEObject;
				T result = caseSdlSet(sdlSet);
				if (result == null) result = caseSdlOutput(sdlSet);
				if (result == null) result = caseSdlAction(sdlSet);
				if (result == null) result = caseInstanciationCreate(sdlSet);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlSet);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_AGENT_INSTANCE: {
				SdlAgentInstance sdlAgentInstance = (SdlAgentInstance)theEObject;
				T result = caseSdlAgentInstance(sdlAgentInstance);
				if (result == null) result = caseSdlInstance(sdlAgentInstance);
				if (result == null) result = caseInstanciationInstance(sdlAgentInstance);
				if (result == null) result = caseInstanciationValue(sdlAgentInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAgentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_DATA_VALUE: {
				SdlDataValue sdlDataValue = (SdlDataValue)theEObject;
				T result = caseSdlDataValue(sdlDataValue);
				if (result == null) result = caseInstanciationValue(sdlDataValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlDataValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_AGENT: {
				SdlAgent sdlAgent = (SdlAgent)theEObject;
				T result = caseSdlAgent(sdlAgent);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlAgent);
				if (result == null) result = caseInstanciationMultiplicityFeature(sdlAgent);
				if (result == null) result = caseCommunicationMedium(sdlAgent);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlAgent);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlAgent);
				if (result == null) result = caseCoreAbstractionsMultiplicitiesMultiplicityElement(sdlAgent);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAgent);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlAgent);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlAgent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PROCEDURE: {
				SdlProcedure sdlProcedure = (SdlProcedure)theEObject;
				T result = caseSdlProcedure(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlProcedure);
				if (result == null) result = caseSdlBehaviorElement(sdlProcedure);
				if (result == null) result = caseSdlClassifier(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlProcedure);
				if (result == null) result = caseSdlNamespace(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlProcedure);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlProcedure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_AGENT_INSTANCE_SET: {
				SdlAgentInstanceSet sdlAgentInstanceSet = (SdlAgentInstanceSet)theEObject;
				T result = caseSdlAgentInstanceSet(sdlAgentInstanceSet);
				if (result == null) result = caseInstanciationSlot(sdlAgentInstanceSet);
				if (result == null) result = caseCommunicationContext(sdlAgentInstanceSet);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAgentInstanceSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_VARIABLE: {
				SdlVariable sdlVariable = (SdlVariable)theEObject;
				T result = caseSdlVariable(sdlVariable);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlVariable);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlVariable);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlVariable);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlVariable);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlVariable);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_AGENT_TYPE: {
				SdlAgentType sdlAgentType = (SdlAgentType)theEObject;
				T result = caseSdlAgentType(sdlAgentType);
				if (result == null) result = caseSdlBehaviorElement(sdlAgentType);
				if (result == null) result = caseSdlClassifier(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAgentType);
				if (result == null) result = caseSdlNamespace(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlAgentType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlAgentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_DATA_TYPE: {
				SdlDataType sdlDataType = (SdlDataType)theEObject;
				T result = caseSdlDataType(sdlDataType);
				if (result == null) result = caseEvaluationDataType(sdlDataType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlDataType);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlDataType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlDataType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlDataType);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_VARIABLE_SLOT: {
				SdlVariableSlot sdlVariableSlot = (SdlVariableSlot)theEObject;
				T result = caseSdlVariableSlot(sdlVariableSlot);
				if (result == null) result = caseInstanciationSlot(sdlVariableSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CHANNEL: {
				SdlChannel sdlChannel = (SdlChannel)theEObject;
				T result = caseSdlChannel(sdlChannel);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlChannel);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlChannel);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CHANNEL_END: {
				SdlChannelEnd sdlChannelEnd = (SdlChannelEnd)theEObject;
				T result = caseSdlChannelEnd(sdlChannelEnd);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlChannelEnd);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlChannelEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CHANNEL_PATH: {
				SdlChannelPath sdlChannelPath = (SdlChannelPath)theEObject;
				T result = caseSdlChannelPath(sdlChannelPath);
				if (result == null) result = caseCoreAbstractionsRelationshipsDirectedRelationship(sdlChannelPath);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlChannelPath);
				if (result == null) result = caseCoreAbstractionsRelationshipsRelationship(sdlChannelPath);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlChannelPath);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlChannelPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_GATE: {
				SdlGate sdlGate = (SdlGate)theEObject;
				T result = caseSdlGate(sdlGate);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlGate);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlGate);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlGate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_SIGNAL: {
				SdlSignal sdlSignal = (SdlSignal)theEObject;
				T result = caseSdlSignal(sdlSignal);
				if (result == null) result = caseCommunicationEventType(sdlSignal);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(sdlSignal);
				if (result == null) result = caseSdlClassifier(sdlSignal);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlSignal);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlSignal);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlSignal);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlSignal);
				if (result == null) result = caseSdlNamespace(sdlSignal);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlSignal);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlSignal);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlSignal);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlSignal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_TIMER: {
				SdlTimer sdlTimer = (SdlTimer)theEObject;
				T result = caseSdlTimer(sdlTimer);
				if (result == null) result = caseSdlSignal(sdlTimer);
				if (result == null) result = caseCommunicationEventType(sdlTimer);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(sdlTimer);
				if (result == null) result = caseSdlClassifier(sdlTimer);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlTimer);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlTimer);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlTimer);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlTimer);
				if (result == null) result = caseSdlNamespace(sdlTimer);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlTimer);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlTimer);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlTimer);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlTimer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_TRIGGER: {
				SdlTrigger sdlTrigger = (SdlTrigger)theEObject;
				T result = caseSdlTrigger(sdlTrigger);
				if (result == null) result = caseCommunicationInput(sdlTrigger);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlTrigger);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlTrigger);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlTrigger);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlTrigger);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_INPUT_INSTANCE: {
				SdlInputInstance sdlInputInstance = (SdlInputInstance)theEObject;
				T result = caseSdlInputInstance(sdlInputInstance);
				if (result == null) result = caseCommunicationListener(sdlInputInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlInputInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_VARIABLE_ACCESS_EVALUATION: {
				SdlVariableAccessEvaluation sdlVariableAccessEvaluation = (SdlVariableAccessEvaluation)theEObject;
				T result = caseSdlVariableAccessEvaluation(sdlVariableAccessEvaluation);
				if (result == null) result = caseSdlEvaluation(sdlVariableAccessEvaluation);
				if (result == null) result = caseEvaluationEvaluation(sdlVariableAccessEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlVariableAccessEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_VARIABLE_ACCESS: {
				SdlVariableAccess sdlVariableAccess = (SdlVariableAccess)theEObject;
				T result = caseSdlVariableAccess(sdlVariableAccess);
				if (result == null) result = caseEvaluationFeatureAccessExpression(sdlVariableAccess);
				if (result == null) result = caseEvaluationExpression(sdlVariableAccess);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlVariableAccess);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlVariableAccess);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlVariableAccess);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlVariableAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PROCEDURE_FRAME: {
				SdlProcedureFrame sdlProcedureFrame = (SdlProcedureFrame)theEObject;
				T result = caseSdlProcedureFrame(sdlProcedureFrame);
				if (result == null) result = caseSdlInstance(sdlProcedureFrame);
				if (result == null) result = caseInstanciationInstance(sdlProcedureFrame);
				if (result == null) result = caseInstanciationValue(sdlProcedureFrame);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlProcedureFrame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_OPEN_RANGE: {
				SdlOpenRange sdlOpenRange = (SdlOpenRange)theEObject;
				T result = caseSdlOpenRange(sdlOpenRange);
				if (result == null) result = caseSdlRange(sdlOpenRange);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlOpenRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_TIMER_ACTIVE_EXPRESSION: {
				SdlTimerActiveExpression sdlTimerActiveExpression = (SdlTimerActiveExpression)theEObject;
				T result = caseSdlTimerActiveExpression(sdlTimerActiveExpression);
				if (result == null) result = caseEvaluationBehavioralFeatureAccessExpression(sdlTimerActiveExpression);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlTimerActiveExpression);
				if (result == null) result = caseEvaluationFeatureAccessExpression(sdlTimerActiveExpression);
				if (result == null) result = caseEvaluationExpression(sdlTimerActiveExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlTimerActiveExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlTimerActiveExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlTimerActiveExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlTimerActiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_OPERATION: {
				SdlOperation sdlOperation = (SdlOperation)theEObject;
				T result = caseSdlOperation(sdlOperation);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlOperation);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(sdlOperation);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlOperation);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlOperation);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlOperation);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlOperation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_RANGE: {
				SdlRange sdlRange = (SdlRange)theEObject;
				T result = caseSdlRange(sdlRange);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PROCEDURE_CALL: {
				SdlProcedureCall sdlProcedureCall = (SdlProcedureCall)theEObject;
				T result = caseSdlProcedureCall(sdlProcedureCall);
				if (result == null) result = caseEvaluationBehavioralFeatureAccessExpression(sdlProcedureCall);
				if (result == null) result = caseInstanciationCreate(sdlProcedureCall);
				if (result == null) result = caseSdlAction(sdlProcedureCall);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlProcedureCall);
				if (result == null) result = caseEvaluationFeatureAccessExpression(sdlProcedureCall);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlProcedureCall);
				if (result == null) result = caseEvaluationExpression(sdlProcedureCall);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlProcedureCall);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlProcedureCall);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlProcedureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_LITERAL_EXPRESSION: {
				SdlLiteralExpression sdlLiteralExpression = (SdlLiteralExpression)theEObject;
				T result = caseSdlLiteralExpression(sdlLiteralExpression);
				if (result == null) result = caseEvaluationLiteralExpression(sdlLiteralExpression);
				if (result == null) result = caseEvaluationExpression(sdlLiteralExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlLiteralExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlLiteralExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlLiteralExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_NOW_EXPRESSION: {
				SdlNowExpression sdlNowExpression = (SdlNowExpression)theEObject;
				T result = caseSdlNowExpression(sdlNowExpression);
				if (result == null) result = caseEvaluationExpression(sdlNowExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlNowExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlNowExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlNowExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlNowExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PID_EXPRESSION: {
				SdlPidExpression sdlPidExpression = (SdlPidExpression)theEObject;
				T result = caseSdlPidExpression(sdlPidExpression);
				if (result == null) result = caseEvaluationExpression(sdlPidExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlPidExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlPidExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlPidExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlPidExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_RANGE_CONDITION: {
				SdlRangeCondition sdlRangeCondition = (SdlRangeCondition)theEObject;
				T result = caseSdlRangeCondition(sdlRangeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_OPERATION_CALL: {
				SdlOperationCall sdlOperationCall = (SdlOperationCall)theEObject;
				T result = caseSdlOperationCall(sdlOperationCall);
				if (result == null) result = caseEvaluationBehavioralFeatureAccessExpression(sdlOperationCall);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(sdlOperationCall);
				if (result == null) result = caseEvaluationFeatureAccessExpression(sdlOperationCall);
				if (result == null) result = caseEvaluationExpression(sdlOperationCall);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlOperationCall);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlOperationCall);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlOperationCall);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlOperationCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_LITERAL: {
				SdlLiteral sdlLiteral = (SdlLiteral)theEObject;
				T result = caseSdlLiteral(sdlLiteral);
				if (result == null) result = caseEvaluationLiteral(sdlLiteral);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlLiteral);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlLiteral);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CLOSED_RANGE: {
				SdlClosedRange sdlClosedRange = (SdlClosedRange)theEObject;
				T result = caseSdlClosedRange(sdlClosedRange);
				if (result == null) result = caseSdlRange(sdlClosedRange);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlClosedRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PARAMETER: {
				SdlParameter sdlParameter = (SdlParameter)theEObject;
				T result = caseSdlParameter(sdlParameter);
				if (result == null) result = caseSdlVariable(sdlParameter);
				if (result == null) result = caseCoreAbstractionsBehavioralFeaturesParameter(sdlParameter);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlParameter);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlParameter);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlParameter);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlParameter);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlParameter);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PACKAGE: {
				SdlPackage sdlPackage = (SdlPackage)theEObject;
				T result = caseSdlPackage(sdlPackage);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlPackage);
				if (result == null) result = caseSdlNamespace(sdlPackage);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlPackage);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlPackage);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseSdlPseudoState(connector);
				if (result == null) result = caseSdlNamedState(connector);
				if (result == null) result = caseSdlAbstractState(connector);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(connector);
				if (result == null) result = caseCoreAbstractionsElementsElement(connector);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.JOIN: {
				Join join = (Join)theEObject;
				T result = caseJoin(join);
				if (result == null) result = caseSdlPseudoState(join);
				if (result == null) result = caseSdlAbstractState(join);
				if (result == null) result = caseCoreAbstractionsElementsElement(join);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.HISTORY: {
				History history = (History)theEObject;
				T result = caseHistory(history);
				if (result == null) result = caseStart(history);
				if (result == null) result = caseSdlPseudoState(history);
				if (result == null) result = caseSdlAbstractState(history);
				if (result == null) result = caseCoreAbstractionsElementsElement(history);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.RETURN: {
				Return return_ = (Return)theEObject;
				T result = caseReturn(return_);
				if (result == null) result = caseStop(return_);
				if (result == null) result = caseSdlPseudoState(return_);
				if (result == null) result = caseSdlAbstractState(return_);
				if (result == null) result = caseCoreAbstractionsElementsElement(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.FORK: {
				Fork fork = (Fork)theEObject;
				T result = caseFork(fork);
				if (result == null) result = caseSdlPseudoState(fork);
				if (result == null) result = caseSdlAbstractState(fork);
				if (result == null) result = caseCoreAbstractionsElementsElement(fork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT: {
				SdlBehaviorElement sdlBehaviorElement = (SdlBehaviorElement)theEObject;
				T result = caseSdlBehaviorElement(sdlBehaviorElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlBehaviorElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_ABSTRACT_STATE: {
				SdlAbstractState sdlAbstractState = (SdlAbstractState)theEObject;
				T result = caseSdlAbstractState(sdlAbstractState);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAbstractState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_ACTION: {
				SdlAction sdlAction = (SdlAction)theEObject;
				T result = caseSdlAction(sdlAction);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CHOICE: {
				SdlChoice sdlChoice = (SdlChoice)theEObject;
				T result = caseSdlChoice(sdlChoice);
				if (result == null) result = caseSdlTrigger(sdlChoice);
				if (result == null) result = caseCommunicationInput(sdlChoice);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlChoice);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlChoice);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlChoice);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlChoice);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_BEHAVIOR: {
				SdlBehavior sdlBehavior = (SdlBehavior)theEObject;
				T result = caseSdlBehavior(sdlBehavior);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_COMPOSITE_STATE: {
				SdlCompositeState sdlCompositeState = (SdlCompositeState)theEObject;
				T result = caseSdlCompositeState(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlCompositeState);
				if (result == null) result = caseSdlState(sdlCompositeState);
				if (result == null) result = caseSdlBehavior(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlCompositeState);
				if (result == null) result = caseSdlNamedState(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlCompositeState);
				if (result == null) result = caseSdlAbstractState(sdlCompositeState);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlCompositeState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_ELSE: {
				SdlElse sdlElse = (SdlElse)theEObject;
				T result = caseSdlElse(sdlElse);
				if (result == null) result = caseSdlChoice(sdlElse);
				if (result == null) result = caseSdlTrigger(sdlElse);
				if (result == null) result = caseCommunicationInput(sdlElse);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlElse);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlElse);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlElse);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlElse);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlElse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_COMPOSITE_STATE_INSTANCE: {
				SdlCompositeStateInstance sdlCompositeStateInstance = (SdlCompositeStateInstance)theEObject;
				T result = caseSdlCompositeStateInstance(sdlCompositeStateInstance);
				if (result == null) result = caseSdlInstance(sdlCompositeStateInstance);
				if (result == null) result = caseCommunicationProcess(sdlCompositeStateInstance);
				if (result == null) result = caseInstanciationInstance(sdlCompositeStateInstance);
				if (result == null) result = caseInstanciationValue(sdlCompositeStateInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlCompositeStateInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PSEUDO_STATE: {
				SdlPseudoState sdlPseudoState = (SdlPseudoState)theEObject;
				T result = caseSdlPseudoState(sdlPseudoState);
				if (result == null) result = caseSdlAbstractState(sdlPseudoState);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlPseudoState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_INPUT: {
				SdlInput sdlInput = (SdlInput)theEObject;
				T result = caseSdlInput(sdlInput);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlInput);
				if (result == null) result = caseSdlTrigger(sdlInput);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlInput);
				if (result == null) result = caseCommunicationInput(sdlInput);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlInput);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlInput);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_IMIDIATE: {
				SdlImidiate sdlImidiate = (SdlImidiate)theEObject;
				T result = caseSdlImidiate(sdlImidiate);
				if (result == null) result = caseSdlTrigger(sdlImidiate);
				if (result == null) result = caseCommunicationInput(sdlImidiate);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlImidiate);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlImidiate);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlImidiate);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlImidiate);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlImidiate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_INSTANCE: {
				SdlStateInstance sdlStateInstance = (SdlStateInstance)theEObject;
				T result = caseSdlStateInstance(sdlStateInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_NODE: {
				SdlStateNode sdlStateNode = (SdlStateNode)theEObject;
				T result = caseSdlStateNode(sdlStateNode);
				if (result == null) result = caseSdlPseudoState(sdlStateNode);
				if (result == null) result = caseSdlAbstractState(sdlStateNode);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlStateNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE: {
				SdlStatePartitionInstance sdlStatePartitionInstance = (SdlStatePartitionInstance)theEObject;
				T result = caseSdlStatePartitionInstance(sdlStatePartitionInstance);
				if (result == null) result = caseSdlStateInstance(sdlStatePartitionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_AUTOMATON: {
				SdlStateAutomaton sdlStateAutomaton = (SdlStateAutomaton)theEObject;
				T result = caseSdlStateAutomaton(sdlStateAutomaton);
				if (result == null) result = caseSdlBehavior(sdlStateAutomaton);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlStateAutomaton);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlStateAutomaton);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlStateAutomaton);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlStateAutomaton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE: {
				SdlState sdlState = (SdlState)theEObject;
				T result = caseSdlState(sdlState);
				if (result == null) result = caseSdlNamedState(sdlState);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlState);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlState);
				if (result == null) result = caseSdlAbstractState(sdlState);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlState);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlState);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlState);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_PARTITION: {
				SdlStatePartition sdlStatePartition = (SdlStatePartition)theEObject;
				T result = caseSdlStatePartition(sdlStatePartition);
				if (result == null) result = caseSdlState(sdlStatePartition);
				if (result == null) result = caseSdlBehavior(sdlStatePartition);
				if (result == null) result = caseSdlNamedState(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlStatePartition);
				if (result == null) result = caseSdlAbstractState(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(sdlStatePartition);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlStatePartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_TRANSITION: {
				SdlTransition sdlTransition = (SdlTransition)theEObject;
				T result = caseSdlTransition(sdlTransition);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_STATE_TYPE: {
				SdlStateType sdlStateType = (SdlStateType)theEObject;
				T result = caseSdlStateType(sdlStateType);
				if (result == null) result = caseSdlClassifier(sdlStateType);
				if (result == null) result = caseCommunicationCommunicator(sdlStateType);
				if (result == null) result = caseSdlNamespace(sdlStateType);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlStateType);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlStateType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlStateType);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlStateType);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlStateType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlStateType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlStateType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_SPLIT: {
				SdlSplit sdlSplit = (SdlSplit)theEObject;
				T result = caseSdlSplit(sdlSplit);
				if (result == null) result = caseSdlPseudoState(sdlSplit);
				if (result == null) result = caseSdlAbstractState(sdlSplit);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlSplit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.START: {
				Start start = (Start)theEObject;
				T result = caseStart(start);
				if (result == null) result = caseSdlPseudoState(start);
				if (result == null) result = caseSdlAbstractState(start);
				if (result == null) result = caseCoreAbstractionsElementsElement(start);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.STOP: {
				Stop stop = (Stop)theEObject;
				T result = caseStop(stop);
				if (result == null) result = caseSdlPseudoState(stop);
				if (result == null) result = caseSdlAbstractState(stop);
				if (result == null) result = caseCoreAbstractionsElementsElement(stop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_CLASSIFIER: {
				SdlClassifier sdlClassifier = (SdlClassifier)theEObject;
				T result = caseSdlClassifier(sdlClassifier);
				if (result == null) result = caseSdlNamespace(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsGeneralizationsClassifier(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlClassifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_NAMESPACE: {
				SdlNamespace sdlNamespace = (SdlNamespace)theEObject;
				T result = caseSdlNamespace(sdlNamespace);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(sdlNamespace);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlNamespace);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlNamespace);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_NAMED_STATE: {
				SdlNamedState sdlNamedState = (SdlNamedState)theEObject;
				T result = caseSdlNamedState(sdlNamedState);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(sdlNamedState);
				if (result == null) result = caseSdlAbstractState(sdlNamedState);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(sdlNamedState);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlNamedState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_INSTANCE: {
				SdlInstance sdlInstance = (SdlInstance)theEObject;
				T result = caseSdlInstance(sdlInstance);
				if (result == null) result = caseInstanciationInstance(sdlInstance);
				if (result == null) result = caseInstanciationValue(sdlInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_OPERATION_EVALUATION: {
				SdlOperationEvaluation sdlOperationEvaluation = (SdlOperationEvaluation)theEObject;
				T result = caseSdlOperationEvaluation(sdlOperationEvaluation);
				if (result == null) result = caseSdlEvaluation(sdlOperationEvaluation);
				if (result == null) result = caseEvaluationEvaluation(sdlOperationEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlOperationEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_EVALUATION: {
				SdlEvaluation sdlEvaluation = (SdlEvaluation)theEObject;
				T result = caseSdlEvaluation(sdlEvaluation);
				if (result == null) result = caseEvaluationEvaluation(sdlEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_LITERAL_EVALUATION: {
				SdlLiteralEvaluation sdlLiteralEvaluation = (SdlLiteralEvaluation)theEObject;
				T result = caseSdlLiteralEvaluation(sdlLiteralEvaluation);
				if (result == null) result = caseSdlEvaluation(sdlLiteralEvaluation);
				if (result == null) result = caseEvaluationEvaluation(sdlLiteralEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlLiteralEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PRIMITIVE_VALUE: {
				SdlPrimitiveValue sdlPrimitiveValue = (SdlPrimitiveValue)theEObject;
				T result = caseSdlPrimitiveValue(sdlPrimitiveValue);
				if (result == null) result = caseSdlDataValue(sdlPrimitiveValue);
				if (result == null) result = caseInstanciationValue(sdlPrimitiveValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlPrimitiveValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_PID_EXPRESSION_EVALUATION: {
				SdlPidExpressionEvaluation sdlPidExpressionEvaluation = (SdlPidExpressionEvaluation)theEObject;
				T result = caseSdlPidExpressionEvaluation(sdlPidExpressionEvaluation);
				if (result == null) result = caseSdlEvaluation(sdlPidExpressionEvaluation);
				if (result == null) result = caseEvaluationEvaluation(sdlPidExpressionEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlPidExpressionEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.PID_VALUE: {
				PidValue pidValue = (PidValue)theEObject;
				T result = casePidValue(pidValue);
				if (result == null) result = caseSdlPrimitiveValue(pidValue);
				if (result == null) result = caseSdlDataValue(pidValue);
				if (result == null) result = caseInstanciationValue(pidValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(pidValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_GENERAL_VALUE: {
				SdlGeneralValue sdlGeneralValue = (SdlGeneralValue)theEObject;
				T result = caseSdlGeneralValue(sdlGeneralValue);
				if (result == null) result = caseSdlDataValue(sdlGeneralValue);
				if (result == null) result = caseInstanciationValue(sdlGeneralValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(sdlGeneralValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER: {
				ConcreteSyntaxSdlQualifier concreteSyntaxSdlQualifier = (ConcreteSyntaxSdlQualifier)theEObject;
				T result = caseConcreteSyntaxSdlQualifier(concreteSyntaxSdlQualifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(concreteSyntaxSdlQualifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_PATH_ITEM: {
				ConcreteSyntaxSdlPathItem concreteSyntaxSdlPathItem = (ConcreteSyntaxSdlPathItem)theEObject;
				T result = caseConcreteSyntaxSdlPathItem(concreteSyntaxSdlPathItem);
				if (result == null) result = caseCoreAbstractionsElementsElement(concreteSyntaxSdlPathItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_IDENTIFIER: {
				ConcreteSyntaxSdlIdentifier concreteSyntaxSdlIdentifier = (ConcreteSyntaxSdlIdentifier)theEObject;
				T result = caseConcreteSyntaxSdlIdentifier(concreteSyntaxSdlIdentifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(concreteSyntaxSdlIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPE: {
				CoreAbstractionsTypedElementsType coreAbstractionsTypedElementsType = (CoreAbstractionsTypedElementsType)theEObject;
				T result = caseCoreAbstractionsTypedElementsType(coreAbstractionsTypedElementsType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsTypedElementsType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsTypedElementsType);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsTypedElementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT: {
				CoreAbstractionsTypedElementsTypedElement coreAbstractionsTypedElementsTypedElement = (CoreAbstractionsTypedElementsTypedElement)theEObject;
				T result = caseCoreAbstractionsTypedElementsTypedElement(coreAbstractionsTypedElementsTypedElement);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsTypedElementsTypedElement);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsTypedElementsTypedElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsTypedElementsTypedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_PARAMETER: {
				CoreAbstractionsBehavioralFeaturesParameter coreAbstractionsBehavioralFeaturesParameter = (CoreAbstractionsBehavioralFeaturesParameter)theEObject;
				T result = caseCoreAbstractionsBehavioralFeaturesParameter(coreAbstractionsBehavioralFeaturesParameter);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsBehavioralFeaturesParameter);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(coreAbstractionsBehavioralFeaturesParameter);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsBehavioralFeaturesParameter);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsBehavioralFeaturesParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE: {
				CoreAbstractionsBehavioralFeaturesBehavioralFeature coreAbstractionsBehavioralFeaturesBehavioralFeature = (CoreAbstractionsBehavioralFeaturesBehavioralFeature)theEObject;
				T result = caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsBehavioralFeaturesBehavioralFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_STRUCTURAL_FEATURES_STRUCTURAL_FEATURE: {
				CoreAbstractionsStructuralFeaturesStructuralFeature coreAbstractionsStructuralFeaturesStructuralFeature = (CoreAbstractionsStructuralFeaturesStructuralFeature)theEObject;
				T result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsStructuralFeaturesStructuralFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_COMMENTS_COMMENT: {
				CoreAbstractionsCommentsComment coreAbstractionsCommentsComment = (CoreAbstractionsCommentsComment)theEObject;
				T result = caseCoreAbstractionsCommentsComment(coreAbstractionsCommentsComment);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsCommentsComment);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsCommentsComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT: {
				CoreAbstractionsOwnershipsElement coreAbstractionsOwnershipsElement = (CoreAbstractionsOwnershipsElement)theEObject;
				T result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsOwnershipsElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsOwnershipsElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_SPECIFICATION: {
				CoreAbstractionsInstancesInstanceSpecification coreAbstractionsInstancesInstanceSpecification = (CoreAbstractionsInstancesInstanceSpecification)theEObject;
				T result = caseCoreAbstractionsInstancesInstanceSpecification(coreAbstractionsInstancesInstanceSpecification);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsInstancesInstanceSpecification);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsInstancesInstanceSpecification);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsInstancesInstanceSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_INSTANCE_VALUE: {
				CoreAbstractionsInstancesInstanceValue coreAbstractionsInstancesInstanceValue = (CoreAbstractionsInstancesInstanceValue)theEObject;
				T result = caseCoreAbstractionsInstancesInstanceValue(coreAbstractionsInstancesInstanceValue);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsInstancesInstanceValue);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsInstancesInstanceValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsInstancesInstanceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_INSTANCES_SLOT: {
				CoreAbstractionsInstancesSlot coreAbstractionsInstancesSlot = (CoreAbstractionsInstancesSlot)theEObject;
				T result = caseCoreAbstractionsInstancesSlot(coreAbstractionsInstancesSlot);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsInstancesSlot);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsInstancesSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT: {
				CoreAbstractionsElementsElement coreAbstractionsElementsElement = (CoreAbstractionsElementsElement)theEObject;
				T result = caseCoreAbstractionsElementsElement(coreAbstractionsElementsElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_VISIBILITIES_NAMED_ELEMENT: {
				CoreAbstractionsVisibilitiesNamedElement coreAbstractionsVisibilitiesNamedElement = (CoreAbstractionsVisibilitiesNamedElement)theEObject;
				T result = caseCoreAbstractionsVisibilitiesNamedElement(coreAbstractionsVisibilitiesNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT: {
				CoreAbstractionsConstraintsNamedElement coreAbstractionsConstraintsNamedElement = (CoreAbstractionsConstraintsNamedElement)theEObject;
				T result = caseCoreAbstractionsConstraintsNamedElement(coreAbstractionsConstraintsNamedElement);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsConstraintsNamedElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsConstraintsNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE: {
				CoreAbstractionsConstraintsNamespace coreAbstractionsConstraintsNamespace = (CoreAbstractionsConstraintsNamespace)theEObject;
				T result = caseCoreAbstractionsConstraintsNamespace(coreAbstractionsConstraintsNamespace);
				if (result == null) result = caseCoreAbstractionsConstraintsNamedElement(coreAbstractionsConstraintsNamespace);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsConstraintsNamespace);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsConstraintsNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT: {
				CoreAbstractionsConstraintsConstraint coreAbstractionsConstraintsConstraint = (CoreAbstractionsConstraintsConstraint)theEObject;
				T result = caseCoreAbstractionsConstraintsConstraint(coreAbstractionsConstraintsConstraint);
				if (result == null) result = caseCoreAbstractionsConstraintsNamedElement(coreAbstractionsConstraintsConstraint);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsConstraintsConstraint);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsConstraintsConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT: {
				CoreAbstractionsNamespacesNamedElement coreAbstractionsNamespacesNamedElement = (CoreAbstractionsNamespacesNamedElement)theEObject;
				T result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsNamespacesNamedElement);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsNamespacesNamedElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsNamespacesNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE: {
				CoreAbstractionsNamespacesNamespace coreAbstractionsNamespacesNamespace = (CoreAbstractionsNamespacesNamespace)theEObject;
				T result = caseCoreAbstractionsNamespacesNamespace(coreAbstractionsNamespacesNamespace);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsNamespacesNamespace);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsNamespacesNamespace);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsNamespacesNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER: {
				CoreAbstractionsSuperClassifier coreAbstractionsSuperClassifier = (CoreAbstractionsSuperClassifier)theEObject;
				T result = caseCoreAbstractionsSuperClassifier(coreAbstractionsSuperClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(coreAbstractionsSuperClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsSuperClassifier);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsSuperClassifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsSuperClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE: {
				CoreAbstractionsClassifiersFeature coreAbstractionsClassifiersFeature = (CoreAbstractionsClassifiersFeature)theEObject;
				T result = caseCoreAbstractionsClassifiersFeature(coreAbstractionsClassifiersFeature);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsClassifiersFeature);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsClassifiersFeature);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsClassifiersFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER: {
				CoreAbstractionsClassifiersClassifier coreAbstractionsClassifiersClassifier = (CoreAbstractionsClassifiersClassifier)theEObject;
				T result = caseCoreAbstractionsClassifiersClassifier(coreAbstractionsClassifiersClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(coreAbstractionsClassifiersClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsClassifiersClassifier);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsClassifiersClassifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsClassifiersClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION: {
				CoreAbstractionsExpressionsExpression coreAbstractionsExpressionsExpression = (CoreAbstractionsExpressionsExpression)theEObject;
				T result = caseCoreAbstractionsExpressionsExpression(coreAbstractionsExpressionsExpression);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsExpressionsExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsExpressionsExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsExpressionsExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_VALUE_SPECIFICATION: {
				CoreAbstractionsExpressionsValueSpecification coreAbstractionsExpressionsValueSpecification = (CoreAbstractionsExpressionsValueSpecification)theEObject;
				T result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsExpressionsValueSpecification);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsExpressionsValueSpecification);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsExpressionsValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_OPAQUE_EXPRESSION: {
				CoreAbstractionsExpressionsOpaqueExpression coreAbstractionsExpressionsOpaqueExpression = (CoreAbstractionsExpressionsOpaqueExpression)theEObject;
				T result = caseCoreAbstractionsExpressionsOpaqueExpression(coreAbstractionsExpressionsOpaqueExpression);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsExpressionsOpaqueExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsExpressionsOpaqueExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsExpressionsOpaqueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT: {
				CoreAbstractionsMultiplicityExpressionsMultiplicityElement coreAbstractionsMultiplicityExpressionsMultiplicityElement = (CoreAbstractionsMultiplicityExpressionsMultiplicityElement)theEObject;
				T result = caseCoreAbstractionsMultiplicityExpressionsMultiplicityElement(coreAbstractionsMultiplicityExpressionsMultiplicityElement);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsMultiplicityExpressionsMultiplicityElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsMultiplicityExpressionsMultiplicityElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_INTEGER: {
				CoreAbstractionsLiteralsLiteralInteger coreAbstractionsLiteralsLiteralInteger = (CoreAbstractionsLiteralsLiteralInteger)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralInteger(coreAbstractionsLiteralsLiteralInteger);
				if (result == null) result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralInteger);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralInteger);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralInteger);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralInteger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_STRING: {
				CoreAbstractionsLiteralsLiteralString coreAbstractionsLiteralsLiteralString = (CoreAbstractionsLiteralsLiteralString)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralString(coreAbstractionsLiteralsLiteralString);
				if (result == null) result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralString);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralString);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralString);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_BOOLEAN: {
				CoreAbstractionsLiteralsLiteralBoolean coreAbstractionsLiteralsLiteralBoolean = (CoreAbstractionsLiteralsLiteralBoolean)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralBoolean(coreAbstractionsLiteralsLiteralBoolean);
				if (result == null) result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralBoolean);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralBoolean);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralBoolean);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_NULL: {
				CoreAbstractionsLiteralsLiteralNull coreAbstractionsLiteralsLiteralNull = (CoreAbstractionsLiteralsLiteralNull)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralNull(coreAbstractionsLiteralsLiteralNull);
				if (result == null) result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralNull);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralNull);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralNull);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_SPECIFICATION: {
				CoreAbstractionsLiteralsLiteralSpecification coreAbstractionsLiteralsLiteralSpecification = (CoreAbstractionsLiteralsLiteralSpecification)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralSpecification);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralSpecification);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralSpecification);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_LITERALS_LITERAL_UNLIMITED_NATURAL: {
				CoreAbstractionsLiteralsLiteralUnlimitedNatural coreAbstractionsLiteralsLiteralUnlimitedNatural = (CoreAbstractionsLiteralsLiteralUnlimitedNatural)theEObject;
				T result = caseCoreAbstractionsLiteralsLiteralUnlimitedNatural(coreAbstractionsLiteralsLiteralUnlimitedNatural);
				if (result == null) result = caseCoreAbstractionsLiteralsLiteralSpecification(coreAbstractionsLiteralsLiteralUnlimitedNatural);
				if (result == null) result = caseCoreAbstractionsExpressionsValueSpecification(coreAbstractionsLiteralsLiteralUnlimitedNatural);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsLiteralsLiteralUnlimitedNatural);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsLiteralsLiteralUnlimitedNatural);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT: {
				CoreAbstractionsRedefinitionsRedefinableElement coreAbstractionsRedefinitionsRedefinableElement = (CoreAbstractionsRedefinitionsRedefinableElement)theEObject;
				T result = caseCoreAbstractionsRedefinitionsRedefinableElement(coreAbstractionsRedefinitionsRedefinableElement);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsRedefinitionsRedefinableElement);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsRedefinitionsRedefinableElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsRedefinitionsRedefinableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_CHANGEABILITIES_STRUCTURAL_FEATURE: {
				CoreAbstractionsChangeabilitiesStructuralFeature coreAbstractionsChangeabilitiesStructuralFeature = (CoreAbstractionsChangeabilitiesStructuralFeature)theEObject;
				T result = caseCoreAbstractionsChangeabilitiesStructuralFeature(coreAbstractionsChangeabilitiesStructuralFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT: {
				CoreAbstractionsMultiplicitiesMultiplicityElement coreAbstractionsMultiplicitiesMultiplicityElement = (CoreAbstractionsMultiplicitiesMultiplicityElement)theEObject;
				T result = caseCoreAbstractionsMultiplicitiesMultiplicityElement(coreAbstractionsMultiplicitiesMultiplicityElement);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsMultiplicitiesMultiplicityElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION: {
				CoreAbstractionsGeneralizationsGeneralization coreAbstractionsGeneralizationsGeneralization = (CoreAbstractionsGeneralizationsGeneralization)theEObject;
				T result = caseCoreAbstractionsGeneralizationsGeneralization(coreAbstractionsGeneralizationsGeneralization);
				if (result == null) result = caseCoreAbstractionsRelationshipsDirectedRelationship(coreAbstractionsGeneralizationsGeneralization);
				if (result == null) result = caseCoreAbstractionsRelationshipsRelationship(coreAbstractionsGeneralizationsGeneralization);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsGeneralizationsGeneralization);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsGeneralizationsGeneralization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER: {
				CoreAbstractionsGeneralizationsClassifier coreAbstractionsGeneralizationsClassifier = (CoreAbstractionsGeneralizationsClassifier)theEObject;
				T result = caseCoreAbstractionsGeneralizationsClassifier(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsClassifiersClassifier(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsNamespacesNamespace(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsGeneralizationsClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP: {
				CoreAbstractionsRelationshipsRelationship coreAbstractionsRelationshipsRelationship = (CoreAbstractionsRelationshipsRelationship)theEObject;
				T result = caseCoreAbstractionsRelationshipsRelationship(coreAbstractionsRelationshipsRelationship);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsRelationshipsRelationship);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsRelationshipsRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP: {
				CoreAbstractionsRelationshipsDirectedRelationship coreAbstractionsRelationshipsDirectedRelationship = (CoreAbstractionsRelationshipsDirectedRelationship)theEObject;
				T result = caseCoreAbstractionsRelationshipsDirectedRelationship(coreAbstractionsRelationshipsDirectedRelationship);
				if (result == null) result = caseCoreAbstractionsRelationshipsRelationship(coreAbstractionsRelationshipsDirectedRelationship);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(coreAbstractionsRelationshipsDirectedRelationship);
				if (result == null) result = caseCoreAbstractionsElementsElement(coreAbstractionsRelationshipsDirectedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.INSTANCIATION_INSTANCE: {
				InstanciationInstance instanciationInstance = (InstanciationInstance)theEObject;
				T result = caseInstanciationInstance(instanciationInstance);
				if (result == null) result = caseCoreAbstractionsElementsElement(instanciationInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.INSTANCIATION_SLOT: {
				InstanciationSlot instanciationSlot = (InstanciationSlot)theEObject;
				T result = caseInstanciationSlot(instanciationSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.INSTANCIATION_VALUE: {
				InstanciationValue instanciationValue = (InstanciationValue)theEObject;
				T result = caseInstanciationValue(instanciationValue);
				if (result == null) result = caseCoreAbstractionsElementsElement(instanciationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.INSTANCIATION_CREATE: {
				InstanciationCreate instanciationCreate = (InstanciationCreate)theEObject;
				T result = caseInstanciationCreate(instanciationCreate);
				if (result == null) result = caseCoreAbstractionsElementsElement(instanciationCreate);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(instanciationCreate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.INSTANCIATION_MULTIPLICITY_FEATURE: {
				InstanciationMultiplicityFeature instanciationMultiplicityFeature = (InstanciationMultiplicityFeature)theEObject;
				T result = caseInstanciationMultiplicityFeature(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsStructuralFeaturesStructuralFeature(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsMultiplicitiesMultiplicityElement(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsElementsElement(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(instanciationMultiplicityFeature);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(instanciationMultiplicityFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_DATA_TYPE: {
				EvaluationDataType evaluationDataType = (EvaluationDataType)theEObject;
				T result = caseEvaluationDataType(evaluationDataType);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(evaluationDataType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(evaluationDataType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationDataType);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_EXPRESSION: {
				EvaluationExpression evaluationExpression = (EvaluationExpression)theEObject;
				T result = caseEvaluationExpression(evaluationExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(evaluationExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(evaluationExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_LITERAL_EXPRESSION: {
				EvaluationLiteralExpression evaluationLiteralExpression = (EvaluationLiteralExpression)theEObject;
				T result = caseEvaluationLiteralExpression(evaluationLiteralExpression);
				if (result == null) result = caseEvaluationExpression(evaluationLiteralExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationLiteralExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(evaluationLiteralExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(evaluationLiteralExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION: {
				EvaluationFeatureAccessExpression evaluationFeatureAccessExpression = (EvaluationFeatureAccessExpression)theEObject;
				T result = caseEvaluationFeatureAccessExpression(evaluationFeatureAccessExpression);
				if (result == null) result = caseEvaluationExpression(evaluationFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(evaluationFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(evaluationFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationFeatureAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_LITERAL: {
				EvaluationLiteral evaluationLiteral = (EvaluationLiteral)theEObject;
				T result = caseEvaluationLiteral(evaluationLiteral);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationLiteral);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_EVALUATION: {
				EvaluationEvaluation evaluationEvaluation = (EvaluationEvaluation)theEObject;
				T result = caseEvaluationEvaluation(evaluationEvaluation);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationEvaluation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION: {
				EvaluationBehavioralFeatureAccessExpression evaluationBehavioralFeatureAccessExpression = (EvaluationBehavioralFeatureAccessExpression)theEObject;
				T result = caseEvaluationBehavioralFeatureAccessExpression(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseEvaluationBehavioralFeatureAccess(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseEvaluationFeatureAccessExpression(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseEvaluationExpression(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsElementsElement(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(evaluationBehavioralFeatureAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS: {
				EvaluationBehavioralFeatureAccess evaluationBehavioralFeatureAccess = (EvaluationBehavioralFeatureAccess)theEObject;
				T result = caseEvaluationBehavioralFeatureAccess(evaluationBehavioralFeatureAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_PROCESS: {
				CommunicationProcess communicationProcess = (CommunicationProcess)theEObject;
				T result = caseCommunicationProcess(communicationProcess);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_EVENT_TYPE: {
				CommunicationEventType communicationEventType = (CommunicationEventType)theEObject;
				T result = caseCommunicationEventType(communicationEventType);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationEventType);
				if (result == null) result = caseCoreAbstractionsTypedElementsType(communicationEventType);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(communicationEventType);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(communicationEventType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_CONTEXT: {
				CommunicationContext communicationContext = (CommunicationContext)theEObject;
				T result = caseCommunicationContext(communicationContext);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_LISTENER: {
				CommunicationListener communicationListener = (CommunicationListener)theEObject;
				T result = caseCommunicationListener(communicationListener);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_EVENT: {
				CommunicationEvent communicationEvent = (CommunicationEvent)theEObject;
				T result = caseCommunicationEvent(communicationEvent);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationEvent);
				if (result == null) result = caseInstanciationValue(communicationEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_INPUT: {
				CommunicationInput communicationInput = (CommunicationInput)theEObject;
				T result = caseCommunicationInput(communicationInput);
				if (result == null) result = caseCoreAbstractionsClassifiersFeature(communicationInput);
				if (result == null) result = caseCoreAbstractionsTypedElementsTypedElement(communicationInput);
				if (result == null) result = caseCoreAbstractionsNamespacesNamedElement(communicationInput);
				if (result == null) result = caseCoreAbstractionsOwnershipsElement(communicationInput);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_MEDIUM: {
				CommunicationMedium communicationMedium = (CommunicationMedium)theEObject;
				T result = caseCommunicationMedium(communicationMedium);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationMedium);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.COMMUNICATION_COMMUNICATOR: {
				CommunicationCommunicator communicationCommunicator = (CommunicationCommunicator)theEObject;
				T result = caseCommunicationCommunicator(communicationCommunicator);
				if (result == null) result = caseCoreAbstractionsElementsElement(communicationCommunicator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmfSdlPackage.SDL_SPECIFICATION: {
				SdlSpecification sdlSpecification = (SdlSpecification)theEObject;
				T result = caseSdlSpecification(sdlSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlCreate(SdlCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAssignment(SdlAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Reset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Reset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlReset(SdlReset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlOutput(SdlOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Signal Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Signal Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlSignalInstance(SdlSignalInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlSet(SdlSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Agent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Agent Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAgentInstance(SdlAgentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Data Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlDataValue(SdlDataValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Agent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Agent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAgent(SdlAgent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlProcedure(SdlProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Agent Instance Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Agent Instance Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAgentInstanceSet(SdlAgentInstanceSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlVariable(SdlVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Agent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Agent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAgentType(SdlAgentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlDataType(SdlDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Variable Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Variable Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlVariableSlot(SdlVariableSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlChannel(SdlChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Channel End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Channel End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlChannelEnd(SdlChannelEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Channel Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Channel Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlChannelPath(SdlChannelPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Gate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Gate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlGate(SdlGate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Signal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlSignal(SdlSignal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Timer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Timer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlTimer(SdlTimer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlTrigger(SdlTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Input Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Input Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlInputInstance(SdlInputInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Variable Access Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Variable Access Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlVariableAccessEvaluation(SdlVariableAccessEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Variable Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlVariableAccess(SdlVariableAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Procedure Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Procedure Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlProcedureFrame(SdlProcedureFrame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Open Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Open Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlOpenRange(SdlOpenRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Timer Active Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Timer Active Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlTimerActiveExpression(SdlTimerActiveExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlOperation(SdlOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlRange(SdlRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Procedure Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Procedure Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlProcedureCall(SdlProcedureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlLiteralExpression(SdlLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Now Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Now Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlNowExpression(SdlNowExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Pid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Pid Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlPidExpression(SdlPidExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Range Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Range Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlRangeCondition(SdlRangeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Operation Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Operation Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlOperationCall(SdlOperationCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlLiteral(SdlLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Closed Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Closed Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlClosedRange(SdlClosedRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlParameter(SdlParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlPackage(SdlPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoin(Join object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistory(History object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturn(Return object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFork(Fork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Behavior Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Behavior Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlBehaviorElement(SdlBehaviorElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Abstract State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Abstract State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAbstractState(SdlAbstractState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlAction(SdlAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlChoice(SdlChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlBehavior(SdlBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Composite State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlCompositeState(SdlCompositeState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlElse(SdlElse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Composite State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Composite State Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlCompositeStateInstance(SdlCompositeStateInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Pseudo State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Pseudo State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlPseudoState(SdlPseudoState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlInput(SdlInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Imidiate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Imidiate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlImidiate(SdlImidiate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStateInstance(SdlStateInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStateNode(SdlStateNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Partition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Partition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStatePartitionInstance(SdlStatePartitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Automaton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Automaton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStateAutomaton(SdlStateAutomaton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlState(SdlState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStatePartition(SdlStatePartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlTransition(SdlTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl State Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl State Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlStateType(SdlStateType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlSplit(SdlSplit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStart(Start object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStop(Stop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlClassifier(SdlClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlNamespace(SdlNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Named State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Named State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlNamedState(SdlNamedState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlInstance(SdlInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Operation Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Operation Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlOperationEvaluation(SdlOperationEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlEvaluation(SdlEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Literal Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Literal Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlLiteralEvaluation(SdlLiteralEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Primitive Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Primitive Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlPrimitiveValue(SdlPrimitiveValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Pid Expression Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Pid Expression Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlPidExpressionEvaluation(SdlPidExpressionEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pid Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pid Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePidValue(PidValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl General Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl General Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlGeneralValue(SdlGeneralValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Qualifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Qualifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteSyntaxSdlQualifier(ConcreteSyntaxSdlQualifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Path Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Path Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteSyntaxSdlPathItem(ConcreteSyntaxSdlPathItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Syntax Sdl Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteSyntaxSdlIdentifier(ConcreteSyntaxSdlIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Typed Elements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Typed Elements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsTypedElementsType(CoreAbstractionsTypedElementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Typed Elements Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Typed Elements Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsTypedElementsTypedElement(CoreAbstractionsTypedElementsTypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Behavioral Features Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Behavioral Features Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsBehavioralFeaturesParameter(CoreAbstractionsBehavioralFeaturesParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Behavioral Features Behavioral Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Behavioral Features Behavioral Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsBehavioralFeaturesBehavioralFeature(CoreAbstractionsBehavioralFeaturesBehavioralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Structural Features Structural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Structural Features Structural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsStructuralFeaturesStructuralFeature(CoreAbstractionsStructuralFeaturesStructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Comments Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Comments Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsCommentsComment(CoreAbstractionsCommentsComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Ownerships Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Ownerships Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsOwnershipsElement(CoreAbstractionsOwnershipsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Instances Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Instances Instance Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsInstancesInstanceSpecification(CoreAbstractionsInstancesInstanceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Instances Instance Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Instances Instance Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsInstancesInstanceValue(CoreAbstractionsInstancesInstanceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Instances Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Instances Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsInstancesSlot(CoreAbstractionsInstancesSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Elements Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Elements Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsElementsElement(CoreAbstractionsElementsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Visibilities Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Visibilities Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsVisibilitiesNamedElement(CoreAbstractionsVisibilitiesNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsConstraintsNamedElement(CoreAbstractionsConstraintsNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsConstraintsNamespace(CoreAbstractionsConstraintsNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Constraints Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsConstraintsConstraint(CoreAbstractionsConstraintsConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Namespaces Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Namespaces Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsNamespacesNamedElement(CoreAbstractionsNamespacesNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Namespaces Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Namespaces Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsNamespacesNamespace(CoreAbstractionsNamespacesNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Super Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Super Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsSuperClassifier(CoreAbstractionsSuperClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Classifiers Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Classifiers Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsClassifiersFeature(CoreAbstractionsClassifiersFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Classifiers Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Classifiers Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsClassifiersClassifier(CoreAbstractionsClassifiersClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsExpressionsExpression(CoreAbstractionsExpressionsExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsExpressionsValueSpecification(CoreAbstractionsExpressionsValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Expressions Opaque Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsExpressionsOpaqueExpression(CoreAbstractionsExpressionsOpaqueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Multiplicity Expressions Multiplicity Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsMultiplicityExpressionsMultiplicityElement(CoreAbstractionsMultiplicityExpressionsMultiplicityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralInteger(CoreAbstractionsLiteralsLiteralInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralString(CoreAbstractionsLiteralsLiteralString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralBoolean(CoreAbstractionsLiteralsLiteralBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Null</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Null</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralNull(CoreAbstractionsLiteralsLiteralNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralSpecification(CoreAbstractionsLiteralsLiteralSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Unlimited Natural</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Literals Literal Unlimited Natural</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsLiteralsLiteralUnlimitedNatural(CoreAbstractionsLiteralsLiteralUnlimitedNatural object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Redefinitions Redefinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Redefinitions Redefinable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsRedefinitionsRedefinableElement(CoreAbstractionsRedefinitionsRedefinableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Changeabilities Structural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Changeabilities Structural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsChangeabilitiesStructuralFeature(CoreAbstractionsChangeabilitiesStructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Multiplicities Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Multiplicities Multiplicity Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsMultiplicitiesMultiplicityElement(CoreAbstractionsMultiplicitiesMultiplicityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Generalizations Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Generalizations Generalization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsGeneralizationsGeneralization(CoreAbstractionsGeneralizationsGeneralization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Generalizations Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Generalizations Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsGeneralizationsClassifier(CoreAbstractionsGeneralizationsClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Relationships Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Relationships Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsRelationshipsRelationship(CoreAbstractionsRelationshipsRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Abstractions Relationships Directed Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Abstractions Relationships Directed Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreAbstractionsRelationshipsDirectedRelationship(CoreAbstractionsRelationshipsDirectedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciation Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciation Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciationInstance(InstanciationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciation Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciation Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciationSlot(InstanciationSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciationValue(InstanciationValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciation Create</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciation Create</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciationCreate(InstanciationCreate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciation Multiplicity Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciation Multiplicity Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciationMultiplicityFeature(InstanciationMultiplicityFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationDataType(EvaluationDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationExpression(EvaluationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationLiteralExpression(EvaluationLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Feature Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Feature Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationFeatureAccessExpression(EvaluationFeatureAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationLiteral(EvaluationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationEvaluation(EvaluationEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Behavioral Feature Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Behavioral Feature Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationBehavioralFeatureAccessExpression(EvaluationBehavioralFeatureAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Behavioral Feature Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Behavioral Feature Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationBehavioralFeatureAccess(EvaluationBehavioralFeatureAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationProcess(CommunicationProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Event Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Event Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationEventType(CommunicationEventType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationContext(CommunicationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationListener(CommunicationListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationEvent(CommunicationEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationInput(CommunicationInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Medium</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Medium</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationMedium(CommunicationMedium object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Communicator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Communicator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationCommunicator(CommunicationCommunicator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sdl Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sdl Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSdlSpecification(SdlSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EmfSdlSwitch
