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
 * A representation of the model object '<em><b>Core Abstractions Expressions Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsExpression()
 * @model
 * @generated
 */
public interface CoreAbstractionsExpressionsExpression extends CoreAbstractionsExpressionsValueSpecification {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsExpression_Symbol()
	 * @model ordered="false"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.CoreAbstractionsExpressionsExpression#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getCoreAbstractionsExpressionsExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
	EList<CoreAbstractionsExpressionsValueSpecification> getOperand();

} // CoreAbstractionsExpressionsExpression
