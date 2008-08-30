/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.tsl.ActionBinding;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ElementReferenceBinding;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.Pattern;
import hub.sam.tef.tsl.PatternTerminal;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Statement;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.TslFactory;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.WhiteSpace;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class TslFactoryImpl extends EFactoryImpl implements TslFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TslFactory init() {
		try {
			TslFactory theTslFactory = (TslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.hu-berlin.de/sam/meta-tools/tef/tsl"); 
			if (theTslFactory != null) {
				return theTslFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TslFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TslFactoryImpl() {
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
			case TslPackage.SYNTAX: return createSyntax();
			case TslPackage.SIMPLE_RULE: return createSimpleRule();
			case TslPackage.NON_TERMINAL: return createNonTerminal();
			case TslPackage.FIX_TERMINAL: return createFixTerminal();
			case TslPackage.PATTERN_TERMINAL: return createPatternTerminal();
			case TslPackage.WHITE_SPACE: return createWhiteSpace();
			case TslPackage.PATTERN: return createPattern();
			case TslPackage.BINDING: return createBinding();
			case TslPackage.ELEMENT_BINDING: return createElementBinding();
			case TslPackage.ELEMENT_REFERENCE_BINDING: return createElementReferenceBinding();
			case TslPackage.PRIMITIVE_BINDING: return createPrimitiveBinding();
			case TslPackage.CONSTANT_BINDING: return createConstantBinding();
			case TslPackage.COMPOSITE_BINDING: return createCompositeBinding();
			case TslPackage.REFERENCE_BINDING: return createReferenceBinding();
			case TslPackage.ACTION_BINDING: return createActionBinding();
			case TslPackage.STATEMENT: return createStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TslPackage.IMODEL_CREATING_CONTEXT:
				return createIModelCreatingContextFromString(eDataType, initialValue);
			case TslPackage.TSL_EXCEPTION:
				return createTslExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TslPackage.IMODEL_CREATING_CONTEXT:
				return convertIModelCreatingContextToString(eDataType, instanceValue);
			case TslPackage.TSL_EXCEPTION:
				return convertTslExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Syntax createSyntax() {
		SyntaxImpl syntax = new SyntaxImpl();
		return syntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleRule createSimpleRule() {
		SimpleRuleImpl simpleRule = new SimpleRuleImpl();
		return simpleRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonTerminal createNonTerminal() {
		NonTerminalImpl nonTerminal = new NonTerminalImpl();
		return nonTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixTerminal createFixTerminal() {
		FixTerminalImpl fixTerminal = new FixTerminalImpl();
		return fixTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternTerminal createPatternTerminal() {
		PatternTerminalImpl patternTerminal = new PatternTerminalImpl();
		return patternTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhiteSpace createWhiteSpace() {
		WhiteSpaceImpl whiteSpace = new WhiteSpaceImpl();
		return whiteSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding createBinding() {
		BindingImpl binding = new BindingImpl();
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementBinding createElementBinding() {
		ElementBindingImpl elementBinding = new ElementBindingImpl();
		return elementBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReferenceBinding createElementReferenceBinding() {
		ElementReferenceBindingImpl elementReferenceBinding = new ElementReferenceBindingImpl();
		return elementReferenceBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveBinding createPrimitiveBinding() {
		PrimitiveBindingImpl primitiveBinding = new PrimitiveBindingImpl();
		return primitiveBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBinding createCompositeBinding() {
		CompositeBindingImpl compositeBinding = new CompositeBindingImpl();
		return compositeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceBinding createReferenceBinding() {
		ReferenceBindingImpl referenceBinding = new ReferenceBindingImpl();
		return referenceBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionBinding createActionBinding() {
		ActionBindingImpl actionBinding = new ActionBindingImpl();
		return actionBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBinding createConstantBinding() {
		ConstantBindingImpl constantBinding = new ConstantBindingImpl();
		return constantBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelCreatingContext createIModelCreatingContextFromString(EDataType eDataType, String initialValue) {
		return (IModelCreatingContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIModelCreatingContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TslException createTslExceptionFromString(EDataType eDataType, String initialValue) {
		return (TslException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTslExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TslPackage getTslPackage() {
		return (TslPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TslPackage getPackage() {
		return TslPackage.eINSTANCE;
	}

} //TslFactoryImpl
