package editortest.view;

/**
 * This is used for a constant edge Text node. This is the opposite to
 * {@link ChangeText}.
 */
public class FixText extends Text {	
	/**
	 * @param text The content that this Text will show, unchangeable.
	 */
	public FixText(String text) {
		changeContent(0, getLength(), text);
	}
}
