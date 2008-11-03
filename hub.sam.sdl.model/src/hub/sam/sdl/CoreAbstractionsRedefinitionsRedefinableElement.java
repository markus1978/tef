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
 * A representation of the model object '<em><b>Core Abstractions Redefinitions Redefinable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinedElement <em>Redefined Element</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement#getRedefinitionContext <em>Redefinition Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRedefinitionsRedefinableElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsRedefinitionsRedefinableElement extends CoreAbstractionsNamespacesNamedElement {
	/**
	 * Returns the value of the '<em><b>Redefined Element</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Element</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRedefinitionsRedefinableElement_RedefinedElement()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsRedefinitionsRedefinableElement> getRedefinedElement();

	/**
	 * Returns the value of the '<em><b>Redefinition Context</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsSuperClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefinition Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefinition Context</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsRedefinitionsRedefinableElement_RedefinitionContext()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsSuperClassifier> getRedefinitionContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" redefineeRequired="true" redefineeOrdered="false"
	 * @generated
	 */
	boolean isConsistentWith(CoreAbstractionsRedefinitionsRedefinableElement redefinee);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" redefinedRequired="true" redefinedOrdered="false"
	 * @generated
	 */
	boolean isRedefinitionContextValid(CoreAbstractionsRedefinitionsRedefinableElement redefined);

} // CoreAbstractionsRedefinitionsRedefinableElement
