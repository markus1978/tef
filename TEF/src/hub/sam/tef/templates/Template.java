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

import hub.sam.tef.models.IModel;
import hub.sam.tef.views.DocumentText;

/**
 * A Template describes how a model elements is viewed. It creates the initial views
 * for a model element. Creates and installes all controller necessary to react to
 * user input, model changes, etc.
 * 
 * This is the base class for all Templates. It provides access to the global elements
 * such as the edited model and the used view (DocumentText)
 */
public abstract class Template {

	private final DocumentText fDocument;
	
	public Template(DocumentText document) {
		fDocument = document;
	}
	
	public Template(Template template) {
		fDocument = template.getDocument();
	}
	
	/**
	 * Provides access to the used view.
	 * @return The view, a toplevel Text element.
	 */
	public DocumentText getDocument() {
		return fDocument;
	}
	
	/**
	 * Provides access to the edited model.
	 * @return The edited model.
	 */
	public IModel getModel() {
		return fDocument.getDocument().getModel();
	}

}
