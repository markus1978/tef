/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature;
import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesParameter;
import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlOperation;
import hub.sam.sdl.SdlParameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlOperationImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOperationImpl#getMember <em>Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOperationImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOperationImpl#getBehavioralFeature_parameter <em>Behavioral Feature parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlOperationImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlOperationImpl extends CoreAbstractionsTypedElementsTypedElementImpl implements SdlOperation {
	/**
	 * The cached value of the '{@link #getOwnedMember() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> ownedMember;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> member;

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
	 * The cached value of the '{@link #getBehavioralFeature_parameter() <em>Behavioral Feature parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralFeature_parameter()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsBehavioralFeaturesParameter> behavioralFeature_parameter;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlParameter> parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE);
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getMember() {
		if (member == null) {
			member = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_OPERATION__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersClassifier> getFeaturingClassifier() {
		if (featuringClassifier == null) {
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
		}
		return featuringClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsBehavioralFeaturesParameter> getBehavioralFeature_parameter() {
		if (behavioralFeature_parameter == null) {
			behavioralFeature_parameter = new EObjectResolvingEList<CoreAbstractionsBehavioralFeaturesParameter>(CoreAbstractionsBehavioralFeaturesParameter.class, this, EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER);
		}
		return behavioralFeature_parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<SdlParameter>(SdlParameter.class, this, EmfSdlPackage.SDL_OPERATION__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNamesOfMember(CoreAbstractionsNamespacesNamedElement element) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean membersAreDistinguishable() {
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeaturingClassifier()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_OPERATION__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.SDL_OPERATION__MEMBER:
				return getMember();
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER:
				return getBehavioralFeature_parameter();
			case EmfSdlPackage.SDL_OPERATION__PARAMETER:
				return getParameter();
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_OPERATION__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER:
				getBehavioralFeature_parameter().clear();
				getBehavioralFeature_parameter().addAll((Collection<? extends CoreAbstractionsBehavioralFeaturesParameter>)newValue);
				return;
			case EmfSdlPackage.SDL_OPERATION__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends SdlParameter>)newValue);
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.SDL_OPERATION__MEMBER:
				getMember().clear();
				return;
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER:
				getBehavioralFeature_parameter().clear();
				return;
			case EmfSdlPackage.SDL_OPERATION__PARAMETER:
				getParameter().clear();
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
			case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.SDL_OPERATION__MEMBER:
				return member != null && !member.isEmpty();
			case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER:
				return behavioralFeature_parameter != null && !behavioralFeature_parameter.isEmpty();
			case EmfSdlPackage.SDL_OPERATION__PARAMETER:
				return parameter != null && !parameter.isEmpty();
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
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;
				case EmfSdlPackage.SDL_OPERATION__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER: return EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER;
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
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER: return EmfSdlPackage.SDL_OPERATION__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER: return EmfSdlPackage.SDL_OPERATION__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_OPERATION__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER: return EmfSdlPackage.SDL_OPERATION__BEHAVIORAL_FEATURE_PARAMETER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlOperationImpl
