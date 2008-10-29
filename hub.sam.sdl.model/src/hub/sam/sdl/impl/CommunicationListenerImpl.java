/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.CommunicationEvent;
import hub.sam.sdl.CommunicationListener;
import hub.sam.sdl.EmfSdlPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class CommunicationListenerImpl extends CoreAbstractionsElementsElementImpl implements CommunicationListener {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getCommunicationListener();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean listensTo(CommunicationEvent e) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //CommunicationListenerImpl
