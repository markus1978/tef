/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.CoreAbstractionsRelationshipsRelationship;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Relationships Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRelationshipsRelationshipImpl#getRelationship_relatedElement <em>Relationship related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsRelationshipsRelationshipImpl extends CoreAbstractionsOwnershipsElementImpl implements CoreAbstractionsRelationshipsRelationship {
	/**
	 * The cached value of the '{@link #getRelationship_relatedElement() <em>Relationship related Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationship_relatedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> relationship_relatedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsRelationshipsRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsRelationshipsRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getRelationship_relatedElement() {
		if (relationship_relatedElement == null) {
			relationship_relatedElement = new EObjectResolvingEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT);
		}
		return relationship_relatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT:
				return getRelationship_relatedElement();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT:
				getRelationship_relatedElement().clear();
				getRelationship_relatedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT:
				getRelationship_relatedElement().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_RELATIONSHIPS_RELATIONSHIP__RELATIONSHIP_RELATED_ELEMENT:
				return relationship_relatedElement != null && !relationship_relatedElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsRelationshipsRelationshipImpl
