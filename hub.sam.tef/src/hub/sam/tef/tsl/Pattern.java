/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Pattern#getRccSymbol <em>Rcc Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Rcc Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rcc Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rcc Symbol</em>' attribute.
	 * @see #setRccSymbol(String)
	 * @see hub.sam.tef.tsl.TslPackage#getPattern_RccSymbol()
	 * @model required="true"
	 * @generated
	 */
	String getRccSymbol();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Pattern#getRccSymbol <em>Rcc Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rcc Symbol</em>' attribute.
	 * @see #getRccSymbol()
	 * @generated
	 */
	void setRccSymbol(String value);

} // Pattern
