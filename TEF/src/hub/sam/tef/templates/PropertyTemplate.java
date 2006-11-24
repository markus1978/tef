package hub.sam.tef.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

/**
 * A PropertyTemplate determins how a property is to be displayed. A property is usually a
 * single value or a collection of values. PropertyTemplates and ValueTemplates alternate along
 * a path in an template hierarchy.
 */
public abstract class PropertyTemplate<ModelType> extends Template{
	
	private final String fProperty;
	
	public PropertyTemplate(ElementTemplate template, String property) {
		super(template);
		fProperty = property;
	}
	
	/**
	 * The name of the property that this template creates representations for.
	 * 
	 * @return The name of the property.
	 */
	protected final String getProperty() {
		return fProperty;
	}
	
	/**
	 * This method is used to create a new view for this property and its
	 * values.
	 * 
	 * @param model
	 *            The model of the element that this property is a part of.
	 * @return The view representing the property and its values.
	 */
	public abstract Text createView(IModelElement model);
}
