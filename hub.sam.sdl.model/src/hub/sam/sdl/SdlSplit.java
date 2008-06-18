/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlSplit#getQuestion <em>Question</em>}</li>
 *   <li>{@link hub.sam.sdl.SdlSplit#getAnswer <em>Answer</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlSplit()
 * @model
 * @generated
 */
public interface SdlSplit extends SdlPseudoState {
	/**
	 * Returns the value of the '<em><b>Question</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Question</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Question</em>' containment reference.
	 * @see #setQuestion(EvaluationExpression)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSplit_Question()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EvaluationExpression getQuestion();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlSplit#getQuestion <em>Question</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Question</em>' containment reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(EvaluationExpression value);

	/**
	 * Returns the value of the '<em><b>Answer</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.SdlChoice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Answer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Answer</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlSplit_Answer()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<SdlChoice> getAnswer();

} // SdlSplit
