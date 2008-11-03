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
 * A representation of the model object '<em><b>Concrete Syntax Sdl State List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.ConcreteSyntaxSdlStateList#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlStateList()
 * @model
 * @generated
 */
public interface ConcreteSyntaxSdlStateList extends SdlState {
	/**
	 * Returns the value of the '<em><b>Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Names</em>' attribute list.
	 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlStateList_Names()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<String> getNames();

} // ConcreteSyntaxSdlStateList
