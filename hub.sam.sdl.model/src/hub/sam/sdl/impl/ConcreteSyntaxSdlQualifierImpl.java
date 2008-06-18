/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.ConcreteSyntaxSdlPathItem;
import hub.sam.sdl.ConcreteSyntaxSdlQualifier;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Syntax Sdl Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.ConcreteSyntaxSdlQualifierImpl#getPathItem <em>Path Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteSyntaxSdlQualifierImpl extends CoreAbstractionsElementsElementImpl implements ConcreteSyntaxSdlQualifier {
	/**
	 * The cached value of the '{@link #getPathItem() <em>Path Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathItem()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteSyntaxSdlPathItem> pathItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteSyntaxSdlQualifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getConcreteSyntaxSdlQualifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteSyntaxSdlPathItem> getPathItem() {
		if (pathItem == null) {
			pathItem = new EObjectContainmentEList<ConcreteSyntaxSdlPathItem>(ConcreteSyntaxSdlPathItem.class, this, EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM);
		}
		return pathItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM:
				return ((InternalEList<?>)getPathItem()).basicRemove(otherEnd, msgs);
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
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM:
				return getPathItem();
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
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM:
				getPathItem().clear();
				getPathItem().addAll((Collection<? extends ConcreteSyntaxSdlPathItem>)newValue);
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
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM:
				getPathItem().clear();
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
			case EmfSdlPackage.CONCRETE_SYNTAX_SDL_QUALIFIER__PATH_ITEM:
				return pathItem != null && !pathItem.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof ConcreteSyntaxSdlQualifier) {
			EList l1 = getPathItem();
			EList l2 = ((ConcreteSyntaxSdlQualifier)arg0).getPathItem();
			if (l1.size() != l2.size()) {
				return false;
			}			
			for (int i = 0; i < l1.size(); i++) {
				if (!l1.get(i).equals(l2.get(i))) {
					return false;
				}
			}
			return true;					
		} else {
			return super.equals(arg0);
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		for (ConcreteSyntaxSdlPathItem pathItem: getPathItem()) {
			hashCode += pathItem.hashCode();
		}
		return hashCode;
	}		

} //ConcreteSyntaxSdlQualifierImpl
