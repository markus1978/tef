package editortest.emf.ocl;

import org.eclipse.jface.text.source.SourceViewerConfiguration;

import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.TEFEditor;

public class OclEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new OclDocumentProvider();
	}

	@Override
	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new OclSourceViewerConfiguration();
	}

	
}
