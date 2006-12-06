/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel.impl;

import editortest.emf.expressions.emfmodel.Expression;
import editortest.emf.expressions.emfmodel.ExpressionsPackage;
import editortest.emf.expressions.emfmodel.Parenthesis;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parenthesis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link editortest.emf.expressions.emfmodel.impl.ParenthesisImpl#getSubexpression <em>Subexpression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParenthesisImpl extends ExpressionImpl implements Parenthesis {
	/**
	 * The cached value of the '{@link #getSubexpression() <em>Subexpression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubexpression()
	 * @generated
	 * @ordered
	 */
	protected Expression subexpression = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParenthesisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.PARENTHESIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSubexpression() {
		return subexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubexpression(Expression newSubexpression, NotificationChain msgs) {
		Expression oldSubexpression = subexpression;
		subexpression = newSubexpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PARENTHESIS__SUBEXPRESSION, oldSubexpression, newSubexpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubexpression(Expression newSubexpression) {
		if (newSubexpression != subexpression) {
			NotificationChain msgs = null;
			if (subexpression != null)
				msgs = ((InternalEObject)subexpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.PARENTHESIS__SUBEXPRESSION, null, msgs);
			if (newSubexpression != null)
				msgs = ((InternalEObject)newSubexpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.PARENTHESIS__SUBEXPRESSION, null, msgs);
			msgs = basicSetSubexpression(newSubexpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PARENTHESIS__SUBEXPRESSION, newSubexpression, newSubexpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.PARENTHESIS__SUBEXPRESSION:
				return basicSetSubexpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.PARENTHESIS__SUBEXPRESSION:
				return getSubexpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.PARENTHESIS__SUBEXPRESSION:
				setSubexpression((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.PARENTHESIS__SUBEXPRESSION:
				setSubexpression((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.PARENTHESIS__SUBEXPRESSION:
				return subexpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ParenthesisImpl