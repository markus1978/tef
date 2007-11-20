/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.tef.etsl.EtslPackage
 * @generated
 */
public interface EtslFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EtslFactory eINSTANCE = hub.sam.tef.etsl.impl.EtslFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extended Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Rule</em>'.
	 * @generated
	 */
	ExtendedRule createExtendedRule();

	/**
	 * Returns a new object of class '<em>Rhs Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rhs Sequence</em>'.
	 * @generated
	 */
	RhsSequence createRhsSequence();

	/**
	 * Returns a new object of class '<em>Rhs Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rhs Part</em>'.
	 * @generated
	 */
	RhsPart createRhsPart();

	/**
	 * Returns a new object of class '<em>Rhs Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rhs Operator</em>'.
	 * @generated
	 */
	RhsOperator createRhsOperator();

	/**
	 * Returns a new object of class '<em>Arbitrary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arbitrary</em>'.
	 * @generated
	 */
	Arbitrary createArbitrary();

	/**
	 * Returns a new object of class '<em>At Least One</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>At Least One</em>'.
	 * @generated
	 */
	AtLeastOne createAtLeastOne();

	/**
	 * Returns a new object of class '<em>Optional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optional</em>'.
	 * @generated
	 */
	Optional createOptional();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EtslPackage getEtslPackage();

} //EtslFactory
