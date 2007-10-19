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

import hub.sam.tef.IAdaptable;
import hub.sam.tef.annotations.IPresentationOptionsProvider;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.models.IModel;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.jface.text.Position;

/**
 * A Template describes how a model elements is viewed. It creates the initial views
 * for a model element. Creates and installes all controller necessary to react to
 * user input, model changes, etc.
 * 
 * This is the base class for all Templates. It provides access to the global elements
 * such as the edited model and the used view (DocumentText)
 */
public abstract class Template implements IAdaptable {

	private final IDocumentModelProvider fModelProvider;	
	private final Template fParent;
	
	public Template(IDocumentModelProvider modelProvider) {			
		this.fModelProvider = modelProvider;
		fParent = null;
	}
	
	public Template(Template template) {
		fParent = template;
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
	
	public IDocumentModelProvider getModelProvider() {
		return fModelProvider;
	}
	
	public final IModel getModel() {
		return getModelProvider().getModel();
	}
	
	public <T> T getAdapter(Class<T> adapter) {	
		if (IPresentationOptionsProvider.class == adapter) {
			return (T)new IPresentationOptionsProvider() {
				public boolean markOccurences(ASTElementNode treeRepresentation, int localOffset) {				
					return false;
				}					
			};
		} else {
			return null;
		}
	}
	
	protected Object getId() {
		return getClass();
	}

	@Override
	public boolean equals(Object arg0) {
		if (this.getClass().equals(arg0.getClass())) {
			return  ((Template)arg0).getId().equals(getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
	
	public Position getPositionForOccurenceMarker(ASTElementNode node) {
		return new Position(node.getAbsoluteOffset(0), node.getLength());
	}
	
	/**
	 * Returns all the directly or indirectly nested templates of a template, plus the template itself.
	 */
	public static Collection<Template> collectTemplates(Template tpl) {
		Collection<Template> result = new ArrayList<Template>();
		collectTemplate(tpl, result, new HashSet<String>(), new HashSet<String>());
		return result;
	}
	
	private static void collectTemplate(Template template, Collection<Template> collection, Collection<String> collectedNonTerminals, Collection<String> visitedNonTerminals) {		
		ISyntaxProvider syntaxProvider = template.getAdapter(ISyntaxProvider.class);
		if (syntaxProvider != null && ! collectedNonTerminals.contains(syntaxProvider.getNonTerminal())) {
			collection.add(template);
			collectedNonTerminals.add(syntaxProvider.getNonTerminal());
		}
		for(Template nestedTemplate: template.getNestedTemplates()) {
			ISyntaxProvider nestedSyntaxProvider = nestedTemplate.getAdapter(ISyntaxProvider.class);
			if (nestedSyntaxProvider != null && ! visitedNonTerminals.contains(nestedSyntaxProvider.getNonTerminal())) {
				if (nestedTemplate instanceof ElementTemplate || nestedTemplate instanceof EmtpyElementTemplate) {
					visitedNonTerminals.add(nestedSyntaxProvider.getNonTerminal());
				}
				collectTemplate(nestedTemplate, collection, collectedNonTerminals, visitedNonTerminals);			
			}
		}
	}
}
