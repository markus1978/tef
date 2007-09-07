package hub.sam.tef.completion;

import hub.sam.tef.models.IModelElement;

/**
 * An interface that can be used by completion collecting functions to allow the user to filter unwanted
 * completion proposals.
 */
public interface ICompletionFilter {
	public boolean accept(IModelElement obj);
}
