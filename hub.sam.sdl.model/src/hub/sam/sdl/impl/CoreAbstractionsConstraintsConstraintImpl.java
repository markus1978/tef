/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsConstraintsConstraint;
import hub.sam.sdl.CoreAbstractionsConstraintsNamespace;
import hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification;
import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Constraints Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsConstraintImpl#getContext <em>Context</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsConstraintImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsConstraintsConstraintImpl#getConstrainedElement <em>Constrained Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreAbstractionsConstraintsConstraintImpl extends CoreAbstractionsConstraintsNamedElementImpl implements CoreAbstractionsConstraintsConstraint {
	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsExpressionsValueSpecification specification;

	/**
	 * The cached value of the '{@link #getConstrainedElement() <em>Constrained Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> constrainedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsConstraintsConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsConstraintsConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsConstraintsNamespace getContext() {
		if (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT) return null;
		return (CoreAbstractionsConstraintsNamespace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(CoreAbstractionsConstraintsNamespace newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(CoreAbstractionsConstraintsNamespace newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID != EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE, CoreAbstractionsConstraintsNamespace.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsExpressionsValueSpecification getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(CoreAbstractionsExpressionsValueSpecification newSpecification, NotificationChain msgs) {
		CoreAbstractionsExpressionsValueSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION, oldSpecification, newSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(CoreAbstractionsExpressionsValueSpecification newSpecification) {
		if (newSpecification != specification) {
			NotificationChain msgs = null;
			if (specification != null)
				msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION, null, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION, null, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getConstrainedElement() {
		if (constrainedElement == null) {
			constrainedElement = new EObjectResolvingEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT);
		}
		return constrainedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((CoreAbstractionsConstraintsNamespace)otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				return basicSetContext(null, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION:
				return basicSetSpecification(null, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_NAMESPACE__OWNED_RULE, CoreAbstractionsConstraintsNamespace.class, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				return getContext();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION:
				return getSpecification();
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT:
				return getConstrainedElement();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				setContext((CoreAbstractionsConstraintsNamespace)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION:
				setSpecification((CoreAbstractionsExpressionsValueSpecification)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
				getConstrainedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				setContext((CoreAbstractionsConstraintsNamespace)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION:
				setSpecification((CoreAbstractionsExpressionsValueSpecification)null);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONTEXT:
				return getContext() != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__SPECIFICATION:
				return specification != null;
			case EmfSdlPackage.CORE_ABSTRACTIONS_CONSTRAINTS_CONSTRAINT__CONSTRAINED_ELEMENT:
				return constrainedElement != null && !constrainedElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsConstraintsConstraintImpl
