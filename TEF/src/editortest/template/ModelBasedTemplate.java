package editortest.template;

import editortest.model.IModel;

public abstract class ModelBasedTemplate extends Template {
	
	private final IModel fModel;	
	
	public ModelBasedTemplate(final IModel model) {
		super();
		fModel = model;
	}
	
	protected IModel getModel() {
		return fModel;
	}
}
