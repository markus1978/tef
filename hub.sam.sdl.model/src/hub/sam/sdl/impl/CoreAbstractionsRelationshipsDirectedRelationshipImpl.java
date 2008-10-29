/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.CoreAbstractionsRelationshipsDirectedRelationship;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Relationships Directed Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl#getSource <em>Source</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsRelationshipsDirectedRelationshipImpl extends CoreAbstractionsRelationshipsRelationshipImpl implements CoreAbstractionsRelationshipsDirectedRelationship {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsRelationshipsDirectedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsRelationshipsDirectedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getSource() {
		if (source == null) {
			source = new EObjectContainmentEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getTarget() {
		if (target == null) {
			target = new EObjectContainmentEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE:
				return ((InternalEList<?>)getSource()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET:
				return ((InternalEList<?>)getTarget()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE:
				return getSource();
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET:
				return getTarget();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE:
				getSource().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET:
				getTarget().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__SOURCE:
				return source != null && !source.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__TARGET:
				return target != null && !target.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsRelationshipsDirectedRelationshipImpl
