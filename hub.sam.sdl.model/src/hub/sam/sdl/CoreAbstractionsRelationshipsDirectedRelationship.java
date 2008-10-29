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
 * A representation of the model object '<em><b>Core Abstractions Relationships Directed Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getSource <em>Source</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsRelationshipsDirectedRelationship extends CoreAbstractionsRelationshipsRelationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship_Source()
	 * @model containment="true" required="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getSource();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship_Target()
	 * @model containment="true" required="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getTarget();

} // CoreAbstractionsRelationshipsDirectedRelationship
