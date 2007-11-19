/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.SimpleRule#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getSimpleRule()
 * @model
 * @generated
 */
public interface SimpleRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.tef.tsl.Symbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference list.
	 * @see hub.sam.tef.tsl.TslPackage#getSimpleRule_Rhs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Symbol> getRhs();

} // SimpleRule
