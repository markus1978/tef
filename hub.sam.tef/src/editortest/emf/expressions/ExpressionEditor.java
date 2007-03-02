package editortest.emf.expressions;

import hub.sam.tef.TEFDocumentProvider;
import hub.sam.tef.TEFEditor;

public class ExpressionEditor extends TEFEditor {

	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new ExpressionDocumentProvider();
	}

}
