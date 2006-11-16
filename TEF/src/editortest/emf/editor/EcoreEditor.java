package editortest.emf.editor;

import editortest.editor.TEFDocumentProvider;
import editortest.editor.TEFEditor;

public class EcoreEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new EcoreDocumentProvider();
	}

}
