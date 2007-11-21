/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.util;

import hub.sam.tef.tsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.tef.tsl.TslPackage
 * @generated
 */
public class TslAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TslPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TslAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TslPackage.eINSTANCE;
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
	protected TslSwitch<Adapter> modelSwitch =
		new TslSwitch<Adapter>() {
			@Override
			public Adapter caseSyntax(Syntax object) {
				return createSyntaxAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseSimpleRule(SimpleRule object) {
				return createSimpleRuleAdapter();
			}
			@Override
			public Adapter caseSymbol(Symbol object) {
				return createSymbolAdapter();
			}
			@Override
			public Adapter caseNonTerminal(NonTerminal object) {
				return createNonTerminalAdapter();
			}
			@Override
			public Adapter caseTerminal(Terminal object) {
				return createTerminalAdapter();
			}
			@Override
			public Adapter caseFixTerminal(FixTerminal object) {
				return createFixTerminalAdapter();
			}
			@Override
			public Adapter casePatternTerminal(PatternTerminal object) {
				return createPatternTerminalAdapter();
			}
			@Override
			public Adapter caseWhiteSpace(WhiteSpace object) {
				return createWhiteSpaceAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseBinding(Binding object) {
				return createBindingAdapter();
			}
			@Override
			public Adapter caseValueBinding(ValueBinding object) {
				return createValueBindingAdapter();
			}
			@Override
			public Adapter caseElementBinding(ElementBinding object) {
				return createElementBindingAdapter();
			}
			@Override
			public Adapter casePrimitiveBinding(PrimitiveBinding object) {
				return createPrimitiveBindingAdapter();
			}
			@Override
			public Adapter casePropertyBinding(PropertyBinding object) {
				return createPropertyBindingAdapter();
			}
			@Override
			public Adapter caseCompositeBinding(CompositeBinding object) {
				return createCompositeBindingAdapter();
			}
			@Override
			public Adapter caseReferenceBinding(ReferenceBinding object) {
				return createReferenceBindingAdapter();
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
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Syntax <em>Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Syntax
	 * @generated
	 */
	public Adapter createSyntaxAdapter() {
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
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.SimpleRule <em>Simple Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.SimpleRule
	 * @generated
	 */
	public Adapter createSimpleRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Symbol
	 * @generated
	 */
	public Adapter createSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.NonTerminal <em>Non Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.NonTerminal
	 * @generated
	 */
	public Adapter createNonTerminalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Terminal
	 * @generated
	 */
	public Adapter createTerminalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.FixTerminal <em>Fix Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.FixTerminal
	 * @generated
	 */
	public Adapter createFixTerminalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.PatternTerminal <em>Pattern Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.PatternTerminal
	 * @generated
	 */
	public Adapter createPatternTerminalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.WhiteSpace <em>White Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.WhiteSpace
	 * @generated
	 */
	public Adapter createWhiteSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.Binding
	 * @generated
	 */
	public Adapter createBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.ValueBinding <em>Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.ValueBinding
	 * @generated
	 */
	public Adapter createValueBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.ElementBinding <em>Element Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.ElementBinding
	 * @generated
	 */
	public Adapter createElementBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.PrimitiveBinding <em>Primitive Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.PrimitiveBinding
	 * @generated
	 */
	public Adapter createPrimitiveBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.PropertyBinding <em>Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.PropertyBinding
	 * @generated
	 */
	public Adapter createPropertyBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.CompositeBinding <em>Composite Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.CompositeBinding
	 * @generated
	 */
	public Adapter createCompositeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.tef.tsl.ReferenceBinding <em>Reference Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.tef.tsl.ReferenceBinding
	 * @generated
	 */
	public Adapter createReferenceBindingAdapter() {
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

} //TslAdapterFactory