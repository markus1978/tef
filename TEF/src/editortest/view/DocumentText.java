package editortest.view;

import org.eclipse.jface.text.BadLocationException;

import editortest.editor.TEFDocument;

public class DocumentText extends CompoundText {
	
	private final TEFDocument fDocument;

	public DocumentText(TEFDocument document) {
		this.fDocument = document;
	}	
	
	@Override
	public void changeContent(int begin, int end, String text) {
		super.changeContent(begin, end, text);
		try {
			fDocument.doReplace(begin, end-begin, text);
		} catch (BadLocationException e) {		
			e.printStackTrace();
		}
	}

	public TEFDocument getDocument() {
		return fDocument;
	}
}
