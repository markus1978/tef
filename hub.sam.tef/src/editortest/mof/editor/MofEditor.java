package editortest.mof.editor;

import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.TEFEditor;

public final class MofEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new MofDocumentProvider();
	}

}
