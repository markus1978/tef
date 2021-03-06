/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.validation;

import hub.sam.sdl.SdlInstance;
import hub.sam.sdl.SdlVariableSlot;

/**
 * A sample validator interface for {@link hub.sam.sdl.SdlInstance}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SdlInstanceValidator {
	boolean validate();

	boolean validateVariable(SdlVariableSlot value);
	boolean validateContainingInstance(SdlInstance value);
}
