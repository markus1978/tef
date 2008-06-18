/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsCommentsComment;
import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Ownerships Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsOwnershipsElementImpl#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsOwnershipsElementImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsOwnershipsElementImpl#getOwnedComment <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsOwnershipsElementImpl extends CoreAbstractionsElementsElementImpl implements CoreAbstractionsOwnershipsElement {
	/**
	 * The cached value of the '{@link #getOwnedElement() <em>Owned Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> ownedElement;

	/**
	 * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComment()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsCommentsComment> ownedComment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsOwnershipsElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getOwnedElement() {
		if (ownedElement == null) {
			ownedElement = new EObjectContainmentWithInverseEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER);
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsOwnershipsElement getOwner() {
		if (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER) return null;
		return (CoreAbstractionsOwnershipsElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(CoreAbstractionsOwnershipsElement newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(CoreAbstractionsOwnershipsElement newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsCommentsComment> getOwnedComment() {
		if (ownedComment == null) {
			ownedComment = new EObjectContainmentEList<CoreAbstractionsCommentsComment>(CoreAbstractionsCommentsComment.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT);
		}
		return ownedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> allOwnedElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String mustBeOwned() {
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElement()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((CoreAbstractionsOwnershipsElement)otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				return ((InternalEList<?>)getOwnedElement()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				return basicSetOwner(null, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				return getOwnedElement();
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				return getOwner();
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT:
				return getOwnedComment();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				getOwnedElement().clear();
				getOwnedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends CoreAbstractionsCommentsComment>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				getOwnedElement().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT:
				getOwnedComment().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT:
				return ownedElement != null && !ownedElement.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER:
				return getOwner() != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsOwnershipsElementImpl
