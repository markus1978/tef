/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef;

import hub.sam.tef.controllers.ComputeCursorPositionVisitor;
import hub.sam.tef.controllers.ComputeSelectionVisitor;
import hub.sam.tef.controllers.IDeleteEventHandler;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;


// this may change with future eclipse versions
public class TEFSourceViewer extends SourceViewer {
	
	public static final int INSERT_ELEMENT = SourceViewer.QUICK_ASSIST + 1;
	public static final int DELETE_ELEMENT = SourceViewer.QUICK_ASSIST + 2;
	
	private IContentAssistant fInsertElementAssist;
	private Text newCursorPositionText = null;
	private int newCursorPositionOffset = -1;
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
		((TEFDocument)getDocument()).getModelDocument().getDocumentText().process(visitor, offset);
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
	public void setNewCursorPosition(Text cursorPositionText, int cursorPositionOffset) {
		this.newCursorPositionText = cursorPositionText;
		this.newCursorPositionOffset = cursorPositionOffset;
		if (fDocumentListener == null) {
			fDocumentListener = new IDocumentListener() {
				public void documentAboutToBeChanged(DocumentEvent event) {
					// empty;					
				}
				public void documentChanged(DocumentEvent event) {
					if (newCursorPositionText != null) {
						if (getTextWidget() != null) {
							int newCursorPosition = newCursorPositionText.getAbsolutOffset(newCursorPositionOffset);
							ComputeCursorPositionVisitor visitor = new ComputeCursorPositionVisitor(newCursorPosition, true, false);
							newCursorPositionText.process(visitor, newCursorPositionOffset);
							if (visitor.hasResult()) {
								getTextWidget().setSelection(visitor.getResult());
							} else {
								System.err.println("@@ Could not set new cusor postion");
							}							
						} else {
							System.err.println("@@ Could not set new cusor postion");
						}
						newCursorPositionText = null;
					}
				}				
			};
			getDocument().addDocumentListener(fDocumentListener);
		}
	}
}
