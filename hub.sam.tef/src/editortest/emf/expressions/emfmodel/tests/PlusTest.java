/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel.tests;

import editortest.emf.expressions.emfmodel.ExpressionsFactory;
import editortest.emf.expressions.emfmodel.Plus;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Plus</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlusTest extends OperatorTest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlusTest.class);
	}

	/**
	 * Constructs a new Plus test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlusTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Plus test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Plus getFixture() {
		return (Plus)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ExpressionsFactory.eINSTANCE.createPlus());
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

} //PlusTest
