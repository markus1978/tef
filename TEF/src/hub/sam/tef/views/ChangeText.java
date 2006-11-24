package hub.sam.tef.views;

/**
 * This represents a edge node in a text hierarchy with changing content. 
 * Opposite to {@link FixText}.
 */
public class ChangeText extends Text {
	
	private boolean isNull = false;
	
	/**
	 * Changes the content of this Text. When this Text is not
	 * {@link Text#isHidden()} it will imidiatly shown in the eclipse view. It
	 * will in all cases cause notification to all handler registred via
	 * {@link Text#addTextChangeListener(IContentChangeListener).
	 * 
	 * @param text
	 *            The new content of this Text. If it the content is null, "<null>" will
	 *            be used as content.
	 */
	public void setText(String text) {
		if (text == null) {
			changeContent(0, getLength(), "<null>");
			isNull = true;
		} else {
			changeContent(0, getLength(), text);
			isNull = false;
		}
	}

	/**
	 * @return True if this Text content's is "<null>".
	 */
	public boolean isNull() {
		return isNull;
	}
}
