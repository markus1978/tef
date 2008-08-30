package hub.sam.tef.editor.popup;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.editor.model.ModelEditor;
import hub.sam.tef.editor.popup.AbstractOpenPopupEditor.Closer;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.tsl.TslException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * This TEF editor type is used for small pop-up windows with text editors for
 * partial models. This editors pop-up within other editors, like the standard
 * EMF generated tree-based model editors.
 */
public abstract class PopupEditor extends ModelEditor implements IPopupEditor {	

	private Closer fPopupCloser = null;
	private IEditingDomainProvider fEditingDomainProvider = null;
	private EObject editedObject = null;
	private EObject fOriginalObject = null;
	
	/**
	 * We store all adaptors of the edited objects container, and delete them
	 * temporarily. This allows to change the model during textual editing, without
	 * the host editor noticing. After editing we restore the adaptors.
	 */
	private EList<Adapter> adapters = null;
	private EObject adapterContainer = null;
		
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

	public static final String CLOSE_POPUP_EDITOR_ACTION_ID = "hub.sam.tef.closePopupEditor";

	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {		
		super.editorContextMenuAboutToShow(menu);
		addAction(menu, TEF_CONTEXT_MENU_GROUP, 
				ClosePopupEditorAction.ACTION_DEFINITION_ID);
		
	}

	@Override
	protected void createActions() {
		super.createActions();		
		setAction(ClosePopupEditorAction.ACTION_DEFINITION_ID, 
				new ClosePopupEditorAction(this));
	}
	
	/**
	 * Is used when the user accepts the editor changes and wants to close the
	 * editor. This will either replace the edited object with the original one
	 * (non store, error cases), or will create a command that replaces the
	 * original with the edited object.
	 */
	public void close(boolean store) {
		EditingDomain editingDomain = 
			fEditingDomainProvider.getEditingDomain();
		
		if (adapterContainer != null) {
			for (Adapter adapter: adapters) {
				adapterContainer.eAdapters().add(adapter);
			}
		}
		
		if (!store || hasError()) {		
			undoReplace();
		} else {
			EObject newObject = editedObject;					
			// now use a command to replace the original object with the edited					
			Command command = 
					PopupEditingReplaceCommand.create(editingDomain, fOriginalObject, newObject,
							lastReplaceCommand, lastResolveCommand);
			undoReplace();
			if (!command.canExecute()) {
				TEFPlugin.getDefault().getLog().log(
						new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
								"Cannot save pop-up editor result! Cannot execute: " + 
								command.getDescription()));
				MessageDialog.openError(getSite().getShell(), "Cannot save pop-up editor result!", 
				"Cannot save pop-up editor result! Cannot execute: " + command.getDescription());
			}
			editingDomain.getCommandStack().execute(command);						
		}
		fPopupCloser.close();
	}
	
	public void setEditingDomainProvider(IEditingDomainProvider editingDomainProvider) {
		this.fEditingDomainProvider = editingDomainProvider;
	}
	
	public void setCloser(Closer closer) {
		this.fPopupCloser = closer;
	}

	/**
	 * The super-class method simply replaces the edited model with the model in
	 * this given resource. A pop-up editor only replaces the edited element
	 * with the content of the given resource. This is not done here, but
	 * directly in the used model creating context
	 * {@link this#createModelCreatingContext()}.
	 */	
	@Override
	public void updateCurrentModel(IModelCreatingContext context) {
		// emtpy		
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
	
	private Command lastReplaceCommand = null;
	private Command lastResolveCommand = null;
	
	private void undoReplace() {
		EditingDomain domain = fEditingDomainProvider.getEditingDomain();
		CommandStack commandStack = domain.getCommandStack();

		if (lastResolveCommand != null) {
			if (commandStack.getUndoCommand() == lastResolveCommand) {
				commandStack.undo();
			}					
			lastResolveCommand = null;
		}
		if (lastReplaceCommand != null) {
			if (commandStack.getUndoCommand() == lastReplaceCommand) {
				commandStack.undo();
			}
			lastReplaceCommand = null;
		}
	
	}
	
	/**
	 * Is used by pop-up editors as a basis for creating contexts (since pop-up
	 * editors do not create models for themselves) and therefore for name
	 * resolving.
	 */
	protected Resource getEditedModel() {
		return getCurrentModel();
	}

	/**
	 * Returns a model creating context that uses the edited resource directly.
	 * When the reconciliation process adds an element to the resource, it is
	 * assumed that this is the newly edited object and this implementation will
	 * replace the old edited object with this object.
	 */
	@Override
	public final IModelCreatingContext createModelCreatingContext() {		
		return new ModelCreatingContext(getMetaModelPackages(),
				getSemanticsProvider(), getEditedModel(), getCurrentText()) {
			private final Collection<Resolution> fResolutions = new ArrayList<Resolution>();
			
			@SuppressWarnings("unchecked")
			@Override
			public void addCreatedObject(EObject newObject) {
				undoReplace();
				EditingDomain domain = fEditingDomainProvider.getEditingDomain();
				CommandStack commandStack = domain.getCommandStack();									
				
		    	EObject container = fOriginalObject.eContainer();
		    	
		    	if (adapterContainer == null && container != null) {
		    		adapterContainer = container;
		    		adapters = new BasicEList();
		    		for (Adapter adapter: adapterContainer.eAdapters()) {
		    			adapters.add(adapter);
		    		}
		    		adapterContainer.eAdapters().clear();
		    	}
		    	
				EList containerList = null;		
				if (container == null) {
					containerList = fOriginalObject.eResource().getContents();				
				} else {	
					EReference containmentFeature = fOriginalObject.eContainmentFeature();	
					if (containmentFeature.isMany()) {
						containerList = (EList)container.eGet(containmentFeature);
					} else { 								
						lastReplaceCommand = SetCommand.create(domain, container, 
								containmentFeature, newObject);					
					}
				}
				if (containerList != null) {
					lastReplaceCommand = new ReplaceCommand(domain, 
							containerList, fOriginalObject, newObject);
				}
				commandStack.execute(lastReplaceCommand);
				
				editedObject = newObject;
			}

			@Override
			public void addResolution(Resolution resolution) {
				fResolutions.add(resolution);
			}

			@Override
			public void executeResolutions() {
				Assert.isTrue(lastResolveCommand == null);
				
				EditingDomain editingDomain = fEditingDomainProvider.getEditingDomain();
				List<Command> commands = new ArrayList<Command>();
				for (Resolution resolution: fResolutions) {
					EReference reference = resolution.getReference();					
					if (reference.isMany()) {
						commands.add(AddCommand.create(editingDomain, 
								resolution.getOwner(), 
								reference, resolution.getReferencedObject()));
					} else {
						commands.add(SetCommand.create(editingDomain, 
								resolution.getOwner(), 
								reference, resolution.getReferencedObject()));
					}
				}				
				if (commands.size() != 0) {
					lastResolveCommand = new CompoundCommand("TEF resolve references command",
							commands);
					editingDomain.getCommandStack().execute(lastResolveCommand);
				}
			}			
		};
	}	
}
