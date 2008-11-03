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
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_source <em>Directed Relationship source</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship#getDirectedRelationship_target <em>Directed Relationship target</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsRelationshipsDirectedRelationship extends CoreAbstractionsRelationshipsRelationship {
	/**
	 * Returns the value of the '<em><b>Directed Relationship source</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directed Relationship source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directed Relationship source</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship_DirectedRelationship_source()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getDirectedRelationship_source();

	/**
	 * Returns the value of the '<em><b>Directed Relationship target</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directed Relationship target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directed Relationship target</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsDirectedRelationship_DirectedRelationship_target()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getDirectedRelationship_target();

} // CoreAbstractionsRelationshipsDirectedRelationship
