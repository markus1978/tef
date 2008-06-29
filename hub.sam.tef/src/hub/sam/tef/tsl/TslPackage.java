/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see hub.sam.tef.tsl.TslFactory
 * @model kind="package"
 * @generated
 */
public interface TslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tsl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.hu-berlin.de/sam/meta-tools/tef/tsl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TslPackage eINSTANCE = hub.sam.tef.tsl.impl.TslPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.SyntaxImpl <em>Syntax</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.SyntaxImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSyntax()
	 * @generated
	 */
	int SYNTAX = 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX__RULES = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX__START = 1;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX__PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Meta Model Platform URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX__META_MODEL_PLATFORM_URI = 3;

	/**
	 * The number of structural features of the '<em>Syntax</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.RuleImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LHS = 0;

	/**
	 * The feature id for the '<em><b>Value Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__VALUE_BINDING = 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PRIORITY = 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.SimpleRuleImpl <em>Simple Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.SimpleRuleImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSimpleRule()
	 * @generated
	 */
	int SIMPLE_RULE = 2;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_RULE__LHS = RULE__LHS;

	/**
	 * The feature id for the '<em><b>Value Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_RULE__VALUE_BINDING = RULE__VALUE_BINDING;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_RULE__PRIORITY = RULE__PRIORITY;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_RULE__RHS = RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.SymbolImpl <em>Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.SymbolImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSymbol()
	 * @generated
	 */
	int SYMBOL = 3;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__PROPERTY_BINDING = 0;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL__ACTION_BINDING = 1;

	/**
	 * The number of structural features of the '<em>Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.NonTerminalImpl <em>Non Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.NonTerminalImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getNonTerminal()
	 * @generated
	 */
	int NON_TERMINAL = 4;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__PROPERTY_BINDING = SYMBOL__PROPERTY_BINDING;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__ACTION_BINDING = SYMBOL__ACTION_BINDING;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__NAME = SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Non Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL_FEATURE_COUNT = SYMBOL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.TerminalImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 5;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__PROPERTY_BINDING = SYMBOL__PROPERTY_BINDING;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__ACTION_BINDING = SYMBOL__ACTION_BINDING;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.FixTerminalImpl <em>Fix Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.FixTerminalImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getFixTerminal()
	 * @generated
	 */
	int FIX_TERMINAL = 6;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_TERMINAL__PROPERTY_BINDING = TERMINAL__PROPERTY_BINDING;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_TERMINAL__ACTION_BINDING = TERMINAL__ACTION_BINDING;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_TERMINAL__TERMINAL = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fix Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIX_TERMINAL_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.PatternTerminalImpl <em>Pattern Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.PatternTerminalImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPatternTerminal()
	 * @generated
	 */
	int PATTERN_TERMINAL = 7;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TERMINAL__PROPERTY_BINDING = TERMINAL__PROPERTY_BINDING;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TERMINAL__ACTION_BINDING = TERMINAL__ACTION_BINDING;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TERMINAL__PATTERN = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TERMINAL_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.WhiteSpaceImpl <em>White Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.WhiteSpaceImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getWhiteSpace()
	 * @generated
	 */
	int WHITE_SPACE = 8;

	/**
	 * The feature id for the '<em><b>Property Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACE__PROPERTY_BINDING = TERMINAL__PROPERTY_BINDING;

	/**
	 * The feature id for the '<em><b>Action Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACE__ACTION_BINDING = TERMINAL__ACTION_BINDING;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACE__ROLE = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>White Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACE_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.PatternImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 9;

	/**
	 * The feature id for the '<em><b>Rcc Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__RCC_SYMBOL = 0;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.BindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 10;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BINDING_ID = 0;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ValueBindingImpl <em>Value Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ValueBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getValueBinding()
	 * @generated
	 */
	int VALUE_BINDING = 11;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__BINDING_ID = BINDING__BINDING_ID;

	/**
	 * The number of structural features of the '<em>Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ElementBindingImpl <em>Element Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ElementBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getElementBinding()
	 * @generated
	 */
	int ELEMENT_BINDING = 12;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BINDING__BINDING_ID = VALUE_BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BINDING__METACLASS = VALUE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_BINDING_FEATURE_COUNT = VALUE_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ElementReferenceBindingImpl <em>Element Reference Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ElementReferenceBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getElementReferenceBinding()
	 * @generated
	 */
	int ELEMENT_REFERENCE_BINDING = 13;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_BINDING__BINDING_ID = ELEMENT_BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_BINDING__METACLASS = ELEMENT_BINDING__METACLASS;

	/**
	 * The number of structural features of the '<em>Element Reference Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_BINDING_FEATURE_COUNT = ELEMENT_BINDING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.PrimitiveBindingImpl <em>Primitive Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.PrimitiveBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPrimitiveBinding()
	 * @generated
	 */
	int PRIMITIVE_BINDING = 14;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BINDING__BINDING_ID = VALUE_BINDING__BINDING_ID;

	/**
	 * The number of structural features of the '<em>Primitive Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BINDING_FEATURE_COUNT = VALUE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.PropertyBindingImpl <em>Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.PropertyBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPropertyBinding()
	 * @generated
	 */
	int PROPERTY_BINDING = 16;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.CompositeBindingImpl <em>Composite Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.CompositeBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getCompositeBinding()
	 * @generated
	 */
	int COMPOSITE_BINDING = 17;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ReferenceBindingImpl <em>Reference Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ReferenceBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getReferenceBinding()
	 * @generated
	 */
	int REFERENCE_BINDING = 18;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ConstantBindingImpl <em>Constant Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ConstantBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getConstantBinding()
	 * @generated
	 */
	int CONSTANT_BINDING = 15;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING__BINDING_ID = VALUE_BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING__VALUE = VALUE_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING__TYPE = VALUE_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constant Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BINDING_FEATURE_COUNT = VALUE_BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING__BINDING_ID = BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING__PROPERTY = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING__DEFAULT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BINDING__BINDING_ID = PROPERTY_BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BINDING__PROPERTY = PROPERTY_BINDING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BINDING__DEFAULT = PROPERTY_BINDING__DEFAULT;

	/**
	 * The number of structural features of the '<em>Composite Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BINDING_FEATURE_COUNT = PROPERTY_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BINDING__BINDING_ID = PROPERTY_BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BINDING__PROPERTY = PROPERTY_BINDING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BINDING__DEFAULT = PROPERTY_BINDING__DEFAULT;

	/**
	 * The number of structural features of the '<em>Reference Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BINDING_FEATURE_COUNT = PROPERTY_BINDING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.ActionBindingImpl <em>Action Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.ActionBindingImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getActionBinding()
	 * @generated
	 */
	int ACTION_BINDING = 19;

	/**
	 * The feature id for the '<em><b>Binding Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BINDING__BINDING_ID = BINDING__BINDING_ID;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BINDING__STATEMENTS = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.tef.tsl.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.impl.StatementImpl
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 20;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__METHOD_NAME = 0;

	/**
	 * The feature id for the '<em><b>Method Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__METHOD_PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Rcc Syntax</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.rcc.syntax.Syntax
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRccSyntax()
	 * @generated
	 */
	int RCC_SYNTAX = 21;

	/**
	 * The meta object id for the '<em>Rcc Rule</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.rcc.syntax.Rule
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRccRule()
	 * @generated
	 */
	int RCC_RULE = 22;

	/**
	 * The meta object id for the '<em>IModel Creating Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.modelcreating.IModelCreatingContext
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getIModelCreatingContext()
	 * @generated
	 */
	int IMODEL_CREATING_CONTEXT = 23;

	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.tef.tsl.TslException
	 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getTslException()
	 * @generated
	 */
	int TSL_EXCEPTION = 24;

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Syntax <em>Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax</em>'.
	 * @see hub.sam.tef.tsl.Syntax
	 * @generated
	 */
	EClass getSyntax();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.tef.tsl.Syntax#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see hub.sam.tef.tsl.Syntax#getRules()
	 * @see #getSyntax()
	 * @generated
	 */
	EReference getSyntax_Rules();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.tsl.Syntax#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see hub.sam.tef.tsl.Syntax#getStart()
	 * @see #getSyntax()
	 * @generated
	 */
	EReference getSyntax_Start();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.tef.tsl.Syntax#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pattern</em>'.
	 * @see hub.sam.tef.tsl.Syntax#getPattern()
	 * @see #getSyntax()
	 * @generated
	 */
	EReference getSyntax_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.Syntax#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Model Platform URI</em>'.
	 * @see hub.sam.tef.tsl.Syntax#getMetaModelPlatformURI()
	 * @see #getSyntax()
	 * @generated
	 */
	EAttribute getSyntax_MetaModelPlatformURI();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see hub.sam.tef.tsl.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.tsl.Rule#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see hub.sam.tef.tsl.Rule#getLhs()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.tsl.Rule#getValueBinding <em>Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Binding</em>'.
	 * @see hub.sam.tef.tsl.Rule#getValueBinding()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_ValueBinding();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.Rule#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see hub.sam.tef.tsl.Rule#getPriority()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Priority();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.SimpleRule <em>Simple Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Rule</em>'.
	 * @see hub.sam.tef.tsl.SimpleRule
	 * @generated
	 */
	EClass getSimpleRule();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.tef.tsl.SimpleRule#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rhs</em>'.
	 * @see hub.sam.tef.tsl.SimpleRule#getRhs()
	 * @see #getSimpleRule()
	 * @generated
	 */
	EReference getSimpleRule_Rhs();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol</em>'.
	 * @see hub.sam.tef.tsl.Symbol
	 * @generated
	 */
	EClass getSymbol();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.tsl.Symbol#getPropertyBinding <em>Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Binding</em>'.
	 * @see hub.sam.tef.tsl.Symbol#getPropertyBinding()
	 * @see #getSymbol()
	 * @generated
	 */
	EReference getSymbol_PropertyBinding();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.tef.tsl.Symbol#getActionBinding <em>Action Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action Binding</em>'.
	 * @see hub.sam.tef.tsl.Symbol#getActionBinding()
	 * @see #getSymbol()
	 * @generated
	 */
	EReference getSymbol_ActionBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.NonTerminal <em>Non Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Terminal</em>'.
	 * @see hub.sam.tef.tsl.NonTerminal
	 * @generated
	 */
	EClass getNonTerminal();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.NonTerminal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.tef.tsl.NonTerminal#getName()
	 * @see #getNonTerminal()
	 * @generated
	 */
	EAttribute getNonTerminal_Name();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see hub.sam.tef.tsl.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.FixTerminal <em>Fix Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fix Terminal</em>'.
	 * @see hub.sam.tef.tsl.FixTerminal
	 * @generated
	 */
	EClass getFixTerminal();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.FixTerminal#getTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see hub.sam.tef.tsl.FixTerminal#getTerminal()
	 * @see #getFixTerminal()
	 * @generated
	 */
	EAttribute getFixTerminal_Terminal();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.PatternTerminal <em>Pattern Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Terminal</em>'.
	 * @see hub.sam.tef.tsl.PatternTerminal
	 * @generated
	 */
	EClass getPatternTerminal();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.tef.tsl.PatternTerminal#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pattern</em>'.
	 * @see hub.sam.tef.tsl.PatternTerminal#getPattern()
	 * @see #getPatternTerminal()
	 * @generated
	 */
	EReference getPatternTerminal_Pattern();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.WhiteSpace <em>White Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>White Space</em>'.
	 * @see hub.sam.tef.tsl.WhiteSpace
	 * @generated
	 */
	EClass getWhiteSpace();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.WhiteSpace#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see hub.sam.tef.tsl.WhiteSpace#getRole()
	 * @see #getWhiteSpace()
	 * @generated
	 */
	EAttribute getWhiteSpace_Role();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see hub.sam.tef.tsl.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.Pattern#getRccSymbol <em>Rcc Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rcc Symbol</em>'.
	 * @see hub.sam.tef.tsl.Pattern#getRccSymbol()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_RccSymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see hub.sam.tef.tsl.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.Binding#getBindingId <em>Binding Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding Id</em>'.
	 * @see hub.sam.tef.tsl.Binding#getBindingId()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_BindingId();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ValueBinding <em>Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Binding</em>'.
	 * @see hub.sam.tef.tsl.ValueBinding
	 * @generated
	 */
	EClass getValueBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ElementBinding <em>Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Binding</em>'.
	 * @see hub.sam.tef.tsl.ElementBinding
	 * @generated
	 */
	EClass getElementBinding();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.tef.tsl.ElementBinding#getMetaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass</em>'.
	 * @see hub.sam.tef.tsl.ElementBinding#getMetaclass()
	 * @see #getElementBinding()
	 * @generated
	 */
	EReference getElementBinding_Metaclass();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ElementReferenceBinding <em>Element Reference Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Reference Binding</em>'.
	 * @see hub.sam.tef.tsl.ElementReferenceBinding
	 * @generated
	 */
	EClass getElementReferenceBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.PrimitiveBinding <em>Primitive Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Binding</em>'.
	 * @see hub.sam.tef.tsl.PrimitiveBinding
	 * @generated
	 */
	EClass getPrimitiveBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.PropertyBinding <em>Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Binding</em>'.
	 * @see hub.sam.tef.tsl.PropertyBinding
	 * @generated
	 */
	EClass getPropertyBinding();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.tef.tsl.PropertyBinding#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see hub.sam.tef.tsl.PropertyBinding#getProperty()
	 * @see #getPropertyBinding()
	 * @generated
	 */
	EReference getPropertyBinding_Property();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.PropertyBinding#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see hub.sam.tef.tsl.PropertyBinding#getDefault()
	 * @see #getPropertyBinding()
	 * @generated
	 */
	EAttribute getPropertyBinding_Default();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.CompositeBinding <em>Composite Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Binding</em>'.
	 * @see hub.sam.tef.tsl.CompositeBinding
	 * @generated
	 */
	EClass getCompositeBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ReferenceBinding <em>Reference Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Binding</em>'.
	 * @see hub.sam.tef.tsl.ReferenceBinding
	 * @generated
	 */
	EClass getReferenceBinding();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ActionBinding <em>Action Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Binding</em>'.
	 * @see hub.sam.tef.tsl.ActionBinding
	 * @generated
	 */
	EClass getActionBinding();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.tef.tsl.ActionBinding#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see hub.sam.tef.tsl.ActionBinding#getStatements()
	 * @see #getActionBinding()
	 * @generated
	 */
	EReference getActionBinding_Statements();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see hub.sam.tef.tsl.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.Statement#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see hub.sam.tef.tsl.Statement#getMethodName()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_MethodName();

	/**
	 * Returns the meta object for the attribute list '{@link hub.sam.tef.tsl.Statement#getMethodParameters <em>Method Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Method Parameters</em>'.
	 * @see hub.sam.tef.tsl.Statement#getMethodParameters()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_MethodParameters();

	/**
	 * Returns the meta object for class '{@link hub.sam.tef.tsl.ConstantBinding <em>Constant Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Binding</em>'.
	 * @see hub.sam.tef.tsl.ConstantBinding
	 * @generated
	 */
	EClass getConstantBinding();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.ConstantBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.tef.tsl.ConstantBinding#getValue()
	 * @see #getConstantBinding()
	 * @generated
	 */
	EAttribute getConstantBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.tef.tsl.ConstantBinding#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see hub.sam.tef.tsl.ConstantBinding#getType()
	 * @see #getConstantBinding()
	 * @generated
	 */
	EAttribute getConstantBinding_Type();

	/**
	 * Returns the meta object for data type '{@link hub.sam.tef.rcc.syntax.Syntax <em>Rcc Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rcc Syntax</em>'.
	 * @see hub.sam.tef.rcc.syntax.Syntax
	 * @model instanceClass="hub.sam.tef.rcc.syntax.Syntax" serializeable="false"
	 * @generated
	 */
	EDataType getRccSyntax();

	/**
	 * Returns the meta object for data type '{@link hub.sam.tef.rcc.syntax.Rule <em>Rcc Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rcc Rule</em>'.
	 * @see hub.sam.tef.rcc.syntax.Rule
	 * @model instanceClass="hub.sam.tef.rcc.syntax.Rule" serializeable="false"
	 * @generated
	 */
	EDataType getRccRule();

	/**
	 * Returns the meta object for data type '{@link hub.sam.tef.modelcreating.IModelCreatingContext <em>IModel Creating Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IModel Creating Context</em>'.
	 * @see hub.sam.tef.modelcreating.IModelCreatingContext
	 * @model instanceClass="hub.sam.tef.modelcreating.IModelCreatingContext"
	 * @generated
	 */
	EDataType getIModelCreatingContext();

	/**
	 * Returns the meta object for data type '{@link hub.sam.tef.tsl.TslException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see hub.sam.tef.tsl.TslException
	 * @model instanceClass="hub.sam.tef.tsl.TslException"
	 * @generated
	 */
	EDataType getTslException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TslFactory getTslFactory();

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
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.SyntaxImpl <em>Syntax</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.SyntaxImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSyntax()
		 * @generated
		 */
		EClass SYNTAX = eINSTANCE.getSyntax();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX__RULES = eINSTANCE.getSyntax_Rules();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX__START = eINSTANCE.getSyntax_Start();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX__PATTERN = eINSTANCE.getSyntax_Pattern();

		/**
		 * The meta object literal for the '<em><b>Meta Model Platform URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNTAX__META_MODEL_PLATFORM_URI = eINSTANCE.getSyntax_MetaModelPlatformURI();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.RuleImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__LHS = eINSTANCE.getRule_Lhs();

		/**
		 * The meta object literal for the '<em><b>Value Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__VALUE_BINDING = eINSTANCE.getRule_ValueBinding();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__PRIORITY = eINSTANCE.getRule_Priority();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.SimpleRuleImpl <em>Simple Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.SimpleRuleImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSimpleRule()
		 * @generated
		 */
		EClass SIMPLE_RULE = eINSTANCE.getSimpleRule();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_RULE__RHS = eINSTANCE.getSimpleRule_Rhs();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.SymbolImpl <em>Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.SymbolImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getSymbol()
		 * @generated
		 */
		EClass SYMBOL = eINSTANCE.getSymbol();

		/**
		 * The meta object literal for the '<em><b>Property Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOL__PROPERTY_BINDING = eINSTANCE.getSymbol_PropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Action Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOL__ACTION_BINDING = eINSTANCE.getSymbol_ActionBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.NonTerminalImpl <em>Non Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.NonTerminalImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getNonTerminal()
		 * @generated
		 */
		EClass NON_TERMINAL = eINSTANCE.getNonTerminal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NON_TERMINAL__NAME = eINSTANCE.getNonTerminal_Name();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.TerminalImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.FixTerminalImpl <em>Fix Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.FixTerminalImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getFixTerminal()
		 * @generated
		 */
		EClass FIX_TERMINAL = eINSTANCE.getFixTerminal();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIX_TERMINAL__TERMINAL = eINSTANCE.getFixTerminal_Terminal();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.PatternTerminalImpl <em>Pattern Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.PatternTerminalImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPatternTerminal()
		 * @generated
		 */
		EClass PATTERN_TERMINAL = eINSTANCE.getPatternTerminal();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_TERMINAL__PATTERN = eINSTANCE.getPatternTerminal_Pattern();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.WhiteSpaceImpl <em>White Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.WhiteSpaceImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getWhiteSpace()
		 * @generated
		 */
		EClass WHITE_SPACE = eINSTANCE.getWhiteSpace();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHITE_SPACE__ROLE = eINSTANCE.getWhiteSpace_Role();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.PatternImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Rcc Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__RCC_SYMBOL = eINSTANCE.getPattern_RccSymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.BindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Binding Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__BINDING_ID = eINSTANCE.getBinding_BindingId();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ValueBindingImpl <em>Value Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ValueBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getValueBinding()
		 * @generated
		 */
		EClass VALUE_BINDING = eINSTANCE.getValueBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ElementBindingImpl <em>Element Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ElementBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getElementBinding()
		 * @generated
		 */
		EClass ELEMENT_BINDING = eINSTANCE.getElementBinding();

		/**
		 * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_BINDING__METACLASS = eINSTANCE.getElementBinding_Metaclass();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ElementReferenceBindingImpl <em>Element Reference Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ElementReferenceBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getElementReferenceBinding()
		 * @generated
		 */
		EClass ELEMENT_REFERENCE_BINDING = eINSTANCE.getElementReferenceBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.PrimitiveBindingImpl <em>Primitive Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.PrimitiveBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPrimitiveBinding()
		 * @generated
		 */
		EClass PRIMITIVE_BINDING = eINSTANCE.getPrimitiveBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.PropertyBindingImpl <em>Property Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.PropertyBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getPropertyBinding()
		 * @generated
		 */
		EClass PROPERTY_BINDING = eINSTANCE.getPropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_BINDING__PROPERTY = eINSTANCE.getPropertyBinding_Property();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_BINDING__DEFAULT = eINSTANCE.getPropertyBinding_Default();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.CompositeBindingImpl <em>Composite Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.CompositeBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getCompositeBinding()
		 * @generated
		 */
		EClass COMPOSITE_BINDING = eINSTANCE.getCompositeBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ReferenceBindingImpl <em>Reference Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ReferenceBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getReferenceBinding()
		 * @generated
		 */
		EClass REFERENCE_BINDING = eINSTANCE.getReferenceBinding();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ActionBindingImpl <em>Action Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ActionBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getActionBinding()
		 * @generated
		 */
		EClass ACTION_BINDING = eINSTANCE.getActionBinding();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BINDING__STATEMENTS = eINSTANCE.getActionBinding_Statements();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.StatementImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__METHOD_NAME = eINSTANCE.getStatement_MethodName();

		/**
		 * The meta object literal for the '<em><b>Method Parameters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__METHOD_PARAMETERS = eINSTANCE.getStatement_MethodParameters();

		/**
		 * The meta object literal for the '{@link hub.sam.tef.tsl.impl.ConstantBindingImpl <em>Constant Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.impl.ConstantBindingImpl
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getConstantBinding()
		 * @generated
		 */
		EClass CONSTANT_BINDING = eINSTANCE.getConstantBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_BINDING__VALUE = eINSTANCE.getConstantBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_BINDING__TYPE = eINSTANCE.getConstantBinding_Type();

		/**
		 * The meta object literal for the '<em>Rcc Syntax</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.rcc.syntax.Syntax
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRccSyntax()
		 * @generated
		 */
		EDataType RCC_SYNTAX = eINSTANCE.getRccSyntax();

		/**
		 * The meta object literal for the '<em>Rcc Rule</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.rcc.syntax.Rule
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getRccRule()
		 * @generated
		 */
		EDataType RCC_RULE = eINSTANCE.getRccRule();

		/**
		 * The meta object literal for the '<em>IModel Creating Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.modelcreating.IModelCreatingContext
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getIModelCreatingContext()
		 * @generated
		 */
		EDataType IMODEL_CREATING_CONTEXT = eINSTANCE.getIModelCreatingContext();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.tef.tsl.TslException
		 * @see hub.sam.tef.tsl.impl.TslPackageImpl#getTslException()
		 * @generated
		 */
		EDataType TSL_EXCEPTION = eINSTANCE.getTslException();

	}

} //TslPackage
