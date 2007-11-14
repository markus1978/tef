/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fix Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.FixTerminal#getTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getFixTerminal()
 * @model
 * @generated
 */
public interface FixTerminal extends Terminal {
	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(String)
	 * @see hub.sam.tef.tsl.TslPackage#getFixTerminal_Terminal()
	 * @model required="true"
	 * @generated
	 */
	String getTerminal();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.FixTerminal#getTerminal <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #getTerminal()
	 * @generated
	 */
	void setTerminal(String value);

} // FixTerminal
