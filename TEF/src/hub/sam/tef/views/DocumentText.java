package hub.sam.tef.views;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;

import editortest.editor.TEFDocument;
import editortest.editor.TEFEditor;
import editortest.editor.TEFSourceViewer;
import editortest.template.whitespaces.LayoutManager;

/**
 * A DocuementText functions as the toplevel text. It is also the interface to
 * the eclipse model (IDocument) and eclipse view (ISourceViewer).
 */
public class DocumentText extends CompoundText {
	
	private final TEFDocument fDocument;
	private TEFSourceViewer fViewer = null;
	private final Collection<IDocumentUpdateListener> fListener = new Vector<IDocumentUpdateListener>();
	
	private boolean toBeUpdated = false;
	private int changesBegin = 0;
	private int changesDocumentEnd = 0;
	private int changesTextEnd = 0;
	
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
		if (getContent(begin, end).equals(text)) {
			return;
		}
		super.changeContent(begin, end, text);
		if (!toBeUpdated) {
			changesBegin = -1;
			changesDocumentEnd = -1;
			changesTextEnd = -1;
			toBeUpdated = true;
		}
		if (begin < changesBegin || changesBegin == -1) {
			changesBegin = begin;
		}		
		
		if (changesDocumentEnd == -1 || changesTextEnd == -1) {
			changesDocumentEnd = end;
			changesTextEnd = end;
		} else {			
			if (end > changesTextEnd) {
				changesDocumentEnd += end - changesTextEnd;			
			}			
		}
		changesTextEnd += text.length() - (end - begin);
	}
	
	public void addDocumentUpdateListener(IDocumentUpdateListener listener) {
		fListener.add(listener);
	}
	
	public void update() {
		if (toBeUpdated) {
			try {					
				for (IDocumentUpdateListener listener: fListener) {
					listener.documentAboutToBeUpdated(this);
				}
				fDocument.doReplace(changesBegin, changesDocumentEnd - changesBegin, getContent(changesBegin, changesTextEnd));
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			toBeUpdated = false;
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
