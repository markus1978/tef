/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.tsl.WhiteSpace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.impl.RuleImpl#getRhs <em>Rhs</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.RuleImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.RuleImpl#getValueBinding <em>Value Binding</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.RuleImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends EObjectImpl implements Rule {
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
	 * The cached value of the '{@link #getLhs() <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLhs()
	 * @generated
	 * @ordered
	 */
	protected NonTerminal lhs;

	/**
	 * The cached value of the '{@link #getValueBinding() <em>Value Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueBinding()
	 * @generated
	 * @ordered
	 */
	protected ValueBinding valueBinding;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Symbol> getRhs() {
		if (rhs == null) {
			rhs = new EObjectContainmentEList<Symbol>(Symbol.class, this, TslPackage.RULE__RHS);
		}
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonTerminal getLhs() {
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLhs(NonTerminal newLhs, NotificationChain msgs) {
		NonTerminal oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TslPackage.RULE__LHS, oldLhs, newLhs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLhs(NonTerminal newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TslPackage.RULE__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TslPackage.RULE__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.RULE__LHS, newLhs, newLhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueBinding getValueBinding() {
		return valueBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueBinding(ValueBinding newValueBinding, NotificationChain msgs) {
		ValueBinding oldValueBinding = valueBinding;
		valueBinding = newValueBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TslPackage.RULE__VALUE_BINDING, oldValueBinding, newValueBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueBinding(ValueBinding newValueBinding) {
		if (newValueBinding != valueBinding) {
			NotificationChain msgs = null;
			if (valueBinding != null)
				msgs = ((InternalEObject)valueBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TslPackage.RULE__VALUE_BINDING, null, msgs);
			if (newValueBinding != null)
				msgs = ((InternalEObject)newValueBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TslPackage.RULE__VALUE_BINDING, null, msgs);
			msgs = basicSetValueBinding(newValueBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.RULE__VALUE_BINDING, newValueBinding, newValueBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.RULE__PRIORITY, oldPriority, priority));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TslPackage.RULE__RHS:
				return ((InternalEList<?>)getRhs()).basicRemove(otherEnd, msgs);
			case TslPackage.RULE__LHS:
				return basicSetLhs(null, msgs);
			case TslPackage.RULE__VALUE_BINDING:
				return basicSetValueBinding(null, msgs);
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
			case TslPackage.RULE__RHS:
				return getRhs();
			case TslPackage.RULE__LHS:
				return getLhs();
			case TslPackage.RULE__VALUE_BINDING:
				return getValueBinding();
			case TslPackage.RULE__PRIORITY:
				return new Integer(getPriority());
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
			case TslPackage.RULE__RHS:
				getRhs().clear();
				getRhs().addAll((Collection<? extends Symbol>)newValue);
				return;
			case TslPackage.RULE__LHS:
				setLhs((NonTerminal)newValue);
				return;
			case TslPackage.RULE__VALUE_BINDING:
				setValueBinding((ValueBinding)newValue);
				return;
			case TslPackage.RULE__PRIORITY:
				setPriority(((Integer)newValue).intValue());
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
			case TslPackage.RULE__RHS:
				getRhs().clear();
				return;
			case TslPackage.RULE__LHS:
				setLhs((NonTerminal)null);
				return;
			case TslPackage.RULE__VALUE_BINDING:
				setValueBinding((ValueBinding)null);
				return;
			case TslPackage.RULE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
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
			case TslPackage.RULE__RHS:
				return rhs != null && !rhs.isEmpty();
			case TslPackage.RULE__LHS:
				return lhs != null;
			case TslPackage.RULE__VALUE_BINDING:
				return valueBinding != null;
			case TslPackage.RULE__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(getLhs().toString());
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
} //RuleImpl
