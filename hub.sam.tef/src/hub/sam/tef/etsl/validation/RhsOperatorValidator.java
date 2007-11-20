/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.etsl.validation;

import hub.sam.tef.etsl.Rhs;

/**
 * A sample validator interface for {@link hub.sam.tef.etsl.RhsOperator}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RhsOperatorValidator {
	boolean validate();

	boolean validateOperand(Rhs value);
}
