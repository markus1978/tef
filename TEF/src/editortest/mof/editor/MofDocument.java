package editortest.mof.editor;

import editortest.editor.TEFDocument;
import editortest.mof.template.MofTemplate;
import editortest.view.DocumentText;

public class MofDocument extends TEFDocument {
	public DocumentText createDocument() {		
		DocumentText result = new editortest.view.DocumentText(this);
		result.addText(new MofTemplate(result).createText((getModel().getOutermostComposites())));
		return result;
	}
}
