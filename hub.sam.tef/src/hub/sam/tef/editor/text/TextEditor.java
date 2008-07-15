package hub.sam.tef.editor.text;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.IIdentificationScheme;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.util.MultiMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.framework.Bundle;

/**
 * An abstract editor class for TEF text editors. This is an extension to normal
 * eclipse decorated text editors. This class provides source viewer
 * configuration and document provider based on configuration provided by
 * clients. Clients have to implement some call back methods to configure the
 * editor.
 * <p>
 * Clients can configure the following information about the used language:
 * <ul>
 * <li>meta-model packages; {@link #createMetaModelPackages()}</li>
 * <li>syntax; {@link #createSyntax()}</li>
 * <li>semantics provider; {@link #createSemanticsProvider()}</li>
 * <li>model creating context; {@link #createModelCreatingContext()}</li>
 * <li>item provider adapter factories for the outline view;
 * {@link #createItemProviderAdapterFactories()}</li>
 * </ul>
 * <p>
 * The editor provides the following information about the edited text:
 * <ul>
 * <li>annotations, including error status about the edited model</li>
 * <li>the current model</li>
 * <li>the current text</li>
 * <li>outline page, outline viewer for the outline view</li>
 * </ul>
 */
public abstract class TextEditor extends org.eclipse.ui.editors.text.TextEditor {
		
	/**
	 * The ID of the editors context menu.
	 */
	public static final String EDITOR_CONTEXT = "hub.sam.tef.editor.context"; 
	
	/**
	 * The context menu path for TEF functionality additions
	 */
	public static final String TEF_CONTEXT_MENU_GROUP = "TEF additions";
	
	private final ComposedAdapterFactory fAdapterFactory;	
	private final EPackage[] fMetaModelPackages;
	private final ISemanticsProvider fSemanitcsProvider;
	private Syntax fSyntax = null;
	private final IIdentificationScheme fIdentificationScheme;
	
	private IContentOutlinePage fContentOutlinePage = null;
	private TreeViewer fContentOutlineViewer = null;
	private final Collection<Annotation> fAnnotations = new ArrayList<Annotation>();	
	protected ResourceSet fResourceSet = new ResourceSetImpl();
	private final Map<EObject, Position> fObjectPositions = new HashMap<EObject, Position>();
	private MultiMap<EObject, Position> occurences = new MultiMap<EObject, Position>(); 
	
	private IModelCreatingContext lastModelCreatingContext = null;
	
	private FormatAction fFormatAction = null;
	
	private final Collection<ITefEditorStatusListener> fStatusListener = 
			new ArrayList<ITefEditorStatusListener>();
	
	/**
	 * @return all the packages that contain all used meta-model elements of the
	 *         models edited with this editor.
	 */
	public final EPackage[] getMetaModelPackages() {
		return fMetaModelPackages;
	}
	
	/**
	 * @return A newly create array with all the packages that contain all used
	 *         meta-model elements of the models edited with this editor.
	 */
	protected abstract EPackage[] createMetaModelPackages();
	
	/**
	 * @return a path relative to the syntax definition for this editor. The
	 *         path has to be relative to the bundle of this editor:
	 *         {@link #getPluginBundle()}.
	 */
	protected abstract String getSyntaxPath();	
	
	/**
	 * @return the bundle that contains all the files, like syntax definitions,
	 *         for this editor.
	 */
	protected abstract Bundle getPluginBundle();
		
	/**
	 * @return item provider adapter factories for the according meta-model
	 *         element. These factories including the actual providers that
	 *         these factories create can be generated using the EMF framework
	 *         and are part of the generated edit-projects. They provide the
	 *         look and feel of the objects displayed in the outline view.
	 */
	protected abstract AdapterFactory[] createItemProviderAdapterFactories();
	
	/**
	 * @return the syntax used by this editor. Overwrite either this method or
	 *         use {@link this#getPlatformURIOfSyntax()}. If the syntax for
	 *         this document is not already set, this implementation loads the
	 *         syntax given by {@link this#getPlatformURIOfSyntax()}. The
	 *         return syntax description must contain the real meta-elements for its
	 *         binding and must contain all the implicit type rules for primitive
	 *         types (TODO). 
	 */
	public final Syntax getSyntax() {
		if (fSyntax == null) {
			try {
				fSyntax = createSyntax();
			} catch (TslException e) {
				throw new RuntimeException(e);
			}
		}
		return fSyntax;
	}
	
	/**
	 * @return the newly created/loaded syntax for this editor.
	 */
	protected Syntax createSyntax() throws TslException {
		Bundle bundle = getPluginBundle();
		if (bundle == null) {
			bundle = TEFPlugin.getDefault().getBundle();
		}
		return Utilities.loadSyntaxDescription(
				bundle,
				getSyntaxPath(), 
				getMetaModelPackages());		
	}
	
