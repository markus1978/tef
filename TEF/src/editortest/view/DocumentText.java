package editortest.view;

import org.eclipse.jface.text.BadLocationException;

import editortest.editor.TEFDocument;
import editortest.editor.TEFSourceViewer;

public class DocumentText extends CompoundText {
	
	private final TEFDocument fDocument;
	private TEFSourceViewer fViewer = null;

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
	
	public void setViewer(TEFSourceViewer viewer) {
		this.fViewer = viewer;
	}
	
	public TEFSourceViewer getViewer() {
		return fViewer;
	}
}
