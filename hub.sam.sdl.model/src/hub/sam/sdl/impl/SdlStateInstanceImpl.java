/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlStateInstance;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl State Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlStateInstanceImpl#getSdlStateInstance_actualState <em>Sdl State Instance actual State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlStateInstanceImpl extends EObjectImpl implements SdlStateInstance {
	/**
	 * The cached value of the '{@link #getSdlStateInstance_actualState() <em>Sdl State Instance actual State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSdlStateInstance_actualState()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlStateInstance> sdlStateInstance_actualState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlStateInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlStateInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlStateInstance> getSdlStateInstance_actualState() {
		if (sdlStateInstance_actualState == null) {
			sdlStateInstance_actualState = new EObjectResolvingEList<SdlStateInstance>(SdlStateInstance.class, this, EmfSdlPackage.SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE);
		}
		return sdlStateInstance_actualState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE:
				return getSdlStateInstance_actualState();
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
			case EmfSdlPackage.SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE:
				getSdlStateInstance_actualState().clear();
				getSdlStateInstance_actualState().addAll((Collection<? extends SdlStateInstance>)newValue);
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
			case EmfSdlPackage.SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE:
				getSdlStateInstance_actualState().clear();
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
			case EmfSdlPackage.SDL_STATE_INSTANCE__SDL_STATE_INSTANCE_ACTUAL_STATE:
				return sdlStateInstance_actualState != null && !sdlStateInstance_actualState.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SdlStateInstanceImpl
