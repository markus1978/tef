/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
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
	private ValueTemplate<ModelType> fValueTemplate = null;
	
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
	
	protected abstract ValueTemplate<ModelType> createValueTemplate();
	
	protected final ValueTemplate<ModelType> getValueTemplate() {
		if (fValueTemplate == null) {
			fValueTemplate = createValueTemplate();
		}
		return fValueTemplate;
	}
	
	@Override
	public final Template[] getNestedTemplates() {	
		return new Template[] { fValueTemplate };
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

	@Override
	public String getNonTerminal() {
		return getValueTemplate().getNonTerminal();	
	}

	@Override
	public String[][] getRules() {
		return new String[][] {};
	}		
}
