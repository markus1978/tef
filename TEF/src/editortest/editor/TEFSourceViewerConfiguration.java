package editortest.editor;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import editortest.controller.IProposalHandler.ProposalKind;
import editortest.editor.presentation.PresentationDamagerRepairer;

public class TEFSourceViewerConfiguration extends SourceViewerConfiguration {

	private final ContentAssistant fChangeContentAssistant;
	private final ContentAssistant fInsertContentAssistant;
	private final ITextDoubleClickStrategy fDoubleClickStrategy;
	private final IAutoEditStrategy fAutoEditStrategy;
			
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
		PresentationDamagerRepairer damageRepair = new PresentationDamagerRepairer((TEFSourceViewer)sourceViewer);
		reconciler.setDamager(damageRepair, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(damageRepair, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
		
	}			
	
}
