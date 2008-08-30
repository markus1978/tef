/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl.impl;

import hub.sam.tef.etsl.Arbitrary;
import hub.sam.tef.etsl.AtLeastOne;
import hub.sam.tef.etsl.EtslFactory;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.etsl.ExtendedRule;
import hub.sam.tef.etsl.Optional;
import hub.sam.tef.etsl.Rhs;
import hub.sam.tef.etsl.RhsOperator;
import hub.sam.tef.etsl.RhsPart;
import hub.sam.tef.etsl.RhsSequence;
import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtslPackageImpl extends EPackageImpl implements EtslPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhsSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhsPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhsOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arbitraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atLeastOneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionalEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hub.sam.tef.etsl.EtslPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EtslPackageImpl() {
		super(eNS_URI, EtslFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EtslPackage init() {
		if (isInited) return (EtslPackage)EPackage.Registry.INSTANCE.getEPackage(EtslPackage.eNS_URI);

		// Obtain or create and register package
		EtslPackageImpl theEtslPackage = (EtslPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EtslPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EtslPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TslPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEtslPackage.createPackageContents();

		// Initialize created meta-data
		theEtslPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEtslPackage.freeze();

		return theEtslPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedRule() {
		return extendedRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedRule_Rhs() {
		return (EReference)extendedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhs() {
		return rhsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhsSequence() {
		return rhsSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhsSequence_Parts() {
		return (EReference)rhsSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhsPart() {
		return rhsPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhsPart_Symbol() {
		return (EReference)rhsPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhsOperator() {
		return rhsOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhsOperator_Operand() {
		return (EReference)rhsOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArbitrary() {
		return arbitraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtLeastOne() {
		return atLeastOneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptional() {
		return optionalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtslFactory getEtslFactory() {
		return (EtslFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		extendedRuleEClass = createEClass(EXTENDED_RULE);
		createEReference(extendedRuleEClass, EXTENDED_RULE__RHS);

		rhsEClass = createEClass(RHS);

		rhsSequenceEClass = createEClass(RHS_SEQUENCE);
		createEReference(rhsSequenceEClass, RHS_SEQUENCE__PARTS);

		rhsPartEClass = createEClass(RHS_PART);
		createEReference(rhsPartEClass, RHS_PART__SYMBOL);

		rhsOperatorEClass = createEClass(RHS_OPERATOR);
		createEReference(rhsOperatorEClass, RHS_OPERATOR__OPERAND);

		arbitraryEClass = createEClass(ARBITRARY);

		atLeastOneEClass = createEClass(AT_LEAST_ONE);

		optionalEClass = createEClass(OPTIONAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TslPackage theTslPackage = (TslPackage)EPackage.Registry.INSTANCE.getEPackage(TslPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendedRuleEClass.getESuperTypes().add(theTslPackage.getRule());
		rhsSequenceEClass.getESuperTypes().add(this.getRhs());
		rhsPartEClass.getESuperTypes().add(this.getRhs());
		rhsOperatorEClass.getESuperTypes().add(this.getRhs());
		arbitraryEClass.getESuperTypes().add(this.getRhsOperator());
		atLeastOneEClass.getESuperTypes().add(this.getRhsOperator());
		optionalEClass.getESuperTypes().add(this.getRhsOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(extendedRuleEClass, ExtendedRule.class, "ExtendedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendedRule_Rhs(), this.getRhs(), null, "rhs", null, 0, 1, ExtendedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(extendedRuleEClass, theTslPackage.getSimpleRule(), "createSimpleRules", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(rhsEClass, Rhs.class, "Rhs", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rhsSequenceEClass, RhsSequence.class, "RhsSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRhsSequence_Parts(), this.getRhs(), null, "parts", null, 1, -1, RhsSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rhsPartEClass, RhsPart.class, "RhsPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRhsPart_Symbol(), theTslPackage.getSymbol(), null, "symbol", null, 1, 1, RhsPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rhsOperatorEClass, RhsOperator.class, "RhsOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRhsOperator_Operand(), this.getRhs(), null, "operand", null, 1, 1, RhsOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arbitraryEClass, Arbitrary.class, "Arbitrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atLeastOneEClass, AtLeastOne.class, "AtLeastOne", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(optionalEClass, Optional.class, "Optional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EtslPackageImpl
