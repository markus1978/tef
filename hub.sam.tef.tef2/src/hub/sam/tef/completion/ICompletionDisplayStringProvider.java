package hub.sam.tef.completion;

import hub.sam.tef.models.IModelElement;

/**
 * An interface that can be used by completion collecting functions to let the user determine the
 * display string of a completion.
 */
public interface ICompletionDisplayStringProvider {
	public String getDisplayString(IModelElement element);
}
