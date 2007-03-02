/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see editortest.emf.expressions.emfmodel.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emfmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "null";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "editortest.emf.metamodels";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.OperatorImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OPERAND2 = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.PlusImpl <em>Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.PlusImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getPlus()
	 * @generated
	 */
	int PLUS = 2;

	/**
	 * The feature id for the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__OPERAND1 = OPERATOR__OPERAND1;

	/**
	 * The feature id for the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__OPERAND2 = OPERATOR__OPERAND2;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.TimesImpl <em>Times</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.TimesImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getTimes()
	 * @generated
	 */
	int TIMES = 3;

	/**
	 * The feature id for the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMES__OPERAND1 = OPERATOR__OPERAND1;

	/**
	 * The feature id for the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMES__OPERAND2 = OPERATOR__OPERAND2;

	/**
	 * The number of structural features of the '<em>Times</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMES_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.ParenthesisImpl <em>Parenthesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.ParenthesisImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getParenthesis()
	 * @generated
	 */
	int PARENTHESIS = 4;

	/**
	 * The feature id for the '<em><b>Subexpression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIS__SUBEXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parenthesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link editortest.emf.expressions.emfmodel.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see editortest.emf.expressions.emfmodel.impl.IntegerImpl
	 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see editortest.emf.expressions.emfmodel.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see editortest.emf.expressions.emfmodel.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference '{@link editortest.emf.expressions.emfmodel.Operator#getOperand1 <em>Operand1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand1</em>'.
	 * @see editortest.emf.expressions.emfmodel.Operator#getOperand1()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Operand1();

	/**
	 * Returns the meta object for the containment reference '{@link editortest.emf.expressions.emfmodel.Operator#getOperand2 <em>Operand2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand2</em>'.
	 * @see editortest.emf.expressions.emfmodel.Operator#getOperand2()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Operand2();

	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see editortest.emf.expressions.emfmodel.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Times <em>Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Times</em>'.
	 * @see editortest.emf.expressions.emfmodel.Times
	 * @generated
	 */
	EClass getTimes();

	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Parenthesis <em>Parenthesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parenthesis</em>'.
	 * @see editortest.emf.expressions.emfmodel.Parenthesis
	 * @generated
	 */
	EClass getParenthesis();

	/**
	 * Returns the meta object for the containment reference '{@link editortest.emf.expressions.emfmodel.Parenthesis#getSubexpression <em>Subexpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subexpression</em>'.
	 * @see editortest.emf.expressions.emfmodel.Parenthesis#getSubexpression()
	 * @see #getParenthesis()
	 * @generated
	 */
	EReference getParenthesis_Subexpression();

	/**
	 * Returns the meta object for class '{@link editortest.emf.expressions.emfmodel.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see editortest.emf.expressions.emfmodel.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for the attribute '{@link editortest.emf.expressions.emfmodel.Integer#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see editortest.emf.expressions.emfmodel.Integer#getValue()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.OperatorImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__OPERAND1 = eINSTANCE.getOperator_Operand1();

		/**
		 * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__OPERAND2 = eINSTANCE.getOperator_Operand2();

		/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.PlusImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.TimesImpl <em>Times</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.TimesImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getTimes()
		 * @generated
		 */
		EClass TIMES = eINSTANCE.getTimes();

		/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.ParenthesisImpl <em>Parenthesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.ParenthesisImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getParenthesis()
		 * @generated
		 */
		EClass PARENTHESIS = eINSTANCE.getParenthesis();

		/**
		 * The meta object literal for the '<em><b>Subexpression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENTHESIS__SUBEXPRESSION = eINSTANCE.getParenthesis_Subexpression();

			/**
		 * The meta object literal for the '{@link editortest.emf.expressions.emfmodel.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see editortest.emf.expressions.emfmodel.impl.IntegerImpl
		 * @see editortest.emf.expressions.emfmodel.impl.ExpressionsPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__VALUE = eINSTANCE.getInteger_Value();

	}

} //ExpressionsPackage
