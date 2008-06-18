/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationCommunicator;
import hub.sam.sdl.CommunicationMedium;
import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement;
import hub.sam.sdl.CoreAbstractionsStructuralFeaturesStructuralFeature;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationMultiplicityFeature;
import hub.sam.sdl.InstanciationSlot;
import hub.sam.sdl.SdlAgent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlAgentImpl#getAssociatedClassifier <em>Associated Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlAgentImpl extends CoreAbstractionsTypedElementsTypedElementImpl implements SdlAgent {
	/**
	 * The cached value of the '{@link #getFeaturingClassifier() <em>Featuring Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturingClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersClassifier> featuringClassifier;

	/**
	 * The default value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_ORDERED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected String isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_UNIQUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsUnique()
	 * @generated
	 * @ordered
	 */
	protected String isUnique = IS_UNIQUE_EDEFAULT;

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
	 * The cached value of the '{@link #getAssociatedClassifier() <em>Associated Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationCommunicator> associatedClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlAgentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlAgent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier() {
		if (featuringClassifier == null) {
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(String newIsOrdered) {
		String oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(String newIsUnique) {
		String oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT__IS_UNIQUE, oldIsUnique, isUnique));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT__LOWER, oldLower, lower));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_AGENT__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationCommunicator> getAssociatedClassifier() {
		if (associatedClassifier == null) {
			associatedClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CommunicationCommunicator>(CommunicationCommunicator.class, this, EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER, EmfSdlPackage.COMMUNICATION_COMMUNICATOR__MEDIUM);
		}
		return associatedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationSlot instanciate() {
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
	public String isMultivalued() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String includesCardinality(String C) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String includesMultiplicity(CoreAbstractionsMultiplicitiesMultiplicityElement M) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeaturingClassifier()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociatedClassifier()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				return ((InternalEList<?>)getAssociatedClassifier()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_AGENT__IS_ORDERED:
				return getIsOrdered();
			case EmfSdlPackage.SDL_AGENT__IS_UNIQUE:
				return getIsUnique();
			case EmfSdlPackage.SDL_AGENT__LOWER:
				return getLower();
			case EmfSdlPackage.SDL_AGENT__UPPER:
				return getUpper();
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				return getAssociatedClassifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT__IS_ORDERED:
				setIsOrdered((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT__IS_UNIQUE:
				setIsUnique((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT__LOWER:
				setLower((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT__UPPER:
				setUpper((String)newValue);
				return;
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				getAssociatedClassifier().clear();
				getAssociatedClassifier().addAll((Collection<? extends CommunicationCommunicator>)newValue);
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
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_AGENT__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				getAssociatedClassifier().clear();
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
			case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_AGENT__IS_ORDERED:
				return IS_ORDERED_EDEFAULT == null ? isOrdered != null : !IS_ORDERED_EDEFAULT.equals(isOrdered);
			case EmfSdlPackage.SDL_AGENT__IS_UNIQUE:
				return IS_UNIQUE_EDEFAULT == null ? isUnique != null : !IS_UNIQUE_EDEFAULT.equals(isUnique);
			case EmfSdlPackage.SDL_AGENT__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case EmfSdlPackage.SDL_AGENT__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER:
				return associatedClassifier != null && !associatedClassifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsMultiplicitiesMultiplicityElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT__IS_ORDERED: return EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_ORDERED;
				case EmfSdlPackage.SDL_AGENT__IS_UNIQUE: return EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_UNIQUE;
				case EmfSdlPackage.SDL_AGENT__LOWER: return EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__LOWER;
				case EmfSdlPackage.SDL_AGENT__UPPER: return EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__UPPER;
				default: return -1;
			}
		}
		if (baseClass == InstanciationMultiplicityFeature.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CommunicationMedium.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER: return EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_AGENT__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsStructuralFeaturesStructuralFeature.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsMultiplicitiesMultiplicityElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_ORDERED: return EmfSdlPackage.SDL_AGENT__IS_ORDERED;
				case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_UNIQUE: return EmfSdlPackage.SDL_AGENT__IS_UNIQUE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__LOWER: return EmfSdlPackage.SDL_AGENT__LOWER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__UPPER: return EmfSdlPackage.SDL_AGENT__UPPER;
				default: return -1;
			}
		}
		if (baseClass == InstanciationMultiplicityFeature.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CommunicationMedium.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER: return EmfSdlPackage.SDL_AGENT__ASSOCIATED_CLASSIFIER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (isOrdered: ");
		result.append(isOrdered);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(", lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} //SdlAgentImpl
