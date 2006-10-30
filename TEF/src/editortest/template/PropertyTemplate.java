package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;

public abstract class PropertyTemplate extends ModelBasedTemplate {

	private final String fProperty;
	private final IMetaModelElement fMetaModel;
	
	public PropertyTemplate(final IModel model, final String property, 
			final IMetaModelElement metaModel) {
		super(model);
		this.fProperty = property;
		this.fMetaModel = metaModel;
	}		
	
	public String getProperty() {
		return fProperty;
	}
	
	public IMetaModelElement getMetaModel() {
		return fMetaModel;
	}
}
