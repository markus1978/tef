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
 * A representation of the model object '<em><b>Sdl Channel Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlChannelPath#getSource <em>Source</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelPath#getTarget <em>Target</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelPath#getSignal <em>Signal</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelPath#getRelatedElement <em>Related Element</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlChannelPath#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath()
 * @model
 * @generated
 */
public interface SdlChannelPath extends CoreAbstractionsRelationshipsDirectedRelationship, CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(SdlChannelEnd)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath_Source()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlChannelEnd getSource();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelPath#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SdlChannelEnd value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(SdlChannelEnd)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath_Target()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SdlChannelEnd getTarget();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelPath#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SdlChannelEnd value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlSignal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath_Signal()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SdlSignal> getSignal();

	/**
	 * Returns the value of the '<em><b>Related Element</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlChannelEnd}.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannelEnd#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Element</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath_RelatedElement()
	 * @see hub.sam.sdl.SdlChannelEnd#getChannel
	 * @model opposite="channel" containment="true" ordered="false"
	 * @generated
	 */
	EList<SdlChannelEnd> getRelatedElement();

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.SdlChannel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' container reference.
	 * @see #setChannel(SdlChannel)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlChannelPath_Channel()
	 * @see hub.sam.sdl.SdlChannel#getPath
	 * @model opposite="path" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SdlChannel getChannel();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlChannelPath#getChannel <em>Channel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' container reference.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(SdlChannel value);

} // SdlChannelPath
