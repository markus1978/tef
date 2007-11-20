/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl;

import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hub.sam.tef.etsl.EtslFactory
 * @model kind="package"
 * @generated
 */
public interface EtslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "etsl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.hu-berlin.de/sam/meta-tools/tef/etsl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "etsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EtslPackage eINSTANCE = hub.sam.tef.etsl.impl.EtslPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.ExtendedRuleImpl <em>Extended Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.ExtendedRuleImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getExtendedRule()
	 * @generated
	 */
	int EXTENDED_RULE = 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_RULE__LHS = TslPackage.RULE__LHS;

	/**
	 * The feature id for the '<em><b>Value Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_RULE__VALUE_BINDING = TslPackage.RULE__VALUE_BINDING;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_RULE__PRIORITY = TslPackage.RULE__PRIORITY;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_RULE__RHS = TslPackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extended Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_RULE_FEATURE_COUNT = TslPackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.RhsImpl <em>Rhs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.RhsImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhs()
	 * @generated
	 */
	int RHS = 1;

	/**
	 * The number of structural features of the '<em>Rhs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.RhsSequenceImpl <em>Rhs Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.RhsSequenceImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsSequence()
	 * @generated
	 */
	int RHS_SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_SEQUENCE__PARTS = RHS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rhs Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_SEQUENCE_FEATURE_COUNT = RHS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.RhsPartImpl <em>Rhs Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.RhsPartImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsPart()
	 * @generated
	 */
	int RHS_PART = 3;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_PART__SYMBOL = RHS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rhs Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_PART_FEATURE_COUNT = RHS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.RhsOperatorImpl <em>Rhs Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.RhsOperatorImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsOperator()
	 * @generated
	 */
	int RHS_OPERATOR = 4;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_OPERATOR__OPERAND = RHS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rhs Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_OPERATOR_FEATURE_COUNT = RHS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.ArbitraryImpl <em>Arbitrary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.ArbitraryImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getArbitrary()
	 * @generated
	 */
	int ARBITRARY = 5;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY__OPERAND = RHS_OPERATOR__OPERAND;

	/**
	 * The number of structural features of the '<em>Arbitrary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_FEATURE_COUNT = RHS_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.AtLeastOneImpl <em>At Least One</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.AtLeastOneImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getAtLeastOne()
	 * @generated
	 */
	int AT_LEAST_ONE = 6;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AT_LEAST_ONE__OPERAND = RHS_OPERATOR__OPERAND;

	/**
	 * The number of structural features of the '<em>At Least One</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AT_LEAST_ONE_FEATURE_COUNT = RHS_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.etsl.impl.OptionalImpl <em>Optional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.etsl.impl.OptionalImpl
	 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getOptional()
	 * @generated
	 */
	int OPTIONAL = 7;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL__OPERAND = RHS_OPERATOR__OPERAND;

	/**
	 * The number of structural features of the '<em>Optional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_FEATURE_COUNT = RHS_OPERATOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.ExtendedRule <em>Extended Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Rule</em>'.
	 * @see hub.sam.tef.etsl.ExtendedRule
	 * @generated
	 */
	EClass getExtendedRule();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.etsl.ExtendedRule#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see hub.sam.tef.etsl.ExtendedRule#getRhs()
	 * @see #getExtendedRule()
	 * @generated
	 */
	EReference getExtendedRule_Rhs();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.Rhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs</em>'.
	 * @see hub.sam.tef.etsl.Rhs
	 * @generated
	 */
	EClass getRhs();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.RhsSequence <em>Rhs Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs Sequence</em>'.
	 * @see hub.sam.tef.etsl.RhsSequence
	 * @generated
	 */
	EClass getRhsSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.tef.etsl.RhsSequence#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see hub.sam.tef.etsl.RhsSequence#getParts()
	 * @see #getRhsSequence()
	 * @generated
	 */
	EReference getRhsSequence_Parts();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.RhsPart <em>Rhs Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs Part</em>'.
	 * @see hub.sam.tef.etsl.RhsPart
	 * @generated
	 */
	EClass getRhsPart();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.etsl.RhsPart#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Symbol</em>'.
	 * @see hub.sam.tef.etsl.RhsPart#getSymbol()
	 * @see #getRhsPart()
	 * @generated
	 */
	EReference getRhsPart_Symbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.RhsOperator <em>Rhs Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs Operator</em>'.
	 * @see hub.sam.tef.etsl.RhsOperator
	 * @generated
	 */
	EClass getRhsOperator();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.etsl.RhsOperator#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see hub.sam.tef.etsl.RhsOperator#getOperand()
	 * @see #getRhsOperator()
	 * @generated
	 */
	EReference getRhsOperator_Operand();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.Arbitrary <em>Arbitrary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arbitrary</em>'.
	 * @see hub.sam.tef.etsl.Arbitrary
	 * @generated
	 */
	EClass getArbitrary();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.AtLeastOne <em>At Least One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>At Least One</em>'.
	 * @see hub.sam.tef.etsl.AtLeastOne
	 * @generated
	 */
	EClass getAtLeastOne();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.etsl.Optional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optional</em>'.
	 * @see hub.sam.tef.etsl.Optional
	 * @generated
	 */
	EClass getOptional();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EtslFactory getEtslFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.ExtendedRuleImpl <em>Extended Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.ExtendedRuleImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getExtendedRule()
		 * @generated
		 */
		EClass EXTENDED_RULE = eINSTANCE.getExtendedRule();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_RULE__RHS = eINSTANCE.getExtendedRule_Rhs();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.RhsImpl <em>Rhs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.RhsImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhs()
		 * @generated
		 */
		EClass RHS = eINSTANCE.getRhs();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.RhsSequenceImpl <em>Rhs Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.RhsSequenceImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsSequence()
		 * @generated
		 */
		EClass RHS_SEQUENCE = eINSTANCE.getRhsSequence();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHS_SEQUENCE__PARTS = eINSTANCE.getRhsSequence_Parts();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.RhsPartImpl <em>Rhs Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.RhsPartImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsPart()
		 * @generated
		 */
		EClass RHS_PART = eINSTANCE.getRhsPart();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHS_PART__SYMBOL = eINSTANCE.getRhsPart_Symbol();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.RhsOperatorImpl <em>Rhs Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.RhsOperatorImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getRhsOperator()
		 * @generated
		 */
		EClass RHS_OPERATOR = eINSTANCE.getRhsOperator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHS_OPERATOR__OPERAND = eINSTANCE.getRhsOperator_Operand();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.ArbitraryImpl <em>Arbitrary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.ArbitraryImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getArbitrary()
		 * @generated
		 */
		EClass ARBITRARY = eINSTANCE.getArbitrary();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.AtLeastOneImpl <em>At Least One</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.AtLeastOneImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getAtLeastOne()
		 * @generated
		 */
		EClass AT_LEAST_ONE = eINSTANCE.getAtLeastOne();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.etsl.impl.OptionalImpl <em>Optional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.etsl.impl.OptionalImpl
		 * @see hub.sam.tef.etsl.impl.EtslPackageImpl#getOptional()
		 * @generated
		 */
		EClass OPTIONAL = eINSTANCE.getOptional();

	}

} //EtslPackage
