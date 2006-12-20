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
import hub.sam.tef.views.DocumentText;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;


public abstract class TEFEditor extends TextEditor {
	
	public static final String INSERT_ELEMENT = "tef.insertElement";
	public static final String DELETE_ELEMENT = "tef.deleteElement";
	
	private int cursorDrift = 0;
	private int currentCursortPosition = 0;
	private boolean duringCursorPositionChange = false;
	
	private Occurences fOccurences = null;
	private SelectedElementMarker fSelectedElementMarker = null;	
		
	public TEFEditor() {
		super();				
		setSourceViewerConfiguration(new TEFSourceViewerConfiguration());
		setDocumentProvider(createDocumentProvider());		
	}
	
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// this may change with future eclipse versions
		fAnnotationAccess= getAnnotationAccess();
		fOverviewRuler= createOverviewRuler(getSharedColors());

		ISourceViewer viewer= new TEFSourceViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}
	
	protected abstract TEFDocumentProvider createDocumentProvider();

	@Override
	public final void createPartControl(Composite parent) {
		super.createPartControl(parent);
		((TEFDocument)getSourceViewer().getDocument()).setEditor(this, (TEFSourceViewer)getSourceViewer());	
		fOccurences = new Occurences(this);
		fSelectedElementMarker = new SelectedElementMarker(this);
	}

	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);
		
		IAction insertElement = createElementInsertAction();
		insertElement.setActionDefinitionId(INSERT_ELEMENT);
		setAction(INSERT_ELEMENT, insertElement);
		
		IAction deleteElement = createDeleteElementAction();
		deleteElement.setActionDefinitionId(DELETE_ELEMENT);
		setAction(DELETE_ELEMENT, deleteElement);
	}		
	
	private IAction createContentAssistAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}
	
	private IAction createElementInsertAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "InsertElement", this, 
				TEFSourceViewer.INSERT_ELEMENT);
	}
	
	private IAction createDeleteElementAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "DeleteElement", this, 
				TEFSourceViewer.DELETE_ELEMENT);
	}	
	
	@Override
	protected final void handleCursorPositionChanged() {
		if (duringCursorPositionChange) {
			return;
		} else {
			duringCursorPositionChange = true;
			ISourceViewer viewer = getSourceViewer();
			currentCursortPosition += cursorDrift;
			int actualCursorPostion = viewer.getTextWidget().getCaretOffset()+ cursorDrift;
			DocumentText document = ((TEFDocument)viewer.getDocument()).getDocument();
			if (currentCursortPosition != actualCursorPostion) {
				int newCursorPos = getValidCursorPosition(actualCursorPostion, document);		
				currentCursortPosition = newCursorPos;
				cursorDrift = 0;	
				selectAndReveal(newCursorPos, 0);					
				super.handleCursorPositionChanged();			
			}
			duringCursorPositionChange = false;
		}
	}

	private int getValidCursorPosition(int newCursorPos, DocumentText document) {
		ComputeCursorPositionVisitor cursorVisitor = new ComputeCursorPositionVisitor(
				newCursorPos, newCursorPos > currentCursortPosition, true);
		document.process(cursorVisitor, newCursorPos);
		newCursorPos = cursorVisitor.getResult();		
		return newCursorPos;
	}

	
	public final void addCarretDrift(int drift) {
		this.cursorDrift += drift;
	}
}
