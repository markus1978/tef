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

import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.controllers.IModelRepresentationProvider;
import hub.sam.tef.models.IModel;
import hub.sam.util.IAdaptable;

/**
 * A Template describes how a model elements is viewed. It creates the initial views
 * for a model element. Creates and installes all controller necessary to react to
 * user input, model changes, etc.
 * 
 * This is the base class for all Templates. It provides access to the global elements
 * such as the edited model and the used view (DocumentText)
 */
public abstract class Template implements IAdaptable {

	private final IAnnotationModelProvider fAnnotationModelProvider;
	private final ICursorPostionProvider fCursorPositionProvider;
	private final IModelRepresentationProvider fModelProvider;	
	private final Template fParent;
	
	public Template(IAnnotationModelProvider annotationModelProvider, ICursorPostionProvider cursorPositionProvider, IModelRepresentationProvider modelProvider) {
		this.fAnnotationModelProvider = annotationModelProvider;
		this.fCursorPositionProvider = cursorPositionProvider;
		this.fModelProvider = modelProvider;
		fParent = null;
	}
	
	public Template(Template template) {
		fParent = template;
		fAnnotationModelProvider = template.fAnnotationModelProvider;
		fCursorPositionProvider = template.fCursorPositionProvider;
		fModelProvider = template.fModelProvider;
	}
	
	/**
	 * @return All nested templates. May be empty.
	 */
	public Template[] getNestedTemplates() {
		return new Template[] {};
	}
	
	/**
	 * @return The parent template if this template has one, null otherwise.
	 */
	public Template getParentTemplate() {
		return fParent;
	}
	
	public IAnnotationModelProvider getAnnotationModelProvider() {
		return fAnnotationModelProvider;
	}
	
	public ICursorPostionProvider getCursorPostionProvider() {
		return fCursorPositionProvider;
	}
	
	public IModelRepresentationProvider getModelProvider() {
		return fModelProvider;
	}
	
	public final IModel getModel() {
		return getModelProvider().getModel();
	}
	
	public <T> T getAdapter(Class<T> adapter) {	
		return null;
	}
}
