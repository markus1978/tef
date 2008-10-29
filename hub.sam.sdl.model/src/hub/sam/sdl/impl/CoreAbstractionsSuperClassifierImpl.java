/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsSuperClassifier;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Super Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsSuperClassifierImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsSuperClassifierImpl#getInheritedMember <em>Inherited Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsSuperClassifierImpl#getGeneral <em>General</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsSuperClassifierImpl extends CoreAbstractionsNamespacesNamespaceImpl implements CoreAbstractionsSuperClassifier {
	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInheritedMember() <em>Inherited Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> inheritedMember;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsSuperClassifier> general;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsSuperClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsSuperClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getInheritedMember() {
		if (inheritedMember == null) {
			inheritedMember = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER);
		}
		return inheritedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsSuperClassifier> getGeneral() {
		if (general == null) {
			general = new EObjectResolvingEList<CoreAbstractionsSuperClassifier>(CoreAbstractionsSuperClassifier.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> inheritedMember() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsSuperClassifier> parents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsSuperClassifier> allParents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> inheritableMembers(CoreAbstractionsSuperClassifier c) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasVisibilityOf(CoreAbstractionsNamespacesNamedElement n) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> inherit(EList<CoreAbstractionsNamespacesNamedElement> inhs) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean maySpecializeType(CoreAbstractionsSuperClassifier c) {
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT:
				return isIsAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER:
				return getInheritedMember();
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL:
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT:
				setIsAbstract(((Boolean)newValue).booleanValue());
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER:
				getInheritedMember().clear();
				getInheritedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsSuperClassifier>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER:
				getInheritedMember().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL:
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__INHERITED_MEMBER:
				return inheritedMember != null && !inheritedMember.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_SUPER_CLASSIFIER__GENERAL:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isAbstract: ");
		result.append(isAbstract);
		result.append(')');
		return result.toString();
	}

} //CoreAbstractionsSuperClassifierImpl
