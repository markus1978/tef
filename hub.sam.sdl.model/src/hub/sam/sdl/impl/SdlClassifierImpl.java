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
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.SdlClassifier;
import hub.sam.sdl.SdlProcedure;
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
 * An implementation of the model object '<em><b>Sdl Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlClassifierImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlClassifierImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlClassifierImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlClassifierImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlClassifierImpl#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SdlClassifierImpl extends SdlNamespaceImpl implements SdlClassifier {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersFeature>(CoreAbstractionsClassifiersFeature.class, this, EmfSdlPackage.SDL_CLASSIFIER__FEATURE, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER);
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
			generalization = new EObjectContainmentWithInverseEList<CoreAbstractionsGeneralizationsGeneralization>(CoreAbstractionsGeneralizationsGeneralization.class, this, EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC);
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
			general = new EObjectResolvingEList<CoreAbstractionsGeneralizationsClassifier>(CoreAbstractionsGeneralizationsClassifier.class, this, EmfSdlPackage.SDL_CLASSIFIER__GENERAL);
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
			variable = new EObjectContainmentEList<SdlVariable>(SdlVariable.class, this, EmfSdlPackage.SDL_CLASSIFIER__VARIABLE);
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
			procedure = new EObjectContainmentEList<SdlProcedure>(SdlProcedure.class, this, EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE);
		}
		return procedure;
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
	public boolean conformsTo(CoreAbstractionsTypedElementsType other) {
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				return getFeature();
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
				return getGeneralization();
			case EmfSdlPackage.SDL_CLASSIFIER__GENERAL:
				return getGeneral();
			case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE:
				return getProcedure();
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends CoreAbstractionsClassifiersFeature>)newValue);
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends CoreAbstractionsGeneralizationsGeneralization>)newValue);
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsGeneralizationsClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends SdlVariable>)newValue);
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends SdlProcedure>)newValue);
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				getFeature().clear();
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
				getGeneralization().clear();
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__GENERAL:
				getGeneral().clear();
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE:
				getVariable().clear();
				return;
			case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE:
				getProcedure().clear();
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
			case EmfSdlPackage.SDL_CLASSIFIER__FEATURE:
				return feature != null && !feature.isEmpty();
			case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
			case EmfSdlPackage.SDL_CLASSIFIER__GENERAL:
				return general != null && !general.isEmpty();
			case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE:
				return variable != null && !variable.isEmpty();
			case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
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
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_CLASSIFIER__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION;
				case EmfSdlPackage.SDL_CLASSIFIER__GENERAL: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL;
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
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE: return EmfSdlPackage.SDL_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION: return EmfSdlPackage.SDL_CLASSIFIER__GENERALIZATION;
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL: return EmfSdlPackage.SDL_CLASSIFIER__GENERAL;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlClassifierImpl
