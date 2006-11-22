package editortest.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;

import editortest.controller.ComputeSelectionVisitor;
import editortest.controller.IDeleteEventHandler;
import editortest.view.Text;

// this may change with future eclipse versions
public class TEFSourceViewer extends SourceViewer {
	
	public static final int INSERT_ELEMENT = SourceViewer.QUICK_ASSIST + 1;
	public static final int DELETE_ELEMENT = SourceViewer.QUICK_ASSIST + 2;
	
	private IContentAssistant fInsertElementAssist;
	private int newCursorPosition = -1;
	private IDocumentListener fDocumentListener = null;
	
	public TEFSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		super(parent, ruler, styles);
	}

	public TEFSourceViewer(Composite parent, IVerticalRuler verticalRuler, IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles) {
		super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);		
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {				
		if (getTextWidget() == null) {
			return;
		}
		fInsertElementAssist = ((TEFSourceViewerConfiguration)configuration).getInsertContentAssistant(this);
		fInsertElementAssist.install(this);
		super.configure(configuration);
	}	

	@Override
	public boolean canDoOperation(int operation) {
		if (operation == INSERT_ELEMENT) {
			return fInsertElementAssist != null && isEditable();
		} else if (operation == DELETE_ELEMENT) {			
			return true;
		} else {
			return super.canDoOperation(operation);
		}
	}

	@Override
	public void doOperation(int operation) {
		switch (operation) {
			case INSERT_ELEMENT:
				doInsertAction();
				return;	
			case DELETE_ELEMENT:
				doDeleteAction();
				return;
		}		
		super.doOperation(operation);
	}	
	
	private void doInsertAction() {
		fInsertElementAssist.showPossibleCompletions();
	}
	
	private void doDeleteAction() {
		int offset = getTextWidget().getCaretOffset();
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)getDocument()).getDocument().process(visitor, offset);
		Text selectedText = visitor.getResult();
		if (selectedText != null) {
			selectedText.getAllElements(IDeleteEventHandler.class).iterator().next().handleEvent(selectedText);
		}
	}
	
	/**
	 * Allows to register a new cursorPosition that is set the next time that
	 * the viewed source document has changed.
	 * 
	 * @param cursorPosition
	 *            The cursor postion as offset relative to the beginning of the
	 *            document.
	 */
	public void setNewCursorPosition(int cursorPosition) {
		this.newCursorPosition = cursorPosition;
		if (fDocumentListener == null) {
			fDocumentListener = new IDocumentListener() {
				public void documentAboutToBeChanged(DocumentEvent event) {
					// empty;					
				}
				public void documentChanged(DocumentEvent event) {
					if (newCursorPosition != -1) {
						if (getTextWidget() != null) {
							getTextWidget().setSelection(newCursorPosition);
						} else {
							System.err.println("@@ Could not set new cusor postion");
						}
						newCursorPosition = -1;
					}
				}				
			};
			getDocument().addDocumentListener(fDocumentListener);
		}
	}
}
