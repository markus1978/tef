/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.tef.tsl.TslPackage
 * @generated
 */
public interface TslFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TslFactory eINSTANCE = hub.sam.tef.tsl.impl.TslFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Syntax</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syntax</em>'.
	 * @generated
	 */
	Syntax createSyntax();

	/**
	 * Returns a new object of class '<em>Simple Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Rule</em>'.
	 * @generated
	 */
	SimpleRule createSimpleRule();

	/**
	 * Returns a new object of class '<em>Non Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Terminal</em>'.
	 * @generated
	 */
	NonTerminal createNonTerminal();

	/**
	 * Returns a new object of class '<em>Fix Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fix Terminal</em>'.
	 * @generated
	 */
	FixTerminal createFixTerminal();

	/**
	 * Returns a new object of class '<em>Pattern Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Terminal</em>'.
	 * @generated
	 */
	PatternTerminal createPatternTerminal();

	/**
	 * Returns a new object of class '<em>White Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>White Space</em>'.
	 * @generated
	 */
	WhiteSpace createWhiteSpace();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	Binding createBinding();

	/**
	 * Returns a new object of class '<em>Element Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Binding</em>'.
	 * @generated
	 */
	ElementBinding createElementBinding();

	/**
	 * Returns a new object of class '<em>Element Reference Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Reference Binding</em>'.
	 * @generated
	 */
	ElementReferenceBinding createElementReferenceBinding();

	/**
	 * Returns a new object of class '<em>Primitive Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Binding</em>'.
	 * @generated
	 */
	PrimitiveBinding createPrimitiveBinding();

	/**
	 * Returns a new object of class '<em>Composite Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Binding</em>'.
	 * @generated
	 */
	CompositeBinding createCompositeBinding();

	/**
	 * Returns a new object of class '<em>Reference Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Binding</em>'.
	 * @generated
	 */
	ReferenceBinding createReferenceBinding();

	/**
	 * Returns a new object of class '<em>Action Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Binding</em>'.
	 * @generated
	 */
	ActionBinding createActionBinding();

	/**
	 * Returns a new object of class '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement</em>'.
	 * @generated
	 */
	Statement createStatement();

	/**
	 * Returns a new object of class '<em>Constant Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Binding</em>'.
	 * @generated
	 */
	ConstantBinding createConstantBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TslPackage getTslPackage();

} //TslFactory
