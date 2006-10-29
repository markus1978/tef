package editortest.text;

import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.IRegion;

public abstract class Text {
	
	private int length = 0;	
	private CompoundText container = null;
	private StringBuffer content = new StringBuffer("");

	private final List<TextEventListener> fEventHandler = new Vector<TextEventListener>();
	private final List<ITextChangeListener> fChangeListener = new Vector<ITextChangeListener>();
	
	public Text() {
		this.container = null;
	}
	
	/**
	 * Returns a String with the text as content.
	 */
	public final String getContent(int begin, int end) {
		if (container != null) {
			return container.getContent(this, begin, end);
		} else {				
			return content.substring(begin, end);
		}
	}
	
	public final String getContent() {
		return getContent(0, getLength());
	}
	
	public void changeContent(int begin, int end, String text) {
		if (container != null) {
			length = length - (end - begin) + text.length();
			container.changeContent(this, begin, end, text);			
		} else {
			content.replace(begin, end, text);
		}
		for (ITextChangeListener changeListener: fChangeListener) {
			changeListener.textChanged(this);
		}
	}
	
	/**
	 * Returns the length of this text.
	 */
	public final int getLength() {
		if (container != null) {
			return length;
		} else {
			return content.length();
		}
	}
	
	protected final void setContainer(CompoundText container) {
		this.container = container;
		changeContent(0,0, content.toString());
		content = null;
	}
	
	public final CompoundText getContainer() {
		return container;
	}
	
	public void process(ITextVisitor visitor, int atOffset) {
		visitor.visitText(this, atOffset);
	}
	
	public final int getAbsolutOffset(int offset) {
		if (container == null) {
			return offset;
		} else {
			return container.getAbsolutOffset(0) + container.getBeginOf(this) + offset;
		}
	}
	
	public void addEventHandler(TextEventListener eventHandler) {
		this.fEventHandler.add(eventHandler);
	}
	
	public List<TextEventListener> getEventHandler() {
		return fEventHandler;
	}

	public void addTextChangeListener(ITextChangeListener textChangeListener) {
		this.fChangeListener.add(textChangeListener);
	}
}
