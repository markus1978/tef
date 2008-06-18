/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.validation;

import hub.sam.sdl.SdlOpenRange;

/**
 * A sample validator interface for {@link hub.sam.sdl.SdlClosedRange}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SdlClosedRangeValidator {
	boolean validate();

	boolean validateUpper(SdlOpenRange value);
	boolean validateLower(SdlOpenRange value);
}
