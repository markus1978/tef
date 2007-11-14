/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>White Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.WhiteSpace#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getWhiteSpace()
 * @model
 * @generated
 */
public interface WhiteSpace extends Terminal {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see #setRole(String)
	 * @see hub.sam.tef.tsl.TslPackage#getWhiteSpace_Role()
	 * @model required="true"
	 * @generated
	 */
	String getRole();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.WhiteSpace#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(String value);

} // WhiteSpace
