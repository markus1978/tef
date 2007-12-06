/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import hub.sam.tef.modelcreating.IModelCreatingContext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.Syntax#getRules <em>Rules</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Syntax#getStart <em>Start</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Syntax#getPattern <em>Pattern</em>}</li>
 *   <li>{@link hub.sam.tef.tsl.Syntax#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.tef.tsl.TslPackage#getSyntax()
 * @model
 * @generated
 */
public interface Syntax extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.tef.tsl.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see hub.sam.tef.tsl.TslPackage#getSyntax_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(NonTerminal)
	 * @see hub.sam.tef.tsl.TslPackage#getSyntax_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NonTerminal getStart();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Syntax#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(NonTerminal value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.tef.tsl.Pattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference list.
	 * @see hub.sam.tef.tsl.TslPackage#getSyntax_Pattern()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pattern> getPattern();

	/**
	 * Returns the value of the '<em><b>Meta Model Platform URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Platform URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Platform URI</em>' attribute.
	 * @see #setMetaModelPlatformURI(String)
	 * @see hub.sam.tef.tsl.TslPackage#getSyntax_MetaModelPlatformURI()
	 * @model
	 * @generated
	 */
	String getMetaModelPlatformURI();

	/**
	 * Sets the value of the '{@link hub.sam.tef.tsl.Syntax#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Platform URI</em>' attribute.
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 */
	void setMetaModelPlatformURI(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="hub.sam.tef.tsl.RccSyntax" required="true" exceptions="hub.sam.tef.tsl.TslException"
	 * @generated
	 */
	hub.sam.tef.rcc.syntax.Syntax getRccSyntax() throws TslException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="hub.sam.tef.tsl.TslException" nonTerminalRequired="true"
	 * @generated
	 */
	EList<Rule> getRulesForNonTerminal(NonTerminal nonTerminal) throws TslException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="hub.sam.tef.tsl.TslException" rccRuleDataType="hub.sam.tef.tsl.RccRule" rccRuleRequired="true"
	 * @generated
	 */
	Rule getRuleForRccRule(hub.sam.tef.rcc.syntax.Rule rccRule) throws TslException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextDataType="hub.sam.tef.tsl.IModelCreatingContext" contextRequired="true"
	 * @generated
	 */
	void check(IModelCreatingContext context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="hub.sam.tef.tsl.TslException" nonTerminalRequired="true"
	 * @generated
	 */
	EList<Rule> getRulesForUsedNonTerminal(NonTerminal nonTerminal) throws TslException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextDataType="hub.sam.tef.tsl.IModelCreatingContext" contextRequired="true"
	 * @generated
	 */
	void replaceExtendedRules(IModelCreatingContext context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="hub.sam.tef.tsl.TslException" rootElementTypeRequired="true"
	 * @generated
	 */
	void reduceSyntax(EClass rootElementType) throws TslException;

} // Syntax
