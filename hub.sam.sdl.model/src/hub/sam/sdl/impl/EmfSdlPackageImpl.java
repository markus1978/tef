/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfSdlPackageImpl extends EPackageImpl implements EmfSdlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "sdl.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlResetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlSignalInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAgentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlDataValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAgentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlProcedureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAgentInstanceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAgentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlVariableSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlChannelEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlChannelPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlGateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlSignalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlTimerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlInputInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlVariableAccessEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlVariableAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlProcedureFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlOpenRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlTimerActiveExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlProcedureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlNowExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlPidExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlRangeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlOperationCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlClosedRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlBehaviorElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlAbstractStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlCompositeStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlElseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlCompositeStateInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlPseudoStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlImidiateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStateInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStateNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStatePartitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStateAutomatonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStatePartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlStateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlSplitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlNamedStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlOperationEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlLiteralEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlPrimitiveValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlPidExpressionEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pidValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlGeneralValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteSyntaxSdlQualifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteSyntaxSdlPathItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteSyntaxSdlIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsTypedElementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsTypedElementsTypedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsBehavioralFeaturesParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsBehavioralFeaturesBehavioralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsStructuralFeaturesStructuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsCommentsCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsOwnershipsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsInstancesInstanceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsInstancesInstanceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsInstancesSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsElementsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsVisibilitiesNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsConstraintsNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsConstraintsNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsConstraintsConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsNamespacesNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsNamespacesNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsSuperClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsClassifiersFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsClassifiersClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsExpressionsExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsExpressionsValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsExpressionsOpaqueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsMultiplicityExpressionsMultiplicityElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsLiteralsLiteralUnlimitedNaturalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsRedefinitionsRedefinableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsChangeabilitiesStructuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsMultiplicitiesMultiplicityElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsGeneralizationsGeneralizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsGeneralizationsClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsRelationshipsRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreAbstractionsRelationshipsDirectedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciationSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciationCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanciationMultiplicityFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationFeatureAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationBehavioralFeatureAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationBehavioralFeatureAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationEventTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationMediumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationCommunicatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sdlSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdlAgentKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdlParameterKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdlPidExpressionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdlStateStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum concreteSyntaxSdlScopeUnitKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum coreAbstractionsVisibilitiesVisibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType primitiveTypesUnlimitedNaturalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType primitiveTypesStringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType primitiveTypesBooleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType primitiveTypesIntegerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType primitiveTypesObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hub.sam.sdl.EmfSdlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmfSdlPackageImpl() {
		super(eNS_URI, EmfSdlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static EmfSdlPackage init() {
		if (isInited) return (EmfSdlPackage)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI);

		// Obtain or create and register package
		EmfSdlPackageImpl theEmfSdlPackage = (EmfSdlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EmfSdlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EmfSdlPackageImpl());

		isInited = true;

		// Load packages
		theEmfSdlPackage.loadPackage();

		// Fix loaded packages
		theEmfSdlPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmfSdlPackage.freeze();

		return theEmfSdlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlCreate() {
		if (sdlCreateEClass == null) {
			sdlCreateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(0);
		}
		return sdlCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCreate_Agent() {
        return (EReference)getSdlCreate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAssignment() {
		if (sdlAssignmentEClass == null) {
			sdlAssignmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(1);
		}
		return sdlAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAssignment_Expression() {
        return (EReference)getSdlAssignment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAssignment_Variable() {
        return (EReference)getSdlAssignment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlReset() {
		if (sdlResetEClass == null) {
			sdlResetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(2);
		}
		return sdlResetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlOutput() {
		if (sdlOutputEClass == null) {
			sdlOutputEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(3);
		}
		return sdlOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlOutput_Via() {
        return (EReference)getSdlOutput().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlOutput_Type() {
        return (EReference)getSdlOutput().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlOutput_To() {
        return (EReference)getSdlOutput().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlSignalInstance() {
		if (sdlSignalInstanceEClass == null) {
			sdlSignalInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(4);
		}
		return sdlSignalInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSignalInstance_Parameter() {
        return (EReference)getSdlSignalInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSignalInstance_Sender() {
        return (EReference)getSdlSignalInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSignalInstance_Receiver() {
        return (EReference)getSdlSignalInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlSet() {
		if (sdlSetEClass == null) {
			sdlSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(5);
		}
		return sdlSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSet_Expression() {
        return (EReference)getSdlSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAgentInstance() {
		if (sdlAgentInstanceEClass == null) {
			sdlAgentInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(6);
		}
		return sdlAgentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstance_AgentInstanceSet() {
        return (EReference)getSdlAgentInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstance_Behavior() {
        return (EReference)getSdlAgentInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstance_OwningInstanceSet() {
        return (EReference)getSdlAgentInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstance_Parent() {
        return (EReference)getSdlAgentInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstance_Offspring() {
        return (EReference)getSdlAgentInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlDataValue() {
		if (sdlDataValueEClass == null) {
			sdlDataValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(7);
		}
		return sdlDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAgent() {
		if (sdlAgentEClass == null) {
			sdlAgentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(8);
		}
		return sdlAgentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlProcedure() {
		if (sdlProcedureEClass == null) {
			sdlProcedureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(10);
		}
		return sdlProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlProcedure_ProcedureStateAutomaton() {
        return (EReference)getSdlProcedure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAgentInstanceSet() {
		if (sdlAgentInstanceSetEClass == null) {
			sdlAgentInstanceSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(11);
		}
		return sdlAgentInstanceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstanceSet_InputQueue() {
        return (EReference)getSdlAgentInstanceSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentInstanceSet_AgentInstance() {
        return (EReference)getSdlAgentInstanceSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlVariable() {
		if (sdlVariableEClass == null) {
			sdlVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(12);
		}
		return sdlVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlVariable_InitExpression() {
        return (EReference)getSdlVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAgentType() {
		if (sdlAgentTypeEClass == null) {
			sdlAgentTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(13);
		}
		return sdlAgentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentType_Agent() {
        return (EReference)getSdlAgentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlAgentType_Kind() {
        return (EAttribute)getSdlAgentType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentType_OwnedAgentType() {
        return (EReference)getSdlAgentType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentType_Channel() {
        return (EReference)getSdlAgentType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAgentType_Gate() {
        return (EReference)getSdlAgentType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlDataType() {
		if (sdlDataTypeEClass == null) {
			sdlDataTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(14);
		}
		return sdlDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlDataType_Operation() {
        return (EReference)getSdlDataType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlVariableSlot() {
		if (sdlVariableSlotEClass == null) {
			sdlVariableSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(15);
		}
		return sdlVariableSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlChannel() {
		if (sdlChannelEClass == null) {
			sdlChannelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(16);
		}
		return sdlChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannel_Path() {
        return (EReference)getSdlChannel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannel_AgentType() {
        return (EReference)getSdlChannel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlChannelEnd() {
		if (sdlChannelEndEClass == null) {
			sdlChannelEndEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(17);
		}
		return sdlChannelEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelEnd_Agent() {
        return (EReference)getSdlChannelEnd().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelEnd_Gate() {
        return (EReference)getSdlChannelEnd().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelEnd_Opposite() {
        return (EReference)getSdlChannelEnd().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelEnd_Channel() {
        return (EReference)getSdlChannelEnd().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlChannelPath() {
		if (sdlChannelPathEClass == null) {
			sdlChannelPathEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(18);
		}
		return sdlChannelPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelPath_Signal() {
        return (EReference)getSdlChannelPath().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChannelPath_Channel() {
        return (EReference)getSdlChannelPath().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlGate() {
		if (sdlGateEClass == null) {
			sdlGateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(19);
		}
		return sdlGateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlGate_Receive() {
        return (EReference)getSdlGate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlGate_Send() {
        return (EReference)getSdlGate().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlGate_ChannelEnd() {
        return (EReference)getSdlGate().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlGate_AgentType() {
        return (EReference)getSdlGate().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlSignal() {
		if (sdlSignalEClass == null) {
			sdlSignalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(20);
		}
		return sdlSignalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlTimer() {
		if (sdlTimerEClass == null) {
			sdlTimerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(21);
		}
		return sdlTimerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlTrigger() {
		if (sdlTriggerEClass == null) {
			sdlTriggerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(22);
		}
		return sdlTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlTrigger_Transition() {
        return (EReference)getSdlTrigger().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlInputInstance() {
		if (sdlInputInstanceEClass == null) {
			sdlInputInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(23);
		}
		return sdlInputInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlInputInstance_OwningStateInstance() {
        return (EReference)getSdlInputInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlVariableAccessEvaluation() {
		if (sdlVariableAccessEvaluationEClass == null) {
			sdlVariableAccessEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(24);
		}
		return sdlVariableAccessEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlVariableAccess() {
		if (sdlVariableAccessEClass == null) {
			sdlVariableAccessEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(25);
		}
		return sdlVariableAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlProcedureFrame() {
		if (sdlProcedureFrameEClass == null) {
			sdlProcedureFrameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(26);
		}
		return sdlProcedureFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlOpenRange() {
		if (sdlOpenRangeEClass == null) {
			sdlOpenRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(27);
		}
		return sdlOpenRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlOpenRange_Operation() {
        return (EReference)getSdlOpenRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlOpenRange_Expression() {
        return (EReference)getSdlOpenRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlTimerActiveExpression() {
		if (sdlTimerActiveExpressionEClass == null) {
			sdlTimerActiveExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(28);
		}
		return sdlTimerActiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlOperation() {
		if (sdlOperationEClass == null) {
			sdlOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(29);
		}
		return sdlOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlRange() {
		if (sdlRangeEClass == null) {
			sdlRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(30);
		}
		return sdlRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlProcedureCall() {
		if (sdlProcedureCallEClass == null) {
			sdlProcedureCallEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(31);
		}
		return sdlProcedureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlProcedureCall_Procedure() {
        return (EReference)getSdlProcedureCall().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlLiteralExpression() {
		if (sdlLiteralExpressionEClass == null) {
			sdlLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(33);
		}
		return sdlLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlLiteralExpression_Value() {
        return (EAttribute)getSdlLiteralExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlNowExpression() {
		if (sdlNowExpressionEClass == null) {
			sdlNowExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(34);
		}
		return sdlNowExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlPidExpression() {
		if (sdlPidExpressionEClass == null) {
			sdlPidExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(35);
		}
		return sdlPidExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlPidExpression_Kind() {
        return (EAttribute)getSdlPidExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlRangeCondition() {
		if (sdlRangeConditionEClass == null) {
			sdlRangeConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(36);
		}
		return sdlRangeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlOperationCall() {
		if (sdlOperationCallEClass == null) {
			sdlOperationCallEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(37);
		}
		return sdlOperationCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlLiteral() {
		if (sdlLiteralEClass == null) {
			sdlLiteralEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(38);
		}
		return sdlLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlClosedRange() {
		if (sdlClosedRangeEClass == null) {
			sdlClosedRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(39);
		}
		return sdlClosedRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlClosedRange_Upper() {
        return (EReference)getSdlClosedRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlClosedRange_Lower() {
        return (EReference)getSdlClosedRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlParameter() {
		if (sdlParameterEClass == null) {
			sdlParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(40);
		}
		return sdlParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlParameter_Kind() {
        return (EAttribute)getSdlParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlPackage() {
		if (sdlPackageEClass == null) {
			sdlPackageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(42);
		}
		return sdlPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlPackage_NestedPackage() {
        return (EReference)getSdlPackage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnector() {
		if (connectorEClass == null) {
			connectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(43);
		}
		return connectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoin() {
		if (joinEClass == null) {
			joinEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(44);
		}
		return joinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistory() {
		if (historyEClass == null) {
			historyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(45);
		}
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturn() {
		if (returnEClass == null) {
			returnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(46);
		}
		return returnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturn_Expression() {
        return (EReference)getReturn().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFork() {
		if (forkEClass == null) {
			forkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(47);
		}
		return forkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlBehaviorElement() {
		if (sdlBehaviorElementEClass == null) {
			sdlBehaviorElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(48);
		}
		return sdlBehaviorElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlBehaviorElement_Behavior() {
        return (EReference)getSdlBehaviorElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAbstractState() {
		if (sdlAbstractStateEClass == null) {
			sdlAbstractStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(49);
		}
		return sdlAbstractStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlAbstractState_Trigger() {
        return (EReference)getSdlAbstractState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlAction() {
		if (sdlActionEClass == null) {
			sdlActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(50);
		}
		return sdlActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlChoice() {
		if (sdlChoiceEClass == null) {
			sdlChoiceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(51);
		}
		return sdlChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlChoice_Condition() {
        return (EReference)getSdlChoice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlBehavior() {
		if (sdlBehaviorEClass == null) {
			sdlBehaviorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(52);
		}
		return sdlBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlCompositeState() {
		if (sdlCompositeStateEClass == null) {
			sdlCompositeStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(53);
		}
		return sdlCompositeStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlElse() {
		if (sdlElseEClass == null) {
			sdlElseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(54);
		}
		return sdlElseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlCompositeStateInstance() {
		if (sdlCompositeStateInstanceEClass == null) {
			sdlCompositeStateInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(55);
		}
		return sdlCompositeStateInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCompositeStateInstance_ActualState() {
        return (EReference)getSdlCompositeStateInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCompositeStateInstance_State() {
        return (EReference)getSdlCompositeStateInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCompositeStateInstance_OwningInstance() {
        return (EReference)getSdlCompositeStateInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCompositeStateInstance_Triggered() {
        return (EReference)getSdlCompositeStateInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlCompositeStateInstance_Sender() {
        return (EReference)getSdlCompositeStateInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlCompositeStateInstance_Status() {
        return (EAttribute)getSdlCompositeStateInstance().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlPseudoState() {
		if (sdlPseudoStateEClass == null) {
			sdlPseudoStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(56);
		}
		return sdlPseudoStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlInput() {
		if (sdlInputEClass == null) {
			sdlInputEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(57);
		}
		return sdlInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlInput_Parameter() {
        return (EReference)getSdlInput().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlInput_Signal() {
        return (EReference)getSdlInput().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlImidiate() {
		if (sdlImidiateEClass == null) {
			sdlImidiateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(58);
		}
		return sdlImidiateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStateInstance() {
		if (sdlStateInstanceEClass == null) {
			sdlStateInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(59);
		}
		return sdlStateInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateInstance_ActualState() {
        return (EReference)getSdlStateInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStateNode() {
		if (sdlStateNodeEClass == null) {
			sdlStateNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(60);
		}
		return sdlStateNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateNode_State() {
        return (EReference)getSdlStateNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStatePartitionInstance() {
		if (sdlStatePartitionInstanceEClass == null) {
			sdlStatePartitionInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(61);
		}
		return sdlStatePartitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStateAutomaton() {
		if (sdlStateAutomatonEClass == null) {
			sdlStateAutomatonEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(62);
		}
		return sdlStateAutomatonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateAutomaton_State() {
        return (EReference)getSdlStateAutomaton().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateAutomaton_Transition() {
        return (EReference)getSdlStateAutomaton().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateAutomaton_NamedState() {
        return (EReference)getSdlStateAutomaton().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateAutomaton_Start() {
        return (EReference)getSdlStateAutomaton().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlState() {
		if (sdlStateEClass == null) {
			sdlStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(63);
		}
		return sdlStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlState_Entry() {
        return (EReference)getSdlState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlState_Exit() {
        return (EReference)getSdlState().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStatePartition() {
		if (sdlStatePartitionEClass == null) {
			sdlStatePartitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(64);
		}
		return sdlStatePartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStatePartition_Partition() {
        return (EReference)getSdlStatePartition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlTransition() {
		if (sdlTransitionEClass == null) {
			sdlTransitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(65);
		}
		return sdlTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlTransition_Action() {
        return (EReference)getSdlTransition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlTransition_Source() {
        return (EReference)getSdlTransition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlTransition_Target() {
        return (EReference)getSdlTransition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlTransition_Trigger() {
        return (EReference)getSdlTransition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlStateType() {
		if (sdlStateTypeEClass == null) {
			sdlStateTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(66);
		}
		return sdlStateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateType_StateAutomaton() {
        return (EReference)getSdlStateType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlStateType_State() {
        return (EReference)getSdlStateType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlSplit() {
		if (sdlSplitEClass == null) {
			sdlSplitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(67);
		}
		return sdlSplitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSplit_Question() {
        return (EReference)getSdlSplit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSplit_Answer() {
        return (EReference)getSdlSplit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStart() {
		if (startEClass == null) {
			startEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(68);
		}
		return startEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStop() {
		if (stopEClass == null) {
			stopEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(69);
		}
		return stopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlClassifier() {
		if (sdlClassifierEClass == null) {
			sdlClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(70);
		}
		return sdlClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlClassifier_Variable() {
        return (EReference)getSdlClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlClassifier_Procedure() {
        return (EReference)getSdlClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlNamespace() {
		if (sdlNamespaceEClass == null) {
			sdlNamespaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(71);
		}
		return sdlNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlNamespace_OwnedType() {
        return (EReference)getSdlNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlNamedState() {
		if (sdlNamedStateEClass == null) {
			sdlNamedStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(72);
		}
		return sdlNamedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlInstance() {
		if (sdlInstanceEClass == null) {
			sdlInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(73);
		}
		return sdlInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlInstance_Variable() {
        return (EReference)getSdlInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlInstance_ContainingInstance() {
        return (EReference)getSdlInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlOperationEvaluation() {
		if (sdlOperationEvaluationEClass == null) {
			sdlOperationEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(74);
		}
		return sdlOperationEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlEvaluation() {
		if (sdlEvaluationEClass == null) {
			sdlEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(75);
		}
		return sdlEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlEvaluation_Context() {
        return (EReference)getSdlEvaluation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlLiteralEvaluation() {
		if (sdlLiteralEvaluationEClass == null) {
			sdlLiteralEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(76);
		}
		return sdlLiteralEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlPrimitiveValue() {
		if (sdlPrimitiveValueEClass == null) {
			sdlPrimitiveValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(77);
		}
		return sdlPrimitiveValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlPidExpressionEvaluation() {
		if (sdlPidExpressionEvaluationEClass == null) {
			sdlPidExpressionEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(78);
		}
		return sdlPidExpressionEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPidValue() {
		if (pidValueEClass == null) {
			pidValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(79);
		}
		return pidValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPidValue_Value() {
        return (EReference)getPidValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlGeneralValue() {
		if (sdlGeneralValueEClass == null) {
			sdlGeneralValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(80);
		}
		return sdlGeneralValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSdlGeneralValue_Value() {
        return (EAttribute)getSdlGeneralValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteSyntaxSdlQualifier() {
		if (concreteSyntaxSdlQualifierEClass == null) {
			concreteSyntaxSdlQualifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(82);
		}
		return concreteSyntaxSdlQualifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntaxSdlQualifier_PathItem() {
        return (EReference)getConcreteSyntaxSdlQualifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteSyntaxSdlPathItem() {
		if (concreteSyntaxSdlPathItemEClass == null) {
			concreteSyntaxSdlPathItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(83);
		}
		return concreteSyntaxSdlPathItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntaxSdlPathItem_Kind() {
        return (EAttribute)getConcreteSyntaxSdlPathItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntaxSdlPathItem_Name() {
        return (EAttribute)getConcreteSyntaxSdlPathItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteSyntaxSdlIdentifier() {
		if (concreteSyntaxSdlIdentifierEClass == null) {
			concreteSyntaxSdlIdentifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(84);
		}
		return concreteSyntaxSdlIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntaxSdlIdentifier_Name() {
        return (EAttribute)getConcreteSyntaxSdlIdentifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntaxSdlIdentifier_Qualifier() {
        return (EReference)getConcreteSyntaxSdlIdentifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsTypedElementsType() {
		if (coreAbstractionsTypedElementsTypeEClass == null) {
			coreAbstractionsTypedElementsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(86);
		}
		return coreAbstractionsTypedElementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsTypedElementsTypedElement() {
		if (coreAbstractionsTypedElementsTypedElementEClass == null) {
			coreAbstractionsTypedElementsTypedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(87);
		}
		return coreAbstractionsTypedElementsTypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsTypedElementsTypedElement_Type() {
        return (EReference)getCoreAbstractionsTypedElementsTypedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsBehavioralFeaturesParameter() {
		if (coreAbstractionsBehavioralFeaturesParameterEClass == null) {
			coreAbstractionsBehavioralFeaturesParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(88);
		}
		return coreAbstractionsBehavioralFeaturesParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsBehavioralFeaturesBehavioralFeature() {
		if (coreAbstractionsBehavioralFeaturesBehavioralFeatureEClass == null) {
			coreAbstractionsBehavioralFeaturesBehavioralFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(89);
		}
		return coreAbstractionsBehavioralFeaturesBehavioralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsBehavioralFeaturesBehavioralFeature_Parameter() {
        return (EReference)getCoreAbstractionsBehavioralFeaturesBehavioralFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsStructuralFeaturesStructuralFeature() {
		if (coreAbstractionsStructuralFeaturesStructuralFeatureEClass == null) {
			coreAbstractionsStructuralFeaturesStructuralFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(90);
		}
		return coreAbstractionsStructuralFeaturesStructuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsCommentsComment() {
		if (coreAbstractionsCommentsCommentEClass == null) {
			coreAbstractionsCommentsCommentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(91);
		}
		return coreAbstractionsCommentsCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsCommentsComment_Body() {
        return (EAttribute)getCoreAbstractionsCommentsComment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsCommentsComment_AnnotatedElement() {
        return (EReference)getCoreAbstractionsCommentsComment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsOwnershipsElement() {
		if (coreAbstractionsOwnershipsElementEClass == null) {
			coreAbstractionsOwnershipsElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(92);
		}
		return coreAbstractionsOwnershipsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsOwnershipsElement_OwnedElement() {
        return (EReference)getCoreAbstractionsOwnershipsElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsOwnershipsElement_Owner() {
        return (EReference)getCoreAbstractionsOwnershipsElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsOwnershipsElement_OwnedComment() {
        return (EReference)getCoreAbstractionsOwnershipsElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsInstancesInstanceSpecification() {
		if (coreAbstractionsInstancesInstanceSpecificationEClass == null) {
			coreAbstractionsInstancesInstanceSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(93);
		}
		return coreAbstractionsInstancesInstanceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesInstanceSpecification_Slot() {
        return (EReference)getCoreAbstractionsInstancesInstanceSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesInstanceSpecification_Classifier() {
        return (EReference)getCoreAbstractionsInstancesInstanceSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesInstanceSpecification_Specification() {
        return (EReference)getCoreAbstractionsInstancesInstanceSpecification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsInstancesInstanceValue() {
		if (coreAbstractionsInstancesInstanceValueEClass == null) {
			coreAbstractionsInstancesInstanceValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(94);
		}
		return coreAbstractionsInstancesInstanceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesInstanceValue_Instance() {
        return (EReference)getCoreAbstractionsInstancesInstanceValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsInstancesSlot() {
		if (coreAbstractionsInstancesSlotEClass == null) {
			coreAbstractionsInstancesSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(95);
		}
		return coreAbstractionsInstancesSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesSlot_OwningInstance() {
        return (EReference)getCoreAbstractionsInstancesSlot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesSlot_Value() {
        return (EReference)getCoreAbstractionsInstancesSlot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsInstancesSlot_DefiningFeature() {
        return (EReference)getCoreAbstractionsInstancesSlot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsElementsElement() {
		if (coreAbstractionsElementsElementEClass == null) {
			coreAbstractionsElementsElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(96);
		}
		return coreAbstractionsElementsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsElementsElement_Line() {
        return (EAttribute)getCoreAbstractionsElementsElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsElementsElement_Column() {
        return (EAttribute)getCoreAbstractionsElementsElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsVisibilitiesNamedElement() {
		if (coreAbstractionsVisibilitiesNamedElementEClass == null) {
			coreAbstractionsVisibilitiesNamedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(97);
		}
		return coreAbstractionsVisibilitiesNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsVisibilitiesNamedElement_Visibility() {
        return (EAttribute)getCoreAbstractionsVisibilitiesNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsConstraintsNamedElement() {
		if (coreAbstractionsConstraintsNamedElementEClass == null) {
			coreAbstractionsConstraintsNamedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(99);
		}
		return coreAbstractionsConstraintsNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsNamedElement_Namespace() {
        return (EReference)getCoreAbstractionsConstraintsNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsConstraintsNamespace() {
		if (coreAbstractionsConstraintsNamespaceEClass == null) {
			coreAbstractionsConstraintsNamespaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(100);
		}
		return coreAbstractionsConstraintsNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsNamespace_OwnedRule() {
        return (EReference)getCoreAbstractionsConstraintsNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsNamespace_OwnedMember() {
        return (EReference)getCoreAbstractionsConstraintsNamespace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsNamespace_Member() {
        return (EReference)getCoreAbstractionsConstraintsNamespace().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsConstraintsConstraint() {
		if (coreAbstractionsConstraintsConstraintEClass == null) {
			coreAbstractionsConstraintsConstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(101);
		}
		return coreAbstractionsConstraintsConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsConstraint_Context() {
        return (EReference)getCoreAbstractionsConstraintsConstraint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsConstraint_Specification() {
        return (EReference)getCoreAbstractionsConstraintsConstraint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsConstraintsConstraint_ConstrainedElement() {
        return (EReference)getCoreAbstractionsConstraintsConstraint().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsNamespacesNamedElement() {
		if (coreAbstractionsNamespacesNamedElementEClass == null) {
			coreAbstractionsNamespacesNamedElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(102);
		}
		return coreAbstractionsNamespacesNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsNamespacesNamedElement_Name() {
        return (EAttribute)getCoreAbstractionsNamespacesNamedElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsNamespacesNamedElement_QualifiedName() {
        return (EAttribute)getCoreAbstractionsNamespacesNamedElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsNamespacesNamedElement_Namespace() {
        return (EReference)getCoreAbstractionsNamespacesNamedElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsNamespacesNamedElement_Identifier() {
        return (EReference)getCoreAbstractionsNamespacesNamedElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsNamespacesNamespace() {
		if (coreAbstractionsNamespacesNamespaceEClass == null) {
			coreAbstractionsNamespacesNamespaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(103);
		}
		return coreAbstractionsNamespacesNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsNamespacesNamespace_OwnedMember() {
        return (EReference)getCoreAbstractionsNamespacesNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsNamespacesNamespace_Member() {
        return (EReference)getCoreAbstractionsNamespacesNamespace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsSuperClassifier() {
		if (coreAbstractionsSuperClassifierEClass == null) {
			coreAbstractionsSuperClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(104);
		}
		return coreAbstractionsSuperClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsSuperClassifier_IsAbstract() {
        return (EAttribute)getCoreAbstractionsSuperClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsSuperClassifier_InheritedMember() {
        return (EReference)getCoreAbstractionsSuperClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsSuperClassifier_General() {
        return (EReference)getCoreAbstractionsSuperClassifier().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsClassifiersFeature() {
		if (coreAbstractionsClassifiersFeatureEClass == null) {
			coreAbstractionsClassifiersFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(105);
		}
		return coreAbstractionsClassifiersFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsClassifiersFeature_FeaturingClassifier() {
        return (EReference)getCoreAbstractionsClassifiersFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsClassifiersClassifier() {
		if (coreAbstractionsClassifiersClassifierEClass == null) {
			coreAbstractionsClassifiersClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(106);
		}
		return coreAbstractionsClassifiersClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsClassifiersClassifier_Feature() {
        return (EReference)getCoreAbstractionsClassifiersClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsExpressionsExpression() {
		if (coreAbstractionsExpressionsExpressionEClass == null) {
			coreAbstractionsExpressionsExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(107);
		}
		return coreAbstractionsExpressionsExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsExpressionsExpression_Symbol() {
        return (EAttribute)getCoreAbstractionsExpressionsExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsExpressionsExpression_Operand() {
        return (EReference)getCoreAbstractionsExpressionsExpression().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsExpressionsValueSpecification() {
		if (coreAbstractionsExpressionsValueSpecificationEClass == null) {
			coreAbstractionsExpressionsValueSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(108);
		}
		return coreAbstractionsExpressionsValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsExpressionsOpaqueExpression() {
		if (coreAbstractionsExpressionsOpaqueExpressionEClass == null) {
			coreAbstractionsExpressionsOpaqueExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(109);
		}
		return coreAbstractionsExpressionsOpaqueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsMultiplicityExpressionsMultiplicityElement() {
		if (coreAbstractionsMultiplicityExpressionsMultiplicityElementEClass == null) {
			coreAbstractionsMultiplicityExpressionsMultiplicityElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(110);
		}
		return coreAbstractionsMultiplicityExpressionsMultiplicityElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_Lower() {
        return (EAttribute)getCoreAbstractionsMultiplicityExpressionsMultiplicityElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_Upper() {
        return (EAttribute)getCoreAbstractionsMultiplicityExpressionsMultiplicityElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_UpperValue() {
        return (EReference)getCoreAbstractionsMultiplicityExpressionsMultiplicityElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsMultiplicityExpressionsMultiplicityElement_LowerValue() {
        return (EReference)getCoreAbstractionsMultiplicityExpressionsMultiplicityElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralInteger() {
		if (coreAbstractionsLiteralsLiteralIntegerEClass == null) {
			coreAbstractionsLiteralsLiteralIntegerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(111);
		}
		return coreAbstractionsLiteralsLiteralIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsLiteralsLiteralInteger_Value() {
        return (EAttribute)getCoreAbstractionsLiteralsLiteralInteger().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralString() {
		if (coreAbstractionsLiteralsLiteralStringEClass == null) {
			coreAbstractionsLiteralsLiteralStringEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(112);
		}
		return coreAbstractionsLiteralsLiteralStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsLiteralsLiteralString_Value() {
        return (EAttribute)getCoreAbstractionsLiteralsLiteralString().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralBoolean() {
		if (coreAbstractionsLiteralsLiteralBooleanEClass == null) {
			coreAbstractionsLiteralsLiteralBooleanEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(113);
		}
		return coreAbstractionsLiteralsLiteralBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsLiteralsLiteralBoolean_Value() {
        return (EAttribute)getCoreAbstractionsLiteralsLiteralBoolean().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralNull() {
		if (coreAbstractionsLiteralsLiteralNullEClass == null) {
			coreAbstractionsLiteralsLiteralNullEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(114);
		}
		return coreAbstractionsLiteralsLiteralNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralSpecification() {
		if (coreAbstractionsLiteralsLiteralSpecificationEClass == null) {
			coreAbstractionsLiteralsLiteralSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(115);
		}
		return coreAbstractionsLiteralsLiteralSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsLiteralsLiteralUnlimitedNatural() {
		if (coreAbstractionsLiteralsLiteralUnlimitedNaturalEClass == null) {
			coreAbstractionsLiteralsLiteralUnlimitedNaturalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(116);
		}
		return coreAbstractionsLiteralsLiteralUnlimitedNaturalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsLiteralsLiteralUnlimitedNatural_Value() {
        return (EAttribute)getCoreAbstractionsLiteralsLiteralUnlimitedNatural().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsRedefinitionsRedefinableElement() {
		if (coreAbstractionsRedefinitionsRedefinableElementEClass == null) {
			coreAbstractionsRedefinitionsRedefinableElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(117);
		}
		return coreAbstractionsRedefinitionsRedefinableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsRedefinitionsRedefinableElement_RedefinedElement() {
        return (EReference)getCoreAbstractionsRedefinitionsRedefinableElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsRedefinitionsRedefinableElement_RedefinitionContext() {
        return (EReference)getCoreAbstractionsRedefinitionsRedefinableElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsChangeabilitiesStructuralFeature() {
		if (coreAbstractionsChangeabilitiesStructuralFeatureEClass == null) {
			coreAbstractionsChangeabilitiesStructuralFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(118);
		}
		return coreAbstractionsChangeabilitiesStructuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsChangeabilitiesStructuralFeature_IsReadOnly() {
        return (EAttribute)getCoreAbstractionsChangeabilitiesStructuralFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsMultiplicitiesMultiplicityElement() {
		if (coreAbstractionsMultiplicitiesMultiplicityElementEClass == null) {
			coreAbstractionsMultiplicitiesMultiplicityElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(119);
		}
		return coreAbstractionsMultiplicitiesMultiplicityElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_IsOrdered() {
        return (EAttribute)getCoreAbstractionsMultiplicitiesMultiplicityElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_IsUnique() {
        return (EAttribute)getCoreAbstractionsMultiplicitiesMultiplicityElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_Lower() {
        return (EAttribute)getCoreAbstractionsMultiplicitiesMultiplicityElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreAbstractionsMultiplicitiesMultiplicityElement_Upper() {
        return (EAttribute)getCoreAbstractionsMultiplicitiesMultiplicityElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsGeneralizationsGeneralization() {
		if (coreAbstractionsGeneralizationsGeneralizationEClass == null) {
			coreAbstractionsGeneralizationsGeneralizationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(120);
		}
		return coreAbstractionsGeneralizationsGeneralizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsGeneralizationsGeneralization_Specific() {
        return (EReference)getCoreAbstractionsGeneralizationsGeneralization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsGeneralizationsGeneralization_General() {
        return (EReference)getCoreAbstractionsGeneralizationsGeneralization().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsGeneralizationsClassifier() {
		if (coreAbstractionsGeneralizationsClassifierEClass == null) {
			coreAbstractionsGeneralizationsClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(121);
		}
		return coreAbstractionsGeneralizationsClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsGeneralizationsClassifier_Generalization() {
        return (EReference)getCoreAbstractionsGeneralizationsClassifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsGeneralizationsClassifier_General() {
        return (EReference)getCoreAbstractionsGeneralizationsClassifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsRelationshipsRelationship() {
		if (coreAbstractionsRelationshipsRelationshipEClass == null) {
			coreAbstractionsRelationshipsRelationshipEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(122);
		}
		return coreAbstractionsRelationshipsRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsRelationshipsRelationship_RelatedElement() {
        return (EReference)getCoreAbstractionsRelationshipsRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreAbstractionsRelationshipsDirectedRelationship() {
		if (coreAbstractionsRelationshipsDirectedRelationshipEClass == null) {
			coreAbstractionsRelationshipsDirectedRelationshipEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(123);
		}
		return coreAbstractionsRelationshipsDirectedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsRelationshipsDirectedRelationship_Source() {
        return (EReference)getCoreAbstractionsRelationshipsDirectedRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreAbstractionsRelationshipsDirectedRelationship_Target() {
        return (EReference)getCoreAbstractionsRelationshipsDirectedRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciationInstance() {
		if (instanciationInstanceEClass == null) {
			instanciationInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(129);
		}
		return instanciationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanciationInstance_Slot() {
        return (EReference)getInstanciationInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciationSlot() {
		if (instanciationSlotEClass == null) {
			instanciationSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(130);
		}
		return instanciationSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanciationSlot_Value() {
        return (EReference)getInstanciationSlot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciationValue() {
		if (instanciationValueEClass == null) {
			instanciationValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(131);
		}
		return instanciationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciationCreate() {
		if (instanciationCreateEClass == null) {
			instanciationCreateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(132);
		}
		return instanciationCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanciationCreate_Classifier() {
        return (EReference)getInstanciationCreate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanciationMultiplicityFeature() {
		if (instanciationMultiplicityFeatureEClass == null) {
			instanciationMultiplicityFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(133);
		}
		return instanciationMultiplicityFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationDataType() {
		if (evaluationDataTypeEClass == null) {
			evaluationDataTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(134);
		}
		return evaluationDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationDataType_Literal() {
        return (EReference)getEvaluationDataType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationExpression() {
		if (evaluationExpressionEClass == null) {
			evaluationExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(135);
		}
		return evaluationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationExpression_SubExpression() {
        return (EReference)getEvaluationExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationLiteralExpression() {
		if (evaluationLiteralExpressionEClass == null) {
			evaluationLiteralExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(136);
		}
		return evaluationLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationLiteralExpression_Literal() {
        return (EReference)getEvaluationLiteralExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationFeatureAccessExpression() {
		if (evaluationFeatureAccessExpressionEClass == null) {
			evaluationFeatureAccessExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(137);
		}
		return evaluationFeatureAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationFeatureAccessExpression_Feature() {
        return (EReference)getEvaluationFeatureAccessExpression().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationLiteral() {
		if (evaluationLiteralEClass == null) {
			evaluationLiteralEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(138);
		}
		return evaluationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationEvaluation() {
		if (evaluationEvaluationEClass == null) {
			evaluationEvaluationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(139);
		}
		return evaluationEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationEvaluation_SubEvaluation() {
        return (EReference)getEvaluationEvaluation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationEvaluation_Value() {
        return (EReference)getEvaluationEvaluation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationBehavioralFeatureAccessExpression() {
		if (evaluationBehavioralFeatureAccessExpressionEClass == null) {
			evaluationBehavioralFeatureAccessExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(140);
		}
		return evaluationBehavioralFeatureAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationBehavioralFeatureAccess() {
		if (evaluationBehavioralFeatureAccessEClass == null) {
			evaluationBehavioralFeatureAccessEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(141);
		}
		return evaluationBehavioralFeatureAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationBehavioralFeatureAccess_Argument() {
        return (EReference)getEvaluationBehavioralFeatureAccess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationBehavioralFeatureAccess_BehavioralFeature() {
        return (EReference)getEvaluationBehavioralFeatureAccess().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationProcess() {
		if (communicationProcessEClass == null) {
			communicationProcessEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(142);
		}
		return communicationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationProcess_Input() {
        return (EReference)getCommunicationProcess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationEventType() {
		if (communicationEventTypeEClass == null) {
			communicationEventTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(143);
		}
		return communicationEventTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationContext() {
		if (communicationContextEClass == null) {
			communicationContextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(144);
		}
		return communicationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationContext_Process() {
        return (EReference)getCommunicationContext().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationContext_PendingEvents() {
        return (EReference)getCommunicationContext().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationListener() {
		if (communicationListenerEClass == null) {
			communicationListenerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(145);
		}
		return communicationListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationEvent() {
		if (communicationEventEClass == null) {
			communicationEventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(146);
		}
		return communicationEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationInput() {
		if (communicationInputEClass == null) {
			communicationInputEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(147);
		}
		return communicationInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationMedium() {
		if (communicationMediumEClass == null) {
			communicationMediumEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(148);
		}
		return communicationMediumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationMedium_AssociatedClassifier() {
        return (EReference)getCommunicationMedium().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationCommunicator() {
		if (communicationCommunicatorEClass == null) {
			communicationCommunicatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(149);
		}
		return communicationCommunicatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationCommunicator_Medium() {
        return (EReference)getCommunicationCommunicator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSdlSpecification() {
		if (sdlSpecificationEClass == null) {
			sdlSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(150);
		}
		return sdlSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSpecification_System() {
        return (EReference)getSdlSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSdlSpecification_Packages() {
        return (EReference)getSdlSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSdlAgentKind() {
		if (sdlAgentKindEEnum == null) {
			sdlAgentKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(9);
		}
		return sdlAgentKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSdlParameterKind() {
		if (sdlParameterKindEEnum == null) {
			sdlParameterKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(32);
		}
		return sdlParameterKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSdlPidExpressionKind() {
		if (sdlPidExpressionKindEEnum == null) {
			sdlPidExpressionKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(41);
		}
		return sdlPidExpressionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSdlStateStatus() {
		if (sdlStateStatusEEnum == null) {
			sdlStateStatusEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(81);
		}
		return sdlStateStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConcreteSyntaxSdlScopeUnitKind() {
		if (concreteSyntaxSdlScopeUnitKindEEnum == null) {
			concreteSyntaxSdlScopeUnitKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(85);
		}
		return concreteSyntaxSdlScopeUnitKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCoreAbstractionsVisibilitiesVisibilityKind() {
		if (coreAbstractionsVisibilitiesVisibilityKindEEnum == null) {
			coreAbstractionsVisibilitiesVisibilityKindEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(98);
		}
		return coreAbstractionsVisibilitiesVisibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrimitiveTypesUnlimitedNatural() {
		if (primitiveTypesUnlimitedNaturalEDataType == null) {
			primitiveTypesUnlimitedNaturalEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(124);
		}
		return primitiveTypesUnlimitedNaturalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrimitiveTypesString() {
		if (primitiveTypesStringEDataType == null) {
			primitiveTypesStringEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(125);
		}
		return primitiveTypesStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrimitiveTypesBoolean() {
		if (primitiveTypesBooleanEDataType == null) {
			primitiveTypesBooleanEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(126);
		}
		return primitiveTypesBooleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrimitiveTypesInteger() {
		if (primitiveTypesIntegerEDataType == null) {
			primitiveTypesIntegerEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(127);
		}
		return primitiveTypesIntegerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrimitiveTypesObject() {
		if (primitiveTypesObjectEDataType == null) {
			primitiveTypesObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(EmfSdlPackage.eNS_URI).getEClassifiers().get(128);
		}
		return primitiveTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfSdlFactory getEmfSdlFactory() {
		return (EmfSdlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("hub.sam.sdl." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //EmfSdlPackageImpl
