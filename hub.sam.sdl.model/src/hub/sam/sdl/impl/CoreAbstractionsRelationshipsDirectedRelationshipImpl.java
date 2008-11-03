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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Relationships Directed Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl#getDirectedRelationship_source <em>Directed Relationship source</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsDirectedRelationshipImpl#getDirectedRelationship_target <em>Directed Relationship target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsRelationshipsDirectedRelationshipImpl extends CoreAbstractionsRelationshipsRelationshipImpl implements CoreAbstractionsRelationshipsDirectedRelationship {
	/**
	 * The cached value of the '{@link #getDirectedRelationship_source() <em>Directed Relationship source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectedRelationship_source()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> directedRelationship_source;

	/**
	 * The cached value of the '{@link #getDirectedRelationship_target() <em>Directed Relationship target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectedRelationship_target()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> directedRelationship_target;

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
	public EList<CoreAbstractionsOwnershipsElement> getDirectedRelationship_source() {
		if (directedRelationship_source == null) {
			directedRelationship_source = new EObjectResolvingEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE);
		}
		return directedRelationship_source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getDirectedRelationship_target() {
		if (directedRelationship_target == null) {
			directedRelationship_target = new EObjectResolvingEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET);
		}
		return directedRelationship_target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE:
				return getDirectedRelationship_source();
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET:
				return getDirectedRelationship_target();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE:
				getDirectedRelationship_source().clear();
				getDirectedRelationship_source().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET:
				getDirectedRelationship_target().clear();
				getDirectedRelationship_target().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE:
				getDirectedRelationship_source().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET:
				getDirectedRelationship_target().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_SOURCE:
				return directedRelationship_source != null && !directedRelationship_source.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_DIRECTED_RELATIONSHIP__DIRECTED_RELATIONSHIP_TARGET:
				return directedRelationship_target != null && !directedRelationship_target.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsRelationshipsDirectedRelationshipImpl
