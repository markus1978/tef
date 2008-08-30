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
import hub.sam.tef.etsl.RhsOperator;
import hub.sam.tef.etsl.RhsPart;
import hub.sam.tef.etsl.RhsSequence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtslFactoryImpl extends EFactoryImpl implements EtslFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtslFactory init() {
		try {
			EtslFactory theEtslFactory = (EtslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.hu-berlin.de/sam/meta-tools/tef/etsl"); 
			if (theEtslFactory != null) {
				return theEtslFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EtslFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtslFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EtslPackage.EXTENDED_RULE: return createExtendedRule();
			case EtslPackage.RHS_SEQUENCE: return createRhsSequence();
			case EtslPackage.RHS_PART: return createRhsPart();
			case EtslPackage.RHS_OPERATOR: return createRhsOperator();
			case EtslPackage.ARBITRARY: return createArbitrary();
			case EtslPackage.AT_LEAST_ONE: return createAtLeastOne();
			case EtslPackage.OPTIONAL: return createOptional();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedRule createExtendedRule() {
		ExtendedRuleImpl extendedRule = new ExtendedRuleImpl();
		return extendedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhsSequence createRhsSequence() {
		RhsSequenceImpl rhsSequence = new RhsSequenceImpl();
		return rhsSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhsPart createRhsPart() {
		RhsPartImpl rhsPart = new RhsPartImpl();
		return rhsPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhsOperator createRhsOperator() {
		RhsOperatorImpl rhsOperator = new RhsOperatorImpl();
		return rhsOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arbitrary createArbitrary() {
		ArbitraryImpl arbitrary = new ArbitraryImpl();
		return arbitrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtLeastOne createAtLeastOne() {
		AtLeastOneImpl atLeastOne = new AtLeastOneImpl();
		return atLeastOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Optional createOptional() {
		OptionalImpl optional = new OptionalImpl();
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtslPackage getEtslPackage() {
		return (EtslPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EtslPackage getPackage() {
		return EtslPackage.eINSTANCE;
	}

} //EtslFactoryImpl
