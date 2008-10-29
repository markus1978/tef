/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsRedefinitionsRedefinableElement;
import hub.sam.sdl.CoreAbstractionsSuperClassifier;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Abstractions Redefinitions Redefinable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRedefinitionsRedefinableElementImpl#getRedefinedElement <em>Redefined Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.CoreAbstractionsRedefinitionsRedefinableElementImpl#getRedefinitionContext <em>Redefinition Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CoreAbstractionsRedefinitionsRedefinableElementImpl extends CoreAbstractionsNamespacesNamedElementImpl implements CoreAbstractionsRedefinitionsRedefinableElement {
	/**
	 * The cached value of the '{@link #getRedefinedElement() <em>Redefined Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsRedefinitionsRedefinableElement> redefinedElement;

	/**
	 * The cached value of the '{@link #getRedefinitionContext() <em>Redefinition Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinitionContext()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsSuperClassifier> redefinitionContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreAbstractionsRedefinitionsRedefinableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCoreAbstractionsRedefinitionsRedefinableElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsRedefinitionsRedefinableElement> getRedefinedElement() {
		if (redefinedElement == null) {
			redefinedElement = new EObjectResolvingEList<CoreAbstractionsRedefinitionsRedefinableElement>(CoreAbstractionsRedefinitionsRedefinableElement.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT);
		}
		return redefinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsSuperClassifier> getRedefinitionContext() {
		if (redefinitionContext == null) {
			redefinitionContext = new EObjectResolvingEList<CoreAbstractionsSuperClassifier>(CoreAbstractionsSuperClassifier.class, this, EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT);
		}
		return redefinitionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConsistentWith(CoreAbstractionsRedefinitionsRedefinableElement redefinee) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRedefinitionContextValid(CoreAbstractionsRedefinitionsRedefinableElement redefined) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT:
				return getRedefinedElement();
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				return getRedefinitionContext();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT:
				getRedefinedElement().clear();
				getRedefinedElement().addAll((Collection<? extends CoreAbstractionsRedefinitionsRedefinableElement>)newValue);
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				getRedefinitionContext().clear();
				getRedefinitionContext().addAll((Collection<? extends CoreAbstractionsSuperClassifier>)newValue);
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT:
				getRedefinedElement().clear();
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				getRedefinitionContext().clear();
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
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINED_ELEMENT:
				return redefinedElement != null && !redefinedElement.isEmpty();
			case EmfSdlPackage.CORE_ABSTRACTIONS_REDEFINITIONS_REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
				return redefinitionContext != null && !redefinitionContext.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoreAbstractionsRedefinitionsRedefinableElementImpl
