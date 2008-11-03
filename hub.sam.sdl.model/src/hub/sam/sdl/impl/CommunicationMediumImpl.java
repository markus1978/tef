/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationCommunicator;
import hub.sam.sdl.CommunicationMedium;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Medium</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CommunicationMediumImpl#getAssociatedClassifier <em>Associated Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommunicationMediumImpl extends CoreAbstractionsElementsElementImpl implements CommunicationMedium {
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
	protected CommunicationMediumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCommunicationMedium();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationCommunicator> getAssociatedClassifier() {
		if (associatedClassifier == null) {
			associatedClassifier = new EObjectWithInverseResolvingEList.ManyInverse<CommunicationCommunicator>(CommunicationCommunicator.class, this, EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER, EmfSdlPackage.COMMUNICATION_COMMUNICATOR__MEDIUM);
		}
		return associatedClassifier;
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
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
			case EmfSdlPackage.COMMUNICATION_MEDIUM__ASSOCIATED_CLASSIFIER:
				return associatedClassifier != null && !associatedClassifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CommunicationMediumImpl
