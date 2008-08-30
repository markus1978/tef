/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tsl.WhiteSpace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.impl.SimpleRuleImpl#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleRuleImpl extends RuleImpl implements SimpleRule {
	/**
	 * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhs()
	 * @generated
	 * @ordered
	 */
	protected EList<Symbol> rhs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.SIMPLE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Symbol> getRhs() {
		if (rhs == null) {
			rhs = new EObjectContainmentEList<Symbol>(Symbol.class, this, TslPackage.SIMPLE_RULE__RHS);
		}
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TslPackage.SIMPLE_RULE__RHS:
				return ((InternalEList<?>)getRhs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TslPackage.SIMPLE_RULE__RHS:
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TslPackage.SIMPLE_RULE__RHS:
				getRhs().clear();
				getRhs().addAll((Collection<? extends Symbol>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TslPackage.SIMPLE_RULE__RHS:
				getRhs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TslPackage.SIMPLE_RULE__RHS:
				return rhs != null && !rhs.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public hub.sam.tef.rcc.syntax.Rule getRCCRule() {
		List<String> result = new ArrayList<String>();
		result.add(getLhs().getRCCSymbol());
		for (Symbol rhsPart: getRhs()) {
			if (!(rhsPart instanceof WhiteSpace)) {
				result.add(rhsPart.getRCCSymbol());
			}
		}
		return new hub.sam.tef.rcc.syntax.Rule(
				result.toArray(new String[] {}));
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		if (getLhs() != null)
			result.append(getLhs().toString());
		else
			result.append("<empty LHS>");
		ValueBinding valueBinding = getValueBinding();
		if (valueBinding != null) {
			result.append(":");
			result.append(valueBinding.toString());
		}
		int priority = getPriority();
		if (priority > 0) {
			result.append(" [");
			result.append(priority);
			result.append("]");
		}
		result.append(" ->");
		for (Symbol rhsPart: getRhs()) {
			result.append(" ");
			result.append(rhsPart.toString());			
		}
		result.append(" ;");
		return result.toString();
	}

} //SimpleRuleImpl
