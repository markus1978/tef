package editortest.template;

import editortest.model.IMetaModelElement;

public abstract class PropertyTemplate extends ModelBasedTemplate {

	private final String fProperty;
	private final IMetaModelElement fMetaModelElement;
	
	public PropertyTemplate(ElementTemplate elementTemplate, final String property) {
		super(elementTemplate);
		this.fProperty = property;
		fMetaModelElement = elementTemplate.getMetaElement();
	}		
	
	public PropertyTemplate(Template template, IMetaModelElement metaModelElement, final String property) {
		super(template);
		this.fProperty = property;
		fMetaModelElement = metaModelElement;
	}
	
	protected final String getProperty() {
		return fProperty;
	}
	
	protected final IMetaModelElement getMetaModel() {
		return fMetaModelElement;
	}
}
