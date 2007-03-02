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

import hub.sam.tef.controllers.IProposalHandler.ProposalKind;
import hub.sam.tef.parse.TEFReconciler;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;


public class TEFSourceViewerConfiguration extends SourceViewerConfiguration {

	private final ContentAssistant fChangeContentAssistant;
	private final ContentAssistant fInsertContentAssistant;
	private final ITextDoubleClickStrategy fDoubleClickStrategy;
	private final IAutoEditStrategy fAutoEditStrategy;
	private final IReconciler fReconciler = new TEFReconciler();
			
	public TEFSourceViewerConfiguration() {
		super();
		this.fChangeContentAssistant = new ContentAssistant();		
		fChangeContentAssistant.setContentAssistProcessor(
				new TEFCompletionProcessor(ProposalKind.change), IDocument.DEFAULT_CONTENT_TYPE);
		this.fInsertContentAssistant = new ContentAssistant();
		fInsertContentAssistant.setContentAssistProcessor(
				new TEFCompletionProcessor(ProposalKind.insert), IDocument.DEFAULT_CONTENT_TYPE);
		
		this.fDoubleClickStrategy = new TEFDoubleClickStrategy();
		this.fAutoEditStrategy = new TEFAutoEditStrategy();
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {		
		return fChangeContentAssistant;
	}
		
	public IContentAssistant getInsertContentAssistant(ISourceViewer sourceViewer) {		
		return fInsertContentAssistant;
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		return fDoubleClickStrategy;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[] { fAutoEditStrategy };
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		PresentationDamagerRepairer damageRepair = new PresentationDamagerRepairer();
		reconciler.setDamager(damageRepair, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(damageRepair, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;		
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {	
		return fReconciler;
	}				
}
