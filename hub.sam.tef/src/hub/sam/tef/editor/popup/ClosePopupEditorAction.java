package hub.sam.tef.editor.popup;

import hub.sam.tef.TEFPlugin;

import org.eclipse.ui.texteditor.ResourceAction;

public class ClosePopupEditorAction extends ResourceAction {

	private IPopupEditor fEditor = null;
	
	/**
	 * This is used to connect the action with all the strings in the messages
	 * properties file of the TEF plug-in.
	 */
	public final static String MESSAGE_KEYS_PREFIX = "ClosePopupEditorAction.";
	/**
	 * This is used to connect the action with the command defined as extension
	 * point in this plug/in.
	 */
	public final static String ACTION_DEFINITION_ID = "hub.sam.tef.ClosePopupEditor";
		
	public ClosePopupEditorAction(IPopupEditor editor) {
		super(TEFPlugin.getMessagesBundle(), MESSAGE_KEYS_PREFIX);
		this.fEditor = editor;
		setActionDefinitionId(ACTION_DEFINITION_ID);
	}

	@Override
	public void run() {
		fEditor.close(true);
	}
}
