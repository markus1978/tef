/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhs Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.etsl.RhsSequence#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.etsl.EtslPackage#getRhsSequence()
 * @model
 * @generated
 */
public interface RhsSequence extends Rhs {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.tef.etsl.Rhs}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see hub.sam.tef.etsl.EtslPackage#getRhsSequence_Parts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Rhs> getParts();

} // RhsSequence
