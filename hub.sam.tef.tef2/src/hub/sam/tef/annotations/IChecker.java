package hub.sam.tef.annotations;

import hub.sam.tef.models.IModelElement;

public interface IChecker {

	/**
	 * Returns null of the modelElement does not contain any errors. Returns an
	 * error description otherwise.
	 */
	String check(IModelElement modelElement);
}
