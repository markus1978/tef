package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;

public abstract class PropertyTemplate extends Template<IModelElement> {

	private final String property;
	private final IMetaModelElement metaModel;
	
	public PropertyTemplate(final String property, final IMetaModelElement metaModel) {
		super();
		this.property = property;
		this.metaModel = metaModel;
	}		
	
	public String getProperty() {
		return property;
	}
}
