/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsConstraintsConstraint;
import hub.sam.sdl.CoreAbstractionsConstraintsNamedElement;
import hub.sam.sdl.CoreAbstractionsConstraintsNamespace;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Constraints Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsNamespaceImpl#getOwnedRule <em>Owned Rule</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsNamespaceImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsNamespaceImpl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsConstraintsNamespaceImpl extends CoreAbstractionsConstraintsNamedElementImpl implements CoreAbstractionsConstraintsNamespace {
	/**
	 * The cached value of the '{@link #getOwnedRule() <em>Owned Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRule()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsConstraintsConstraint> ownedRule;

	/**
	 * The cached value of the '{@link #getOwnedMember() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsConstraintsNamedElement> ownedMember;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsConstraintsNamedElement> member;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsConstraintsNamespaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsConstraintsNamespace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsConstraintsConstraint> getOwnedRule() {
		if (ownedRule == null) {
			ownedRule = new EObjectContainmentWithInverseEList<CoreAbstractionsConstraintsConstraint>(CoreAbstractionsConstraintsConstraint.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT);
		}
		return ownedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsConstraintsNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsConstraintsNamedElement>(CoreAbstractionsConstraintsNamedElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMED_ELEMENT__NAMESPACE);
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsConstraintsNamedElement> getMember() {
		if (member == null) {
			member = new EObjectResolvingEList<CoreAbstractionsConstraintsNamedElement>(CoreAbstractionsConstraintsNamedElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER);
		}
		return member;
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRule()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				return getOwnedRule();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER:
				return getMember();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends CoreAbstractionsConstraintsConstraint>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsConstraintsNamedElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsConstraintsNamedElement>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER:
				getMember().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__MEMBER:
				return member != null && !member.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsConstraintsNamespaceImpl
