package editortest.mof.editor;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.views.DocumentText;
import editortest.mof.template.MofTemplate;

public class MofDocument extends TEFDocument {
	
	public DocumentText createDocument() {		
		DocumentText result = new hub.sam.tef.views.DocumentText(this);
		result.addText(new MofTemplate(result).createText((getModel().getOutermostComposites())));
		return result;
	}
}
