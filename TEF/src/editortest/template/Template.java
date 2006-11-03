package editortest.template;

import editortest.model.IModel;
import editortest.text.Document;

public abstract class Template {

	private final Document fDocument;
	
	public Template(Document document) {
		fDocument = document;
	}
	
	public Template(Template template) {
		fDocument = template.getDocument();
	}
	
	public Document getDocument() {
		return fDocument;
	}
	
	public IModel getModel() {
		return fDocument.getDocument().getModel();
	}

}
