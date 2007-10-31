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
package hub.sam.tef.documents;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.annotations.IChecker;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.annotations.IPresentationOptionsProvider;
import hub.sam.tef.completion.ICompletionComputer;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTElement;
import hub.sam.tef.reconciliation.treerepresentation.IndexASTSelector;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.util.trees.IChildSelector;
import hub.sam.util.trees.TreeIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * This class represent TEF documents as eclipse text documents
 * {@link IDocument}. In other words it wrapped a TEF text structures, starting
 * with a {@link DocumentText}, into an eclipse interface.
 * 
 * Instances of this class can run in two modi. One the TEF mode (the normal and
 * starting mode). All changes to the document caused by the eclipse editor
 * (user keystrokes mostly) are translated into TEF events. If these events can
 * be handled by TEF, nothing happens here. TEF will change the underlying
 * model, according listeners will change the TEF text structure, an according
 * updates will call {@link #doReplace(int, int, String)} in this class, which
 * forwards the changes to the eclipse editor. If an event can't be handled,
 * this document switched into the eclipse mode. In this mode the documents acts
 * like a normal eclipse document. It is now the responsibility of the installed
 * TEF reconciler to parse the current editor content at appropriate times and
 * finally change the model and therefore the TEX text structure. The TEF
 * reconciler is also responsibly to switch this document back into TEF mode. In
 * eclipse mode this document does not present the TEF text structure, but a
 * normal StringBuffer based string content.
 * 
 * This document is a document per editor. This is completely wrong. It should be separated from
 * a concrete editor instance.
 */
public abstract class TEFDocument extends Document implements ILanguageModelProvider {	
	private Template topLevelTemplate = null;
	
	private DocumentModel documentModel = null;		
	private boolean changed = false;
	private IAnnotationModelExtension annotationModel = null;
	
	private AbstractLayoutManager layout = null;
	
	@Override
	public final void replace(int pos, int length, String text) throws BadLocationException {
		eclipseReplace(pos, length, text);
	}
	
	/**
	 * This is a new method, not known to the eclipse platform. It is used to handle document changes that
	 * were not directly triggered by the user. These changes come from the according DocumentText.
	 * We say this are changes "from below", in contradiction to changes "from above" {@link #replace(int, int, String)}.
	 */
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		super.replace(pos, length, text);
	}
	
	private synchronized final void eclipseReplace(int pos, int length, String text) throws BadLocationException {
		changed = true;
		super.replace(pos, length, text);
	}
	
	public IDocumentModelProvider getModelProvider() {
		return documentModel;
	}
	
	public void configure(IAnnotationModelExtension annotationModel) {
		this.annotationModel = annotationModel;
		if (documentModel != null) {
			documentModel.setAnnotationModel(annotationModel);
		}
	}

	public void setInitialModelContent(IModel model, Object resource) {
		documentModel = new DocumentModel(model, resource, annotationModel, this, this);
		documentModel.initializeFromModel();
		try {
			doReplace(0, get().length(), documentModel.getText());
		} catch (BadLocationException ex) {
			throw new RuntimeException(ex);
		}
		documentModel.reconcile();
		this.changed = false;					
	}	
	
	public void setInitialTextContext(IModel model, Object resourceId, String text) {
		documentModel = new DocumentModel(model, resourceId, annotationModel, this, this);
		documentModel.initializeFromText(text);
		try {
			doReplace(0, get().length(), text);
		} catch (BadLocationException ex) {
			throw new RuntimeException(ex);			
		}
		documentModel.reconcile();
		this.changed = true;
	}
	
	public void setInitialModel(IModel model, Object resource) {
		documentModel = new DocumentModel(model, resource, annotationModel, this, this);		
	}
	
	@Override
	public void set(String text) {
		super.set(text);
		documentModel.initializeFromModel();
		try {
			doReplace(0, get().length(), documentModel.getText());
		} catch (BadLocationException ex) {
			throw new RuntimeException(ex);
		}
		documentModel.reconcile();
		this.changed = false;
	}

	synchronized public void setModelContent(ASTElementNode tree, IModelElement model) {
		changed = tree == null;
		documentModel.update(tree, model);
	}
	
	protected abstract Template createTopLevelTemplate(IAnnotationModelProvider annotationProvider);
	
	public final Template getTopLevelTemplate() {
		if (topLevelTemplate == null) {
			topLevelTemplate = createTopLevelTemplate(null);
		}
		return topLevelTemplate;
	}
	
	public boolean needsReconciling() {
		return changed;
	}
	
	synchronized public Map<Annotation, Position> createNewOccurenceAnnotations(ISourceViewer viewer) {										
		int cursorPosition = viewer.getTextWidget().getCaretOffset();			
		IChildSelector<ASTElementNode> selector = new IndexASTSelector(cursorPosition, 0);		
		ASTElementNode selectedTreeNode = null; 

		try {
			selectedTreeNode = TreeIterator.select(selector, documentModel.getTreeRepresentation());
		} catch (RuntimeException ex) {
			// This might fail for a newly opened or created text document
			return new HashMap<Annotation, Position>();
		}
		
		IModelElement modelElement = null;		
		IASTElement selectedTreeContents = selectedTreeNode.getElement();
		Template template = null;
		if (selectedTreeContents instanceof ModelASTElement) {
			modelElement = ((ModelASTElement)selectedTreeContents).getModelElement();
			template = selectedTreeContents.getTemplate();
		}
		
		Map<Annotation, Position> result = new HashMap<Annotation, Position>();
		if (modelElement != null && template.getAdapter(IPresentationOptionsProvider.class)
						.markOccurences(selectedTreeNode, cursorPosition - selectedTreeNode.getAbsoluteOffset(0))) {
			Collection<Position> positions = documentModel.getOccurences(modelElement);
			for (Position position : positions) {
				result.put(new Annotation("hub.sam.tef.occurence", false, null),position);
			}
			return result;
		} else {
			return result;
		}		
	}

	protected abstract AbstractLayoutManager createLayout();
	
	public final AbstractLayoutManager getLayout() {
		if (layout == null) {
			layout = createLayout();
		}
		return layout;
	}
	
	private Collection<ICompletionComputer> completionsCache = null;
	/**
	 * This method collects all the completions defined by the templates of the provided language.
	 * 
	 * At the moment, concrete language provider simply return a list of the completions. This is wrong. 
	 * This should be final. TODO cache
	 */
	public Collection<ICompletionComputer> getCompletions() {
		//if (completionsCache == null) {		
			completionsCache = new ArrayList<ICompletionComputer>();
			for (Template tpl: Template.collectTemplates(getTopLevelTemplate())) {
				if (tpl instanceof ElementTemplate) {
					completionsCache.addAll(((ElementTemplate)tpl).getCompletions());
				}
			}
		//}
		return completionsCache;
	}

	public void dispose() {
		documentModel.dispose();
	}

	/**
	 * A checker is only optional.
	 */
	public IChecker getChecker() {
		return null;
	}	
	
	private final static IIdentifierResolver emptyResolver = new IIdentifierResolver() {
		public void addToEnvironment(IModelElement element) {				
		}

		public void removeFromEnvironment(IModelElement element) {				
		}

		public IModelElement resolveIdentifier(IModel model, ASTElementNode node, IModelElement context, IModelElement topLevelElement, IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {			
			throw new CouldNotResolveIdentifierException("name resolution not implemented");
		}			
	};
	
	/**
	 * A identifier resolver is optional
	 */
	public IIdentifierResolver getIdentityResolver() {
		return emptyResolver;
	}

}
