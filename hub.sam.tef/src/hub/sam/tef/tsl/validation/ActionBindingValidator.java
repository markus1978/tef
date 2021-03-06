/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.validation;

import hub.sam.tef.tsl.Statement;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hub.sam.tef.tsl.ActionBinding}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ActionBindingValidator {
	boolean validate();

	boolean validateStatements(EList<Statement> value);
}
