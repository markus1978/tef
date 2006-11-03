package editortest.template;

import editortest.model.IModelElement;
import editortest.text.Text;


public abstract class PropertyTemplate<ModelType> extends Template{

	private final ElementTemplate fElementTemplate;
	private final String fProperty;
	
	public PropertyTemplate(ElementTemplate template, String property) {
		super(template);
		fElementTemplate = template;
		fProperty = property;
	}
	
	protected final String getProperty() {
		return fProperty;
	}
	
	/** 
	 * This method is used by the value templates to promote a value change.
	 * @param view The view that represents the value.
	 * @param model The model which this property is a part of.
	 * @param value The new value for that property.
	 */
	public abstract void updateProperty(Text view, IModelElement model, ModelType value);
	
	/**
	 * This method is used to create a new view for this property and its values.
	 * @param model The model of the element that this property is a part of.
	 * @return The view representing the property and its values.
	 */
	public abstract Text createView(IModelElement model);
}
