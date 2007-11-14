package hub.sam.tef.contentassist;

/**
 * An interface that can be used by completion collecting functions to allow the
 * user to filter unwanted completion proposals.
 */
public interface ICompletionFilter {
	public boolean accept(Object obj);
}
