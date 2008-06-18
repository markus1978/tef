/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification;
import hub.sam.sdl.CoreAbstractionsMultiplicityExpressionsMultiplicityElement;
import hub.sam.sdl.EmfSdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Multiplicity Expressions Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl#getUpperValue <em>Upper Value</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl#getLowerValue <em>Lower Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl extends CoreAbstractionsOwnershipsElementImpl implements CoreAbstractionsMultiplicityExpressionsMultiplicityElement {
	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final String LOWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected String lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final String UPPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected String upper = UPPER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUpperValue() <em>Upper Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperValue()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsExpressionsValueSpecification upperValue;

	/**
	 * The cached value of the '{@link #getLowerValue() <em>Lower Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerValue()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsExpressionsValueSpecification lowerValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsMultiplicityExpressionsMultiplicityElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(String newLower) {
		String oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(String newUpper) {
		String oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsValueSpecification getUpperValue() {
		return upperValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperValue(CoreAbstractionsExpressionsValueSpecification newUpperValue, NotificationChain msgs) {
		CoreAbstractionsExpressionsValueSpecification oldUpperValue = upperValue;
		upperValue = newUpperValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE, oldUpperValue, newUpperValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperValue(CoreAbstractionsExpressionsValueSpecification newUpperValue) {
		if (newUpperValue != upperValue) {
			NotificationChain msgs = null;
			if (upperValue != null)
				msgs = ((InternalEObject)upperValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE, null, msgs);
			if (newUpperValue != null)
				msgs = ((InternalEObject)newUpperValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE, null, msgs);
			msgs = basicSetUpperValue(newUpperValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE, newUpperValue, newUpperValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsValueSpecification getLowerValue() {
		return lowerValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerValue(CoreAbstractionsExpressionsValueSpecification newLowerValue, NotificationChain msgs) {
		CoreAbstractionsExpressionsValueSpecification oldLowerValue = lowerValue;
		lowerValue = newLowerValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE, oldLowerValue, newLowerValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerValue(CoreAbstractionsExpressionsValueSpecification newLowerValue) {
		if (newLowerValue != lowerValue) {
			NotificationChain msgs = null;
			if (lowerValue != null)
				msgs = ((InternalEObject)lowerValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE, null, msgs);
			if (newLowerValue != null)
				msgs = ((InternalEObject)newLowerValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE, null, msgs);
			msgs = basicSetLowerValue(newLowerValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE, newLowerValue, newLowerValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String lower() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String upper() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String lowerBound() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String upperBound() {
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE:
				return basicSetUpperValue(null, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE:
				return basicSetLowerValue(null, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER:
				return getLower();
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER:
				return getUpper();
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE:
				return getUpperValue();
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE:
				return getLowerValue();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER:
				setLower((String)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER:
				setUpper((String)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE:
				setUpperValue((CoreAbstractionsExpressionsValueSpecification)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE:
				setLowerValue((CoreAbstractionsExpressionsValueSpecification)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE:
				setUpperValue((CoreAbstractionsExpressionsValueSpecification)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE:
				setLowerValue((CoreAbstractionsExpressionsValueSpecification)null);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__UPPER_VALUE:
				return upperValue != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITY_EXPRESSIONS_MULTIPLICITY_ELEMENT__LOWER_VALUE:
				return lowerValue != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} //CoreAbstractionsMultiplicityExpressionsMultiplicityElementImpl
