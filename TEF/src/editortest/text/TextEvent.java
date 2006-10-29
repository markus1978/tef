package editortest.text;

import org.eclipse.jface.text.IDocument;

public class TextEvent {
	
	private int begin;
	private String text;
	private int end;
	private final IDocument fDocument;

	public TextEvent(IDocument document, int begin, String text) {
		super();
		this.begin = begin;
		this.end = begin;
		this.text = text;
		fDocument = document;
	}
	
	public TextEvent(IDocument document, int begin, int end, String text) {
		this.begin = begin;
		this.end = end;
		this.text = text;
		fDocument = document;
	}
	
	/**
	 * Creates an inner event from an outerevent based on the offset(begin) of 
	 * the inner event in the inner text. 
	 */
	public TextEvent(TextEvent e, int offset) {
		begin = offset; 
		end = offset + e.getEnd() - e.getBegin();
		text = e.getText();
		fDocument = e.fDocument;
	}
	
	public IDocument getDocument() {
		return fDocument;
	}
	
	/**
	 * Changes this outer event from an innerevent based on the offset(begin) of 
	 * the inner event in the inner text. 
	 */	
	public void updateFromOffset(TextEvent e, int offset) {
		end = offset + e.getEnd();
		begin = offset + e.getBegin();
		text = e.getText();
	}

	public int getBegin() {
		return begin;
	}	
	
	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
