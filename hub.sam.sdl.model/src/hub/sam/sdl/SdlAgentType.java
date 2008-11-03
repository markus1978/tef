/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Agent Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getAgent <em>Agent</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getKind <em>Kind</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getOwnedAgentType <em>Owned Agent Type</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getChannel <em>Channel</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentType#getGate <em>Gate</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType()
 * @model
 * @generated
 */
public interface SdlAgentType extends SdlBehaviorElement, SdlClassifier, CoreAbstractionsBehavioralFeaturesBehavioralFeature {
	/**
	 * Returns the value of the '<em><b>Agent</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAgent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Agent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAgent> getAgent();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.SdlAgentKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlAgentKind
	 * @see #setKind(SdlAgentKind)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlAgentKind getKind();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlAgentKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SdlAgentKind value);

	/**
	 * Returns the value of the '<em><b>Owned Agent Type</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlAgentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Agent Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Agent Type</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_OwnedAgentType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlAgentType> getOwnedAgentType();

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlChannel}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannel#getAgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Channel()
	 * @see hub.sam.sdl.SdlChannel#getAgentType
	 * @model opposite="agentType" containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlChannel> getChannel();

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(SdlCompositeState)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Behavior()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SdlCompositeState getBehavior();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentType#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(SdlCompositeState value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<SdlParameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Gate</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlGate}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlGate#getAgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gate</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentType_Gate()
	 * @see hub.sam.sdl.SdlGate#getAgentType
	 * @model opposite="agentType" containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlGate> getGate();

} // SdlAgentType
