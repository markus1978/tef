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


import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.documents.TEFDocumentProvider;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;


public abstract class AbstractTEFEditor extends TextEditor {	
	
	public AbstractTEFEditor() {
		super();				
		setSourceViewerConfiguration(createSourceViewerConfiguration());
		setDocumentProvider(createDocumentProvider());		
	}

	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new TEFSourceViewerConfiguration();
	}
	
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {		
		// this may change with future eclipse versions
		fAnnotationAccess= getAnnotationAccess();
		fOverviewRuler= createOverviewRuler(getSharedColors());

		ISourceViewer viewer= super.createSourceViewer(parent, ruler, styles);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}
	
	protected abstract TEFDocumentProvider createDocumentProvider();

	public final TEFDocument getDocument()  {
		return (TEFDocument)getSourceViewer().getDocument();
	}
	
	@Override
	public final void createPartControl(Composite parent) {	
		super.createPartControl(parent);	
		getDocument().configure((IAnnotationModelExtension)getSourceViewer().getAnnotationModel());
		new TEFOccurencesUpdater(this);				
		getSourceViewer().addTextInputListener(new ITextInputListener() {
			public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			}
			public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
				((TEFDocument)oldInput).dispose();
			}			
		});
	}

	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);		
	}		
	
	private IAction createContentAssistAction() {		
		ResourceBundle resourceBundle = TEFPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}
		
	public Control getWidget() {
		return getSourceViewer().getTextWidget();
	}
}
