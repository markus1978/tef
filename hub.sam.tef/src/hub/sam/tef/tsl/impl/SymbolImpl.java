/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.impl;

import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.tef.tsl.impl.SymbolImpl#getPropertyBinding <em>Property Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SymbolImpl extends EObjectImpl implements Symbol {
	/**
	 * The cached value of the '{@link #getPropertyBinding() <em>Property Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyBinding()
	 * @generated
	 * @ordered
	 */
	protected PropertyBinding propertyBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TslPackage.Literals.SYMBOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyBinding getPropertyBinding() {
		return propertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyBinding(PropertyBinding newPropertyBinding, NotificationChain msgs) {
		PropertyBinding oldPropertyBinding = propertyBinding;
		propertyBinding = newPropertyBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TslPackage.SYMBOL__PROPERTY_BINDING, oldPropertyBinding, newPropertyBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyBinding(PropertyBinding newPropertyBinding) {
		if (newPropertyBinding != propertyBinding) {
			NotificationChain msgs = null;
			if (propertyBinding != null)
				msgs = ((InternalEObject)propertyBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TslPackage.SYMBOL__PROPERTY_BINDING, null, msgs);
			if (newPropertyBinding != null)
				msgs = ((InternalEObject)newPropertyBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TslPackage.SYMBOL__PROPERTY_BINDING, null, msgs);
			msgs = basicSetPropertyBinding(newPropertyBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TslPackage.SYMBOL__PROPERTY_BINDING, newPropertyBinding, newPropertyBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRCCSymbol() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TslPackage.SYMBOL__PROPERTY_BINDING:
				return basicSetPropertyBinding(null, msgs);
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
			case TslPackage.SYMBOL__PROPERTY_BINDING:
				return getPropertyBinding();
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
			case TslPackage.SYMBOL__PROPERTY_BINDING:
				setPropertyBinding((PropertyBinding)newValue);
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
			case TslPackage.SYMBOL__PROPERTY_BINDING:
				setPropertyBinding((PropertyBinding)null);
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
			case TslPackage.SYMBOL__PROPERTY_BINDING:
				return propertyBinding != null;
		}
		return super.eIsSet(featureID);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(getRCCSymbol());
		PropertyBinding propertyBinding = getPropertyBinding();
		if (propertyBinding != null) {
			result.append(":");
			result.append(propertyBinding.toString());
		}
		return result.toString();
	}

} //SymbolImpl
