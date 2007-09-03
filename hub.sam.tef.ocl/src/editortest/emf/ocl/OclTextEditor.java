package editortest.emf.ocl;

import hub.sam.tef.AbstractTEFEditor;
import hub.sam.tef.documents.TEFDocumentProvider;

import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class OclTextEditor extends AbstractTEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new OclTextDocumentProvider();
	}

	@Override
	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new OclSourceViewerConfiguration();
	}

}
