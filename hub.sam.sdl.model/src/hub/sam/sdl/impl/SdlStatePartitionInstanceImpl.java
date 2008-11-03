/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlStateInstance;
import hub.sam.sdl.SdlStatePartitionInstance;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl State Partition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlStatePartitionInstanceImpl#getActualState <em>Actual State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlStatePartitionInstanceImpl extends SdlStateInstanceImpl implements SdlStatePartitionInstance {
	/**
	 * The cached value of the '{@link #getActualState() <em>Actual State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualState()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlStateInstance> actualState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlStatePartitionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlStatePartitionInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlStateInstance> getActualState() {
		if (actualState == null) {
			actualState = new EObjectResolvingEList<SdlStateInstance>(SdlStateInstance.class, this, EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE);
		}
		return actualState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE:
				return getActualState();
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
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE:
				getActualState().clear();
				getActualState().addAll((Collection<? extends SdlStateInstance>)newValue);
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
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE:
				getActualState().clear();
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
			case EmfSdlPackage.SDL_STATE_PARTITION_INSTANCE__ACTUAL_STATE:
				return actualState != null && !actualState.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SdlStatePartitionInstanceImpl
