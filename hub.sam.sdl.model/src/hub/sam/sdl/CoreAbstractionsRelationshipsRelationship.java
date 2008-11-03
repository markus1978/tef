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
 * A representation of the model object '<em><b>Core Abstractions Relationships Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRelationshipsRelationship#getRelationship_relatedElement <em>Relationship related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsRelationship()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsRelationshipsRelationship extends CoreAbstractionsOwnershipsElement {
	/**
	 * Returns the value of the '<em><b>Relationship related Element</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship related Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship related Element</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRelationshipsRelationship_Relationship_relatedElement()
	 * @model required="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getRelationship_relatedElement();

} // CoreAbstractionsRelationshipsRelationship
