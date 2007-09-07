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

import hub.sam.tef.completion.TEFCompletionProcessor;

import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TEFSourceViewerConfiguration extends SourceViewerConfiguration {		
	private final ContentAssistant fChangeContentAssistant;		
	private final ITextDoubleClickStrategy fDoubleClickStrategy;	
	private final IAnnotationHover fAnnotationHover;	
	//private final IAutoEditStrategy fAutoEditStrategy;
			
	public TEFSourceViewerConfiguration() {
		super();
		this.fChangeContentAssistant = new ContentAssistant();		
		fChangeContentAssistant.setContentAssistProcessor(
				new TEFCompletionProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		
		this.fDoubleClickStrategy = new TEFDoubleClickStrategy();
		this.fAnnotationHover = new DefaultAnnotationHover();
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {		
		return fChangeContentAssistant;
	}
		
	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		//return fDoubleClickStrategy;
		return null;
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
				
		DefaultDamagerRepairer damageRepairer = new DefaultDamagerRepairer(
				new TEFTokenScanner(sourceViewer));
		reconciler.setDamager(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;		
	}
	
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return new TEFReconciler(sourceViewer);		
	}

	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return fAnnotationHover;
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType, int stateMask) {
		return new DefaultTextHover(sourceViewer);
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return new DefaultTextHover(sourceViewer);
	}				
	
	
}
