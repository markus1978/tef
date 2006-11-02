package editortest.template;

import editortest.text.Document;

public abstract class ModelBasedTemplate extends Template {	
	
	public ModelBasedTemplate(Document document) {
		super(document);
	}
	
	public ModelBasedTemplate(Template template) {
		super(template);
	}
	
}
