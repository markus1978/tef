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
 * A representation of the model object '<em><b>Sdl Agent Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet <em>Agent Instance Set</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstance#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet <em>Owning Instance Set</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstance#getParent <em>Parent</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlAgentInstance#getOffspring <em>Offspring</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance()
 * @model
 * @generated
 */
public interface SdlAgentInstance extends SdlInstance {
	/**
	 * Returns the value of the '<em><b>Agent Instance Set</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance <em>Agent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Instance Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Instance Set</em>' containment reference.
	 * @see #setAgentInstanceSet(SdlAgentInstanceSet)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance_AgentInstanceSet()
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getAgentInstance
	 * @model opposite="agentInstance" containment="true" ordered="false"
	 * @generated
	 */
	SdlAgentInstanceSet getAgentInstanceSet();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstance#getAgentInstanceSet <em>Agent Instance Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Instance Set</em>' containment reference.
	 * @see #getAgentInstanceSet()
	 * @generated
	 */
	void setAgentInstanceSet(SdlAgentInstanceSet value);

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(SdlCompositeStateInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance_Behavior()
	 * @see hub.sam.sdl.SdlCompositeStateInstance#getOwningInstance
	 * @model opposite="owningInstance" containment="true" ordered="false"
	 * @generated
	 */
	SdlCompositeStateInstance getBehavior();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstance#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(SdlCompositeStateInstance value);

	/**
	 * Returns the value of the '<em><b>Owning Instance Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlAgentInstanceSet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Instance Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Instance Set</em>' container reference.
	 * @see #setOwningInstanceSet(SdlAgentInstanceSet)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance_OwningInstanceSet()
	 * @see hub.sam.sdl.SdlAgentInstanceSet#getValue
	 * @model opposite="value" transient="false" ordered="false"
	 * @generated
	 */
	SdlAgentInstanceSet getOwningInstanceSet();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstance#getOwningInstanceSet <em>Owning Instance Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance Set</em>' container reference.
	 * @see #getOwningInstanceSet()
	 * @generated
	 */
	void setOwningInstanceSet(SdlAgentInstanceSet value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance_Parent()
	 * @model ordered="false"
	 * @generated
	 */
	SdlAgentInstance getParent();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstance#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SdlAgentInstance value);

	/**
	 * Returns the value of the '<em><b>Offspring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offspring</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offspring</em>' reference.
	 * @see #setOffspring(SdlAgentInstance)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlAgentInstance_Offspring()
	 * @model ordered="false"
	 * @generated
	 */
	SdlAgentInstance getOffspring();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlAgentInstance#getOffspring <em>Offspring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offspring</em>' reference.
	 * @see #getOffspring()
	 * @generated
	 */
	void setOffspring(SdlAgentInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" pathRequired="true" pathOrdered="false"
	 * @generated
	 */
	SdlAgentInstanceSet leadsTo(SdlChannelPath path);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathRequired="true" pathOrdered="false"
	 * @generated
	 */
	EList<SdlChannelPath> continuesWith(SdlChannelPath path);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sRequired="true" sOrdered="false" viaRequired="true" viaOrdered="false"
	 * @generated
	 */
	void dispatchSignal(SdlSignalInstance s, SdlGate via);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void run();

} // SdlAgentInstance
