/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hub.sam.sdl.EmfSdlPackage#getConcreteSyntaxSdlScopeUnitKind()
 * @model
 * @generated
 */
public enum ConcreteSyntaxSdlScopeUnitKind implements Enumerator {
	/**
	 * The '<em><b>Package</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	PACKAGE(0, "Package", "Package"),

	/**
	 * The '<em><b>System Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_TYPE(1, "SystemType", "SystemType"),

	/**
	 * The '<em><b>Process Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESS_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESS_TYPE(2, "ProcessType", "ProcessType"),

	/**
	 * The '<em><b>Block Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCK_TYPE(3, "BlockType", "BlockType"),

	/**
	 * The '<em><b>Signal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNAL_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNAL(4, "Signal", "Signal"),

	/**
	 * The '<em><b>Procedure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE_VALUE
	 * @generated
	 * @ordered
	 */
	PROCEDURE(5, "Procedure", "Procedure"),

	/**
	 * The '<em><b>System</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM(6, "System", "System"),

	/**
	 * The '<em><b>Block</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCK(7, "Block", "Block"),

	/**
	 * The '<em><b>Process</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESS_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESS(8, "Process", "Process"),

	/**
	 * The '<em><b>State Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_TYPE(9, "StateType", "StateType"),

	/**
	 * The '<em><b>State</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE(10, "State", "State");

	/**
	 * The '<em><b>Package</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PACKAGE
	 * @model name="Package"
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_VALUE = 0;

	/**
	 * The '<em><b>System Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_TYPE
	 * @model name="SystemType"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_TYPE_VALUE = 1;

	/**
	 * The '<em><b>Process Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Process Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESS_TYPE
	 * @model name="ProcessType"
	 * @generated
	 * @ordered
	 */
	public static final int PROCESS_TYPE_VALUE = 2;

	/**
	 * The '<em><b>Block Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Block Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOCK_TYPE
	 * @model name="BlockType"
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_TYPE_VALUE = 3;

	/**
	 * The '<em><b>Signal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Signal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIGNAL
	 * @model name="Signal"
	 * @generated
	 * @ordered
	 */
	public static final int SIGNAL_VALUE = 4;

	/**
	 * The '<em><b>Procedure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Procedure</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE
	 * @model name="Procedure"
	 * @generated
	 * @ordered
	 */
	public static final int PROCEDURE_VALUE = 5;

	/**
	 * The '<em><b>System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM
	 * @model name="System"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_VALUE = 6;

	/**
	 * The '<em><b>Block</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Block</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOCK
	 * @model name="Block"
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_VALUE = 7;

	/**
	 * The '<em><b>Process</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Process</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESS
	 * @model name="Process"
	 * @generated
	 * @ordered
	 */
	public static final int PROCESS_VALUE = 8;

	/**
	 * The '<em><b>State Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>State Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE_TYPE
	 * @model name="StateType"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_TYPE_VALUE = 9;

	/**
	 * The '<em><b>State</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>State</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE
	 * @model name="State"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConcreteSyntaxSdlScopeUnitKind[] VALUES_ARRAY =
		new ConcreteSyntaxSdlScopeUnitKind[] {
			PACKAGE,
			SYSTEM_TYPE,
			PROCESS_TYPE,
			BLOCK_TYPE,
			SIGNAL,
			PROCEDURE,
			SYSTEM,
			BLOCK,
			PROCESS,
			STATE_TYPE,
			STATE,
		};

	/**
	 * A public read-only list of all the '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConcreteSyntaxSdlScopeUnitKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcreteSyntaxSdlScopeUnitKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConcreteSyntaxSdlScopeUnitKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcreteSyntaxSdlScopeUnitKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConcreteSyntaxSdlScopeUnitKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Concrete Syntax Sdl Scope Unit Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcreteSyntaxSdlScopeUnitKind get(int value) {
		switch (value) {
			case PACKAGE_VALUE: return PACKAGE;
			case SYSTEM_TYPE_VALUE: return SYSTEM_TYPE;
			case PROCESS_TYPE_VALUE: return PROCESS_TYPE;
			case BLOCK_TYPE_VALUE: return BLOCK_TYPE;
			case SIGNAL_VALUE: return SIGNAL;
			case PROCEDURE_VALUE: return PROCEDURE;
			case SYSTEM_VALUE: return SYSTEM;
			case BLOCK_VALUE: return BLOCK;
			case PROCESS_VALUE: return PROCESS;
			case STATE_TYPE_VALUE: return STATE_TYPE;
			case STATE_VALUE: return STATE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConcreteSyntaxSdlScopeUnitKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ConcreteSyntaxSdlScopeUnitKind
