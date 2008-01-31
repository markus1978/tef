package hub.sam.tef.tsleditor;

import hub.sam.tef.editor.text.TextEditor;

import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

public class TslSourceViewerConfiguration extends hub.sam.tef.editor.SourceViewerConfiguration {

	public TslSourceViewerConfiguration(TextEditor editor) {
		super(editor);
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
			ISourceViewer sourceViewer, String contentType) {
		return new TslTextDoubleClickStrategy();
	}

}
