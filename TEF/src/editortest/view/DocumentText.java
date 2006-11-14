package editortest.view;

import org.eclipse.jface.text.BadLocationException;

import editortest.editor.TEFDocument;
import editortest.editor.TEFEditor;
import editortest.editor.TEFSourceViewer;

/**
 * A DocuementText functions as the toplevel text. It is also the interface to
 * the eclipse model (IDocument) and eclipse view (ISourceViewer).
 */
public class DocumentText extends CompoundText {
	
	private final TEFDocument fDocument;
	private TEFSourceViewer fViewer = null;

	public DocumentText(TEFDocument document) {
		this.fDocument = document;		
	}	
	
	/**
	 * Forwards any change to the document to the eclipse model (IDocument).
	 * This also automatically causes the new content to be displayed by the
	 * eclipse view.
	 */
	@Override
	public void changeContent(int begin, int end, String text) {
		super.changeContent(begin, end, text);
		try {
			fDocument.doReplace(begin, end-begin, text);
		} catch (BadLocationException e) {		
			e.printStackTrace();
		}
	}

	/**
	 * Returns the eclipse model (IDocument).
	 * 
	 * @return A specialised eclipse document for TEF.
	 */
	public TEFDocument getDocument() {
		return fDocument;
	}
	
	public void setViewer(TEFSourceViewer viewer) {
		this.fViewer = viewer;
	}
	
	/**
	 * Returns the eclipse view (ISourceViewer).
	 * 
	 * @return A specialised eclipse view for TEF. Or null, if the view wasn't
	 *         set to this text. This is configured by the corresponding
	 *         {@link TEFEditor} during its setup phase.
	 */
	public TEFSourceViewer getViewer() {
		return fViewer;
	}
}
