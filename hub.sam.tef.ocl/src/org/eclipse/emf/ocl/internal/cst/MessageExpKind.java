/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Message Exp Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getMessageExpKind()
 * @model
 * @generated
 */
public final class MessageExpKind extends AbstractEnumerator {
	/**
	 * The '<em><b>Has Sent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Has Sent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HAS_SENT_LITERAL
	 * @model name="hasSent"
	 * @generated
	 * @ordered
	 */
	public static final int HAS_SENT = 1;

	/**
	 * The '<em><b>Sent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SENT_LITERAL
	 * @model name="sent"
	 * @generated
	 * @ordered
	 */
	public static final int SENT = 2;

	/**
	 * The '<em><b>Has Sent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HAS_SENT
	 * @generated
	 * @ordered
	 */
	public static final MessageExpKind HAS_SENT_LITERAL = new MessageExpKind(HAS_SENT, "hasSent", "hasSent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENT
	 * @generated
	 * @ordered
	 */
	public static final MessageExpKind SENT_LITERAL = new MessageExpKind(SENT, "sent", "sent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Message Exp Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MessageExpKind[] VALUES_ARRAY =
		new MessageExpKind[] {
			HAS_SENT_LITERAL,
			SENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Message Exp Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Message Exp Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageExpKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageExpKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Exp Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageExpKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MessageExpKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Exp Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessageExpKind get(int value) {
		switch (value) {
			case HAS_SENT: return HAS_SENT_LITERAL;
			case SENT: return SENT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MessageExpKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} //MessageExpKind
