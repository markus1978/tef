/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package editortest.emf.expressions.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link editortest.emf.expressions.emfmodel.Identifier#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getIdentifier()
 * @model
 * @generated
 */
public interface Identifier extends Expression {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see editortest.emf.expressions.emfmodel.ExpressionsPackage#getIdentifier_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link editortest.emf.expressions.emfmodel.Identifier#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Identifier