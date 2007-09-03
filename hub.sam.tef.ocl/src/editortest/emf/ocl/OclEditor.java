package editortest.emf.ocl;

import org.eclipse.jface.text.source.SourceViewerConfiguration;

import hub.sam.tef.AbstractTEFEditor;
import hub.sam.tef.documents.TEFDocumentProvider;

public class OclEditor extends AbstractTEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new OclDocumentProvider();
	}

	@Override
	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new OclSourceViewerConfiguration();
	}

	
}
