package hub.sam.tef.editor;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.util.EObjectHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
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
 * configuration and document provider configured through some call back
 * methods. These call-back methods are to be implemented/overwritten by
 * inheriting clients.
 * <p>
 * An editor provides the following information about the used language:
 * <ul>
 * 	<li>meta-model packages</li>
 *  <li>syntax</li>
 *  <li>semantics provider</li>
 *  <li>model creating context</li>
 *  <li>item provider adapter factories for the outline view</li>
 * </ul>
 * <p>
 * The editor provides the following information about the edited text:
 * <ul>
 *  <li>annotations</li>
 *  <li>current-model</li>
 *  <li>outline page, outline viewer for the outline view</li>
 * </ul>
 */
public abstract class TextEditor extends org.eclipse.ui.editors.text.TextEditor {

	private final ComposedAdapterFactory fAdapterFactory;	
	private final EPackage[] fMetaModelPackages;
	private final ISemanticsProvider fSemanitcsProvider;
	private Syntax fSyntax = null;
	
	private IContentOutlinePage fContentOutlinePage = null;
	private TreeViewer fContentOutlineViewer = null;
	private final Collection<Annotation> fAnnotations = new ArrayList<Annotation>();	
	private final ResourceSet fResourceSet = new ResourceSetImpl();	
	
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
	 * @return a newly created semantics provider for this editor.
	 */
	protected ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanitcsProvider();
	}
	
	/**
	 * Allows to use your own model creating context. The idea is that you
	 * extend the existing model creating context and provide additional
	 * adapters that you can use for realizing specific language semantics. One
	 * example is the storage of name-tables in a model creating context.
	 * 
	 * @return a newly creating model creating context.
	 */
	public ModelCreatingContext createModelCreatingContext() {
		return new ModelCreatingContext(getMetaModelPackages(), getSemanticsProvider());
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
	 * Allows reconciliation to updates this editor with a newly created model.
	 * It will also update the content outline view contents.
	 * 
	 * @param resource
	 *            is a resource that contains the model.
	 */
	protected void updateCurrentModel(final Resource resource) {
		EList<Resource> resources = fResourceSet.getResources();
		if (resources.size() > 0) {			
			resources.set(0, resource);
		} else {			
			resources.add(resource);
		}
		if (fContentOutlineViewer != null) {
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {	
				public void run() {
					TreePath[] expandState = fContentOutlineViewer.getExpandedTreePaths();					
					fContentOutlineViewer.setInput(resource);	
					restoreExpandState(expandState);
				}
			});
		}
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
					if (EObjectHelper.getLocalId(content).equals(
							EObjectHelper.getLocalId((EObject)oldPathElement))) {
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
		fSemanitcsProvider = createSemanticsProvider();
		fMetaModelPackages = createMetaModelPackages();
		fAdapterFactory = createComposedAdapterFactory();
		try {
			fSyntax = createSyntax();
		} catch (TslException e) {
			throw new RuntimeException(e);
		} 
		setSourceViewerConfiguration(new SourceViewerConfiguration(this));
	}
	
	/**
	 * Creates additional actions. In this implementation this is the action
	 * that triggers content assist.
	 */
	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);		
	}		
	
	/**
	 * @return the content assist action.
	 */
	private IAction createContentAssistAction() {		
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
	 * Adapts to IContentOutlinePage for the outline view associated with this editor.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapterClass) {
		if (adapterClass == IContentOutlinePage.class) {
			if (fContentOutlinePage == null) {			
				fContentOutlinePage = new MyContentOutlinePage();
				fContentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						// TODO what do we do if the selection is changed in the outline
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
		super.dispose();
	}
}
