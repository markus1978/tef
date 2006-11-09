package editortest.mof;

import editortest.editor.TEFDocument;
import editortest.mof.template.MofTemplate;
import editortest.text.Document;

public class MofDocument extends TEFDocument {
	public Document createDocument() {		
		Document result = new editortest.text.Document(this);
		result.addText(new MofTemplate(result).createText((getModel().getOutermostComposites())));
		return result;
	}
}
