package editortest.tefwidgets;

import editortest.editors.EclipseDocument;
import editortest.template.MofTemplate;
import editortest.widgets.Document;

public class TestMofDocument extends Document {
	
	public TestMofDocument(EclipseDocument document) {
		super(document);				
		addText(new MofTemplate(document.getModel()).
				createText(document.getModel().getElements()));
	}
}
