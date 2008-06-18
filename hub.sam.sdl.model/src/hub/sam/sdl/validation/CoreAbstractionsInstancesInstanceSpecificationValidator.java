/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.validation;

import hub.sam.sdl.CoreAbstractionsClassifiersClassifier;
import hub.sam.sdl.CoreAbstractionsExpressionsValueSpecification;
import hub.sam.sdl.CoreAbstractionsInstancesSlot;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hub.sam.sdl.CoreAbstractionsInstancesInstanceSpecification}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CoreAbstractionsInstancesInstanceSpecificationValidator {
	boolean validate();

	boolean validateSlot(EList<CoreAbstractionsInstancesSlot> value);
	boolean validateClassifier(EList<CoreAbstractionsClassifiersClassifier> value);
	boolean validateSpecification(CoreAbstractionsExpressionsValueSpecification value);
}
