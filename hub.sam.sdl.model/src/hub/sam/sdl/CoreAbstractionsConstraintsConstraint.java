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
 * A representation of the model object '<em><b>Core Abstractions Constraints Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext <em>Context</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getSpecification <em>Specification</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getConstrainedElement <em>Constrained Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsConstraint()
 * @model
 * @generated
 */
public interface CoreAbstractionsConstraintsConstraint extends CoreAbstractionsConstraintsNamedElement {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedRule <em>Owned Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(CoreAbstractionsConstraintsNamespace)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsConstraint_Context()
	 * @see hub.sam.sdl.CoreAbstractionsConstraintsNamespace#getOwnedRule
	 * @model opposite="ownedRule" transient="false" ordered="false"
	 * @generated
	 */
	CoreAbstractionsConstraintsNamespace getContext();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(CoreAbstractionsConstraintsNamespace value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(CoreAbstractionsExpressionsValueSpecification)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsConstraint_Specification()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CoreAbstractionsExpressionsValueSpecification getSpecification();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsConstraintsConstraint#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(CoreAbstractionsExpressionsValueSpecification value);

	/**
	 * Returns the value of the '<em><b>Constrained Element</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsOwnershipsElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Element</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsConstraintsConstraint_ConstrainedElement()
	 * @model
	 * @generated
	 */
	EList<CoreAbstractionsOwnershipsElement> getConstrainedElement();

} // CoreAbstractionsConstraintsConstraint
