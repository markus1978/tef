package editortest.mof.editor;

import editortest.editor.TEFDocument;
import editortest.mof.template.MofTemplate;
import editortest.text.DocumentText;

public class MofDocument extends TEFDocument {
	public DocumentText createDocument() {		
		DocumentText result = new editortest.text.DocumentText(this);
		result.addText(new MofTemplate(result).createText((getModel().getOutermostComposites())));
		return result;
	}
}
