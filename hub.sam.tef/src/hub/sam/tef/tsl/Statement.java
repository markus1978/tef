/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Statement#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Statement#getMethodParameters <em>Method Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getStatement()
 * @model
 * @generated
 */
public interface Statement extends EObject {
	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see hub.sam.tef.tsl.TslPackage#getStatement_MethodName()
	 * @model required="true"
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Statement#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Method Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Parameters</em>' attribute list.
	 * @see hub.sam.tef.tsl.TslPackage#getStatement_MethodParameters()
	 * @model
	 * @generated
	 */
	EList<Integer> getMethodParameters();

} // Statement
