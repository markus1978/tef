package hub.sam.tef.editor;

import hub.sam.tef.contentassist.ContentAssistProcessor;
import hub.sam.tef.editor.text.TextEditor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;

public class SourceViewerConfiguration extends org.eclipse.jface.text.source.SourceViewerConfiguration {
	private final TextEditor fEditor;	

	private final IAnnotationHover fAnnotationHover = new DefaultAnnotationHover();
	private PresentationReconciler fPresentationReconciler = null;
	private ContentAssistant fContentAssistant = null;

	public SourceViewerConfiguration(TextEditor editor) {
		super();
		fEditor = editor;
	}					

	/**
	 * Returns a content assistant configures with one content assist processor.
	 * This processor is configured with content assists taken from the editors
	 * semantics.
	 */
	@Override
	public IContentAssistant getContentAssistant(
			ISourceViewer sourceViewer) {
		if (fContentAssistant == null) {
			fContentAssistant = new ContentAssistant();		
			fContentAssistant.setContentAssistProcessor(
					new ContentAssistProcessor(fEditor), 
					IDocument.DEFAULT_CONTENT_TYPE);
		}
		return fContentAssistant;
	}

	/**
	 * Returns a presentation reconciler with highlightings from syntax
	 * (keywords) and primitive types.
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		if (fPresentationReconciler == null) {
			fPresentationReconciler = new PresentationReconciler();
			fPresentationReconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
					
			DefaultDamagerRepairer damageRepairer = new DefaultDamagerRepairer(
					new TokenScanner(fEditor.getSyntax()));
			fPresentationReconciler.setDamager(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);
			fPresentationReconciler.setRepairer(damageRepairer, IDocument.DEFAULT_CONTENT_TYPE);					
		}
		return fPresentationReconciler;
	}
	
	/**
	 * Creates a mono reconciler, configures it with the TEF reconciling
	 * strategy {@link ReconcilingStrategy}, and returns it.
	 */
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {	
		IReconcilingStrategy strategy = new ReconcilingStrategy(fEditor, sourceViewer); 
		MonoReconciler reconciler= new MonoReconciler(strategy, false);
		reconciler.setIsIncrementalReconciler(false);
		reconciler.setProgressMonitor(new NullProgressMonitor());
		reconciler.setDelay(500);
		return reconciler;				
	}

	/**
	 * Returns a default annotation hover that simply displays the
	 * annotation messages.
	 */
	@Override
	public IAnnotationHover getAnnotationHover(
			ISourceViewer sourceViewer) {
		return fAnnotationHover;
	}

}
