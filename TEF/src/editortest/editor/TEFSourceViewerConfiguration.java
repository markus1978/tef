package editortest.editor;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TEFSourceViewerConfiguration extends SourceViewerConfiguration {

	private final ContentAssistant fcontentAssistant;
	private final ITextDoubleClickStrategy fDoubleClickStrategy;
	private final IAutoEditStrategy fAutoEditStrategy;
			
	public TEFSourceViewerConfiguration() {
		super();
		this.fcontentAssistant = new ContentAssistant();		
		fcontentAssistant.setContentAssistProcessor(
				new TEFCompletionProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		
		this.fDoubleClickStrategy = new TEFDoubleClickStrategy();
		this.fAutoEditStrategy = new TEFAutoEditStrategy();
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {		
		return fcontentAssistant;
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		return fDoubleClickStrategy;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[] { fAutoEditStrategy };
	}			
}
