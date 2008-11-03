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
import hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier;
import hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.SdlClassifier;
import hub.sam.sdl.SdlNamespace;
import hub.sam.sdl.SdlParameter;
import hub.sam.sdl.SdlProcedure;
import hub.sam.sdl.SdlSignal;
import hub.sam.sdl.SdlVariable;

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
 * An implementation of the model object '<em><b>Sdl Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getMember <em>Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getFeaturingClassifier <em>Featuring Classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getBehavioralFeature_parameter <em>Behavioral Feature parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlSignalImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlSignalImpl extends CommunicationEventTypeImpl implements SdlSignal {
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
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsTypedElementsType> ownedType;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersFeature> feature;

	/**
	 * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralization()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsGeneralization> generalization;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsClassifier> general;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlVariable> variable;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlProcedure> procedure;

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
	protected SdlSignalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlSignal();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE);
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
			member = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_SIGNAL__MEMBER);
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
			featuringClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersClassifier>(CoreAbstractionsClassifiersClassifier.class, this, EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE);
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
			behavioralFeature_parameter = new EObjectResolvingEList<CoreAbstractionsBehavioralFeaturesParameter>(CoreAbstractionsBehavioralFeaturesParameter.class, this, EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER);
		}
		return behavioralFeature_parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsTypedElementsType> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentEList<CoreAbstractionsTypedElementsType>(CoreAbstractionsTypedElementsType.class, this, EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersFeature>(CoreAbstractionsClassifiersFeature.class, this, EmfSdlPackage.SDL_SIGNAL__FEATURE, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER);
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsGeneralization> getGeneralization() {
		if (generalization == null) {
			generalization = new EObjectContainmentWithInverseEList<CoreAbstractionsGeneralizationsGeneralization>(CoreAbstractionsGeneralizationsGeneralization.class, this, EmfSdlPackage.SDL_SIGNAL__GENERALIZATION, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC);
		}
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> getGeneral() {
		if (general == null) {
			general = new EObjectResolvingEList<CoreAbstractionsGeneralizationsClassifier>(CoreAbstractionsGeneralizationsClassifier.class, this, EmfSdlPackage.SDL_SIGNAL__GENERAL);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlVariable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<SdlVariable>(SdlVariable.class, this, EmfSdlPackage.SDL_SIGNAL__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlProcedure> getProcedure() {
		if (procedure == null) {
			procedure = new EObjectContainmentEList<SdlProcedure>(SdlProcedure.class, this, EmfSdlPackage.SDL_SIGNAL__PROCEDURE);
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<SdlParameter>(SdlParameter.class, this, EmfSdlPackage.SDL_SIGNAL__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> general() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> parents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean conformsTo(CoreAbstractionsGeneralizationsClassifier other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> allFeatures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationInstance instanciate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeaturingClassifier()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralization()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				return ((InternalEList<?>)getFeaturingClassifier()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_SIGNAL__PARAMETER:
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.SDL_SIGNAL__MEMBER:
				return getMember();
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				return getFeaturingClassifier();
			case EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER:
				return getBehavioralFeature_parameter();
			case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE:
				return getOwnedType();
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				return getFeature();
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				return getGeneralization();
			case EmfSdlPackage.SDL_SIGNAL__GENERAL:
				return getGeneral();
			case EmfSdlPackage.SDL_SIGNAL__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_SIGNAL__PROCEDURE:
				return getProcedure();
			case EmfSdlPackage.SDL_SIGNAL__PARAMETER:
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				getFeaturingClassifier().addAll((Collection<? extends CoreAbstractionsClassifiersClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER:
				getBehavioralFeature_parameter().clear();
				getBehavioralFeature_parameter().addAll((Collection<? extends CoreAbstractionsBehavioralFeaturesParameter>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends CoreAbstractionsTypedElementsType>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends CoreAbstractionsClassifiersFeature>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends CoreAbstractionsGeneralizationsGeneralization>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsGeneralizationsClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends SdlVariable>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends SdlProcedure>)newValue);
				return;
			case EmfSdlPackage.SDL_SIGNAL__PARAMETER:
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__MEMBER:
				getMember().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				getFeaturingClassifier().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER:
				getBehavioralFeature_parameter().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				getFeature().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				getGeneralization().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__GENERAL:
				getGeneral().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__VARIABLE:
				getVariable().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__PROCEDURE:
				getProcedure().clear();
				return;
			case EmfSdlPackage.SDL_SIGNAL__PARAMETER:
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
			case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__MEMBER:
				return member != null && !member.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER:
				return featuringClassifier != null && !featuringClassifier.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER:
				return behavioralFeature_parameter != null && !behavioralFeature_parameter.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__FEATURE:
				return feature != null && !feature.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__GENERAL:
				return general != null && !general.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__VARIABLE:
				return variable != null && !variable.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
			case EmfSdlPackage.SDL_SIGNAL__PARAMETER:
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
				case EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;
				case EmfSdlPackage.SDL_SIGNAL__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER: return EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE: return EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__GENERALIZATION: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION;
				case EmfSdlPackage.SDL_SIGNAL__GENERAL: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_SIGNAL__VARIABLE: return EmfSdlPackage.SDL_CLASSIFIER__VARIABLE;
				case EmfSdlPackage.SDL_SIGNAL__PROCEDURE: return EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE;
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
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER: return EmfSdlPackage.SDL_SIGNAL__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER: return EmfSdlPackage.SDL_SIGNAL__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER: return EmfSdlPackage.SDL_SIGNAL__FEATURING_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsBehavioralFeaturesBehavioralFeature.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_BEHAVIORAL_FEATURES_BEHAVIORAL_FEATURE__BEHAVIORAL_FEATURE_PARAMETER: return EmfSdlPackage.SDL_SIGNAL__BEHAVIORAL_FEATURE_PARAMETER;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE: return EmfSdlPackage.SDL_SIGNAL__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE: return EmfSdlPackage.SDL_SIGNAL__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION: return EmfSdlPackage.SDL_SIGNAL__GENERALIZATION;
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL: return EmfSdlPackage.SDL_SIGNAL__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE: return EmfSdlPackage.SDL_SIGNAL__VARIABLE;
				case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE: return EmfSdlPackage.SDL_SIGNAL__PROCEDURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlSignalImpl
