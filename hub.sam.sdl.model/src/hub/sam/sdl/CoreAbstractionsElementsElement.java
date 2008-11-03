/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Abstractions Elements Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsElementsElement#getLine <em>Line</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsElementsElement#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsElementsElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreAbstractionsElementsElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsElementsElement_Line()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsElementsElement#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(int)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsElementsElement_Column()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsElementsElement#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

} // CoreAbstractionsElementsElement
