package hub.sam.tef.editor.popup;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.editor.model.ModelEditor;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.popupactions.OpenTefEditor.Closer;
import hub.sam.tef.tsl.TslException;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.TextOperationAction;

/**
 * This TEF editor type is used for small pop-up windows with text editors for
 * partial models. This editors pop-up within other editors, like the standard
 * EMF generated tree-based model editors.
 */
public abstract class PopupEditor extends ModelEditor {
	
	public static final String CLOSE_POPUP_EDITOR_ACTION_ID = "hub.sam.tef.closePopupEditor";

	private Closer fPopupCloser = null;
	private EObject editedObject = null;
	private EObject fOriginalObject = null;
		
	/**
	 * Pop-up editors do not only edit whole models, but single model elements.
	 * For this, we need specific syntaxes for all the elements that can be
	 * edited.
	 */			
	public void reduceSyntax(EClass classifier) throws TslException {
		getSyntax().reduceSyntax(classifier);
	}

	@Override
	protected void initialiseDocumentProvider() {
		setDocumentProvider(new PopupDocumentProvider(this));
	}

	@Override
	protected void createActions() {
		super.createActions();
		IAction closePopupEditor = createClosePopupEditorAction();
		closePopupEditor.setActionDefinitionId(CLOSE_POPUP_EDITOR_ACTION_ID);
		setAction(CLOSE_POPUP_EDITOR_ACTION_ID, closePopupEditor);
	}
	
	private IAction createClosePopupEditorAction() {
		ResourceBundle resourceBundle = TEFPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "Close Popup Editor", this, 
				PopupSourceViewer.CLOSE_POPUP_EDITOR_ACTION_KEY);
	}
	
	/**
	 * This creates a custom source viewer. This method might be a problem,
	 * since it does not seem to be the indent of the eclipse developers to be
	 * overrideable.
	 */
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// this may change with future eclipse versions
		fAnnotationAccess= getAnnotationAccess();
		fOverviewRuler= createOverviewRuler(getSharedColors());

		ISourceViewer viewer= new PopupSourceViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles, this);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}

	/**
	 * Is used when the user accepts the editor changes and wants to close the editor.
	 */
	public void close(boolean store) {
		if (!store || hasError()) {			
			replaceEditedObject(fOriginalObject);
		} 
		fPopupCloser.close();
	}
	
	public void configure(Closer popupCloser) {
		this.fPopupCloser = popupCloser;		
	}

	/**
	 * The super-class method simply replaces the edited model with the model in
	 * this given resource. A pop-up editor only replaces the edited element
	 * with the content of the given resource. This is not done here, but
	 * directly in the used model creating context
	 * {@link this#createModelCreatingContext()}.
	 */	
	@Override
	public void updateCurrentModel(Resource resource) {
		// emtpy		
	}

	/**
	 * Replaces the edited object in the edited resource. TODO make this undo-able
	 * by using the according command-stack of the host editor.
	 */
	@SuppressWarnings("unchecked")
	private void replaceEditedObject(EObject newObject) {
		EObject container = editedObject.eContainer();
		EList containerList = null;
		if (container == null) {
			containerList = fResource.getContents();
		} else {
			EReference containmentFeature = editedObject.eContainmentFeature();
			if (containmentFeature.isMany()) {
				containerList = (EList)container.eGet(containmentFeature);						
			} else {
				container.eSet(containmentFeature, newObject);
			}
		}
		if (containerList != null) {
			int index = containerList.indexOf(editedObject);
			containerList.set(index, newObject);
		}
		editedObject = newObject;
	}
	
	/**
	 * Configures this editor with the editedObject. Can only be called once in
	 * the life-cycle of an pop-up editor.
	 */
	protected void setEditedObject(EObject editedObject) {
		Assert.isTrue(this.editedObject == null);
		this.editedObject = editedObject;
		this.fOriginalObject = editedObject;
	}

	/**
	 * Returns a model creating context that uses the edited resource directly.
	 * When the reconciliation process adds an element to the resource, it is
	 * assumed that this is the newly edited object and this implementation will
	 * replace the old edited object with this object.
	 */
	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new ModelCreatingContext(getMetaModelPackages(),
				getSemanticsProvider(), fResource, getCurrentText()) {
			@Override
			public void addCreatedObject(EObject object) {
				replaceEditedObject(object);
			}

		};
	}
	
	
}
