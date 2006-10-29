package editortest.text;

/**
 * Implementations of this interface can traverse a tree of texts. This interface
 * is also used to control the recursive decent along a tree of texts.
 */
public interface ITextVisitor {
	
	/**
	 * This method is called when this visitor visits a {@link Text} that is not a
	 * {@link CompoundText}.
	 */
	public void visitText(Text visitedText, int atOffset);
	
	/**
	 * This method is called when this visitor visits a {@link CompoundText}.
	 * A {@link CompoundText} is always visited after its children have 
	 * been visited.
	 */
	public void visitCompoundText(CompoundText visitedText, int atOffset);
	
	/**
	 * This method should return all children of the given {@link CompoundText}
	 * that this visitor shall be visit before it visits the {@link CompoundText}
	 * itself. The method must only return texts that a direct children of
	 * the given text.
	 */
	public Iterable<Text> decentInto(CompoundText text);
}
