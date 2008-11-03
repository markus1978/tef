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
 * A representation of the model object '<em><b>Core Abstractions Super Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#getInheritedMember <em>Inherited Member</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsSuperClassifier()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsSuperClassifier extends CoreAbstractionsNamespacesNamespace {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsSuperClassifier_IsAbstract()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsSuperClassifier#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Inherited Member</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsNamespacesNamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Member</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Member</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsSuperClassifier_InheritedMember()
	 * @model derived="true" ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> getInheritedMember();

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsSuperClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsSuperClassifier_General()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsSuperClassifier> getGeneral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> inheritedMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsSuperClassifier> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<CoreAbstractionsSuperClassifier> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" cRequired="true" cOrdered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> inheritableMembers(CoreAbstractionsSuperClassifier c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nRequired="true" nOrdered="false"
	 * @generated
	 */
	boolean hasVisibilityOf(CoreAbstractionsNamespacesNamedElement n);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" inhsMany="true" inhsOrdered="false"
	 * @generated
	 */
	EList<CoreAbstractionsNamespacesNamedElement> inherit(EList<CoreAbstractionsNamespacesNamedElement> inhs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" cRequired="true" cOrdered="false"
	 * @generated
	 */
	boolean maySpecializeType(CoreAbstractionsSuperClassifier c);

} // CoreAbstractionsSuperClassifier
