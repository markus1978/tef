/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;

import hub.sam.tef.tsl.Symbol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhs Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.etsl.RhsPart#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.etsl.EtslPackage#getRhsPart()
 * @model
 * @generated
 */
public interface RhsPart extends Rhs {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' containment reference.
	 * @see #setSymbol(Symbol)
	 * @see hub.sam.tef.etsl.EtslPackage#getRhsPart_Symbol()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Symbol getSymbol();

	/**
	 * Sets the value of the '{@link hub.sam.tef.etsl.RhsPart#getSymbol <em>Symbol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' containment reference.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(Symbol value);

} // RhsPart
