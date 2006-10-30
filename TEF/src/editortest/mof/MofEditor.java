package editortest.mof;

import editortest.editor.TEFDocumentProvider;
import editortest.editor.TEFEditor;

public final class MofEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new MofDocumentProvider();
	}

}