	/**
	 * @return the semantics that his editor uses. A semantics is used to
	 *         complement the syntax description. It basically describes how the
	 *         syntax is connect to the meta-model and how other non-syntax
	 *         features of the editor behave (code-completion, semantical
	 *         highlighting, etc.). Overwrite to provide your own semantics.
	 */
	public final ISemanticsProvider getSemanticsProvider() {
		return fSemanitcsProvider;
	}
	
	/**
	 * Overwrite to create a custom semantics. Also allows to create the
	 * {@link DefaultSemanitcsProvider} with a different
	 * {@link IIdentificationScheme}.
	 * 
	 * @return a newly created semantics provider for this editor.
	 */
	protected ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanitcsProvider(getIdentificationScheme());
	}
	
	private IIdentificationScheme getIdentificationScheme() {
		return fIdentificationScheme;
	}

	protected IIdentificationScheme createIdentificationScheme() {
		return DefaultIdentificationScheme.INSTANCE;
	}
	
	/**
	 * Allows to use your own model creating context. The idea is that you
	 * extend the existing model creating context and provide additional
	 * adapters that you can use for realizing specific language semantics. One
	 * example is the storage of name-tables in a model creating context.
	 * 
	 * @return a newly creating model creating context.
	 */
	public IModelCreatingContext createModelCreatingContext() {
		return new ModelCreatingContext(
				getMetaModelPackages(), getSemanticsProvider(), 
				new ResourceImpl(), getCurrentText());
	}
	
	/**
	 * @return the list of annotation currently registered to the annotation model
	 * of the source-viewer showing this document.
	 */
	public Collection<Annotation> getAnnotations() {		
		return fAnnotations;
	}
			
	/**
	 * @return a resource that contains the model from the last successful
	 *         reconciliation.
	 */
	public Resource getCurrentModel() {
		EList<Resource> resources = fResourceSet.getResources();
		if (resources.size() > 0) {
			return this.fResourceSet.getResources().get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * @return the current text edited in this editor.
	 */
	public String getCurrentText() {
		return getSourceViewer().getDocument().get();
	}
	
	/**
	 * Deletes the old (last) model creating context and all its constituents. This
	 * should be used before a new model creating context is set.
	 */
	private void clearModelCreatingContext() {
		if (lastModelCreatingContext != null) {
			lastModelCreatingContext.destroy();
		}
	}
	
	/**
	 * Allows reconciliation to update this editor with a newly created model.
	 * It will also update the content outline view contents.
	 * 
	 * @param resource
	 *            is a resource that contains the model.
	 */
	public void updateCurrentModel(final IModelCreatingContext context) {			
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {	
			public void run() {
				TreePath[] expandState = null; 
				if (fContentOutlineViewer != null) {
					expandState = fContentOutlineViewer.getExpandedTreePaths();
				}
				
				occurences = context.getOccurences();				
				fObjectPositions.clear();		
				if (context.getResource().getContents().size() != 0) {
					clearModelCreatingContext();
					lastModelCreatingContext = context;			
				} else {
					return;
				}

				EList<Resource> resources = fResourceSet.getResources();
				final Resource contextResource = context.getResource();
				Resource storeResource = null; 
				
				// update the current model
				if (resources.size() > 0) {
					storeResource = resources.get(0);
					if (storeResource != contextResource) {												
						resources.remove(storeResource);						
						resources.add(contextResource);	
						storeResource.setURI(URI.createURI("dontcare"));
						storeResource.unload();								
						storeResource = contextResource;						
					}
				} else { 							
					resources.add(contextResource);
					storeResource = contextResource;
				}
				
								
				// update object positions
				TreeIterator<EObject> allContents = resources.get(0).getAllContents();
				while(allContents.hasNext()) {
					EObject content = allContents.next();
					ParseTreeRuleNode treeNodeForObject = context.getTreeNodeForObject(content);
					if (treeNodeForObject != null) {
						fObjectPositions.put(content, treeNodeForObject.getPosition());
					}
				}
				
				// update the outline view
			    final Resource resource = storeResource;
				if (fContentOutlineViewer != null) {
					fContentOutlineViewer.setInput(resource);
					restoreExpandState(expandState);
				}				
				fireEditorStatus();							
			}									
		});
	}
	
	/**
	 * Allows to change the text in the editor. This is used to discard the
	 * user input and replace it with a pretty printed model text.
	 */
	public void updateCurrentText(String newText) {		 
		IDocument document = getSourceViewer().getDocument();
		String oldText = document.get();
		try {
			document.replace(0, oldText.length(), newText);
		} catch (BadLocationException e) {
			Assert.isTrue(false, "supposed unreachable");
		}
	}
	
	/**
	 * Tries to find the objects in the given expand state in the current model.
	 * If an element is found, it is expanded in the content outline view.
	 * 
	 * TODO the used IDs can be very weak depending on the language. Maybe it should
	 * be either configurable what states are restored and what not, or we should
	 * restore states based on weak local IDs, or we check whether a path is unique in
	 * the model (expensive).
	 */
	private void restoreExpandState(TreePath[] expandState) {
		List<TreePath> newExpandState = new ArrayList<TreePath>();
		pathLoop: for (TreePath oldPath: expandState) {
			Object[] newPath = new Object[oldPath.getSegmentCount()];
			EList<EObject> contents = getCurrentModel().getContents();
			segmentLoop: for (int i = 0; i < oldPath.getSegmentCount(); i++) {
				Object oldPathElement = oldPath.getSegment(i);
				for (EObject content: contents) {
					IIdentificationScheme identificationScheme = getIdentificationScheme();
					if (identificationScheme.getIdentitiy(content).equals(
							identificationScheme.getIdentitiy((EObject)oldPathElement))) {
						newPath[i] = content;
						contents = content.eContents();
						continue segmentLoop;
					}
				}
				continue pathLoop;
			}
			newExpandState.add(new TreePath(newPath));
		}
		fContentOutlineViewer.setExpandedTreePaths(newExpandState.toArray(new TreePath[] {}));
	}

	/**
	 * Configures this editor. It sets an appropriate document provider and
	 * source viewer configuration based on the implementation of
	 * {@link this#createMetaModelPackages(), this#createSyntax(),
	 * this#createSemanticsProvider()}.
	 */
	public TextEditor() {
		super();		
		fIdentificationScheme = createIdentificationScheme();
		fSemanitcsProvider = createSemanticsProvider();
		fMetaModelPackages = createMetaModelPackages();
		fAdapterFactory = createComposedAdapterFactory();		
		setSourceViewerConfiguration(createSourceViewerConfiguration());		
	}
	
	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new SourceViewerConfiguration(this);
	}
	
	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
	}
	
	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(new String[] { "hub.sam.tef.context" }); 
	}
	
	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {
		menu.add(new Separator(TEF_CONTEXT_MENU_GROUP));
		Collection<String> actionIds = new ArrayList<String>();
		addActions(actionIds);
		for (String actionId: actionIds) {
			addAction(menu, TEF_CONTEXT_MENU_GROUP, actionId);
		}
		super.editorContextMenuAboutToShow(menu);
	}
	
	protected void addActions(Collection<String> actionIds) {
		actionIds.add(FormatAction.ACTION_DEFINITION_ID);
	}
	
	/**
	 * Creates additional actions. In this implementation this is the action
	 * that triggers content assist and an action for formating the editor content.
	 */
	@Override
	protected void createActions() {	
		super.createActions();
		IAction contentAssist = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		contentAssist.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", contentAssist);	
				
		fFormatAction = new FormatAction(this);
		setAction(FormatAction.ACTION_DEFINITION_ID, fFormatAction);	
	}		
	
	/**
	 * @return the content assist action.
	 */
	protected IAction createContentAssistAction() {		
		ResourceBundle resourceBundle = TEFPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}
	
	
	/**
	 * @return a composed adapter factories created from the item provider
	 *         factories taken from
	 *         {@link this#createItemProviderAdapterFactories()} and adds
	 *         standard factories for resources and based on EMFs reflective
	 *         interface.
	 */
	private ComposedAdapterFactory getComposedAdaptorFactory() {
		return fAdapterFactory;
	}
	
	private ComposedAdapterFactory createComposedAdapterFactory() {
		ComposedAdapterFactory result = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);	
		result.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		for (AdapterFactory adapterFactory: createItemProviderAdapterFactories()) {
			result.addAdapterFactory(adapterFactory);
		}			
		result.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		return result;
	}
	
	/**
	 * Adapts to IContentOutlinePage for the outline view associated with this
	 * editor. The provided content outline page is based on the user given item
	 * provider {@link #createItemProviderAdapterFactories()} and changes the
	 * text selection when the outline view selection is changed.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapterClass) {		
		if (adapterClass == IContentOutlinePage.class) {
			if (fContentOutlinePage == null) {			
				fContentOutlinePage = new MyContentOutlinePage();
				fContentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						EObject selectedObject = (EObject) ((IStructuredSelection) event
										.getSelection()).getFirstElement();
						Position selectedObjectsPosition = 
								TextEditor.this.fObjectPositions.get(selectedObject);
						if (selectedObjectsPosition != null && !TextEditor.this.hasError()) {
							int offset = selectedObjectsPosition.getOffset();
							ISourceViewer sourceViewer = TextEditor.this.getSourceViewer();
							if (offset < sourceViewer.getDocument().get().length()) {
								sourceViewer.getTextWidget().setSelection(offset, 
										offset+selectedObjectsPosition.getLength());
							}
						}
					}
				});
			}

			return fContentOutlinePage;
		} else {
			return super.getAdapter(adapterClass);
		}
	}
	
	/**
	 * The content outline page that is used for the outline view associated
	 * with this editor. It uses its standard tree viewer and configures it with
	 * the item providers given by extending classes.
	 */	
	private class MyContentOutlinePage extends ContentOutlinePage {
		@Override
		public void createControl(Composite parent) {			
			super.createControl(parent);
			fContentOutlineViewer = getTreeViewer();
			fContentOutlineViewer.addSelectionChangedListener(this);

			// Set up the tree viewer.
			fContentOutlineViewer
					.setContentProvider(new AdapterFactoryContentProvider(
							getComposedAdaptorFactory()));
			fContentOutlineViewer
					.setLabelProvider(new AdapterFactoryLabelProvider(
							getComposedAdaptorFactory()));
			fContentOutlineViewer
					.setInput(getCurrentModel());

			if (!fResourceSet.getResources().isEmpty()) {
				// Select the root object in the view.
				fContentOutlineViewer.setSelection(new StructuredSelection(
						fResourceSet.getResources().get(0)), true);
			}
		}
	}
	
	/**
	 * Disposes all contained elements of this editor that need explicit
	 * disposal.
	 */
	@Override
	public void dispose() {
		if (fAdapterFactory != null) {
			fAdapterFactory.dispose();
		}
		if (fContentOutlinePage != null) {
			fContentOutlinePage.dispose();
		}
		if (fFormatAction != null) {
			fFormatAction.dispose();
		}
		super.dispose();
	}
	
	/**
	 * @return true if the edited model contains an error, i.e. the last
	 *         reconciliation created some error markers.
	 */
	public boolean hasError() {
		return getAnnotations().size() > 0;
	}
	
	/**
	 * Allows other to react to editor status changes. Listeners are informed
	 * about error status changes after reconciliation.
	 */
	public void addEditorStatusListener(ITefEditorStatusListener listener) {
		this.fStatusListener.add(listener);
	}
	
	/**
	 * See {@link #addEditorStatusListener(ITefEditorStatusListener)}
	 */
	public void removeEditorStatusListener(ITefEditorStatusListener listener) {
		this.fStatusListener.remove(listener);
	}
	
	/**
	 * Triggers that listeners to the editors status are informed about the
	 * current editor status.
	 */
	public void fireEditorStatus() {
		for(ITefEditorStatusListener listener: fStatusListener) {
			listener.errorStatusChanged(this);
		}
	}
	
	/**
	 * @return the model creating context that was used in the last model
	 *         creation. It still contains all the model information gathered
	 *         during model creation and this information might be useful for
	 *         other editor aspects, such as code completion.
	 */
	public IModelCreatingContext getLastModelCreatingContext() {
		return lastModelCreatingContext;
	}

	private final Collection<Annotation> occurenceAnnotations = new ArrayList<Annotation>();
	private EObject objectUnderCursor = null;
	
	/**
	 * Change the annotations to mark occurences
	 */
	@Override
	protected void handleCursorPositionChanged() {		
		super.handleCursorPositionChanged();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				ISourceViewer viewer = getSourceViewer();
				int offset = viewer.getTextWidget().getCaretOffset();
				EObject newObjectUnderCursor = null;
				loop: for (EObject object: occurences.getKeys()) {
					for (Position position: occurences.get(object)) {			
						if (position.offset <= offset && (position.offset + position.length) >= offset) {
							newObjectUnderCursor = object;
							break loop;
							
						}
					}
				}
				
				if (newObjectUnderCursor != objectUnderCursor) {
					IAnnotationModel annotations = viewer.getAnnotationModel();
					for (Annotation annotation: occurenceAnnotations) {
						annotations.removeAnnotation(annotation);
					}
					occurenceAnnotations.clear();
					if (newObjectUnderCursor != null) {
						for (Position occurencePosition: occurences.get(newObjectUnderCursor)) {
							Annotation annotation = new Annotation("hub.sam.tef.occurence", false, null);
							occurenceAnnotations.add(annotation);
							annotations.addAnnotation(annotation, occurencePosition);
						}
					}
					objectUnderCursor = newObjectUnderCursor;				
				}
			}
		});
	}		
}
