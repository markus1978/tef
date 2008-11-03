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
 * A representation of the model object '<em><b>Concrete Syntax Sdl Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlQualifier#getPathItem <em>Path Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlQualifier()
 * @model
 * @generated
 */
public interface ConcreteSyntaxSdlQualifier extends CoreAbstractionsElementsElement {
	/**
	 * Returns the value of the '<em><b>Path Item</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.sdl.ConcreteSyntaxSdlPathItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Item</em>' containment reference list.
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlQualifier_PathItem()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConcreteSyntaxSdlPathItem> getPathItem();

} // ConcreteSyntaxSdlQualifier
