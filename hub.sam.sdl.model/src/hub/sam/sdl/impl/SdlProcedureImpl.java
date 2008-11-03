/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsGeneralizationsClassifier;
import hub.sam.sdl.CoreAbstractionsGeneralizationsGeneralization;
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.InstanciationInstance;
import hub.sam.sdl.SdlBehavior;
import hub.sam.sdl.SdlBehaviorElement;
import hub.sam.sdl.SdlClassifier;
import hub.sam.sdl.SdlNamespace;
import hub.sam.sdl.SdlParameter;
import hub.sam.sdl.SdlProcedure;
import hub.sam.sdl.SdlStateAutomaton;
import hub.sam.sdl.SdlVariable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getTypedElement_type <em>Typed Element type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getSdlBehaviorElement_behavior <em>Sdl Behavior Element behavior</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlProcedureImpl#getProcedureStateAutomaton <em>Procedure State Automaton</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlProcedureImpl extends CoreAbstractionsBehavioralFeaturesBehavioralFeatureImpl implements SdlProcedure {
	/**
	 * The cached value of the '{@link #getTypedElement_type() <em>Typed Element type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedElement_type()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsTypedElementsType typedElement_type;

	/**
	 * The cached value of the '{@link #getSdlBehaviorElement_behavior() <em>Sdl Behavior Element behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSdlBehaviorElement_behavior()
	 * @generated
	 * @ordered
	 */
	protected SdlBehavior sdlBehaviorElement_behavior;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsTypedElementsType> ownedType;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsClassifiersFeature> feature;

	/**
	 * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralization()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsGeneralization> generalization;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsGeneralizationsClassifier> general;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlVariable> variable;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlProcedure> procedure;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlParameter> parameter;

	/**
	 * The cached value of the '{@link #getProcedureStateAutomaton() <em>Procedure State Automaton</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedureStateAutomaton()
	 * @generated
	 * @ordered
	 */
	protected SdlStateAutomaton procedureStateAutomaton;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlProcedure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType getTypedElement_type() {
		if (typedElement_type != null && typedElement_type.eIsProxy()) {
			InternalEObject oldTypedElement_type = (InternalEObject)typedElement_type;
			typedElement_type = (CoreAbstractionsTypedElementsType)eResolveProxy(oldTypedElement_type);
			if (typedElement_type != oldTypedElement_type) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE, oldTypedElement_type, typedElement_type));
			}
		}
		return typedElement_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType basicGetTypedElement_type() {
		return typedElement_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedElement_type(CoreAbstractionsTypedElementsType newTypedElement_type) {
		CoreAbstractionsTypedElementsType oldTypedElement_type = typedElement_type;
		typedElement_type = newTypedElement_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE, oldTypedElement_type, typedElement_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlBehavior getSdlBehaviorElement_behavior() {
		return sdlBehaviorElement_behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSdlBehaviorElement_behavior(SdlBehavior newSdlBehaviorElement_behavior, NotificationChain msgs) {
		SdlBehavior oldSdlBehaviorElement_behavior = sdlBehaviorElement_behavior;
		sdlBehaviorElement_behavior = newSdlBehaviorElement_behavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, oldSdlBehaviorElement_behavior, newSdlBehaviorElement_behavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSdlBehaviorElement_behavior(SdlBehavior newSdlBehaviorElement_behavior) {
		if (newSdlBehaviorElement_behavior != sdlBehaviorElement_behavior) {
			NotificationChain msgs = null;
			if (sdlBehaviorElement_behavior != null)
				msgs = ((InternalEObject)sdlBehaviorElement_behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, null, msgs);
			if (newSdlBehaviorElement_behavior != null)
				msgs = ((InternalEObject)newSdlBehaviorElement_behavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, null, msgs);
			msgs = basicSetSdlBehaviorElement_behavior(newSdlBehaviorElement_behavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR, newSdlBehaviorElement_behavior, newSdlBehaviorElement_behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsTypedElementsType> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentEList<CoreAbstractionsTypedElementsType>(CoreAbstractionsTypedElementsType.class, this, EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectWithInverseResolvingEList.ManyInverse<CoreAbstractionsClassifiersFeature>(CoreAbstractionsClassifiersFeature.class, this, EmfSdlPackage.SDL_PROCEDURE__FEATURE, EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_FEATURE__FEATURING_CLASSIFIER);
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsGeneralization> getGeneralization() {
		if (generalization == null) {
			generalization = new EObjectContainmentWithInverseEList<CoreAbstractionsGeneralizationsGeneralization>(CoreAbstractionsGeneralizationsGeneralization.class, this, EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION, EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_GENERALIZATION__SPECIFIC);
		}
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> getGeneral() {
		if (general == null) {
			general = new EObjectResolvingEList<CoreAbstractionsGeneralizationsClassifier>(CoreAbstractionsGeneralizationsClassifier.class, this, EmfSdlPackage.SDL_PROCEDURE__GENERAL);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlVariable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<SdlVariable>(SdlVariable.class, this, EmfSdlPackage.SDL_PROCEDURE__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlProcedure> getProcedure() {
		if (procedure == null) {
			procedure = new EObjectContainmentEList<SdlProcedure>(SdlProcedure.class, this, EmfSdlPackage.SDL_PROCEDURE__PROCEDURE);
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<SdlParameter>(SdlParameter.class, this, EmfSdlPackage.SDL_PROCEDURE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SdlStateAutomaton getProcedureStateAutomaton() {
		return procedureStateAutomaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcedureStateAutomaton(SdlStateAutomaton newProcedureStateAutomaton, NotificationChain msgs) {
		SdlStateAutomaton oldProcedureStateAutomaton = procedureStateAutomaton;
		procedureStateAutomaton = newProcedureStateAutomaton;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON, oldProcedureStateAutomaton, newProcedureStateAutomaton);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureStateAutomaton(SdlStateAutomaton newProcedureStateAutomaton) {
		if (newProcedureStateAutomaton != procedureStateAutomaton) {
			NotificationChain msgs = null;
			if (procedureStateAutomaton != null)
				msgs = ((InternalEObject)procedureStateAutomaton).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON, null, msgs);
			if (newProcedureStateAutomaton != null)
				msgs = ((InternalEObject)newProcedureStateAutomaton).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON, null, msgs);
			msgs = basicSetProcedureStateAutomaton(newProcedureStateAutomaton, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON, newProcedureStateAutomaton, newProcedureStateAutomaton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> general() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsGeneralizationsClassifier> parents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean conformsTo(CoreAbstractionsGeneralizationsClassifier other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsClassifiersFeature> allFeatures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationInstance instanciate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean conformsTo(CoreAbstractionsTypedElementsType other) {
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
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralization()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return basicSetSdlBehaviorElement_behavior(null, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
				return basicSetProcedureStateAutomaton(null, msgs);
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
			case EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE:
				if (resolve) return getTypedElement_type();
				return basicGetTypedElement_type();
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return getSdlBehaviorElement_behavior();
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
				return getOwnedType();
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				return getFeature();
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				return getGeneralization();
			case EmfSdlPackage.SDL_PROCEDURE__GENERAL:
				return getGeneral();
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
				return getVariable();
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
				return getProcedure();
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
				return getParameter();
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
				return getProcedureStateAutomaton();
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
			case EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE:
				setTypedElement_type((CoreAbstractionsTypedElementsType)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				setSdlBehaviorElement_behavior((SdlBehavior)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends CoreAbstractionsTypedElementsType>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends CoreAbstractionsClassifiersFeature>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				getGeneralization().clear();
				getGeneralization().addAll((Collection<? extends CoreAbstractionsGeneralizationsGeneralization>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends CoreAbstractionsGeneralizationsClassifier>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends SdlVariable>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends SdlProcedure>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends SdlParameter>)newValue);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
				setProcedureStateAutomaton((SdlStateAutomaton)newValue);
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
			case EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE:
				setTypedElement_type((CoreAbstractionsTypedElementsType)null);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				setSdlBehaviorElement_behavior((SdlBehavior)null);
				return;
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				getFeature().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				getGeneralization().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__GENERAL:
				getGeneral().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
				getVariable().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
				getProcedure().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
				getParameter().clear();
				return;
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
				setProcedureStateAutomaton((SdlStateAutomaton)null);
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
			case EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE:
				return typedElement_type != null;
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
				return sdlBehaviorElement_behavior != null;
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__FEATURE:
				return feature != null && !feature.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
				return generalization != null && !generalization.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__GENERAL:
				return general != null && !general.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
				return variable != null && !variable.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
				return procedureStateAutomaton != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE: return EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;
				default: return -1;
			}
		}
		if (baseClass == SdlBehaviorElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR: return EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE: return EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__FEATURE: return EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION;
				case EmfSdlPackage.SDL_PROCEDURE__GENERAL: return EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_PROCEDURE__VARIABLE: return EmfSdlPackage.SDL_CLASSIFIER__VARIABLE;
				case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE: return EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE: return EmfSdlPackage.SDL_PROCEDURE__TYPED_ELEMENT_TYPE;
				default: return -1;
			}
		}
		if (baseClass == SdlBehaviorElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_BEHAVIOR_ELEMENT__SDL_BEHAVIOR_ELEMENT_BEHAVIOR: return EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR;
				default: return -1;
			}
		}
		if (baseClass == SdlNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_NAMESPACE__OWNED_TYPE: return EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsClassifiersClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_CLASSIFIERS_CLASSIFIER__FEATURE: return EmfSdlPackage.SDL_PROCEDURE__FEATURE;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsGeneralizationsClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERALIZATION: return EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION;
				case EmfSdlPackage.CORE_ABSTRACTIONS_GENERALIZATIONS_CLASSIFIER__GENERAL: return EmfSdlPackage.SDL_PROCEDURE__GENERAL;
				default: return -1;
			}
		}
		if (baseClass == SdlClassifier.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.SDL_CLASSIFIER__VARIABLE: return EmfSdlPackage.SDL_PROCEDURE__VARIABLE;
				case EmfSdlPackage.SDL_CLASSIFIER__PROCEDURE: return EmfSdlPackage.SDL_PROCEDURE__PROCEDURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SdlProcedureImpl
