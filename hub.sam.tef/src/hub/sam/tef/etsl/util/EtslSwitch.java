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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hub.sam.tef.etsl.EtslPackage
 * @generated
 */
public class EtslSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EtslPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtslSwitch() {
		if (modelPackage == null) {
			modelPackage = EtslPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EtslPackage.EXTENDED_RULE: {
				ExtendedRule extendedRule = (ExtendedRule)theEObject;
				T result = caseExtendedRule(extendedRule);
				if (result == null) result = caseRule(extendedRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.RHS: {
				Rhs rhs = (Rhs)theEObject;
				T result = caseRhs(rhs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.RHS_SEQUENCE: {
				RhsSequence rhsSequence = (RhsSequence)theEObject;
				T result = caseRhsSequence(rhsSequence);
				if (result == null) result = caseRhs(rhsSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.RHS_PART: {
				RhsPart rhsPart = (RhsPart)theEObject;
				T result = caseRhsPart(rhsPart);
				if (result == null) result = caseRhs(rhsPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.RHS_OPERATOR: {
				RhsOperator rhsOperator = (RhsOperator)theEObject;
				T result = caseRhsOperator(rhsOperator);
				if (result == null) result = caseRhs(rhsOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.ARBITRARY: {
				Arbitrary arbitrary = (Arbitrary)theEObject;
				T result = caseArbitrary(arbitrary);
				if (result == null) result = caseRhsOperator(arbitrary);
				if (result == null) result = caseRhs(arbitrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.AT_LEAST_ONE: {
				AtLeastOne atLeastOne = (AtLeastOne)theEObject;
				T result = caseAtLeastOne(atLeastOne);
				if (result == null) result = caseRhsOperator(atLeastOne);
				if (result == null) result = caseRhs(atLeastOne);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EtslPackage.OPTIONAL: {
				Optional optional = (Optional)theEObject;
				T result = caseOptional(optional);
				if (result == null) result = caseRhsOperator(optional);
				if (result == null) result = caseRhs(optional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedRule(ExtendedRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rhs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rhs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRhs(Rhs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rhs Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rhs Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRhsSequence(RhsSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rhs Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rhs Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRhsPart(RhsPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rhs Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rhs Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRhsOperator(RhsOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arbitrary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arbitrary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArbitrary(Arbitrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>At Least One</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>At Least One</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtLeastOne(AtLeastOne object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptional(Optional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EtslSwitch
