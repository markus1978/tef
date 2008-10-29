/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier;
import hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Generalizations Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl#getMember <em>Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsGeneralizationsClassifierImpl#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsGeneralizationsClassifierImpl extends CoreAbstractionsTypedElementsTypeImpl implements CoreAbstractionsGeneralizationsClassifier {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsGeneralizationsClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE);
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
			member = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersFeature>(CoreAbstractionsClassifiersFeature.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER);
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
			generalization = new EObjectContainmentWithInverseEList<CoreAbstractionsGeneralizationsGeneralization>(CoreAbstractionsGeneralizationsGeneralization.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC);
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
			general = new EObjectResolvingEList<CoreAbstractionsGeneralizationsClassifier>(CoreAbstractionsGeneralizationsClassifier.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL);
		}
		return general;
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER:
				return getMember();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				return getFeature();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
				return getGeneralization();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL:
				return getGeneral();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends CoreAbstractionsClassifiersFeature>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends CoreAbstractionsGeneralizationsGeneralization>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsGeneralizationsClassifier>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER:
				getMember().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				getFeature().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL:
				getGeneral().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER:
				return member != null && !member.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE:
				return feature != null && !feature.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL:
				return general != null && !general.isEmpty();
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
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE;
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
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__MEMBER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CoreAbstractionsGeneralizationsClassifierImpl
