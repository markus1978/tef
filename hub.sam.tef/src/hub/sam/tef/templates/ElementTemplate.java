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

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.IPresentationOptionsProvider;
import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.IdentifierResolutionNotImplementedException;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.ICompletionComputer;
import hub.sam.tef.completion.StandardReferenceCompletion;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.extensions.InternalModelElement;
import hub.sam.tef.reconciliation.syntax.IElementSyntaxProvider;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.text.Position;

/**
 * A special ValueTemplate used for elements, whereby elements are container for
 * Properties. An ElementTemplate provides the representations for whole model
 * elements using property and terminal templates as children. It defines a node in 
 * a hierarchy of templates.
 */
public abstract class ElementTemplate extends ValueTemplate<IModelElement> {
	
	private final IMetaModelElement fMetaModel;
	private Template[] fTemplates;
	
	public ElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);		
		fMetaModel = metaModel;
	}	

	public ElementTemplate(IDocumentModelProvider modelProvider, IMetaModelElement metaModel) {
		super(modelProvider, metaModel);
		fMetaModel = metaModel;
	}
	
	/**
	 * Creates all child templates. This can be Terminal or ValueTemplates.
	 */
	public abstract Template[] createTemplates();
		
	@Override
	public Template[] getNestedTemplates() {
		return getTemplates();
	}

	private final Template[] getTemplates() {
		if (fTemplates == null) {
			fTemplates = createTemplates();
		}
		return fTemplates;
	}

	/**
	 * @return The meta element that describes the elements that this template
	 *         provides representations for.
	 */
	protected IMetaModelElement getMetaElement() {
		return this.fMetaModel;
	}
	
	/**
	 * Returns true for those meta model elements that this element template
	 * provides representations for.
	 */
	public boolean isTemplateFor(IModelElement model) {		
		return getMetaElement().isMetaModelFor(model);
	}
	
	/**
	 * When a view for this element is created those property subviews that
	 * represent properties that this method yields will be registered as
	 * occurences of the element represented by this template..
	 * 
	 * @param property
	 *            The property.
	 * @return True when the representation of this property should be marked as
	 *         a occurence of the element represented by the containing element
	 *         template.
	 */
	protected boolean isIdentifierProperty(String property) {
		return false;
	}
		
	@Override
	public Position getPositionForOccurenceMarker(ASTElementNode node) {
		loop: for (Template subTemplate: getNestedTemplates()) {
			if (subTemplate instanceof PropertyTemplate) {
				PropertyTemplate subPropertyTemplate = (PropertyTemplate)subTemplate;
				if (isIdentifierProperty(subPropertyTemplate.getProperty())) {
					ASTNode identifierNode = node.getNode(subPropertyTemplate.getProperty());
					if (identifierNode != null) {
						return new Position(identifierNode.getAbsoluteOffset(0), identifierNode.getLength());
					}
					break loop;
				}
			}
		}
		return super.getPositionForOccurenceMarker(node);
	}

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {	
		return null;
	}
	
	/**
	 * During reconciliation a model is created without real, but fake
	 * references. These fake references target "mock" objects, which are
	 * created using this method. These "mock" object have to be
	 * {@link InternalModelElement}.
	 */
	public IModelElement createMockObject() {
		InternalModelElement mock = new InternalModelElement(getMetaElement());
		for (Template template: getTemplates()) {
			if (template instanceof SingleValueTemplate) {
				((ValueTemplate)template.getNestedTemplates()[0]).getCommandToCreateADefaultValue(
						mock, ((PropertyTemplate)template).getProperty(), false).execute();
			}
		}
		return mock;
	}
	
	protected String getAlternativeSymbol() {
		return null;
	}
	
	/**
	 * Callback method that returns null of the modelElement does not contain any errors. Returns an
	 * error description otherwise.
	 */
	public String check(IModelElement modelElement, SemanticsContext context) {
		return null;
	}
	
	/**
	 * Callback method that returnes a resolved identifier. Throws a {@link CouldNotResolveIdentifierException} if the
	 * identifier could not be resolved. 
	 * 
	 * @param model The overall model (EditingDomain)
	 * @param node The parse tree node of the element that has to be resolved
	 * @param context The model element that contains the reference to be resolved
	 * @param topLevelElement The toplevel model element of the current model
	 * @param expectedType The expected type of the resolved element
	 * @param property The property that the reference is a value for
	 * @return The resolved element (can be null)
	 * @throws CouldNotResolveIdentifierException
	 */
	public IModelElement resolveIdentifier(IModel model, ASTElementNode node, IModelElement context, 
			IModelElement topLevelElement, 
			IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {
		throw new IdentifierResolutionNotImplementedException("resolution not implemented");
	}
	
	/**
	 * If {@link this#getPropertiesWithCompletion()} returns a property, this
	 * callback has to provide proposals for this completion.
	 * @param property The property that values are to be completed for.
	 * @param completionNode The AST node that characterizes the element that the completion is requested on.
	 * @param context Contains additional information about the current model, and place of the completion request.
	 * @return A collection of proposals.
	 */
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(
			String property,
			ASTElementNode completionNode, 
			CompletionContext context) {		
		return null;
	}
	
	/**
	 * Callback that determines for what properties this element provides code completion.
	 */
	public String[] getPropertiesWithCompletion() {
		return new String[] {};
	}
	
	/**
	 * Call back to vary the standard completion behaviour ... TODO.
	 */
	public String[] getRulePrefixForCompletion(String property) {
		return null;
	}
			
	
	public Collection<ICompletionComputer> getCompletions() {
		Collection<ICompletionComputer> completions = new ArrayList<ICompletionComputer>();
		for(String property: getPropertiesWithCompletion()) {
			completions.add(new StandardReferenceCompletion(this, property));
		}
		return completions;
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter || IElementSyntaxProvider.class == adapter) {
			return (T) new ElementTemplateSemantics(this);
		} else if (IASTProvider.class == adapter) {
			return (T) new ElementTemplateSemantics(this);
		} else if (ISemanticProvider.class == adapter) {
			return (T) new ElementTemplateSemantics(this);
		} else if (IPresentationOptionsProvider.class == adapter) {
			return (T) new IPresentationOptionsProvider() {
				public boolean markOccurences(ASTElementNode treeRepresentation, int localOffset) {
					return treeRepresentation.getNode("name") == treeRepresentation.getNode(localOffset);
				}				
			};
		} else {
			return null;
		}
	}

	@Override
	protected Object getId() {
		if (getAlternativeSymbol() != null) {			
			return getAlternativeSymbol();
		} else if (getAdapter(ISyntaxProvider.class) != null) {
			return getAdapter(ISyntaxProvider.class).getNonTerminal();
		} else {
			return getAlternativeSymbol();
		}
	}	
}
