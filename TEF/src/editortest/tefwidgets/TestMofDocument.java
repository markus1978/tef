package editortest.tefwidgets;

import editortest.editor.EclipseDocument;
import editortest.mof.template.MofTemplate;
import editortest.text.Document;

public class TestMofDocument extends Document {
	
	public TestMofDocument(EclipseDocument document) {
		super(document);				
		addText(new MofTemplate(document.getModel()).
				createText(document.getModel().getElements()));
	}
}
