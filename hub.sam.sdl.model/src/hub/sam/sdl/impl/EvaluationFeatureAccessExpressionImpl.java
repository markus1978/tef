/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationFeatureAccessExpression;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Feature Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.EvaluationFeatureAccessExpressionImpl#getFeatureAccessExpression_feature <em>Feature Access Expression feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EvaluationFeatureAccessExpressionImpl extends EvaluationExpressionImpl implements EvaluationFeatureAccessExpression {
	/**
	 * The cached value of the '{@link #getFeatureAccessExpression_feature() <em>Feature Access Expression feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureAccessExpression_feature()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsClassifiersFeature featureAccessExpression_feature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationFeatureAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getEvaluationFeatureAccessExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersFeature getFeatureAccessExpression_feature() {
		if (featureAccessExpression_feature != null && featureAccessExpression_feature.eIsProxy()) {
			InternalEObject oldFeatureAccessExpression_feature = (InternalEObject)featureAccessExpression_feature;
			featureAccessExpression_feature = (CoreAbstractionsClassifiersFeature)eResolveProxy(oldFeatureAccessExpression_feature);
			if (featureAccessExpression_feature != oldFeatureAccessExpression_feature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE, oldFeatureAccessExpression_feature, featureAccessExpression_feature));
			}
		}
		return featureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersFeature basicGetFeatureAccessExpression_feature() {
		return featureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureAccessExpression_feature(CoreAbstractionsClassifiersFeature newFeatureAccessExpression_feature) {
		CoreAbstractionsClassifiersFeature oldFeatureAccessExpression_feature = featureAccessExpression_feature;
		featureAccessExpression_feature = newFeatureAccessExpression_feature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE, oldFeatureAccessExpression_feature, featureAccessExpression_feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				if (resolve) return getFeatureAccessExpression_feature();
				return basicGetFeatureAccessExpression_feature();
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
			case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				setFeatureAccessExpression_feature((CoreAbstractionsClassifiersFeature)newValue);
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
			case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				setFeatureAccessExpression_feature((CoreAbstractionsClassifiersFeature)null);
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
			case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				return featureAccessExpression_feature != null;
		}
		return super.eIsSet(featureID);
	}

} //EvaluationFeatureAccessExpressionImpl
