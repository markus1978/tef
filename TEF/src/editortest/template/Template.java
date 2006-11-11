package editortest.template;

import editortest.model.IModel;
import editortest.view.DocumentText;

public abstract class Template {

	private final DocumentText fDocument;
	
	public Template(DocumentText document) {
		fDocument = document;
	}
	
	public Template(Template template) {
		fDocument = template.getDocument();
	}
	
	public DocumentText getDocument() {
		return fDocument;
	}
	
	public IModel getModel() {
		return fDocument.getDocument().getModel();
	}

}
