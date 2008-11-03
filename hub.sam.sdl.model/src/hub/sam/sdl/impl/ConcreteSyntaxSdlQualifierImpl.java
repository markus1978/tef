/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

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

	/**
	 * @generated NOT
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int pathItemHashCode = 0;
		if (pathItem != null) {
			for(Object o: pathItem) {
				pathItemHashCode += o.hashCode();
			}
		}
		result = prime * result
				+ ((pathItem == null) ? 0 : pathItemHashCode);
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ConcreteSyntaxSdlQualifierImpl other = (ConcreteSyntaxSdlQualifierImpl) obj;
		if (pathItem == null) {
			if (other.pathItem != null)
				return false;
		} else {
			if (other.pathItem.size() == pathItem.size()) {
				for (int i = 0; i < pathItem.size(); i++) {
					if (!other.pathItem.get(i).equals(pathItem.get(i))) {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
} //ConcreteSyntaxSdlQualifierImpl
