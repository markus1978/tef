/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl.util;

import hub.sam.tef.etsl.Arbitrary;
import hub.sam.tef.etsl.AtLeastOne;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.etsl.ExtendedRule;
import hub.sam.tef.etsl.Optional;
import hub.sam.tef.etsl.Rhs;
import hub.sam.tef.etsl.RhsOperator;
import hub.sam.tef.etsl.RhsPart;
import hub.sam.tef.etsl.RhsSequence;
import hub.sam.tef.tsl.Rule;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.tef.etsl.EtslPackage
 * @generated
 */
public class EtslAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EtslPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtslAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EtslPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EtslSwitch<Adapter> modelSwitch =
		new EtslSwitch<Adapter>() {
			@Override
			public Adapter caseExtendedRule(ExtendedRule object) {
				return createExtendedRuleAdapter();
			}
			@Override
			public Adapter caseRhs(Rhs object) {
				return createRhsAdapter();
			}
			@Override
			public Adapter caseRhsSequence(RhsSequence object) {
				return createRhsSequenceAdapter();
			}
			@Override
			public Adapter caseRhsPart(RhsPart object) {
				return createRhsPartAdapter();
			}
			@Override
			public Adapter caseRhsOperator(RhsOperator object) {
				return createRhsOperatorAdapter();
			}
			@Override
			public Adapter caseArbitrary(Arbitrary object) {
				return createArbitraryAdapter();
			}
			@Override
			public Adapter caseAtLeastOne(AtLeastOne object) {
				return createAtLeastOneAdapter();
			}
			@Override
			public Adapter caseOptional(Optional object) {
				return createOptionalAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.ExtendedRule <em>Extended Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.ExtendedRule
	 * @generated
	 */
	public Adapter createExtendedRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.Rhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.Rhs
	 * @generated
	 */
	public Adapter createRhsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.RhsSequence <em>Rhs Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.RhsSequence
	 * @generated
	 */
	public Adapter createRhsSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.RhsPart <em>Rhs Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.RhsPart
	 * @generated
	 */
	public Adapter createRhsPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.RhsOperator <em>Rhs Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.RhsOperator
	 * @generated
	 */
	public Adapter createRhsOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.Arbitrary <em>Arbitrary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.Arbitrary
	 * @generated
	 */
	public Adapter createArbitraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.AtLeastOne <em>At Least One</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.AtLeastOne
	 * @generated
	 */
	public Adapter createAtLeastOneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.etsl.Optional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.etsl.Optional
	 * @generated
	 */
	public Adapter createOptionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EtslAdapterFactory
