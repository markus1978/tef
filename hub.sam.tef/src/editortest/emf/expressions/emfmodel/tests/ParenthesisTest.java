/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel.tests;

import editortest.emf.expressions.emfmodel.ExpressionsFactory;
import editortest.emf.expressions.emfmodel.Parenthesis;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parenthesis</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParenthesisTest extends ExpressionTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ParenthesisTest.class);
	}

	/**
	 * Constructs a new Parenthesis test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenthesisTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parenthesis test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Parenthesis getFixture() {
		return (Parenthesis)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ExpressionsFactory.eINSTANCE.createParenthesis());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ParenthesisTest
