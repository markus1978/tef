package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;

public abstract class PropertyTemplate extends Template<IModelElement> {

	private final String fProperty;
	private final IMetaModelElement fMetaModel;
	
	public PropertyTemplate(final String property, final IMetaModelElement metaModel) {
		super();
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
