/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl.impl;

import hub.sam.tef.etsl.Arbitrary;
import hub.sam.tef.etsl.AtLeastOne;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.etsl.ExtendedRule;
import hub.sam.tef.etsl.Optional;
import hub.sam.tef.etsl.Rhs;
import hub.sam.tef.etsl.RhsOperator;
import hub.sam.tef.etsl.RhsPart;
import hub.sam.tef.etsl.RhsSequence;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslFactory;
import hub.sam.tef.tsl.impl.RuleImpl;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.tef.etsl.impl.ExtendedRuleImpl#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedRuleImpl extends RuleImpl implements ExtendedRule {
	/**
	 * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhs()
	 * @generated
	 * @ordered
	 */
	protected Rhs rhs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtslPackage.Literals.EXTENDED_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rhs getRhs() {
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRhs(Rhs newRhs, NotificationChain msgs) {
		Rhs oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtslPackage.EXTENDED_RULE__RHS, oldRhs, newRhs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhs(Rhs newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtslPackage.EXTENDED_RULE__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtslPackage.EXTENDED_RULE__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtslPackage.EXTENDED_RULE__RHS, newRhs, newRhs));
	}	

	/**
	 * <!-- begin-user-doc --> This renders the rule unusable, because all the
	 * parts in this rule are transfered to the created simple rules. <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<SimpleRule> createSimpleRules() {
		EList<SimpleRule> result = new BasicEList<SimpleRule>();	
			
		SimpleRule mainRule = TslFactory.eINSTANCE.createSimpleRule();
		result.add(mainRule);
		mainRule.setLhs(getLhs());
		mainRule.setPriority(getPriority());
		mainRule.setValueBinding(getValueBinding());
		createSimpleRuleRhs(getRhs(), mainRule.getRhs(), result, 
				new UniqueNonTerminalFactory(mainRule.getLhs().getName()));
		
		return result;
	}	
	
	/**
	 * Allows to create non terminal names that are guaranteed to not be used
	 * otherwise.
	 * @generated NOT
	 */
	private static class UniqueNonTerminalFactory {
		private static int unique = 0;
		private String prefix;		
		public UniqueNonTerminalFactory(String prefix) {
			super();
			this.prefix = prefix;
		}
		String getUniqueNonTerminal(String key) {
			return prefix + "__" + key + "_" + unique++;
		}		
	}
	
	/**
	 * Resets the unique part of all implicit symbol names. This should be called before
	 * the implicit rules for a syntax are created to ensure that these symbols always
	 * get the same names.
	 * @generated NOT
	 */
	public static void resetImplicitRuleUnique() {
		UniqueNonTerminalFactory.unique = 0;
	}
	
	/**
	 * Takes the RHS of an extended rule and creates the RHS of a simple rule.
	 * It also creates additional necessary simple rules on the fly.
	 * 
	 * @param rhs
	 *            the extended rule RHS.
	 * @param simpleRuleRhs
	 *            the simple rule RHS. The created RHS parts are added to this
	 *            list.
	 * @param rules
	 *            a list for additional rules. Rules that get created on the fly
	 *            will be added to this list.
	 * @param unique
	 *            a unique non terminal factory that creates new non terminal
	 *            used for additional rules.
	 * @generated NOT
	 */
	private void createSimpleRuleRhs(Rhs rhs, EList<Symbol> simpleRuleRhs, 
			List<SimpleRule> rules, UniqueNonTerminalFactory unique) {		
		if (rhs == null) {
			return; // do nothing, the rule stays empty
		} else if (rhs instanceof RhsPart) {
			Symbol symbol = ((RhsPart)rhs).getSymbol();
			simpleRuleRhs.add(symbol);
		} else if (rhs instanceof RhsSequence) {
			for (Rhs sequencePart: ((RhsSequence)rhs).getParts()) {
				createSimpleRuleRhs(sequencePart, simpleRuleRhs, rules, unique);
			}
		} else if (rhs instanceof RhsOperator) {
			if (rhs instanceof Arbitrary) {
				// takes ( A B C )* and creates
				// __Arbitrary_ -> A B C __Arbitrary ;
				// __Arbitrary_ -> ;
				// and adds __Arbitrary to the simpleRuleRhs
				String arbitraryNonTerminal = unique.getUniqueNonTerminal("Arbitrary");
				
				SimpleRule tailRule = TslFactory.eINSTANCE.createSimpleRule();				
				rules.add(tailRule);				
				createSimpleRuleRhs(((Arbitrary)rhs).getOperand(), tailRule.getRhs(), rules, unique);
				NonTerminal tailRuleTailRhs = TslFactory.eINSTANCE.createNonTerminal();
				tailRuleTailRhs.setName(arbitraryNonTerminal);
				tailRule.getRhs().add(tailRuleTailRhs);				
				tailRule.setPriority(1);
				NonTerminal tailRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				tailRuleLhs.setName(arbitraryNonTerminal);
				tailRule.setLhs(tailRuleLhs);
				
				SimpleRule headRule = TslFactory.eINSTANCE.createSimpleRule();
				rules.add(headRule);
				headRule.setPriority(0);
				NonTerminal headRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				headRuleLhs.setName(arbitraryNonTerminal);
				headRule.setLhs(headRuleLhs);
				
				NonTerminal arbitraryRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				arbitraryRuleLhs.setName(arbitraryNonTerminal);
				simpleRuleRhs.add(arbitraryRuleLhs);
			} else if (rhs instanceof AtLeastOne) {
				// takes ( A B C )+ and creates
				// __AtLeastOne_ -> __AtLeastOneParts __AtLeastOne ;
				// __AtLeastOne_ -> __AtLeastOneParts;
				// __AtLeastOneParts_ -> A B C
				// and adds __AtLeastOne_ to the simpleRuleRhs
				String atLeastOnePartsNonTerminal = unique.getUniqueNonTerminal("AtLeastOneParts");
				String atLeastOneNonTerminal = unique.getUniqueNonTerminal("AtLeastOne");
				
				SimpleRule partsRule = TslFactory.eINSTANCE.createSimpleRule();
				rules.add(partsRule);				
				NonTerminal partsRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				partsRuleLhs.setName(atLeastOnePartsNonTerminal);
				partsRule.setLhs(partsRuleLhs);
				createSimpleRuleRhs(((AtLeastOne)rhs).getOperand(), partsRule.getRhs(), rules, unique);
								
				SimpleRule tailRule = TslFactory.eINSTANCE.createSimpleRule();				
				rules.add(tailRule);				
				NonTerminal tailRulePartsRhs = TslFactory.eINSTANCE.createNonTerminal();
				tailRulePartsRhs.setName(atLeastOnePartsNonTerminal);
				tailRule.getRhs().add(tailRulePartsRhs);
				NonTerminal tailRuleTailRhs = TslFactory.eINSTANCE.createNonTerminal();
				tailRuleTailRhs.setName(atLeastOneNonTerminal);
				tailRule.getRhs().add(tailRuleTailRhs);				
				tailRule.setPriority(1);
				NonTerminal tailRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				tailRuleLhs.setName(atLeastOneNonTerminal);
				tailRule.setLhs(tailRuleLhs);
				
				SimpleRule headRule = TslFactory.eINSTANCE.createSimpleRule();
				rules.add(headRule);
				headRule.setPriority(0);
				NonTerminal headRulePartsRhs = TslFactory.eINSTANCE.createNonTerminal();
				headRulePartsRhs.setName(atLeastOnePartsNonTerminal);
				headRule.getRhs().add(headRulePartsRhs);
				NonTerminal headRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				headRuleLhs.setName(atLeastOneNonTerminal);
				headRule.setLhs(headRuleLhs);
				
				NonTerminal arbitraryRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				arbitraryRuleLhs.setName(atLeastOneNonTerminal);
				simpleRuleRhs.add(arbitraryRuleLhs);
			} else if (rhs instanceof Optional) {
				// takes ( A B C )? and creates
				// __Optional_ -> A B C ;
				// __Optional_ -> ;
				// and adds __Optional_ to the simpleRuleRhs
				String optionalNonTerminal = unique.getUniqueNonTerminal("Optional");
				
				SimpleRule positiveRule = TslFactory.eINSTANCE.createSimpleRule();							
				createSimpleRuleRhs(((Optional)rhs).getOperand(), positiveRule.getRhs(), rules, unique);				
				positiveRule.setPriority(1);
				NonTerminal positiveRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				positiveRuleLhs.setName(optionalNonTerminal);
				positiveRule.setLhs(positiveRuleLhs);
				rules.add(positiveRule);
				
				SimpleRule negativeRule = TslFactory.eINSTANCE.createSimpleRule();				
				negativeRule.setPriority(0);
				NonTerminal negativeRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				negativeRuleLhs.setName(optionalNonTerminal);
				negativeRule.setLhs(negativeRuleLhs);
				rules.add(negativeRule);

				NonTerminal optionalRuleLhs = TslFactory.eINSTANCE.createNonTerminal();
				optionalRuleLhs.setName(optionalNonTerminal);
				simpleRuleRhs.add(optionalRuleLhs);
			} else {
				Assert.isTrue(false, "supposed unreachable");
			}
		} else {
			Assert.isTrue(false, "supposed unreachable");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtslPackage.EXTENDED_RULE__RHS:
				return basicSetRhs(null, msgs);
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
			case EtslPackage.EXTENDED_RULE__RHS:
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EtslPackage.EXTENDED_RULE__RHS:
				setRhs((Rhs)newValue);
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
			case EtslPackage.EXTENDED_RULE__RHS:
				setRhs((Rhs)null);
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
			case EtslPackage.EXTENDED_RULE__RHS:
				return rhs != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Rule getRCCRule() {
		Assert.isTrue(false, "supposed unreachable");
		return null;
	}	

} //ExtendedRuleImpl
