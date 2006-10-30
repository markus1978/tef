package editortest.text;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import editortest.editor.TEFDocument;

public class Document extends CompoundText {
	
	private final TEFDocument fDocument;

	public Document(TEFDocument document) {
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

	public IDocument getDocument() {
		return fDocument;
	}		
}
