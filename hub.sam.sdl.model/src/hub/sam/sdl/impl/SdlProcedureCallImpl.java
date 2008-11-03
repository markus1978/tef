/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationCreate;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.SdlAction;
import hub.sam.sdl.SdlProcedure;
import hub.sam.sdl.SdlProcedureCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureCallImpl#getCreate_classifier <em>Create classifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureCallImpl#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlProcedureCallImpl extends EvaluationBehavioralFeatureAccessExpressionImpl implements SdlProcedureCall {
	/**
	 * The cached value of the '{@link #getCreate_classifier() <em>Create classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreate_classifier()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsClassifiersClassifier create_classifier;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected SdlProcedure procedure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlProcedureCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlProcedureCall();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersClassifier getCreate_classifier() {
		if (create_classifier != null && create_classifier.eIsProxy()) {
			InternalEObject oldCreate_classifier = (InternalEObject)create_classifier;
			create_classifier = (CoreAbstractionsClassifiersClassifier)eResolveProxy(oldCreate_classifier);
			if (create_classifier != oldCreate_classifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER, oldCreate_classifier, create_classifier));
			}
		}
		return create_classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersClassifier basicGetCreate_classifier() {
		return create_classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate_classifier(CoreAbstractionsClassifiersClassifier newCreate_classifier) {
		CoreAbstractionsClassifiersClassifier oldCreate_classifier = create_classifier;
		create_classifier = newCreate_classifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER, oldCreate_classifier, create_classifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlProcedure getProcedure() {
		if (procedure != null && procedure.eIsProxy()) {
			InternalEObject oldProcedure = (InternalEObject)procedure;
			procedure = (SdlProcedure)eResolveProxy(oldProcedure);
			if (procedure != oldProcedure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE, oldProcedure, procedure));
			}
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlProcedure basicGetProcedure() {
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedure(SdlProcedure newProcedure) {
		SdlProcedure oldProcedure = procedure;
		procedure = newProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE, oldProcedure, procedure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationInstance create(InstanciationInstance context) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER:
				if (resolve) return getCreate_classifier();
				return basicGetCreate_classifier();
			case EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE:
				if (resolve) return getProcedure();
				return basicGetProcedure();
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
			case EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER:
				setCreate_classifier((CoreAbstractionsClassifiersClassifier)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE:
				setProcedure((SdlProcedure)newValue);
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
			case EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER:
				setCreate_classifier((CoreAbstractionsClassifiersClassifier)null);
				return;
			case EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE:
				setProcedure((SdlProcedure)null);
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
			case EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER:
				return create_classifier != null;
			case EmfSdlPackage.SDL_PROCEDURE_CALL__PROCEDURE:
				return procedure != null;
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
		if (baseClass == InstanciationCreate.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER: return EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == SdlAction.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == InstanciationCreate.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.INSTANCIATION_CREATE__CREATE_CLASSIFIER: return EmfSdlPackage.SDL_PROCEDURE_CALL__CREATE_CLASSIFIER;
				default: return -1;
			}
		}
		if (baseClass == SdlAction.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlProcedureCallImpl
