package editortest.template;

import editortest.model.IModel;
import editortest.text.Document;

public abstract class ModelBasedTemplate extends Template {
	
	private final IModel fModel;	
	
	public ModelBasedTemplate(Document document, final IModel model) {
		super(document);
		fModel = model;
	}
	
	public ModelBasedTemplate(Template template, final IModel model) {
		super(template);
		fModel = model;
	}
	
	protected IModel getModel() {
		return fModel;
	}
}
