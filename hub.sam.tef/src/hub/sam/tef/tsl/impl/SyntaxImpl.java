/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.Pattern;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.util.MultiMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Syntax</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.impl.SyntaxImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.SyntaxImpl#getStart <em>Start</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.SyntaxImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.impl.SyntaxImpl#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SyntaxImpl extends EObjectImpl implements Syntax {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected NonTerminal start;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<Pattern> pattern;

	/**
	 * The default value of the '{@link #getMetaModelPlatformURI() <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected static final String META_MODEL_PLATFORM_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModelPlatformURI() <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected String metaModelPlatformURI = META_MODEL_PLATFORM_URI_EDEFAULT;

	/**
	 * This symbol is used for an implicit top-level RCC rule: __start ::=
	 * <TEF-syntax start symbol>.
	 * 
	 * @see #getRCCSyntax().
	 */
	public final static String START_SYMBOL = "__start";	

	private Map<String, EList<Rule>> fRulesForUsedNonTerminal;
	private Map<String, EList<Rule>> fRules;
	private Map<String, Object> fImplicitRules;
	private boolean initialised = false;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SyntaxImpl() {
		super();	
	}
	
	@SuppressWarnings("unchecked")
	private void initialise() {
		if (initialised) {
			//return;
		}		
		
		MultiMap<String, Rule> rulesForUsedNonTerminal = new MultiMap<String, Rule>();
		MultiMap<String, Rule> rulesUnsorted = new MultiMap<String, Rule>() {
			@Override
			protected Collection<Rule> createCollection() {
				return new ArrayList<Rule>();
			}			
		};
		for (Rule rule: getRules()) {
			rulesUnsorted.put(rule.getLhs().getName(), rule);
			for (Symbol rhsPart: ((SimpleRule)rule).getRhs()) {
				if (rhsPart instanceof NonTerminal) {
					rulesForUsedNonTerminal.put(((NonTerminal)rhsPart).getName(), rule);
				}
			}
		}
		fRules = new HashMap<String, EList<Rule>>();		
		fRulesForUsedNonTerminal = new HashMap<String, EList<Rule>>();
		
		for (String key: rulesUnsorted.getKeys()) {
			Collection<Rule> rulesForKey = rulesUnsorted.get(key);
			Collections.sort((List)rulesForKey, new Comparator<Rule>() {
				@Override
				public int compare(Rule o1, Rule o2) {
					if (o1.getPriority() > o2.getPriority()) {
						return -1;
					} else if (o1.getPriority() < o2.getPriority()) {
						return 1;
					} else {
						return 0;
					}
				}				
			});
			fRules.put(key, new BasicEList<Rule>(rulesForKey));
		}			
		for (String key: rulesForUsedNonTerminal.getKeys()) {
			fRulesForUsedNonTerminal.put(key, new BasicEList<Rule>(rulesForUsedNonTerminal.get(key)));
		}
		
		fImplicitRules = new HashMap<String, Object>();
		for(PrimitiveTypeDescriptor primitiveTypeDescr: 
				PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
			fImplicitRules.put(primitiveTypeDescr.getNonTerminalName(), "");			
		}
		initialised = true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.SYNTAX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, TslPackage.SYNTAX__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonTerminal getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStart(NonTerminal newStart, NotificationChain msgs) {
		NonTerminal oldStart = start;
		start = newStart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TslPackage.SYNTAX__START, oldStart, newStart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(NonTerminal newStart) {
		if (newStart != start) {
			NotificationChain msgs = null;
			if (start != null)
				msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TslPackage.SYNTAX__START, null, msgs);
			if (newStart != null)
				msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TslPackage.SYNTAX__START, null, msgs);
			msgs = basicSetStart(newStart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.SYNTAX__START, newStart, newStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pattern> getPattern() {
		if (pattern == null) {
			pattern = new EObjectContainmentEList<Pattern>(Pattern.class, this, TslPackage.SYNTAX__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaModelPlatformURI() {
		return metaModelPlatformURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelPlatformURI(String newMetaModelPlatformURI) {
		String oldMetaModelPlatformURI = metaModelPlatformURI;
		metaModelPlatformURI = newMetaModelPlatformURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.SYNTAX__META_MODEL_PLATFORM_URI, oldMetaModelPlatformURI, metaModelPlatformURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * The RCC syntax that corresponds to the described TEF syntax contains all the
	 * rules of the TEF syntax, plus one additional rules declaring whitespaces, and 
	 * one rule as a "start" rule. This one is necessary, because RCC needs a "top-level"-rule
	 * that is a rule with a LHS not used on any RHS.
	 * 
	 * @return the corresponding RCC syntax.
	 * <!-- end-user-doc --> 
	 * @generated NOT
	 */
	public hub.sam.tef.rcc.syntax.Syntax getRccSyntax() {
		List<hub.sam.tef.rcc.syntax.Rule> rules = new ArrayList<hub.sam.tef.rcc.syntax.Rule>();		
		for (Rule rule: getRules()) {			
			rules.add((hub.sam.tef.rcc.syntax.Rule)rule.getRCCRule()); 			
		}
		rules.add(new hub.sam.tef.rcc.syntax.Rule(new String[] {"ignored", "`whitespaces`"}));
		rules.add(new hub.sam.tef.rcc.syntax.Rule(
				new String[] {START_SYMBOL, getStart().getRCCSymbol()}));
		hub.sam.tef.rcc.syntax.Syntax result = new hub.sam.tef.rcc.syntax.Syntax();
		result.appendRules(rules);		
		result.findStartRules();
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @return all rules with the given non terminal as lhs, sorted by their priority.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Rule> getRulesForNonTerminal(NonTerminal nonTerminal) {
		initialise();
		
		EList<Rule> result = fRules.get(nonTerminal.getName());
		if (result == null) {
			result = new BasicEList<Rule>();
		} 
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @return the TEF syntax rule for a given RCC syntax rule.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Rule getRuleForRccRule(hub.sam.tef.rcc.syntax.Rule rccRule) throws TslException {		
		initialise();		
		
		Collection<Rule> rulesForRccRule = fRules.get(rccRule.getNonterminal());
		if (rulesForRccRule != null) {
			for (Rule rule: rulesForRccRule) {
				if (rule.getRCCRule().equals(rccRule)) {
					return rule;
				}
			}
		}
		throw new TslException("Unexpected RCC rule, rule is not part of the syntax.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void check(ModelCreatingContext context) {
		if (!initialised) {
			initialise();
		}
		
		// check for used but not existing non terminals
		for(Rule rule: getRules()) {
			for(Symbol rhsPart: ((SimpleRule)rule).getRhs()) {
				if (rhsPart instanceof NonTerminal) {
					if ((getRulesForNonTerminal((NonTerminal)rhsPart).size() == 0) &&
							(fImplicitRules.get(((NonTerminal)rhsPart).getName()) == null)) {						
						context.addError(new ModelCheckError(
								"No rule for non terminal " + ((NonTerminal)rhsPart).getName() + ".", rhsPart));
					}
				}
			}
		}	
		for(List<Rule> rules: fRules.values()) {						
			if (rules.size() > 1) {
				for (int i = 0; i < rules.size(); i++) {
					Rule rule1 = rules.get(i);
					loop: for (int ii = i+1; ii < rules.size(); ii++) {
						Rule rule2 = rules.get(ii);
						int iii = 0;
						hub.sam.tef.rcc.syntax.Rule rccRule1 = rule1.getRCCRule();
						hub.sam.tef.rcc.syntax.Rule rccRule2 = rule2.getRCCRule();
						while ((rccRule1.rightSize() > iii) && (rccRule2.rightSize() > iii)) {
							if (!rccRule1.getRightSymbol(iii).equals(rccRule2.getRightSymbol(iii))) {
								continue loop;
							}
							iii++;
						}
						if (rule1.getPriority() == rule2.getPriority()) {
							context.addError(new ModelCheckError(
									"One rule is prefix of another without giving a priority.", rule1));
							context.addError(new ModelCheckError(									
									"One rule is prefix of another without giving a priority.", rule2));
						}						
					}
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Rule> getRulesForUsedNonTerminal(NonTerminal nonTerminal) {
		if (!initialised) {
			initialise();
		}
		EList<Rule> result = fRulesForUsedNonTerminal.get(nonTerminal.getName());
		if (result == null) {
			result = new BasicEList<Rule>();
		} 
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TslPackage.SYNTAX__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case TslPackage.SYNTAX__START:
				return basicSetStart(null, msgs);
			case TslPackage.SYNTAX__PATTERN:
				return ((InternalEList<?>)getPattern()).basicRemove(otherEnd, msgs);
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
			case TslPackage.SYNTAX__RULES:
				return getRules();
			case TslPackage.SYNTAX__START:
				return getStart();
			case TslPackage.SYNTAX__PATTERN:
				return getPattern();
			case TslPackage.SYNTAX__META_MODEL_PLATFORM_URI:
				return getMetaModelPlatformURI();
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
			case TslPackage.SYNTAX__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case TslPackage.SYNTAX__START:
				setStart((NonTerminal)newValue);
				return;
			case TslPackage.SYNTAX__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends Pattern>)newValue);
				return;
			case TslPackage.SYNTAX__META_MODEL_PLATFORM_URI:
				setMetaModelPlatformURI((String)newValue);
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
			case TslPackage.SYNTAX__RULES:
				getRules().clear();
				return;
			case TslPackage.SYNTAX__START:
				setStart((NonTerminal)null);
				return;
			case TslPackage.SYNTAX__PATTERN:
				getPattern().clear();
				return;
			case TslPackage.SYNTAX__META_MODEL_PLATFORM_URI:
				setMetaModelPlatformURI(META_MODEL_PLATFORM_URI_EDEFAULT);
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
			case TslPackage.SYNTAX__RULES:
				return rules != null && !rules.isEmpty();
			case TslPackage.SYNTAX__START:
				return start != null;
			case TslPackage.SYNTAX__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case TslPackage.SYNTAX__META_MODEL_PLATFORM_URI:
				return META_MODEL_PLATFORM_URI_EDEFAULT == null ? metaModelPlatformURI != null : !META_MODEL_PLATFORM_URI_EDEFAULT.equals(metaModelPlatformURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (metaModelPlatformURI: ");
		result.append(metaModelPlatformURI);
		result.append(')');
		return result.toString();
	}

} //SyntaxImpl
