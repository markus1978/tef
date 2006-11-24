package editortest.emf.editor;

import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.TEFEditor;

public class EcoreEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new EcoreDocumentProvider();
	}

}
